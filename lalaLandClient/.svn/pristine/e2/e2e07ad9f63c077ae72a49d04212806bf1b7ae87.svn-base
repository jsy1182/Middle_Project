package Board.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import service.IBoardService;
import vo.BoardVO;
import vo.EmpVO;
import vo.MemberVO;
import vo.ReplyVO;

public class ViewQAEmpController {
	EmpVO emp ;
	BoardVO board;
	IBoardService service;

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private AnchorPane anchoPane;

    @FXML
    private URL location;

    @FXML
    private TextField tf_title;

    @FXML
    private Label la_date;

    @FXML
    private TextArea ta;

    @FXML
    private RadioButton radio;

    @FXML
    private TextArea answer;

    @FXML
    private Label la_answer;

    @FXML
    private Button btn_update;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_goback;

    @FXML
    private Label la_writer;

    @FXML
    private TextField tf_secret;

    @FXML
    private Label la_reply2;

    @FXML
    private Label la_reply;

    

    @FXML
    void click_delete(ActionEvent event) {
    	boolean recheck = check();
		if (recheck) {
			int chk;
			try {
				chk = service.deleteBoard(board.getBo_id());
				if (chk > 0)
					alert("INFORMATION", "성공적으로 삭제했습니다.");
				else
					alert("INFORMATION", "삭제하지 못했습니다.");
			} catch (RemoteException e) {
				e.printStackTrace();

			}

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardQAEmp.fxml"));

			Parent root;
			try {
				root = loader.load();
				anchoPane.getChildren().setAll(root);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} 
    }
    private boolean check() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("CONFIRMATION");
		alert.setContentText("정말로 글을 삭제하시겠습니까?");

		ButtonType confirmResult = alert.showAndWait().get();

		if (confirmResult == ButtonType.OK) {
			return true;
		} else if (confirmResult == ButtonType.CANCEL) {
			return false;
		} else {
			return false;
		}
	}

    

    @FXML
    void click_goback(ActionEvent event) {
    	Stage stage = (Stage) answer.getScene().getWindow();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardQAEmp.fxml"));

		Parent root;
		try {
			root = loader.load();
			anchoPane.getChildren().setAll(root);
//			Scene scene = new Scene(root);
//			stage.setScene(scene);

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

   
    
    private void setReply() {
		ReplyVO reply= null; 
		try {
			reply = service.selectReply(board.getBo_id());
			if(reply==null) {
				
			}else {
				answer.setText(reply.getReply_content());
				la_reply.setText(reply.getMem_id());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

    
    public void alert(String header, String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}

    @FXML
    void click_update(ActionEvent event) {
    	//답변 등록하기 버튼
    	Map<String, String> param = new HashMap<String, String>();
		String bo_id = board.getBo_id();
		if(answer.getText().isEmpty()) {
			alert(null, "글을 작성해주세요.");
			return;
		}
		String reply_content = answer.getText();
		String mem_id=emp.getEmp_id();
		
		param.put("bo_id", bo_id);
		param.put("reply_content", reply_content);
		param.put("mem_id", mem_id);
		
		
		int chk ;
		try {
			chk =service.insertReply(param);
			if(chk>0) {
				alert(null, "답변 등록 성공");
				setReply();
			}
			else alert(null,"답변 등록 실패");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert tf_title != null : "fx:id=\"tf_title\" was not injected: check your FXML file 'ViewQAEmp.fxml'.";
        assert la_date != null : "fx:id=\"la_date\" was not injected: check your FXML file 'ViewQAEmp.fxml'.";
        assert ta != null : "fx:id=\"ta\" was not injected: check your FXML file 'ViewQAEmp.fxml'.";
        assert radio != null : "fx:id=\"radio\" was not injected: check your FXML file 'ViewQAEmp.fxml'.";
        assert answer != null : "fx:id=\"answer\" was not injected: check your FXML file 'ViewQAEmp.fxml'.";
        assert la_answer != null : "fx:id=\"la_answer\" was not injected: check your FXML file 'ViewQAEmp.fxml'.";
        assert btn_update != null : "fx:id=\"btn_update\" was not injected: check your FXML file 'ViewQAEmp.fxml'.";
        assert btn_delete != null : "fx:id=\"btn_delete\" was not injected: check your FXML file 'ViewQAEmp.fxml'.";
        assert btn_goback != null : "fx:id=\"btn_goback\" was not injected: check your FXML file 'ViewQAEmp.fxml'.";
        assert la_writer != null : "fx:id=\"la_writer\" was not injected: check your FXML file 'ViewQAEmp.fxml'.";
        assert tf_secret != null : "fx:id=\"tf_secret\" was not injected: check your FXML file 'ViewQAEmp.fxml'.";
        assert la_reply2 != null : "fx:id=\"la_reply2\" was not injected: check your FXML file 'ViewQAEmp.fxml'.";
        assert la_reply != null : "fx:id=\"la_reply\" was not injected: check your FXML file 'ViewQAEmp.fxml'.";
        assert anchoPane != null : "fx:id=\"anchoPane\" was not injected: check your FXML file 'ViewBoardAdmin.fxml'.";

        answer.setWrapText(true);

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IBoardService) reg.lookup("boardService");

		} catch (RemoteException | NotBoundException e) {
			System.out.println("board service 가져오기 실패");
			e.printStackTrace();
		}

		emp = CurrentLoginPerson.CurrentEmp;
		
    }
    public void setBoard(BoardVO board) {
		this.board = board;
		
	}


	public void settingBoard() {
		//게시물 보기로 창 띄울 때 

		tf_title.setText(board.getBo_title());
		la_date.setText(board.getBo_date());
		if (board.getBo_sc().equals("t") || board.getBo_sc().equals("T")) {
			radio.setSelected(true);
		}
		ta.setText(board.getBo_content());
		la_writer.setText(board.getMem_id());

		setReply();
	}
}
