package main;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.PayMentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.ILalaLandBuyService;
import vo.Annual_memberVO;
import vo.BuyVO;
import vo.EventVO;
import vo.Event_joinVO;
import vo.MemberVO;
import vo.TicketVO;

public class BuyController {
	ILalaLandBuyService service;
	static Map<String,Float> eventMap=new HashMap<String,Float>();
	List<TicketVO> list;
	BuyVO buyVO=new BuyVO();
	Annual_memberVO amVO=new Annual_memberVO();
	PayMentController paymentController;
	MemberVO member;
	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private AnchorPane anchorPane;

	    @FXML
	    private Button buytc1;

	    @FXML
	    private Label lb11;

	    @FXML
	    private Label lb12;

	    @FXML
	    private Label lb21;

	    @FXML
	    private Label lb22;

	    @FXML
	    private Label lb31;

	    @FXML
	    private Label lb32;

	    @FXML
	    private Button buytc2;

	    @FXML
	    private Button buytc3;

	    @FXML
	    private Button buytc4;

	    @FXML
	    private Label lb13;

	    @FXML
	    private Label lb14;

	    @FXML
	    private Label lb23;

	    @FXML
	    private Label lb24;

	    @FXML
	    private Label lb33;

	    @FXML
	    private Label lb34;

	    @FXML
	    private Button buytc15;

	    @FXML
	    private Button buytc6;

	    @FXML
	    private Label lbl;

	    @FXML
	    private DatePicker dt;

	    @FXML
	    private Label lbdate;

