package config;

import java.io.Reader;


import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {

	private static SqlMapClient smc;
	
	static {
		
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("config/sqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static SqlMapClient getInstance() {
		return smc;
	}
	
	
}
