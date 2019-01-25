package dao;

import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.ReserveVO;
import vo.RideVO;

public class ReserveDaoImpl implements IReserveDao{
	private SqlMapClient client;
	private static IReserveDao dao;
	
	private ReserveDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}
	
	public static IReserveDao getInstance() {
		if(dao == null) dao = new ReserveDaoImpl();
		return dao;
		
	}
	// 놀이기구 이름 가져오기
	@Override
	public List<RideVO> getRideName() throws SQLException {
		
		return client.queryForList("reserve.getRideName");
	}

	// 놀이기구 아이디 가져오기
	@Override
	public String getRideId(String reRide) throws SQLException {
		return (String)client.queryForObject("reserve.getRideId", reRide);
	}

	@Override
	public int insertReserve(ReserveVO rvo) throws SQLException {
		Object obj=client.insert("reserve.insertReserve", rvo);
		if(obj==null) {
			return 1;
		}
		return 0;
	}

	// 이메일 가져오기
	@Override
	public String getEmail(String mem_id) throws SQLException {
		return (String) client.queryForObject("reserve.getEmail", mem_id);
	}

	// 예약 중복 검사
	@Override
	public int countReserve(ReserveVO rvo) throws SQLException {
		return (int) client.queryForObject("reserve.countReserve", rvo);
	}

	// 3번 예약 확인
	@Override
	public int limitThreeReserve(String mem_id) throws SQLException {
		return (int) client.queryForObject("reserve.limitThreeReserve", mem_id);
	}

	// 예약취소 테이블 가져오기
	@Override
	public List<ReserveVO> getAllReserve(String mem_id) throws SQLException {
		return client.queryForList("reserve.getAllReserve", mem_id);
	}

	// 예약취소하기
	@Override
	public int deleteReserve(ReserveVO vo) throws SQLException {
		return client.delete("reserve.deleteReserve", vo);
	}

	@Override
	public String getSelectRideId(String ridename) throws SQLException {
		return (String) client.queryForObject("reserve.getSelectRideId", ridename);
	}

	@Override
	public int deleteAll(String mem_id) throws SQLException {
		return client.delete("reserve.deleteAll", mem_id);
	}

	

	

}
