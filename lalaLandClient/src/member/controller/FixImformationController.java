package member.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import service.ILalaLandMemberService;
import vo.MemberVO;

public class FixImformationController {

	MemberVO memVo;

	String temp = null;

	final Font font = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 13);

	@FXML
	private Label pass_text;

	@FXML
	private Label passOk_text;

	@FXML
	private Label mail_text;

	@FXML
	private Label tel_text;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button ok_btn;

	@FXML
	private Button can_btn;

	@FXML
	private PasswordField pass;

	@FXML
	private PasswordField passOk;

	@FXML
	private TextField tel;

	@FXML
	private TextField mail;

	@FXML
	void canBtn(ActionEvent event) {
		Stage stage = (Stage) tel.getScene().getWindow();
		stage.close();
	}

	@FXML
	void okBtn(ActionEvent event) throws IOException {
		String str2;
		// 핸드폰 번호 정규식
		boolean check2 = false;

		Pattern p2 = Pattern.compile("^\\d{3}-\\d{3,4}-\\d{4}$");

		Matcher match2 = p2.matcher(tel.getText());

		if (match2.matches()) {
			check2 = true;
		} else {
			check2 = false;
		}
		if (check2) {
			memVo.setMem_tel(tel.getText());
		} else {
			alert("WARNING", "핸드폰 번호 형식에 맞게 작성해 주세요");
			return;
		}
		// 이메일 중복 확인
		str2 = mail.getText();
		if (str2 != temp) {

			int cnt = service.getCounMemberEamil(str2);

			if (cnt > 0) {
				alert(null, "이미 존재하는 email입니다.");
				return;
			} else {
				memVo.setMem_mail(str2);
				// 이메일
				boolean check = false;

				Pattern p = Pattern.compile("(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+");

				Matcher match = p.matcher(mail.getText());

				if (match.matches()) {
					check = true;
				} else {
					check = false;
					alert("WARNING", "이메일 형식에 맞게 작성해 주세요~");
					return;
				}
			}

		}

		// 비밀번호 일치 검사
		if (!(pass.getText().equals(passOk.getText()))) {
			alert("WARNING", "비밀번호를 확인해 주세요");
			pass.requestFocus();
			return;

		} else {

			int chk;
			try {
				chk = service.fixInformation(memVo);
				if (chk > 0)
					alert(null, "update 성공");
				else
					alert(null, "update 실패");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			Stage stage = (Stage) tel.getScene().getWindow();
			stage.close();

		}

	}

	public void alert(String header, String msg) {
		Alert alert = new Alert(AlertType.WARNING);

		alert.setTitle("WARNING");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}

	ILalaLandMemberService service;

	@FXML
	void initialize() {
		assert pass_text != null : "fx:id=\"pass_text\" was not injected: check your FXML file 'FixImformation.fxml'.";
		assert passOk_text != null : "fx:id=\"passOk_text\" was not injected: check your FXML file 'FixImformation.fxml'.";
		assert ok_btn != null : "fx:id=\"ok_btn\" was not injected: check your FXML file 'FixImformation.fxml'.";
		assert can_btn != null : "fx:id=\"can_btn\" was not injected: check your FXML file 'FixImformation.fxml'.";
		assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'FixImformation.fxml'.";
		assert passOk != null : "fx:id=\"passOk\" was not injected: check your FXML file 'FixImformation.fxml'.";
		assert tel_text != null : "fx:id=\"tel_text\" was not injected: check your FXML file 'FixImformation.fxml'.";
		assert tel != null : "fx:id=\"tel\" was not injected: check your FXML file 'FixImformation.fxml'.";
		assert mail_text != null : "fx:id=\"mail_text\" was not injected: check your FXML file 'FixImformation.fxml'.";
		assert mail != null : "fx:id=\"mail\" was not injected: check your FXML file 'FixImformation.fxml'.";

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (ILalaLandMemberService) reg.lookup("memberService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("member service 가져오기 실패");
			e.printStackTrace();
		}

		pass_text.setFont(font);
		passOk_text.setFont(font);
		ok_btn.setFont(font);
		can_btn.setFont(font);
		tel_text.setFont(font);
		pass.setFont(font);
		passOk.setFont(font);
		tel.setFont(font);
		mail_text.setFont(font);
		mail.setFont(font);

		memVo = CurrentLoginPerson.CurrentMember;
		mail.setText(memVo.getMem_mail());
		tel.setText(memVo.getMem_tel());
		pass.setText(memVo.getMem_pass());

		memVo.setMem_mail(mail.getText());
		memVo.setMem_pass(pass.getText());
		memVo.setMem_tel(tel.getText());

		temp = mail.getText();

	}

}
