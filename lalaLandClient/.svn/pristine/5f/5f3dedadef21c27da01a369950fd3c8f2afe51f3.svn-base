package controller;


import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.itextpdf.awt.PdfPrinterGraphics2D;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import service.ILalaLandItemService;
import vo.ConvenienceVO;
import vo.ItemVO;
//import sajo.boramsangjo.tk.lu.buy.vo.TkLuBuyVO;
import vo.Item_buyVO;
/**
 * 영수증 값을 받아 pdf로 저장
 * @author kbr
 *
 */
public class PDFItemBuy {

   public static String itembuy_id;
   public static String item_id;
   public static String mem_id;
   public static String itembuy_date;
   public static String itembuy_refend;
   public static int itembuy_sales;
   Item_buyVO itemBuy=new Item_buyVO();
   public static ILalaLandItemService service;
   static String item_name="";
   static String item_con="";
   static String con_name="";
   

   public PDFItemBuy(Item_buyVO itemBuy) {
      
      this.itembuy_id=itemBuy.getItemBuy_id();
      this.item_id = itemBuy.getItem_id();
      this.mem_id = itemBuy.getMem_id();
      this.itembuy_date = itemBuy.getItemBuy_date();
      this.itembuy_sales = itemBuy.getItemBuy_sales();
      
      try {
          Registry reg = LocateRegistry.getRegistry("localhost", 1088);
          service = (ILalaLandItemService) reg.lookup("itemService");
       } catch (RemoteException | NotBoundException e) {
          System.out.println("실패");
          e.printStackTrace();
       }
 
   }

   public static void pdfPrint() throws RemoteException {
	   List<ItemVO> item_n=service.selectItemAll();
	   for(int i=0;i<item_n.size();i++) {
		   if(item_n.get(i).getItem_id().equals(item_id)) {
			   item_name=item_n.get(i).getItem_name();
			   item_con=item_n.get(i).getCon_id();
		   }
	   }
	   
	  List<ConvenienceVO> con_n= service.selectConvenAll();
	  for(int i=0;i<con_n.size();i++) {
		   if(con_n.get(i).getCon_id().equals(item_con)) {
			   
			  con_name=con_n.get(i).getCon_title();
		   }
	   }
	   
	 
	   
      Document doc = new Document(PageSize.A7, 35, 35, 35, 35);

      Calendar oCalendar = Calendar.getInstance(); // 현재 날짜/시간 등의 각종 정보 얻기

      try {
         
         PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("D:/" + itembuy_id + ".pdf"));

         String resPath = "D:\\\\A_TeachingMaterial\\\\4.MiddleProject\\\\workspace\\\\lalaLandClient\\\\res\\\\font/HoonWhitecatR.ttf";

         BaseFont bf = BaseFont.createFont(resPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

         Font cellNormailFont = new Font(bf, 8, Font.NORMAL);
         Font cellNormailFont2 = new Font(bf, 5, Font.NORMAL);

         doc.open();
         doc.add(new Paragraph(" "));

         doc.add(new Paragraph("                       [  영  수  증 ]           \n\n", cellNormailFont));
         doc.add(new Paragraph("구매일자 : " + itembuy_date, cellNormailFont2));
         doc.add(new Paragraph("영수증발행일자 : " + oCalendar.get(Calendar.YEAR) + "-" + (oCalendar.get(Calendar.MONTH)+1)
               + "-" + oCalendar.get(Calendar.DAY_OF_MONTH), cellNormailFont2));
         doc.add(new Paragraph("----------------------------------------", cellNormailFont));
         doc.add(new Paragraph(" 품      명  :  "+item_name, cellNormailFont));
         //doc.add(new Paragraph(" 구매구량  :  " + tk_lu_buy_num + "장", cellNormailFont));
         //int ticketPrice = tk_lu_buy_num * 100;
         //int buga = (int) (ticketPrice * 0.1);
         //doc.add(new Paragraph(" 금      액  :  " + itembuy_sales + "원", cellNormailFont));
         //doc.add(new Paragraph(" 부 가 세  :  " + buga + "원", cellNormailFont));
         //int sum = ticketPrice + buga;
         doc.add(new Paragraph("----------------------------------------", cellNormailFont));
         doc.add(new Paragraph(" 총      액  :  " +itembuy_sales + "원", cellNormailFont));
         doc.add(new Paragraph(" 수  령  처  :  "+con_name, cellNormailFont));
         doc.add(new Paragraph("\n\n\n상 호 명 : LALALAND", cellNormailFont2));
         doc.add(new Paragraph("사업자등록번호 : 5959595959", cellNormailFont2));
         //doc.add(new Paragraph("주    소 : 대전 중구 중앙로 76 영민빌딩 2층", cellNormailFont2));
         //doc.add(new Paragraph("전화번호 : 042-220-0000", cellNormailFont2));
         //doc.add(new Paragraph("대    표 : 보람상조", cellNormailFont2));

         doc.close();
         writer.close();

      } catch (DocumentException | IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

}