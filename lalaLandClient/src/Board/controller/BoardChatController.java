package Board.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.CurrentLoginPerson;
import service.IBoardService;
import vo.AdminVO;
import vo.EmpVO;
import vo.MemberVO;
import vo.VoiceVO;

public class BoardChatController {
	MemberVO member;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView img;

	@FXML
	private Button btn_chatting;

	@FXML
	void hover(MouseEvent event) {
		Image imgg = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/봇1.png");
		img.setImage(imgg);
	}

	@FXML
	void hoverOut(MouseEvent event) {
		Image imgg = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/채팅.jpg");
		img.setImage(imgg);

	}

	@FXML
	void click_chatting(ActionEvent event) {
		Stage stage = new Stage();
		try {
			Parent root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/chatting.fxml"));
			root = loader.load();
			ChattingController controller = loader.getController();
			controller.setting();
			Scene scene = new Scene(root);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();

	}

	@FXML
	void click_image(MouseEvent event) {
		TextInputDialog prompt = new TextInputDialog("감사합니다.");
		prompt.setTitle("고객 소리함");
		prompt.setHeaderText(null);
		prompt.setContentText("언제나 고객의 소리를 듣겠습니다.");

		Optional<String> result = prompt.showAndWait();

		String strResult = null;
		if (result.isPresent()) {
			strResult = result.get();
		} else {
			alert("취소되었습니다.");
			return;
		}
		VoiceVO voice = new VoiceVO();
		voice.setVoice_content(strResult);
		int chk;

		try {
			chk = service.insertVoice(voice);
			if (chk > 0)
				alert("소중한 의견과 관심 항상 감사합니다. ");
			else
				alert("다시 한번 시도해주시면 감사하겠습니다.");
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	private void alert(String string) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText(string);
		alert.showAndWait();

	}

	IBoardService service;

	@FXML
	void initialize() {
		assert btn_chatting != null : "fx:id=\"btn_chatting\" was not injected: check your FXML file 'BoardChat.fxml'.";
		assert img != null : "fx:id=\"img\" was not injected: check your FXML file 'BoardChat.fxml'.";

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IBoardService) reg.lookup("boardService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("board service 가져오기 실패");
			e.printStackTrace();
		}

		member = CurrentLoginPerson.CurrentMember;

	}
}
