package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.Event_joinVO;

public class EventJoinDaoImpl implements IEventJoinDao{
	private SqlMapClient client;
	private static IEventJoinDao dao;
	
	private EventJoinDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}
	
	public static IEventJoinDao getInstance() {
		if(dao == null) dao = new EventJoinDaoImpl();
		return dao;
	}

	@Override
	public List<Event_joinVO> allEventJoin() throws SQLException {
		return client.queryForList("eventJoin.allEventJoin");
	}

	@Override
	public int insertEventJoin(Event_joinVO vo) throws SQLException {
		if(client.insert("eventJoin.insertEventJoin",vo)== null) return 1;
		return 0;
	}

	@Override
	public int selectMemId(String mem_id, String event_id) throws SQLException {
		if(client.queryForObject("eventJoin.selectMemId",mem_id,event_id) == null) return 1;
		return 0;
	}
	
	
	
	
}
