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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.IZooService;
import vo.AnimalVO;
import vo.FarmVO;

public class zoo_SafariController {
	IZooService service;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button label_animalName;

    @FXML
    private ComboBox<String> combo_farm;

    @FXML
    private Button btn_back;

    @FXML
    private TextArea animal_explain;

    @FXML
    private ImageView img_4;

    @FXML
    private ImageView img_3;

    @FXML
    private ImageView img_2;

    @FXML
    private ImageView img_1;
    

    @FXML
    private ImageView img_map;

    @FXML
    private ImageView img_next;
    

    @FXML
    private ImageView img_back;




  
    @FXML
    void actionBack(ActionEvent event) {
    	try {
			Parent zooScene = FXMLLoader.load(getClass().getResource("/UI/zooScene.fxml")); 
			Stage primaryStage = (Stage)btn_back.getScene().getWindow();
			anchorPane.getChildren().setAll(zooScene);

//			Scene scene = new Scene(zooScene);
//			primaryStage.setTitle("zoo");
//			primaryStage.setScene(scene);
//			primaryStage.show();
			
			//Scene scene = new Scene(root);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }


    List<String> data = new ArrayList<>();
    ObservableList<String> list ;
    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'zooScene.fxml'.";
        assert label_animalName != null : "fx:id=\"label_animalName\" was not injected: check your FXML file 'zooScene2.fxml'.";
        assert combo_farm != null : "fx:id=\"combo_farm\" was not injected: check your FXML file 'zooScene2.fxml'.";
        assert btn_back != null : "fx:id=\"btn_back\" was not injected: check your FXML file 'zooScene2.fxml'.";
        assert animal_explain != null : "fx:id=\"animal_explain\" was not injected: check your FXML file 'zooScene2.fxml'.";
        assert img_4 != null : "fx:id=\"img_4\" was not injected: check your FXML file 'zooScene2.fxml'.";
        assert img_3 != null : "fx:id=\"img_3\" was not injected: check your FXML file 'zooScene2.fxml'.";
        assert img_2 != null : "fx:id=\"img_2\" was not injected: check your FXML file 'zooScene2.fxml'.";
        assert img_1 != null : "fx:id=\"img_1\" was not injected: check your FXML file 'zooScene2.fxml'.";
        assert img_map != null : "fx:id=\"img_map\" was not injected: check your FXML file 'zooScene2.fxml'.";
        assert img_next != null : "fx:id=\"img_next\" was not injected: check your FXML file 'zooScene2.fxml'.";
        assert img_back != null : "fx:id=\"img_back\" was not injected: check your FXML file 'zooScene2.fxml'.";

        animal_explain.setEditable(false);
        Registry reg;
		try {
			reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IZooService) reg.lookup("zoo");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		final Font font = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 17);
		final Font font2 = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 12);
		label_animalName.setFont(font);
		btn_back.setFont(font2);
		
		
		
		// 콤보박스 값 가져오기
		try {
			 data = service.getComboList("FR001");
			 list = FXCollections.observableArrayList(data);
			 combo_farm.setItems(list);
			 combo_farm.getSelectionModel().selectFirst();

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		// 이름과 설명 처음값
		label_animalName.setText(combo_farm.getSelectionModel().getSelectedItem().toString());
		try {
			animal_explain.setText(service.getAnimalExplain(label_animalName.getText()));
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace(); 
		}
		
		// 콤보박스 선택할때 설명변경
		combo_farm.setOnAction(e->{
			label_animalName.setText(combo_farm.getSelectionModel().getSelectedItem().toString());
			String animal_name = combo_farm.getSelectionModel().getSelectedItem().toString();
			String text;
			try {
				text = service.getAnimalExplain(animal_name);
				animal_explain.setText(text);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			
		});
		
		
		img_map.setOnMouseClicked(e->{
			Stage stage = new Stage();
	    	Stage mainStage = (Stage)img_map.getScene().getWindow();
	    	stage.initOwner(mainStage);
	    	stage.initModality(Modality.WINDOW_MODAL);
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/zooScene_map1.fxml"));
	    	
	    	try {
				Parent child = loader.load();
				Scene scene = new Scene(child);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		});
		/**
		 * 2018/11/24 강혜민
		 */
		img_back.setVisible(false);
		img_next.setOnMouseClicked(e->{
			if (img_1.isVisible() == true) {
				img_1.setVisible(false);
				img_back.setVisible(true);
			}else if(img_2.isVisible() == true) {
				img_2.setVisible(false);	
				
			}else if(img_3.isVisible() == true) {
				img_3.setVisible(false);
				img_next.setVisible(false);
			}
		});
		
		img_back.setOnMouseClicked(e->{
			if(img_3.isVisible() == false) {
				img_3.setVisible(true);
				img_next.setVisible(true);
			}else if(img_2.isVisible() == false) {
				img_2.setVisible(true);
			}else if(img_1.isVisible() == false) {
				img_1.setVisible(true);
				img_back.setVisible(false);
			}
		});
    }
}
