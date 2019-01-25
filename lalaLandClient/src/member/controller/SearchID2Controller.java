package member.controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import service.ILalaLandMemberService;
import vo.MemberVO;

public class SearchID2Controller {
	
	Stage st;
	
	public ILalaLandMemberService service;
	
	MemberVO memVo;



	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label searchId;
    
    @FXML
    private Button ok_btn;

    @FXML
    void okBtn(ActionEvent event) {
    	Stage stage = (Stage) searchId.getScene().getWindow();
    	stage.close();

    }
     
    
    String memberId;
    
    @FXML
    void initialize() {
    	assert ok_btn != null : "fx:id=\"ok_btn\" was not injected: check your FXML file 'SearchIDScene2.fxml'.";
        assert searchId != null : "fx:id=\"searchId\" was not injected: check your FXML file 'SearchIDScene2.fxml'.";

        
        //searchId.setText("");
        
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandMemberService) reg.lookup("memberService");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("board service 가져오기 실패");
            e.printStackTrace();
         }
        	settingText();
    }
    public void setString(String mem_id) {
    	memberId = mem_id;
    }
    public void settingText() {
    	searchId.setText(memberId);
    }
}
