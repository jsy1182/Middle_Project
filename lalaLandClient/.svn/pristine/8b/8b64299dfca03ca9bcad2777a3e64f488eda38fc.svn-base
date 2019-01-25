package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.Event_joinVO;

public interface IEventJoinService extends Remote{
	public List<Event_joinVO> allEventJoin() throws RemoteException;
	public int insertEventJoin(Event_joinVO vo) throws RemoteException;
	public int selectMemId(String mem_id, String event_id) throws RemoteException;
}
