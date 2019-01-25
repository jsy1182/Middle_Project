package member.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ILalaLandMemberService;
import vo.MemberVO;

public class SearchPassController {

	public ILalaLandMemberService service;

	private MemberVO memVo;

	private String strId;

	private String strEm;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button ok_btn;

	@FXML
	private TextField id;

	@FXML
	private TextField mail;

	@FXML
	private Button can_btn;

	@FXML
	void canBtn(ActionEvent event) {
		Stage stage = (Stage) id.getScene().getWindow();
		stage.close();

	}

	@FXML
	void okBtn(ActionEvent event) throws IOException {

		if (id.getText().isEmpty()) {
			alert("WARMING", "아이디를 입력해주세요");
			id.requestFocus();
			return;
		}
		if (mail.getText().isEmpty()) {
			alert("WARMING", "이메일을 작성해 주세요");
			mail.requestFocus();
			return;

		}

		String Id = id.getText();
		Map<String, String> searchpass = new HashMap<>();
		searchpass.put("mem_id", id.getText());
		searchpass.put("mem_mail", mail.getText());

		memVo = service.searchPass(searchpass);

		if (memVo != null) {
			Stage stage = (Stage) ok_btn.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/SearchPassWordScene2.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);

			stage.setTitle("비밀번호 전송");

			stage.setScene(scene);
			stage.show();

			Random rnd = new Random();
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < 8; i++) {
				if (rnd.nextBoolean()) {
					buf.append((char) ((int) (rnd.nextInt(26)) + 97));
				} else {
					buf.append((rnd.nextInt(9)));
				}
			}

			memVo.setMem_pass(buf.toString());
			int chk = 0;

			chk = service.changePass(memVo);
			if (chk > 0) {
//				alert(null, "update 성공");
			}
			else {
				alert(null, "update 실패");
				
			}

			// 이메일
			boolean check = false;

			Pattern p = Pattern.compile("(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+");

			Matcher match = p.matcher(mail.getText());

			if (match.matches()) {
				check = true;
			} else {
				check = false;
			}

			if (check) {

				final String user = "didtldjs1234@naver.com"; // 발신자의 이메일 아이디를 입력
				final String password = "diddiddid111"; // 발신자 이메일의 패스워드를 입력

				// Recipient's email ID needs to be mentioned.
				String to = mail.getText();

				// Assuming you are sending email from localhost

				// Get system properties
				Properties properties = new Properties();
				properties.put("mail.smtp.host", "smtp.naver.com");
				properties.put("mail.smtp.port", 465);
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.ssl.enable", "true");

				// Setup mail server

				// Get the default Session object.
				Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});

				try {
					// Create a default MimeMessage object.
					MimeMessage message = new MimeMessage(session);

					// Set From: header field of the header.
					message.setFrom(new InternetAddress(user));

					// Set To: header field of the header.
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail.getText()));

					// Set Subject: header field
					message.setSubject("라라랜드 임시 비밀번호입니다");

//		    			 Now set the actual message
					message.setText("인증 번호는 : " + buf.toString() + "입니다");

					// Send message
					Transport.send(message);
					alert(null, "메일에서 임시 비밀번호를 확인해 주세요~");

				} catch (MessagingException mex) {
					mex.printStackTrace();
				}

			} else {
				alert("WARNING", "이메일 형식에 맞게 작성해 주세요~");
				return;
			}

		} else {

			Stage stage = (Stage) ok_btn.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/SearchPassWordScene3.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);

			stage.setTitle("회원정보를 찾지 못했습니다.");
			stage.setScene(scene);
			stage.show();
		}
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
		assert ok_btn != null : "fx:id=\"ok_btn\" was not injected: check your FXML file 'SearchPassWordScene.fxml'.";
		assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'SearchPassWordScene.fxml'.";
		assert mail != null : "fx:id=\"mail\" was not injected: check your FXML file 'SearchPassWordScene.fxml'.";
		assert can_btn != null : "fx:id=\"can_btn\" was not injected: check your FXML file 'SearchPassWordScene.fxml'.";

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (ILalaLandMemberService) reg.lookup("memberService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("member service 가져오기 실패");
			e.printStackTrace();
		}
	}
}
