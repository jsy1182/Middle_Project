package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.Annual_memberVO;
import vo.BuyVO;
import vo.EventVO;
import vo.Event_joinVO;
import vo.MemberVO;
import vo.TicketVO;

public interface ILalaLandBuyDao {
	public TicketVO getTicket(String ticketId) throws SQLException;
	public List<Event_joinVO> getEventJoin(String memId) throws SQLException;
	public List<EventVO> getEvent() throws SQLException;
	public int checkBuy(BuyVO buyVO) throws SQLException;
	public int checkAnnual(Annual_memberVO annualVO) throws SQLException;
	public int checkAnnual2(String memId) throws SQLException;
	public List<TicketVO> getAllTicket() throws SQLException;
	
	public int insertBuy(BuyVO vo) throws SQLException;
	
	public int insertAnnual(Annual_memberVO vo) throws SQLException;
	
	public MemberVO getMember(String mem_id) throws SQLException;
	
	public int updateAnnual(Annual_memberVO vo) throws SQLException;
	
	public int updateTicket(TicketVO vo) throws SQLException;
	
	public List<BuyVO> selectAllbuy() throws SQLException;
	
	public List<BuyVO> getBuywithid(String para) throws SQLException;
	
	public List<BuyVO> getBuyVOwithId(String mem_id) throws SQLException;
	
	public int refundTicket(String buy_id) throws SQLException;
	
	public List<BuyVO> getAllbuyForChart() throws SQLException;
	
	public int getTicketCount(String ticket_id) throws SQLException;
	   
	public int getMemberCount(int num)throws SQLException;
	
	public List<BuyVO> getAllbuyForExcel(String date)throws SQLException;
	
	public List<String> selectAllDate() throws SQLException;
	
	public EventVO getEventwithEJID(String ej_id) throws SQLException;
}
