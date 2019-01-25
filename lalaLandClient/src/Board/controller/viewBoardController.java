package Board.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import vo.BoardVO;

public class viewBoardController {
	private BoardVO board;

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
    void click_animal(ActionEvent event) {

    }

    @FXML
    void click_annual(ActionEvent event) {

    }
   

    @FXML
    void click_goback(ActionEvent event) {
    	Stage stage = (Stage)btn_goback.getScene().getWindow();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardMain.fxml"));

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
    void initialize() {
        assert tf_title != null : "fx:id=\"tf_title\" was not injected: check your FXML file 'viewBoard.fxml'.";
        assert la_date != null : "fx:id=\"la_date\" was not injected: check your FXML file 'viewBoard.fxml'.";
        assert ta != null : "fx:id=\"ta\" was not injected: check your FXML file 'viewBoard.fxml'.";
        assert btn_goback != null : "fx:id=\"btn_goback\" was not injected: check your FXML file 'viewBoard.fxml'.";
        assert anchoPane != null : "fx:id=\"anchoPane\" was not injected: check your FXML file 'ViewBoardAdmin.fxml'.";

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
