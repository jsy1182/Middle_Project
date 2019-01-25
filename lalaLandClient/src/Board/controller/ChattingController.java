package Board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.text.DefaultCaret;

import org.controlsfx.control.textfield.TextFields;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import vo.MemberVO;

public class ChattingController implements Initializable {

	String URL = null;
	private String imgname = "";
	MemberVO member;

	Image img_bot = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/봇.PNG");
	Image img_mem;
	
	

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

    @FXML
    private TextField txtMsg;

	@FXML
	private Button btn_send;

	@FXML
	private ScrollPane scrollpane;

	@FXML
	private VBox vbox;

	@FXML
	private HBox hbox;

	@FXML
	private ImageView img_admin;

	@FXML
	private Label ta_admin;

	@FXML
	void click_exit(ActionEvent event) {

		Stage stage = (Stage) vbox.getScene().getWindow();
		stage.close();
	}

	@FXML
	void click_send(ActionEvent event) {
		sendMsg();
	}

	// 엔터 전송
	public void tfMsgSend(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			sendMsg();
			txtMsg.clear();
		}
	}

	public void sendMsg() {
		try {
			String str = null;

			String uText = txtMsg.getText();
			if (uText.length() > 20) {
				uText = uText.substring(0, 20) + "\n" + uText.substring(20);
			}
			ChattingViewHBox h_member = new ChattingViewHBox(img_mem, uText, true);
			vbox.getChildren().add(h_member);

			if (uText.contains("상품권")) {
				str = "죄송하지만, 라라랜드에서 \n사용 가능한 상품권은 없습니다.";
			} else if (uText.contains("아이템 구매") && uText.contains("언제")) {

				str = "아이템 구매 후 현장에서 \n지급 도와드리고 있습니다. ";

			} else if (uText.contains("제공되는 파일")) {
				str = "저희 라라랜드에서 제공되는 파일로는 \n 이용 가이드북.pdf이 있습니다.";
			} else if (uText.contains("놀이기구")) {
				if (uText.contains("추천")) {
					str = "저희 라라랜드 가장 대표적인 놀이기구로는 \n자이로 스윙이 있습니다.";
				} else if (uText.contains("제일") || uText.contains("무서운")) {
					str = "제일 무서운 놀이기구로는 \n자이로드롭이지 않을까 싶습니다. ";
				} else if (uText.contains("보유한 놀이기구")) {
					str = "저희가 보유한 놀이기구는 총 24개 입니다.";
				} else {
					str = "놀이기구에 대한 질문 더\n 추가하도록 하겠습니다.";
				}

			} else if (uText.contains("유모차")) {

				if (uText.contains("어디")) {
					str = "제공되는 유모차는 신밧드의 \n 모험 입구옆에서 제공해드리고 있습니다. ";
				} else {
					str = "저희 라라랜드는 가족 고객분들께 \n 유모차를 제공해드리고 있습니다.";
				}
			} else if (uText.contains("안녕")) {
				int decider = (int) (Math.random() * 2 + 1);
				if (decider == 1) {
					str = "안녕하세요 고객님 항상 감사드립니다. ^^";
				} else if (decider == 2) {
					str = "환상의 나라 라라랜드입니다 ^o^ ";
				}

			} else {
				str = "등록되지 않은 질문입니다.\n 문의전화는 0000-0000 입니다.";
			}
			botSay(str);
			txtMsg.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void botSay(String s) {
		try {
			ChattingViewHBox h_admin = new ChattingViewHBox(img_bot, s, false);
			vbox.getChildren().add(h_admin);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {
		assert txtMsg != null : "fx:id=\"txtMsg\" was not injected: check your FXML file 'chatting.fxml'.";
		assert btn_send != null : "fx:id=\"btn_send\" was not injected: check your FXML file 'chatting.fxml'.";
		assert scrollpane != null : "fx:id=\"scrollpane\" was not injected: check your FXML file 'chatting.fxml'.";
		assert vbox != null : "fx:id=\"vbox\" was not injected: check your FXML file 'chatting.fxml'.";
		assert hbox != null : "fx:id=\"hbox\" was not injected: check your FXML file 'chatting.fxml'.";
		assert img_admin != null : "fx:id=\"img_admin\" was not injected: check your FXML file 'chatting.fxml'.";
        assert txtMsg != null : "fx:id=\"txtMsg\" was not injected: check your FXML file 'chatting.fxml'.";

     // scroll to bottom
     Platform.runLater(new Runnable() {
         @Override
         public void run() {
             scrollpane.setVvalue(1.0);
         }
     });
     
     

	}
	private static String[] possibleWords = { "라라랜드에서 제공되는 파일이 있나요?", "라라랜드는 총 몇개의 놀이기구를 보유하고 있나요?", 
			"놀이기구 추천해주세요.","안녕하세요","아이템 구매한 건 언제 받을 수 있나요?",
			"놀이기구 중 가장 무서운 건 뭐가 있나요?", "라라랜드에서 유모차 대여해주나요?", "유모차는 어디에서 대여받나요?" };


	@Override
	public void initialize(java.net.URL location, ResourceBundle resources) {
		TextFields.bindAutoCompletion(txtMsg, possibleWords);
		
		scrollpane.vvalueProperty().bind(vbox.heightProperty());
	}

	public void setting() {
		member = CurrentLoginPerson.CurrentMember;
		
		imgname = member.getMem_id() + ".jpg";
		File file = new File("D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/img/"+imgname);
		if(file.exists()) {
			URL = "file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/image/img/" + imgname;
		}else {
			URL = "file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/image/noimage.jpg";
			
		}
		
		img_mem=new Image(URL);
		hbox.setVisible(true);
		ta_admin.setText("라라랜드입니다 무엇을 도와드릴까요?");

		txtMsg.setOnKeyPressed(e -> tfMsgSend(e));
	}

}
