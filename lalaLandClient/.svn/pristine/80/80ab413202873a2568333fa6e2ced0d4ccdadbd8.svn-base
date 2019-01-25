package Board.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import service.IBoardService;
import service.ILalaLandMemberService;
import vo.AdminVO;
import vo.EmpVO;
import vo.MessageVO;

public class ViewMessageController {
	EmpVO emp;
	AdminVO admin;
	MessageVO message = new MessageVO();
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label la_from;

	@FXML
	private Label la_date;

	@FXML
	private TextArea ta;

	@FXML
	private TextField tf_from;

	@FXML
	private Button button1;

	@FXML
	private Label la_to;

	@FXML
	private TextField tf_to;

	@FXML
	void click_goback(ActionEvent event) {
		Stage stage = (Stage) tf_from.getScene().getWindow();
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/Board/fxml/message.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);

	}

	String content;

	public void sendContent(String str) {
		content = str;
	}

	@FXML
	void click_button(ActionEvent event) {
		if (!button1.getText().equals("보내기")) {
			// 답장하기
			Stage stage = new Stage();
			Parent root = null;
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/MessageReply.fxml"));
				root = loader.load();
				MessageReplyController controller = loader.getController();
				message.setMessage_to(tf_from.getText());
				message.setMessage_from(tf_to.getText());
				message.setMessage_date(la_date.getText());
				message.setMessage_content(content);

				controller.setMsg(message);

				Scene scene = new Scene(root);
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {

			MessageVO message = new MessageVO();

			message.setMessage_date(la_date.getText());
			message.setMessage_content(ta.getText());

			if (emp == null) {
				message.setMessage_from(admin.getAdmin_id());
			} else {
				message.setMessage_from(emp.getEmp_id());
			}
			message.setMessage_to(tf_to.getText());

			int chk;
			try {
				chk = memService.getCountEmp(tf_to.getText());
				if (chk > 0) {
				} else if (tf_to.getText().equals("admin")) {
				} else {
					alert("존재하지 않는 아이디입니다.");
					return;
				}
				chk = service.insertMessage(message);
				if (chk > 0)
					alert("메시지 전송 완료");
				else
					alert("메시지 전송 실패");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			Stage stage = (Stage) button1.getScene().getWindow();
			stage.close();
		}

	}

	private void alert(String string) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText(string);
		alert.showAndWait();

	}

	IBoardService service;
	ILalaLandMemberService memService;

	@FXML
	void initialize() {
		assert la_from != null : "fx:id=\"la_from\" was not injected: check your FXML file 'ViewMessage.fxml'.";
		assert la_date != null : "fx:id=\"la_date\" was not injected: check your FXML file 'ViewMessage.fxml'.";
		assert ta != null : "fx:id=\"ta\" was not injected: check your FXML file 'ViewMessage.fxml'.";
		assert tf_from != null : "fx:id=\"tf_from\" was not injected: check your FXML file 'ViewMessage.fxml'.";
		assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'ViewMessage.fxml'.";
		assert la_to != null : "fx:id=\"la_to\" was not injected: check your FXML file 'ViewMessage.fxml'.";
		assert tf_to != null : "fx:id=\"tf_to\" was not injected: check your FXML file 'ViewMessage.fxml'.";

		la_date.setText(new Date().toString());

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IBoardService) reg.lookup("boardService");
			memService = (ILalaLandMemberService) reg.lookup("memberService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("service 가져오기 실패");
			e.printStackTrace();
		}
		emp = CurrentLoginPerson.CurrentEmp;
		admin = CurrentLoginPerson.CurrentAdmin;
		
		ta.setWrapText(true);

	}

	public void setMessage(MessageVO message) {
		this.message = message;

		la_date.setText(message.getMessage_date());
		tf_from.setText(message.getMessage_from());
		tf_to.setText(message.getMessage_to());
		ta.setText(message.getMessage_content());
	}

	public void setting() {
		button1.setText("보내기");
		if (emp != null) {
			tf_from.setText(emp.getEmp_id());
		} else {
			tf_from.setText(admin.getAdmin_id());
		}
		tf_from.setDisable(true);
	}

}
