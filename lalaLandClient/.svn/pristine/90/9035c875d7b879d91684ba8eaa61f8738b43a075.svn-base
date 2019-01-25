package eventAdmin.controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import service.IEventService;
import vo.EventVO;

public class EventAdminEditController {
	private IEventService service;
	
	// EventAdminMain에서 값을 받기위한 VO
	EventVO eventVo;
	TextArea ta;
	// EventEdit에서 값 저장하는 VO
	
    public void setTa(TextArea ta) {
		this.ta = ta;
	}

	public void setEventVo(EventVO eventVo) {
		this.eventVo = eventVo;
		
		SimpleDateFormat form = new SimpleDateFormat("YY-MM-dd");
		String start = form.format(setDate(eventVo.getEvent_start())); 
		String end = form.format(setDate(eventVo.getEvent_end())); 
		
		tfId.setText(eventVo.getEvent_id());
		tfTitle.setText(eventVo.getEvent_title());
    	taContent.setText(eventVo.getEvent_content());;
    	tfStart.setText(start);
    	tfEnd.setText(end);
    	tfDiscount.setText(eventVo.getEvent_disc()+"");
	}
	
	public java.util.Date setDate(Date date){
		java.util.Date utilDate = new java.util.Date(date.getTime());  	
		return utilDate;
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
    
    
    @FXML
	void btnOK(ActionEvent event) throws RemoteException, ParseException {
    	EventVO vo = new EventVO();
    	
    	SimpleDateFormat form = new SimpleDateFormat("YY-MM-dd");
    	
    	vo.setEvent_id(tfId.getText());
    	vo.setEvent_title(tfTitle.getText());
    	vo.setEvent_content(taContent.getText());
    	vo.setEvent_start(new java.sql.Date(form.parse(tfStart.getText()).getTime()));
    	vo.setEvent_end(new java.sql.Date(form.parse(tfEnd.getText()).getTime()));
    	vo.setEvent_disc(Float.parseFloat(tfDiscount.getText()));
    	
		int edit = service.updateEvent(vo);
		if(edit>0) {
			confirm("수정 성공");
			ta.setText("제목 : " + tfTitle.getText() + "\n내용 : " + taContent.getText() + 
					"\n할인률 : " + Float.parseFloat(tfDiscount.getText()) + "\n이벤트 시작일 : " + tfStart.getText()+ 
					"\n이벤트 종료일 : " + tfEnd.getText());
		}
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
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	tfTitle.clear();
    	taContent.clear();
    	tfStart.clear();
    	tfEnd.clear();
    	tfDiscount.clear();
    	stage.close();
    }
    
    @FXML
    void initialize() throws RemoteException {
        assert tfTitle != null : "fx:id=\"tfTitle\" was not injected: check your FXML file 'EventEdit.fxml'.";
        assert taContent != null : "fx:id=\"taContent\" was not injected: check your FXML file 'EventEdit.fxml'.";
        assert tfStart != null : "fx:id=\"tfStart\" was not injected: check your FXML file 'EventEdit.fxml'.";
        assert tfEnd != null : "fx:id=\"tfEnd\" was not injected: check your FXML file 'EventEdit.fxml'.";
        assert tfDiscount != null : "fx:id=\"tfDiscount\" was not injected: check your FXML file 'EventEdit.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'EventEdit.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'EventEdit.fxml'.";

        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IEventService) reg.lookup("eventService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("board service 가져오기 실패");
			e.printStackTrace();
		} 
    }
}
