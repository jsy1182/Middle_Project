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

import main.CurrentLoginPerson;
import vo.BuyVO;
import vo.MemberVO;
/**
 * 11-23추가
 * @author 이재형
 *
 */
public class GroupPdf {
	public String cardNum;
	public String bank;
	public String email;
	public int totalPrice;
	public int buyCount;
	public MemberVO memVO;
	
	public GroupPdf(String cardNum,String bank, int totalPrice, int buyCount,String email) {
		this.cardNum=cardNum;
		this.bank=bank;
		this.totalPrice=totalPrice;
		this.buyCount=buyCount;
		this.email=email;
		memVO = CurrentLoginPerson.CurrentMember;
	}
	
	public void printPdf() {
		Document doc=new Document(PageSize.A7, 35, 35, 35, 35);
		Calendar oCalendar = Calendar.getInstance(); // 현재 날짜/시간 등의 각종 정보 얻기
		try {
			PdfWriter writer=PdfWriter.getInstance(doc, new FileOutputStream("D:/"+email+".pdf"));
			
			String resPath = "res/font/HoonJunglebookR.otf";
			
			BaseFont bf = BaseFont.createFont(resPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

	        Font cellNormailFont = new Font(bf, 7, Font.NORMAL);
	        Font cellNormailFont2 = new Font(bf, 3, Font.NORMAL);

			
			doc.open();
	        doc.add(new Paragraph(" "));
	        doc.add(new Paragraph("                       [  영  수  증 ]           \n\n", cellNormailFont));
	        doc.add(new Paragraph("수신자 : " + memVO.getMem_name(),cellNormailFont2));
	        doc.add(new Paragraph("영수증발행일자 : " + oCalendar.get(Calendar.YEAR) + "-" + (oCalendar.get(Calendar.MONTH)+1)
	                + "-" + oCalendar.get(Calendar.DAY_OF_MONTH),cellNormailFont2));
	        doc.add(new Paragraph("--------------------------------", cellNormailFont));
	        doc.add(new Paragraph(" 입금은행 : "+bank,cellNormailFont));
	        doc.add(new Paragraph(" 카드번호 : "+cardNum,cellNormailFont));
	        doc.add(new Paragraph("------------------------------"));
	        doc.add(new Paragraph(" 구매수량 :  " + buyCount + "매",cellNormailFont));
	        doc.add(new Paragraph(" 총      액  :  " + totalPrice + "원",cellNormailFont));
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
			PdfReader reader = new PdfReader("D:/"+email+".pdf");
			PdfStamper pdfStamper;
			pdfStamper = new PdfStamper(reader,
			    new FileOutputStream("D:/"+email+"Water.pdf"));
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
