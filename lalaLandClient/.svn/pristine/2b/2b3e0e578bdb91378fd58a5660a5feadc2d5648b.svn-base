package controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import service.IZooService;
import vo.AnimalVO;

public class zooEmpInsertController { 
	IZooService service;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lable_name;

    @FXML
    private TextArea animalContent;

    @FXML
    private TextField label_farm;

    @FXML
    private Button btn_ok;

    @FXML
    private Button btn_cancel;

    @FXML
    void action_cancel(ActionEvent event) {
    /**
     * 	2018/11/23 강혜민
     * 동물 insert시 값을 안 넣었을때 오류잡기 
     */
    	Stage mystage = (Stage)btn_ok.getScene().getWindow();
    	mystage.close();
    }

    @FXML
    void action_ok(ActionEvent event) {
    	Stage mystage = (Stage)btn_ok.getScene().getWindow();
    	AnimalVO avo = new AnimalVO();
    	/**
    	 * 2018/11/23 강혜민
    	 * 동물 insert시 값을 안 넣었을때 오류잡기 
    	 */
    	/////
    	if(label_farm.getText().length() == 0 || lable_name.getText().length() == 0 || animalContent.getText().length() == 0) {
    		alert("입력오류", "정확히 입력해주세요.");
    		Optional<ButtonType> result = alert.showAndWait();
    		return;
    	}
    	////
    	avo.setAnimal_name(lable_name.getText());
    	avo.setAnimal_content(animalContent.getText());
    	avo.setFarm_id(label_farm.getText());
    	
    	try {
			int cnt = service.insertAnimal(avo);
			if(cnt>0) {
				mystage.close();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void initialize() {
        assert lable_name != null : "fx:id=\"lable_name\" was not injected: check your FXML file 'zooEmpInsert.fxml'.";
        assert animalContent != null : "fx:id=\"animalContent\" was not injected: check your FXML file 'zooEmpInsert.fxml'.";
        assert label_farm != null : "fx:id=\"label_farm\" was not injected: check your FXML file 'zooEmpInsert.fxml'.";
        assert btn_ok != null : "fx:id=\"btn_ok\" was not injected: check your FXML file 'zooEmpInsert.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'zooEmpInsert.fxml'.";

        Registry reg;
      		try {
      			reg = LocateRegistry.getRegistry("localhost", 1088);
      			service = (IZooService) reg.lookup("zoo");
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
