package Food.controller;

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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.ILalaLandFoodService;
import service.ILalaLandItemService;
import vo.ConvenienceVO;
import vo.FoodVO;
import vo.ItemVO;

public class FoodModifyController {
///관리자 --음식 수정
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private MenuItem btn_ride;

    @FXML
    private MenuItem btn_animal;

    @FXML
    private MenuItem btn_con;

    @FXML
    private MenuItem btn_info;

    @FXML
    private MenuItem btn_buy;

    @FXML
    private MenuItem btn_bulk;

    @FXML
    private MenuItem btn_itembuy;

    @FXML
    private MenuItem btn_annual;

    @FXML
    private MenuItem btn_cancelBuy;

    @FXML
    private MenuItem btn_res;

    @FXML
    private MenuItem btn_cancelRes;

    @FXML
    private MenuItem btn_notice;

    @FXML
    private MenuItem btn_qa;

    @FXML
    private MenuItem btn_chat;

    @FXML
    private MenuItem btn_mine;

    @FXML
    private MenuItem btn_attend;

    @FXML
    private MenuItem btn_coupon;

    @FXML
    private MenuItem btn_ticketList;

    @FXML
    private MenuItem btn_itemList;

    @FXML
    private Menu btn_logout;

    @FXML
    private TextField TFNAME;

    @FXML
    private TextField TFPRICE;

    @FXML
    private TextArea TACONTENT;

    @FXML
    private ComboBox<String> COMBOBOX;

    @FXML
    private Button ADDBTN;

    @FXML
    private Button CANBTN;

    @FXML
    private Button btn_korean;

    @FXML
    private Button btn_english;

    @FXML
    private Button btn_music;

    
    FoodVO std;
    
    ILalaLandFoodService service=null;
    ObservableList<ConvenienceVO> data=null;
    String con_id;
    
    @FXML
    void ADDBUTTON(ActionEvent event) throws RemoteException {
    	FoodVO food =new FoodVO();
    	
    	for(ConvenienceVO vo : data) {
        	//COMBOBOX.getItems().add(vo.getCon_title());
        	if((String)COMBOBOX.getSelectionModel().getSelectedItem()==vo.getCon_title()) {
        		con_id=vo.getCon_id();
        	}
        }
    	

    	
	    	
	    		if(TFNAME.getText().isEmpty()) {
					alert("이름을 입력하세요.","이름");
					return;
				}
				if(TFPRICE.getText().isEmpty()) {
					alert("가격을 입력하세요.","이름");
					return;
					
				}
				String str = TFPRICE.getText();
				for(int i =0; i<str.length();i++) {
					if(48>str.charAt(i)||str.charAt(i)>58) {
						alert(null, "가격은 숫자만 입력해주세요.");
						return;
					}
				}
				if(TACONTENT.getText().isEmpty()) {
					alert("설명을 입력하세요.","이름");
					return;
					
				}
				if(COMBOBOX.getSelectionModel().getSelectedItem().isEmpty()) {
					alert("편의시설을 선택하세요.","이름");
					return;
					
				}
    	
    	food.setFood_name(TFNAME.getText());
    	food.setFood_price(Integer.parseInt(TFPRICE.getText()));
    	food.setFood_content(TACONTENT.getText());  
    	food.setCon_id(con_id);
    	food.setFood_id(std.getFood_id());
		

    	
    	
		service.updateFood(food);
		
		alert("음식이 추가가 완료 되었습니다.","음식 목록으로 돌아갑니다.");
		try {

			Stage st;
			st = (Stage) COMBOBOX.getScene().getWindow();
			st.close();
//			Scene addScene = new Scene(addRoot);
//			st.setScene(addScene);
//			st.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void CANCLEBUTTON(ActionEvent event) {
    	alert("음식 수정이 취소 되었습니다.","음식 목록으로 돌아갑니다.");

			Stage st;
			st = (Stage) COMBOBOX.getScene().getWindow();
			st.close();
    }

    @FXML
    void COMBOBOXCONVI(ActionEvent event) {

    }

   

    @FXML
    void initialize() throws RemoteException {
        assert btn_ride != null : "fx:id=\"btn_ride\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_animal != null : "fx:id=\"btn_animal\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_con != null : "fx:id=\"btn_con\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_info != null : "fx:id=\"btn_info\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_buy != null : "fx:id=\"btn_buy\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_bulk != null : "fx:id=\"btn_bulk\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_itembuy != null : "fx:id=\"btn_itembuy\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_annual != null : "fx:id=\"btn_annual\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_cancelBuy != null : "fx:id=\"btn_cancelBuy\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_res != null : "fx:id=\"btn_res\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_cancelRes != null : "fx:id=\"btn_cancelRes\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_notice != null : "fx:id=\"btn_notice\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_qa != null : "fx:id=\"btn_qa\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_chat != null : "fx:id=\"btn_chat\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_mine != null : "fx:id=\"btn_mine\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_attend != null : "fx:id=\"btn_attend\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_coupon != null : "fx:id=\"btn_coupon\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_ticketList != null : "fx:id=\"btn_ticketList\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_itemList != null : "fx:id=\"btn_itemList\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_logout != null : "fx:id=\"btn_logout\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert TFNAME != null : "fx:id=\"TFNAME\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert TFPRICE != null : "fx:id=\"TFPRICE\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert TACONTENT != null : "fx:id=\"TACONTENT\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert COMBOBOX != null : "fx:id=\"COMBOBOX\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert ADDBTN != null : "fx:id=\"ADDBTN\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert CANBTN != null : "fx:id=\"CANBTN\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_korean != null : "fx:id=\"btn_korean\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_english != null : "fx:id=\"btn_english\" was not injected: check your FXML file 'FoodModify.fxml'.";
        assert btn_music != null : "fx:id=\"btn_music\" was not injected: check your FXML file 'FoodModify.fxml'.";
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'AdminMainScene.fxml'.";

        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandFoodService) reg.lookup("foodService");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("실패");
            e.printStackTrace();
         }
        List<ConvenienceVO> convenience=service.selectConenAll();
        data = FXCollections.observableArrayList(convenience);
        //COMBOBOX.setPromptText("선택하세요");
        for(ConvenienceVO vo : data) {
         	COMBOBOX.getItems().add(vo.getCon_title());
         }
        COMBOBOX.getSelectionModel().selectFirst();
    }
	public void setContente(FoodVO std) {
			
			this.std=std;
			TFNAME.setText(std.getFood_name());
			TFPRICE.setText(std.getFood_price()+"");
			TACONTENT.setText(std.getFood_content());
	
		}
    
    public void alert(String header,String msg) {
        Alert alert = new Alert(AlertType.WARNING);
        
        alert.setTitle("WARNING");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
        
     }
}
