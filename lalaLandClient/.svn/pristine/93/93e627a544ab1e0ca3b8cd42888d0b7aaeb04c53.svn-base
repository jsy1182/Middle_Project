package controller;



import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import service.ILalaLandItemService;
import vo.ItemVO;
import vo.Item_buyVO;

public class MailItemBuy {
	public static String itembuy_id;
	public static String item_id;
	public static String mem_id;
	public static String itembuy_date;
	public static String itembuy_refend;
	public static int itembuy_sales;
   
   
   public static String user_id;
   public static String user_mail;
   
   
   Item_buyVO itemBuy=new Item_buyVO();
   public static ILalaLandItemService service;
   static String item_name="";


   public MailItemBuy(Item_buyVO vo, String user_mail) {
      
      this.user_mail = user_mail;
      
      this.itembuy_id=vo.getItemBuy_id();
      this.item_id = vo.getItem_id();
      this.mem_id = vo.getMem_id();
      this.itembuy_date = vo.getItemBuy_date();
      this.itembuy_sales = vo.getItemBuy_sales();
      
      try {
          Registry reg = LocateRegistry.getRegistry("localhost", 1088);
          service = (ILalaLandItemService) reg.lookup("itemService");
       } catch (RemoteException | NotBoundException e) {
          System.out.println("실패");
          e.printStackTrace();
       }
   }

   public static void sendPDFMail() throws EmailException, RemoteException {
	   List<ItemVO> item_n=service.selectItemAll();
	   for(int i=0;i<item_n.size();i++) {
		   if(item_n.get(i).getItem_id().equals(item_id)) {
			   item_name=item_n.get(i).getItem_name();
		   }
	   }
	   
   
	   
      try {

         // 첨부파일 만들기
         EmailAttachment attachment = new EmailAttachment();

         // 보낼 파일 경로 설정
         attachment.setPath("d:/" + itembuy_id + ".pdf");

         // 파일이 첨부되어 있는지 확인
         attachment.setDescription(EmailAttachment.ATTACHMENT);

         // 첨부파일 설명
         attachment.setDescription("LALALAND 아이템 구매 영수증");

         // 첨부파일 이름 지정
         attachment.setName(itembuy_id + ".pdf");

         // 전자메일 메세지를 만듭니다.
         MultiPartEmail email = new MultiPartEmail();

         // 메일 보내기
         email.setHostName("smtp.naver.com");
         email.setSmtpPort(465);
         email.setAuthenticator(new DefaultAuthenticator("gogoxotj", "xoxldrns49"));
         email.setSSLOnConnect(true);
         email.addTo(user_mail);
         email.setFrom("gogoxotj@naver.com");
         email.setCharset("euc-kr");
         email.setSubject("[LALALAND] "+itembuy_date+"에 구입한  아이템 영수증");
         email.setMsg(mem_id+"님 께서 "+itembuy_date+" 에 구매한 "+item_name+"에 대한 구입 영수증을 보내드립니다.");
         email.setMsg("LALALAND에서 즐거운 시간 보내시길 바랍니다. 이용해 주셔서 감사드립니다.");
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
