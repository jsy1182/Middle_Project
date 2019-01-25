package Board.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.IBoardService;
import vo.AdminVO;
import vo.EmpVO;
import vo.MessageVO;

public class MessageController {
	AdminVO admin;
	EmpVO emp ;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<MessageVO> table;

    @FXML 
    private TableColumn<?, ?> col_date;

    @FXML
    private TableColumn<?, ?> col_content;

    @FXML
    private TableColumn<?, ?> col_from;

    @FXML
    private Pagination pagination;

    @FXML
    private Button btn_send;

    @FXML
    private Button btn_delete;
    
    @FXML
    void table_click(MouseEvent event) {
    	
    	MessageVO message = table.getSelectionModel().getSelectedItem();
    	if(message==null)return;    	
    	Stage stage= (Stage) table.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/ViewMessage.fxml"));
    	
    	Parent root;
		try {
			root = loader.load();
			ViewMessageController controller = loader.getController();
			controller.setMessage(message);
			Scene scene = new Scene(root);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	

    }

    @FXML
    void click_delete(ActionEvent event) {
    	MessageVO message = (MessageVO) table.getSelectionModel().getSelectedItem();
    	if(message==null)return;
    	int chk ;
    	
    	try {
			chk= service.deleteMessage(message.getMessage_id());
			if(chk>0) alert("쪽지 삭제 성공");
			else alert("쪽지 삭제 실패");
			setTable();
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	

    }
    
    private void alert(String string) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText(string);
		alert.showAndWait();
		
	} 

    @FXML
    void click_send(ActionEvent event) {
    	
    	Stage stage= (Stage) table.getScene().getWindow();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/ViewMessage.fxml"));
    	
    	Parent root;
		try {
			root = loader.load();
			ViewMessageController controller = loader.getController();
			controller.setting();
			Scene scene = new Scene(root);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	

    }
    IBoardService service;
    List<MessageVO> list ;
    ObservableList<MessageVO> data ;
    private int datasize ;
    private int rowperpage = 10 ;
    
    @FXML
    void initialize() {
    	assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'message.fxml'.";
        assert col_date != null : "fx:id=\"col_date\" was not injected: check your FXML file 'message.fxml'.";
        assert col_content != null : "fx:id=\"col_content\" was not injected: check your FXML file 'message.fxml'.";
        assert col_from != null : "fx:id=\"col_from\" was not injected: check your FXML file 'message.fxml'.";
        assert pagination != null : "fx:id=\"pagination\" was not injected: check your FXML file 'message.fxml'.";
        assert btn_send != null : "fx:id=\"btn_send\" was not injected: check your FXML file 'message.fxml'.";
        assert btn_delete != null : "fx:id=\"btn_delete\" was not injected: check your FXML file 'message.fxml'.";

        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (IBoardService) reg.lookup("boardService");
           
         } catch (RemoteException | NotBoundException e) {
            System.out.println("board service 가져오기 실패");
            e.printStackTrace();
         }
        
        col_content.setCellValueFactory(new PropertyValueFactory<>("message_content"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("message_date"));
        col_from.setCellValueFactory(new PropertyValueFactory<>("message_from"));
        
        admin = CurrentLoginPerson.CurrentAdmin;
        emp = CurrentLoginPerson.CurrentEmp;
        
        setTable();
        
        
    }
    
    public void setTable() {
        if(admin!=null) {
        	try {
				list = service.selectMessageList(admin.getAdmin_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
        }else {
        	try {
				list = service.selectMessageList(emp.getEmp_id());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
        }
        datasize = list.size();
		
		data = FXCollections.observableArrayList(list);
		table.setItems(data);
		int pageCount ;
		if(datasize==0) {
			pageCount=0;
		}
		pageCount= datasize / rowperpage + (datasize % rowperpage == 0 ? 0 : 1);
		pagination.setPageCount(pageCount);
		pagination.setMaxPageIndicatorCount(pageCount);
		changeTableView(0);
		
		pagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {
			 
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				changeTableView(newValue.intValue());
			}
 
		});
    }
    
    
    
    public void changeTableView(int index) {
		int fromIndex = index * rowperpage; // 가져올 데이터의 시작번호
		int toIndex = Math.min(fromIndex + rowperpage, datasize);

		table.setItems(FXCollections.observableArrayList(list.subList(fromIndex, toIndex)));
	}
    
}
