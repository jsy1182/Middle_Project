package Board.controller;

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
import javafx.scene.input.MouseEvent;
import service.IBoardService;
import vo.VoiceVO;

public class VoiceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<VoiceVO> table;

    @FXML
    private TableColumn<?, ?> col_id;

    @FXML
    private TableColumn<?, ?> col_content;

    @FXML
    private TableColumn<?, ?> col_date;

    @FXML
    void click_delete(MouseEvent event) {
    	VoiceVO voice = table.getSelectionModel().getSelectedItem();
    	if(voice.equals(null)||voice==null) {
    		return;
    	}
    	String id = voice.getVoice_id();
    	int chk ;
    	try {
			chk = service.deleteVoice(id);
			List<VoiceVO> list = service.selectVoice();
			data= FXCollections.observableArrayList(list);
			table.setItems(data);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void click_table(MouseEvent event) {
    	VoiceVO vo = table.getSelectionModel().getSelectedItem();
    	if(vo==null) {
    		return;
    	}
    }
    
    IBoardService service;
    ObservableList<VoiceVO> data ; 
    
    @FXML
    void initialize() {
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'Voice.fxml'.";
        assert col_id != null : "fx:id=\"col_id\" was not injected: check your FXML file 'Voice.fxml'.";
        assert col_content != null : "fx:id=\"col_content\" was not injected: check your FXML file 'Voice.fxml'.";
        assert col_date != null : "fx:id=\"col_date\" was not injected: check your FXML file 'Voice.fxml'.";
        
        col_content.setCellValueFactory(new PropertyValueFactory<>("voice_content"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("voice_date"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("voice_id"));
        
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (IBoardService) reg.lookup("boardService");
            List<VoiceVO> list = service.selectVoice();
			data= FXCollections.observableArrayList(list);
			table.setItems(data);
            
         } catch (RemoteException | NotBoundException e) {
            System.out.println("board service 가져오기 실패");
            e.printStackTrace();
         }
        
        

    }
}
