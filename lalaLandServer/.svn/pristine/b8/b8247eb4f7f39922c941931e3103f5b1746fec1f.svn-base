package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.LalaLandFoodDaoImpl;
import dao.LalaLandItemDaoImpl;
import vo.ConvenienceVO;
import vo.FoodVO;

public class LalaLandFoodServiceImpl  extends UnicastRemoteObject implements ILalaLandFoodService {
	
	private static LalaLandFoodDaoImpl dao;
	private static LalaLandFoodServiceImpl service;
	public LalaLandFoodServiceImpl() throws RemoteException {
		dao=LalaLandFoodDaoImpl.getInstance();
	}
	
	public static LalaLandFoodServiceImpl getInstance() throws RemoteException{
		if(service==null) service=new LalaLandFoodServiceImpl();
		return service;
	}
	
	@Override
	public List<FoodVO> selectFoodAll() throws RemoteException{
		
		return dao.selectFoodAll();
	}

	@Override
	public List<FoodVO> selectFoodByName(String food_name) throws RemoteException{
		
		return dao.selectFoodByName(food_name);
	}

	@Override
	public void insertFood(FoodVO food) throws RemoteException{
		dao.insertFood(food);
		
	}

	@Override
	public List<ConvenienceVO>  selectConenAll() throws RemoteException{
		
		return dao.selectConenAll();
	}

	@Override
	public int deleteFood(String food_id)throws RemoteException {
		
		return dao.deleteFood(food_id);
	}

	@Override
	public void updateFood(FoodVO food) throws RemoteException{
		dao.updateFood(food);
		
	}

}
