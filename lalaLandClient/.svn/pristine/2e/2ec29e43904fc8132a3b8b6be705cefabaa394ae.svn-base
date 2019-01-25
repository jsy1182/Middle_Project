package member.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.text.TabableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.ILalaLandMemberService;
import vo.EmpVO;


public class EmpListController {

	public ILalaLandMemberService service;

	List<EmpVO> list;
	
	ObservableList<EmpVO> data;
	
	EmpVO emp = new EmpVO();
	
	@FXML
    private ResourceBundle resources;
    @FXML
    private AnchorPane anchoPance;
    @FXML
    private URL location;
    
    @FXML
    private Label label;

    @FXML
    private TableView<EmpVO> notice;

    @FXML
    private TableColumn<?, ?> col_id;

    @FXML
    private TableColumn<?, ?> col_part;

    @FXML
    private TableColumn<?, ?> col_tel;

    @FXML
    private TableColumn<?, ?> col_bir;

    @FXML
    private TableColumn<?, ?> col_mail;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private Button btn_search;

    @FXML
    private Button fire_btn;
    

    @FXML
    private Button btn_add;

    

    

    String colName;
    @FXML
    void click_search(ActionEvent event) {

    	if(combo.getValue().equals("놀이공원")) {
          	colName = "놀이공원";
          }else if(combo.getValue().equals("동물원")) {
          	colName = "동물원";
          }else {
          	colName = "편의시설";
          }	
        
        
        
        try {
    		list = service.searchemp(colName);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
        	data = FXCollections.observableArrayList(list);
        	notice.setItems(data);
        	
    }


    @FXML
    void click_add(ActionEvent event) {
    	Stage stage = new Stage();
	       FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/fxml/EmpAdd.fxml"));
	       
	       Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	setting();
    }

    @FXML
    void fireBtn(ActionEvent event) throws RemoteException {
    	EmpVO emp = notice.getSelectionModel().getSelectedItem();
    	
    	if(notice.getSelectionModel().isEmpty()) {
    		alert(null,"해고할 사람을 클릭 해주세요");
    		return;
    	}else {
    		int index = notice.getSelectionModel().getSelectedIndex();
    		data.remove(index);
    		
    		int chk = service.deleteemp(emp.getEmp_id());
    		
    		if(chk ==1) {
    			alert(null,"해고되었습니다 ㅠ.ㅠ ");
    		}else {
    			alert(null,"해고를 다시 시도해주세요");
    		}
    	}

    }
    public void alert(String header, String msg) {
  		Alert alert = new Alert(AlertType.WARNING);

  		alert.setTitle("WARNING");
  		alert.setHeaderText(header);
  		alert.setContentText(msg);
  		alert.showAndWait();
  	}

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'empList.fxml'.";
        assert notice != null : "fx:id=\"notice\" was not injected: check your FXML file 'empList.fxml'.";
        assert col_id != null : "fx:id=\"col_id\" was not injected: check your FXML file 'empList.fxml'.";
        assert col_part != null : "fx:id=\"col_part\" was not injected: check your FXML file 'empList.fxml'.";
        assert col_tel != null : "fx:id=\"col_tel\" was not injected: check your FXML file 'empList.fxml'.";
        assert col_bir != null : "fx:id=\"col_bir\" was not injected: check your FXML file 'empList.fxml'.";
        assert col_mail != null : "fx:id=\"col_mail\" was not injected: check your FXML file 'empList.fxml'.";
        assert combo != null : "fx:id=\"combo\" was not injected: check your FXML file 'empList.fxml'.";
        assert btn_search != null : "fx:id=\"btn_search\" was not injected: check your FXML file 'empList.fxml'.";
        assert fire_btn != null : "fx:id=\"fire_btn\" was not injected: check your FXML file 'empList.fxml'.";
		assert anchoPance != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert btn_add != null : "fx:id=\"btn_add\" was not injected: check your FXML file 'empList.fxml'.";

        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandMemberService) reg.lookup("memberService");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("member service 가져오기 실패");
            e.printStackTrace();
         }
        
        combo.getItems().addAll("놀이공원","동물원","편의시설");
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("emp_id"));
        col_tel.setCellValueFactory(new PropertyValueFactory<>("emp_tel"));
        col_bir.setCellValueFactory(new PropertyValueFactory<>("emp_bir"));
        col_mail.setCellValueFactory(new PropertyValueFactory<>("emp_mail"));
        col_part.setCellValueFactory(new PropertyValueFactory<>("emp_iden"));
        
       setting();
        
        final Font font1 = Font.loadFont(getClass().getResourceAsStream("/font/HoonWhitecatR.ttf"), 50);
        label.setFont(font1);
        
    }
    public void setting() {
    	 try {
     		list = service.getAllEmp();
     	} catch (RemoteException e) {
     		e.printStackTrace();
     	}

         
         data = FXCollections.observableArrayList(list);
         notice.setItems(data);
    }
}
