package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.AttendVO;

public interface IAttendService extends Remote{
	/**
	 * 출석을 했는지 안했는지 중복검사를 한다
	 * @param mem_id 중복검사를 할 회원의 아이디
	 * @param attend_date 오늘의 날짜
	 * @return
	 */
	public int attendCheck(AttendVO vo) throws RemoteException;
	
	/**
	 * 출석VO에 정보를 DB 넣어준다
	 * @param vo 출석정보 
	 * @return
	 */
	public int insertAttend(AttendVO vo) throws RemoteException;
}
