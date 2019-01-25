package Item.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ConvEmpMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchoPane;

    @FXML
    private Label lb1;

    @FXML
    private Label lb2;

    @FXML
    void enterGift(MouseEvent event) {
    	lb1.setVisible(true);
    }

    @FXML
    void enterRes(MouseEvent event) {
    	lb2.setVisible(true);
    }

    @FXML
    void exitGift(MouseEvent event) {
    	lb1.setVisible(false);
    }

    @FXML
    void exitRes(MouseEvent event) {
    	lb2.setVisible(false);
    }

    @FXML
    void gomanageGift(MouseEvent event) {
    	Stage stage = (Stage) lb1.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ItemMain.fxml"));
        Parent addRoot;
		try {
			addRoot = loader.load();
			anchoPane.getChildren().setAll(addRoot);

//	        Scene addScene = new Scene(addRoot);
//	        stage.setScene(addScene);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void gomanageRes(MouseEvent event) {
    	Stage stage = (Stage) lb2.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Food/fxml/FoodMain.fxml"));
        Parent addRoot;
		try {
			addRoot = loader.load();
			anchoPane.getChildren().setAll(addRoot);
//	        Scene addScene = new Scene(addRoot);
//	        stage.setScene(addScene);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert anchoPane != null : "fx:id=\"anchoPane\" was not injected: check your FXML file 'ConvEmpMain.fxml'.";
        assert lb1 != null : "fx:id=\"lb1\" was not injected: check your FXML file 'ConvEmpMain.fxml'.";
        assert lb2 != null : "fx:id=\"lb2\" was not injected: check your FXML file 'ConvEmpMain.fxml'.";
        setLabel();
    }
    
    public void setLabel() {
    	lb1.setVisible(false);
    	lb2.setVisible(false);
    	final Font font = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 25);
    	lb1.setFont(font);
    	lb2.setFont(font);
    }
}