    @FXML
    void clickBuyTC1(ActionEvent event) {
		if(dt.getValue()==null) {
			walert("구매실패", "입장 날짜를 입력해주세요");
			return;
		}
		LocalDateTime now=LocalDateTime.now();
		now.toLocalDate();
		LocalDate selDate=dt.getValue();
		if(now.toLocalDate().isAfter(selDate)) {
			walert("구매실패", "입장 날짜를 오늘 이후로 입력해주세요");
			return;
		}
		buyVO.setBuy_date(dt.getValue().toString());
    	try {
			if(service.checkBuy(buyVO)==1) {
				alert("구매확인", list.get(0).getTicket_kinds()+"티켓을 구매하시겠습니까???");
				Optional<ButtonType> result=alert.showAndWait();
				String ticketId=null;
				if(result.get()==ButtonType.OK) {
					ticketId=list.get(0).getTicket_id();
					buyVO.setTicket_id(ticketId);
					buyVO.setBuy_date(dt.getValue().toString());
					int sales=(int)(list.get(0).getTicket_pri()*(1-maxDisc));
					buyVO.setSales(sales);
					
				//화면 전환 부분
				Stage payment=new Stage(StageStyle.DECORATED);
				try {
					FXMLLoader loader=new FXMLLoader(getClass().getResource("/buy/Payment.fxml"));
					Parent paymentRoot;
					
					paymentRoot = loader.load();
					Scene paymentScene=new Scene(paymentRoot);
					paymentController=loader.getController();
					paymentController.setBuyVO(buyVO);
					paymentController.setAnnualVO(amVO);
					paymentController.setMemVO(member);
					paymentController.setLabel();
					
					payment.setTitle("구매 화면");
					payment.setScene(paymentScene);
					payment.showAndWait();
					gotoMainPage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else {
					return;
				}
			}else{	//end of if
				walert("구매실패", "이미 구매한 입장권이 있습니다.");
				return;
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }//end of btn1
    /**
     * 청소년 구매버튼 액션
     * @param event
     */
    @FXML
    void clickBuyTC2(ActionEvent event) {
    	if(dt.getValue()==null) {
			walert("구매실패", "입장 날짜를 입력해주세요");
			return;
		}
		LocalDateTime now=LocalDateTime.now();
		now.toLocalDate();
		LocalDate selDate=dt.getValue();
		if(now.toLocalDate().isAfter(selDate)) {
			walert("구매실패", "입장 날짜를 오늘 이후로 입력해주세요");
			return;
		}
		buyVO.setBuy_date(dt.getValue().toString());
    	try {
			if(service.checkBuy(buyVO)==1) {
				alert("구매확인", list.get(1).getTicket_kinds()+"티켓을 구매하시겠습니까???");
				Optional<ButtonType> result=alert.showAndWait();
				String ticketId=null;
				if(result.get()==ButtonType.OK) {
					ticketId=list.get(1).getTicket_id();
					buyVO.setTicket_id(ticketId);
					buyVO.setBuy_date(dt.getValue().toString());
					int sales=(int)(list.get(1).getTicket_pri()*(1-maxDisc));
					buyVO.setSales(sales);
					
				//화면 전환 부분
				Stage payment=new Stage(StageStyle.DECORATED);
				try {
					FXMLLoader loader=new FXMLLoader(getClass().getResource("/buy/Payment.fxml"));
					Parent paymentRoot;
					
					paymentRoot = loader.load();
					Scene paymentScene=new Scene(paymentRoot);
					paymentController=loader.getController();
					paymentController.setBuyVO(buyVO);
					paymentController.setAnnualVO(amVO);
					paymentController.setMemVO(member);
					paymentController.setLabel();
					
					payment.setTitle("구매 화면");
					payment.setScene(paymentScene);
					payment.showAndWait();
					gotoMainPage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else {
					return;
				}
			}else{	//end of if
				walert("구매실패", "이미 구매한 입장권이 있습니다.");
				return;
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }// end of btn2

    @FXML
    void clickBuyTC3(ActionEvent event) {
    	if(dt.getValue()==null) {
			walert("구매실패", "입장 날짜를 입력해주세요");
			return;
		}
		LocalDateTime now=LocalDateTime.now();
		now.toLocalDate();
		LocalDate selDate=dt.getValue();
		if(now.toLocalDate().isAfter(selDate)) {
			walert("구매실패", "입장 날짜를 오늘 이후로 입력해주세요");
			return;
		}
		buyVO.setBuy_date(dt.getValue().toString());
    	try {
			if(service.checkBuy(buyVO)==1) {
				alert("구매확인", list.get(2).getTicket_kinds()+"티켓을 구매하시겠습니까???");
				Optional<ButtonType> result=alert.showAndWait();
				String ticketId=null;
				if(result.get()==ButtonType.OK) {
					ticketId=list.get(2).getTicket_id();
					buyVO.setTicket_id(ticketId);
					buyVO.setBuy_date(dt.getValue().toString());
					int sales=(int)(list.get(2).getTicket_pri()*(1-maxDisc));
					buyVO.setSales(sales);
					
					//화면 전환 부분
					Stage payment=new Stage(StageStyle.DECORATED);
					try {
						FXMLLoader loader=new FXMLLoader(getClass().getResource("/buy/Payment.fxml"));
						Parent paymentRoot;
						
						paymentRoot = loader.load();
						Scene paymentScene=new Scene(paymentRoot);
						paymentController=loader.getController();
						paymentController.setBuyVO(buyVO);
						paymentController.setAnnualVO(amVO);
						paymentController.setMemVO(member);
						paymentController.setLabel();
						
						payment.setTitle("구매 화면");
						payment.setScene(paymentScene);
						payment.showAndWait();
						gotoMainPage();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					return;
				}
			}else{	//end of if
				walert("구매실패", "이미 구매한 입장권이 있습니다.");
				return;
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }// end of btn3

	@FXML
	void clickBuyTC4(ActionEvent event) {
		try {
			if (dt.getValue() == null) {
				walert("구매실패", "입장 날짜를 입력해주세요");
				return;
			}
			LocalDateTime now = LocalDateTime.now();
			now.toLocalDate();
			LocalDate selDate = dt.getValue();
			if (now.toLocalDate().isAfter(selDate)) {
				walert("구매실패", "입장 날짜를 오늘 이후로 입력해주세요");
				return;
			}
			String ticketId = null;
			ticketId = list.get(3).getTicket_id();
			amVO.setAm_id(member.getMem_id());
			amVO.setTicket_id(ticketId);
			amVO.setAm_start(dt.getValue().toString());
			amVO.setAm_end("" + dt.getValue().plusYears(1));
			if (service.checkAnnual(amVO) == 1) {
				alert("구매확인", list.get(3).getTicket_kinds() + "티켓을 구매하시겠습니까???");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					int sales = (int) (list.get(3).getTicket_pri());
					buyVO.setTicket_id(ticketId);
					buyVO.setSales(sales);
					buyVO.setBuy_date(dt.getValue().toString());

					// 화면 전환 부분
					Stage payment = new Stage(StageStyle.DECORATED);
					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/buy/Payment.fxml"));
						Parent paymentRoot;

						paymentRoot = loader.load();
						Scene paymentScene = new Scene(paymentRoot);
						paymentController = loader.getController();
						paymentController.setBuyVO(buyVO);
						paymentController.setAnnualVO(amVO);
						paymentController.setMemVO(member);
						paymentController.setLabel();

						payment.setTitle("구매 화면");
						payment.setScene(paymentScene);
						payment.showAndWait();
						gotoMainPage();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					return;
				}
			} else { // end of if
				walert("구매실패", "이미 구매한 입장권이 있습니다.");
				return;
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

    @FXML
    void clickBuyTC5(ActionEvent event) {
    	try {
    		if(dt.getValue()==null) {
				walert("구매실패", "입장 날짜를 입력해주세요");
				return;
			}
    		LocalDateTime now=LocalDateTime.now();
			now.toLocalDate();
			LocalDate selDate=dt.getValue();
    		if(now.toLocalDate().isAfter(selDate)) {
				walert("구매실패", "입장 날짜를 오늘 이후로 입력해주세요");
				return;
			}
    		String ticketId=null;
    		ticketId=list.get(4).getTicket_id();
    		amVO.setAm_id(member.getMem_id());
    		amVO.setTicket_id(ticketId);
    		amVO.setAm_start(dt.getValue().toString());
			amVO.setAm_end(""+dt.getValue().plusYears(1));
			if(service.checkAnnual(amVO)==1) {
				alert("구매확인", list.get(4).getTicket_kinds()+"티켓을 구매하시겠습니까???");
				Optional<ButtonType> result=alert.showAndWait();
				if(result.get()==ButtonType.OK) {
					int sales=(int)(list.get(4).getTicket_pri());
					buyVO.setTicket_id(ticketId);
					buyVO.setSales(sales);
					buyVO.setBuy_date(dt.getValue().toString());
					
				//화면 전환 부분
				Stage payment=new Stage(StageStyle.DECORATED);
				try {
					FXMLLoader loader=new FXMLLoader(getClass().getResource("/buy/Payment.fxml"));
					Parent paymentRoot;
					
					paymentRoot = loader.load();
					Scene paymentScene=new Scene(paymentRoot);
					paymentController=loader.getController();
					paymentController.setBuyVO(buyVO);
					paymentController.setAnnualVO(amVO);
					paymentController.setMemVO(member);
					paymentController.setLabel();
					
					payment.setTitle("구매 화면");
					payment.setScene(paymentScene);
					payment.showAndWait();
					gotoMainPage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else {
					return;
				}
			}else{	//end of if
				walert("구매실패", "이미 구매한 입장권이 있습니다.");
				return;
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }//end of clickBuyTc5

    @FXML
    void clickBuyTC6(ActionEvent event) {
    	try {
    		if(dt.getValue()==null) {
				walert("구매실패", "입장 날짜를 입력해주세요");
				return;
			}
    		LocalDateTime now=LocalDateTime.now();
			now.toLocalDate();
			LocalDate selDate=dt.getValue();
    		if(now.toLocalDate().isAfter(selDate)) {
				walert("구매실패", "입장 날짜를 오늘 이후로 입력해주세요");
				return;
			}
    		String ticketId=null;
    		ticketId=list.get(5).getTicket_id();
    		amVO.setAm_id(member.getMem_id());
    		amVO.setTicket_id(ticketId);
    		amVO.setAm_start(dt.getValue().toString());
			amVO.setAm_end(""+dt.getValue().plusYears(1));
			if(service.checkAnnual(amVO)==1) {
				alert("구매확인", list.get(5).getTicket_kinds()+"티켓을 구매하시겠습니까???");
				Optional<ButtonType> result=alert.showAndWait();
				if(result.get()==ButtonType.OK) {
					int sales=(int)(list.get(5).getTicket_pri());
					buyVO.setTicket_id(ticketId);
					buyVO.setSales(sales);
					buyVO.setBuy_date(dt.getValue().toString());
					
				//화면 전환 부분
				Stage payment=new Stage(StageStyle.DECORATED);
				try {
					FXMLLoader loader=new FXMLLoader(getClass().getResource("/buy/Payment.fxml"));
					Parent paymentRoot;
					
					paymentRoot = loader.load();
					Scene paymentScene=new Scene(paymentRoot);
					paymentController=loader.getController();
					paymentController.setBuyVO(buyVO);
					paymentController.setAnnualVO(amVO);
					paymentController.setMemVO(member);
					paymentController.setLabel();
					
					payment.setTitle("구매 화면");
					payment.setScene(paymentScene);
					payment.showAndWait();
					gotoMainPage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else {
					return;
				}
			}else{	//end of if
				walert("구매실패", "이미 구매한 입장권이 있습니다.");
				return;
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }//end of btn6 

   
    String maxEjId;
	float maxDisc = 0;
    
    @FXML
    void initialize() {
        assert buytc1 != null : "fx:id=\"buytc1\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert lb11 != null : "fx:id=\"lb11\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert lb12 != null : "fx:id=\"lb12\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert lb21 != null : "fx:id=\"lb21\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert lb22 != null : "fx:id=\"lb22\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert lb31 != null : "fx:id=\"lb31\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert lb32 != null : "fx:id=\"lb32\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert buytc2 != null : "fx:id=\"buytc2\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert buytc3 != null : "fx:id=\"buytc3\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert buytc4 != null : "fx:id=\"buytc4\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert lb13 != null : "fx:id=\"lb13\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert lb14 != null : "fx:id=\"lb14\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert lb23 != null : "fx:id=\"lb23\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert lb24 != null : "fx:id=\"lb24\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert lb33 != null : "fx:id=\"lb33\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert lb34 != null : "fx:id=\"lb34\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert buytc15 != null : "fx:id=\"buytc15\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert buytc6 != null : "fx:id=\"buytc6\" was not injected: check your FXML file 'buyscene.fxml'.";
        assert lbl != null : "fx:id=\"lbl\" was not injected: check your FXML file 'BuyScene.fxml'.";
        assert dt != null : "fx:id=\"dt\" was not injected: check your FXML file 'BuyScene.fxml'.";
        assert lbdate != null : "fx:id=\"lbdate\" was not injected: check your FXML file 'BuyScene.fxml'.";
        member=CurrentLoginPerson.CurrentMember;
        setFont();
        List<EventVO> eventList = null;
        try {
			Registry reg=LocateRegistry.getRegistry("localhost", 1088);
			service=(ILalaLandBuyService) reg.lookup("buy");
			list=service.getAllTicket();
			eventList=service.getEvent();
		} catch (RemoteException e) {
            System.out.println("buy service 가져오기 실패");
            e.printStackTrace();
         }catch (NotBoundException ee) {
        	 System.out.println("buy service 가져오기 실패");
             ee.printStackTrace();
		}
        
        buyVO.setMem_id(member.getMem_id());
      
        setLabel();
        
		for(EventVO evo:eventList) {
			eventMap.put(evo.getEvent_id(), evo.getEvent_disc());
		}
		getMaxDisc();
		
    }
    public void setFont() {
    	final Font font = Font.loadFont(getClass().getResourceAsStream("/font/HoonWhitecatR.ttf"), 25);
        final Font font1 = Font.loadFont(getClass().getResourceAsStream("/font/HoonJunglebookR.otf"), 70);
        final Font font2 = Font.loadFont(getClass().getResourceAsStream("/font/HoonlefthanderR.otf"), 35);
        final Font font3 = Font.loadFont(getClass().getResourceAsStream("/font/THELeft.ttf"), 25);
        final Font font0 = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 50);
        lb11.setFont(font2);
        lb12.setFont(font2);
        lb13.setFont(font2);
        lb14.setFont(font2);
        lb21.setFont(font2);
        lb22.setFont(font2);
        lb23.setFont(font2);
        lb24.setFont(font2);
        lb31.setFont(font2);
        lb32.setFont(font2);
        lb33.setFont(font2);
        lb34.setFont(font2);
        lbl.setFont(font0);
        lbdate.setFont(font3);
        buytc1.setFont(font);
        buytc15.setFont(font);
        buytc2.setFont(font);
        buytc3.setFont(font);
        buytc4.setFont(font);
        buytc6.setFont(font);
    }
    public void getMaxDisc() {
    	List<Event_joinVO> ejList = null;
		
		try {
			ejList = service.getEventJoin(member.getMem_id());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 할인률이 가장 높은 이벤트를 사용하기 위해서
		 */
		for(Event_joinVO ejVO:ejList) {
			String name=ejVO.getEvent_id();
			if(eventMap.get(name)>maxDisc) {
				maxDisc=eventMap.get(name);
				maxEjId=ejVO.getEj_id();
			}
		}
		buyVO.setEj_id(maxEjId);
    }
    
    public void setLabel() {
 		lb11.setText(list.get(0).getTicket_kinds());
    	lb12.setText(""+list.get(0).getTicket_pri());
    	lb21.setText(list.get(1).getTicket_kinds());
    	lb22.setText(""+list.get(1).getTicket_pri());
    	lb31.setText(list.get(2).getTicket_kinds());
    	lb32.setText(""+list.get(2).getTicket_pri());
    	lb13.setText(list.get(3).getTicket_kinds());
    	lb14.setText(""+list.get(3).getTicket_pri());
    	lb23.setText(list.get(4).getTicket_kinds());
    	lb24.setText(""+list.get(4).getTicket_pri());
    	lb33.setText(list.get(5).getTicket_kinds());
    	lb34.setText(""+list.get(5).getTicket_pri());
    }
    
    public void gotoMainPage() {
    	try {
    		FXMLLoader loader=new FXMLLoader(
    				getClass().getResource("/UI/mainscene.fxml")
    				);
    		Parent buy;
			buy=loader.load();
			Stage buyStage=(Stage) lb11.getScene().getWindow();
			
			Scene scene=new Scene(buy);
			buyStage.setTitle("메인화면");
			buyStage.setScene(scene);
			buyStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    			
    }//end of gotoMainPage
    Alert alert;
    public void alert(String header,String msg) {
		alert=new Alert(AlertType.CONFIRMATION);
		
		alert.setTitle("구매확인");
		alert.setHeaderText(header);
		alert.setContentText(msg);
	}//end of alert
    
    public void walert(String header,String msg) {
		Alert walert=new Alert(AlertType.WARNING);
		
		walert.setTitle("등록실패");
		walert.setHeaderText(header);
		walert.setContentText(msg);
		
		walert.show();
	}//end of walert
    
}
