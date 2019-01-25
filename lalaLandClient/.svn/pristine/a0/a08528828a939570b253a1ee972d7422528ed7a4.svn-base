package coupon;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import main.CurrentLoginPerson;
import service.ICouponService;
import service.IEventJoinService;
import service.IEventService;
import vo.CouponVO;
import vo.EventVO;
import vo.Event_joinVO;
import vo.MemberVO;

public class CouponMainController {
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<CouponVO> tableview;

	@FXML
	private TableColumn<?, ?> colEventJoinId;

	@FXML
	private TableColumn<?, ?> colEventTitle;

	@FXML
	private TableColumn<?, ?> colEventDisc;

	@FXML
	private TableColumn<?, ?> colEventStart;

	@FXML
	private TableColumn<?, ?> colEventEnd;
	
	@FXML
    private Label title;

	
	
	IEventService service;
	IEventJoinService ejservice;
	ICouponService cservice;
	MemberVO member;
	List<CouponVO> clist;
	private ObservableList<CouponVO> colist;
	
	@FXML
	void initialize() throws RemoteException {
		assert tableview != null : "fx:id=\"tableview\" was not injected: check your FXML file 'Coupon.fxml'.";
		assert colEventJoinId != null : "fx:id=\"colEventJoinId\" was not injected: check your FXML file 'Coupon.fxml'.";
		assert colEventTitle != null : "fx:id=\"colEventTitle\" was not injected: check your FXML file 'Coupon.fxml'.";
		assert colEventDisc != null : "fx:id=\"colEventDisc\" was not injected: check your FXML file 'Coupon.fxml'.";
		assert colEventStart != null : "fx:id=\"colEventStart\" was not injected: check your FXML file 'Coupon.fxml'.";
		assert colEventEnd != null : "fx:id=\"colEventEnd\" was not injected: check your FXML file 'Coupon.fxml'.";
		assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'Coupon.fxml'.";
		
		final Font font = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 20);
		title.setFont(font);

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IEventService) reg.lookup("eventService");
			ejservice = (IEventJoinService) reg.lookup("eventJoinService");
			cservice = (ICouponService) reg.lookup("couponService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("board service 가져오기 실패");
			e.printStackTrace();
		}
		
		member = CurrentLoginPerson.CurrentMember;

		clist = cservice.showCoupon(member.getMem_id());

		
		colEventJoinId.setCellValueFactory(new PropertyValueFactory<>("ej_id"));
		colEventTitle.setCellValueFactory(new PropertyValueFactory<>("event_title"));
		colEventDisc.setCellValueFactory(new PropertyValueFactory<>("event_disc"));
		colEventStart.setCellValueFactory(new PropertyValueFactory<>("event_start"));
		colEventEnd.setCellValueFactory(new PropertyValueFactory<>("event_end"));
		
		colist = FXCollections.observableArrayList(clist);
		tableview.setItems(colist);
	}
}
