package controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import service.IBoardService;

public class AdminMainSceneController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
    @FXML
    private Label label;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private Label text;
    
    /**
     * 메인 로고 텍스트 추가
     * @author 류주완
     * 2018-11-26
     * @param event
     */
    @FXML
    void settext1(MouseEvent event) {
    	text.setVisible(true);
    }

    @FXML
    void settext2(MouseEvent event) {
    	text.setVisible(false);
    }

	@FXML
	void click_EMPList(ActionEvent event) {

		
		 //직원 리스트 확인
	       Stage stage = (Stage) label.getScene().getWindow();
	       FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/fxml/empList.fxml"));
	       
	       Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root); 
//			Scene scene = new Scene(root);
//			
//			stage.setScene(scene);
//			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	@FXML
	void click_ManageEvent(ActionEvent event) {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/event/fxml/eventScene2.fxml"));
	       
	       Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 *Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/event/fxml/eventScene2.fxml"));
		
		Parent root ;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 */
	}

	@FXML
	void click_ManageSale(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/chart/ChartMain.fxml"));
	       
	       Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root); 
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    @FXML
    void click_viewBuy(ActionEvent event) {
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("/buy/AdminViewBuy.fxml"));
	       
	       Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root); 
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void click_viewTicket(ActionEvent event) {
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("/buy/AdminViewTicket.fxml"));
	       
	       Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root); 
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	@FXML
	void click_Member(ActionEvent event) {
		 Stage stage = (Stage) label.getScene().getWindow();
	       FXMLLoader loader = new FXMLLoader(getClass().getResource("../member/fxml/memberList.fxml"));
	       
	       Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root); 
//
//			Scene scene = new Scene(root);
//			
//			stage.setScene(scene);
//			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	@FXML
	void click_QA(ActionEvent event) {
		Stage stage = (Stage)label.getScene().getWindow();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardQAAdmin.fxml"));

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
	

	/*@FXML
	void click_addEMP(ActionEvent event) {
		  // 직원 추가
	       Stage stage = new Stage();
	       FXMLLoader loader = new FXMLLoader(getClass().getResource("../member/fxml/EmpAdd.fxml"));
	       
	       Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}*/

	@FXML
	void click_lalaLand(MouseEvent event) {
		Stage stage = (Stage) label.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/AdminMainScene.fxml"));
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
		Stage stage = (Stage) label.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/fxml/loginscene.fxml"));
        Parent root;
		try {
			root = loader.load();

	        Scene addScene = new Scene(root);
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
	void click_notice(ActionEvent event) {
		Stage stage = (Stage)label.getScene().getWindow();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardAdminMain.fxml"));

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
	void click_voice(MouseEvent event) {
		Stage stage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Board/fxml/Voice.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
	}

	IBoardService service;

	@FXML
	void initialize() throws IOException {
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'AdminMainScene.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'AdminMainScene.fxml'.";

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IBoardService) reg.lookup("boardService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("board service 가져오기 실패");
			e.printStackTrace();
		}
		
		CurrentLoginPerson.note.stop();
		/**
		 * 명언 추가/그래프
		 * @author 류주완
		 * 
		 */
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/wise_saying/wiseSaying.fxml"));
		Parent addRoot = loader.load();
		anchorPane.getChildren().setAll(addRoot);
		
	}
}
