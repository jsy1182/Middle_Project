package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

import dao.EventJoinDaoImpl;
import dao.IEventJoinDao;
import vo.Event_joinVO;

public class EventJoinServiceImpl extends UnicastRemoteObject implements IEventJoinService{
	private IEventJoinDao dao;
	private static IEventJoinService service;
	
	private EventJoinServiceImpl() throws RemoteException{
		dao = EventJoinDaoImpl.getInstance();
	}
	
	public static IEventJoinService getInstance() throws RemoteException {
		if(service == null) service = new EventJoinServiceImpl();
		return service;
	}

	@Override
	public List<Event_joinVO> allEventJoin() throws RemoteException {
		List<Event_joinVO> list = null;
		try {
			list = dao.allEventJoin();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertEventJoin(Event_joinVO vo) throws RemoteException {
		int count = 0;
		try {
			count = dao.insertEventJoin(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int selectMemId(String mem_id, String event_id) throws RemoteException {
		int count = 0;
		try {
			count = dao.selectMemId(mem_id,event_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
