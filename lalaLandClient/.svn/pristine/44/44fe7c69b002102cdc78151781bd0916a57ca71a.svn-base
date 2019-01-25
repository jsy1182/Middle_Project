package controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import service.ILalaLandBuyService;
import vo.Annual_memberVO;
import vo.BuyVO;
import vo.MemberVO;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;

public class GPayMentController {
	ILalaLandBuyService service;
	BuyVO buyVO;
	List<BuyVO> buyVOlist;
	Annual_memberVO annualVO;
	ReceiptController receiptController;
	MemberVO memVO;
	String bank1="농협";
	String credit;
	String ticketKind;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnPayment;

    @FXML
    private RadioButton radio1;

    @FXML
    private ToggleGroup bank;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio3;

    @FXML
    private RadioButton radio4;

    @FXML
    private TextField txFd1;

    @FXML
    private Label cardNum;

    @FXML
    private TextField txFd3;

    @FXML
    private TextField txFd4;

    @FXML
    private TextField txFd2;

    @FXML
    private Label cardNum2;

    @FXML
    private TextField txFd5;

    @FXML
    private Label cardNum3;

    @FXML
    private TextField txFd6;

    @FXML
    private Label cardNum4;

    @FXML
    private Label prodLabel;

    @FXML
    private Label moneyLabel;

    @FXML
    private Label emailLb;

    @FXML
    private TextField emailTxfd;

    @FXML
    void clickBtnCancel(ActionEvent event) {
    	Stage close=(Stage) prodLabel.getScene().getWindow();
		close.close();
    }

