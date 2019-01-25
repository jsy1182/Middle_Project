package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.ConvenienceVO;
import vo.FoodVO;

public interface ILalaLandFoodService extends Remote {
	/**
	 * 모든 음식에 대한 정보를 검색
	 * @author 류주완
	 * @since 2018-11-14
	 * @return List<FoodVO>
	 */
	public List<FoodVO> selectFoodAll()throws RemoteException;
	
	/**
	 * 음식이름으로 음식에 대한 정보를 검색
	 * @param food_id
	 * @return List<FoodVO>
	 * @author 류주완
	 * @since 2018-11-14
	 */
	public List<FoodVO> selectFoodByName(String food_name)throws RemoteException;
	
	/**
	 * 음식정보 추가
	 * @param food
	 * @author 류주완
	 * @since 2018-11-14
	 */
	public void insertFood(FoodVO food)throws RemoteException;
	
	/**
	 * 편의 시설 에 대한 정보를 가져온다.
	 * @return
	 * @author 류주완
	 * @since 2018-11-14
	 */
	public List<ConvenienceVO>  selectConenAll()throws RemoteException;
	
	/**
	 * 음식에 대한 정보 삭제 
	 * @return String
	 * @author 류주완
	 * @since 2018-11-14
	 */
	public int deleteFood(String food_id)throws RemoteException;
	
	/**
	 * 음식에 대한 정보를 수정
	 * @param food
	 * @author 류주완
	 * @since 2018-11-14
	 */
	public void updateFood(FoodVO food)throws RemoteException;
}
