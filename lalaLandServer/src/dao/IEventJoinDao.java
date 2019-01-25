package dao;

import java.sql.SQLException;
import java.util.List;

import vo.Event_joinVO;

public interface IEventJoinDao{
	public List<Event_joinVO> allEventJoin() throws SQLException;
	public int insertEventJoin(Event_joinVO vo) throws SQLException;
	public int selectMemId(String mem_id, String event_id) throws SQLException;
}
