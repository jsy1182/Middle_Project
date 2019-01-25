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
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.IRideService;
import vo.RideVO;

public class rideEmpSceneController {
	IRideService service;
	ObservableList<RideVO> data;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<RideVO> table_1;

    @FXML
    private TableColumn<?, ?> tb_no;

    @FXML
    private TableColumn<?, ?> tb_name;

    @FXML
    private TableColumn<?, ?> tb_date;

    @FXML
    private TableColumn<?, ?> tb_many;

    @FXML
    private TableColumn<?, ?> tb_level;

    @FXML
    private TableColumn<?, ?> tb_content;

    @FXML
    private TableColumn<?, ?> tb_height;

    @FXML
    private TableColumn<?, ?> tb_yes;

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
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/rideEmpInsert.fxml"));
    	
    	try {
			Parent child = loader.load();
			Scene scene = new Scene(child);
			stage.setScene(scene);
			stage.showAndWait();
			getRide();
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

    List<RideVO> ridelist;
    public void getRide() {
    	try {
			ridelist = service.getAllRide();
			data = FXCollections.observableArrayList(ridelist);
			table_1.setItems(data);
			/**
			 * 2018/11/23 강혜민
			 */
			btn_modify.setDisable(true);
			btn_delte.setDisable(true);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert table_1 != null : "fx:id=\"table_1\" was not injected: check your FXML file 'rideEmpScene.fxml'.";
        assert tb_no != null : "fx:id=\"tb_no\" was not injected: check your FXML file 'rideEmpScene.fxml'.";
        assert tb_name != null : "fx:id=\"tb_name\" was not injected: check your FXML file 'rideEmpScene.fxml'.";
        assert tb_date != null : "fx:id=\"tb_date\" was not injected: check your FXML file 'rideEmpScene.fxml'.";
        assert tb_many != null : "fx:id=\"tb_many\" was not injected: check your FXML file 'rideEmpScene.fxml'.";
        assert tb_level != null : "fx:id=\"tb_level\" was not injected: check your FXML file 'rideEmpScene.fxml'.";
        assert tb_content != null : "fx:id=\"tb_content\" was not injected: check your FXML file 'rideEmpScene.fxml'.";
        assert tb_height != null : "fx:id=\"tb_height\" was not injected: check your FXML file 'rideEmpScene.fxml'.";
        assert tb_yes != null : "fx:id=\"tb_yes\" was not injected: check your FXML file 'rideEmpScene.fxml'.";
        assert btn_add != null : "fx:id=\"btn_add\" was not injected: check your FXML file 'rideEmpScene.fxml'.";
        assert btn_modify != null : "fx:id=\"btn_modify\" was not injected: check your FXML file 'rideEmpScene.fxml'.";
        assert btn_delte != null : "fx:id=\"btn_delte\" was not injected: check your FXML file 'rideEmpScene.fxml'.";

        Registry reg;
		try {
			reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IRideService) reg.lookup("ride");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		getRide();
		tb_no.setCellValueFactory(new PropertyValueFactory<>("ride_id"));
		tb_name.setCellValueFactory(new PropertyValueFactory<>("ride_name"));
		tb_date.setCellValueFactory(new PropertyValueFactory<>("ride_date"));
		tb_many.setCellValueFactory(new PropertyValueFactory<>("ride_max"));
		tb_level.setCellValueFactory(new PropertyValueFactory<>("ride_diff"));
		tb_content.setCellValueFactory(new PropertyValueFactory<>("ride_content"));
		tb_height.setCellValueFactory(new PropertyValueFactory<>("ride_height"));
		tb_yes.setCellValueFactory(new PropertyValueFactory<>("ride_iden"));
		
		
		table_1.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				/**
				 * 2018/11/23 강혜민
				 */
				btn_modify.setDisable(false);
				btn_delte.setDisable(false);
				btn_delte.setOnAction(e->{
					try {
						int cnt = 0;
						String id = table_1.getSelectionModel().getSelectedItem().getRide_id();
						System.out.println(id);
						cnt = service.deleteRide(id);
						if(cnt>0) {
							getRide();
						}
					} catch (RemoteException e2) {
						e2.printStackTrace();
					}
			  }); // setonaction
				
				
				btn_modify.setOnAction(e->{
					try {
						RideVO rvo = new RideVO();
						rvo.setRide_id(table_1.getSelectionModel().getSelectedItem().getRide_id());
						rvo.setRide_name(table_1.getSelectionModel().getSelectedItem().getRide_name());
						rvo.setRide_content(table_1.getSelectionModel().getSelectedItem().getRide_content());
						rvo.setRide_date(table_1.getSelectionModel().getSelectedItem().getRide_date());
						rvo.setRide_max(table_1.getSelectionModel().getSelectedItem().getRide_max());
						rvo.setRide_diff(table_1.getSelectionModel().getSelectedItem().getRide_diff());
						rvo.setRide_iden(table_1.getSelectionModel().getSelectedItem().getRide_iden());
						rvo.setRide_height(table_1.getSelectionModel().getSelectedItem().getRide_height());
						
						Stage modify = new Stage(StageStyle.DECORATED);
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/rideEmpModify.fxml"));
						Parent pmodi = null;
						pmodi = loader.load();
						Scene mscene = new Scene(pmodi);
						
						rideEmpModifyController rmc = loader.getController();
						rmc.setter(rvo);
						rmc.setting();
						
						modify.setTitle("수정화면");
						modify.setScene(mscene);
						modify.showAndWait();
						getRide();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
			}; // handle
		}); // setonMouseClicked
		
    }
}
