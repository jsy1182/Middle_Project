package controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import service.IRideService;
import vo.RideVO;

public class rideEmpInsertController {
	IRideService service;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lb_name;

    @FXML
    private TextArea txt_content;

    @FXML
    private TextField lb_height;

    @FXML
    private Button btn_ok;

    @FXML
    private Button btn_cancel;

    @FXML
    private TextField lb_date;

    @FXML
    private TextField lb_num;

    @FXML
    private TextField lb_level;

    @FXML
    private TextField lb_yes;
    
    @FXML
    private TextField lb_position;

    @FXML
    void action_cancel(ActionEvent event) {
    	/**
    	 * 2018/11/23
    	 */
    	Stage stage = (Stage) btn_cancel.getScene().getWindow();
    	stage.close();
    	//
    }

    @FXML
    void action_ok(ActionEvent event) {
    	/**
    	 * 2018/11/23 강혜민
    	 */
    	if(
    		lb_name.getText().length() == 0 ||
    	    txt_content.getText().length() == 0 ||
    	    lb_height.getText().length() == 0 || 
    	    lb_date.getText().length() == 0 || 
    	    lb_num.getText().length() == 0 || 
    	    lb_level.getText().length() == 0 || 
    	    lb_yes.getText().length() == 0 || 
    	    lb_position.getText().length() == 0) {
    		alert("입력오류", "값을 정확히 입력해주세요.");
    		Optional<ButtonType> result = alert.showAndWait();
    		return;
    	}
    	//////
    	Stage stage = (Stage) btn_ok.getScene().getWindow();
    	RideVO rvo = new RideVO();
    	/**
    	 * 2018/11/23 강혜민
    	 * 정규식
    	 */
    	
    	boolean a = Pattern.matches("^[0-9]{4}/[0-9]{2}/[0-9]{2}", lb_date.getText());
    	if(a == false) {
    		alert("입력오류", "건설날짜는 0000/00/00 으로 입력해주세요.");
    		Optional<ButtonType> result = alert.showAndWait();
    		return;
    	}
    	boolean b = Pattern.matches("^[0-9]*$", lb_num.getText());
    	if(b == false) {
    		alert("입력오류", "탑승인원은 숫자로 입력해주세요.");
    		Optional<ButtonType> result = alert.showAndWait();
    		return;
    	}
    	boolean c = Pattern.matches("^[0-9]*$", lb_level.getText());
    	if(c == false) {
    		alert("입력오류", "난이도는 숫자로 입력해주세요.");
    		Optional<ButtonType> result = alert.showAndWait();
    		return;
    	}
    	boolean d = Pattern.matches("^[0-9]*$", lb_height.getText());
    	if(d == false) {
    		alert("입력오류", "키는 숫자로 입력해주세요.");
    		Optional<ButtonType> result = alert.showAndWait();
    		return;
    	}
    	boolean e = Pattern.matches("^[T|F]", lb_yes.getText());
    	if(e == false) {
    		alert("입력오류", "운행여부는 T또는 F로 입력해주세요.");
    		Optional<ButtonType> result = alert.showAndWait();
    		return;
    	}
    	boolean f = Pattern.matches("^[0-9]*,[0-9]*", lb_position.getText());
    	if(f == false) {
    		alert("입력오류", "위치는 00,00로 입력해주세요.");
    		Optional<ButtonType> result = alert.showAndWait();
    		return;
    	}
    	
    	/////
    	rvo.setRide_name(lb_name.getText());
    	rvo.setRide_content(txt_content.getText());
    	rvo.setRide_height(Integer.parseInt(lb_height.getText()));
    	rvo.setRide_date(lb_date.getText());
    	rvo.setRide_max(Integer.parseInt(lb_num.getText()));
    	rvo.setRide_diff(Integer.parseInt(lb_level.getText()));
    	rvo.setRide_iden(lb_yes.getText());
    	rvo.setRide_pos(lb_position.getText());
    	
    	try {
			int cnt = service.InsertRide(rvo);
			if(cnt>0) {
				stage.close();
			}
		} catch (RemoteException e2) {
			e2.printStackTrace();
		}
    	
    }

    @FXML
    void initialize() {
        assert lb_name != null : "fx:id=\"lb_name\" was not injected: check your FXML file 'rideEmpInsert.fxml'.";
        assert txt_content != null : "fx:id=\"txt_content\" was not injected: check your FXML file 'rideEmpInsert.fxml'.";
        assert lb_height != null : "fx:id=\"lb_height\" was not injected: check your FXML file 'rideEmpInsert.fxml'.";
        assert btn_ok != null : "fx:id=\"btn_ok\" was not injected: check your FXML file 'rideEmpInsert.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'rideEmpInsert.fxml'.";
        assert lb_date != null : "fx:id=\"lb_date\" was not injected: check your FXML file 'rideEmpInsert.fxml'.";
        assert lb_num != null : "fx:id=\"lb_num\" was not injected: check your FXML file 'rideEmpInsert.fxml'.";
        assert lb_level != null : "fx:id=\"lb_level\" was not injected: check your FXML file 'rideEmpInsert.fxml'.";
        assert lb_yes != null : "fx:id=\"lb_yes\" was not injected: check your FXML file 'rideEmpInsert.fxml'.";
        assert lb_position != null : "fx:id=\"lb_position\" was not injected: check your FXML file 'rideEmpInsert.fxml'.";


        Registry reg;
		try {
			reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IRideService) reg.lookup("ride");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
    }
    
    Alert alert;
    public void alert (String header,String msg) {
      alert=new Alert(AlertType.WARNING);
      
      alert.setTitle("Insert불가");
      alert.setHeaderText(header);
      alert.setContentText(msg);
   }//end of alert
}
