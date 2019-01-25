package member.controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
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

import org.apache.poi.ss.formula.functions.Match;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import service.ILalaLandMemberService;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import vo.MemberVO;

public class signUpSceneController {

	public ILalaLandMemberService service;

	List<MemberVO> list;

	ObservableList<MemberVO> data;

	private String str;

	private String str2;

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
	private Button pinok_btn;

	@FXML
	private TextField tel;

	@FXML
	private TextField name;

	@FXML
	private TextField bir;

	@FXML
	private TextField mail;

	@FXML
	private TextField pinNumber;

	@FXML
	private Button send_btn;

	@FXML
	void canBtn(ActionEvent event) {
		Stage stage = (Stage) id.getScene().getWindow();
		stage.close();

	}

	@FXML
	void oberlapBtn(ActionEvent event) throws RemoteException {

		str = id.getText();
		if (id.getText().isEmpty()) {
			alert(null, "ID를 입력하세요");
			id.requestFocus();
			return;
		}
		if(id.getText().equals("admin")) {
			alert(null,"관리자로는 회원가입 할수 없습니다.");
			return;
		}

		int cnt = service.getCountMember(str);

		if (cnt > 0) {
			alert(null, id.getText() + "는 이미 있는 ID입니다.");
		} else {
			alert(null, id.getText() + "는 사용하실수 있는 ID입니다.");
		}

	}

	String now;

	@FXML
	void okBtn(ActionEvent event) throws RemoteException {

		now = "add";

		MemberVO mem = new MemberVO();

		if (!pin) {
			alert(null, "인증번호확인을 하지않았습니다.");
			return;
		}

		if (now.equals("add")) {
			if (name.getText().isEmpty()) {
				alert("WARNING", "이름을 입력해 주세요");
				name.requestFocus();
				return;
			}

			if (tel.getText().isEmpty()) {
				alert("WARNING", "전화번호를 입력해 주세요");
				tel.requestFocus();
				return;
			}

			if (bir.getText().isEmpty()) {
				alert("WARNING", "생일을 입력해 주세요");
				bir.requestFocus();
				return;
			}

			if (mail.getText().isEmpty()) {
				alert("WARNING", "이메일을 입력해 주세요");
				mail.requestFocus();
				return;
			}

			if (pass.getText().isEmpty()) {
				alert("WARNING", "비밀번호를 입력해 주세요");
				pass.requestFocus();
				return;
			}

			// 비밀번호 일치 검사
			if (!(pass.getText().equals(passOk.getText()))) {
				alert("WARNING", "비밀번호를 확인해 주세요");
				pass.requestFocus();
				return;
			}

		}

		// 아이디 중복 체크
		int cnt2 = service.getCountMember(str);
		if (cnt2 > 0) {
			alert(null, id.getText() + "아이디 중복 확인을 해주세요.");
			id.requestFocus();
			return;
		}
		
		if(id.getText().equals("admin")) {
			alert(null,"관리자로는 회원가입 할수 없습니다.");
			return;
		}

		// 생일 정규식
		boolean check = false;

		Pattern p1 = Pattern.compile("^[1-2]{1}[0-9]{3}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}$");

		Matcher match = p1.matcher(bir.getText());

		if (match.matches()) {
			check = true;
		} else {
			check = false;
		}

		if (check) {
			mem.setMem_bir(bir.getText());
		} else {
			alert("WARNING", "yyyymmdd 에 맞게 작성해주세요");
			return;
		}


		// 핸드폰 번호 정규식
		boolean check2 = false;

		Pattern p2 = Pattern.compile("^\\d{3}-\\d{3,4}-\\d{4}$");
		
		Matcher match2 = p2.matcher(tel.getText());
		
		if(match2.matches()) {
			check2 = true;
		}else {
			check2 = false;
		}if(check2) {
			mem.setMem_tel(tel.getText());
		}else {
			alert("WARNING","핸드폰 번호 형식에 맞게 작성해 주세요");
			return;
		}


		mem.setMem_id(id.getText());
		mem.setMem_tel(tel.getText());
		mem.setMem_name(name.getText());
		mem.setMem_mail(mail.getText());
		mem.setMem_pass(pass.getText());
		mem.setMem_grade("silver");
//    	mem.setMem_bir(bir.getText());

		int cnt = service.insertMember(mem);

		if (cnt == 1) {
			alert(null, "LaLaLand에 오신걸 환영합니다!");
			Stage stage = (Stage) id.getScene().getWindow();
			stage.close();
		} else {
			alert("warning", "회원가입되지 않았습니다.");

		}
//    		id.clear();
//        	tel.clear();
//        	name.clear();
//        	bir.clear();
//        	mail.clear();
//        	pinNumber.clear();
//        	pass.clear();
//        	passOk.clear();

	}

