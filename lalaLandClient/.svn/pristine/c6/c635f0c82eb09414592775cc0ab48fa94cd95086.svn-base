package controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import service.ILalaLandBuyService;
import vo.BuyVO;

public class AdminViewBuyController {
	ILalaLandBuyService service;
	List<BuyVO> list;
	List<String> datelist;
	ObservableList<BuyVO> data;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	@FXML
	private AnchorPane anchorPane;

	@FXML
	private TableView<BuyVO> table;

	@FXML
	private TableColumn<?, ?> colbuyid;

	@FXML
	private TableColumn<?, ?> colbuydate;

	@FXML
	private TableColumn<?, ?> colsale;

	@FXML
	private TableColumn<?, ?> colticket;

	@FXML
	private TableColumn<?, ?> colmem;

	@FXML
	private TableColumn<?, ?> colevent;
	
    @FXML
    private TableColumn<?, ?> colPay;

	@FXML
	private TextField searchtxt;

	@FXML
	private Button searchbtn;

	@FXML
	private ComboBox<String> com;

	public static Workbook workbook = new HSSFWorkbook();

	@FXML
	void clksearchbtn(ActionEvent event) {
		String para = searchtxt.getText();
		try {
			list = service.getBuywithid(para);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTable();
	}

	@FXML
	void click_ExcelDownload(ActionEvent event) {
		try {
			Excel excel = new Excel(service.getAllTicket());

			datelist = service.selectAllDate();
			for (String date : datelist) {
				list = service.getAllbuyForExcel(date);
				excel.printExcel(list, date);
			}
			excel.save();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void initialize() {
		assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'AdminViewBuy.fxml'.";
		assert colbuyid != null : "fx:id=\"colbuyid\" was not injected: check your FXML file 'AdminViewBuy.fxml'.";
		assert colbuydate != null : "fx:id=\"colbuydate\" was not injected: check your FXML file 'AdminViewBuy.fxml'.";
		assert colsale != null : "fx:id=\"colsale\" was not injected: check your FXML file 'AdminViewBuy.fxml'.";
		assert colticket != null : "fx:id=\"colticket\" was not injected: check your FXML file 'AdminViewBuy.fxml'.";
		assert colmem != null : "fx:id=\"colmem\" was not injected: check your FXML file 'AdminViewBuy.fxml'.";
		assert colevent != null : "fx:id=\"colevent\" was not injected: check your FXML file 'AdminViewBuy.fxml'.";
		assert colPay != null : "fx:id=\"colPay\" was not injected: check your FXML file 'AdminViewBuy.fxml'.";
		assert searchtxt != null : "fx:id=\"searchtxt\" was not injected: check your FXML file 'AdminViewBuy.fxml'.";
		assert searchbtn != null : "fx:id=\"searchbtn\" was not injected: check your FXML file 'AdminViewBuy.fxml'.";
		assert com != null : "fx:id=\"com\" was not injected: check your FXML file 'AdminViewBuy.fxml'.";
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'AdminMainScene.fxml'.";

		setComandTable();

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (ILalaLandBuyService) reg.lookup("buy");
			list = service.selectAllbuy();
		} catch (RemoteException e) {
			System.out.println("buy service 가져오기 실패");
			e.printStackTrace();
		} catch (NotBoundException ee) {
			System.out.println("buy service 가져오기 실패");
			ee.printStackTrace();
		}

		colbuyid.setCellValueFactory(new PropertyValueFactory<>("buy_id"));
		colbuydate.setCellValueFactory(new PropertyValueFactory<>("buy_date"));
		colsale.setCellValueFactory(new PropertyValueFactory<>("sales"));
		colticket.setCellValueFactory(new PropertyValueFactory<>("ticket_id"));
		colmem.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
		colevent.setCellValueFactory(new PropertyValueFactory<>("ej_id"));
		colPay.setCellValueFactory(new PropertyValueFactory<>("refund"));
		
		setTable();
	}

	public void setComandTable() {
		List<String> combolist = new ArrayList<>();
		combolist.add(0, "구매번호");
		combolist.add(1, "회원ID");
		ObservableList<String> list = FXCollections.observableArrayList(combolist);
		com.setItems(list);
		com.getSelectionModel().selectFirst();
	}

	public void setTable() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEj_id() == null) {
				list.get(i).setEj_id("X");
			}
			if(list.get(i).getRefund().equals("T")) {
				list.get(i).setRefund("결제 취소");
			}else {
				list.get(i).setRefund("결제 완료");
			}
		}
		data = FXCollections.observableArrayList(list);
		table.setItems(data);
	}
	
}
