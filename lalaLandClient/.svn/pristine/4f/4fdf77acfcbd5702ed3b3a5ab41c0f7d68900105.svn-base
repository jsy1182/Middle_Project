package buy;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import main.CurrentLoginPerson;
import vo.BuyVO;
import vo.MemberVO;
/**
 * 11-23일추가
 * @author 이재형
 *
 */
public class GroupEmail {
	public String email1;
	
	public GroupEmail(String email1) {
		this.email1=email1;
	}
	
	public void sendPDFMail() throws EmailException{
		
		//  첨부파일 만들기
		EmailAttachment attachment=new EmailAttachment();
		
		// 보낼 파일 경로 설정
		attachment.setPath("D:/"+email1+"Water.pdf");
		
		// 파일이 첨부되어 있는지 확인
		attachment.setDescription(EmailAttachment.ATTACHMENT);
		
		// 첨부파일 설명
		attachment.setDescription("입장권 구매 영수증");
		
		// 첨부파일 이름 지정
		attachment.setName(email1+"groupBuy.pdf");
		
		// 전자메일 메세지를 만듭니다.
		MultiPartEmail email=new MultiPartEmail();
		email.setHostName("smtp.naver.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("wogud8383", "aa5413823"));
        email.setSSLOnConnect(true);
        email.addTo(email1);
        email.setFrom("wogud8383@naver.com");
        email.setCharset("euc-kr");
        email.setSubject("[LaLaLand] 고객님께서  구매하신 단체 입장권 영수증입니다.");
        email.setMsg("앞으로도 많은 이용부탁드립니다. 오늘도 즐거운 하루 되세요!");

        // 파일 첨부
        email.attach(attachment);
        // 메일보내기
        email.send();
		
	}
	
}//end of class
