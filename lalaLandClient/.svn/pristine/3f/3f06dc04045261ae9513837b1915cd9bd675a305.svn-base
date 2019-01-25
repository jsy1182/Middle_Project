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
import service.IZooService;
import vo.RideVO;

public class rideEmpModifyController {
	IRideService service;
	RideVO vo;
	String ride_id;
	public void setter(RideVO vo) {
		this.vo = vo;
	}
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
    void action_cancel(ActionEvent event) {
    	Stage stage = (Stage) btn_ok.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void action_ok(ActionEvent event) {
    	RideVO rvo = new RideVO();
    	/**
    	 * 2018/11/23 강혜민
    	 * 정규식
    	 */
    	
    	boolean a = Pattern.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}", lb_date.getText());
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
    	
    	if(lb_name.getText().isEmpty()) {
    		return;
    	}
    	if(lb_date.getText().isEmpty()) {
    		return;
    	}
    	if(lb_num.getText().isEmpty()) {
    		return;
    	}
    	if(lb_level.getText().isEmpty()) {
    		return;
    	}
    	if(txt_content.getText().isEmpty()) {
    		return;
    	}
    	if(lb_height.getText().isEmpty()) {
    		return;
    	}
    	if(lb_yes.getText().isEmpty()) {
    		return;
    	}
    	
    	/////
    	rvo.setRide_id(ride_id);
    	rvo.setRide_name(lb_name.getText());
    	rvo.setRide_content(txt_content.getText());
    	rvo.setRide_height(Integer.parseInt(lb_height.getText()));
    	rvo.setRide_date(lb_date.getText());
    	rvo.setRide_max(Integer.parseInt(lb_num.getText()));
    	rvo.setRide_diff(Integer.parseInt(lb_level.getText()));
    	rvo.setRide_iden(lb_yes.getText());
    	try {
    		int cnt = 0;
    		if(rvo == null) {
    			return;
    		}
			cnt = service.updateRide(rvo);
			if(cnt>0) {
				Stage stage = (Stage) btn_ok.getScene().getWindow();
				stage.close();
			}else {
				System.out.println("update실패");
			}
		} catch (RemoteException e2) {
			e2.printStackTrace();
		}
    	
    }

    public void setting() {
    	ride_id = vo.getRide_id();
    	System.out.println(ride_id);
    	lb_name.setText(vo.getRide_name());
    	txt_content.setText(vo.getRide_content());
    	lb_height.setText(""+vo.getRide_height());
    	lb_date.setText(vo.getRide_date());
    	lb_num.setText(""+vo.getRide_max());
    	lb_level.setText(""+vo.getRide_diff());
    	lb_yes.setText(vo.getRide_iden());	
    }
    @FXML
    void initialize() {
        assert lb_name != null : "fx:id=\"lb_name\" was not injected: check your FXML file 'rideEmpModify.fxml'.";
        assert txt_content != null : "fx:id=\"txt_content\" was not injected: check your FXML file 'rideEmpModify.fxml'.";
        assert lb_height != null : "fx:id=\"lb_height\" was not injected: check your FXML file 'rideEmpModify.fxml'.";
        assert btn_ok != null : "fx:id=\"btn_ok\" was not injected: check your FXML file 'rideEmpModify.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'rideEmpModify.fxml'.";
        assert lb_date != null : "fx:id=\"lb_date\" was not injected: check your FXML file 'rideEmpModify.fxml'.";
        assert lb_num != null : "fx:id=\"lb_num\" was not injected: check your FXML file 'rideEmpModify.fxml'.";
        assert lb_level != null : "fx:id=\"lb_level\" was not injected: check your FXML file 'rideEmpModify.fxml'.";
        assert lb_yes != null : "fx:id=\"lb_yes\" was not injected: check your FXML file 'rideEmpModify.fxml'.";

        Registry reg;
     		try {
     			reg = LocateRegistry.getRegistry("localhost", 1088);
     			service = (IRideService) reg.lookup("ride");
     			System.out.println("service lookup성공");
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
