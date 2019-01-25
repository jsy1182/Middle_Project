package dao;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import vo.ConvenienceVO;
import vo.ItemVO;
import vo.Item_buyVO;

public interface ILalaLandItemDao {
	
	/**
	 * 아이템목록가져오기
	 * @return ItemVO 전체
	 * @author 류주완
	 * @since 2018-11-12
	 * 
	 */
	public List<ItemVO> selectItemAll();
	
	/**
	 * 텍스트필드로 아이템의 이름을 검색
	 * @param Item_name
	 * @return List<ItemVO>
	 * @author 류주완
	 * @since 2018-11-12
	 */
	public List<ItemVO> selectItemByName(String item_name);
	
	
	/**
	 * 아이템을 추가하는 메서드
	 * @param item
	 * 
	 * @author 류주완
	 * @since 2018-11-12
	 * 
	 */
	public void insertItem(ItemVO item);
	
	/**
	 * 편의시설분류를 가져간다.
	 * @return List<ConvenienceVO>
	 * @author 류주완
	 * @since 2018-11-13
	 */
	public List<ConvenienceVO> selectConvenAll();
	
	/**
	 * 아이템목록에서 아이템을 삭제
	 * @return String
	 * @author 류주완
	 * @since 2018-11-14
	 */
	public int deleteItem(String item_id);
	
	/**
	 * 아이템 목록 업데이트
	 * @param item
	 * @author 류주완
	 * @since 2018-11-16
	 */
	public void updateItem(ItemVO item);
	/**
	 * 아이템을 구매하면 아이템 구매 목록에 추가 
	 * @param itemBuy
	 * @author 류주완
	 * @since 2018-11-16
	 */
	public void insertItemBuy(Item_buyVO itemBuy);

	/**
	 * 아이템 구매 목록을 가져온다.
	 * @return List<Item_buyVO>
	 * @author 류주완
	 * @since 2018-11-19
	 */
	public List<Item_buyVO> selectItemBuyAll();
	
	/**
	 * 아이템 구매 목록을 가져온다.item_name과 refund
	 * @return List<Item_buyVO>
	 * @author 류주완
	 * @since 2018-11-21
	 */
	public List<Item_buyVO> selectItemBuyItemNameRefund();	
	/**
	 * 아이템을 구매 취소하여 update하는 부분
	 * @param itemBuy
	 * @return 
	 * @author 류주완
	 * @since 2018-11-19
	 */
	public void updateItemBuy(Item_buyVO itemBuy);
}
