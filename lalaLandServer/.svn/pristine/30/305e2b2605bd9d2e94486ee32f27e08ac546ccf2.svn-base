package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.ILalaLandBuyDao;
import dao.LalaLandBuyDaoImpl;
import vo.Annual_memberVO;
import vo.BuyVO;
import vo.EventVO;
import vo.Event_joinVO;
import vo.MemberVO;
import vo.TicketVO;

public class LalaLandBuyServiceImpl extends UnicastRemoteObject implements ILalaLandBuyService{
	ILalaLandBuyDao dao;
	public LalaLandBuyServiceImpl() throws RemoteException{
		dao=new LalaLandBuyDaoImpl();
	}
	
	@Override
	public TicketVO getTicket(String ticketId) throws RemoteException{
		TicketVO ticketVO=null;
		try {
			ticketVO=dao.getTicket(ticketId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticketVO;
	}

	@Override
	public List<Event_joinVO> getEventJoin(String memId) throws RemoteException{
		List<Event_joinVO> ejList=null;
		try {
			ejList=dao.getEventJoin(memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ejList;
	}

	@Override
	public List<EventVO> getEvent() throws RemoteException{
		List<EventVO> eventList=null;
		try {
			eventList=dao.getEvent();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventList;
	}

	@Override
	public int checkBuy(BuyVO buyVO) throws RemoteException{
		int num=0;
		try {
			num=dao.checkBuy(buyVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int checkAnnual(Annual_memberVO annualVO) throws RemoteException{
		int num=0;
		try {
			num=dao.checkAnnual(annualVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<TicketVO> getAllTicket() throws RemoteException{
		List<TicketVO> list=null;
		try {
			list=dao.getAllTicket();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertBuy(BuyVO vo) throws RemoteException {
		int num=0;
		try {
			num=dao.insertBuy(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int insertAnnual(Annual_memberVO vo) throws RemoteException {
		int num=0;
		try {
			num=dao.insertAnnual(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public MemberVO getMember(String mem_id) throws RemoteException {
		MemberVO memVO=null;
		try {
			memVO=dao.getMember(mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return memVO;
	}

	@Override
	public int checkAnnual2(String memId) throws RemoteException {
		int num=0;
		try {
			num=dao.checkAnnual2(memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int updateAnnual(Annual_memberVO vo) throws RemoteException {
		int update=0;
		try {
			update=dao.updateAnnual(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public int updateTicket(TicketVO vo) throws RemoteException {
		int update=0;
		try {
			update=dao.updateTicket(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public List<BuyVO> selectAllbuy() throws RemoteException {
		List<BuyVO> list = null;
		try {
			list=dao.selectAllbuy();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BuyVO> getBuywithid(String para) throws RemoteException {
		List<BuyVO> list=null;
		try {
			list=dao.getBuywithid(para);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BuyVO> getBuyVOwithId(String mem_id) throws RemoteException {
		List<BuyVO> list=null;
		try {
			list=dao.getBuyVOwithId(mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int refundTicket(String buy_id) throws RemoteException {
		int update=0;
		try {
			update=dao.refundTicket(buy_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public List<BuyVO> getAllbuyForChart() throws RemoteException {
		List<BuyVO> list = null;
		try {
			list=dao.getAllbuyForChart();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	 @Override
	   public int getTicketCount(String ticket_id) throws RemoteException {
	      int ticket=0;
	      try {
	         ticket=dao.getTicketCount(ticket_id);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return ticket;
	   }

	   @Override
	   public int getMemberCount(int num) throws RemoteException {
	      int count =0;
	      try {
	         count = dao.getMemberCount(num);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return count;
	   }

	@Override
	public List<BuyVO> getAllbuyForExcel(String date) throws RemoteException {
		List<BuyVO> list = null;
		try {
			list=dao.getAllbuyForExcel(date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<String> selectAllDate() throws RemoteException {
		List<String> list = null;
		try {
			list = dao.selectAllDate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public EventVO getEventwithEJID(String ej_id) throws RemoteException {
		EventVO evo=null;
		try {
			evo=dao.getEventwithEJID(ej_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return evo;
	}

}//end of ServiceImpl
