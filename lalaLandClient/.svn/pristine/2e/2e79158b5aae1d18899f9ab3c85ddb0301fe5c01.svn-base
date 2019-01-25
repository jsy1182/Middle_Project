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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.CurrentLoginPerson;
import service.IAttendService;
import service.ILalaLandMemberService;
import vo.AttendVO;
import vo.BuyVO;
import vo.MemberVO;

public class MyInfoController {

	private ILalaLandMemberService service;
	
	private MemberVO member;
	
	private BuyVO buy;
	
//	private SalesTicketVO saleTickek;
	
	private String URL="";
	   
	private String imgname = "";
	

	private IAttendService attendService = null;
	
	private List<MemberVO> mem;
	
	AttendVO vo;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem btn_mine;

    @FXML
    private MenuItem btn_attend;

    @FXML
    private MenuItem btn_coupon;

    @FXML
    private MenuItem btn_ticketList;

    @FXML
    private MenuItem btn_itemList;

    @FXML
    private Label name;

    @FXML
    private ImageView picture;

    @FXML
    private Button picture_button;

    @FXML
    private Button fix_btn;

    @FXML
    private Label tel;

    @FXML
    private Label email;

    @FXML
    private Label bir;

    @FXML
    private Label membership;
    
  
    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;
    
    @FXML
    private DatePicker dp;

    @FXML
    private Button attend;

    @FXML
    private Label lbl;

  
    /**
	 * 출석체크를 한다
	 * 출석을 했는지에 대한 중복 체크를 한다
	 * 오늘이 아닌 날을 누르려하면 출석날이 아니라고 한다
	 * 2018-11-23
	 * @author 김민재 
	 * @param event 버튼 클릭이벤트
	 * @throws RemoteException
	 */
    @FXML
    void attencance(ActionEvent event) throws RemoteException {
    	vo.setMem_id(member.getMem_id()); // 로그인한 아이디를 넣는다
    	if(dp.getValue() == null) {
			alert(null, "날짜를 선택해주세요");
			dp.requestFocus();
			return;
		}
		String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		if (dp.getValue().equals(LocalDate.now()) && vo.getMem_id().equals(member.getMem_id())
				&& vo.getAttend_yes().equals("T")) {
			lbl.setText("이미 출석을 하셨습니다");
		} else if (dp.getValue().equals(LocalDate.now()) && vo.getMem_id().equals(member.getMem_id())) {
			vo.setAttend_yes("T");
			lbl.setText("출석하셨습니다");
			int chk = attendService.insertAttend(vo);
			if(chk>0) {
				System.out.println("insert 성공");
			}else {
				System.out.println("insert 실패");
			}
		} else {
			lbl.setText("출석일이 아닙니다");
		}
    }
    
    /**
	 * 출석을 하기위해 미리 설정을 해놓는다
	 * 2018-11-23
	 * @author 김민재
	 * @param vo 출석객체를 받아서 셋팅해준다
	 * @return vo 셋팅한 객체를 다시 돌려준다
	 */
	AttendVO setAttend(AttendVO vo){
		String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
		vo.setAttend_date(today);
		vo.setAttend_yes("F");
		vo.setMem_id(member.getMem_id());
		return vo;
	}

	public void alert(String header, String msg) {
    	Alert warning = new Alert(AlertType.WARNING);
    	
    	warning.setTitle("오류");
    	warning.setHeaderText(header);
    	warning.setContentText(msg);
    	warning.showAndWait();
    }

