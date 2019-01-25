package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

import dao.CouponDaoImpl;
import dao.ICouponDao;
import vo.CouponVO;

public class CouponServiceImpl extends UnicastRemoteObject implements ICouponService{
	private ICouponDao dao;
	private static ICouponService service;
	
	private CouponServiceImpl() throws RemoteException{
		dao = CouponDaoImpl.getInstance();
	}
	
	public static ICouponService getInstance() throws RemoteException{
		if(service == null) service = new CouponServiceImpl();
		return service;
	}

	@Override
	public List<CouponVO> showCoupon(String mem_id) throws RemoteException {
		List<CouponVO> list = null;
		try {
			list = dao.showCoupon(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
