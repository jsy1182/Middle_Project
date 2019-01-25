package Item.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import service.ILalaLandItemService;
import vo.ConvenienceVO;
import vo.ItemVO;

public class ItemAddController {
///관리자 입장 -- 아이템 추가
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField TFNAME;

    @FXML
    private TextField TFPRICE;

    @FXML
    private TextField TFSOLD;
    
    @FXML
    private Label lb1;
    
    @FXML
    private Label lb2;
    
    @FXML
    private Label lb3;
    
    @FXML
    private Label lb4;
    
    @FXML
    private Label lb5;

    @FXML
    private TextArea TACONTENT;

    @FXML
    private ComboBox<String> COMBOBOX;

    @FXML
    private Button ADDBTN;

    @FXML
    private Button CANBTN;

	private ILalaLandItemService service = null;

	ObservableList<ConvenienceVO> data = null;

	String cov_id;
	
	/**
	 * 아이템을 추가하는 버튼
	 * 
	 * @param event
	 */
	@FXML
	void ADDBUTTON(ActionEvent event) throws RemoteException {
		ItemVO item = new ItemVO();

		for (ConvenienceVO vo : data) {
			// COMBOBOX.getItems().add(vo.getCon_title());
			if ((String) COMBOBOX.getSelectionModel().getSelectedItem() == vo.getCon_title()) {
				cov_id = vo.getCon_id();
			}
		}

		if (TFNAME.getText().isEmpty()) {
			alert("이름을 입력하세요.", "이름");
			return;
		}
		if (TFPRICE.getText().isEmpty()) {
			alert("가격을 입력하세요.", "이름");
			return;

		}
		if (TFSOLD.getText().isEmpty()) {
			alert("매진여부를 입력하세요.", "이름");
			return;

		}
		if(!(TFSOLD.getText().equals("T") || TFSOLD.getText().equals("F"))) {
			alert("매진여부는 T,F로 입력해주세요","T 품절, F 구매가능");
			return;
		}
		if (TACONTENT.getText().isEmpty()) {
			alert("설명을 입력하세요.", "이름");
			return;

		}
		if (COMBOBOX.getSelectionModel().getSelectedItem().isEmpty()) {
			alert("편의시설을 선택하세요.", "이름");
			return;

		}
		String str = TFPRICE.getText();
		for(int i=0; i <str.length();i++) {
			if(48>str.charAt(i)||str.charAt(i)>58) {
				alert(null, "가격은 숫자만 입력해주세요.");
				return;
			}
		}

		item.setItem_name(TFNAME.getText());
		item.setItem_price(Integer.parseInt(TFPRICE.getText()));
		item.setItem_sold(TFSOLD.getText());
		item.setItem_content(TACONTENT.getText());
		item.setCon_id(cov_id);

		service.insertItem(item);
		alert("상품 추가가 완료 되었습니다.", "아이템 목록으로 돌아갑니다.");
//		try {
//
			Stage st;
			st = (Stage) COMBOBOX.getScene().getWindow();
			st.close();
			
//
//			anchorPane.getChildren().setAll(addRoot);
//			
////
////			Scene addScene = new Scene(addRoot);
////			st.setScene(addScene);
////			st.show();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

	/**
	 * 아이템 추가를 취소하는 버튼
	 * 
	 * @param event
	 */
	@FXML
	void CANCLEBUTTON(ActionEvent event) {
		alert("상품 추가가 취소 되었습니다.", "아이템 목록으로 돌아갑니다.");
		try {

			Stage st;
			st = (Stage) COMBOBOX.getScene().getWindow();
			st.close();
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ItemMain.fxml"));
//			Parent addRoot = loader.load();
//			anchorPane.getChildren().setAll(addRoot);

//			Scene addScene = new Scene(addRoot);
//			st.setScene(addScene);
//			st.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 편의시설 분류를 선택하는 콤보 박스
	 * 
	 * @param event
	 */
	@FXML
	void COMBOBOXCONVI(ActionEvent event) {

	}
	

	@FXML
	void initialize() throws RemoteException {
		assert TFNAME != null : "fx:id=\"TFNAME\" was not injected: check your FXML file 'ItemAddV.fxml'.";
		assert TFPRICE != null : "fx:id=\"TFPRICE\" was not injected: check your FXML file 'ItemAddV.fxml'.";
		assert TFSOLD != null : "fx:id=\"TFSOLD\" was not injected: check your FXML file 'ItemAddV.fxml'.";
		assert TACONTENT != null : "fx:id=\"TACONTENT\" was not injected: check your FXML file 'ItemAddV.fxml'.";
		assert COMBOBOX != null : "fx:id=\"COMBOBOX\" was not injected: check your FXML file 'ItemAddV.fxml'.";
		assert ADDBTN != null : "fx:id=\"ADDBTN\" was not injected: check your FXML file 'ItemAddV.fxml'.";
		assert CANBTN != null : "fx:id=\"CANBTN\" was not injected: check your FXML file 'ItemAddV.fxml'.";
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'AdminMainScene.fxml'.";
		assert lb1 != null : "fx:id=\"lb1\" was not injected: check your FXML file 'ItemAdd.fxml'.";
		assert lb2 != null : "fx:id=\"lb1\" was not injected: check your FXML file 'ItemAdd.fxml'.";
		assert lb3 != null : "fx:id=\"lb1\" was not injected: check your FXML file 'ItemAdd.fxml'.";
		assert lb4 != null : "fx:id=\"lb1\" was not injected: check your FXML file 'ItemAdd.fxml'.";
		assert lb5 != null : "fx:id=\"lb1\" was not injected: check your FXML file 'ItemAdd.fxml'.";
		
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (ILalaLandItemService) reg.lookup("itemService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("실패");
			e.printStackTrace();
		}
		
		setfont();
		
		List<ConvenienceVO> convenience = service.selectConvenAll();
		data = FXCollections.observableArrayList(convenience);
		//COMBOBOX.setPromptText("선택하세요");
		for (ConvenienceVO vo : data) {
			COMBOBOX.getItems().add(vo.getCon_title());
		}
		COMBOBOX.getSelectionModel().selectFirst();
	}

	public void alert(String header, String msg) {
		Alert alert = new Alert(AlertType.WARNING);

		alert.setTitle("WARNING");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();

	}
	
	public void setfont() {
    	final Font font = Font.loadFont(getClass().getResourceAsStream("/font/THELeft.ttf"), 20);
    	final Font font2 = Font.loadFont(getClass().getResourceAsStream("/font/HoonWhitecatR.ttf"), 25);
    	ADDBTN.setFont(font);
    	CANBTN.setFont(font);
    	lb1.setFont(font2);
    	lb2.setFont(font2);
    	lb3.setFont(font2);
    	lb4.setFont(font2);
    	lb5.setFont(font2);
    }
}
