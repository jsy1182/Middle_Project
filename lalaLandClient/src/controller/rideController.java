package controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.IRideService;
import service.IZooService;
import vo.RideVO;

public class rideController {
	IRideService service;
	List<String> data = new ArrayList<>();
	ObservableList<String> list ;
	String text;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

  
    @FXML
    private Slider scrollbar_height;

    @FXML
    private ComboBox<String> combo_ride;

    @FXML
    private TextArea textarea_explain;

    @FXML
    private Label label_height;

    @FXML
    private Button btn_parade;

    @FXML
    private Label label_date;

    @FXML
    private Label label_number;

    @FXML
    private Label label_level;

    @FXML
    private Label label_limit;

    @FXML
    private Label label_ok;

    @FXML
    private Label albel_rideName;
    
    @FXML
    private ImageView img_map1;
    
    @FXML
    private Button btn_search;
    
    @FXML
    void hover(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/맵1.png") ;
    	img_map1.setImage(img);

    }

    @FXML
    void hover1(MouseEvent event) {
    	String style="-fx-border-width:3px; -fx-border-color: #ffcc00; -fx-background-color: #FAFABE;";
    	btn_parade.setStyle(style);
    }

    @FXML
    void hoverOut(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/맵.png") ;
    	img_map1.setImage(img);
    }

    @FXML
    void hoverOut1(MouseEvent event) {
    	String style="-fx-border-width:3px; -fx-border-color: #ffcc00; -fx-background-color: #ffffff;";
    	btn_parade.setStyle(style);
    }

    @FXML
    void action_parade(ActionEvent event) {
    	// parade팝업창 띄우기
    	Stage stage = new Stage();
    	Stage mainStage = (Stage)label_level.getScene().getWindow();
    	stage.initOwner(mainStage);
    	stage.initModality(Modality.WINDOW_MODAL);
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/parade.fxml"));
    	
    	try {
			Parent child = loader.load();
			Scene scene = new Scene(child);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    } 

    @FXML
    void action_search(ActionEvent event) {
    	// 스크롤바 값에 따라 콤보박스 리스트 변경
    	List<String> data2 = new ArrayList<>();
    	ObservableList<String> list2 ;
    	try {
			 data2 = service.getComboListRide(Integer.parseInt(label_height.getText()));
			 list2 = FXCollections.observableArrayList(data2);
			 combo_ride.setItems(list2);
			 combo_ride.getSelectionModel().selectFirst();

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
    }

  
    @FXML
    void initialize() {
    	assert albel_rideName != null : "fx:id=\"albel_rideName\" was not injected: check your FXML file 'RideScene.fxml'.";
        assert scrollbar_height != null : "fx:id=\"scrollbar_height\" was not injected: check your FXML file 'RideScene.fxml'.";
        assert combo_ride != null : "fx:id=\"combo_ride\" was not injected: check your FXML file 'RideScene.fxml'.";
        assert textarea_explain != null : "fx:id=\"textarea_explain\" was not injected: check your FXML file 'RideScene.fxml'.";
        assert label_height != null : "fx:id=\"label_height\" was not injected: check your FXML file 'RideScene.fxml'.";
        assert btn_parade != null : "fx:id=\"btn_parade\" was not injected: check your FXML file 'RideScene.fxml'.";
        assert label_date != null : "fx:id=\"label_date\" was not injected: check your FXML file 'RideScene.fxml'.";
        assert label_number != null : "fx:id=\"label_number\" was not injected: check your FXML file 'RideScene.fxml'.";
        assert label_level != null : "fx:id=\"label_level\" was not injected: check your FXML file 'RideScene.fxml'.";
        assert label_limit != null : "fx:id=\"label_limit\" was not injected: check your FXML file 'RideScene.fxml'.";
        assert label_ok != null : "fx:id=\"label_ok\" was not injected: check your FXML file 'RideScene.fxml'.";
        assert img_map1 != null : "fx:id=\"img_map1\" was not injected: check your FXML file 'RideScene.fxml'.";
        assert btn_search != null : "fx:id=\"btn_search\" was not injected: check your FXML file 'RideScene.fxml'.";
        
        Registry reg;
		try {
			reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IRideService) reg.lookup("ride");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		

		final Font font = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 17);
		albel_rideName.setFont(font);
		
		// 놀이기구 이름 콤보박스에 담기
		try {
			 data = service.getComboListRide(0);
			 list = FXCollections.observableArrayList(data);
			 combo_ride.setItems(list);
			 combo_ride.getSelectionModel().selectFirst();

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		// 이름과 설명 처음값
		albel_rideName.setText(combo_ride.getSelectionModel().getSelectedItem().toString());
			try {
				textarea_explain.setText(service.getRideExplain(albel_rideName.getText()));
			} catch (RemoteException e2) {
				e2.printStackTrace(); 
			}
				
		// textarea에 놀이기구 설명 출력
		combo_ride.setOnAction(e->{
			if(combo_ride.getSelectionModel().getSelectedItem()!=null) {
				List<RideVO> ridelist;
				albel_rideName.setText(combo_ride.getSelectionModel().getSelectedItem().toString());
				String ride_name = combo_ride.getSelectionModel().getSelectedItem().toString();
				
				try {
					text = service.getRideExplain(ride_name);
					textarea_explain.setText(text);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				

				try {
					ridelist = service.getRideInfo(albel_rideName.getText());
					String level="";
					for(RideVO vo : ridelist) {
						label_date.setText(vo.getRide_date());
				        label_number.setText(vo.getRide_max()+"");
				        for(int i=0; i<vo.getRide_diff(); i++) {
				        	level += " * ";
				        }
				        label_level.setText(level);
				        label_limit.setText(vo.getRide_height()+"cm");
				        label_ok.setText(vo.getRide_iden()); 
					}
					
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		// 스크롤바로 키 정하기
		scrollbar_height.setOnMouseDragged(e->{
			label_height.setText((int)scrollbar_height.getValue()+"");
		});
		scrollbar_height.setOnMouseClicked(e->{
			label_height.setText((int)scrollbar_height.getValue()+"");
		});
		
		//놀이기구 건설날짜, 최대 탑승인원, 난이도, 제한 키, 운행여부 가져오기
		List<RideVO> ridelist;
		try {
			ridelist = service.getRideInfo(albel_rideName.getText());
			for(RideVO vo : ridelist) {
				String level="";
				label_date.setText(vo.getRide_date());
		        label_number.setText(vo.getRide_max()+"");
		        for(int i=0; i<vo.getRide_diff(); i++) {
		        	level += " * ";
		        }
		        label_level.setText(level);
		        label_limit.setText(vo.getRide_height()+"cm");
		        label_ok.setText(vo.getRide_iden()); 
			}
			
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} 
		
		img_map1.setOnMouseClicked(e->{
			Stage stage= new Stage();
	    	Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("/map/map.fxml"));
				stage.setTitle("놀이동산 지도");
				stage.setScene(new Scene(root));
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.show();
			}catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
    }
}
