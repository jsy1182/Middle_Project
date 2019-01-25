package buy;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import service.ILalaLandBuyService;
import vo.TicketVO;

public class BuyModiController {
	ILalaLandBuyService service;
	TicketVO ticketVO;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lb1;

    @FXML
    private Label lb2;

    @FXML
    private Label lb3;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private Button btnModi;
 
    @FXML
    private Button btnNo;

    @FXML
    void clkNo(ActionEvent event) {
    	Stage close=(Stage) txt1.getScene().getWindow();
		close.close();
    }

    @FXML
    void clkOk(ActionEvent event) {
    	if(txt3.getText().isEmpty()||txt3.getText()==null) {
    		walert("수정실패", "정확한값을 입력해주세요");
    		return;
    	}
    	if(Integer.parseInt(txt3.getText())<10000) {
    		walert("수정실패","입력한값이 너무 작습니다.");
    		return;
    	}
    	pricemodi();
    }

    @FXML
    void initialize() {
        assert lb1 != null : "fx:id=\"lb1\" was not injected: check your FXML file 'BuyModi.fxml'.";
        assert lb2 != null : "fx:id=\"lb2\" was not injected: check your FXML file 'BuyModi.fxml'.";
        assert lb3 != null : "fx:id=\"lb3\" was not injected: check your FXML file 'BuyModi.fxml'.";
        assert txt1 != null : "fx:id=\"txt1\" was not injected: check your FXML file 'BuyModi.fxml'.";
        assert txt2 != null : "fx:id=\"txt2\" was not injected: check your FXML file 'BuyModi.fxml'.";
        assert txt3 != null : "fx:id=\"txt3\" was not injected: check your FXML file 'BuyModi.fxml'.";
        assert btnModi != null : "fx:id=\"btnModi\" was not injected: check your FXML file 'BuyModi.fxml'.";
        assert btnNo != null : "fx:id=\"btnNo\" was not injected: check your FXML file 'BuyModi.fxml'.";

    }
    public void setTicketVO(TicketVO ticketVO) {
    	this.ticketVO=ticketVO;
    }
    public void setService(ILalaLandBuyService service) {
    	this.service=service;
    }
    public void setLabel() {
    	txt1.setText(ticketVO.getTicket_id());
    	txt2.setText(ticketVO.getTicket_kinds());
    	txt3.setText(ticketVO.getTicket_pri()+"");
    	txt1.setEditable(false);
    	txt2.setEditable(false);
    	txt3.getCursor();
    }
    public void ialert(String header,String msg) {
		Alert alert=new Alert(AlertType.INFORMATION);
		
		alert.setTitle("수정 완료");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}//end of alert
    public void walert(String header,String msg) {
		Alert walert=new Alert(AlertType.WARNING);
		
		walert.setTitle("등록실패");
		walert.setHeaderText(header);
		walert.setContentText(msg);
		
		walert.show();
	}//end of walert
    public void pricemodi() {
    	Pattern p = Pattern.compile("(^[0-9]*$)");
    	Matcher m = p.matcher(txt3.getText());
    	if(m.find()) {
    		try {
    			int ticketPri=Integer.parseInt(txt3.getText());
    			ticketVO.setTicket_pri(ticketPri);
				int update=service.updateTicket(ticketVO);
				if(update>0) {
					ialert("수정완료", "수정이 완료되었습니다.");
					Stage close=(Stage) txt1.getScene().getWindow();
					close.close();
				}else {
					walert("업데이트 실패", "업데이트 실패");
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}else {
    		walert("입력실패", "정확한 가격 입력해주세요");
    	}
    }
}
