package controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.IRideService;
import vo.ParadeVO;

public class paradeController {
	IRideService service;
	ObservableList<ParadeVO> data;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<ParadeVO> table_parade;

    @FXML
    private TableColumn<ParadeVO, String> table_name;

    @FXML
    private TableColumn<ParadeVO, String> table_time;

    @FXML
    private TableColumn<ParadeVO, String> table_abailable;

    @FXML
    void initialize() {
        assert table_parade != null : "fx:id=\"table_parade\" was not injected: check your FXML file 'parade.fxml'.";
        assert table_name != null : "fx:id=\"table_name\" was not injected: check your FXML file 'parade.fxml'.";
        assert table_time != null : "fx:id=\"table_time\" was not injected: check your FXML file 'parade.fxml'.";
        assert table_abailable != null : "fx:id=\"table_abailable\" was not injected: check your FXML file 'parade.fxml'.";

        Registry reg;
		try {
			reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IRideService) reg.lookup("ride");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		 List<ParadeVO> paradelist;
		try {
			paradelist = service.getAllParade();
			data = FXCollections.observableArrayList(paradelist);
			table_parade.setItems(data);
			
			table_name.setCellValueFactory(new PropertyValueFactory<>("parade_name"));
			table_time.setCellValueFactory(new PropertyValueFactory<>("parade_time"));
			table_abailable.setCellValueFactory(new PropertyValueFactory<>("parade_yes"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		 
    }
}
