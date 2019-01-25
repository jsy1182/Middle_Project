package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

import dao.EventDaoImpl;
import dao.IEventDao;
import vo.EventVO;

public class EventServiceImpl extends UnicastRemoteObject implements IEventService{
	private IEventDao dao;
	private static IEventService service;
	
	private EventServiceImpl() throws RemoteException{
		dao = EventDaoImpl.getInstance();
	}
	
	public static IEventService getInstance() throws RemoteException{
		if(service == null) service = new EventServiceImpl();
		return service;
	}

	@Override
	public List<EventVO> allEvent() throws RemoteException {
		List<EventVO> eventList = null;
		try {
			eventList = dao.allEvent();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventList;
	}

	@Override
	public int insertEvent(EventVO vo) throws RemoteException {
		int count = 0;
		try {
			count = dao.insertEvent(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateEvent(EventVO vo) throws RemoteException {
		int count = 0;
		try {
			count = dao.updateEvent(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
