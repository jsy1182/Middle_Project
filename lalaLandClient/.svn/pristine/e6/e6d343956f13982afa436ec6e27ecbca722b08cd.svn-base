package vo;

import java.io.Serializable;

public class Item_buyVO implements Serializable{
	private static final long serialVersionUID = -78677366217105636L;
	
	private String itemBuy_id;
	private String item_id;
	private String mem_id;
	private String itemBuy_date;
	private String itemBuy_refend;
	private int itemBuy_sales;
	private String itemBuy_refendText;
	private String item_name;
	
	
	public String getItemBuy_refendText() {
		if(itemBuy_refend.equals("F")) {
			this.itemBuy_refendText="결제 완료";
		}else {
			this.itemBuy_refendText="구매취소";
		}
		return itemBuy_refendText;
	}
	public void setItemBuy_refendText(String itemBuy_refendText) {
		if(itemBuy_refend.equals("F")) {
			this.itemBuy_refendText="결제 완료";
		}else {
			this.itemBuy_refendText="구매취소";
		}
		//this.itemBuy_refendText = itemBuy_refendText;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItemBuy_id() {
		return itemBuy_id;
	}
	public void setItemBuy_id(String itemBuy_id) {
		this.itemBuy_id = itemBuy_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getItemBuy_date() {
		return itemBuy_date;
	}
	public void setItemBuy_date(String itemBuy_date) {
		this.itemBuy_date = itemBuy_date;
	}
	public String getItemBuy_refend() {
		return itemBuy_refend;
	}
	public void setItemBuy_refend(String itemBuy_refend) {
		this.itemBuy_refend = itemBuy_refend;
	}
	public int getItemBuy_sales() {
		return itemBuy_sales;
	}
	public void setItemBuy_sales(int itemBuy_sales) {
		this.itemBuy_sales = itemBuy_sales;
	}
	
	
	
}
