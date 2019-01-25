package Item.controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import Food.controller.FoodInfoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.ILalaLandFoodService;
import service.ILalaLandItemService;
import vo.FoodVO;
import vo.ItemVO;

public class ConvCustomerMainController {

	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;
	    

	    @FXML
	    private Button Itembtn;

	    @FXML
	    private Button foodbtn;
	    
	    @FXML
	    private AnchorPane anchorPane;
	    
	    ILalaLandItemService service;
	    ILalaLandFoodService service2;
	    ItemVO item2;
	    FoodVO food2;

    @FXML
    void Itembtn(ActionEvent event) {
    	try {

			Stage st;
			st = (Stage) Itembtn.getScene().getWindow();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ItemCustomerMain.fxml"));
			Parent addRoot = loader.load();
			anchorPane.getChildren().setAll(addRoot);

			// WritingController addController = loader.getController();

			// addController.setMainController(this);
			// addController.setContente(std);

//			Scene addScene = new Scene(addRoot);
//		st.setScene(addScene);
//			st.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    

    @FXML
    void foodbtn(ActionEvent event) {
    	try {

			Stage st;
			st = (Stage) Itembtn.getScene().getWindow();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Food/fxml/FoodCustomerMain.fxml"));
			Parent addRoot = loader.load();
			anchorPane.getChildren().setAll(addRoot);

			// WritingController addController = loader.getController();

			// addController.setMainController(this);
			// addController.setContente(std);

//			Scene addScene = new Scene(addRoot);
//			st.setScene(addScene);
//			st.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public void getItem(String item_id) throws RemoteException {
    	List<ItemVO> item=service.selectItemAll();
    	List<FoodVO> food=service2.selectFoodAll();
    	
    	System.out.println(item_id);
    	System.out.println(item);
    	System.out.println(food);
    	System.out.println(item_id.substring(0, 1));
    	
    	if((item_id.substring(0, 1).trim()).equals("i")) {
    		System.out.println("i로시작");
    		for(int i=0;i< item.size();i++) {
    			if(item.get(i).getItem_id().equals(item_id)) {
    				item2=item.get(i);
    				System.out.println(item2);
    			}
    		}
    	}else {
    		System.out.println("f로시작");
    		for(int i=0;i< food.size();i++) {
    			if(food.get(i).getFood_id().equals(item_id)) {
    				food2=food.get(i);
    				System.out.println(food2);
    			}
    		}
    	}
    	
    }
    
    @FXML
    void food1(MouseEvent event) throws RemoteException {
    	
		getItem("f409");
		System.out.println(food2);
		try {

			Stage st;
			st = new Stage();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Food/fxml/FoodInfo.fxml"));
			
			Parent addRoot; 
			addRoot= loader.load();
//			anchorPane.getChildren().setAll(addRoot);
			
			FoodInfoController InfoController = loader.getController();

			 //addController.setMainController(this);
			InfoController.setContente2(food2);
			//System.out.println("std = "+std);
			Scene addScene = new Scene(addRoot);
			st.initModality(Modality.APPLICATION_MODAL);
			st.setScene(addScene);
			st.show();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }

    @FXML
    void food2(MouseEvent event) throws RemoteException {
    	getItem("f308");
		
		try {

			Stage st;
			st = new Stage();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Food/fxml/FoodInfo.fxml"));
			
			Parent addRoot; 
			addRoot= loader.load();
//			anchorPane.getChildren().setAll(addRoot);
			
			FoodInfoController InfoController = loader.getController();

			 //addController.setMainController(this);
			InfoController.setContente2(food2);
			//System.out.println("std = "+std);
			Scene addScene = new Scene(addRoot);
			st.initModality(Modality.APPLICATION_MODAL);
			st.setScene(addScene);
			st.show();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }


    @FXML
    void item1(MouseEvent event) throws RemoteException {
    	getItem("i303");
		
		try {

			Stage st;
			st = new Stage();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ItemInfo.fxml"));
			
			Parent addRoot; 
			addRoot= loader.load();
//			anchorPane.getChildren().setAll(addRoot);
			
			ItemInfoController InfoController = loader.getController();

			 //addController.setMainController(this);
			InfoController.setContente(item2);
			//System.out.println("std = "+std);
			Scene addScene = new Scene(addRoot);
			st.initModality(Modality.APPLICATION_MODAL);
			st.setScene(addScene);
			st.show();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }

    @FXML
    void item2(MouseEvent event) throws RemoteException {
    	getItem("i111");
		
		try {

			Stage st;
			st = new Stage();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ItemInfo.fxml"));
			
			Parent addRoot; 
			addRoot= loader.load();
//			anchorPane.getChildren().setAll(addRoot);
			
			ItemInfoController InfoController = loader.getController();

			 //addController.setMainController(this);
			InfoController.setContente(item2);
			//System.out.println("std = "+std);
			Scene addScene = new Scene(addRoot);
			st.initModality(Modality.APPLICATION_MODAL);
			st.setScene(addScene);
			st.show();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }

    @FXML
    void initialize() throws RemoteException {
        assert Itembtn != null : "fx:id=\"Itembtn\" was not injected: check your FXML file 'ConvCustomerMain.fxml'.";
        assert foodbtn != null : "fx:id=\"foodbtn\" was not injected: check your FXML file 'ConvCustomerMain.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'ConvCustomerMain.fxml'.";
        
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandItemService) reg.lookup("itemService");
            service2 = (ILalaLandFoodService) reg.lookup("foodService");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("실패");
            e.printStackTrace();
         }
        
        

    }
}
