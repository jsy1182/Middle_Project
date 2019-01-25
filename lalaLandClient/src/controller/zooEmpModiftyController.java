package controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import service.IZooService;
import vo.AnimalVO;

public class zooEmpModiftyController {
	IZooService service;
	AnimalVO vo;
	String animal_id;
	public void setter(AnimalVO vo) {
		this.vo = vo;
	}
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
    	Stage stage = (Stage) btn_ok.getScene().getWindow();
    	stage.close();
    	
    }

    @FXML
    void action_ok(ActionEvent event) {
    	AnimalVO vo = new AnimalVO();
    	vo.setAnimal_name(lable_name.getText());
    	vo.setAnimal_content(animalContent.getText());
    	vo.setFarm_id(label_farm.getText());
    	vo.setAnimal_id(animal_id);
    	Stage stage = (Stage) btn_cancel.getScene().getWindow();
    	
    	try {
			int cnt = service.updateAnimal(vo);
			//System.out.println(cnt);
			if(cnt>0) {
				stage.close();
			}else {
				System.out.println("update실패");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
    public void setting() {
    	lable_name.setText(vo.getAnimal_name());
    	animalContent.setText(vo.getAnimal_content());
    	label_farm.setText(vo.getFarm_id());
    	animal_id = vo.getAnimal_id();
    	//System.out.println(animal_id);
    	
    }
    @FXML
    void initialize() {
        assert lable_name != null : "fx:id=\"lable_name\" was not injected: check your FXML file 'zooEmpModifty.fxml'.";
        assert animalContent != null : "fx:id=\"animalContent\" was not injected: check your FXML file 'zooEmpModifty.fxml'.";
        assert label_farm != null : "fx:id=\"label_farm\" was not injected: check your FXML file 'zooEmpModifty.fxml'.";
        assert btn_ok != null : "fx:id=\"btn_ok\" was not injected: check your FXML file 'zooEmpModifty.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'zooEmpModifty.fxml'.";


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
    
    
}
