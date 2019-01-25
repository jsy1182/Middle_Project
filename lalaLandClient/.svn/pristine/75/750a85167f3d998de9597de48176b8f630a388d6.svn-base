package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EntranceScene3Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView img;
    @FXML
    private Button btn;

    @FXML
    private Label label;

    @FXML
    void click_ok(ActionEvent event) {
    	Stage st = (Stage) img.getScene().getWindow();
    	st.close();
    }

    @FXML
    void initialize() {
    	 assert img != null : "fx:id=\"img\" was not injected: check your FXML file 'EntranceScene3.fxml'.";
         assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'EntranceScene3.fxml'.";
         assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'EntranceScene3.fxml'.";
        img.setOnKeyPressed(e->KeyEvent(e));
        
        final Font font1 = Font.loadFont(getClass().getResourceAsStream("/font/HoonWhitecatR.ttf"), 30);
        final Font font = Font.loadFont(getClass().getResourceAsStream("/font/HoonWhitecatR.ttf"), 20);
        label.setFont(font1);
        btn.setFont(font);

    }
	private void KeyEvent(KeyEvent e) {
		if(e.getCode()==KeyCode.ENTER) {
			Stage st = (Stage) img.getScene().getWindow();
	    	st.close();
		}
	}
}
