package member.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.ILalaLandMemberService;
import vo.MemberVO;

public class SearchIDController {

	private MemberVO memVo;

	public ILalaLandMemberService service;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button ok_btn;

	@FXML
	private TextField name;

	@FXML
	private TextField email;

	@FXML
	private Button can_btn;

	@FXML
	void canBtn(ActionEvent event) {
		Stage stage = (Stage) email.getScene().getWindow();
		stage.close();

	}

	@FXML
	void okBtn(ActionEvent event) throws IOException {
		if (name.getText().isEmpty()) {
			alert("WARMING", "이름을 입력해 주세요");
			name.requestFocus();
			return;
		}
		if (email.getText().isEmpty()) {
			alert("WARMING", "이메일을 입력해 주세요");
			email.requestFocus();
			return;
		}

		// 이메일
		boolean check = false;

		Pattern p = Pattern.compile("(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+");

		Matcher match = p.matcher(email.getText());

		if (match.matches()) {
			check = true;
		} else {
			check = false;
		}
		
		if (check) {
			Map<String, String> searchID = new HashMap<>();
			searchID.put("mem_name", name.getText());
			searchID.put("mem_mail", email.getText());

			memVo = service.searchId(searchID);

			System.out.println(memVo);
			if (memVo != null) {
				Stage stage = (Stage) ok_btn.getScene().getWindow();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/SearchIDScene2.fxml"));
				Parent root = loader.load();
				
				
				SearchID2Controller controller = loader.getController();
				Scene scene = new Scene(root);
				
				String memberId = memVo.getMem_id();
				controller.setString(memberId);
				controller.settingText();
				
				stage.setScene(scene);
				stage.show();

			} else {

				Stage stage = (Stage) ok_btn.getScene().getWindow();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/SearchIDScene3.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);

				stage.setTitle("아이디 찾지 못했습니다.");
				stage.setScene(scene);
				stage.show();
			}
		}else {
			alert(null,"이메일 형식에 맞게 작성해 주세요");
		}

	}

	public void setMemVo(MemberVO memVo) {
		this.memVo = memVo;
	}

	public void alert(String header, String msg) {
		Alert alert = new Alert(AlertType.WARNING);

		alert.setTitle("WARNING");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}

	@FXML
	void initialize() {
		assert ok_btn != null : "fx:id=\"ok_btn\" was not injected: check your FXML file 'SearchIDScene.fxml'.";
		assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'SearchIDScene.fxml'.";
		assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'SearchIDScene.fxml'.";
		assert can_btn != null : "fx:id=\"can_btn\" was not injected: check your FXML file 'SearchIDScene.fxml'.";

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (ILalaLandMemberService) reg.lookup("memberService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("member service 가져오기 실패");
			e.printStackTrace();
		}

		
	}
}
