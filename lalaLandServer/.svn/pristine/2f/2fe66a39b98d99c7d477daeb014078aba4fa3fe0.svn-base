package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

import dao.IReserveDao;
import dao.ReserveDaoImpl;
import vo.ReserveVO;
import vo.RideVO;

public class ReserveServiceImpl extends UnicastRemoteObject implements IReserveService {
	private IReserveDao dao;
	private static IReserveService service;
	
	private ReserveServiceImpl() throws RemoteException{
		dao = ReserveDaoImpl.getInstance();
	}
	
	public static IReserveService getInstance() throws RemoteException{
		if(service == null) service = new ReserveServiceImpl();
		return service;
	}
	// 놀이기구 이름가져오기
	@Override
	public List<RideVO> getRideName() throws RemoteException {
		List<RideVO> list = null;
		try {
			list = dao.getRideName();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	// 놀이기구 아이디 가져오기
	@Override
	public String getRideId(String reRide) throws RemoteException {
		String id =null;
		try {
			id = dao.getRideId(reRide);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public int insertReserve(ReserveVO rvo) throws RemoteException {
		int cnt = 0;
		try {
			cnt = dao.insertReserve(rvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String getEmail(String mem_id) throws RemoteException {
		String mail=null;
		try {
			mail = dao.getEmail(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mail;
	}

	@Override
	public int countReserve(ReserveVO rvo) throws RemoteException {
		int cnt = 0;
		try {
			cnt = dao.countReserve(rvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int limitThreeReserve(String mem_id) throws RemoteException {
		int cnt = 0;
		try {
			cnt = dao.limitThreeReserve(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	// 예약취소 테이블 가져오기
	@Override
	public List<ReserveVO> getAllReserve(String mem_id) throws RemoteException {
		List<ReserveVO> list = null;
		try {
			list = dao.getAllReserve(mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteReserve(ReserveVO vo) throws RemoteException {
		int cnt = 0;
		try {
			cnt = dao.deleteReserve(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	// 이름을 아이디로 가져오기
	@Override
	public String getSelectRideId(String ridename) throws RemoteException {
		String id = null;
		try {
			id = dao.getSelectRideId(ridename);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public int deleteAll(String mem_id) throws RemoteException {
		int cnt = 0;
		try {
			cnt = dao.deleteAll(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}


	
}
