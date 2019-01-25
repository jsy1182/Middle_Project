package controller;

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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.IZooService;
import vo.AnimalVO;

public class zooEmpController {
	ObservableList<AnimalVO> data;
	IZooService service;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<AnimalVO> table_1;

    @FXML
    private TableColumn<?, ?> tb_no;

    @FXML
    private TableColumn<?, ?> tb_name;

    @FXML
    private TableColumn<?, ?> tb_content;

    @FXML
    private TableColumn<?, ?> tb_farm;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_modify;

    @FXML
    private Button btn_delte;

    @FXML
    void action_add(ActionEvent event) {
    	Stage stage = new Stage();
    	Stage mainStage = (Stage)btn_add.getScene().getWindow();
    	stage.initOwner(mainStage);
    	stage.initModality(Modality.WINDOW_MODAL);
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/zooEmpInsert.fxml"));
    	
    	try {
			Parent child = loader.load();
			Scene scene = new Scene(child);
			stage.setScene(scene);
			stage.showAndWait();
			getTable();
			/**
			 * 2018/11/23 강혜민
			 * 
			 */
			btn_delte.setDisable(true);
			btn_modify.setDisable(true);
			///
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    }

    @FXML
    void action_delete(ActionEvent event) {
    	
    }


    @FXML
    void action_modify(ActionEvent event) {
    	
    }

    
    public void getTable() {
    	List<AnimalVO> animallist;
    	try {
			animallist = service.getAllAnimal();
			data = FXCollections.observableArrayList(animallist);
			table_1.setItems(data);
			/**
			 * 2018/11/23 강혜민
			 * 
			 */
			btn_delte.setDisable(true);
			btn_modify.setDisable(true);
			/////
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
    	assert table_1 != null : "fx:id=\"table_1\" was not injected: check your FXML file 'zooEmpScene.fxml'.";
        assert tb_no != null : "fx:id=\"tb_no\" was not injected: check your FXML file 'zooEmpScene.fxml'.";
        assert tb_name != null : "fx:id=\"tb_name\" was not injected: check your FXML file 'zooEmpScene.fxml'.";
        assert tb_content != null : "fx:id=\"tb_content\" was not injected: check your FXML file 'zooEmpScene.fxml'.";
        assert tb_farm != null : "fx:id=\"tb_farm\" was not injected: check your FXML file 'zooEmpScene.fxml'.";
        assert btn_add != null : "fx:id=\"btn_add\" was not injected: check your FXML file 'zooEmpScene.fxml'.";
        assert btn_modify != null : "fx:id=\"btn_modify\" was not injected: check your FXML file 'zooEmpScene.fxml'.";
        assert btn_delte != null : "fx:id=\"btn_delte\" was not injected: check your FXML file 'zooEmpScene.fxml'.";


        Registry reg;
		try {
			reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IZooService) reg.lookup("zoo");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		/**
		 * 2018/11/23 강혜민
		 * 
		 */
		btn_delte.setDisable(true);
		btn_modify.setDisable(true);
		//////
		getTable();
		tb_no.setCellValueFactory(new PropertyValueFactory<>("animal_id"));
		tb_name.setCellValueFactory(new PropertyValueFactory<>("animal_name"));
		tb_content.setCellValueFactory(new PropertyValueFactory<>("animal_content"));
		tb_farm.setCellValueFactory(new PropertyValueFactory<>("farm_id"));
		
		table_1.setOnMouseClicked(new EventHandler<Event>() {
			
			public void handle(Event event) {
				/**
				 * 2018/11/23 강혜민
				 * 
				 */
				btn_delte.setDisable(false);
				btn_modify.setDisable(false);
				////
				btn_delte.setOnAction(e->{
					String id = table_1.getSelectionModel().getSelectedItem().getAnimal_id();
				try {
					int cnt = service.deleteAnimal(id);
					if(cnt>0) {
						getTable();
						/**
						 * 2018/11/23 강혜민
						 * 
						 */
						btn_delte.setDisable(false);
						btn_modify.setDisable(false);
						/////
					}
					/**
					 * 2018/11/23 강혜민
					 * 
					 */
					btn_delte.setDisable(true);
					btn_modify.setDisable(true);
					///
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				});// setonaction
				
				btn_modify.setOnAction(e->{
					
			    		try {
						AnimalVO avo = new AnimalVO();
						avo.setAnimal_name(table_1.getSelectionModel().getSelectedItem().getAnimal_name());
						avo.setAnimal_content(table_1.getSelectionModel().getSelectedItem().getAnimal_content());
						avo.setFarm_id(table_1.getSelectionModel().getSelectedItem().getFarm_id());
						avo.setAnimal_id(table_1.getSelectionModel().getSelectedItem().getAnimal_id());
						
						Stage modi = new Stage(StageStyle.DECORATED);
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/zooEmpModifty.fxml"));
						Parent pmodi = null;
						pmodi = loader.load();
						Scene mscene = new Scene(pmodi);
						
						zooEmpModiftyController zmc = loader.getController();
						
						// 값 보내기
						zmc.setter(avo);
						zmc.setting();
						
						modi.setTitle("수정화면");
						modi.setScene(mscene);
						modi.showAndWait();
						/**
						 * 2018/11/23 강혜민
						 * 
						 */
						btn_delte.setDisable(false);
						btn_modify.setDisable(false);
						//////
						
						getTable();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					
				});
				
			};// handle
		});// setonmouseClicked
    }
    
  
}
