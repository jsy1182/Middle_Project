package vo;

import java.io.Serializable;

public class ItemVO implements Serializable{
	private static final long serialVersionUID = -1061771582679778553L;
	
	private String item_id;
	private String item_name;
	private int item_price;
	private String item_sold;
	private String item_content;
	private String con_id;
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public String getItem_sold() {
		return item_sold;
	}
	public void setItem_sold(String item_sold) {
		this.item_sold = item_sold;
	}
	public String getItem_content() {
		return item_content;
	}
	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}
	public String getCon_id() {
		return con_id;
	}
	public void setCon_id(String con_id) {
		this.con_id = con_id;
	}
	
	
}
