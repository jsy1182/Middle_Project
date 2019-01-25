package controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.EmailException;

import buy.Email;
import buy.Pdf;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import vo.Annual_memberVO;
import vo.BuyVO;
import vo.MemberVO;

public class ReceiptController {
	BuyVO buyVO;
	Annual_memberVO annualVO;
	String cardNum="";
	MemberVO memVO;
	String email;
	String expiry;
	String bank;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRecipt;

    @FXML
    private Button btnClose;

    @FXML
    private Label labelDate;

    @FXML
    private Label labelNum;

    @FXML
    private Label labelProd;

    @FXML
    private Label labelMoney;

    @FXML
    void clickBtnClose(ActionEvent event) {
    	Stage close=(Stage) btnRecipt.getScene().getWindow();
		close.close();
    }

    @FXML
    void clickBtnRecipt(ActionEvent event) {
    	Pdf pdf=new Pdf(buyVO,cardNum,expiry,bank);
    	pdf.printPdf();
    	pdf.makeWaterMark();
    	Email email1=new Email(buyVO, email);
    	try {
			email1.sendPDFMail();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ialert("이메일 발송완료", email+"주소로 영수증이 발송되었습니다.");
    	Stage close=(Stage) btnRecipt.getScene().getWindow();
		close.close();
    }

    @FXML
    void initialize() {
        assert btnRecipt != null : "fx:id=\"btnRecipt\" was not injected: check your FXML file 'Receipt.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'Receipt.fxml'.";
        assert labelDate != null : "fx:id=\"labelDate\" was not injected: check your FXML file 'Receipt.fxml'.";
        assert labelNum != null : "fx:id=\"labelNum\" was not injected: check your FXML file 'Receipt.fxml'.";
        assert labelProd != null : "fx:id=\"labelProd\" was not injected: check your FXML file 'Receipt.fxml'.";
        assert labelMoney != null : "fx:id=\"labelMoney\" was not injected: check your FXML file 'Receipt.fxml'.";
        
    }
    public void setBuyVO(BuyVO buyVO) {
    	this.buyVO=buyVO;
    }
    
    public void setLabel() {
    	labelMoney.setText(""+buyVO.getSales());
    	String ticketName="";
    	if(buyVO.getTicket_id().equals("tc001")) {
    		ticketName="소인";
    	}else if(buyVO.getTicket_id().equals("tc002")) {
    		ticketName="청소년";
    	}else if(buyVO.getTicket_id().equals("tc003")) {
    		ticketName="성인";
    	}else if(buyVO.getTicket_id().equals("tc004")) {
    		ticketName="연간 소인";
    	}else if(buyVO.getTicket_id().equals("tc005")) {
    		ticketName="연간 청소년";
    	}else if(buyVO.getTicket_id().equals("tc006")) {
    		ticketName="연간 성인";
    	}else if(buyVO.getTicket_id().equals("tc007")) {
    		ticketName="단체 구매";
    	}
    	labelProd.setText(ticketName);
    	labelDate.setText(buyVO.getBuy_date());
    	labelNum.setText(cardNum);
    	
    }
    
    public void setAnnualVO(Annual_memberVO annualVO) {
    	this.annualVO=annualVO;
    }
    public void setCardNum(String cardNum) {
    	this.cardNum=cardNum;
    }
    public void setMemberVO(MemberVO memVO,String email) {
    	this.memVO=memVO;
    	this.email=email;
    	
    }
    public void setExpiry(String expiry) {
    	this.expiry=expiry;
    }
    public void setBank(String bank) {
    	this.bank=bank;
    }
    public void ialert(String header,String msg) {
		Alert alert=new Alert(AlertType.INFORMATION);
		
		alert.setTitle("이메일 발송 완료");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}//end of alert
}
