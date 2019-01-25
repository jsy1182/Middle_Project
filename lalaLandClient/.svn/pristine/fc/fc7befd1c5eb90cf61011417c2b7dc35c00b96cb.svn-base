package member.controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import service.ILalaLandMemberService;

public class SearchPass3Controller {
	
	private ILalaLandMemberService service;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ok_btn;

    @FXML
    void okBtn(ActionEvent event) {
    	Stage stage = (Stage) ok_btn.getScene().getWindow();
    	stage.close();


    }

    @FXML
    void initialize() {
        assert ok_btn != null : "fx:id=\"ok_btn\" was not injected: check your FXML file 'SearchPassWordScene3.fxml'.";

        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandMemberService) reg.lookup("memberService");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("board service 가져오기 실패");
            e.printStackTrace();
         }

    }
}
