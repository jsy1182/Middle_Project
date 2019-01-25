package vo;

import java.io.Serializable;

public class FarmVO implements Serializable{
	private static final long serialVersionUID = -7886507099908853625L;
	
	private String farm_id;
	private String farm_name;
	private String farm_pos;
	public String getFarm_id() {
		return farm_id;
	}
	public void setFarm_id(String farm_id) {
		this.farm_id = farm_id;
	}
	public String getFarm_name() {
		return farm_name;
	}
	public void setFarm_name(String farm_name) {
		this.farm_name = farm_name;
	}
	public String getFarm_pos() {
		return farm_pos;
	}
	public void setFarm_pos(String farm_pos) {
		this.farm_pos = farm_pos;
	}
	
	
}
