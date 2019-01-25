package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.LalaLandDaoImpl;
import dao.LalaLandItemDaoImpl;
import vo.ConvenienceVO;
import vo.ItemVO;
import vo.Item_buyVO;

public class LalaLandItemServiceImpl extends UnicastRemoteObject implements ILalaLandItemService {

	private static LalaLandItemDaoImpl dao;
	private static LalaLandItemServiceImpl service;
	public LalaLandItemServiceImpl() throws RemoteException {
		dao=LalaLandItemDaoImpl.getInstance();
	}
	
	public static LalaLandItemServiceImpl getInstance() throws RemoteException{
		if(service==null) service=new LalaLandItemServiceImpl();
		return service;
	}
	@Override
	public List<ItemVO> selectItemAll()throws RemoteException{
		return dao.selectItemAll();
	}

	@Override
	public List<ItemVO> selectItemByName(String item_name) throws RemoteException{
		
		return dao.selectItemByName(item_name);
	}

	@Override
	public void insertItem(ItemVO item) throws RemoteException{
		
		dao.insertItem(item);
	}

	@Override
	public List<ConvenienceVO> selectConvenAll()throws RemoteException {
		
		return dao.selectConvenAll();
	}

	@Override
	public int deleteItem(String item_id)throws RemoteException {
		
		return dao.deleteItem(item_id);
	}

	@Override
	public void updateItem(ItemVO item)throws RemoteException {
		dao.updateItem(item);
		
	}

	@Override
	public void insertItemBuy(Item_buyVO itemBuy) throws RemoteException {
		dao.insertItemBuy(itemBuy);
		
	}

	@Override
	public List<Item_buyVO> selectItemBuyAll() throws RemoteException {
		
		return dao.selectItemBuyAll();
	}

	@Override
	public void updateItemBuy(Item_buyVO itemBuy)  throws RemoteException{
		dao.updateItemBuy(itemBuy);
		
	}

	@Override
	public List<Item_buyVO> selectItemBuyItemNameRefund() throws RemoteException {
		
		return dao.selectItemBuyItemNameRefund();
	}



}
