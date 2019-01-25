package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.Annual_memberVO;
import vo.BuyVO;
import vo.EventVO;
import vo.Event_joinVO;
import vo.MemberVO;
import vo.TicketVO;

public interface ILalaLandBuyService extends Remote {
	/**
	 * buy테이블에 있는 ticketId로 TicketVO를 가져온다.
	 * @param ticketId
	 * @return ticketVO
	 */
	public TicketVO getTicket(String ticketId) throws RemoteException;
	/**
	 * 회원이 참여한 EventJoin리스트를 가져온다.
	 * @param memId 로그인한 회원의 ID
	 * @return EventJoin리스트
	 */
	public List<Event_joinVO> getEventJoin(String memId) throws RemoteException;
	
	/**
	 * 이벤트 전체 목록을 가져온다.
	 * @return
	 */
	public List<EventVO> getEvent() throws RemoteException;
	/**
	 * 아이디가 구매 테이블에 존재하고 구매날이 오늘날짜와 같은지
	 * @param memId
	 * @return
	 */
	public int checkBuy(BuyVO buyVO) throws RemoteException;
	/**
	 * 멤버가 연간회원인지 확인
	 * @param memId
	 * @return
	 * @throws RemoteException
	 */
	public int checkAnnual(Annual_memberVO annualVO) throws RemoteException;
	/**
	 * 멤버가 이전에 연간회원을 구입한적이 있는지 확인
	 * @param memId
	 * @return
	 * @throws RemoteException
	 */
	public int checkAnnual2(String memId) throws RemoteException;
	/**
	 * 모든티켓을 가져온다.
	 * @return
	 * @throws RemoteException
	 */
	public List<TicketVO> getAllTicket() throws RemoteException;
	/**
	 * buy테이블에 추가
	 * @param vo
	 * @return insert성공이면 1반환 실패면 0반환
	 * @throws RemoteException
	 */
	public int insertBuy(BuyVO vo) throws RemoteException;
	/**
	 * anuual 테이블에 추가
	 * @param vo
	 * @return insert성공이면 1반환 실패면 0반환
	 * @throws RemoteException
	 */
	public int insertAnnual(Annual_memberVO vo) throws RemoteException;
	/**
	 * 멤버아이디로 멤버를 가져온다
	 * @param mem_id
	 * @return 멤버VO
	 * @throws RemoteException
	 */
	public MemberVO getMember(String mem_id) throws RemoteException;
	/**
	 * 연간회원이 이전에 구매한 이력이 있을경우 사용할 update메서드
	 * @param vo 업데이트할 연간회원 vo
	 * @return 업데이트된 행의 갯수
	 * @throws RemoteException
	 */
	public int updateAnnual(Annual_memberVO vo) throws RemoteException;
	/**
	 * 티켓의 가격을 수정한다.
	 * @param vo 수정된 티켓vo
	 * @return 업데이트된 행의갯수
	 * @throws RemoteException
	 */
	public int updateTicket(TicketVO vo) throws RemoteException;
	/**
	 * 오늘날짜 이후의 모든 구매vo를 가져온다.
	 * @return
	 * @throws RemoteException
	 */
	public List<BuyVO> selectAllbuy() throws RemoteException;
	/**
	 * 회원 아이디 또는 구매아이디로 구매리스트를 가져온다.
	 * @param para 회원 아이디 또는 구매아이디
	 * @return
	 * @throws RemoteException
	 */
	public List<BuyVO> getBuywithid(String para) throws RemoteException;
	/**
	 * 회원아이디를 파라미터로 회원이 구매한 내역을 가져온다(단체구매 제외)
	 * @param mem_id 회원 id
	 * @return 회원이 구매한 내역(단체구매 제외)
	 * @throws RemoteException
	 */
	public List<BuyVO> getBuyVOwithId(String mem_id) throws RemoteException;
	/**
	 * 구매내역의 refund컬럼을 T로 바꾼다.
	 * @param buy_id
	 * @return
	 * @throws RemoteException
	 */
	public int refundTicket(String buy_id) throws RemoteException;
	/**
	 * 구매내역 전체를 가져온다.
	 * @return
	 * @throws RemoteException
	 */
	public List<BuyVO> getAllbuyForChart() throws RemoteException;
	/**
	    * 구매내역에서 구매한 티켓의 수를 가져온다.
	    * @param ticket_id
	    * @return
	    * @throws SQLException
	    */
	   public int getTicketCount(String ticket_id) throws RemoteException;
	   /**
	    * 멤버의 연령별 판매분포
	    * @param num
	    * @return
	    * @throws RemoteException
	    */
	   public int getMemberCount(int num)throws RemoteException;
	   
	   /**
	    * 엑셀에서 날짜별로 워크북 만들기 위한 메서드
	    * @param date
	    * @return list<BuyVO>
	    * @throws RemoteException
	    * @author 전선영
	    * 
	    */
	   public List<BuyVO> getAllbuyForExcel(String date)throws RemoteException;
	   /**
	    * 구매내역이 있는 날짜를 모두 출력하는 메서드
	    * @return
	    * @throws RemoteException
	    * @author 전선영
	    */
	   public List<String> selectAllDate() throws RemoteException;
	   /**
	    * 이벤트조인 아이디로 이벤트vo를 가져온다.
	    * @param ej_id
	    * @return
	    * @throws RemoteException
	    */
	   public EventVO getEventwithEJID(String ej_id) throws RemoteException;
}
