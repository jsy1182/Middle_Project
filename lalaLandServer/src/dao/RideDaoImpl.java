package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import javafx.scene.control.Label;
import vo.ParadeVO;
import vo.RideVO;

public class RideDaoImpl implements IRideDao{
	private SqlMapClient client;
	private static IRideDao dao;
	
	private RideDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}
	
	public static IRideDao getInstance() {
		if(dao==null) dao = new RideDaoImpl();
		return dao;
	}

	/**
	 * 키에 따라 놀이기구 이름가져오기
	 */
	@Override
	public List<String> getComboListRide(int i) throws SQLException {
		return client.queryForList("ride.getComboListRide", i);
	}

	/**
	 * 놀이기구 설명가져오기
	 */
	@Override
	public String getRideExplain(String ride_name) throws SQLException {
		return (String) client.queryForObject("ride.getRideExplain", ride_name);
	}

	/**
	 * 놀이기구 건설날짜, 최대 탑승인원, 난이도, 제한 키, 운행여부 가져오기
	 */
	@Override
	public List<RideVO> getRideInfo(String albel_rideName) throws SQLException {
		return client.queryForList("ride.getRideInfo", albel_rideName);
	}

	/**
	 * 퍼레이드 정보 가져오기
	 */
	@Override
	public List<ParadeVO> getAllParade() throws SQLException {
		return client.queryForList("ride.getAllParade");
	}

	@Override
	public List<RideVO> getAllRide() throws SQLException {
		return client.queryForList("ride.getAllRide");
	}

	/**
	 * 직원 - 놀이기구 생성하기
	 */
	@Override
	public int InsertRide(RideVO rvo) throws SQLException {
		Object obj = null;
		obj = client.insert("ride.insertRide", rvo);
		if(obj != null) return 1;
		return 0;
	}

	/**
	 * 직원 - 놀이기구 삭제하기
	 */
	@Override
	public int deleteRide(String id) throws SQLException {
		return client.delete("ride.deleteRide", id);
	}

	/**
	 * 직원 - 놀이기구 수정하기
	 */
	@Override
	public int updateRide(RideVO rvo) throws SQLException {
		return client.update("ride.updateRide", rvo);
	}

}
