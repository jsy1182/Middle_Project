package controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.EmailException;

import buy.GroupEmail;
import buy.GroupPdf;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import vo.MemberVO;

public class GReceiptController {
	int totalprice;
	int buyCount;
	String email;
	MemberVO memVO;
	String bank;
	String cardNum;
	String ticketKind;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnOK;
    
    @FXML
    private Button btnClose1;

    @FXML
    private Label lblmoney;

    @FXML
    void clickBtnClose(ActionEvent event) {
    	ialert("구매 완료", "이용해 주셔서 감사합니다.");
    	Stage close=(Stage) btnClose1.getScene().getWindow();
		close.close();
    }
    
    @FXML
    void clickBtnOk(ActionEvent event) {
    	GroupPdf pdf=new GroupPdf(cardNum, bank, totalprice, buyCount, email);
    	pdf.printPdf();
    	pdf.makeWaterMark();
    	GroupEmail mail=new GroupEmail(email);
    	try {
			mail.sendPDFMail();
			ialert("영수증 발송 완료", "이용해 주셔서 감사합니다.");
	    	Stage close=(Stage) btnClose1.getScene().getWindow();
			close.close();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert btnClose1 != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'GReceipt.fxml'.";
        assert lblmoney != null : "fx:id=\"lblmoney\" was not injected: check your FXML file 'GReceipt.fxml'.";
        assert btnOK != null : "fx:id=\"btnOK\" was not injected: check your FXML file 'GReceipt.fxml'.";

    }
    public void ialert(String header,String msg) {
		Alert alert=new Alert(AlertType.INFORMATION);
		
		alert.setTitle("구매 완료");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}//end of alert
    
    public void settotalprice(int totalprice) {
    	this.totalprice=totalprice;
    	lblmoney.setText(totalprice+"");
    }
    
    public void setbuyCount(int buyCount) {
    	this.buyCount=buyCount;
    }
    
    public void setEmail(String email) {
    	this.email=email;
    }
    
    public void setmemVO(MemberVO memVO) {
    	this.memVO=memVO;
    }
    
    public void setBank(String bank) {
    	this.bank=bank;
    }
    
    public void setCardNum(String cardNum) {
    	this.cardNum=cardNum;
    }
    
    public void setTicketKind(String ticketkind) {
    	ticketKind=ticketkind;
    }
}
