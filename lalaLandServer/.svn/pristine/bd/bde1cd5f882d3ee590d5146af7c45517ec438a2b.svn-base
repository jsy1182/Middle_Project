package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.Annual_memberVO;
import vo.BuyVO;
import vo.EventVO;
import vo.Event_joinVO;
import vo.MemberVO;
import vo.TicketVO;

public class LalaLandBuyDaoImpl implements ILalaLandBuyDao {
	SqlMapClient client;

	public LalaLandBuyDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}

	@Override
	public TicketVO getTicket(String ticketId) throws SQLException {
		TicketVO ticketVO = null;
		ticketVO = (TicketVO) client.queryForObject("buy.getTicket", ticketId);
		return ticketVO;
	}

	@Override
	public List<Event_joinVO> getEventJoin(String memId) throws SQLException {
		List<Event_joinVO> ejList = null;
		ejList = client.queryForList("buy.getEventJoin", memId);
		return ejList;
	}

	@Override
	public List<EventVO> getEvent() throws SQLException {
		List<EventVO> eventList = null;
		eventList = client.queryForList("buy.getEvent");
		return eventList;
	}

	@Override
	public int checkBuy(BuyVO buyVO) throws SQLException {
		int buy = 0;
		buy = (int) client.queryForObject("buy.checkBuy", buyVO);
		if (buy == 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public int checkAnnual(Annual_memberVO annualVO) throws SQLException {
		int annual = 0;
		annual = (int) client.queryForObject("buy.checkAnnual", annualVO);
		if (annual == 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<TicketVO> getAllTicket() throws SQLException {
		List<TicketVO> list = null;
		list = client.queryForList("buy.getAllTicket");
		return list;
	}

	@Override
	public int insertBuy(BuyVO vo) throws SQLException {
		Object obj = client.insert("buy.insertBuy", vo);
		if (obj == null) {
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAnnual(Annual_memberVO vo) throws SQLException {
		Object obj = client.insert("buy.insertAnnual", vo);
		if (obj == null) {
			return 1;
		}
		return 0;
	}

	@Override
	public MemberVO getMember(String mem_id) throws SQLException {
		MemberVO memVO = (MemberVO) client.queryForObject("buy.getMember", mem_id);
		return memVO;
	}

	@Override
	public int checkAnnual2(String memId) throws SQLException {
		int annual = 0;
		annual = (int) client.queryForObject("buy.checkAnnual2", memId);
		if (annual == 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public int updateAnnual(Annual_memberVO vo) throws SQLException {
		int update = 0;
		update = client.update("buy.updateAnnual", vo);
		return update;
	}

	@Override
	public int updateTicket(TicketVO vo) throws SQLException {
		int update = 0;
		update = client.update("buy.updateTicket", vo);
		return update;
	}

	@Override
	public List<BuyVO> selectAllbuy() throws SQLException {
		List<BuyVO> list;
		list = client.queryForList("buy.getAllBuy");
		return list;
	}

	@Override
	public List<BuyVO> getBuywithid(String para) throws SQLException {
		List<BuyVO> list;
		list = client.queryForList("buy.getBuywithid", para);
		return list;
	}

	@Override
	public List<BuyVO> getBuyVOwithId(String mem_id) throws SQLException {
		List<BuyVO> list;
		list = client.queryForList("buy.getBuyVOwithId", mem_id);
		return list;
	}

	@Override
	public int refundTicket(String buy_id) throws SQLException {
		int update = 0;
		update = client.update("buy.refundTicket", buy_id);
		return update;
	}

	@Override
	public List<BuyVO> getAllbuyForChart() throws SQLException {
		List<BuyVO> list;
		list = client.queryForList("buy.getAllbuyForChart");
		return list;
	}

	@Override
	public int getTicketCount(String ticket_id) throws SQLException {
		int ticket = 0;
		ticket = (int) client.queryForObject("buy.getTicketCount", ticket_id);
		return ticket;
	}

	@Override
	public int getMemberCount(int num) throws SQLException {
		int count = 0;
		count = (int) client.queryForObject("buy.getMemberCount", num);
		return count;
	}

	@Override
	public List<BuyVO> getAllbuyForExcel(String date) throws SQLException {
		return client.queryForList("buy.getAllbuyForExcel",date);
	}

	@Override
	public List<String> selectAllDate() throws SQLException {
		return client.queryForList("buy.selectAllDate");
	}

	@Override
	public EventVO getEventwithEJID(String ej_id) throws SQLException {
		return (EventVO) client.queryForObject("buy.getEventwithEJID", ej_id);
	}

}
