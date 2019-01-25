package member.controller;

import java.awt.List;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import service.ILalaLandMemberService;
import vo.EmpVO;
import vo.MemberVO;

public class EmpAddController {

	public ILalaLandMemberService service;

	private String str;
	MemberVO mem;

	final Font font = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 13);

	@FXML
	private Label boon_text;

	@FXML
	private Label bir_text;

	@FXML
	private Label emp_text;

	@FXML
	private Label tel_text;

	@FXML
	private Label mail_text;

	@FXML
	private Label pass_text;

	@FXML
	private Label passOk_text;

	@FXML
	private Label id_text;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField id;

	@FXML
	private Button ok_btn;

	@FXML
	private Button can_btn;

	@FXML
	private Button overlap_btn;

	@FXML
	private PasswordField pass;

	@FXML
	private PasswordField passOk;

	@FXML
	private TextField tel;

	@FXML
	private TextField bir;

	@FXML
	private TextField mail;

	@FXML
	private ComboBox<String> iden;

	@FXML
	void canBtn(ActionEvent event) {

		Stage stage = (Stage) ok_btn.getScene().getWindow();
    	stage.close();
	}

	@FXML
	void idenComboBox(ActionEvent event) {

		
	}

	@FXML
	void oberlapBtn(ActionEvent event) throws RemoteException {

		str = id.getText();
		if (id.getText().isEmpty()) {
			alert(null, "ID를 입력하세요");
			id.requestFocus();
			return;

		}

		int cnt = service.getCountEmp(str);

		if (cnt > 0) {
			alert(null, id.getText() + "는 이미 있는 직원ID입니다.");
		} else {
			alert(null, id.getText() + "는 사용하실수 있는 직원ID입니다.");
		}

	}

	@FXML
	void okBtn(ActionEvent event) throws RemoteException {

		EmpVO emp = new EmpVO();

		if (id.getText().isEmpty()) {
			alert(null, "id를 입력해 주세요");
			id.requestFocus();
			return;
		}

		if (pass.getText().isEmpty()) {
			alert(null, "비밀번호를 입력해주세요");
			pass.requestFocus();
			return;

		}

		if (passOk.getText().isEmpty()) {
			alert(null, "비밀번호확인을 입력해주세요");
			pass.requestFocus();
			return;
		}

		if (bir.getText().isEmpty()) {
			alert(null, "생일을 입력해주세요");
			bir.requestFocus();
			return;
		}

		if (tel.getText().isEmpty()) {
			alert(null, "전화번호를 입력해주세요");
			return;
		}

		if (iden.getSelectionModel().isSelected(0)) {
			alert(null, "직원 분류를 선택해주세요");
			iden.requestFocus();
			return;
		}
		// 비밀번호 일치 검사
		if (!(pass.getText().equals(passOk.getText()))) {
			alert("WARNING", "비밀번호를 확인해 주세요");
			pass.requestFocus();
			return;
		}

		int cnt = service.getCountEmp(str);
		if (cnt > 0) {
			alert(null, id.getText() + "아이디 중복 확인을 해주세요.");
		} else {

			// 생일정규식
			boolean check = false;

			Pattern p = Pattern.compile("^[1-2]{1}[0-9]{3}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}$");

			Matcher match = p.matcher(bir.getText());

			if (match.matches()) {
				check = true;
			} else {
				check = false;
			}

			if (check) {
				emp.setEmp_bir(bir.getText());
			} else {
				alert("WARNING", "yyyy/mm/dd 에 맞게 작성해주세요");
				return;
			}

			//핸드폰 정규식
			
			boolean check3 = false;

			Pattern p3 = Pattern.compile("^\\d{3}\\d{3,4}\\d{4}$");
			
			Matcher match3 = p3.matcher(tel.getText());
			
			if(match3.matches()) {
				check3 = true;
			}else {
				check3 = false;
				
			}if(check3) {
//				emp.setEmp_tel(tel.getText());
			}else {
				alert("WARNING","핸드폰 번호 형식에 맞게 작성해 주세요");
				return;
			}

			// 이메일
			boolean check2 = false;

			Pattern p2 = Pattern.compile("(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+");

			Matcher match2 = p2.matcher(mail.getText());

			if (match2.matches()) {
				check2 = true;
			} else {
				check2 = false;
			}
			if (check2) {
			} else {
				alert("WARNING", "이메일 형식에 맞게 작성해 주세요~");
				return;
			}
			

			emp.setEmp_id(id.getText());
			emp.setEmp_iden(iden.getSelectionModel().getSelectedItem());
			emp.setEmp_mail(mail.getText());
			emp.setEmp_pass(pass.getText());
			emp.setEmp_tel(tel.getText());

			int cnt2 = service.insertEmp(emp);

			if (cnt2 == 1) {
				alert(null, "직원이 정상적으로 추가 되었습니다.");

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
					message.setSubject("라라랜드 직원이 되신걸 축하 드립니다.");

//    			 Now set the actual message
					message.setText("당신의 직원 번호는: " + id.getText() + "입니다 + " + "\n" + "직원의 비밀 번호는 " + pass.getText());

					// Send message
					Transport.send(message);

				} catch (MessagingException mex) {
					mex.printStackTrace();
				}

				id.clear();
				mail.clear();
				pass.clear();
				tel.clear();
				Stage stage = (Stage) id.getScene().getWindow();
				stage.close();
			} else {
				alert("warning", "직원 추가가 되지 않았습니다.");
			}
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
		assert id_text != null : "fx:id=\"id_text\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert pass_text != null : "fx:id=\"pass_text\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert passOk_text != null : "fx:id=\"passOk_text\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert passOk != null : "fx:id=\"passOk\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert tel_text != null : "fx:id=\"tel_text\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert tel != null : "fx:id=\"tel\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert bir != null : "fx:id=\"bir\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert bir_text != null : "fx:id=\"bir_text\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert boon_text != null : "fx:id=\"boon_text\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert iden != null : "fx:id=\"iden\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert mail_text != null : "fx:id=\"mail_text\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert mail != null : "fx:id=\"mail\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert ok_btn != null : "fx:id=\"ok_btn\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert can_btn != null : "fx:id=\"can_btn\" was not injected: check your FXML file 'EmpAdd.fxml'.";
		assert overlap_btn != null : "fx:id=\"overlap_btn\" was not injected: check your FXML file 'EmpAdd.fxml'.";

		bir_text.setFont(font);
		boon_text.setFont(font);
		tel_text.setFont(font);
		mail_text.setFont(font);
		pass_text.setFont(font);
		passOk_text.setFont(font);
		id_text.setFont(font);

		id.setFont(font);
		pass.setFont(font);
		passOk.setFont(font);
		tel.setFont(font);
		bir.setFont(font);
		mail.setFont(font);
		ok_btn.setFont(font);
		can_btn.setFont(font);
		overlap_btn.setFont(font);

		iden.getItems().add("분류선택");
		iden.getItems().add("놀이공원");
		iden.getItems().add("동물원");
		iden.getItems().add("편의시설");

		iden.getSelectionModel().selectFirst();

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (ILalaLandMemberService) reg.lookup("memberService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("member service 가져오기 실패");
			e.printStackTrace();
		}
	}
}