	int pinNum = ((int) (Math.random() * 9999) + 1000);

	private boolean pin = false;

	@FXML
	void pinOkBtn(ActionEvent event) {


		//핀번호 정규식
		boolean check2 = false;

		Pattern p2 = Pattern.compile("^\\d{4,5}");
		
		Matcher match2 = p2.matcher(pinNumber.getText());
		
		if(match2.matches()) {
			check2 = true;
		}else {
			check2 = false;
		}if(check2) {
			if ((Integer.parseInt(pinNumber.getText())) == pinNum) {
				pin = true;
				alert(null,"정답입니다~");
			} else {
				alert("Warming", "인증번호를 다시 확인해 주세요");
				return;
			}
			
		}else {
			alert("WARNING","인증번호는 4~5자리 입니다");
			return;
		}
		
		

	}

	@FXML
	void sendBtn(ActionEvent event) throws RemoteException {

		// 이메일 중복 확인
		str2 = mail.getText();

		int cnt = service.getCounMemberEamil(str2);

		if (cnt > 0) {
			alert(null, "이미 존재하는 email입니다.");
		} else {
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
					message.setSubject("라라랜드 회원 가입에 감사드립니다!!");

//    			 Now set the actual message
					message.setText("인증 번호는 : " + pinNum + "입니다");

					// Send message
					Transport.send(message);
					alert(null, "메일에서 인증번호를 확인해 주세요~");

				} catch (MessagingException mex) {
					mex.printStackTrace();
				}

			} else {
				alert("WARNING", "이메일 형식에 맞게 작성해 주세요~");
				return;
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
		assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'signUpScene.fxml'.";
		assert ok_btn != null : "fx:id=\"ok_btn\" was not injected: check your FXML file 'signUpScene.fxml'.";
		assert can_btn != null : "fx:id=\"can_btn\" was not injected: check your FXML file 'signUpScene.fxml'.";
		assert overlap_btn != null : "fx:id=\"overlap_btn\" was not injected: check your FXML file 'signUpScene.fxml'.";
		assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'signUpScene.fxml'.";
		assert passOk != null : "fx:id=\"passOk\" was not injected: check your FXML file 'signUpScene.fxml'.";
		assert pinok_btn != null : "fx:id=\"pinok_btn\" was not injected: check your FXML file 'signUpScene.fxml'.";
		assert tel != null : "fx:id=\"tel\" was not injected: check your FXML file 'signUpScene.fxml'.";
		assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'signUpScene.fxml'.";
		assert bir != null : "fx:id=\"bir\" was not injected: check your FXML file 'signUpScene.fxml'.";
		assert mail != null : "fx:id=\"mail\" was not injected: check your FXML file 'signUpScene.fxml'.";
		assert pinNumber != null : "fx:id=\"pinNumber\" was not injected: check your FXML file 'signUpScene.fxml'.";
		assert send_btn != null : "fx:id=\"send_btn\" was not injected: check your FXML file 'signUpScene.fxml'.";

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (ILalaLandMemberService) reg.lookup("memberService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("member service 가져오기 실패");
			e.printStackTrace();
		}

	}
}
