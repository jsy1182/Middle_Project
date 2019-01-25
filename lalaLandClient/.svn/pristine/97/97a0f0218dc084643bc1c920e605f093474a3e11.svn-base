package game.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.lf5.viewer.categoryexplorer.TreeModelAdapter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import service.IEventJoinService;
import service.IEventService;
import service.ILalaLandMemberService;
import vo.EventVO;
import vo.Event_joinVO;
import vo.MemberVO;

public class FaceGameOkController {

	ILalaLandMemberService service;

	public MemberVO member;

	List<EventVO> evlist = null; // 가져온 이벤트 내용를 넣는다
	
    private Event_joinVO ej = new Event_joinVO(); // event_join에 대한 내용을 가지고 있다
    
    String event_id = "ev002"; // 이벤트 아이디
    
    
    private IEventService evservice; // 이벤트를 가지고 오려고 필요


    private IEventJoinService ejservice; // insert를 하기위해 필요
    

 
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button ok_btn;

	@FXML
	private Label name;
	
	

	@FXML
	void okBtn(ActionEvent event) {
		

		Stage stage = (Stage) name.getScene().getWindow();
		stage.close();

	}

	@FXML
	void initialize() {
		assert ok_btn != null : "fx:id=\"ok_btn\" was not injected: check your FXML file 'FaceGameOk.fxml'.";
		assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'FaceGameOk.fxml'.";

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (ILalaLandMemberService) reg.lookup("memberService");
			ejservice = (IEventJoinService) reg.lookup("eventJoinService");
			evservice = (IEventService) reg.lookup("eventService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("member service 가져오기 실패");
			e.printStackTrace();
		}

		member = CurrentLoginPerson.CurrentMember;

		FaceRecognition test = new FaceRecognition();

		try {
			test.setConnection();
			test.setFileTransfer();
			test.receiveResponse();
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}

	public class FaceRecognition {

		// 사용자 계정
		private final String ID = "HPhMS5z3Rlc1P1bvVauw";
		private final String PASS = "60fJyesyCs";

		// 서비스 연결 컨넥션
		private HttpsURLConnection con;

		// 얼굴인식 URL 연결 설정메서드
		public void setConnection() {
			String apiURL = "https://openapi.naver.com/v1/vision/celebrity";

			// 얼굴감지
			// String apiURL2 ="https://openapi.naver.com/v1/vision/face";
			try {
				URL url = new URL(apiURL);
				con = (HttpsURLConnection) url.openConnection();

				con.setUseCaches(false);
				con.setDoOutput(true);
				con.setDoInput(true);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// 파일전송 설정
		public void setFileTransfer() {
			String boundary = "---" + System.currentTimeMillis() + "---";
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			con.setRequestProperty("X-Naver-Client-Id", ID);
			con.setRequestProperty("X-Naver-Client-Secret", PASS);
			try {
				OutputStream out = con.getOutputStream();
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, "UTF-8"), true);

				String LINE_FEED = "\r\n";

				// 검사할 파일 읽기
				String imgFile;
				imgFile = getClass().getResource(member.getMem_id() + ".jpg").getPath();
				File uploadFile = new File(imgFile);
				String paramName = "image";

				String fileName = uploadFile.getName();
				writer.append("---" + boundary).append(LINE_FEED);
				writer.append(
						"Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + fileName + "\"")
						.append(LINE_FEED);
				writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
				writer.append(LINE_FEED);
				writer.flush();

				FileInputStream fin = new FileInputStream(uploadFile);
				byte[] buffer = new byte[4096];
				int len = 0;
				while ((len = fin.read(buffer)) != -1) {
					out.write(buffer, 0, len);
				}
				out.flush();

				fin.close();
				writer.append(LINE_FEED).flush();
				writer.append("--" + boundary + "--").append(LINE_FEED);
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 응답 수신
		public void receiveResponse() {

			try {
				BufferedReader br = null;
				int responseCode = con.getResponseCode();// 응답코드
				
				if (responseCode == 200) {// 정상처리
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));

				} else {// 오류
					name.setText("바로 당신");
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				}

				String inputLine;
				if (br != null) {
					StringBuffer response = new StringBuffer();
					while ((inputLine = br.readLine()) != null) {
						response.append(inputLine);
					}

					br.close();
					name.setText("☆ " + response.toString().substring(89, 94) + " ☆");
					System.out.println(response.toString());
					if (response.toString().substring(89, 94).contains("김") || 
						response.toString().substring(89, 94).contains("황") ||
						response.toString().substring(89, 94).contains("이")) {
						try {
							evlist = evservice.allEvent();
							member = CurrentLoginPerson.CurrentMember;
							
							for (int i = 0; i < evlist.size(); i++) {
								if(evlist.get(i).getEvent_id().equals(event_id)) {
									ej.setEvent_id(evlist.get(i).getEvent_id());
									ej.setMem_id(member.getMem_id());
								}
							}
							
							/**
							 * insert를 사용해 자료를 넣어준다
							 * 0보다 크면 성공 아니면 실패
							 */
							int ejcount = ejservice.insertEventJoin(ej);
							if(ejcount > 0) { 
//								alert(null, "등록 성공");
							}else {
								alert(null,"실패");
							}
						} catch (RemoteException e) {
							e.printStackTrace();
						}
						alert(null,"쿠폰 지급");
					}else {
						alert(null," 닮은 연예인중에 '김', '이', '황' 이 들어가지 않습니다.");
					}
				}
			} catch (Exception e) {
			}

		}
		
		public synchronized void pictureFolder() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 

		public void alert(String header, String msg) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("WARNING");
			alert.setHeaderText(header);
			alert.setContentText(msg);
			alert.showAndWait();
		}

	}
}
