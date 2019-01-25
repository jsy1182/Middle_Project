package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

import dao.AttendDaoImpl;
import dao.IAttendDao;
import vo.AttendVO;


public class AttendServiceImpl extends UnicastRemoteObject implements IAttendService{
	private IAttendDao dao ;
	private static IAttendService service;
	
	private AttendServiceImpl() throws RemoteException{
		dao = AttendDaoImpl.getInstance();
		
	}
	public static IAttendService getInstance() throws RemoteException {
		if(service == null) service= new AttendServiceImpl();
		return service;
	}
	@Override
	public int attendCheck(AttendVO vo) throws RemoteException{
		int check = 0;
		try {
			check = dao.attendCheck(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	@Override
	public int insertAttend(AttendVO vo) throws RemoteException{
		int result =0;
		try {
			result = dao.insertAttend(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
