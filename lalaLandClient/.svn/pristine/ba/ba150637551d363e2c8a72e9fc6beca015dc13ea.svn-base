package buy;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ItemAndTicketViewMainController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView ticketimg;

    @FXML
    private ImageView giftimg;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    void ExitGift(MouseEvent event) {
    	lbl2.setText("");
    }

    
    @FXML
    void clkgift(MouseEvent event) {
    	gotoViewItemPage();
    }

    @FXML
    void clkticket(MouseEvent event) {
    	gotoViewBuyPage();
    }

    @FXML
    void enterGift(MouseEvent event) {
    	lbl2.setText("아이템 구매 내역");
    	setFont();
    }

    @FXML
    void enterTicket(MouseEvent event) {
    	lbl1.setText("티켓 구매 내역");
    	setFont();
    }

    @FXML
    void exitTicket(MouseEvent event) {
    	lbl1.setText("");
    }

    @FXML
    void initialize() {
    	assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'ItemAndTicketViewMain.fxml'.";
        assert ticketimg != null : "fx:id=\"ticketimg\" was not injected: check your FXML file 'ItemAndTicketViewMain.fxml'.";
        assert giftimg != null : "fx:id=\"giftimg\" was not injected: check your FXML file 'ItemAndTicketViewMain.fxml'.";
        assert lbl1 != null : "fx:id=\"lbl1\" was not injected: check your FXML file 'ItemAndTicketViewMain.fxml'.";
        assert lbl2 != null : "fx:id=\"lbl2\" was not injected: check your FXML file 'ItemAndTicketViewMain.fxml'.";

    }
    
    public void setFont() {
        final Font font = Font.loadFont(getClass().getResourceAsStream("/font/HoonlefthanderR.otf"), 35);
        lbl1.setFont(font);
        lbl2.setFont(font);
    }
    
    public void gotoViewBuyPage() {
    	try {
    		FXMLLoader loader=new FXMLLoader(
    				getClass().getResource("/buy/ViewBuy.fxml")
    				);
    		Parent buy;
			buy=loader.load();
			anchorPane.getChildren().setAll(buy);
//			Stage buyStage=(Stage) lbl1.getScene().getWindow();
//			
//			Scene scene=new Scene(buy);
//			buyStage.setTitle("티켓조회화면");
//			buyStage.setScene(scene);
//			buyStage.show();
//			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    			
    }//end of gotoMainPage
    
    public void gotoViewItemPage() {
    	try {

    		FXMLLoader loader=new FXMLLoader(
    				getClass().getResource("/Item/fxml/cancelBuyCustomer.fxml")
    				);
    		Parent buy;
    		buy=loader.load();
    		anchorPane.getChildren().setAll(buy);
//    		Stage buyStage=(Stage) lbl1.getScene().getWindow();
//    		
//    		Scene scene=new Scene(buy);
//    		buyStage.setTitle("티켓조회화면");
//    		buyStage.setScene(scene);
//    		buyStage.show();
    		
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    }//end of gotoMainPage
}
