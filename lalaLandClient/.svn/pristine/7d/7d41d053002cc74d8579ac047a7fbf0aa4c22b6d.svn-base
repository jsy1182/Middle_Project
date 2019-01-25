package Item.controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Food.controller.FoodInfoController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.ILalaLandItemService;
import vo.ItemVO;

public class ItemCustomerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField TF;

    @FXML
    private Button SELBUT;

    @FXML
    private TableView<ItemVO> TV;

    @FXML
    private TableColumn<ItemVO, String> TVID;

    @FXML
    private TableColumn<ItemVO, Integer> TVPR;

/*    @FXML
    private TableColumn<ItemVO, String> TVSOLD;*/

    @FXML
    private TableColumn<ItemVO, String> TVCON;

    @FXML
    private TableColumn<ItemVO, String> TVSTO;

    @FXML
    private Button backbtn;

    @FXML
    private Button buybtn;

    
    private ILalaLandItemService service=null;
    
    private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	ObservableList<ItemVO> data = null;
	
	ItemVO std=null;//선택한 item에 대한정보를 저장한다.


	@FXML
    void SELECTBUTTON(ActionEvent event) throws RemoteException {
    	String item_name= TF.getText();
    	List<ItemVO> item=(List<ItemVO>) service.selectItemByName(item_name);
    	
    	
    	
    	if (item == null || item.size() == 0) {
			System.out.println("\t\t 정보가 하나도 없습니다. ");
		} else {
			List<ItemVO> itemList = new ArrayList<>();
			for (ItemVO mvo : item) {
				if(item.get(0).getItem_sold().equals("F")) {
					String name = mvo.getItem_name();
					int price = mvo.getItem_price();
					String sold = mvo.getItem_sold();
					String content = mvo.getItem_content();
					
					itemList.add(mvo);
				}

			}
			data = FXCollections.observableArrayList(itemList);
		}
//		data.setAll(item);
		TV.setItems(data);
		
		
		// 제일끝의 이름과 vo의 이름을 맞추자
		TV.getColumns().setAll(TVID, TVPR, TVCON);
		
    }

	/**
	 * 뒤로 버튼 메인 화면으로 이동
	 * @param event
	 */
    @FXML
    void backbtn(ActionEvent event) {
    	//메인화면으로 이동 구현
    	try {

			Stage st;
			st = (Stage) TV.getScene().getWindow();

			//FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ConvCustomerMain.fxml"));
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/mainscene.fxml"));
			Parent addRoot = loader.load();
//			anchorPane.getChildren().setAll(addRoot);

			// WritingController addController = loader.getController();

			// addController.setMainController(this);
			// addController.setContente(std);
//
			Scene addScene = new Scene(addRoot);
			st.setScene(addScene);
			st.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	

    }
    /**
     * 구매 버튼
     * 구매창을 띄운다
     * @author 류주완
     * @since 2018-11-14
     * @param event
     */
    @FXML
    void buybtn(ActionEvent event) {
    	if(std==null) {
    		alert("구매할 상품을 선택하세요","선택");
    		return;
    	}
    	
    	
    	alert("상품을 구매 합니다.","구매 페이지로 이동합니다.");
    	try {

			Stage st;
			st = new Stage();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ItemPayMent.fxml"));
			Parent addRoot = loader.load();
			/**
			 * 아이템 페이먼트 창 수정 
			 * @author 류주완
			 * 
			 */
			//anchorPane.getChildren().setAll(addRoot);
			ItemPayMentController payment=loader.getController();
			payment.setItemId(std);

			Scene addScene = new Scene(addRoot);
			st.setScene(addScene);
			st.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
   	 *Item로 부터 DB를 가져오기 위한 연결
        * @throws RemoteException 
        * @author 류주완
        * @since2018-11-13
   	 */
   	void getstda() throws RemoteException {
   		List<ItemVO> ItemList = service.selectItemAll();
   		
   		if (ItemList == null || ItemList.size() == 0) {
   			System.out.println("\t\t 정보가 하나도 없습니다. ");
   		} else {
   			List<ItemVO> itemList = new ArrayList<>();
   			for (ItemVO mvo : ItemList) {
   				if(mvo.getItem_sold().equals("F")) {
   					System.out.println(mvo.getItem_sold());
   					String name = mvo.getItem_name();
   					int price = mvo.getItem_price();
   					String sold = mvo.getItem_sold();
   					String content = mvo.getItem_content();
   					itemList.add(mvo);	
   				}

   			}
   			data = FXCollections.observableArrayList(itemList);
   		}
   		//data.setAll(ItemList);
   		TV.setItems(data);
   		
   		
   		// 제일끝의 이름과 vo의 이름을 맞추자
   		TV.getColumns().setAll(TVID, TVPR,  TVCON);

   	}

    @FXML
    void initialize() throws RemoteException {
        assert TF != null : "fx:id=\"TF\" was not injected: check your FXML file 'ItemCustomerMain.fxml'.";
        assert SELBUT != null : "fx:id=\"SELBUT\" was not injected: check your FXML file 'ItemCustomerMain.fxml'.";
        assert TV != null : "fx:id=\"TV\" was not injected: check your FXML file 'ItemCustomerMain.fxml'.";
        assert TVID != null : "fx:id=\"TVID\" was not injected: check your FXML file 'ItemCustomerMain.fxml'.";
        assert TVPR != null : "fx:id=\"TVPR\" was not injected: check your FXML file 'ItemCustomerMain.fxml'.";
        //assert TVSOLD != null : "fx:id=\"TVSOLD\" was not injected: check your FXML file 'ItemCustomerMain.fxml'.";
        assert TVCON != null : "fx:id=\"TVCON\" was not injected: check your FXML file 'ItemCustomerMain.fxml'.";
        assert TVSTO != null : "fx:id=\"TVSTO\" was not injected: check your FXML file 'ItemCustomerMain.fxml'.";
        assert backbtn != null : "fx:id=\"backbtn\" was not injected: check your FXML file 'ItemCustomerMain.fxml'.";
        assert buybtn != null : "fx:id=\"buybtn\" was not injected: check your FXML file 'ItemCustomerMain.fxml'.";
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'AdminMainScene.fxml'.";

        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandItemService) reg.lookup("itemService");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("실패");
            e.printStackTrace();
         }
        
        getstda();
        

        TVID.setCellValueFactory(new PropertyValueFactory<ItemVO, String>("item_name"));
		TVPR.setCellValueFactory(new PropertyValueFactory<ItemVO, Integer>("item_price"));
		//TVSOLD.setCellValueFactory(new PropertyValueFactory<ItemVO, String>("item_sold"));
		TVCON.setCellValueFactory(new PropertyValueFactory<ItemVO, String>("item_content"));
        
		
		
		
		TV.setOnMouseClicked(e -> {
			std = (ItemVO) TV.getSelectionModel().getSelectedItem();
			
			try {

				Stage st;
				st = new Stage();
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ItemInfo.fxml"));
				
				Parent addRoot; 
				addRoot= loader.load();
//				anchorPane.getChildren().setAll(addRoot);
				
				ItemInfoController InfoController = loader.getController();

				 //addController.setMainController(this);
				InfoController.setContente(std);
				System.out.println("std = "+std);
				Scene addScene = new Scene(addRoot);
				st.initModality(Modality.APPLICATION_MODAL);
				st.setScene(addScene);
				st.show();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
        
        
    }
    public void alert(String header,String msg) {
        Alert alert = new Alert(AlertType.WARNING);
        
        alert.setTitle("WARNING");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
        
     }
    
    
}
