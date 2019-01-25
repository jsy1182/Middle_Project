package dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import config.SqlMapClientFactory;
import vo.AttendVO;

public class AttendDaoImpl implements IAttendDao{
	private SqlMapClient client ;
	private static IAttendDao dao;
	
	private AttendDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}
	
	public static IAttendDao getInstance() {
		if(dao==null) dao = new AttendDaoImpl();
		return dao;
	}

	@Override
	public int attendCheck(AttendVO vo) throws SQLException {
		return (int) client.queryForObject("attend.attendCheck",vo);
	}

	@Override
	public int insertAttend(AttendVO vo) throws SQLException {
		if(client.insert("attend.insertAttend", vo)==null) return 1;
		else return 0;
	}
}
