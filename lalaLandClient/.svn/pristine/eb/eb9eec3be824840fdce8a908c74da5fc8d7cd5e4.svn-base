package Board.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import vo.BoardVO;

public class SecretCheckController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label label1;

	@FXML
	private Label label2;

	@FXML
	private PasswordField tf;

	@FXML
	void click_btn(ActionEvent event) {
		passwordCheck();

	}

	private void passwordCheck() {
		chk = false;

		String str = tf.getText();
		if (board.getBo_pass().equals(str)) {
			chk = true;

			Stage stage = (Stage) label1.getScene().getWindow();
			stage.close();

		} else {
			alert("비밀번호가 올바르지 않습니다.");
		}
	};

	BoardVO board = new BoardVO();
	private boolean chk;

	public boolean isChk() {
		return chk;
	}

	public void setChk(boolean chk) {
		this.chk = chk;
	}

	@FXML
	void initialize() {
		assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'secretCheck.fxml'.";
		assert label2 != null : "fx:id=\"label2\" was not injected: check your FXML file 'secretCheck.fxml'.";
		assert tf != null : "fx:id=\"tf\" was not injected: check your FXML file 'secretCheck.fxml'.";

		final Font font = Font.loadFont(getClass().getResourceAsStream("/font/HoonWhitecatR.ttf"), 20);

		label1.setFont(font);
		label2.setFont(font);

		tf.setOnKeyPressed(e -> enterkey(e));

	}

	private void enterkey(KeyEvent e) {
		if (e.getCode() == KeyCode.ENTER) {
			passwordCheck();
		}
	}

	private void alert(String msg) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText("INCORRECT !!");
		alert.setContentText(msg);
		alert.showAndWait();
	}

	public void setBoard(BoardVO board) {
		this.board = board;
	}
}
