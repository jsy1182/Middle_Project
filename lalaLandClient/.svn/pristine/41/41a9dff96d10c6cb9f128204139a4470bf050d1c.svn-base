package Item.controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.text.AsyncBoxView.ChildLocator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.ILalaLandItemService;
import vo.ItemVO;

public class ItemMainController {
///관리자 --- 아이템 메인
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

    @FXML
    private TableColumn<ItemVO, String> TVSOLD;

    @FXML
    private TableColumn<ItemVO, String> TVCON;

    @FXML
    private TableColumn<ItemVO, String> TVSTO;

    @FXML
    private Button addbtn;

    @FXML
    private Button delbut;

    @FXML
    private Button modibtn;

    @FXML
    private Button btn_korean;

    @FXML
    private Button btn_english;

    @FXML
    private Button btn_music;
    
    private ILalaLandItemService service=null;
    
    private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	ObservableList<ItemVO> data = null;
	
	ItemVO std=null;

    @FXML
    void SELECTBUTTON(ActionEvent event) throws RemoteException {
    	String item_name= TF.getText();
    	List<ItemVO> item=(List<ItemVO>) service.selectItemByName(item_name);
    	
    	
    	
    	if (item == null || item.size() == 0) {
			System.out.println("\t\t 정보가 하나도 없습니다. ");
		} else {
			List<ItemVO> itemList = new ArrayList<>();
			for (ItemVO mvo : item) {
				String name = mvo.getItem_name();
				int price = mvo.getItem_price();
				String sold = mvo.getItem_sold();
				String content = mvo.getItem_content();
				
				itemList.add(mvo);

			}
			data = FXCollections.observableArrayList(itemList);
		}
//		data.setAll(item);
		TV.setItems(data);
		
		
		// 제일끝의 이름과 vo의 이름을 맞추자
		TV.getColumns().setAll(TVID, TVPR, TVSOLD, TVCON);
		
		
		
    }

    /**
     * 추가버튼
     * 선택된 아이템을 목록에 추가
     * @param event
     */
    @FXML
    void addButton(ActionEvent event) {
		try {

			Stage st;
			st = new Stage();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ItemAdd.fxml"));
			Parent addRoot = loader.load();

			// WritingController addController = loader.getController();

			// addController.setMainController(this);
			// addController.setContente(std);

			Scene addScene = new Scene(addRoot);
			st.setScene(addScene);
			st.initModality(Modality.APPLICATION_MODAL);
			st.showAndWait();
			getstda();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

   

    /**
     * 삭제버튼 
     * 선택된 아이템을 목록에서 삭제
     * @param event
     */
    @FXML
    void deleteButton(ActionEvent event) {
    	// 레이블 클릭했을때 이벤트 처리
    	
    	if(TV.getSelectionModel().getSelectedItem()==null) {
    		alert("삭제할 레이블을 선택하세요","선택");
    		return;
    	}
    	try {
			int tmp=service.deleteItem(std.getItem_id());
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
    	try {
			getstda();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	alert("선택한 레이블이 삭제 되었습니다.","삭제");
    	
    }

    /**
     * 수정버튼 
     * 선택된 아이템의 내용을 수정
     * @param event
     */
    @FXML
    void moidfyButton(ActionEvent event) {
    	
    	if(TV.getSelectionModel().getSelectedItem()==null) {
    		alert("수정할 레이블을 선택하세요","선택");
    		return;
    	}
    	
    	try {

			Stage st = new Stage();
			

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ItemModify.fxml"));
			Parent addRoot = loader.load();

			ItemModifyController addController = loader.getController();

			 //addController.setMainController(this);
			 addController.setContente(std);

			Scene addScene = new Scene(addRoot);
			st.initModality(Modality.APPLICATION_MODAL);
			st.setScene(addScene);
			st.showAndWait();
			getstda();

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
   		System.out.println(ItemList);
   		if (ItemList == null || ItemList.size() == 0) {
   			System.out.println("\t\t 정보가 하나도 없습니다. ");
   		} else {
   			List<ItemVO> itemList = new ArrayList<>();
   			for (ItemVO mvo : ItemList) {
   				String name = mvo.getItem_name();
   				int price = mvo.getItem_price();
   				String sold = mvo.getItem_sold();
   				String content = mvo.getItem_content();
   				
   				itemList.add(mvo);

   			}
   			data = FXCollections.observableArrayList(itemList);
   		}
   		data.setAll(ItemList);
   		TV.setItems(data);
   		
   		
   		// 제일끝의 이름과 vo의 이름을 맞추자
   		TV.getColumns().setAll(TVID, TVPR, TVSOLD, TVCON);

   	}

    @FXML
    void initialize() throws RemoteException {
        assert TF != null : "fx:id=\"TF\" was not injected: check your FXML file 'ItemMainV.fxml'.";
        assert SELBUT != null : "fx:id=\"SELBUT\" was not injected: check your FXML file 'ItemMainV.fxml'.";
        assert TV != null : "fx:id=\"TV\" was not injected: check your FXML file 'ItemMainV.fxml'.";
        assert TVID != null : "fx:id=\"TVID\" was not injected: check your FXML file 'ItemMainV.fxml'.";
        assert TVPR != null : "fx:id=\"TVPR\" was not injected: check your FXML file 'ItemMainV.fxml'.";
        assert TVSOLD != null : "fx:id=\"TVSOLD\" was not injected: check your FXML file 'ItemMainV.fxml'.";
        assert TVCON != null : "fx:id=\"TVCON\" was not injected: check your FXML file 'ItemMainV.fxml'.";
        assert TVSTO != null : "fx:id=\"TVSTO\" was not injected: check your FXML file 'ItemMainV.fxml'.";
        assert addbtn != null : "fx:id=\"addbtn\" was not injected: check your FXML file 'ItemMainV.fxml'.";
        assert delbut != null : "fx:id=\"delbut\" was not injected: check your FXML file 'ItemMainV.fxml'.";
        assert modibtn != null : "fx:id=\"modibtn\" was not injected: check your FXML file 'ItemMainV.fxml'.";
        assert btn_korean != null : "fx:id=\"btn_korean\" was not injected: check your FXML file 'ItemMainV.fxml'.";
        assert btn_english != null : "fx:id=\"btn_english\" was not injected: check your FXML file 'ItemMainV.fxml'.";
        assert btn_music != null : "fx:id=\"btn_music\" was not injected: check your FXML file 'ItemMainV.fxml'.";
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'AdminMainScene.fxml'.";

        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandItemService) reg.lookup("itemService");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("실패");
            e.printStackTrace();
         }
        
        setfont();

        TVID.setCellValueFactory(new PropertyValueFactory<ItemVO, String>("item_name"));
		TVPR.setCellValueFactory(new PropertyValueFactory<ItemVO, Integer>("item_price"));
		TVSOLD.setCellValueFactory(new PropertyValueFactory<ItemVO, String>("item_sold"));
		TVCON.setCellValueFactory(new PropertyValueFactory<ItemVO, String>("item_content"));
        
		
		
		getstda();
		
		TV.setOnMouseClicked(e -> {
			std = (ItemVO) TV.getSelectionModel().getSelectedItem();
			
			
		});
        
        
        
    }
    public void setfont() {
    	final Font font = Font.loadFont(getClass().getResourceAsStream("/font/THELeft.ttf"), 20);
    	SELBUT.setFont(font);
    	addbtn.setFont(font);
    	delbut.setFont(font);
    	modibtn.setFont(font);
    }
    
    public void alert(String header,String msg) {
        Alert alert = new Alert(AlertType.WARNING);
        
        alert.setTitle("WARNING");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
        
     }
    
}
