package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.ConvenienceVO;
import vo.ItemVO;
import vo.Item_buyVO;

public class LalaLandItemDaoImpl implements ILalaLandItemDao {
	
	private SqlMapClient client ;
	private static LalaLandItemDaoImpl dao;
	
	public LalaLandItemDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}
	
	public static LalaLandItemDaoImpl getInstance() {
		if(dao==null) dao= new LalaLandItemDaoImpl();
		return dao;
	}
	
	@Override
	public List<ItemVO> selectItemAll() {
		List<ItemVO> itemlist=null;
		try {
			itemlist=client.queryForList("item.selectItemAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemlist;
		
	}

	@Override
	public List<ItemVO> selectItemByName(String item_name) {
		List<ItemVO> itemlist=null;
		try {
			itemlist=client.queryForList("item.selectItemByName",item_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemlist;
	}
/*
	@Override
	public List<ItemVO> selectItemByPriceName(int item_Price) {
		List<ItemVO> itemlist=null;
		try {
			itemlist=client.queryForList("item.selectItemByPrice",item_Price);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemlist;
	}*/

	@Override
	public void insertItem(ItemVO item) {
		
		try {
			client.insert("item.insertItem",item);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public List<ConvenienceVO> selectConvenAll() {
		List<ConvenienceVO> conven=null;
		try {
			conven = client.queryForList("item.selectConvenAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conven;
	}

	@Override
	public int deleteItem(String item_id) {
		int item=0;
		try {
			item=client.delete("item.deleteItem",item_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public void updateItem(ItemVO item) {
		try {
			client.update("item.updateItem",item);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertItemBuy(Item_buyVO itemBuy) {
		try {
			client.insert("item.insertItemBuy",itemBuy);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Item_buyVO> selectItemBuyAll() {
		List<Item_buyVO> item=null;
		
		try {
			item=client.queryForList("item.selectItemBuyAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public void updateItemBuy(Item_buyVO itemBuy) {
		try {
			client.update("item.updateItemBuy",itemBuy);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Item_buyVO> selectItemBuyItemNameRefund() {
		List<Item_buyVO> itemBuy=null;
		try {
			itemBuy=client.queryForList("item.selectItemBuyItemNameRefund");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemBuy;
	}

}
