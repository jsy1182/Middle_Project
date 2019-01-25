package buy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import vo.BuyVO;

public class Pdf {
	public String buy_id;
	public String buy_date;
	public int sales;
	public String ticket_id;
	public String mem_id;
	public String cardNum;
	public String expiry;
	public String bank;
	
	public Pdf(BuyVO vo,String cardNum,String expiry,String bank) {
		this.buy_id=vo.getBuy_id();
		this.buy_date=vo.getBuy_date();
		this.sales=vo.getSales();
		this.ticket_id=vo.getTicket_id();
		this.mem_id=vo.getMem_id();
		this.cardNum=cardNum;
		this.expiry=expiry;
		this.bank=bank;
	}
	
	public void printPdf() {
		Document doc=new Document(PageSize.A7, 35, 35, 35, 35);
		Calendar oCalendar = Calendar.getInstance(); // 현재 날짜/시간 등의 각종 정보 얻기
		try {
			PdfWriter writer=PdfWriter.getInstance(doc, new FileOutputStream("D:/"+mem_id+"_"+buy_date+".pdf"));
			
			String resPath = "res/font/HoonJunglebookR.otf";
			
			BaseFont bf = BaseFont.createFont(resPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

	        Font cellNormailFont = new Font(bf, 7, Font.NORMAL);
	        Font cellNormailFont2 = new Font(bf, 3, Font.NORMAL);

			
			doc.open();
	        doc.add(new Paragraph(" "));
	        doc.add(new Paragraph("                       [  영  수  증 ]           \n\n", cellNormailFont));
	        doc.add(new Paragraph("구매일자 : " + buy_date,cellNormailFont2));
	        doc.add(new Paragraph("영수증발행일자 : " + oCalendar.get(Calendar.YEAR) + "-" + (oCalendar.get(Calendar.MONTH)+1)
	                + "-" + oCalendar.get(Calendar.DAY_OF_MONTH),cellNormailFont2));
	        String ticketKind="";
	        if(ticket_id.equals("tc001")) {
	        	ticketKind="소인";
	        }else if(ticket_id.equals("tc002")) {
	        	ticketKind="청소년";
	        }else if(ticket_id.equals("tc003")) {
	        	ticketKind="성인";
	        }else if(ticket_id.equals("tc004")) {
	        	ticketKind="소인 연간";
	        }else if(ticket_id.equals("tc005")) {
	        	ticketKind="청소년 연간";
	        }else if(ticket_id.equals("tc006")) {
	        	ticketKind="성인 연간";
	        }
	        doc.add(new Paragraph("--------------------------------", cellNormailFont));
	        doc.add(new Paragraph(" 품      명  : "+ticketKind,cellNormailFont));
	        doc.add(new Paragraph(" 입금은행 : "+bank,cellNormailFont));
	        doc.add(new Paragraph(" 카드번호 : "+cardNum,cellNormailFont));
	        doc.add(new Paragraph(" 유효기간 : "+expiry,cellNormailFont));
	        doc.add(new Paragraph("------------------------------"));
	        doc.add(new Paragraph(" 총      액  :  " + sales + "원",cellNormailFont));
	        doc.add(new Paragraph("\n\n\n상 호 명 : TWICE",cellNormailFont2));
	        doc.add(new Paragraph("사업자등록번호 : 220-00-0000",cellNormailFont2));
	        doc.add(new Paragraph("주    소 : 대전 중구 중앙로 76 영민빌딩 2층",cellNormailFont2));
	        doc.add(new Paragraph("전화번호 : 042-220-0000",cellNormailFont2));
	        doc.add(new Paragraph("대    표 : 강혜민",cellNormailFont2));

	        doc.close();
	        writer.close(); 
		} catch (DocumentException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}//end of printPdf
	public void makeWaterMark() {
		//watermark
		try {
			PdfReader reader = new PdfReader("D:/"+mem_id+"_"+buy_date+".pdf");
			PdfStamper pdfStamper;
			pdfStamper = new PdfStamper(reader,
			    new FileOutputStream("D:/"+mem_id+"_"+buy_date+"Water.pdf"));
			Image image = Image.getInstance("D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\lalaLandClient\\Image\\watermark.PNG");
			for(int i=1; i<= reader.getNumberOfPages(); i++){
				PdfContentByte content = pdfStamper.getUnderContent(i);
				image.setAbsolutePosition(-30, -260);
				PdfGState gs1 = new PdfGState();
				gs1.setFillOpacity(0.1f);
				content.addImage(image);
				content.setGState(gs1);
			}
			pdfStamper.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}//end of pdf
