package dao;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javafx.scene.control.Label;
import vo.ParadeVO;
import vo.RideVO;

public interface IRideDao {

	/**
	 * 콤보박스 놀이기구 이름 가져오기
	 * @param i 키
	 * @return
	 * @throws SQLException
	 */
	public List<String> getComboListRide(int i) throws SQLException;
	
	
	/**
	 * 놀이기구 설명가져오기
	 * @param ride_name
	 * @return
	 * @throws SQLException
	 */
	public String getRideExplain(String ride_name) throws SQLException;
	
	/**
	 * 놀이기구 건설날짜, 최대 탑승인원, 난이도, 제한 키, 운행여부 가져오기
	 * @param albel_rideName
	 * @return
	 * @throws RemoteException
	 */
	public List<RideVO> getRideInfo(String albel_rideName) throws SQLException;

	/**
	 * 퍼레이드정보 가져오기
	 * @return
	 */
	public List<ParadeVO> getAllParade() throws SQLException;
	
	/**
	 * 직원 - 모든 놀이기구 정보 가져오기
	 * @return
	 * @throws RemoteException
	 */
	public List<RideVO> getAllRide() throws SQLException;
	
	/**
	 * 직원 - 놀이기구 생성하기
	 * @param rvo
	 * @return
	 * @throws RemoteException
	 */
	public int InsertRide(RideVO rvo) throws SQLException;
	
	/**
	 * 직원 - 놀이기구 삭제하기
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public int deleteRide(String id) throws SQLException;
	
	/**
	 * 직원 - 놀이기구 update
	 * @param rvo
	 * @return
	 * @throws RemoteException
	 */
	public int updateRide(RideVO rvo) throws SQLException;


}
