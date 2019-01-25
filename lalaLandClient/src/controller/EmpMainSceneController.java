








package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import vo.EmpVO;

public class EmpMainSceneController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label logo;
    
    EmpVO emp ;

	@FXML
	void clcik_QA(ActionEvent event) {
		Stage stage = (Stage) logo.getScene().getWindow();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardQAEmp.fxml"));

		Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root);
//
//			Scene scene = new Scene(root);
//			stage.setScene(scene);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void click_animal(ActionEvent event) {
		
		if(!emp.getEmp_iden().equals("동물원")) {
			alert("권한이 없습니다.");
			return;
		}
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/zooEmpScene.fxml"));

			Parent root;

			root = loader.load();
			anchorPane.getChildren().setAll(root);
			/*
			 * Scene scene = new Scene(root); stage.setScene(scene);
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//편의시설 관리
	@FXML
	void click_con(ActionEvent event) {
		if(!emp.getEmp_iden().equals("편의시설")) {
			alert("권한이 없습니다.");
			return;
		}

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ConvEmpMain.fxml"));
        Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root);
//
//	        Scene addScene = new Scene(addRoot);
//	        stage.setScene(addScene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void click_event(ActionEvent event) {

	}

	@FXML
	void click_lalaLand(MouseEvent event) {
		Stage stage = (Stage) logo.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/EmpMainScene.fxml"));
		Parent root;
		try {
			root = loader.load();

			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_logout(ActionEvent event) {
		
		Stage stage = (Stage) logo.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/fxml/loginscene.fxml"));
        Parent addRoot;
		try {
			addRoot = loader.load();
	        Scene addScene = new Scene(addRoot);
	        stage.setScene(addScene);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_message(MouseEvent event) {
		Stage stage = new Stage();
		try {
			Parent root;

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/message.fxml"));

			root = loader.load();

			Scene scene = new Scene(root);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// stage.initStyle(StageStyle.TRANSPARENT);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();

	}

	@FXML
	void click_mine(ActionEvent event) {
		Stage stage = (Stage) logo.getScene().getWindow();
	       FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/fxml/empMyInfo.fxml"));

	       Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root);

//			Scene scene = new Scene(root);
//			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	       


	}

	@FXML
	void click_notice(ActionEvent event) {

		Stage stage = (Stage) logo.getScene().getWindow();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardEmpMain.fxml"));

		Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root);
//			Scene scene = new Scene(root);
//			stage.setScene(scene);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void click_ride(ActionEvent event) {
		if(!emp.getEmp_iden().equals("놀이공원")) {
			alert("권한이 없습니다.");
			return;
		}
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/rideEmpScene.fxml"));

			Parent root;

			root = loader.load();
			anchorPane.getChildren().setAll(root);
			/*
			 * Scene scene = new Scene(root); stage.setScene(scene);
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void initialize() throws IOException {
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'EmpMainScene.fxml'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file 'EmpMainScene.fxml'.";
        
		CurrentLoginPerson.note.stop();
		

		/**
		 * 명언 추가/그래프
		 * @author 류주완
		 * 
		 */
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/wise_saying/wiseSaying.fxml"));
		Parent addRoot = loader.load();
		anchorPane.getChildren().setAll(addRoot);
		
		emp = CurrentLoginPerson.CurrentEmp;

	}
	private void alert(String string) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText(string);
		alert.showAndWait();

	}
}
