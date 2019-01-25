package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

import dao.IRideDao;
import dao.RideDaoImpl;
import vo.ParadeVO;
import vo.RideVO;

public class RideServiceImpl extends UnicastRemoteObject implements IRideService{
	private IRideDao dao;
	private static IRideService service;
	
	private RideServiceImpl() throws RemoteException{
		dao = RideDaoImpl.getInstance();
	}
	
	public static IRideService getInstance() throws RemoteException{
		if(service == null) service = new RideServiceImpl();
		return service;
	}
	/**
	 * 키에 따라 놀이기구 이름가져오기
	 */
	@Override
	public List<String> getComboListRide(int i) throws RemoteException {
		List<String> list = null;
		try {
			list = dao.getComboListRide(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getRideExplain(String ride_name) throws RemoteException {
		String explain = null;
		try {
			explain = dao.getRideExplain(ride_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return explain;
	}

	/**
	 * 놀이기구 건설날짜, 최대 탑승인원, 난이도, 제한 키, 운행여부 가져오기
	 */
	@Override
	public List<RideVO> getRideInfo(String albel_rideName) throws RemoteException {
		List<RideVO> list = null;
		try {
			list = dao.getRideInfo(albel_rideName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 퍼레이드 정보 가져오기
	 */
	@Override
	public List<ParadeVO> getAllParade() throws RemoteException {
		List<ParadeVO> list = null;
		try {
			list = dao.getAllParade();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<RideVO> getAllRide() throws RemoteException {
		List<RideVO> list = null;
		try {
			list = dao.getAllRide();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 직원 - 놀이기구 생성하기
	 */
	@Override
	public int InsertRide(RideVO rvo) throws RemoteException {
		Object obj = null;
		int cnt = 0;
		try {
			obj = dao.InsertRide(rvo);
			if(obj != null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteRide(String id) throws RemoteException {
		int cnt = 0;
		try {
			cnt = dao.deleteRide(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 직원 - 놀이기구 수정하기
	 */
	@Override
	public int updateRide(RideVO rvo) throws RemoteException {
		int cnt = 0;
		try {
			cnt = dao.updateRide(rvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("service cnt=" + cnt);
		return cnt;
	}
}
