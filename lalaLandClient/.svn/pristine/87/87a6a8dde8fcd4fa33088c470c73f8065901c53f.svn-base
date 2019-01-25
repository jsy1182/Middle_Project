package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import service.ILalaLandBuyService;
import vo.BuyVO;
import vo.TicketVO;

public class Excel {
	List<BuyVO> buyList;
	ILalaLandBuyService service;
	List<TicketVO> ticketList;

	Excel(List<TicketVO> ticketList) {
		this.ticketList = ticketList;
	}

	public void printExcel(List<BuyVO> list, String date) {
		buyList = list;

		try {
			// MemberVO mv = new MemberVO();
			// 시트 이름을 날짜로
			Sheet sheet = AdminViewBuyController.workbook.createSheet(date);
			// Create Heading
			Row heading = sheet.createRow(0);
			heading.createCell(0).setCellValue("구매번호");
			heading.createCell(1).setCellValue("구매날짜");
			heading.createCell(2).setCellValue("가격");
			heading.createCell(3).setCellValue("티켓종류");
			heading.createCell(4).setCellValue("고객번호");
			heading.createCell(5).setCellValue("할인율");
			// heading.getLastCellNum()
			for (int i = 0; i < heading.getLastCellNum(); i++) {
				CellStyle styleHeading = AdminViewBuyController.workbook.createCellStyle();
				Font font = AdminViewBuyController.workbook.createFont();
				font.setBold(true);
				font.setFontName(HSSFFont.FONT_ARIAL);
				font.setFontHeightInPoints((short) 11);
				styleHeading.setFont(font);
				styleHeading.setVerticalAlignment(CellStyle.ALIGN_CENTER);
				heading.getCell(i).setCellStyle(styleHeading);
			}
			int r = 1;
			for (BuyVO buy : buyList) {
				Row row = sheet.createRow(r);

				// 구매번호
				Cell cell1 = row.createCell(0);
				cell1.setCellValue(buy.getBuy_id());

				// 구매날짜
				Cell cell2 = row.createCell(1);
				cell2.setCellValue(buy.getBuy_date());

				// 가격
				Cell cell3 = row.createCell(2);
				cell3.setCellValue(buy.getSales());

				// 티켓종류
				for (TicketVO vo : ticketList) {
					if (vo.getTicket_id().equals( buy.getTicket_id())) {
						Cell cellPhone = row.createCell(3);
						cellPhone.setCellValue(vo.getTicket_kinds());
					}

				}
				// 고객번호
				Cell cell4 = row.createCell(4);
				cell4.setCellValue(buy.getMem_id());

				// 할인율
				Cell cell5 = row.createCell(5);
				cell5.setCellValue(buy.getEj_id());

				r++;
			}

			// Autofit
			for (int i = 0; i < heading.getLastCellNum(); i++) {
				sheet.autoSizeColumn(i);

			}

			System.out.println("성공적으로 마쳤습니다.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void save() {
		try {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dd = format.format(date);
			// save excel file
			FileOutputStream out = new FileOutputStream("D:\\매출현황표 " + dd + ".xls");
			AdminViewBuyController.workbook.write(out);
			out.close();
			AdminViewBuyController.workbook.close();
			walert("저장완료", "성공적으로 저장을 마쳤습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void walert(String header,String msg) {
		Alert walert=new Alert(AlertType.INFORMATION);
		
		walert.setTitle("저장완료");
		walert.setHeaderText(header);
		walert.setContentText(msg);
		
		walert.show();
	}//end of walert
}
