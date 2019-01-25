package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import dao.ILalaLandMemberDao;
import dao.LalaLandMemberDaoImpl;
import vo.AdminVO;
import vo.EmpVO;
import vo.MemberVO;

public class LalaLandMemberServiceImpl extends UnicastRemoteObject implements ILalaLandMemberService {
	
	private ILalaLandMemberDao dao ;
	private static ILalaLandMemberService service;
	
	private LalaLandMemberServiceImpl() throws RemoteException{
		dao = LalaLandMemberDaoImpl.getInstance();
		
	}
	public static ILalaLandMemberService getInstance() throws RemoteException {
		if(service == null) service= new LalaLandMemberServiceImpl();
		return service;
	}
	@Override
	public List<MemberVO> getAllMemberList() throws RemoteException{
		return dao.getAllMemberList();
	}
	
	@Override
	public int insertMember(MemberVO memVo) throws RemoteException{
		return dao.insertMember(memVo);
	}
	@Override
	public int deleteMember(String memId) throws RemoteException{
		return dao.deleteMember(memId);
	}
	@Override
	public int getCountMember(String memId) throws RemoteException{
		return dao.getCountMember(memId);
	}
	
	@Override
	public int getCounMemberEamil(String memId) throws RemoteException {
		return dao.getCounMemberEamil(memId);
	}
	
	@Override
	public MemberVO logInMember(Map<String, String> map) throws RemoteException {
		return dao.logInMember(map);
	}
	@Override
	public MemberVO searchId(Map<String, String> map) throws RemoteException {
		return dao.searchId(map);
	}
	@Override
	public MemberVO searchPass(Map<String, String> map) throws RemoteException {
		return dao.searchPass(map);
	}
	@Override
	public int changePass(MemberVO memVo) throws RemoteException {
		return dao.changePass(memVo);
	}
	@Override
	public int fixInformation(MemberVO memVo) throws RemoteException {
		return dao.fixInformation(memVo);
	}
	@Override
	public AdminVO LogInAdmin(Map<String, String> map) throws RemoteException {
		return dao.LogInAdmin(map);
	}
	@Override
	public EmpVO LogInEmp(Map<String, String> map) throws RemoteException {
		return dao.LogInEmp(map);
	}
	@Override
	public int getCountEmp(String empId) throws RemoteException {
		return dao.getCountEmp(empId);
	}
	@Override
	public int insertEmp(EmpVO empVo) throws RemoteException {
		return dao.insertEmp(empVo);
	}
	@Override
	public List<EmpVO> searchemp(String emp) throws RemoteException {
		return dao.searchemp(emp);
	}
	@Override
	public int deleteemp(String empId) throws RemoteException {
		return dao.deleteemp(empId);
	}
	@Override
	public List<MemberVO> searchmember(String mem) throws RemoteException {
		return dao.searchmember(mem);
	}
	@Override
	public int fixInformationEmp(EmpVO empVo) throws RemoteException{
		return dao.fixInformationEmp(empVo);
	}
/*	@Override
	public List<MemberVO> sumSales(String mem_id) throws RemoteException {
		return dao.sumSales(mem_id);
	}*/
	@Override
	public int membershipGrade(MemberVO memVo) throws RemoteException {
		return dao.membershipGrade(memVo);
	}
	@Override
	public void updateMemberSales(String mem_id) throws RemoteException {
		dao.updateMemberSales(mem_id);
		
	}
@Override
	public List<EmpVO> getAllEmp() throws RemoteException {
		return dao.getAllEmp();
	}
@Override
public String getWiseContent(String count) throws RemoteException {
	
	return  dao.getWiseContent(count);
}

}

