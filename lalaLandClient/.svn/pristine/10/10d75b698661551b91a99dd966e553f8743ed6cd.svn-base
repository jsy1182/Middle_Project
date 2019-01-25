package member.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton.ButtonType;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import service.ILalaLandMemberService;
import vo.AdminVO;
import vo.EmpVO;
import vo.MemberVO;
import javafx.scene.control.Alert.AlertType;

public class loginsceneController {
	
	private MemberVO memVo;
	private AdminVO admin;
	private EmpVO emp;
	
	public ILalaLandMemberService service;
	
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField id;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_signup;

    @FXML
    private Button btn_searchId;

    @FXML
    private Button btn_searchPass;

    @FXML
    private PasswordField pass;

    @FXML
    private Button btn_music;
    
    @FXML
    private MediaView mv;

    @FXML
    void login(ActionEvent event) throws IOException {
    	login();
    }

    private void login() throws IOException{
    	if(id.getText().isEmpty()) {
    		alert("WARMING","ID를 입력해주세요.");
    		id.requestFocus();
    		return;
    	}
    	if(pass.getText().isEmpty()) {
    		alert("WARMING","PassWord를 입력해주세요");
    		pass.requestFocus();
    		return;
    	}
    	
    	
    	Map<String, String> logIn = new HashMap<>();
    	logIn.put("mem_id", id.getText());
    	logIn.put("mem_pass", pass.getText());
    	
    	admin=service.LogInAdmin(logIn);
    	memVo = service.logInMember(logIn);
    	emp = service.LogInEmp(logIn);
    	
    	
    	Stage stage = (Stage) btn_login.getScene().getWindow();
    	FXMLLoader loader;
    	if(admin!=null) {  
    		// 관리자로 로그인한 경우
    		loader = new FXMLLoader(getClass().getResource("/ui/AdminMainScene.fxml"));
    		new CurrentLoginPerson(admin);
    		Stage st = new Stage();
    		Parent root = FXMLLoader.load(getClass().getResource("/UI/EntranceScene2.fxml"));
    		
    		Scene scene = new Scene(root);
    		st.setScene(scene);
    		st.initModality(Modality.APPLICATION_MODAL);
    		st.showAndWait();
    		
    		
    	}else if(memVo!=null) {
    		//회원으로 로그인한 경우
    		loader = new FXMLLoader(getClass().getResource("/ui/mainscene.fxml"));
    		new CurrentLoginPerson(memVo);
    		Stage st = new Stage();
    		Parent root = FXMLLoader.load(getClass().getResource("/UI/EntranceScene.fxml"));
    		
    		Scene scene = new Scene(root);
    		st.setScene(scene);
    		st.initModality(Modality.APPLICATION_MODAL);
    		st.showAndWait();
    		
    	}else if(emp!=null) {
    		//직원으로 가입한 경우
    		loader = new FXMLLoader(getClass().getResource("/ui/EmpMainScene.fxml"));
    		new CurrentLoginPerson(emp);
    		Stage st = new Stage();
    		Parent root = FXMLLoader.load(getClass().getResource("/UI/EntranceScene3.fxml"));
    		
    		Scene scene = new Scene(root);
    		st.setScene(scene);
    		st.initModality(Modality.APPLICATION_MODAL);
    		st.showAndWait();
    	}else {
    		alert(null,"아이디 혹은 비밀번호를 확인해주세요");
    		return;
    	}
    		
    		
    	Parent root ;
    	try {
    		root= loader.load();
    		Scene scene = new Scene(root);
    		
    		stage.setScene(scene);
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
		
	}

	@FXML
    void music(ActionEvent event) {
    	//AudioClip note = new AudioClip(this.getClass().getResource("/music/Openning Music.mp3").toString());
    	if(btn_music.getText()!="STOP") {
    		//play 시작
    	btn_music.setText("STOP");
    	CurrentLoginPerson.note.play();
    	}else {
    		// stop 
    		btn_music.setText("Music");
    		CurrentLoginPerson.note.stop();
    	}
    	
    }
    

    

	@FXML
    void searchId(ActionEvent event) throws IOException {

    	Stage stage = new Stage();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/fxml/SearchIDScene.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	
    	stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("아이디 찾기");
    	stage.setScene(scene);
    	stage.show();
    	
    	
    }

    @FXML
    void searchPass(ActionEvent event) throws IOException {
    	
    	Stage stage = new Stage();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/fxml/SearchPassWordScene.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	
    	stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("비밀번호 찾기");
    	stage.setScene(scene);
    	stage.show();
    	

    }

    @FXML
    void singup(ActionEvent event) throws IOException {
    	Stage stage = new Stage();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/fxml/signUpScene.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	
    	stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("회원가입");
    	stage.setScene(scene);
    	stage.show();
    	
    	

    }

    public void alert(String header,String msg) {
    	Alert alert = new Alert(AlertType.WARNING);
    	
    	alert.setTitle("WARNING");
    	alert.setHeaderText(header);
    	alert.setContentText(msg);
    	alert.showAndWait();
    	
    }
    
    MediaPlayer mediaPlayer = null;
    @FXML
    void enterMouse(MouseEvent event) {
    	//BGM
    	if(btn_music.getText()!="STOP") {
    		//play 시작
    	btn_music.setText("STOP");
    	CurrentLoginPerson.note.play();
    	}else {
    		// stop 
    		btn_music.setText("Music");
    		CurrentLoginPerson.note.stop();
    	}
    	
    	mv.setDisable(false);
    	
    	mv.setVisible(true);
        
        //MediaPlayer mediaPlayer = null;
        final String MEDIA_URL="lalamovie.mp4";
        System.out.println(location.toString());
        System.out.println(this.getClass().getResource(MEDIA_URL).toExternalForm());
        
        
        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(MEDIA_URL).toExternalForm()));
        mediaPlayer.setAutoPlay(true);
        mv.setMediaPlayer(mediaPlayer);
    	
    }

    @FXML
    void exitMouse(MouseEvent event) {
    	if(btn_music.getText()!="STOP") {
    		//play 시작
    	btn_music.setText("STOP");
    	CurrentLoginPerson.note.play();
    	}else {
    		// stop 
    		btn_music.setText("Music");
    		CurrentLoginPerson.note.stop();
    	}
    	mediaPlayer.setVolume(0);
    	mv.setDisable(true);
    	mv.setVisible(false);
    	
    }
    
    @FXML
    void initialize() {
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'loginscene.fxml'.";
        assert btn_login != null : "fx:id=\"btn_login\" was not injected: check your FXML file 'loginscene.fxml'.";
        assert btn_signup != null : "fx:id=\"btn_signup\" was not injected: check your FXML file 'loginscene.fxml'.";
        assert btn_searchId != null : "fx:id=\"btn_searchId\" was not injected: check your FXML file 'loginscene.fxml'.";
        assert btn_searchPass != null : "fx:id=\"btn_searchPass\" was not injected: check your FXML file 'loginscene.fxml'.";
        assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'loginscene.fxml'.";
        assert btn_music != null : "fx:id=\"btn_music\" was not injected: check your FXML file 'loginscene.fxml'.";
        assert mv != null : "fx:id=\"mv\" was not injected: check your FXML file 'loginscene.fxml'.";
        CurrentLoginPerson.CurrentAdmin=null;
        CurrentLoginPerson.CurrentEmp=null;
        CurrentLoginPerson.CurrentMember=null;
        
        
        try {	
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandMemberService) reg.lookup("memberService");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("memberService 가져오기 실패");
            e.printStackTrace();
         }
        
        CurrentLoginPerson.note.play();
        btn_music.setText("STOP");
        
        if (CurrentLoginPerson.note.isPlaying())
			btn_music.setText("STOP");
		else {
			btn_music.setText("Music");
		}
        pass.setOnKeyPressed(e->{
			try {
				btnsetting(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
        id.setOnKeyPressed(e->btnset(e));

    }

	private void btnset(KeyEvent e) {
		if(e.getCode()==KeyCode.TAB) {
			pass.requestFocus();
		}
	}

	private void btnsetting(KeyEvent e) throws IOException {
		if(e.getCode()==KeyCode.ENTER) {
			login();
		}
	}

	
}
