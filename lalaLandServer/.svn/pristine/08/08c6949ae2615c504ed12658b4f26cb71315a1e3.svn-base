package dao;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import vo.AnimalVO;
import vo.FarmVO;

public interface IZooDao {
	public List<String> getComboList(String belly_name) throws SQLException;
	
	public String getAnimalExplain(String animal_name) throws SQLException;
	
	/**
	 * 직원 - 테이블에 모든 동물 정보 가져오기
	 * @return
	 * @throws RemoteException
	 */
	public List<AnimalVO> getAllAnimal() throws SQLException;
	
	/**
	 * 직원 - 동물 추가하기
	 * @param avo
	 * @return
	 * @throws RemoteException
	 */
	public int insertAnimal(AnimalVO avo) throws SQLException;
	
	/**
	 * 직원 - 동물 삭제하기
	 * @param id
	 * @throws RemoteException
	 */
	public int deleteAnimal(String id) throws SQLException;

	/**
	 * 직원 - 동물 수정하기
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	public int updateAnimal(AnimalVO vo) throws SQLException;
}
