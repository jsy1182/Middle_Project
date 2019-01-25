package Board.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
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

public class ViewBoardAdminController {
	private BoardVO board;

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private AnchorPane anchoPane;

    @FXML
    private URL location;

    @FXML
    private TextField tf_title;

    @FXML
    private Label la_date;

    @FXML
    private TextArea ta;

    @FXML
    private Button btn_goback;

    @FXML
    void click_delete(ActionEvent event) {
    	int chk ;
    	try {
			chk = service.deleteBoard(board.getBo_id());
			if(chk>0) alert("공지사항 삭제 성공");
			else alert("공지사항 삭제 실패");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
    
    private void alert(String string) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText(string);
		alert.showAndWait();

	}


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
    void click_update(ActionEvent event) {
    	board.setBo_content(ta.getText());
    	board.setBo_title(tf_title.getText());
    	int chk;
    	try {
			chk = service.updateBoard(board);
			if(chk>0)alert("수정 성공");
			else alert("수정 실패");
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


    
    IBoardService service ;
    
    @FXML
    void initialize() {
        assert tf_title != null : "fx:id=\"tf_title\" was not injected: check your FXML file 'ViewBoardAdmin.fxml'.";
        assert la_date != null : "fx:id=\"la_date\" was not injected: check your FXML file 'ViewBoardAdmin.fxml'.";
        assert ta != null : "fx:id=\"ta\" was not injected: check your FXML file 'ViewBoardAdmin.fxml'.";
        assert btn_goback != null : "fx:id=\"btn_goback\" was not injected: check your FXML file 'ViewBoardAdmin.fxml'.";
        assert anchoPane != null : "fx:id=\"anchoPane\" was not injected: check your FXML file 'ViewBoardAdmin.fxml'.";

        
        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IBoardService) reg.lookup("boardService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("board service 가져오기 실패");
			e.printStackTrace();
		}
        ta.setWrapText(true);

    }
    public void setBoard(BoardVO board) {
    	this.board = board;
    }
    
    public void setTextField() {
    	tf_title.setText(board.getBo_title());
    	la_date.setText(board.getBo_date()); 
    	ta.setText(board.getBo_content());
    	
    }
}
