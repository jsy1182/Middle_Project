package member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import main.CurrentLoginPerson;
import service.ILalaLandMemberService;
import vo.EmpVO;

public class EmpMyInfoController {
	
	private ILalaLandMemberService service;
	
	private EmpVO emp;
	
	private String imgname = "";
	
	private String URL = "";


	@FXML
    private ResourceBundle resources;
	@FXML
	private AnchorPane anchorPane;
    @FXML
    private URL location;

    @FXML
    private Label id;

    @FXML
    private Label tel;

    @FXML
    private Label email;

    @FXML
    private Label bir;

    @FXML
    private Label iden;

    @FXML
    private Button fix_btn;
    
    @FXML
    private Button insert_btn;
    

    @FXML
    private ImageView picture;
    

    @FXML
    void click_picture(ActionEvent event) {

    }

    
    @FXML
    void insertBtn(ActionEvent event) {
    	Stage stage = (Stage) insert_btn.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
       fileChooser.getExtensionFilters().addAll(
             new ExtensionFilter("Image File", "*.png", "*jpg", "*gif")
             );
       
       //FileOpen Dialog창을 띄우고 사용자가 선택한 파일 정보를 가져온다.
       File selectedFile = fileChooser.showOpenDialog(stage);
       
       if(selectedFile != null) { //열기버튼을 클릭하면...
          try {
             File file = new File(selectedFile.getPath());
             FileInputStream fileIn = new FileInputStream(file);
             FileInputStream fileIn2 = new FileInputStream(file);
             
             Image img = new Image(fileIn);
             picture.setImage(img);
             FileOutputStream fileOut = new FileOutputStream("D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/image/img/"+imgname);

             //fileIn.reset();
             byte[] buffer = new byte[(int) file.length()];
             
             int readcount = 0;
             
             
             while((readcount = fileIn2.read(buffer))!=-1) {
                fileOut.write(buffer,0,readcount);
             }
             fileOut.flush();
             
             
             
             
             
             
          } catch (FileNotFoundException e) {
             e.printStackTrace();
          } catch (IOException e) {
             e.printStackTrace();
          } catch(Exception e) {
             e.printStackTrace();
          }
          
       }
    }
   
    @FXML
    void fixBtn(ActionEvent event) {
    	
    	Stage stage = new Stage();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/fxml/FixImformationEmp.fxml"));
    	Parent root;
		try {
			root = loader.load();			
			Scene scene = new Scene(root);
			
			stage.setTitle("내정보 수정");
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTable();
    }
    @FXML
    void initialize() {
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'empMyInfo.fxml'.";
        assert tel != null : "fx:id=\"tel\" was not injected: check your FXML file 'empMyInfo.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'empMyInfo.fxml'.";
        assert bir != null : "fx:id=\"bir\" was not injected: check your FXML file 'empMyInfo.fxml'.";
        assert iden != null : "fx:id=\"iden\" was not injected: check your FXML file 'empMyInfo.fxml'.";
        assert fix_btn != null : "fx:id=\"fix_btn\" was not injected: check your FXML file 'empMyInfo.fxml'.";
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'mainscene.fxml'.";
        assert insert_btn != null : "fx:id=\"insert_btn\" was not injected: check your FXML file 'empMyInfo.fxml'.";
        assert picture != null : "fx:id=\"picture\" was not injected: check your FXML file 'empMyInfo.fxml'.";

        setTable();

        final Font font = Font.loadFont(getClass().getResourceAsStream("/font/HoonWhitecatR.ttf"), 35);

		tel.setFont(font);
		email.setFont(font);
		bir.setFont(font);
		iden.setFont(font);
		
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandMemberService) reg.lookup("memberService");
         } catch (RemoteException | NotBoundException e) {
             System.out.println("member service 가져오기 실패");
             e.printStackTrace();
          }
        
		imgname = emp.getEmp_id() + ".jpg";
		File file = new File("D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/img/" + imgname);
		URL="file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/img/"+imgname;
		Image img = new Image(URL);
		picture.setImage(img);
    }
    
    public void setTable() {
   	 try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandMemberService) reg.lookup("memberService");
         } catch (RemoteException | NotBoundException e) {
             System.out.println("member service 가져오기 실패");
             e.printStackTrace();
          }
        
       emp= CurrentLoginPerson.CurrentEmp;
       
//     id.setText(emp.getEmp_id());
       tel.setText(emp.getEmp_tel());
       email.setText(emp.getEmp_mail());
       bir.setText(emp.getEmp_bir().substring(0, 10));
       iden.setText(emp.getEmp_iden());
       
       
		
   }
}
