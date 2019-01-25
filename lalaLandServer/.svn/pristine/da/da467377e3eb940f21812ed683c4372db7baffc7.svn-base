package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.BoardVO;
import vo.MessageVO;
import vo.ReplyVO;
import vo.VoiceVO;

public interface IBoardService extends Remote {
	
	/**
	 * 공지사항 글만 가져오는 메서드
	 * @return 공지사항 리스트를 반환
	 * @throws SQLException
	 */
	public List<BoardVO> getnoticeList() throws RemoteException;
	
	/**
	 * Q&A 글만 가져오는 메서드
	 * @return Q&A 리스트를 반환
	 * @throws SQLException
	 */
	public List<BoardVO> getQAList() throws RemoteException;
	
	/**
	 * 해당 글을 DB에서 삭제하는 메서드
	 * @param bo_id 삭제할 글의 ID
	 * @return 삭제 성공 : 1 , 실패 : 0
	 * @throws SQLException
	 */
	public int deleteBoard(String bo_id) throws RemoteException;
	
	/**
	 * 비밀글을 작성하는 메서드
	 * @param board 작성할 게시판
	 * @return 수정 성공시 : 1 실패 : 0
	 * @throws SQLException
	 */
	public int insertSecretBoard(BoardVO board) throws RemoteException;
	
	/**
	 * 일반글을 작성하는 메서드
	 * @param board 작성할 게시판
	 * @return 수정 성공시 : 1 실패 : 0
	 * @throws SQLException
	 */
	public int insertBoard(BoardVO board) throws RemoteException;
	
	/**
	 * 일반글 -> 비밀글로 수정하는 메서드
	 * @param board 수정할 데이터를 담은 vo
	 * @return 수정 성공시 : 1 실패 : 0
	 * @throws SQLException
	 */
	public int updateSecretBoard(BoardVO board) throws RemoteException;
	
	/**
	 * 비밀글 -> 일반글로 수정하는 메서드
	 * @param board 수정할 데이터를 담은 vo
	 * @return 수정 성공시 : 1 실패 : 0
	 * @throws SQLException
	 */
	public int updateNomalBoard(BoardVO board) throws RemoteException;
	
	/**
	 * 일반글 -> 일반글 , 비밀글-> 비밀글 그대로 유지하면서 내용만 수정하는 메서드
	 * @param board 수정할 데이터를 담은 vo
	 * @return 수정 성공시 : 1 실패 : 0
	 * @throws SQLException
	 */
	public int updateBoard(BoardVO board) throws RemoteException;
	
	/**
	 * 공지사항에서 원하는 정보를 검색하는 메서드
	 * @param param 검색할 정보를 담은 map
	 * @return 정보에 해당하는 게시물리스트를 반환
	 */
	public List<BoardVO> searchNoticeBoard(Map<String, String> param)throws RemoteException;
	
	/**
	 * Q & A에서 원하는 정보를 검색하는 메서드
	 * @param param 검색할 정보를 담은 map
	 * @return 정보에 해당하는 게시물리스트를 반환
	 */
	public List<BoardVO> searchQABoard(Map<String, String> param)throws RemoteException;
	
	/**
	 * 해당 멤버가 받은 쪽지리스트를 조회하는 메서드
	 * @param mem_to 해당 멤버
	 * @return List<MessageVO>
	 * @throws RemoteException
	 */
	public List<MessageVO> selectMessageList(String mem_to) throws RemoteException;
	
	/**
	 * 해당 쪽지를 조회하는 메서드
	 * @param message_id 조회할 메시지
	 * @return MessageVO
	 * @throws RemoteException
	 */
	public MessageVO selectMessage(String message_id) throws RemoteException;
	
	/**
	 * 새로운 메시지를 등록하는 메서드
	 * @param message 등록할 MessageVO
	 * @return 성공시 1,실패시 0
	 * @throws RemoteException
	 */
	public int insertMessage(MessageVO message) throws RemoteException;
	
	/**
	 * 메시지를 삭제하는 메서드
	 * @param message_id 삭제할 메시지의 ID
	 * @return 삭제 성공시 1 실패시 0
	 * @throws RemoteException
	 */
	public int deleteMessage(String message_id) throws RemoteException;
	
	/**
	 * 고객소리함 리스트를 출력하는 메서드
	 * @return VoiceVO 리스트
	 * @throws SQLException
	 */
	public List<VoiceVO> selectVoice() throws RemoteException;
	
	/**
	 * 고객소리를 DB에서 삭제하는 메서드
	 * @param voice_id 삭제할 voice의 아이디
	 * @return 성공시 1 , 실패시 0
	 * @throws SQLException
	 */
	public int deleteVoice(String voice_id) throws RemoteException;
	
	/**
	 * 새롭게 등록되는 고객의 소리
	 * @param voice 등록될 VoiceVO
	 * @return 성공시 1, 실패시 0
	 * @throws SQLException
	 */
	public int insertVoice(VoiceVO voice) throws RemoteException;
	
	public ReplyVO selectReply(String bo_id) throws RemoteException;
	
	public int insertReply(Map<String, String> param) throws RemoteException;
	
}
