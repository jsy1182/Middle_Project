package dao;

import java.util.List;
import java.util.Map;

import javafx.scene.AmbientLight;
import vo.AdminVO;
import vo.EmpVO;
import vo.MemberVO;

public interface ILalaLandMemberDao {
	
	/**
	 * 
	 * @return
	 * @author 오지원
	 * @since 2018-11-12
	 * 
	 * 멤버 전체를 보여주는 메서드
	 */
	public List<MemberVO> getAllMemberList();
	
	/**
	 * 
	 * @param memVo
	 * @return
	 * @author 오지원
	 * @since 2018-11-12
	 * 
	 * 멤버를 추가하는 메서드
	 */
	public int insertMember(MemberVO memVo);
	
	/**
	 * 
	 * @param memId
	 * @return
	 * @author 오지원
	 * @since 2018-11-12
	 * 멤버를 삭제하는 메서드
	 */
	public int deleteMember(String memId);
	
	/**
	 * 
	 * @param memId
	 * @return
	 * @author 오지원
	 * @2018-11-12
	 * 
	 * 중복된 아이디를 삭제 하기 위해 아이디 존재 여부에 따라 1과 0으로 나타낸다.
	 */
	public int getCountMember(String memId);
	
	/**
	 * 
	 * @param memId
	 * @return
	 * @author 오지원
	 * @2018-11-26
	 * 
	 * 이메일 중복하면 안됨
	 */
	public int getCounMemberEamil(String memId);
	
	
	/**
	 * 
	 * @param memId
	 * @return
	 * @author 오지원
	 * @since 2018-11-13
	 * 
	 * 로그인을 위해 아이디를 가지고 오는 
	 */
	public MemberVO logInMember(Map<String, String> map);
	
	/**
	 * 
	 * @param map
	 * @return
	 * @author 오지원
	 * @since 2018 -11-14
	 * 
	 * 아이디 찾기를 위해 이름과 이메일을 가지고 오는 
	 */
	public MemberVO searchId(Map<String,String> map);
	
	/**
	 * 
	 * @param map
	 * @return
	 * @author 오지원
	 * @since 2018-11-14
	 *
	 * 비밀번호를 찾기위해 아이디와 이메일을 가지고 오는 
	 */
	public MemberVO searchPass(Map<String,String>map);
	
	/**
	 * 
	 * @param memVo
	 * @return
	 * @author 오지원
	 * @since 2018-11-15
	 * 
	 * 비밀번호를 찾기 위해 이메일로 임시 비밀번호를 보내고 보낸 임시 비밀번호로 수정하는 
	 */
	public int changePass(MemberVO memVo);
	
	/**
	 * 
	 * @param memVo
	 * @return
	 * @author 오지원
	 * @since 2018-11-16
	 * 
	 * 회원정보를 수정하기 위해
	 */
	public int fixInformation(MemberVO memVo);
	
	/**
	 * 관리자로 로그인 하는 메서드
	 * @param map
	 * @author 전선영
	 * @return
	 */
	public AdminVO LogInAdmin(Map<String, String> map);
	
	/**
	 * 직원으로 로그인 하는 메서드
	 * @param map
	 * @author 전선영
	 * @return
	 */
	public EmpVO LogInEmp(Map<String, String> map);
	
	public int getCountEmp(String empId);
	
	/**
	 * 
	 * @param empVo
	 * @return
	 * @author 오지원
	 * 
	 * 직원을 추가하는 메서드
	 */
	public int insertEmp(EmpVO empVo);
	
	/**
	 * 
	 * @param map
	 * @return
	 * @author 오지원
	 * 
	 * 직원의 정보를 보기 위해 직원들을 검색하는 메서드
	 */
	public List<EmpVO> searchemp(String emp); 
	
	/**
	 * 
	 * @param empId
	 * @return
	 * @author 오지원
	 * 
	 * 직원을 삭제하는 메서드
	 */
	public int deleteemp(String empId);
	
	/**
	 * 
	 * @param mem
	 * @return
	 * @author 오지원
	 * 
	 * 회원의 정보를 보기 위해 회원들을 검색하는 메서드
	 * 
	 */
	public List<MemberVO> searchmember(String mem);
	
	/**
	 * 
	 * @param empVo
	 * @return
	 * @author 오지원
	 * 
	 * 직원의 정보를 수정하기 위한 메서드
	 */
	public int fixInformationEmp(EmpVO empVo);
	
/*	*//**
//	 * 
//	 * @param mem_id
//	 * @return
//	 * @author 오지원
//	 * 
//	 * 맴버쉽등급을 적용하기 위해 회원의 아이디와 구매 내역을 확인하는 메서드
//	 *//*
	public List<MemberVO> sumSales(String mem_id);*/
	
	/**
	 * 회원별 구매 금액을 업데이트
	 * @param mem_id
	 */
	public void updateMemberSales(String mem_id);

	/**
	 * 
	 * @param memVo
	 * @return
	 * @author 오지원
	 * 
	 * 맴버쉽등급을 적용하기 위해 회원의 맴버쉽 등급을 저장
	 */	  
	public int membershipGrade(MemberVO memVo);
	/**
	 * 
	 * @return
	 * @author 오지원
	 * 
	 * 직원을 전체 목록을 볼수 있음
	 */
	public List<EmpVO> getAllEmp();
	/**
	 * 수정
	 * 명언 가져오기
	 * @author 류주완
	 * @param count
	 * @return
	 */
	public String getWiseContent(String count);

}
