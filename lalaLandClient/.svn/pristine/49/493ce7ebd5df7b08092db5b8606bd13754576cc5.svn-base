package Item.controller;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import service.ILalaLandItemService;
import vo.ConvenienceVO;
import vo.ItemVO;

public class ItemInfoController {

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
    
    @FXML
    private Button buybtn;
    
    ItemVO item=new ItemVO();
   
    String imgname="";
    String URL="";
    
    public ILalaLandItemService service;

    
    @FXML
    void buybtn(ActionEvent event) {
    	if(item==null) {
    		alert("구매할 상품을 선택하세요","선택");
    		return;
    	}
    	
    	
    	alert("상품을 구매 합니다.","구매 페이지로 이동합니다.");
    	try {

			Stage st;
			st = (Stage) buybtn.getScene().getWindow();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ItemPayMent.fxml"));
			Parent addRoot = loader.load();
			/**
			 * 아이템 페이먼트 창 수정 
			 * @author 류주완
			 * 
			 */
			//anchorPane.getChildren().setAll(addRoot);
			ItemPayMentController payment=loader.getController();
			payment.setItemId(item);

			Scene addScene = new Scene(addRoot);
			st.setScene(addScene);
			st.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() throws RemoteException {
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'ItemInfo.fxml'.";
        assert namelabel != null : "fx:id=\"namelabel\" was not injected: check your FXML file 'ItemInfo.fxml'.";
        assert prilabel != null : "fx:id=\"prilabel\" was not injected: check your FXML file 'ItemInfo.fxml'.";
        assert contentlabel != null : "fx:id=\"contentlabel\" was not injected: check your FXML file 'ItemInfo.fxml'.";
        assert conidlabel != null : "fx:id=\"conidlabel\" was not injected: check your FXML file 'ItemInfo.fxml'.";
        assert buybtn != null : "fx:id=\"buybtn\" was not injected: check your FXML file 'ItemInfo.fxml'.";
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'AdminMainScene.fxml'.";

        
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandItemService) reg.lookup("itemService");
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
	public void setContente(ItemVO std) throws RemoteException {
		item=std;
		
		 //이미지 구현
	      imgname = item.getItem_id()+".jpg";
	   
	      URL="file:///D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\lalaLandClient\\Image\\Item//"+imgname;
	      //System.out.println(URL);
	      Image img = new Image(URL);
	      /**
	       * 아이템에 이미지가 없으면 사진 준비중 이미지를 띄운다.
	       * @author 류주완
	       * 2018-11-23
	       */
	      if(img.isError()) {
	    	  URL="file:///D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\lalaLandClient\\Image\\사진준비중.JPG";
		      //System.out.println(URL);
		      img = new Image(URL);
	      }
	      image.setImage(img);
        
        
        namelabel.setText(item.getItem_name());

        prilabel.setText(item.getItem_price()+"");

        contentlabel.setText(item.getItem_content());

        String con_name="";
        List<ConvenienceVO> con =service.selectConvenAll(); 
        for(int i=0;i<con.size();i++) {
        	
        	if(con.get(i).getCon_id().equals(item.getCon_id())) {
        		
        		con_name=con.get(i).getCon_title();
        	}
        }
        conidlabel.setText(con_name);
		
		
	}
	
	public void alert(String header,String msg) {
        Alert alert = new Alert(AlertType.WARNING);
        
        alert.setTitle("WARNING");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
        
     }
    
}
