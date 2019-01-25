package Board.controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import service.IBoardService;
import vo.MessageVO;

public class MessageReplyController {
	MessageVO message ; 

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea ta;

    @FXML
    void click_goback(ActionEvent event) {
    	Stage stage = (Stage) ta.getScene().getWindow();
    	stage.close();

    }

    @FXML
    void click_send(ActionEvent event) {
    	Stage stage = (Stage) ta.getScene().getWindow();
    	message.setMessage_content(ta.getText());
    	
    	
    	int chk ; 
		try {
			chk = service.insertMessage(message);
			if(chk>0) alert("메시지 전송 완료");
			else alert("메시지 전송 실패");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	stage.close();
    }
    
    private void alert(String string) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText(string);
		alert.showAndWait();
		
	} 
    
    IBoardService service ;
    @FXML
    void initialize() {
        assert ta != null : "fx:id=\"ta\" was not injected: check your FXML file 'MessageReply.fxml'.";
        
        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IBoardService) reg.lookup("boardService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("board service 가져오기 실패");
			e.printStackTrace();
		}
        ta.setWrapText(true);
        
    }
    
    public void setMsg(MessageVO msg) {
    	message=msg;
    }
}