    @FXML
    void clickBtnPayment(ActionEvent event) {
    	Pattern p1 = Pattern.compile("(^[0-9]{4}$)");
    	Pattern p2 = Pattern.compile("^(0?[1-9]|1[012])$");
    	
    	Matcher m1 = p1.matcher(txFd1.getText());
    	Matcher m2 = p1.matcher(txFd2.getText());
    	Matcher m3 = p1.matcher(txFd3.getText());
    	Matcher m4 = p1.matcher(txFd4.getText());
    	
    	if(!(m1.find() && m2.find() && m3.find() && m4.find())) {
    		walert("입력오류", "카드번호를 다시 입력해주세요");
    		txFd1.clear();
    		txFd2.clear();
    		txFd3.clear();
    		txFd4.clear();
    		txFd1.setEditable(true);
    		txFd2.setEditable(true);
    		txFd3.setEditable(true);
    		txFd4.setEditable(true);
    		return;
    	}
    	
    	SimpleDateFormat format=new SimpleDateFormat("YYYY");
		Date date=new Date();
		String dateformat=format.format(date);
		int z=Integer.parseInt(dateformat);
    	int j=Integer.parseInt(txFd5.getText());
    	if(j<=z) {
    		walert("입력오류", "유효일자를 다시 입력해주세요");
    		txFd5.clear();
    		txFd6.clear();
    		txFd5.setEditable(true);
    		txFd6.setEditable(true);
    		return;
    	}
    	
    	Matcher m5=p1.matcher(txFd5.getText());
    	Matcher m6=p2.matcher(txFd6.getText());
    	if(!m5.find()||!m6.find()) {
    		walert("입력오류", "유효일자를 다시 입력해주세요");
    		txFd5.clear();
    		txFd6.clear();
    		txFd5.setEditable(true);
    		txFd6.setEditable(true);
    		return;
    	}
    	
    	credit=txFd1.getText()+"-"+txFd2.getText()+"-"+txFd3.getText()+"-"+txFd4.getText();
    	
    	String ticketKind1=buyVOlist.get(1).getTicket_id();
    	if(ticketKind1.equals("tc001")) {
    		ticketKind="어린이";
    	}else if(ticketKind1.equals("tc002")) {
    		ticketKind="청소년";
    	}else if(ticketKind1.equals("tc003")) {
    		ticketKind="성인";
    	}
		try {
			for(int i=0; i<buyVOlist.size();i++) {
				service.insertBuy(buyVOlist.get(i));
			}
			Parent receipt1 = null;
			FXMLLoader loader=new FXMLLoader(
					getClass().getResource("/buy/GReceipt.fxml")
					);
			try {
				receipt1=loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Stage buyStage=(Stage) btnPayment.getScene().getWindow();
			Scene scene=new Scene(receipt1);
			
			GReceiptController grc=loader.getController();
			grc.settotalprice(totalprice);
			grc.setbuyCount(buyVOlist.size());
			grc.setBank(bank1);
			grc.setCardNum(credit);
			grc.setTicketKind(ticketKind);
			grc.setEmail(emailTxfd.getText());
			grc.setmemVO(memVO);
			
			buyStage.setTitle("구매 확인 화면");
			buyStage.setScene(scene);
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void clickRadio1(ActionEvent event) {
    	bank1="농협";
    }

    @FXML
    void clickRadio2(ActionEvent event) {
    	bank1="KB국민";
    }

    @FXML
    void clickRadio3(ActionEvent event) {
    	bank1="신한은행";
    }

    @FXML
    void clickRadio4(ActionEvent event) {
    	bank1="신협";
    }
    
    @FXML
    void pressTxfd1(KeyEvent event) {
    	if(txFd1.getText().length()>3) {
    		txFd1.setEditable(false);
    		txFd2.requestFocus();
    	}
    }

    @FXML
    void pressTxfd2(KeyEvent event) {
    	if(txFd2.getText().length()>3) {
    		txFd2.setEditable(false);
    		txFd3.requestFocus();
    	}
    }

    @FXML
    void pressTxfd3(KeyEvent event) {
    	if(txFd3.getText().length()>3) {
    		txFd3.setEditable(false);
    		txFd4.requestFocus();
    	}
    }

    @FXML
    void pressTxfd4(KeyEvent event) {
    	if(txFd4.getText().length()>3) {
    		txFd4.setEditable(false);
    		txFd5.requestFocus();
    	}
    }

    @FXML
    void pressTxfd5(KeyEvent event) {
    	if(txFd5.getText().length()>3) {
    		txFd5.setEditable(false);
    		txFd6.requestFocus();
    	}
    }

    @FXML
    void pressTxfd6(KeyEvent event) {
    	if(txFd6.getText().length()>1) {
    		txFd6.setEditable(false);
    	}
    }
    
    @FXML
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert btnPayment != null : "fx:id=\"btnPayment\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert radio1 != null : "fx:id=\"radio1\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert bank != null : "fx:id=\"bank\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert radio2 != null : "fx:id=\"radio2\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert radio3 != null : "fx:id=\"radio3\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert radio4 != null : "fx:id=\"radio4\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert txFd1 != null : "fx:id=\"txFd1\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert cardNum != null : "fx:id=\"cardNum\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert txFd3 != null : "fx:id=\"txFd3\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert txFd4 != null : "fx:id=\"txFd4\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert txFd2 != null : "fx:id=\"txFd2\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert cardNum2 != null : "fx:id=\"cardNum2\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert txFd5 != null : "fx:id=\"txFd5\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert cardNum3 != null : "fx:id=\"cardNum3\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert txFd6 != null : "fx:id=\"txFd6\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert cardNum4 != null : "fx:id=\"cardNum4\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert prodLabel != null : "fx:id=\"prodLabel\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert moneyLabel != null : "fx:id=\"moneyLabel\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert emailLb != null : "fx:id=\"emailLb\" was not injected: check your FXML file 'GPayment.fxml'.";
        assert emailTxfd != null : "fx:id=\"emailTxfd\" was not injected: check your FXML file 'GPayment.fxml'.";
        
        

    }
    int totalprice;
    public void setbuyVO(List<BuyVO> vo) {
    	buyVOlist=vo;
    	prodLabel.setText("단체구매");
    	totalprice=buyVOlist.get(1).getSales()*buyVOlist.size();
    	moneyLabel.setText(totalprice+"원");
    	try {
			MemberVO memvo=service.getMember(buyVOlist.get(0).getMem_id());
			emailTxfd.setText(memvo.getMem_mail());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void setservice(ILalaLandBuyService service) {
    	this.service=service;
    }
    public void walert(String header,String msg) {
		Alert walert=new Alert(AlertType.WARNING);
		
		walert.setTitle("등록실패");
		walert.setHeaderText(header);
		walert.setContentText(msg);
		
		walert.show();
	}//end of walert
}
