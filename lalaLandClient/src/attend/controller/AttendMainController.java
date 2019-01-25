package attend.controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import main.CurrentLoginPerson;
import service.IAttendService;
import service.ILalaLandMemberService;
import vo.AttendVO;
import vo.MemberVO;

public class AttendMainController {
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private DatePicker dp;

	@FXML
	private Button attend;

	@FXML
	private Label lbl;

	private IAttendService attendService = null;
	private ILalaLandMemberService service = null;
	private List<MemberVO> mem;
	AttendVO vo;
	private MemberVO member;

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

	@FXML
	void initialize() throws RemoteException {
		assert attend != null : "fx:id=\"attend\" was not injected: check your FXML file 'calendar.fxml'.";
		assert lbl != null : "fx:id=\"lbl\" was not injected: check your FXML file 'calendar.fxml'.";
		assert dp != null : "fx:id=\"dp\" was not injected: check your FXML file 'calendar.fxml'.";

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
	}
}
