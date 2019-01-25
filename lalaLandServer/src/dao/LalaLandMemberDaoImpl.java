package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.AdminVO;
import vo.EmpVO;
import vo.MemberVO;

public class LalaLandMemberDaoImpl implements ILalaLandMemberDao {
	private SqlMapClient client;
	private static ILalaLandMemberDao dao;

	private LalaLandMemberDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}

	public static ILalaLandMemberDao getInstance() {
		if (dao == null)
			dao = new LalaLandMemberDaoImpl();
		return dao;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> memList = new ArrayList<MemberVO>();

		try {
			memList = client.queryForList("member.getAllMemberList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}
	
	

	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0;
		try {
			Object obj = client.insert("member.insertMember", memVo);

			if (obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {

			cnt = client.delete("member.deleteMember", memId);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int getCountMember(String memId) {
		int count = 0;

		try {
			count = (int) client.queryForObject("member.getCountMember", memId);

		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int getCounMemberEamil(String memId) {
		
		int count = 0;
		
		try {
			count = (int) client.queryForObject("member.getCounMemberEamil", memId);
			
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public MemberVO logInMember(Map<String, String> map) {

		MemberVO vo = null;

		try {
			vo = (MemberVO) client.queryForObject("member.logInMember", map);
		} catch (SQLException e) {
			vo = null;
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public MemberVO searchId(Map<String, String> map) {

		MemberVO vo = null;

		try {
			vo = (MemberVO) client.queryForObject("member.searchId", map);
		} catch (SQLException e) {
			vo = null;
			e.printStackTrace();
		}

		return vo;
	}

	@Override
	public MemberVO searchPass(Map<String, String> map) {

		MemberVO vo = null;

		try {
			vo = (MemberVO) client.queryForObject("member.searchPass", map);
		} catch (SQLException e) {
			vo = null;
			e.printStackTrace();
		}

		return vo;
	}

	@Override
	public int changePass(MemberVO memVo) {

		int mem = 0;

		try {
			mem = client.update("member.changePass", memVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mem;
	}

	@Override
	public int fixInformation(MemberVO memVo) {

		int mem = 0;

		try {
			mem = client.update("member.fixInformation", memVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;
	}

	@Override
	public AdminVO LogInAdmin(Map<String, String> map) {
		AdminVO vo = null;
		try {
			vo = (AdminVO) client.queryForObject("member.LogInAdmin", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}

	@Override
	public EmpVO LogInEmp(Map<String, String> map) {
		EmpVO vo = null;
		try {
			vo = (EmpVO) client.queryForObject("member.LogInEmp", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}

	@Override
	public int getCountEmp(String empId) {
		int count = 0;

		try {
			count = (int) client.queryForObject("member.getCountEmp", empId);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int insertEmp(EmpVO empVo) {
		int cnt = 0;
		try {
			Object obj = client.insert("member.insertEmp", empVo);

			if (obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<EmpVO> searchemp(String emp) {
		List<EmpVO> vo = null;

		try {
			vo = client.queryForList("member.searchemp", emp);
		} catch (SQLException e) {
		}
		return vo;
	}

	@Override
	public int deleteemp(String empId) {
		int cnt = 0;
		try {
			cnt = client.delete("member.deleteemp", empId);
		} catch (SQLException e) {
		}
		return cnt;
	}

	@Override
	public List<MemberVO> searchmember(String mem) {
		List<MemberVO> vo = null;

		try {
			vo = client.queryForList("member.searchmember", mem);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int fixInformationEmp(EmpVO empVo) {
		int mem = 0;

		try {
			mem = client.update("member.fixInformationEmp", empVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;
	}

	/*@Override
	public List<MemberVO> sumSales(String mem_id) {
		List<MemberVO> vo = null;
		
		try {
			vo = (List<MemberVO>) client.queryForObject("member.sumSales");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}*/

	@Override
	public int membershipGrade(MemberVO memVo) {
		int mem = 0;
		
		try {
			mem = client.update("member.membershipGrade", memVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return mem;
	}

	@Override
	public void updateMemberSales(String mem_id) {
		try {
			client.update("member.updateMemberSales",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<EmpVO> getAllEmp() {
		List<EmpVO> empList = new ArrayList<EmpVO>();
		
		try {
			empList = client.queryForList("member.getAllEmp");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empList;
	}

	@Override
	public String getWiseContent(String count) {
		String content=null;
		try {
			content=(String) client.queryForObject("member.getWiseContent",count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return content;
	}

}
