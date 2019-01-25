package Board.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.IBoardService;
import vo.BoardVO;

public class NewNoticeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private AnchorPane anchoPane;

    @FXML
    private TextField tf_title;

    @FXML
    private Label la_date;

    @FXML
    private TextArea ta;

    @FXML
    private Button btn_goback;

   

    @FXML
    void click_goback(ActionEvent event) {
    	Stage stage = (Stage)btn_goback.getScene().getWindow();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardAdminMain.fxml"));

		Parent root;
		try {
			root = loader.load();
			anchoPane.getChildren().setAll(root);
//			Scene scene = new Scene(root);
//			stage.setScene(scene);

		} catch (IOException e) {
			e.printStackTrace();
		}

    }
    
    @FXML
    void click_insert(ActionEvent event) {
    	if(tf_title.getText().isEmpty()) {
    		alert("제목을 입력하세요.");
    		return;
    	}
    	if(ta.getText().isEmpty()) {
    		alert("내용을 입력하세요.");
    		return;
    	}
    	BoardVO board = new BoardVO();
    	board.setBo_title(tf_title.getText());
    	board.setBo_content(ta.getText());
    	board.setMem_id("admin");
    	int chk;
    	try {
			chk = service.insertBoard(board);
			if(chk>0) alert("게시물 등록 성공");
			else alert("게시물 등록 실패");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardAdminMain.fxml"));

		Parent root;
		try {
			root = loader.load();
			anchoPane.getChildren().setAll(root);

		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	

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
        assert tf_title != null : "fx:id=\"tf_title\" was not injected: check your FXML file 'NewNotice.fxml'.";
        assert la_date != null : "fx:id=\"la_date\" was not injected: check your FXML file 'NewNotice.fxml'.";
        assert ta != null : "fx:id=\"ta\" was not injected: check your FXML file 'NewNotice.fxml'.";
        assert btn_goback != null : "fx:id=\"btn_goback\" was not injected: check your FXML file 'NewNotice.fxml'.";
        assert anchoPane != null : "fx:id=\"anchoPane\" was not injected: check your FXML file 'ViewBoardAdmin.fxml'.";

        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IBoardService) reg.lookup("boardService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("board service 가져오기 실패");
			e.printStackTrace();
		}
        
        la_date.setText(new Date().toString());
        ta.setWrapText(true);

    }
}
