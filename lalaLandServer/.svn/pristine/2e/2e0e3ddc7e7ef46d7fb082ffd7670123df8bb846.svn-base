package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.BoardDaoImpl;
import dao.IBoardDao;
import vo.BoardVO;
import vo.MessageVO;
import vo.ReplyVO;
import vo.VoiceVO;

public class BoardServiceImpl extends UnicastRemoteObject implements IBoardService {

	private IBoardDao dao;
	private static IBoardService service;

	private BoardServiceImpl() throws RemoteException {
		dao = BoardDaoImpl.getInstance();

	}

	public static IBoardService getInstance() throws RemoteException {
		if (service == null)
			service = new BoardServiceImpl();
		return service;
	}

	@Override
	public List<BoardVO> getnoticeList() throws RemoteException {
		List<BoardVO> list = null;
		try {
			list = dao.getnoticeList();
		} catch (SQLException e) {
			System.out.println("getnoticeList() 오류");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BoardVO> getQAList() throws RemoteException {
		List<BoardVO> list = null;
		try {
			list = dao.getQAList();
		} catch (SQLException e) {
			System.out.println("getQAList() 오류");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteBoard(String bo_id) throws RemoteException {
		int result = 0;
		try {
			result = dao.deleteBoard(bo_id);
		} catch (SQLException e) {
			System.out.println("deleteBoard() 오류");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertSecretBoard(BoardVO board) throws RemoteException {
		int result = 0;
		try {
			result = dao.insertSecretBoard(board);
		} catch (SQLException e) {
			System.out.println("insertSecretBoard() 오류");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertBoard(BoardVO board) throws RemoteException {
		int result = 0;
		try {
			result = dao.insertBoard(board);
		} catch (SQLException e) {
			System.out.println("insertBoard() 오류");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateSecretBoard(BoardVO board) throws RemoteException {
		int result = 0;
		try {
			result = dao.updateSecretBoard(board);
		} catch (SQLException e) {
			System.out.println("updateSecretBoard() 오류");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateNomalBoard(BoardVO board) throws RemoteException {
		int result = 0;
		try {
			result = dao.updateNomalBoard(board);
		} catch (SQLException e) {
			System.out.println("updateNomalBoard() 오류");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateBoard(BoardVO board) throws RemoteException {
		int result = 0;
		try {
			result = dao.updateBoard(board);
		} catch (SQLException e) {
			System.out.println("updateBoard() 오류");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<BoardVO> searchNoticeBoard(Map<String, String> param) throws RemoteException {
		List<BoardVO> list = null;
		try {
			list = dao.searchNoticeBoard(param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BoardVO> searchQABoard(Map<String, String> param) throws RemoteException {
		List<BoardVO> list = null;
		try {
			list = dao.searchQABoard(param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MessageVO> selectMessageList(String mem_to) throws RemoteException {
		List<MessageVO> list = null;
		try {
			list = dao.selectMessageList(mem_to);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MessageVO selectMessage(String message_id) throws RemoteException {
		MessageVO vo = null;
		try {
			vo = dao.selectMessage(message_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int insertMessage(MessageVO message) throws RemoteException {
		int chk = 0;
		try {
			chk = dao.insertMessage(message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public int deleteMessage(String message_id) throws RemoteException {
		int chk = 0;
		try {
			chk = dao.deleteMessage(message_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return chk;
	}

	@Override
	public List<VoiceVO> selectVoice() throws RemoteException {
		List<VoiceVO> list = null;
		try {
			list = dao.selectVoice();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteVoice(String voice_id) throws RemoteException {
		int chk = 0;
		try {
			chk = dao.deleteVoice(voice_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public int insertVoice(VoiceVO voice) throws RemoteException {
		int chk = 0;
		try {
			chk = dao.insertVoice(voice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public ReplyVO selectReply(String bo_id) throws RemoteException {
		ReplyVO vo = null;
		try {
			vo = dao.selectReply(bo_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int insertReply(Map<String, String> param) throws RemoteException {
		int chk=0;
		try {
			chk= dao.insertReply(param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

}
