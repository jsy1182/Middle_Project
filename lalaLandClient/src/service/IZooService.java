package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.AnimalVO;

public interface IZooService extends Remote{
	/**
	 * combo박스 리스트가져오기(동물이름)
	 * @return list<String>
	 * @throws RemoteException
	 */
	public List<String> getComboList(String string) throws RemoteException;
	

	/**
	 * 동물 설명 가져오기
	 * @param animal_name
	 * @return 동물설명
	 * @throws RemoteException
	 */
	public String getAnimalExplain(String animal_name) throws RemoteException;


	/**
	 * 직원 - 테이블에 모든 동물 정보 가져오기
	 * @return
	 * @throws RemoteException
	 */
	public List<AnimalVO> getAllAnimal() throws RemoteException;


	/**
	 * 직원 - 동물 추가하기
	 * @param avo
	 * @return
	 * @throws RemoteException
	 */
	public int insertAnimal(AnimalVO avo) throws RemoteException;


	/**
	 * 직원 - 동물 삭제하기
	 * @param id
	 * @throws RemoteException
	 */
	public int deleteAnimal(String id) throws RemoteException;


	/**
	 * 직원 - 동물 수정하기
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	public int updateAnimal(AnimalVO vo) throws RemoteException;

}
