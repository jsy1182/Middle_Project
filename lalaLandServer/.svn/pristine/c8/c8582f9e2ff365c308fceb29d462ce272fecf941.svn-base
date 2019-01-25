package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import javafx.fxml.FXMLLoader;
import vo.AnimalVO;
import vo.FarmVO;

public class ZooDaoImpl implements IZooDao {
	private SqlMapClient client;
	private static IZooDao dao;
	
	private ZooDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}
	
	public static IZooDao getInstance() {
		if(dao==null) dao = new ZooDaoImpl();
		return dao;
	}

	/**
	 *  벨리 콤보 리스트 가져오기
	 */
	@Override
	public List<String> getComboList(String belly_name) throws SQLException {
		return client.queryForList("zoo.getComboList", belly_name);
	}

	@Override
	public String getAnimalExplain(String animal_name) throws SQLException {
		return (String) client.queryForObject("zoo.getAnimalExplain", animal_name);
	}

	@Override
	public List<AnimalVO> getAllAnimal() throws SQLException {
		return client.queryForList("zoo.getAllAnimal");
	}

	@Override
	public int insertAnimal(AnimalVO avo) throws SQLException {
		Object obj = client.insert("zoo.inertAnimal",avo);
		if(obj != null) return 1;
		return 0;
	}

	@Override
	public int deleteAnimal(String id) throws SQLException {
		int cnt = client.delete("zoo.deleteAnimal", id);
		return cnt;
	}

	@Override
	public int updateAnimal(AnimalVO vo) throws SQLException {
		return client.update("zoo.updateAnimal", vo);
	}

	
}
