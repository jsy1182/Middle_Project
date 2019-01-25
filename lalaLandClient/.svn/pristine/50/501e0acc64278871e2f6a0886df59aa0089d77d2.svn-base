package controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import buy.BuyModiController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.ILalaLandBuyService;
import vo.TicketVO;

public class AdminViewTicketController {
	ILalaLandBuyService service;
	String admin_id="admin";
	List<TicketVO> ticketList;
	TicketVO ticketVO;
    @FXML
    private ResourceBundle resources;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private URL location;

    @FXML
    private Label lbtc2;

    @FXML
    private Label lbtc3;

    @FXML
    private Label lbtc4;

    @FXML
    private Label lbtc5;

    @FXML
    private Label lbtc6;

    @FXML
    private Label lbtc7;

    @FXML
    private Label lbtc1;

    @FXML
    private Button tc4btn;

    @FXML
    private Label lblmodi;

    @FXML
    private Button tc3btn;

    @FXML
    private Button tc2btn;

    @FXML
    private Button tc1btn;

    @FXML
    private Button tc7;

    @FXML
    private Button tc6;

    @FXML
    private Button tc5;

    

    @FXML
    void clicktx6(ActionEvent event) {
    	setTicket();
    	gotoBuyModi(5);
    	gotoMainPage();
    }

    @FXML
    void clk2(ActionEvent event) {
    	setTicket();
    	gotoBuyModi(1);
    	gotoMainPage();
    }

    @FXML
    void clk3(ActionEvent event) {
    	setTicket();
    	gotoBuyModi(2);
    	gotoMainPage();
    }

    @FXML
    void clk4(ActionEvent event) {
    	setTicket();
    	gotoBuyModi(3);
    	gotoMainPage();
    }

    @FXML
    void clktc1(ActionEvent event) {
    	setTicket();
    	gotoBuyModi(0);
    	gotoMainPage();
    }

    @FXML
    void clktc5(ActionEvent event) {
    	setTicket();
    	gotoBuyModi(4);
    	gotoMainPage();
    }

    @FXML
    void clktc7(ActionEvent event) {
    	setTicket();
    	gotoBuyModi(6);
    	gotoMainPage();
    }

    @FXML
    void initialize() {
    	assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert lbtc2 != null : "fx:id=\"lbtc2\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert lbtc3 != null : "fx:id=\"lbtc3\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert lbtc4 != null : "fx:id=\"lbtc4\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert lbtc5 != null : "fx:id=\"lbtc5\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert lbtc6 != null : "fx:id=\"lbtc6\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert lbtc7 != null : "fx:id=\"lbtc7\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert lbtc1 != null : "fx:id=\"lbtc1\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert tc4btn != null : "fx:id=\"tc4btn\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert lblmodi != null : "fx:id=\"lblmodi\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert tc3btn != null : "fx:id=\"tc3btn\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert tc2btn != null : "fx:id=\"tc2btn\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert tc1btn != null : "fx:id=\"tc1btn\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert tc7 != null : "fx:id=\"tc7\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert tc6 != null : "fx:id=\"tc6\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        assert tc5 != null : "fx:id=\"tc5\" was not injected: check your FXML file 'AdminViewTicket.fxml'.";
        
        try {
			Registry reg=LocateRegistry.getRegistry("localhost", 1088);
			service=(ILalaLandBuyService) reg.lookup("buy");
		} catch (RemoteException e) {
            System.out.println("buy service 가져오기 실패");
            e.printStackTrace();
         }catch (NotBoundException ee) {
        	 System.out.println("buy service 가져오기 실패");
             ee.printStackTrace();
		}
        setTicket();
        setLabel();
        setFont();
    }//end of initialize
    public void setService(ILalaLandBuyService service) {
    	this.service=service;
    }
    public void setTicket() {
    	try {
			ticketList=service.getAllTicket();
		} catch (RemoteException e) {
			walert("로드실패", "티켓 정보 가져오기 실패");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void walert(String header,String msg) {
		Alert walert=new Alert(AlertType.WARNING);
		
		walert.setTitle("등록실패");
		walert.setHeaderText(header);
		walert.setContentText(msg);
		
		walert.show();
	}//end of walert
    public void setLabel() {
    	lbtc1.setText(ticketList.get(0).getTicket_kinds());
    	lbtc2.setText(ticketList.get(1).getTicket_kinds());
    	lbtc3.setText(ticketList.get(2).getTicket_kinds());
    	lbtc4.setText(ticketList.get(3).getTicket_kinds());
    	lbtc5.setText(ticketList.get(4).getTicket_kinds());
    	lbtc6.setText(ticketList.get(5).getTicket_kinds());
    	lbtc7.setText(ticketList.get(6).getTicket_kinds());
    }
    public void setFont() {
    	final Font font = Font.loadFont(getClass().getResourceAsStream("/font/HoonWhitecatR.ttf"), 25);
        final Font font1 = Font.loadFont(getClass().getResourceAsStream("/font/HoonJunglebookR.otf"), 50);
        final Font font2 = Font.loadFont(getClass().getResourceAsStream("/font/HoonlefthanderR.otf"), 35);
        final Font font3 = Font.loadFont(getClass().getResourceAsStream("/font/THELeft.ttf"), 25);
        
        lblmodi.setFont(font1);
        lbtc1.setFont(font2);
        lbtc2.setFont(font2);
        lbtc3.setFont(font2);
        lbtc4.setFont(font2);
        lbtc5.setFont(font2);
        lbtc6.setFont(font2);
        lbtc7.setFont(font2);
        tc1btn.setFont(font);
        tc2btn.setFont(font);
        tc3btn.setFont(font);
        tc4btn.setFont(font);
        tc5.setFont(font);
        tc6.setFont(font);
        tc7.setFont(font);
    }
    
    public void gotoBuyModi(int i) {
    	try {
			Stage gpayment=new Stage(StageStyle.DECORATED);
			FXMLLoader loader=new FXMLLoader(getClass().getResource("/buy/BuyModi.fxml"));
			Parent modi;
			modi = loader.load();
			
			Scene gpayscene=new Scene(modi);
			
			BuyModiController bmc=loader.getController();
			bmc.setService(service);
			bmc.setTicketVO(ticketList.get(i));
			bmc.setLabel();
			
			gpayment.setTitle("티켓 수정화면");
			gpayment.setScene(gpayscene);
			gpayment.showAndWait();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public void gotoMainPage() {
    	try {
    		FXMLLoader loader=new FXMLLoader(
    				getClass().getResource("/UI/AdminMainScene.fxml")
    				);
    		Parent buy;
			buy=loader.load();
			Stage buyStage=(Stage) lbtc2.getScene().getWindow();
			
			Scene scene=new Scene(buy);
			buyStage.setTitle("메인화면");
			buyStage.setScene(scene);
			buyStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    			
    }//end of gotoMainPage
    
}
