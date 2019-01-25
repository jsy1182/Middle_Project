package dao;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;

public class LalaLandDaoImpl implements ILalaLandDao {
	private SqlMapClient client ;
	private static ILalaLandDao dao;
	
	private LalaLandDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}
	
	public static ILalaLandDao getInstance() {
		if(dao==null) dao = new LalaLandDaoImpl();
		return dao;
	}

}
