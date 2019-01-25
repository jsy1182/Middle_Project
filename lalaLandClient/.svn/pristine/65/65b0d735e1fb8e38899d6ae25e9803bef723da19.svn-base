package game.main;

import java.net.URL;
import java.util.ResourceBundle;

import game.contoller.memory.MemoryCardGame;
import game.contoller.roulette.HangmanMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MiniGameMainController {
	Stage stage = new Stage();
	Pane pane = new Pane();
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnMemory;

	@FXML
	private Button btnRoulette;

	@FXML
	void playMemoryGame(ActionEvent event) {
		try {
			MemoryCardGame memory = new MemoryCardGame();
			stage = new Stage();
			stage.setTitle("기억력 게임");
			memory.start(stage);
			//stage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void playRoulette(ActionEvent event) {
		try {
			HangmanMain hangman = new HangmanMain();
			stage = new Stage();
			stage.setTitle("행맨");
			hangman.start(stage);
			stage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {
		assert btnMemory != null : "fx:id=\"btnMemory\" was not injected: check your FXML file 'GameScene.fxml'.";
		assert btnRoulette != null : "fx:id=\"btnRoulette\" was not injected: check your FXML file 'GameScene.fxml'.";

	}
}
