package main;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.DataFormat;
import javafx.stage.Stage;

public class LalaLandClientMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/member/fxml/loginscene.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			CurrentLoginPerson.hostServices=getHostServices();
			primaryStage.setTitle("라라랜드");
			primaryStage.show();
		} catch (IOException e) {
			System.out.println("fxml 연결 실패");
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
