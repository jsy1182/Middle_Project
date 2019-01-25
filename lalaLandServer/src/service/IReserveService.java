package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.ReserveVO;
import vo.RideVO;

public interface IReserveService extends Remote {

	/**
	 * 테이블에 놀이기구 이름가져오기
	 * @return
	 * @throws RemoteException
	 */
	public List<RideVO> getRideName() throws RemoteException;
	
	/**
	 * 놀이기구 예약시 놀익기구ID가져오기
	 * @param reRide
	 * @return
	 * @throws RemoteException
	 */
	public String getRideId(String reRide) throws RemoteException;

	/**
	 * 놀이기구 예약 저장하기
	 * @param rvo
	 * @return
	 * @throws RemoteException
	 */
	public int insertReserve(ReserveVO rvo) throws RemoteException;

	/**
	 * 이메일 가져오기
	 * @param mem_id
	 * @return
	 * @throws RemoteException
	 */
	public String getEmail(String mem_id) throws RemoteException;

	/**
	 * 예약 중복 검사
	 * @param rvo
	 * @return
	 */
	public int countReserve(ReserveVO rvo) throws RemoteException;
	
	/**
	 * 한 회원당 예약 3번으로 제한하기
	 * @param mem_id
	 * @return
	 */
	public int limitThreeReserve(String mem_id) throws RemoteException;

	/**
	 * 예약취소 테이블정보 가져오기
	 * @param mem_id
	 * @return
	 */
	public List<ReserveVO> getAllReserve(String mem_id) throws RemoteException;

	/**
	 * 예약 취소하기
	 * @param name
	 * @param time
	 * @return
	 * @throws RemoteException
	 */
	public int deleteReserve(ReserveVO vo) throws RemoteException;

	/**
	 * 기구 이름가져오기
	 * @param ridename
	 * @return
	 */
	public String getSelectRideId(String ridename) throws RemoteException;
	
	/**
	 * 예약 하루 지나면 초기화
	 * @param mem_id
	 * @return
	 * @throws RemoteException
	 */
	public int deleteAll(String mem_id) throws RemoteException;


}
