package eventAdmin.controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.DateUtil;

import event.controller.EventAdminMainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import service.IEventService;
import vo.EventVO;

public class EventAdminAddController {
	private IEventService service;
	private EventAdminMainController add;
	
	
	
    public void setAdd(EventAdminMainController add) {
		this.add = add;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfId;
    
    @FXML
    private TextField tfTitle;

    @FXML
    private TextArea taContent;

    @FXML
    private TextField tfStart;

    @FXML
    private TextField tfEnd;

    @FXML
    private TextField tfDiscount;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancel;

/*    public void setTa(TextArea taContent) {
		this.taContent = taContent;
	}*/
    
    public java.util.Date setDate(Date date){
		java.util.Date utilDate = new java.util.Date(date.getTime());  	
		return utilDate;
	}
    
    public Date setSqlDate(java.util.Date date) {
    	Date sqlDate = new Date(date.getTime());
    	return sqlDate;
    }
    
    @FXML
    void btnOK(ActionEvent event) throws RemoteException{
    	EventVO eventVO = new EventVO();
    	
    	if(tfTitle.getText().isEmpty()) {
    		alert("제목 입력 오류","제목을 입력해주세요");
    		tfTitle.requestFocus();
    		System.out.println(tfTitle.getText());
    		return;
    	}
    	
    	if(taContent.getText().isEmpty()) {
    		alert("내용 입력 오류","내용을 입력해주세요"+taContent.getText().length());
    		taContent.requestFocus();
    		return;
    	}
    	
    	if(tfStart.getText().isEmpty()) {
    		alert("날짜 입력 오류","날짜를 입력해주세요");
    		tfStart.requestFocus();
    		return;
    	}
    	if(tfEnd.getText().isEmpty()) {
    		alert("날짜 입력 오류","날짜를 입력해주세요");
    		tfEnd.requestFocus();
    		return;
    	}
    	if(tfDiscount.getText().isEmpty()) {
    		alert("할인율 입력 오류","할인율을 입력해주세요");
    		tfDiscount.requestFocus();
    		return;
    	}
    	
    	SimpleDateFormat form = new SimpleDateFormat("YY-MM-dd");
		String discount = "^[0](.[0-9]{1,2})?$";
    	Pattern pattern = Pattern.compile(discount);
    	
    	eventVO.setEvent_title(tfTitle.getText());
    	eventVO.setEvent_content(taContent.getText());
    	
    	try {
			eventVO.setEvent_start(new java.sql.Date(form.parse(tfStart.getText()).getTime()));
		} catch (ParseException e) {
			alert(null,"시작일을 다시 입력해주세요");
			tfStart.requestFocus();
			return;
		}
   
    	try {
			eventVO.setEvent_end(new java.sql.Date(form.parse(tfEnd.getText()).getTime()));
		} catch (ParseException e) {
			alert(null,"종료일을 다시 입력해주세요");
			tfEnd.requestFocus();
			return;
		}
    	
    	try {
    		eventVO.setEvent_disc(Float.parseFloat(tfDiscount.getText()));
    	}catch (NumberFormatException e){
    		alert(null,"숫자만 입력해주세요");
    		tfDiscount.requestFocus();
    		return;
    	}
    	
    	Matcher m = pattern.matcher(eventVO.getEvent_disc()+"");
    	if(m.find()) {
    		m.group();
    	}else {
    		alert(null,"잘못된 입력입니다");
    		tfDiscount.requestFocus();
    		return;
    	}
    	
    	int count = service.insertEvent(eventVO);
    	if(count > 0) {
    		confirm("등록 성공");
    		try {
				add.showlistView();
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	}else {
    		alert(null, "등록실패");
    	}
    	
    	clear();
    }

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	clear();
    	stage.close();
    }
    
    public void clear() {
    	tfTitle.clear();
    	taContent.clear();
    	tfStart.clear();
    	tfEnd.clear();
    	tfDiscount.clear();
    }
    
    public void alert(String header, String msg) {
    	Alert warning = new Alert(AlertType.WARNING);
    	
    	warning.setTitle("오류");
    	warning.setHeaderText(header);
    	warning.setContentText(msg);
    	warning.showAndWait();
    }
    
    public void confirm(String msg) {
    	Alert confirm = new Alert(AlertType.CONFIRMATION);
    	
    	confirm.setTitle("확인");
    	confirm.setHeaderText(null);
    	confirm.setContentText(msg);
    	
    	confirm.showAndWait();
    }
    
    @FXML
    void initialize() {
    	assert tfId != null : "fx:id=\"tfId\" was not injected: check your FXML file 'EventAdd.fxml'.";
        assert tfTitle != null : "fx:id=\"tfTitle\" was not injected: check your FXML file 'EventAdd.fxml'.";
        assert taContent != null : "fx:id=\"taContent\" was not injected: check your FXML file 'EventAdd.fxml'.";
        assert tfStart != null : "fx:id=\"tfStart\" was not injected: check your FXML file 'EventAdd.fxml'.";
        assert tfEnd != null : "fx:id=\"tfEnd\" was not injected: check your FXML file 'EventAdd.fxml'.";
        assert tfDiscount != null : "fx:id=\"tfDiscount\" was not injected: check your FXML file 'EventAdd.fxml'.";
        
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IEventService) reg.lookup("eventService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("board service 가져오기 실패");
			e.printStackTrace();
		}
		
		
		
    }
}
