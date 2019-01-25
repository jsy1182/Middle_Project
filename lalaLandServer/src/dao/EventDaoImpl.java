package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.EventVO;

public class EventDaoImpl implements IEventDao{
	SqlMapClient client;
	private static IEventDao dao;
	
	private EventDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}
	
	public static IEventDao getInstance() {
		if(dao == null) dao = new EventDaoImpl();
		return dao;
	}

	@Override
	public List<EventVO> allEvent() throws SQLException {
		return client.queryForList("event.allEvent");
	}

	@Override
	public int insertEvent(EventVO vo) throws SQLException {
		if (client.insert("event.insertEvent", vo) == null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int updateEvent(EventVO vo) throws SQLException {
		return client.update("event.updateEvent", vo);
	}
}
