package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.ConvenienceVO;
import vo.FoodVO;
import vo.ItemVO;

public class LalaLandFoodDaoImpl implements ILalaLandFoodDao {
	private SqlMapClient client;
	private static LalaLandFoodDaoImpl dao;
	
	public LalaLandFoodDaoImpl() {
		client=SqlMapClientFactory.getInstance();
	}
	public static LalaLandFoodDaoImpl getInstance() {
		if(dao==null) dao= new LalaLandFoodDaoImpl();
		return dao;
	}

	@Override
	public List<FoodVO> selectFoodAll() {
		List<FoodVO> foodlist=null;
		try {
			foodlist=client.queryForList("food.selectFoodAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foodlist;
	}

	@Override
	public List<FoodVO> selectFoodByName(String food_name) {
		List<FoodVO> foodlist=null;
		try {
			foodlist=client.queryForList("food.selectFoodByName",food_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foodlist;
	}

	@Override
	public void insertFood(FoodVO food) {
		try {
			client.insert("food.insertFood",food);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ConvenienceVO>  selectConenAll() {
		List<ConvenienceVO> conven=null;
		try {
			conven = client.queryForList("food.selectConvenAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conven;
	}

	@Override
	public int deleteFood(String food_id) {
		int food=0;
		try {
			food=client.delete("food.deleteFood",food_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return food;
	}

	@Override
	public void updateFood(FoodVO food) {
		try {
			client.update("food.updateFood",food);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
