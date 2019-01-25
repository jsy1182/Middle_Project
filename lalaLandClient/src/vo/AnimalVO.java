package vo;

import java.io.Serializable;

public class AnimalVO implements Serializable{
	private static final long serialVersionUID = 302809679204630315L;
	
	private String animal_id;
	private String animal_name;
	private String animal_content;
	private String farm_id;
	public String getAnimal_id() {
		return animal_id;
	}
	public void setAnimal_id(String animal_id) {
		this.animal_id = animal_id;
	}
	public String getAnimal_name() {
		return animal_name;
	}
	public void setAnimal_name(String animal_name) {
		this.animal_name = animal_name;
	}
	public String getAnimal_content() {
		return animal_content;
	}
	public void setAnimal_content(String animal_content) {
		this.animal_content = animal_content;
	}
	public String getFarm_id() {
		return farm_id;
	}
	public void setFarm_id(String farm_id) {
		this.farm_id = farm_id;
	}
	
	
}