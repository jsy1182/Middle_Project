package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Optional;
import java.util.ResourceBundle;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import member.controller.MyInfoController;
import service.IBoardService;
import service.ILalaLandMemberService;
import vo.MemberVO;
import vo.VoiceVO;

public class MainSceneController {
	private MemberVO member;
	public ILalaLandMemberService service;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
    @FXML
    private ImageView img;

	@FXML
	private MenuItem btn_mine;

	@FXML
	private MenuItem btn_attend;

	@FXML
	private MenuItem btn_coupon;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private ImageView image;

	@FXML
	private ImageView imageView;

	@FXML
	private Button btn_music;

	@FXML
	private Label localLabel;

	@FXML
	private Label weatherLabel;

	@FXML
	private ImageView mainPicture;

	@FXML
	private ImageView tmp_picture;

	@FXML
	private Label localInput;

	@FXML
	private Label weatherInput;

	@FXML
	private Label tmpInput;

	@FXML
	private Label tmpLabel;

	@FXML
	private Label text;
    @FXML
    private ImageView img2;

    @FXML
    private ImageView img1;

	/**
	 * 메인 로고 텍스트 추가
	 * 
	 * @author 류주완 2018-11-26
	 * @param event
	 */
    @FXML
    void hoverr(MouseEvent event) {
    	
    }

    @FXML
    void hoverrOut(MouseEvent event) {
    	
    }
	  @FXML
	    void hover(MouseEvent event) {
		  Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/img1.png");
		  img1.setImage(img);
	    }

	    @FXML
	    void hover2(MouseEvent event) {
	    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/img2.png");
			  img2.setImage(img);
	    }

	    @FXML
	    void hoverOut(MouseEvent event) {
	    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/로봇Event.PNG");
			  img1.setImage(img);
	    }

	    @FXML
	    void hoverOut2(MouseEvent event) {
	    	Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/faceEvent.PNG");
			  img2.setImage(img);
	    }
	@FXML
	void settext1(MouseEvent event) {
		text.setVisible(true);
	}

