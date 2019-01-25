package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.BoardVO;
import vo.MessageVO;
import vo.ReplyVO;
import vo.VoiceVO;

public class BoardDaoImpl implements IBoardDao {
	private SqlMapClient client;
	private static IBoardDao dao;

	private BoardDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}

	public static IBoardDao getInstance() {
		if (dao == null)
			dao = new BoardDaoImpl();
		return dao;
	}

	@Override
	public List<BoardVO> getnoticeList() throws SQLException {
		return client.queryForList("board.getnoticeList");
	}

	@Override
	public List<BoardVO> getQAList() throws SQLException {
		return client.queryForList("board.getQAList");
	}

	@Override
	public int deleteBoard(String bo_id) throws SQLException {
		return client.delete("board.deleteBoard", bo_id);
	}

	@Override
	public int insertSecretBoard(BoardVO board) throws SQLException {
		if (client.insert("board.insertSecretBoard", board) == null)
			return 1;
		else
			return 0;
	}

	@Override
	public int insertBoard(BoardVO board) throws SQLException {
		if (client.insert("board.insertBoard", board) == null)
			return 1;
		else
			return 0;
	}

	@Override
	public int updateSecretBoard(BoardVO board) throws SQLException {
		return client.update("board.updateSecretBoard", board);
	}

	@Override
	public int updateNomalBoard(BoardVO board) throws SQLException {
		return client.update("board.updateNomalBoard", board);
	}

	@Override
	public int updateBoard(BoardVO board) throws SQLException {
		return client.update("board.updateBoard", board);
	}

	@Override
	public List<BoardVO> searchNoticeBoard(Map<String, String> param) throws SQLException {
		return client.queryForList("board.searchNoticeBoard", param);
	}

	@Override
	public List<BoardVO> searchQABoard(Map<String, String> param) throws SQLException {
		return client.queryForList("board.searchQABoard", param);
	}

	@Override
	public List<MessageVO> selectMessageList(String mem_to) throws SQLException {
		return client.queryForList("message.selectMessageList", mem_to);
	}

	@Override
	public MessageVO selectMessage(String message_id) throws SQLException {
		return (MessageVO) client.queryForObject("message.selectMessage", message_id);
	}

	@Override
	public int insertMessage(MessageVO message) throws SQLException {
		if (client.insert("message.insertMessage", message) == null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int deleteMessage(String message_id) throws SQLException {
		return client.delete("message.deleteMessage", message_id);
	}

	@Override
	public List<VoiceVO> selectVoice() throws SQLException {
		return client.queryForList("message.selectVoice");
	}

	@Override
	public int deleteVoice(String voice_id) throws SQLException {
		return client.delete("message.deleteVoice", voice_id);
	}

	@Override
	public int insertVoice(VoiceVO voice) throws SQLException {
		if (client.insert("message.insertVoice", voice) == null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public ReplyVO selectReply(String bo_id) throws SQLException {
		return (ReplyVO) client.queryForObject("board.selectReply",bo_id);
	}

	@Override
	public int insertReply(Map<String, String> param) throws SQLException {
		if (client.insert("board.insertReply", param) == null) {
			return 1;
		} else {
			return 0;
		}
	}

}
