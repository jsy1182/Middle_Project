package controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.IZooService;

public class zooController {
	IZooService service;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button btn_dark;

    @FXML
    private Button btn_safari;

    @FXML
    private Button btn_rost;

    @FXML
    private Button btn_monkey;

    @FXML
    private ImageView img_dark;

    @FXML
    private ImageView img_lost;

    @FXML
    private ImageView img_safari;

    @FXML
    private ImageView img_monkey;

    @FXML
    void actionDark(ActionEvent event) {
    	try {
			Parent safariScene = FXMLLoader.load(getClass().getResource("/UI/zooScene4.fxml")); 
			Stage primaryStage = (Stage)btn_safari.getScene().getWindow();
			anchorPane.getChildren().setAll(safariScene);
			
//			Scene scene = new Scene(safariScene);
//			primaryStage.setTitle("야행관");
//			primaryStage.setScene(scene);
//			primaryStage.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void hover(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/zoo로스트벨리1.png");
    	img_safari.setImage(img);

    }

    @FXML
    void hover2(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/zoo사파리1.PNG");
    	img_lost.setImage(img);

    }

    @FXML
    void hover3(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/야행관1.png");
    	img_dark.setImage(img);

    }

    @FXML
    void hover4(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/몽키벨리1.PNG");
    	img_monkey.setImage(img);

    }

    @FXML
    void hoverOout4(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/몽키벨리.PNG");
		  img_monkey.setImage(img);

    }

    @FXML
    void hoverOut(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/zoo로스트벨리.png");
		  img_safari.setImage(img);

    }

    @FXML
    void hoverOut2(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/zoo사파리.PNG");
		  img_lost.setImage(img);

    }

    @FXML
    void hoverOut3(MouseEvent event) {
    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/야행관.png");
		  img_dark.setImage(img);

    }

    @FXML
    void actionMonkey(ActionEvent event) {
    	// 몽키벨리 창 열기
    	try {
			Parent safariScene = FXMLLoader.load(getClass().getResource("/UI/zooScene5.fxml")); 
			Stage primaryStage = (Stage)btn_safari.getScene().getWindow();
			anchorPane.getChildren().setAll(safariScene);
//
//			Scene scene = new Scene(safariScene);
//			primaryStage.setTitle("몽키벨리");
//			primaryStage.setScene(scene);
//			primaryStage.show();
//			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void actionRost(ActionEvent event) {
    	// 로스트벨리 창 열기
    	try {
			Parent safariScene = FXMLLoader.load(getClass().getResource("/UI/zooScene3.fxml")); 
			Stage primaryStage = (Stage)btn_safari.getScene().getWindow();
			anchorPane.getChildren().setAll(safariScene);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void actionSafari(ActionEvent event) {
    	// 사파리 창 열기
    	try {
			Parent safariScene = FXMLLoader.load(getClass().getResource("/UI/zooScene2.fxml")); 
			Stage primaryStage = (Stage)btn_safari.getScene().getWindow();
			anchorPane.getChildren().setAll(safariScene);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

   
    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'zooScene.fxml'.";
        assert btn_dark != null : "fx:id=\"btn_dark\" was not injected: check your FXML file 'zooScene.fxml'.";
        assert btn_safari != null : "fx:id=\"btn_safari\" was not injected: check your FXML file 'zooScene.fxml'.";
        assert btn_rost != null : "fx:id=\"btn_rost\" was not injected: check your FXML file 'zooScene.fxml'.";
        assert btn_monkey != null : "fx:id=\"btn_monkey\" was not injected: check your FXML file 'zooScene.fxml'.";
        assert img_dark != null : "fx:id=\"img_dark\" was not injected: check your FXML file 'zooScene.fxml'.";
        assert img_lost != null : "fx:id=\"img_lost\" was not injected: check your FXML file 'zooScene.fxml'.";
        assert img_safari != null : "fx:id=\"img_safari\" was not injected: check your FXML file 'zooScene.fxml'.";
        assert img_monkey != null : "fx:id=\"img_monkey\" was not injected: check your FXML file 'zooScene.fxml'.";
        
        Registry reg;
		try {
			reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IZooService) reg.lookup("zoo");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final Font font = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 17);
		 
        btn_safari.setFont(font);
        btn_dark.setFont(font);
        btn_rost.setFont(font);
        btn_monkey.setFont(font);
        
        /**
         * 2018/11/23 강혜민
         */
        img_safari.setOnMouseClicked(e->{
        	// 사파리 창 열기
        	try {
    			Parent safariScene = FXMLLoader.load(getClass().getResource("/UI/zooScene2.fxml")); 
    			Stage primaryStage = (Stage)btn_safari.getScene().getWindow();
    			anchorPane.getChildren().setAll(safariScene);
    		} catch (IOException e2) {
    			e2.printStackTrace();
    		}
        });
      
        img_lost.setOnMouseClicked(e->{
        	// 로스트벨리 창 열기
        	try {
    			Parent safariScene = FXMLLoader.load(getClass().getResource("/UI/zooScene3.fxml")); 
    			Stage primaryStage = (Stage)btn_safari.getScene().getWindow();
    			anchorPane.getChildren().setAll(safariScene);
    		} catch (IOException e3) {
    			e3.printStackTrace();
    		}
        });
        
        img_dark.setOnMouseClicked(e->{
        	try {
    			Parent safariScene = FXMLLoader.load(getClass().getResource("/UI/zooScene4.fxml")); 
    			Stage primaryStage = (Stage)btn_safari.getScene().getWindow();
    			anchorPane.getChildren().setAll(safariScene);
    		} catch (IOException e4) {
    			e4.printStackTrace();
    		}
        });
        
       img_monkey.setOnMouseClicked(e->{
    	// 몽키벨리 창 열기
       	try {
   			Parent safariScene = FXMLLoader.load(getClass().getResource("/UI/zooScene5.fxml")); 
   			Stage primaryStage = (Stage)btn_safari.getScene().getWindow();
   			anchorPane.getChildren().setAll(safariScene);
   		} catch (IOException e5) {
   			e5.printStackTrace();
   		}
       });
        
    } 
}
