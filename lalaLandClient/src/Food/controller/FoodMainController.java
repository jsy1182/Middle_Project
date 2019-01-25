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
import service.ILalaLandFoodService;
import vo.FoodVO;
import vo.FoodVO;

public class FoodMainController {
//관리자 --- food메인
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
    private Button addbtn;

    @FXML
    private Button delbut;

    @FXML
    private Button modibtn;
    
    private ILalaLandFoodService service=null;
    
    private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	ObservableList<FoodVO> data = null;
	
	FoodVO std=null;

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
				String sto=mvo.getCon_id();
				
				foodList.add(mvo);

			}
			data = FXCollections.observableArrayList(foodList);
		}
//		data.setAll(Food);
		TV.setItems(data);
		
		
		// 제일끝의 이름과 vo의 이름을 맞추자
		TV.getColumns().setAll(TVID, TVPR, TVCON,TVSTO);
		
    }

    /**
     * 추가버튼
     * 선택된 아이템을 목록에 추가
     * @param event
     */
    @FXML
    void addButton(ActionEvent event) {
		try {

			Stage st = new Stage();
			

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Food/fxml/FoodAdd.fxml"));
			Parent addRoot = loader.load();

			// WritingController addController = loader.getController();

			// addController.setMainController(this);
			// addController.setContente(std);

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
			int tmp=service.deleteFood(std.getFood_id());
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
			

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Food/fxml/FoodModify.fxml"));
			Parent addRoot = loader.load();
			FoodModifyController addController = loader.getController();
			

			 //addController.setMainController(this);
			 
			addController.setContente(std);

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
   	 *Food로 부터 DB를 가져오기 위한 연결
        * @throws RemoteException 
        * @author 류주완
        * @since2018-11-13
   	 */
   	void getstda() throws RemoteException {
   		List<FoodVO> FoodList = service.selectFoodAll();
   		System.out.println(FoodList);
   		
   		if (FoodList == null || FoodList.size() == 0) {
   			System.out.println("\t\t 정보가 하나도 없습니다. ");
   		} else {
   			List<FoodVO> foodList = new ArrayList<>();
   			for (FoodVO mvo : foodList) {
   				String name = mvo.getFood_name();
   				int price = mvo.getFood_price();
   				String content = mvo.getFood_content();
   				String sto=mvo.getCon_id();
   				
   				foodList.add(mvo);

   			}
   			data = FXCollections.observableArrayList(foodList);
   		}
   		data.setAll(FoodList);
   		TV.setItems(data);
   		
   		
   		// 제일끝의 이름과 vo의 이름을 맞추자
   		TV.getColumns().setAll(TVID, TVPR, TVCON,TVSTO);

   	}

    @FXML
    void initialize() throws RemoteException {
        assert TF != null : "fx:id=\"TF\" was not injected: check your FXML file 'EmpMainScene.fxml'.";
        assert SELBUT != null : "fx:id=\"SELBUT\" was not injected: check your FXML file 'EmpMainScene.fxml'.";
        assert TV != null : "fx:id=\"TV\" was not injected: check your FXML file 'EmpMainScene.fxml'.";
        assert TVID != null : "fx:id=\"TVID\" was not injected: check your FXML file 'EmpMainScene.fxml'.";
        assert TVPR != null : "fx:id=\"TVPR\" was not injected: check your FXML file 'EmpMainScene.fxml'.";
        assert TVCON != null : "fx:id=\"TVCON\" was not injected: check your FXML file 'EmpMainScene.fxml'.";
        assert TVSTO != null : "fx:id=\"TVSTO\" was not injected: check your FXML file 'EmpMainScene.fxml'.";
        assert addbtn != null : "fx:id=\"addbtn\" was not injected: check your FXML file 'EmpMainScene.fxml'.";
        assert delbut != null : "fx:id=\"delbut\" was not injected: check your FXML file 'EmpMainScene.fxml'.";
        assert modibtn != null : "fx:id=\"modibtn\" was not injected: check your FXML file 'EmpMainScene.fxml'.";
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'AdminMainScene.fxml'.";

        
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandFoodService) reg.lookup("foodService");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("실패");
            e.printStackTrace();
         }
        
        

        TVID.setCellValueFactory(new PropertyValueFactory<FoodVO, String>("food_name"));
		TVPR.setCellValueFactory(new PropertyValueFactory<FoodVO, Integer>("food_price"));
		TVCON.setCellValueFactory(new PropertyValueFactory<FoodVO, String>("food_content"));
		TVSTO.setCellValueFactory(new PropertyValueFactory<FoodVO, String>("con_id"));
        
		
		
		getstda();
		
		TV.setOnMouseClicked(e -> {
			std = (FoodVO) TV.getSelectionModel().getSelectedItem();
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
