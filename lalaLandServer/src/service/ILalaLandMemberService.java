package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import vo.AdminVO;
import vo.EmpVO;
import vo.MemberVO;

public interface ILalaLandMemberService extends Remote {
	
	public List<MemberVO> getAllMemberList() throws RemoteException;

	public int insertMember(MemberVO memVo) throws RemoteException;

	public int deleteMember(String memId) throws RemoteException;

	public int getCountMember(String memId) throws RemoteException;
	
	public int getCounMemberEamil(String memId) throws RemoteException;
	
	public MemberVO logInMember(Map<String, String> map) throws RemoteException;
	
	public MemberVO searchId(Map<String,String> map)throws RemoteException;
	
	public MemberVO searchPass(Map<String,String>map)throws RemoteException;

	public int changePass(MemberVO memVo)throws RemoteException;

	public int fixInformation(MemberVO memVo)throws RemoteException;

	public AdminVO LogInAdmin(Map<String, String> map)throws RemoteException;
	
	public EmpVO LogInEmp(Map<String, String> map)throws RemoteException;
	
	public int getCountEmp(String empId) throws RemoteException;

	public int insertEmp(EmpVO empVo) throws RemoteException;

	public List<EmpVO> searchemp(String emp) throws RemoteException; 
	
	public int deleteemp(String empId) throws RemoteException;
	
	public List<MemberVO> searchmember(String mem) throws RemoteException;
	
	public int fixInformationEmp(EmpVO empVo) throws RemoteException;
	
	//public List<MemberVO> sumSales(String mem_id) throws RemoteException;

	public int membershipGrade(MemberVO memVo) throws RemoteException;
	
	/**
	 * 회원별 구매 금액을 업데이트
	 * @param mem_id
	 */
	public void updateMemberSales(String mem_id) throws RemoteException;
	public List<EmpVO> getAllEmp() throws RemoteException;

	/**
	 * 수정
	 * 명언 가져오기
	 * @author 류주완
	 * @param count
	 * @return
	 */
	public String getWiseContent(String count) throws RemoteException;
}