	@FXML
	void settext2(MouseEvent event) {
		text.setVisible(false);
	}
	IBoardService Bservice ;
	@FXML
	void click_voice(MouseEvent event) {
		TextInputDialog prompt = new TextInputDialog("감사합니다.");
		prompt.setTitle("고객 소리함");
		prompt.setHeaderText(null);
		prompt.setContentText("언제나 고객의 소리를 듣겠습니다.");

		Optional<String> result = prompt.showAndWait();

		String strResult = null;
		if (result.isPresent()) {
			strResult = result.get();
		}else {
			alert("취소되었습니다.");
			return;
		}
		VoiceVO voice = new VoiceVO();
		voice.setVoice_content(strResult);
		int chk;

		try {
			chk = Bservice.insertVoice(voice);
			if (chk > 0)
				alert("소중한 의견과 관심 항상 감사합니다. ");
			else
				alert("다시 한번 시도해주시면 감사하겠습니다.");
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
	private void alert(String string) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText(string);
		alert.showAndWait();

	}

	@FXML
	void click_animal(ActionEvent event) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/zooScene.fxml"));

			Parent root;

			root = loader.load();
			anchorPane.getChildren().setAll(root);
			/*
			 * Scene scene = new Scene(root); stage.setScene(scene);
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

/*	@FXML
	void click_attend(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/attend/controller/calendar.fxml"));

			Parent root;

			root = loader.load();
			anchorPane.getChildren().setAll(root);
			
			 * Scene scene = new Scene(root); stage.setScene(scene);
			 

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
*/

	@FXML
	void click_bulk(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/buy/GroupBuy.fxml"));

			Parent root;

			root = loader.load();
			anchorPane.getChildren().setAll(root);
			/*
			 * Scene scene = new Scene(root); stage.setScene(scene);
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_buy(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/buy/BuyScene.fxml"));

			Parent root;

			root = loader.load();
			anchorPane.getChildren().setAll(root);
			/*
			 * Scene scene = new Scene(root); stage.setScene(scene);
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_cancelBuy(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/buy/ItemAndTicketViewMain.fxml"));

			Parent root;

			root = loader.load();
			anchorPane.getChildren().setAll(root);
			/*
			 * Scene scene = new Scene(root); stage.setScene(scene);
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_cancelRes(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/reserveScene2.fxml"));

			Parent root;

			root = loader.load();
			anchorPane.getChildren().setAll(root);
			/*
			 * Scene scene = new Scene(root); stage.setScene(scene);
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_chat(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardChat.fxml"));

		Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root);
			/*
			 * Scene scene = new Scene(root); stage.setScene(scene);
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void click_con(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ConvCustomerMain.fxml"));
			Parent root = loader.load();

			// WritingController addController = loader.getController();

			// addController.setMainController(this);
			// addController.setContente(std);
			anchorPane.getChildren().setAll(root);
			/*
			 * Scene addScene = new Scene(addRoot); st.setScene(addScene); st.show();
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_coupon(ActionEvent event) {
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Coupon.fxml"));

			Parent root = loader.load();

			Scene scene = new Scene(root);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void click_faceEvent(MouseEvent event) {
		// 닮은 사진 이벤트
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/game/main/faceGame.fxml"));

			Parent root = loader.load();

			Scene scene = new Scene(root);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_game(MouseEvent event) {
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/game/main/GameScene.fxml"));

			Parent root;

			root = loader.load();
//			anchorPane.getChildren().setAll(root);

			Scene scene = new Scene(root);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_info(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/info.fxml"));
		Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_itembuy(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ItemCustomerMain.fxml"));
			Parent root = loader.load();

			// WritingController addController = loader.getController();

			// addController.setMainController(this);
			// addController.setContente(std);
			anchorPane.getChildren().setAll(root);
			/*
			 * Scene addScene = new Scene(addRoot); st.setScene(addScene); st.show();
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_logout(ActionEvent event) {
		Stage stage = (Stage) btn_music.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/fxml/loginscene.fxml"));
		Parent root;
		try {
			root = loader.load();
			CurrentLoginPerson.note.stop();
			Scene addScene = new Scene(root);
			stage.setScene(addScene);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_mine(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/fxml/myInfo.fxml"));
		Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root);
			/*
			 * Scene addScene = new Scene(addRoot); stage.setScene(addScene);
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_music(ActionEvent event) {
		// AudioClip note = new AudioClip(this.getClass().getResource("/music/Openning
		// Music.mp3").toString());
		if (btn_music.getText() != "STOP") {
			// play 시작
			btn_music.setText("STOP");
			CurrentLoginPerson.note.play();
		} else {
			// stop
			btn_music.setText("Music");
			CurrentLoginPerson.note.stop();
		}
	}

	@FXML
	void click_notice(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardMain.fxml"));

		Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root);
//			Scene scene = new Scene(root);
//			stage.setScene(scene);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_rdie(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/RideScene.fxml"));

			Parent root;

			root = loader.load();
			anchorPane.getChildren().setAll(root);
			/*
			 * Scene scene = new Scene(root); stage.setScene(scene);
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_res(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/reserveScene.fxml"));

			Parent root;

			root = loader.load();
			anchorPane.getChildren().setAll(root);
			/*
			 * Scene scene = new Scene(root); stage.setScene(scene);
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void click_main(MouseEvent event) {

		Stage stage = (Stage) btn_music.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/mainscene.fxml"));

		Parent root;
		try {
			root = loader.load();

			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void clilck_qa(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardQA.fxml"));

		Parent root;
		try {
			root = loader.load();
			anchorPane.getChildren().setAll(root);
			/*
			 * Scene scene = new Scene(root); stage.setScene(scene);
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void initialize() {
		assert btn_mine != null : "fx:id=\"btn_mine\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert btn_coupon != null : "fx:id=\"btn_coupon\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert img2 != null : "fx:id=\"img2\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert img1 != null : "fx:id=\"img1\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert imageView != null : "fx:id=\"imageView\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert tmpInput != null : "fx:id=\"tmpInput\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert tmp_picture != null : "fx:id=\"tmp_picture\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert weatherInput != null : "fx:id=\"weatherInput\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert btn_music != null : "fx:id=\"btn_music\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert text != null : "fx:id=\"text\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert img != null : "fx:id=\"img\" was not injected: check your FXML file 'mainscene.fxml'.";


		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (ILalaLandMemberService) reg.lookup("memberService");
			Bservice = (IBoardService) reg.lookup("boardService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("memberService 가져오기 실패");
			e.printStackTrace();
		}

		if (CurrentLoginPerson.note.isPlaying())
			btn_music.setText("STOP");
		else {
			btn_music.setText("Music");
		}
		Image img = new Image("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/회전목마1.gif");
		imageView.setImage(img);

		weather();

	}

	/**
	 * @author 오지원
	 * @since 2018-11-23
	 * 
	 *        날씨기능
	 */
	public void weather() {

		try {
			// 서울시청의 위도와 경도
			String lon = "127.38500"; // 경도
			String lat = "36.35111"; // 위도

			// OpenAPI call하는 URL
			String urlstr = "http://api.openweathermap.org/data/2.5/weather?" + "lat=" + lat + "&lon=" + lon
					+ "&appid=08f4c5d61d93eceff37f2cf8ea1b4e24";
			URL url = new URL(urlstr);
			BufferedReader bf;
			String line;
			String result = "";

			// 날씨 정보를 받아온다.
			bf = new BufferedReader(new InputStreamReader(url.openStream()));

			// 버퍼에 있는 정보를 문자열로 변환.
			while ((line = bf.readLine()) != null) {
				result = result.concat(line);
				// System.out.println(line);
			}

			// 문자열을 JSON으로 파싱
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObj = (JsonObject) jsonParser.parse(result);

			// 지역 출력
//	            System.out.println("지역 : " + jsonObj.get("name"));

			// 날씨 출력
			JsonArray weatherArray = (JsonArray) jsonObj.get("weather");
			JsonObject obj = (JsonObject) weatherArray.get(0);
			String weather = "" + obj.get("main");

			// 온도 출력(절대온도라서 변환 필요)
			JsonObject mainArray = (JsonObject) jsonObj.get("main");
			double ktemp = Double.parseDouble(mainArray.get("temp").toString());
			double temp = ktemp - 273.15;

			bf.close();

			weatherInput.setText(weather);
			tmpInput.setText("" + (int)(temp)+".3" + "도");

			if (weather.equals("\"Clear\"")) {
				String URL = "file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/image/해.png";
				Image img = new Image(URL);
				tmp_picture.setImage(img);
			} else if (weather.equals("\"Fog\"")) {
				String URL = "file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/image/흐림.png";
				Image img = new Image(URL);
				tmp_picture.setImage(img);

			} else if (weather.equals("\"Mist\"")) {
				String URL = "file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/image/흐림.png";
				Image img = new Image(URL);
				tmp_picture.setImage(img);

			} else if (weather.equals("\"Rain\"")) {
				String URL = "file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/image/비.png";
				Image img = new Image(URL);
				tmp_picture.setImage(img);

			} else if (weather.equals("\"Snow\"")) {
				String URL = "file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/image/눈.png";
				Image img = new Image(URL);
				tmp_picture.setImage(img);

			}else if (weather.equals("\"Clouds\"")) {
				String URL = "file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/image/흐림.png";
				Image img = new Image(URL);
				tmp_picture.setImage(img);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
