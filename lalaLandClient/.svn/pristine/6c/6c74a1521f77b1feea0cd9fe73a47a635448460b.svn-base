package Item.controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import service.ILalaLandItemService;
import vo.ItemVO;
import vo.Item_buyVO;
import vo.MemberVO;

public class cancelBuyCustomerController {
//아이템 구매목록 확인 및 구매취소 - 고객
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private MenuItem conbtn;

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
    private TableView<Item_buyVO> TV;

    @FXML
    private TableColumn<Item_buyVO, String> TVNUM;

    @FXML
    private TableColumn<Item_buyVO, String> TVNAME;

    /*@FXML
    private TableColumn<Item_buyVO, Integer> TVCOUNT;
*/
    @FXML
    private TableColumn<Item_buyVO, Integer> TVSALE;

    @FXML
    private TableColumn<Item_buyVO, String> TVDATE;

    @FXML
    private TableColumn<Item_buyVO, String> TVREFUND;
    
    ILalaLandItemService service;
    List<Item_buyVO> ItemBuyListNew=new ArrayList<>();
    MemberVO mem=CurrentLoginPerson.CurrentMember;
    String mem_id=mem.getMem_id();
    ObservableList<Item_buyVO> data;
    Item_buyVO std;
    
    
    /**
     * 뒤로가기 버튼 이전페이지로 이동
     * @param event
     */
    @FXML
    void backBtn(ActionEvent event) {
    	try {

			Stage st;
			st = (Stage) TV.getScene().getWindow();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/mainscene.fxml"));
			Parent addRoot = loader.load();
			//ItemPayMentController payment=loader.getController();
			//payment.setItemId(std);

			Scene addScene = new Scene(addRoot);
			st.setScene(addScene);
			st.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    /**
     * 구매 취소버튼
     * 
     * @param event
     * @throws RemoteException 
     */
    @FXML
    void cancelBtn(ActionEvent event) throws RemoteException {
    	if(std==null) {
    		alert("구매 취소할 상품이 선택되지 않았습니다.","구매 취소할 상품을 선택하세요.");
    		return;
    	}
    	alert("선택한 상품을 구매 취소합니다.","구매취소");
    	std.setItemBuy_refend("T");
    	service.updateItemBuy(std);
    	//TV.getColumns().remove(true);
    	//getstda();
    	
    }

  
    /**
   	 *Item로 부터 DB를 가져오기 위한 연결
        * @throws RemoteException 
        * @author 류주완
        * @since2018-11-13
   	 */
   	void getstda() throws RemoteException {
   		List<Item_buyVO> ItemBuyList = service.selectItemBuyItemNameRefund();
   	
   		for(int i=0;i<ItemBuyList.size();i++) {
   			if(ItemBuyList.get(i).getMem_id().equals(mem_id)) {
   				ItemBuyListNew.add(ItemBuyList.get(i));
   				
   			}
   		}
   		
   		
   		
   		
   		if (ItemBuyListNew == null || ItemBuyListNew.size() == 0) {
   			System.out.println("\t\t 정보가 하나도 없습니다. ");
   		} else {
   			List<Item_buyVO> itemList = new ArrayList<>();
   			//아이템을 이름으로 출력
   			for (Item_buyVO mvo : ItemBuyListNew) {
   				
   				String itemBuy_name=mvo.getItem_name();
   				int itemBuy_sales = mvo.getItemBuy_sales();
   				String itemBuy_date= mvo.getItemBuy_date();
   				
   				//구매 상태를 결제완료 구매취소로 출력
   				String itemBuy_refendText=mvo.getItemBuy_refendText();
   				
   				itemList.add(mvo);

   			}
   			data = FXCollections.observableArrayList(itemList);
   		}
   		//data.setAll(ItemList);
   		TV.setItems(data);
   		
   		
   		// 제일끝의 이름과 vo의 이름을 맞추자
   		TV.getColumns().setAll(TVNUM, TVNAME,TVSALE,TVDATE,TVREFUND);

   	}


    @FXML
    void initialize() throws RemoteException {
        assert conbtn != null : "fx:id=\"conbtn\" was not injected: check your FXML file 'cancelBuyCustomer.fxml'.";
        assert btn_mine != null : "fx:id=\"btn_mine\" was not injected: check your FXML file 'cancelBuyCustomer.fxml'.";
        assert btn_attend != null : "fx:id=\"btn_attend\" was not injected: check your FXML file 'cancelBuyCustomer.fxml'.";
        assert btn_coupon != null : "fx:id=\"btn_coupon\" was not injected: check your FXML file 'cancelBuyCustomer.fxml'.";
        assert btn_ticketList != null : "fx:id=\"btn_ticketList\" was not injected: check your FXML file 'cancelBuyCustomer.fxml'.";
        assert btn_itemList != null : "fx:id=\"btn_itemList\" was not injected: check your FXML file 'cancelBuyCustomer.fxml'.";
        assert TV != null : "fx:id=\"TV\" was not injected: check your FXML file 'cancelBuyCustomer.fxml'.";
        assert TVNUM != null : "fx:id=\"TVNUM\" was not injected: check your FXML file 'cancelBuyCustomer.fxml'.";
        assert TVNAME != null : "fx:id=\"TVNAME\" was not injected: check your FXML file 'cancelBuyCustomer.fxml'.";
        //assert TVCOUNT != null : "fx:id=\"TVCOUNT\" was not injected: check your FXML file 'cancelBuyCustomer.fxml'.";
        assert TVSALE != null : "fx:id=\"TVSALE\" was not injected: check your FXML file 'cancelBuyCustomer.fxml'.";
        assert TVDATE != null : "fx:id=\"TVDATE\" was not injected: check your FXML file 'cancelBuyCustomer.fxml'.";
        assert TVREFUND != null : "fx:id=\"TVREFUND\" was not injected: check your FXML file 'cancelBuyCustomer.fxml'.";
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'AdminMainScene.fxml'.";

        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandItemService) reg.lookup("itemService");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("실패");
            e.printStackTrace();
         }
        
        

        TVNUM.setCellValueFactory(new PropertyValueFactory<Item_buyVO, String>("itemBuy_id"));
		TVNAME.setCellValueFactory(new PropertyValueFactory<Item_buyVO, String>("item_name"));
	//	TVCOUNT.setCellValueFactory(new PropertyValueFactory<Item_buyVO, Integer>("item_number"));
		TVSALE.setCellValueFactory(new PropertyValueFactory<Item_buyVO, Integer>("itemBuy_sales"));
		TVDATE.setCellValueFactory(new PropertyValueFactory<Item_buyVO, String>("itemBuy_date"));
		TVREFUND.setCellValueFactory(new PropertyValueFactory<Item_buyVO, String>("itemBuy_refendText"));
        
	getstda();
		//테이블 뷰에서 선택한 값
		TV.setOnMouseClicked(e -> {
			std = (Item_buyVO) TV.getSelectionModel().getSelectedItem();
			
			/*try {

				Stage st;
				st = (Stage) TV.getScene().getWindow();
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ItemInfo.fxml"));
				
				Parent addRoot; 
				addRoot= loader.load();
				
				//ItemInfoController InfoController = loader.getController();

				 //addController.setMainController(this);
				//InfoController.setContente(std);
				//System.out.println("std = "+std);
				Scene addScene = new Scene(addRoot);
				st.setScene(addScene);
				st.show();

			} catch (Exception e1) {
				e1.printStackTrace();
			}*/
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
