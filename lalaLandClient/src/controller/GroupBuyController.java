package controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.lowagie.toolbox.plugins.Txt2Pdf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.CurrentLoginPerson;
import service.ILalaLandBuyService;
import vo.BuyVO;
import vo.MemberVO;
import vo.TicketVO;

public class GroupBuyController {
	TicketVO ticketVO;
	ILalaLandBuyService service;
	MemberVO member;
	GPayMentController gpaymentController3;
	int lblNum = 10;
	BuyVO buyVO;
	@FXML
	private ResourceBundle resources;
	@FXML
	private AnchorPane anchorPane;

	@FXML
	private URL location;

	@FXML
	private Label lb21;

	@FXML
	private Label lb22;

	@FXML
	private Button buytc2;

	@FXML
	private Label lbl;

	@FXML
	private DatePicker dt;

	@FXML
	private Label lbdate;

	@FXML
	private Button btnminus;

	@FXML
	private Button btnplus;

	@FXML
	private Label lblnum;

	@FXML
	private Label lblnum2;

	@FXML
	private Button selnum;

	@FXML
	void clickBuyTC2(ActionEvent event) { // 구매버튼을 눌렀을때
		if (dt.getValue() == null) {
			walert("구매실패", "입장 날짜를 입력해주세요");
			return;
		}
		LocalDateTime now = LocalDateTime.now();
		now.toLocalDate();
		LocalDate selDate = dt.getValue();
		if (now.toLocalDate().isAfter(selDate)) {
			walert("구매실패", "입장 날짜를 오늘 이후로 입력해주세요");
			return;
		}
		alert("구매확인", ticketVO.getTicket_kinds() + " 티켓을 구매하시겠습니까???");
		Optional<ButtonType> result = alert.showAndWait();

		List<BuyVO> list = new ArrayList<>();
		for (int i = 0; i < lblNum; i++) {
			buyVO = new BuyVO();
			buyVO.setMem_id(member.getMem_id());
			buyVO.setBuy_date(dt.getValue().toString());
			buyVO.setSales(ticketVO.getTicket_pri());
			buyVO.setTicket_id("tc007");
			list.add(buyVO);
		} // end of for

		// 화면전환부분
		try {
			Stage gpayment = new Stage(StageStyle.DECORATED);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/buy/GPayMent.fxml"));
			Parent gpay;
			gpay = loader.load();

			Scene gpayscene = new Scene(gpay);

			GPayMentController gpmc = loader.getController();
			gpmc.setservice(service);
			gpmc.setbuyVO(list);

			gpayment.setTitle("결제화면");
			gpayment.setScene(gpayscene);
			gpayment.showAndWait();
			// setLabel();
			gotoMainPage();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void clickmi(ActionEvent event) {
		if (lblNum == 10) {
			btnminus.setDisable(true);
			return;
		}
		lblNum = lblNum - 1;
		setLabel();
		if (lblNum == 10) {
			btnminus.setDisable(true);
			return;
		}
		if (lblNum != 20) {
			btnplus.setDisable(false);
		}
	}

	@FXML
	void clickplus(ActionEvent event) {
		if (btnminus.isDisable()) {
			btnminus.setDisable(false);
		}
		lblNum = lblNum + 1;
		setLabel();
		if (lblNum == 20) {
			btnplus.setDisable(true);
			return;
		}
	}

	@FXML
	void clicksel(ActionEvent event) {

		try {
			Stage payment = new Stage(StageStyle.DECORATED);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/buy/Calculator.fxml"));
			Parent calculator;
			calculator = loader.load();

			CalculatorController cc = loader.getController();
			cc.setGbc(this);

			Scene calculatorscene = new Scene(calculator);

			payment.setTitle("직접선택화면");
			payment.setScene(calculatorscene);
			payment.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {

		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'GroupBuy.fxml'.";
		assert lb21 != null : "fx:id=\"lb21\" was not injected: check your FXML file 'GroupBuy.fxml'.";
		assert lb22 != null : "fx:id=\"lb22\" was not injected: check your FXML file 'GroupBuy.fxml'.";
		assert buytc2 != null : "fx:id=\"buytc2\" was not injected: check your FXML file 'GroupBuy.fxml'.";
		assert lbl != null : "fx:id=\"lbl\" was not injected: check your FXML file 'GroupBuy.fxml'.";
		assert dt != null : "fx:id=\"dt\" was not injected: check your FXML file 'GroupBuy.fxml'.";
		assert lbdate != null : "fx:id=\"lbdate\" was not injected: check your FXML file 'GroupBuy.fxml'.";
		assert btnminus != null : "fx:id=\"btnminus\" was not injected: check your FXML file 'GroupBuy.fxml'.";
		assert btnplus != null : "fx:id=\"btnplus\" was not injected: check your FXML file 'GroupBuy.fxml'.";
		assert lblnum != null : "fx:id=\"lblnum\" was not injected: check your FXML file 'GroupBuy.fxml'.";
		assert lblnum2 != null : "fx:id=\"lblnum2\" was not injected: check your FXML file 'GroupBuy.fxml'.";
		assert selnum != null : "fx:id=\"selnum\" was not injected: check your FXML file 'GroupBuy.fxml'.";

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (ILalaLandBuyService) reg.lookup("buy");
		} catch (RemoteException e) {
			System.out.println("buy service 가져오기 실패");
			e.printStackTrace();
		} catch (NotBoundException ee) {
			System.out.println("buy service 가져오기 실패");
			ee.printStackTrace();
		}
		member = CurrentLoginPerson.CurrentMember;
		setLabel();
	}

	public void setLabel2(String lab) {
		lblnum.setText(lab);
		lblNum = Integer.parseInt(lblnum.getText());
		lb22.setText(ticketVO.getTicket_pri()*lblNum+"원");
	}

	public void setLabel() {

		lblnum.setText(lblNum + " ");
		try {
			ticketVO = service.getTicket("tc007");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lb21.setText(ticketVO.getTicket_kinds());
		lb22.setText(ticketVO.getTicket_pri()*lblNum + "원");
		final Font font = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 17);
		final Font font2 = Font.loadFont(getClass().getResourceAsStream("/font/HoonlefthanderR.otf"), 30);
		final Font font3 = Font.loadFont(getClass().getResourceAsStream("/font/THELeft.ttf"), 20);
		lb21.setFont(font2);
		lb22.setFont(font2);
		buytc2.setFont(font);
		lbdate.setFont(font);
		lblnum.setFont(font3);
		lblnum2.setFont(font);
		selnum.setFont(font3);
	}

	public void setlblNum(int lblNum) {
		this.lblNum = lblNum;
		System.out.println(lblNum);
		System.out.println(this.lblNum);
	}

	public void setService(ILalaLandBuyService service) {
		this.service = service;
	}

	public void walert(String header, String msg) {
		Alert walert = new Alert(AlertType.WARNING);

		walert.setTitle("등록실패");
		walert.setHeaderText(header);
		walert.setContentText(msg);

		walert.show();
	}// end of walert

	Alert alert;

	public void alert(String header, String msg) {
		alert = new Alert(AlertType.CONFIRMATION);

		alert.setTitle("구매확인");
		alert.setHeaderText(header);
		alert.setContentText(msg);
	}// end of alert

	public void gotoMainPage() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/mainscene.fxml"));
			Parent buy;
			buy = loader.load();
//			anchorPane.getChildren().setAll(buy);
			Stage buyStage = (Stage) selnum.getScene().getWindow();
//
			Scene scene = new Scene(buy);
			buyStage.setTitle("구매를 누르면 갈화면");
			buyStage.setScene(scene);
			buyStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end of gotoMainPage

}
