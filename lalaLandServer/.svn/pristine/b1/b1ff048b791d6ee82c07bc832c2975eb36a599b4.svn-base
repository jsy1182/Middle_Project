package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.CouponVO;

public class CouponDaoImpl implements ICouponDao{
	SqlMapClient client;
	private static ICouponDao dao;
	
	private CouponDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}
	
	public static ICouponDao getInstance(){
		if(dao == null) dao = new CouponDaoImpl();
		return dao;
	}

	@Override
	public List<CouponVO> showCoupon(String mem_id) throws SQLException {
		System.out.println("dsad----------------");
		return client.queryForList("coupon.showCoupon",mem_id);
	}
}
