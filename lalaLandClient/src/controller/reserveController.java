    package controller;


import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.SynchronousQueue;

import org.apache.commons.mail.EmailException;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import service.IReserveService;
import service.IRideService;
import ua.email;
import ua.qr;
import vo.MemberVO;
import vo.ParadeVO;
import vo.ReserveVO;
import vo.RideVO;

public class reserveController {
	ReserveVO rvo;
	IReserveService service;
	ObservableList<RideVO> data;
	ObservableList<DataVo> data2;
	MemberVO member ; 
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TableView<RideVO> table_1;

    @FXML
    private TableColumn<RideVO, String> table_name;

    @FXML
    private TableView<DataVo> table_2;

    @FXML
    private TableColumn<DataVo, String> table_time;


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
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/mail1.png") ;
    	img_reserve.setImage(img);
    	
    }
    
    @FXML
    void hoverOut(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/mail.png") ;
    	img_reserve.setImage(img);
    }
    
    @FXML
    void action_img_reserve(MouseEvent event) {

    


   
    	// 예약하기
    	String ride_id = null;
    	String email1 = null;
    	rvo = new ReserveVO();
    	int cnt = 0;
    	int cnt2 = 0;
    	int cnt3 = 0;
    	int currentTime = 0;
    	int reserveTime = 0;
    	alert("예약하시겠습니까?", " 놀이기구 : " + label_ride.getText() + "\n시간 : "+ label_time.getText());
    	Optional<ButtonType> result = alert.showAndWait();
    	String reRide = label_ride.getText();
    	String reTime = label_time.getText();
    	if(result.get() == ButtonType.OK) {
    		try {
    			/**
    			 * 2018/11/23 강혜민
    			 * 예약시 아무것도 선택안했을 때 수정 
    			 * 
    			 */
    			if(label_ride.getText().length() == 0 || label_time.getText().length() == 0) {
    				alert3("선택오류", "예약하실 놀이기구와 시간을 선택해주세요."); 
    				Optional<ButtonType> result2 = alert3.showAndWait();
    				return;
    			}
    			///
				ride_id = service.getRideId(reRide);
				rvo.setMem_id(member.getMem_id());  
				rvo.setRes_time(reTime);
				rvo.setRide_id(ride_id);
				cnt2 = service.countReserve(rvo);
				cnt3 = service.limitThreeReserve(member.getMem_id());
				
				DateFormat dateFormat = new SimpleDateFormat("HH");
				Calendar cal = Calendar.getInstance();
				currentTime = Integer.parseInt(dateFormat.format(cal.getTime()));
				reserveTime = Integer.parseInt(reTime.substring(0, 2));
				// 예약중복검사
				if(reserveTime <= currentTime) {
					alert3("예약 불가", "이미 지나간 시간입니다.");
					Optional<ButtonType> result4 = alert3.showAndWait();
					return;
				// 같은 기구 같은 시간 검사
				}else if(cnt2 > 0) {
					alert3("예약 불가", "예약이 중복됩니다.");
					Optional<ButtonType> result2 = alert3.showAndWait();
					return;
				// 3번 이상 예약 검사
				}else if(cnt3 >= 3){
					System.out.println(cnt3);
					alert3("예약 불가", "한회원당 예약을 3번으로 제한합니다.");
					Optional<ButtonType> result3 = alert3.showAndWait();
					return;
				// 저장하기	
				}else {
					
					cnt = service.insertReserve(rvo);
					if(cnt >0) {
						email1 = service.getEmail(member.getMem_id());
						//System.out.println(email1);
						// 이메일 전송하기
						qr makeqr = new qr();
						makeqr.createQR();
						email mail = new email();
						try {
							mail.sendPDFMail(email1);
						} catch (EmailException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						alert2("예약확인", "회원님의 이메일로 QR코드를 전송했습니다.");
						Optional<ButtonType> result5 = alert2.showAndWait();
					}
				}
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    	}else {
    		return;
    	}
    	
      
    }

    @FXML
    void click_animal(ActionEvent event) {
    	try {
			Parent zoo = FXMLLoader.load(getClass().getResource("/UI/zooScene.fxml")); 
			Stage primaryStage = (Stage)img_reserve.getScene().getWindow();
			
			Scene scene = new Scene(zoo);
			primaryStage.setTitle("동물원");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

 
    @FXML
    void click_cancelRes(ActionEvent event) {
    	try {
			Parent resrveCancel = FXMLLoader.load(getClass().getResource("/UI/reserveScene2.fxml")); 
			Stage primaryStage = (Stage)img_reserve.getScene().getWindow();
			
			Scene scene = new Scene(resrveCancel);
			primaryStage.setTitle("예약취소");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }


    


    @FXML
    void initialize() {
     assert table_1 != null : "fx:id=\"table_1\" was not injected: check your FXML file 'reserveScene.fxml'.";
        assert table_name != null : "fx:id=\"table_name\" was not injected: check your FXML file 'reserveScene.fxml'.";
        assert table_2 != null : "fx:id=\"table_2\" was not injected: check your FXML file 'reserveScene.fxml'.";
        assert table_time != null : "fx:id=\"table_time\" was not injected: check your FXML file 'reserveScene.fxml'.";
        assert label_ride != null : "fx:id=\"label_ride\" was not injected: check your FXML file 'reserveScene.fxml'.";
        assert label_time != null : "fx:id=\"label_time\" was not injected: check your FXML file 'reserveScene.fxml'.";
        assert font1 != null : "fx:id=\"font1\" was not injected: check your FXML file 'reserveScene.fxml'.";
        assert font2 != null : "fx:id=\"font2\" was not injected: check your FXML file 'reserveScene.fxml'.";
        assert font3 != null : "fx:id=\"font3\" was not injected: check your FXML file 'reserveScene.fxml'.";
        assert font4 != null : "fx:id=\"font4\" was not injected: check your FXML file 'reserveScene.fxml'.";
        assert font5 != null : "fx:id=\"font5\" was not injected: check your FXML file 'reserveScene.fxml'.";
        assert font6 != null : "fx:id=\"font6\" was not injected: check your FXML file 'reserveScene.fxml'.";
        assert img_reserve != null : "fx:id=\"img_reserve\" was not injected: check your FXML file 'reserveScene.fxml'.";

        
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
		
		
		member = CurrentLoginPerson.CurrentMember;
		
		// 테이블 셋팅
		List<RideVO> reservelist;
		List<DataVo> list=new ArrayList<>();
		
		try {
			reservelist = service.getRideName();
			data = FXCollections.observableArrayList(reservelist);
			table_1.setItems(data);
			table_name.setCellValueFactory(new PropertyValueFactory<>("ride_name"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		

		
		table_time.setCellValueFactory(new PropertyValueFactory<DataVo, String>("data"));
		
		
		list.add(new DataVo("11:00"));
		list.add(new DataVo("13:00"));
		list.add(new DataVo("15:00"));
		list.add(new DataVo("19:00"));
		list.add(new DataVo("21:00"));
		
		data2 = FXCollections.observableArrayList(list);
		table_2.setItems(data2);
		
		// 테이블 선택시 값 가져오기
		table_1.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				if(table_1.getSelectionModel().isEmpty()) {
					alert3("예약불가", "놀이기구를 선택해주세요.");
					alert3.show();
					return;
				}
				String name = table_1.getSelectionModel().getSelectedItem().getRide_name();
				label_ride.setText(name);
			};
		});
		
		table_2.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				if(table_2.getSelectionModel().isEmpty()) {
					alert3("예약불가", "시간을 선택해주세요.");
					alert3.show();
					return;
				}
				String time = table_2.getSelectionModel().getSelectedItem().getData();
				label_time.setText(time);
			};
		});
		
		
		
    }
    
    public class DataVo{
    	
    	public DataVo(String data) {
			super();
			this.data = data;
		}

    	
		public DataVo() {
			super();
		}


		private String data;

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}
    	
    }
    
    Alert alert;
    public void alert (String header,String msg) {
      alert=new Alert(AlertType.CONFIRMATION);
      
      alert.setTitle("예약확인");
      alert.setHeaderText(header);
      alert.setContentText(msg);
   }//end of alert
    
    
    Alert alert2;
    public void alert2 (String header,String msg) {
      alert2=new Alert(AlertType.INFORMATION);
      
      alert2.setTitle("예약확인");
      alert2.setHeaderText(header);
      alert2.setContentText(msg);
   }//end of alert
    
    Alert alert3;
    public void alert3 (String header,String msg) {
      alert3=new Alert(AlertType.WARNING);
      
      alert3.setTitle("예약불가");
      alert3.setHeaderText(header);
      alert3.setContentText(msg);
   }//end of alert
    
}


	
	
	



