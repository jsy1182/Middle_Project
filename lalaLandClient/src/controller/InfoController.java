package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import main.CurrentLoginPerson;

public class InfoController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label la1;

    @FXML
    private Label la2;

    @FXML
    private Label la3;

    @FXML
    private Label la4;

    @FXML
    private Label la5;
    @FXML
    private ImageView facebook_img;

    @FXML
    private ImageView instagram_img;

    @FXML
    private Hyperlink hyperlink = new Hyperlink("www.facebook.com") ;

    private Hyperlink hyperlink2 = new Hyperlink("https://www.instagram.com/?hl=ko");
    
    @FXML
    void hover(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/fecebook1.png") ;
    	facebook_img.setImage(img);
    }

    @FXML
    void hover1(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/instagram1.png") ;
    	instagram_img.setImage(img);

    }

    @FXML
    void hoverOut(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/facebook.png") ;
    	facebook_img.setImage(img);
    }

    @FXML
    void hoverOut1(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/instagram.png") ;
    	instagram_img.setImage(img);

    }

    

    /**
     * 이용 가이드북 파일을 제공하는 메서드 
     * @param event
     */
    @FXML
    void click_download(MouseEvent event) {
    	try {
			FileInputStream fin = new FileInputStream("D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/data/guidebook.pdf");
			FileChooser fileChooser = new FileChooser ();
            fileChooser.setTitle ( "파일 저장");
            Stage stage = (Stage) la1.getScene().getWindow();
            
            fileChooser.getExtensionFilters().addAll(
					new ExtensionFilter("pdf", "*.pdf"));
            
            File file = fileChooser.showSaveDialog(stage);
            if (file!= null) {
               FileOutputStream fout = new FileOutputStream(file);
               byte[] buffer = new byte[1024];
               
               int readcount = 0;
               
               while((readcount = fin.read(buffer))!=-1) {
                  fout.write(buffer,0,readcount);
               }
               fout.flush();
               fout.close();
               alert("파일 전송 완료 !");
		
            }
    	}catch (Exception e) {
			e.printStackTrace();
		}

    }
    public void alert(String str) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("파일 전송");
    	alert.setContentText(str);
    	alert.showAndWait();
    }

  

    @FXML
    void initialize() {
        assert la1 != null : "fx:id=\"la1\" was not injected: check your FXML file 'info.fxml'.";
        assert la2 != null : "fx:id=\"la2\" was not injected: check your FXML file 'info.fxml'.";
        assert la3 != null : "fx:id=\"la3\" was not injected: check your FXML file 'info.fxml'.";
        assert la4 != null : "fx:id=\"la4\" was not injected: check your FXML file 'info.fxml'.";
        assert la5 != null : "fx:id=\"la5\" was not injected: check your FXML file 'info.fxml'.";
        assert facebook_img != null : "fx:id=\"facebook_img\" was not injected: check your FXML file 'info.fxml'.";
        assert instagram_img != null : "fx:id=\"instagram_img\" was not injected: check your FXML file 'info.fxml'.";
        
        
        
        final Font font = Font.loadFont(getClass().getResourceAsStream("/font/HoonWhitecatR.ttf"),25);
        final Font rfont = Font.loadFont(getClass().getResourceAsStream("/font/HoonWhitecatR.ttf"),35);
        la1.setFont(rfont);
        la2.setFont(font);
        la3.setFont(font);
        la4.setFont(font);
        la5.setFont(font);
        
        facebook_img.setOnMousePressed(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				CurrentLoginPerson.hostServices.showDocument(hyperlink.getText());
				
			}
		});
        
        instagram_img.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				CurrentLoginPerson.hostServices.showDocument(hyperlink2.getText());
				
			}
		});
    }


}
