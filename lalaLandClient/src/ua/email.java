package ua;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;



public class email {

   
   
   public static void sendPDFMail(String mail) throws EmailException {
	 
      try {

         // 첨부파일 만들기
         EmailAttachment attachment = new EmailAttachment();

         // 보낼 파일 경로 설정
         attachment.setPath("D:/D_Other/MyQRCode.png");

         // 파일이 첨부되어 있는지 확인
         attachment.setDescription(EmailAttachment.ATTACHMENT);

         // 첨부파일 설명
         attachment.setDescription("놀이기구 예약 QR코드");

         // 첨부파일 이름 지정
         attachment.setName("MyQRCode.png");

         // 전자메일 메세지를 만듭니다.
         MultiPartEmail email = new MultiPartEmail();

         // 메일 보내기
         email.setHostName("smtp.naver.com");
         email.setSmtpPort(587);
         email.setAuthenticator(new DefaultAuthenticator("govl327", "ehowlrhrl3"));
         email.setSSLOnConnect(true);
         email.addTo(mail);
         email.setFrom("govl327@naver.com");
         email.setCharset("euc-kr");
         email.setSubject("놀이기구 예약 QR코드");
         email.setMsg("고객님께서 예약하신 놀이기구의 FREE PASS QR코드입니다.");
         email.setMsg("항상 라라랜드를 사용해주셔서 감사합니다.");
         email.setMsg("앞으로도 많은 이용부탁드립니다. 오늘도 즐거운 하루 되세요!");

         // 파일 첨부
         email.attach(attachment);
         // 메일보내기
         email.send();
         
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

}