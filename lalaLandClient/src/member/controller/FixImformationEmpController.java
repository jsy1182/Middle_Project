package member.controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import service.ILalaLandMemberService;
import vo.EmpVO;

public class FixImformationEmpController {
	
	EmpVO empVo;
    ILalaLandMemberService service;
    
	final Font font = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 13);



    @FXML
    private Label pass_text;

    @FXML
    private Label passOk_text;
    
    @FXML
    private Label tel_text;
    
    @FXML
    private Label mail_text;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ok_btn;

    @FXML
    private Button can_btn;

    @FXML
    private PasswordField pass;

    @FXML
    private PasswordField passOk;

    @FXML
    private TextField tel;

    @FXML
    private TextField mail;

    @FXML
    void canBtn(ActionEvent event) {
    	Stage stage = (Stage) tel.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void okBtn(ActionEvent event) {
    	empVo.setEmp_mail(mail.getText());
    	empVo.setEmp_pass(pass.getText());
    	empVo.setEmp_tel(tel.getText());
    	
    	// 비밀번호 일치 검사
    	if(!(pass.getText().equals(passOk.getText()))) {
    		alert("WARNING","비밀번호를 확인해 주세요");
    		pass.requestFocus();
    		return;
    		
    	}else {
    		
    		int chk ;
    		try {
    			chk = service.fixInformationEmp(empVo);
    			if(chk>0) alert(null,"update 성공");
    			else alert(null,"update 실패");
    		}catch(RemoteException e) {
    			e.printStackTrace();
    		}
    		Stage stage = (Stage) tel.getScene().getWindow();
    		stage.close();
    		
    		
    		
    		
    	}
    	

    }
    public void alert(String header, String msg) {
		Alert alert = new Alert(AlertType.WARNING);

		alert.setTitle("WARNING");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}

    @FXML
    void initialize() {
        assert pass_text != null : "fx:id=\"pass_text\" was not injected: check your FXML file 'FixImformationEmp.fxml'.";
        assert passOk_text != null : "fx:id=\"passOk_text\" was not injected: check your FXML file 'FixImformationEmp.fxml'.";
        assert ok_btn != null : "fx:id=\"ok_btn\" was not injected: check your FXML file 'FixImformationEmp.fxml'.";
        assert can_btn != null : "fx:id=\"can_btn\" was not injected: check your FXML file 'FixImformationEmp.fxml'.";
        assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'FixImformationEmp.fxml'.";
        assert passOk != null : "fx:id=\"passOk\" was not injected: check your FXML file 'FixImformationEmp.fxml'.";
        assert tel_text != null : "fx:id=\"tel_text\" was not injected: check your FXML file 'FixImformationEmp.fsml'.";
        assert tel != null : "fx:id=\"tel\" was not injected: check your FXML file 'FixImformationEmp.fxml'.";
        assert mail_text != null : "fx:id=\"mail_text\" was not injected: check your FXML file 'FixImformationEmp.fxml'.";
        assert mail != null : "fx:id=\"mail\" was not injected: check your FXML file 'FixImformationEmp.fxml'.";

        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandMemberService) reg.lookup("memberService");
         } catch (RemoteException | NotBoundException e) {
             System.out.println("member service 가져오기 실패");
             e.printStackTrace();
          }
        pass_text.setFont(font);
        passOk_text.setFont(font);
        ok_btn.setFont(font);
        can_btn.setFont(font);
        pass.setFont(font);
        passOk.setFont(font);
        tel_text.setFont(font);
        tel.setFont(font);
        mail_text.setFont(font);
        mail.setFont(font);
        
        empVo = CurrentLoginPerson.CurrentEmp;
        mail.setText(empVo.getEmp_mail());
        tel.setText(empVo.getEmp_tel());
        pass.setText(empVo.getEmp_pass());
    }
}
