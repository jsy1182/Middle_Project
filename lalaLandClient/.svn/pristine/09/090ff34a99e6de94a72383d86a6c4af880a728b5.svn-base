package buy;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import service.ILalaLandBuyService;
import vo.BuyVO;
import vo.MemberVO;

public class ViewBuyController {
	ILalaLandBuyService service;
	List<BuyVO> list;
	BuyVO selVO;
	ObservableList<BuyVO> data;
	MemberVO member;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<BuyVO> table;

    @FXML
    private TableColumn<BuyVO, String> buyId;

    @FXML
    private TableColumn<BuyVO, String> buyKind;

    @FXML
    private TableColumn<BuyVO, String> buyMem;

    @FXML
    private TableColumn<BuyVO, Integer> buySales;

    @FXML
    private TableColumn<BuyVO, String> buyDate;

    @FXML
    private TableColumn<BuyVO, String> buyStatus;

    @FXML
    private Button backBtn;

    @FXML
    private Button btnCancel;


    @FXML
    void clkbackBtn(ActionEvent event) {
    	gotomain();
    }

    @FXML
    void clkcancelBtn(ActionEvent event) {
    	if(selVO==null) {
    		walert("환불실패", "구매내역을 선택해주세요.");
    		return;
    	}
    	if(selVO.getRefund().equals("환불 불가능")) {
    		walert("환불실패", "이미 환불받은 상품입니다.");
    		return;
    	}
    	alert("환불확인", "정말로 구매취소 하시겠습니까???");
		Optional<ButtonType> result=alert.showAndWait();
		if(result.get()==ButtonType.OK) {
			String buy_id=selVO.getBuy_id();
			try {
				int update=service.refundTicket(buy_id);
				if(update>0) {
					aalert("업데이트 성공", "정상적으로 환불처리 되었습니다.");
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setTable();
		}
    }//end of clkcancel

    @FXML
    void initialize() {
    	assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'ViewBuy.fxml'.";
        assert buyId != null : "fx:id=\"buyId\" was not injected: check your FXML file 'ViewBuy.fxml'.";
        assert buyKind != null : "fx:id=\"buyKind\" was not injected: check your FXML file 'ViewBuy.fxml'.";
        assert buyMem != null : "fx:id=\"buyMem\" was not injected: check your FXML file 'ViewBuy.fxml'.";
        assert buySales != null : "fx:id=\"buySales\" was not injected: check your FXML file 'ViewBuy.fxml'.";
        assert buyDate != null : "fx:id=\"buyDate\" was not injected: check your FXML file 'ViewBuy.fxml'.";
        assert buyStatus != null : "fx:id=\"buyStatus\" was not injected: check your FXML file 'ViewBuy.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'ViewBuy.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'ViewBuy.fxml'.";
        member = CurrentLoginPerson.CurrentMember;
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandBuyService) reg.lookup("buy");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("실패");
            e.printStackTrace();
         }
        setTable();
        
        table.setOnMouseClicked(e->{
        	selVO=table.getSelectionModel().getSelectedItem();
        });
        
    }//end of initialize()
    
    public void gotomain() {
    	try {
			Stage st;
			st = (Stage) backBtn.getScene().getWindow();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/mainscene.fxml"));
			Parent addRoot = loader.load();
			//ItemPayMentController payment=loader.getController();
			//payment.setItemId(std);

			Scene addScene = new Scene(addRoot);
			st.setScene(addScene);
			st.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
    }//end of gotomain()
    
    public void setTable() {
    	try {
			list=service.getBuyVOwithId(member.getMem_id());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	buyId.setCellValueFactory(new PropertyValueFactory<BuyVO, String>("buy_id"));
    	buyKind.setCellValueFactory(new PropertyValueFactory<BuyVO, String>("ticket_id"));
		buyMem.setCellValueFactory(new PropertyValueFactory<BuyVO, String>("mem_id"));
		buySales.setCellValueFactory(new PropertyValueFactory<BuyVO, Integer>("sales"));
		buyDate.setCellValueFactory(new PropertyValueFactory<BuyVO, String>("buy_date"));
		buyStatus.setCellValueFactory(new PropertyValueFactory<BuyVO, String>("refund"));
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTicket_id().equals("tc001")) {
				list.get(i).setTicket_id("어린이");
			}else if(list.get(i).getTicket_id().equals("tc002")) {
				list.get(i).setTicket_id("청소년");
			}else if(list.get(i).getTicket_id().equals("tc003")) {
				list.get(i).setTicket_id("성인");
			}else if(list.get(i).getTicket_id().equals("tc004")) {
				list.get(i).setTicket_id("어린이(연간)");
			}else if(list.get(i).getTicket_id().equals("tc005")) {
				list.get(i).setTicket_id("청소년(연간)");
			}else if(list.get(i).getTicket_id().equals("tc006")) {
				list.get(i).setTicket_id("성인(연간)");
			}
			if(list.get(i).getRefund().equals("F")) {
				list.get(i).setRefund("결제 완료");
			}else {
				list.get(i).setRefund("환불 완료");
			}
		}
		data = FXCollections.observableArrayList(list);
		table.setItems(data);
    }
    
    public void walert(String header,String msg) {
		Alert walert=new Alert(AlertType.WARNING);
		
		walert.setTitle("등록실패");
		walert.setHeaderText(header);
		walert.setContentText(msg);
		
		walert.show();
	}//end of walert
    
    public void aalert(String header,String msg) {
    	Alert walert=new Alert(AlertType.INFORMATION);
    	
    	walert.setTitle("환불성공");
    	walert.setHeaderText(header);
    	walert.setContentText(msg);
    	
    	walert.show();
    }//end of walert
    
    Alert alert;
    public void alert(String header,String msg) {
		alert=new Alert(AlertType.CONFIRMATION);
		
		alert.setTitle("구매확인");
		alert.setHeaderText(header);
		alert.setContentText(msg);
	}//end of alert
    
}
