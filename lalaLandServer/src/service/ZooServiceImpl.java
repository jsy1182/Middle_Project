package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

import dao.IZooDao;
import dao.ZooDaoImpl;
import vo.AnimalVO;
import vo.FarmVO;


public class ZooServiceImpl extends UnicastRemoteObject implements IZooService {

	private IZooDao dao;
	private static IZooService service;
	
	private ZooServiceImpl() throws RemoteException{
		dao = ZooDaoImpl.getInstance();
	}
	
	public static IZooService getInstance() throws RemoteException{
		if(service == null) service = new ZooServiceImpl();
		return service;
	}
	/**
	 *  벨리 콤보 리스트 가져오기
	 *  
	 */
	@Override
	public List<String> getComboList(String belly_name) throws RemoteException {
		List<String> list = null;
		try {
			list = dao.getComboList(belly_name);
		} catch (SQLException e) {
			System.out.println("getComboList()오류");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getAnimalExplain(String animal_name) throws RemoteException {
		String explain = "";
		try {
			explain = dao.getAnimalExplain(animal_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return explain;
	}

	@Override
	public List<AnimalVO> getAllAnimal() throws RemoteException {
		List<AnimalVO> list = null;
		try {
			list = dao.getAllAnimal();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertAnimal(AnimalVO avo) throws RemoteException {
		Object obj = null;
		int cnt = 0;
		try {
			obj = dao.insertAnimal(avo);
			if(obj != null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteAnimal(String id) throws RemoteException {
		int cnt = 0;
		try {
			cnt = dao.deleteAnimal(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateAnimal(AnimalVO vo) throws RemoteException {
		int cnt = 0;
		try {
			cnt = dao.updateAnimal(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	
}
