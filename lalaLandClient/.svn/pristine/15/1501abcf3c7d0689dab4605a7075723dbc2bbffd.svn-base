package Board.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import service.IBoardService;
import vo.AdminVO;
import vo.BoardVO;
import vo.EmpVO;
import vo.MemberVO;
import vo.ReplyVO;

public class ViewQAController {
	MemberVO member;

	BoardVO board = new BoardVO();
	IBoardService service;

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private AnchorPane anchoPane;

    @FXML
    private TextField tf_title;

    @FXML
    private Label la_date;

    @FXML
    private TextArea ta;

    @FXML
    private Button btn_insert;

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
    private PasswordField tf_secret;

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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardQA.fxml"));

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

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardQA.fxml"));

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


	@FXML
	void click_insert(ActionEvent event) {
		BoardVO vo = new BoardVO();

		String title = tf_title.getText();
		if (title.isEmpty()) {
			alert("INFORMATION!", "제목을 입력해주세요.");
			tf_title.requestFocus();
			return;
		}
		String content = ta.getText();
		if (content.isEmpty()) {
			alert("INFORMATION!", "내용을 입력해주세요.");
			ta.requestFocus();
			return;
		}
		if(radio.isSelected()) {
		if(tf_secret.getText().isEmpty()) {
			alert("INFORMATION!", "비밀글에 비밀번호를 설정해주세요.");
			return;
		}
		}
		int chk;
		try {
			vo.setBo_title(title);
			vo.setBo_content(content);
			vo.setMem_id(la_writer.getText());
			if (radio.isSelected()) {
				vo.setBo_sc("t");
				if (tf_secret.getText().trim().equals(null)) {
					alert("INFORMATION !", "비밀번호를 입력해주세요.");
					tf_secret.requestFocus();
					return;
				}
				vo.setBo_pass(tf_secret.getText());
				chk = service.insertSecretBoard(vo);

			} else {
				chk = service.insertBoard(vo);
			}

			if (chk > 0)
				alert(null, "새로운 게시물을 등록했습니다.");
			else
				alert(null, "게시물 등록을 실패했습니다.");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardQA.fxml"));

		Parent root;
		try {
			root = loader.load();
			anchoPane.getChildren().setAll(root);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@FXML
	void click_update(ActionEvent event) {
		
		board.setBo_title(tf_title.getText());
		board.setBo_content(ta.getText());
		int chk;
		try {
			if (radio.isSelected()) {
				if (tf_secret.getText().isEmpty()) {
					alert(null, "비밀번호 입력해주세요.");
					return;
				} else {
					board.setBo_pass(tf_secret.getText());
					chk = service.updateSecretBoard(board);
				}
			} else {
				chk = service.updateNomalBoard(board);
			}
			if (chk > 0)
				alert("INFORMATION !", "성공적으로 수정되었습니다.");
			else
				alert("INFORMATION ! ", "수정하지 못하였습니다.");

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/BoardQA.fxml"));

		Parent root;
		try {
			root = loader.load();
			anchoPane.getChildren().setAll(root);

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
				answer.setVisible(true);
				la_answer.setVisible(true);
				btn_update.setVisible(false);
				la_reply.setVisible(true);
				la_reply2.setVisible(true);
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
	void initialize() {
        assert tf_title != null : "fx:id=\"tf_title\" was not injected: check your FXML file 'ViewQA.fxml'.";
        assert la_date != null : "fx:id=\"la_date\" was not injected: check your FXML file 'ViewQA.fxml'.";
        assert ta != null : "fx:id=\"ta\" was not injected: check your FXML file 'ViewQA.fxml'.";
        assert btn_insert != null : "fx:id=\"btn_insert\" was not injected: check your FXML file 'ViewQA.fxml'.";
        assert radio != null : "fx:id=\"radio\" was not injected: check your FXML file 'ViewQA.fxml'.";
        assert answer != null : "fx:id=\"answer\" was not injected: check your FXML file 'ViewQA.fxml'.";
        assert la_answer != null : "fx:id=\"la_answer\" was not injected: check your FXML file 'ViewQA.fxml'.";
        assert btn_update != null : "fx:id=\"btn_update\" was not injected: check your FXML file 'ViewQA.fxml'.";
        assert btn_delete != null : "fx:id=\"btn_delete\" was not injected: check your FXML file 'ViewQA.fxml'.";
        assert btn_goback != null : "fx:id=\"btn_goback\" was not injected: check your FXML file 'ViewQA.fxml'.";
        assert la_writer != null : "fx:id=\"la_writer\" was not injected: check your FXML file 'ViewQA.fxml'.";
        assert tf_secret != null : "fx:id=\"tf_secret\" was not injected: check your FXML file 'ViewQA.fxml'.";
        assert la_reply2 != null : "fx:id=\"la_reply2\" was not injected: check your FXML file 'ViewQA.fxml'.";
        assert la_reply != null : "fx:id=\"la_reply\" was not injected: check your FXML file 'ViewQA.fxml'.";
		assert anchoPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'EmpMainScene.fxml'.";

        
		if (!answer.getText().isEmpty()) {
			answer.setVisible(true);
			la_answer.setVisible(true);
		}

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IBoardService) reg.lookup("boardService");

		} catch (RemoteException | NotBoundException e) {
			System.out.println("board service 가져오기 실패");
			e.printStackTrace();
		}

		member = CurrentLoginPerson.CurrentMember;
		ta.setWrapText(true);

	}

	public void setBoard(BoardVO board) {
		this.board = board;
		
	}

	public void setting() {
		//새 글 등록하기 메서드로 창 띄울 때
		btn_insert.setVisible(true);
		btn_update.setVisible(false);
		btn_delete.setVisible(false);
		la_writer.setText(member.getMem_id());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		la_date.setText(format.format(new Date()));
		
		
	}

	public void settingBoard() {
		//게시물 보기로 창 띄울 때 
		
		if(board.getMem_id().equals(member.getMem_id())) {
			//자신의 게시물
			btn_delete.setVisible(true); 
			btn_update.setVisible(true);
			
		}else {
			//다른 사람의 게시물
			btn_delete.setVisible(false); 
			btn_update.setVisible(false);
		}
			
		
		setReply();
		tf_title.setText(board.getBo_title());
		la_date.setText(board.getBo_date());
		if (board.getBo_sc().equals("t") || board.getBo_sc().equals("T")) {
			radio.setSelected(true);
		}
		ta.setText(board.getBo_content());
		la_writer.setText(board.getMem_id());

	}

}
