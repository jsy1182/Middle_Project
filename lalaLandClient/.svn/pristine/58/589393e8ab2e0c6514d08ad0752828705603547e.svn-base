package member.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mail {

	public static void main(String[] args) {
		final String user = "didtldjs1234@naver.com"; // 발신자의 이메일 아이디를 입력
		final String password = "diddiddid111"; // 발신자 이메일의 패스워드를 입력

		// Recipient's email ID needs to be mentioned.
		String to = "wp01052@naver.com";

		int pinNum = ((int)(Math.random()*9999)+1000);
		

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
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("wp01052@naver.com"));

			// Set Subject: header field
			message.setSubject("라라랜드 회원 가입에 감사드립니다!!");

//			 Now set the actual message
			message.setText("인증 번호는 : " + pinNum + "입니다");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
