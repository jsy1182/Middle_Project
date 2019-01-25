package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import vo.MemberVO;

public class EntranceSceneController {
	MemberVO member ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn;

    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    void click_ok(ActionEvent event) {
    	Stage stage = (Stage) label.getScene().getWindow();
    	stage.close();

    }

    @FXML
    void initialize() {
    	assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'EntranceScene.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'EntranceScene.fxml'.";
        assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'EntranceScene.fxml'.";
        member =CurrentLoginPerson.CurrentMember;
        label.setText(member.getMem_name());
        label.setOnKeyPressed(e->KeyEvent(e));
        
        final Font font1 = Font.loadFont(getClass().getResourceAsStream("/font/HoonWhitecatR.ttf"), 30);
        final Font font = Font.loadFont(getClass().getResourceAsStream("/font/HoonWhitecatR.ttf"), 20);
        label.setFont(font1);
        label1.setFont(font1);
        btn.setFont(font);
    }
	private void KeyEvent(KeyEvent e) {
		if(e.getCode()==KeyCode.ENTER) {
			Stage st = (Stage) label.getScene().getWindow();
	    	st.close();
		}
	}
}
