package Food.controller;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.ILalaLandFoodService;

import vo.FoodVO;


public class FoodCustomerMainController {
///사용자 입장 -- 음식리스트
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
    private TableView<FoodVO> TV;

    @FXML
    private TableColumn<FoodVO, String> TVID;

    @FXML
    private TableColumn<FoodVO, Integer> TVPR;

    @FXML
    private TableColumn<FoodVO, String> TVCON;

    @FXML
    private TableColumn<FoodVO, String> TVSTO;

    @FXML
    private Button backbtn1;

    @FXML
    private Button buybtn1;

    private ILalaLandFoodService service=null;
    
    private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	ObservableList<FoodVO> data = null;
	
	FoodVO std=new FoodVO();
    
    
	@FXML
    void SELECTBUTTON(ActionEvent event) throws RemoteException {
    	String food_name= TF.getText();
    	List<FoodVO> food=(List<FoodVO>) service.selectFoodByName(food_name);
    	
    	
    	
    	if (food == null || food.size() == 0) {
			System.out.println("\t\t 정보가 하나도 없습니다. ");
		} else {
			List<FoodVO> foodList = new ArrayList<>();
			for (FoodVO mvo : food) {
				
				String name = mvo.getFood_name();
				int price = mvo.getFood_price();
				String content = mvo.getFood_content();
				
				foodList.add(mvo);
				

			}
			data = FXCollections.observableArrayList(foodList);
		}
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
	       try {

	         Stage st;
	         st = (Stage) TV.getScene().getWindow();


	         FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/mainscene.fxml"));

	         //FXMLLoader loader = new FXMLLoader(getClass().getResource("Item/fxml/ConvCustomerMain.fxml"));

	         //FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ConvCustomerMain.fxml"));

	         Parent addRoot = loader.load();
	         //anchorPane.getChildren().setAll(addRoot);
	         // WritingController addController = loader.getController();

	         // addController.setMainController(this);
	         // addController.setContente(std);

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
   		List<FoodVO> foodList = service.selectFoodAll();
   		System.out.println(foodList);
   		if (foodList == null || foodList.size() == 0) {
   			System.out.println("\t\t 정보가 하나도 없습니다. ");
   		} else {
   			List<FoodVO> FoodList = new ArrayList<>();
   			for (FoodVO mvo : foodList) {
   				String name = mvo.getFood_name();
   				int price = mvo.getFood_price();
   				String content = mvo.getFood_content();
   				
   				FoodList.add(mvo);

   			}
   			data = FXCollections.observableArrayList(FoodList);
   		}
   		TV.setItems(data);
   		
   		
   		// 제일끝의 이름과 vo의 이름을 맞추자
   		TV.getColumns().setAll(TVID, TVPR,  TVCON);

   	}

    @FXML
    void initialize() throws RemoteException {
        assert TF != null : "fx:id=\"TF\" was not injected: check your FXML file 'FoodCustomerMain.fxml'.";
        assert SELBUT != null : "fx:id=\"SELBUT\" was not injected: check your FXML file 'FoodCustomerMain.fxml'.";
        assert TV != null : "fx:id=\"TV\" was not injected: check your FXML file 'FoodCustomerMain.fxml'.";
        assert TVID != null : "fx:id=\"TVID\" was not injected: check your FXML file 'FoodCustomerMain.fxml'.";
        assert TVPR != null : "fx:id=\"TVPR\" was not injected: check your FXML file 'FoodCustomerMain.fxml'.";
        assert TVCON != null : "fx:id=\"TVCON\" was not injected: check your FXML file 'FoodCustomerMain.fxml'.";
        assert TVSTO != null : "fx:id=\"TVSTO\" was not injected: check your FXML file 'FoodCustomerMain.fxml'.";
        assert backbtn1 != null : "fx:id=\"backbtn1\" was not injected: check your FXML file 'FoodCustomerMain.fxml'.";
        assert buybtn1 != null : "fx:id=\"buybtn1\" was not injected: check your FXML file 'FoodCustomerMain.fxml'.";
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'AdminMainScene.fxml'.";

        
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service =  (ILalaLandFoodService) reg.lookup("foodService");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("실패");
            e.printStackTrace();
         }
        
        

        TVID.setCellValueFactory(new PropertyValueFactory<FoodVO, String>("food_name"));
		TVPR.setCellValueFactory(new PropertyValueFactory<FoodVO, Integer>("food_price"));
		//TVSOLD.setCellValueFactory(new PropertyValueFactory<ItemVO, String>("item_sold"));
		TVCON.setCellValueFactory(new PropertyValueFactory<FoodVO, String>("food_content"));
        
		
		
		getstda();
		
		TV.setOnMouseClicked(e -> {
			std = (FoodVO) TV.getSelectionModel().getSelectedItem();
			
			try {

				Stage st ;
				st = new Stage();
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/Food/fxml/FoodInfo.fxml"));
				
				Parent addRoot; 
				addRoot= loader.load();
//				anchorPane.getChildren().setAll(addRoot);
				
				FoodInfoController InfoController = loader.getController();

				 //addController.setMainController(this);
				InfoController.setContente2(std);
				
				
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
