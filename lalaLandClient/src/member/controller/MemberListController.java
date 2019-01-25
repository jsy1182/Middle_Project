package member.controller;

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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import service.ILalaLandMemberService;
import vo.MemberVO;

public class MemberListController {

public ILalaLandMemberService service ;
	
	MemberVO vo = new MemberVO();
	
	List<MemberVO> list;
	
	ObservableList<MemberVO> data;
    @FXML
    private ResourceBundle resources;
	@FXML
	private AnchorPane anchorPane;
    @FXML
    private URL location;
    
    @FXML
    private Label label;

    @FXML
    private TableView<MemberVO> notice;

    @FXML
    private TableColumn<?, ?> col_id;

    @FXML
    private TableColumn<?, ?> col_name;

    @FXML
    private TableColumn<?, ?> col_tel;

    @FXML
    private TableColumn<?, ?> col_bir;

    @FXML
    private TableColumn<?, ?> col_mail;

    @FXML
    private TableColumn<?, ?> col_membership;

    @FXML
    private Button btn_search;

    @FXML
    private TextField name;

    @FXML
    private Button btn_korean;

    @FXML
    private Button btn_english;

    @FXML
    private Button btn_music2;

    

    @FXML
    void click_search(ActionEvent event) {
    	if(name.getText().isEmpty()) {
        	alert(null,"이름을 입력해주세요");
        	return;
        }
        	try {
    			list = service.searchmember(name.getText());
    		} catch (RemoteException e) {
    			e.printStackTrace();
    		}
        
        
        data = FXCollections.observableArrayList(list);
        notice.setItems(data);}
    
    public void alert(String header, String msg) {
  		Alert alert = new Alert(AlertType.WARNING);

  		alert.setTitle("WARNING");
  		alert.setHeaderText(header);
  		alert.setContentText(msg);
  		alert.showAndWait();
  	}

    @FXML
    void initialize() {
        assert notice != null : "fx:id=\"notice\" was not injected: check your FXML file 'memberList.fxml'.";
        assert col_id != null : "fx:id=\"col_id\" was not injected: check your FXML file 'memberList.fxml'.";
        assert col_name != null : "fx:id=\"col_name\" was not injected: check your FXML file 'memberList.fxml'.";
        assert col_tel != null : "fx:id=\"col_tel\" was not injected: check your FXML file 'memberList.fxml'.";
        assert col_bir != null : "fx:id=\"col_bir\" was not injected: check your FXML file 'memberList.fxml'.";
        assert col_mail != null : "fx:id=\"col_mail\" was not injected: check your FXML file 'memberList.fxml'.";
        assert col_membership != null : "fx:id=\"col_membership\" was not injected: check your FXML file 'memberList.fxml'.";
        assert btn_search != null : "fx:id=\"btn_search\" was not injected: check your FXML file 'memberList.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'memberList.fxml'.";
        assert btn_korean != null : "fx:id=\"btn_korean\" was not injected: check your FXML file 'memberList.fxml'.";
        assert btn_english != null : "fx:id=\"btn_english\" was not injected: check your FXML file 'memberList.fxml'.";
        assert btn_music2 != null : "fx:id=\"btn_music2\" was not injected: check your FXML file 'memberList.fxml'.";
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'memberList.fxml'.";


        try {	
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandMemberService) reg.lookup("memberService");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("memberService 가져오기 실패");
            e.printStackTrace();
         }
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
        col_tel.setCellValueFactory(new PropertyValueFactory<>("mem_tel"));
        col_bir.setCellValueFactory(new PropertyValueFactory<>("mem_bir"));
        col_mail.setCellValueFactory(new PropertyValueFactory<>("mem_mail"));
        col_membership.setCellValueFactory(new PropertyValueFactory<>("mem_grade"));
        
       try {
		list = service.getAllMemberList();
	} catch (RemoteException e) {
		e.printStackTrace();
	}

       data = FXCollections.observableArrayList(list);
       notice.setItems(data);
       
       final Font font1 = Font.loadFont(getClass().getResourceAsStream("/font/HoonWhitecatR.ttf"), 50);
       label.setFont(font1);
       
       	
    }
}
