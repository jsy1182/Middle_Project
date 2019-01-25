package game.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MiniGameMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
            Parent root = FXMLLoader.load(getClass().getResource("GameScene.fxml")); 
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("출석체크");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public static void main(String[] args) {
		launch(args);
	}
}
