package buy;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import vo.BuyVO;

public class Email {
	public String buy_id;
	public String buy_date;
	public int sales;
	public String ticket_id;
	public String mem_id;
	public String user_mail;
	
	public Email(BuyVO vo,String user_mail) {
		this.buy_id=vo.getBuy_id();
		this.buy_date=vo.getBuy_date();
		this.sales=vo.getSales();
		this.ticket_id=vo.getTicket_id();
		this.mem_id=vo.getMem_id();
		this.user_mail=user_mail;
	}
	
	public void sendPDFMail() throws EmailException{
		
		//  첨부파일 만들기
		EmailAttachment attachment=new EmailAttachment();
		
		// 보낼 파일 경로 설정
		attachment.setPath("D:/"+mem_id+"_"+buy_date+"Water.pdf");
		
		// 파일이 첨부되어 있는지 확인
		attachment.setDescription(EmailAttachment.ATTACHMENT);
		
		// 첨부파일 설명
		attachment.setDescription("입장권 구매 영수증");
		
		// 첨부파일 이름 지정
		attachment.setName(mem_id+"_"+buy_date+".pdf");
		
		// 전자메일 메세지를 만듭니다.
		MultiPartEmail email=new MultiPartEmail();
		email.setHostName("smtp.naver.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("wogud8383", "aa5413823"));
        email.setSSLOnConnect(true);
        email.addTo(user_mail);
        email.setFrom("wogud8383@naver.com");
        email.setCharset("euc-kr");
        email.setSubject("[LaLaLand]"+mem_id+"님께서 "+buy_date+" 구매하신 입장권 영수증입니다.");
        email.setMsg("구매자    :"+mem_id);
        email.setMsg("구매일    : "+buy_date);
        email.setMsg("결제금액 : "+sales);
        email.setMsg("앞으로도 많은 이용부탁드립니다. 오늘도 즐거운 하루 되세요!");

        // 파일 첨부
        email.attach(attachment);
        // 메일보내기
        email.send();
		
	}
	
}//end of class
