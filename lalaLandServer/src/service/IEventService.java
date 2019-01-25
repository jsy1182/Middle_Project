package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.EventVO;

public interface IEventService extends Remote {
	/**
	 * 모든 이벤트를 보여준다
	 * @return List<EventVO> 
	 * @throws SQLException
	 */
	public List<EventVO> allEvent() throws RemoteException;
	
	/**
	 * 관리자가 이벤트를 추가할수있다
	 * @param vo 이벤트의 내용을 가지고 있다
	 * @return 1이면 추가성공 0이면 추가실패
	 * @throws SQLException
	 */
	public int insertEvent(EventVO vo) throws RemoteException;
	
	/**
	 * 관리자가 이벤트를 수정할수있다
	 * @param vo 이벤트의 내용을 가지고 있다
	 * @return 1이면 수정성공 0이면 수정실패
	 * @throws SQLException
	 */
	public int updateEvent(EventVO vo) throws RemoteException;
}
