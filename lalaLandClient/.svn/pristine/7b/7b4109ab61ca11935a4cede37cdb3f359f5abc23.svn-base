package controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import service.IReserveService;
import vo.MemberVO;
import vo.ReserveVO;
import vo.RideVO;


public class reserve2Controller {
	IReserveService service;
	ObservableList<ReserveVO> data;
	ReserveVO vo = null;
	ReserveVO rvo = null;
	MemberVO member ;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<ReserveVO> table_1;

    @FXML
    private TableColumn<?, ?> tb_id;

    @FXML
    private TableColumn<?, ?> tb_time;

    @FXML
    private TableColumn<?, ?> tb_ride;

    @FXML
    private Label label_ride;

    @FXML
    private Label label_time;
    
    @FXML
    private Label font1;

    @FXML
    private Label font2;

    @FXML
    private Label font3;

    @FXML
    private Label font4;

    @FXML
    private Label font5;

    @FXML
    private Label font6;
    
    @FXML
    private ImageView img_reserve;
    
    @FXML
    void hover(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/envelope1.png") ;
    	img_reserve.setImage(img);
    }

    @FXML
    void hoverOut(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/envelope.png") ;
    	img_reserve.setImage(img);
    }

    @FXML
    void action_img_reserve(MouseEvent event) {

    	/**
		 * 2018/11/23 강혜민
		 * 예약시 아무것도 선택안했을 때 수정 
		 * 
		 */
		if(label_ride.getText().length() == 0 || label_time.getText().length() == 0) {
			alert("선택오류", "삭제하실 예약정보를 선택해주세요."); 
			Optional<ButtonType> result2 = alert.showAndWait();
			return;
		}
    }



    public void getReserve() {
    	List<ReserveVO> reservelist;
		try {
			int currentTime = 0;
			DateFormat dateFormat = new SimpleDateFormat("HH");
			Calendar cal = Calendar.getInstance();
			currentTime = Integer.parseInt(dateFormat.format(cal.getTime()));
			System.out.println(currentTime);
			if(currentTime == 22) {
				int cnt = service.deleteAll(member.getMem_id());
			}
			reservelist = service.getAllReserve(member.getMem_id());
			
			data = FXCollections.observableArrayList(reservelist);
			table_1.setItems(data);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void initialize() {
        assert table_1 != null : "fx:id=\"table_1\" was not injected: check your FXML file 'reserveScene2.fxml'.";
        assert tb_id != null : "fx:id=\"tb_id\" was not injected: check your FXML file 'reserveScene2.fxml'.";
        assert tb_time != null : "fx:id=\"tb_time\" was not injected: check your FXML file 'reserveScene2.fxml'.";
        assert tb_ride != null : "fx:id=\"tb_ride\" was not injected: check your FXML file 'reserveScene2.fxml'.";
        assert label_ride != null : "fx:id=\"label_ride\" was not injected: check your FXML file 'reserveScene2.fxml'.";
        assert label_time != null : "fx:id=\"label_time\" was not injected: check your FXML file 'reserveScene2.fxml'.";
        assert font1 != null : "fx:id=\"font1\" was not injected: check your FXML file 'reserveScene2.fxml'.";
        assert font2 != null : "fx:id=\"font2\" was not injected: check your FXML file 'reserveScene2.fxml'.";
        assert font3 != null : "fx:id=\"font3\" was not injected: check your FXML file 'reserveScene2.fxml'.";
        assert font4 != null : "fx:id=\"font4\" was not injected: check your FXML file 'reserveScene2.fxml'.";
        assert font5 != null : "fx:id=\"font5\" was not injected: check your FXML file 'reserveScene2.fxml'.";
        assert font6 != null : "fx:id=\"font6\" was not injected: check your FXML file 'reserveScene2.fxml'.";
        assert img_reserve != null : "fx:id=\"img_reserve\" was not injected: check your FXML file 'reserveScene2.fxml'.";

        Registry reg;
		try {
			reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IReserveService) reg.lookup("reserve");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		final Font font = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 13);
		final Font Rfont = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 18);
		font1.setFont(Rfont);
		font2.setFont(font);
		font3.setFont(font);
		font4.setFont(font);
		font5.setFont(font);
		font6.setFont(font);
	
		
		// 테이블 정보 가져오기 (reserveVO)
		member = CurrentLoginPerson.CurrentMember;
		getReserve();
		tb_id.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
		tb_ride.setCellValueFactory(new PropertyValueFactory<>("ride_name"));
		tb_time.setCellValueFactory(new PropertyValueFactory<>("res_time"));
		
			
		// 테이블 삭제하기 
		table_1.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				img_reserve.setOnMouseClicked(e->{
					int currentTime = 0;
					int reserveTime = 0;
					int cnt = 0;
					String ride_id = null;
					String res_time = table_1.getSelectionModel().getSelectedItem().getRes_time();
					String ride_name = table_1.getSelectionModel().getSelectedItem().getRide_name();
					DateFormat dateFormat = new SimpleDateFormat("HH");
					Calendar cal = Calendar.getInstance();
					currentTime = Integer.parseInt(dateFormat.format(cal.getTime()));
					reserveTime = Integer.parseInt(res_time.substring(0, 2));
					try {
						ride_id = service.getSelectRideId(ride_name);
						
						if(currentTime >= reserveTime) {
							alert("예약취소불가", "이미 지나간 시간이므로 취소가 불가합니다.");
							Optional<ButtonType> result2 = alert.showAndWait();
							return;
							
						}
						rvo = new ReserveVO();
						rvo.setMem_id(member.getMem_id());
						rvo.setRes_time(res_time);
						rvo.setRide_id(ride_id);
						
						cnt = service.deleteReserve(rvo);
						if(cnt>0) {
							alert2("예약 취소", "예약이 취소되었습니다.");
							Optional<ButtonType> result = alert2.showAndWait();
							getReserve();
							// table다시 불러오기
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					
				}); // setOnAction
			}// handle()
		});// setOnMouse
   }
    Alert alert;
    public void alert (String header,String msg) {
      alert=new Alert(AlertType.WARNING);
      
      alert.setTitle("예약취소불가");
      alert.setHeaderText(header);
      alert.setContentText(msg);
   }//end of alert
    
    Alert alert2;
    public void alert2 (String header,String msg) {
      alert2=new Alert(AlertType.CONFIRMATION);
      
      alert2.setTitle("확인");
      alert2.setHeaderText(header);
      alert2.setContentText(msg);
   }//end of alert
    
}