    @FXML
    void fixBtn(ActionEvent event) throws RemoteException  {

    	Stage stage = new Stage();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/fxml/FixImformation.fxml"));
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
    void pictureButton(ActionEvent event) {
       Stage stage = (Stage) picture_button.getScene().getWindow();
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
            FileInputStream fileIn3 = new FileInputStream(file);
            
            Image img = new Image(fileIn);
            picture.setImage(img);
            FileOutputStream fileOut = new FileOutputStream("D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/image/img/"+imgname);
            FileOutputStream fileOut2 = new FileOutputStream("D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/src/game/main/"+imgname);

            //fileIn.reset();
            byte[] buffer = new byte[(int) file.length()];
            byte[] buffer2 = new byte[(int) file.length()];
            
            int readcount = 0;
            
            
            while((readcount = fileIn2.read(buffer))!=-1) {
               fileOut.write(buffer,0,readcount);
            }
            fileOut.flush();
            
            while((readcount = fileIn3.read(buffer2))!=-1) {
            	fileOut2.write(buffer, 0, readcount);
            }
            fileOut2.flush();
            
            
            
            
            
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
    void initialize() throws RemoteException {
        assert btn_mine != null : "fx:id=\"btn_mine\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert btn_attend != null : "fx:id=\"btn_attend\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert btn_coupon != null : "fx:id=\"btn_coupon\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert btn_ticketList != null : "fx:id=\"btn_ticketList\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert btn_itemList != null : "fx:id=\"btn_itemList\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert picture != null : "fx:id=\"picture\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert picture_button != null : "fx:id=\"picture_button\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert fix_btn != null : "fx:id=\"fix_btn\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert tel != null : "fx:id=\"tel\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert bir != null : "fx:id=\"bir\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert membership != null : "fx:id=\"membership\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert label2 != null : "fx:id=\"label2\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert label3 != null : "fx:id=\"label3\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert label4 != null : "fx:id=\"label4\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert label5 != null : "fx:id=\"label5\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert dp != null : "fx:id=\"dp\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert attend != null : "fx:id=\"attend\" was not injected: check your FXML file 'myInfo.fxml'.";
        assert lbl != null : "fx:id=\"lbl\" was not injected: check your FXML file 'myInfo.fxml'.";

        
       setTable();
       	final Font font = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 17);
		final Font font2 = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 25);
		final Font font3 = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 10);
		//name.setFont(font2);
		
		//label2.setFont(font);
		//label3.setFont(font);
		//label4.setFont(font);
		//label5.setFont(font);
		//picture_button.setFont(font3);
		//fix_btn.setFont(font3);
		

		//name.setFont(font);
		//tel.setFont(font);
		//email.setFont(font);
		//bir.setFont(font);
		//membership.setFont(font);
		
    }
    


    public void setTable() throws RemoteException {
    	 try {
             Registry reg = LocateRegistry.getRegistry("localhost", 1088);
             service = (ILalaLandMemberService) reg.lookup("memberService");
             attendService = (IAttendService) reg.lookup("attendService");
          } catch (RemoteException | NotBoundException e) {
              System.out.println("member service 가져오기 실패");
              e.printStackTrace();
           }
        //현재 로그인 한 사람의 정보 
        member= CurrentLoginPerson.CurrentMember; 
        vo = setAttend(new AttendVO());
		mem = service.getAllMemberList();
        
        /**
         * 
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			attendService = (IAttendService) reg.lookup("attendService");
			service = (ILalaLandMemberService) reg.lookup("memberService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("실패");
			e.printStackTrace();
		}
		
		member = CurrentLoginPerson.CurrentMember;
		vo = setAttend(new AttendVO());
		mem = service.getAllMemberList();
         */
        
        //현재 로그인 한 사람의 구매 내역을 업데이트
        service.updateMemberSales(member.getMem_id());
        Map<String, String> logIn = new HashMap<>();
        logIn.put("mem_id", member.getMem_id());
    	logIn.put("mem_pass", member.getMem_pass());
        member =service.logInMember(logIn);
        
        name.setText(member.getMem_name());
 		tel.setText(member.getMem_tel());
 		email.setText(member.getMem_mail());
 		bir.setText(member.getMem_bir().substring(0, 10));
 		membership.setText(member.getMem_grade());
 		
 		
 		if(0<=member.getSalesticket()&&member.getSalesticket()<200000){
 			member.setMem_grade("silver");
 		}else if(200000<=member.getSalesticket()&&member.getSalesticket()<500000){
 			member.setMem_grade("gold");
 		}else if(member.getSalesticket()>1000000) {
 			member.setMem_grade("vip");
 		}
 		
 		membership.setText(member.getMem_grade());
 		
 		int chk;
 		try {
 			
 			member.setMem_grade(member.getMem_grade());
 			chk = service.membershipGrade(member);
			if(chk>0) {
//				System.out.println("성~동!") ;
			}else {
//				System.out.println("실패");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			
		}
 		
 		imgname = member.getMem_id()+".jpg";
 		File file = new File("D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/img/"+imgname);
		if(!file.exists()) {
			URL="file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/user(1).png";
		}else {
			
			URL="file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/lalaLandClient/Image/img/"+imgname;
		}
        Image img = new Image(URL);
        picture.setImage(img);
 		
 		
    }
	

}
