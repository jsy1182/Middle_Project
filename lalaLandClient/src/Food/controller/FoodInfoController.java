package Food.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import service.ILalaLandFoodService;
import service.ILalaLandItemService;
import service.ILalaLandMemberService;
import vo.ConvenienceVO;
import vo.FoodVO;
import vo.ItemVO;

public class FoodInfoController {

	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;
	    @FXML
	    private AnchorPane anchorPane;
	    @FXML
	    private ImageView image;

	    @FXML
	    private Label namelabel;

	    @FXML
	    private Label prilabel;

	    @FXML
	    private Label contentlabel;

	    @FXML
	    private Label conidlabel;
    
    FoodVO food=new FoodVO();
    String imgname="";
    String URL="";
    
    public ILalaLandFoodService service;

   
    @FXML
    void click_goback(ActionEvent event) {
    	Stage stage = (Stage) namelabel.getScene().getWindow();
    	stage.close();
    	

    }

   

    @FXML
    void initialize() throws RemoteException {
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'ItemInfo.fxml'.";
        assert namelabel != null : "fx:id=\"namelabel\" was not injected: check your FXML file 'ItemInfo.fxml'.";
        assert prilabel != null : "fx:id=\"prilabel\" was not injected: check your FXML file 'ItemInfo.fxml'.";
        assert contentlabel != null : "fx:id=\"contentlabel\" was not injected: check your FXML file 'ItemInfo.fxml'.";
        assert conidlabel != null : "fx:id=\"conidlabel\" was not injected: check your FXML file 'ItemInfo.fxml'.";
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'AdminMainScene.fxml'.";

        
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandFoodService) reg.lookup("foodService");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("board service 가져오기 실패");
            e.printStackTrace();
         }
        
        final Font font = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 15);
        final Font font2 = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 13);


        namelabel.setFont(font);
        prilabel.setFont(font);
        contentlabel.setFont(font2);
        conidlabel.setFont(font);
        
        
     
        
        
    }
    /**
     * 아이템 상세 페이지 내용을 채워주기위해 
     * 선택한 레이블의 정보를 가져온다.
     * @param std
     * @throws RemoteException 
     */
	public void setContente2(FoodVO std) throws RemoteException{
		food=std;
		
		 //이미지 구현
		
	      imgname = food.getFood_id()+".jpg";
	   
	      URL="file:///D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\lalaLandClient\\Image\\Food//"+imgname;
	      Image img = new Image(URL);
	      /**
	       * 음식에 이미지가 없으면 사진 준비중 이미지를 띄운다.
	       * @author 류주완
	       * 2018-11-23
	       */
	      if(img.isError()) {
	    	  URL="file:///D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\lalaLandClient\\Image\\사진준비중.JPG";
		      //System.out.println(URL);
		      img = new Image(URL);
	      }
	      
	      
	      image.setImage(img);
	      
	      namelabel.setText(food.getFood_name());
	       
	       prilabel.setText(food.getFood_price()+"");
	      

	       contentlabel.setText(food.getFood_content());
	       

	      String con_name="";
	       List<ConvenienceVO> con =service.selectConenAll(); 
	       for(int i=0;i<con.size();i++) {
	       	
	       	if(con.get(i).getCon_id().equals(food.getCon_id())) {
	       		
	       		con_name=con.get(i).getCon_title();
	       	}
	       }
	       conidlabel.setText(con_name);
       
       
		
		
	}
	
	
    
}
