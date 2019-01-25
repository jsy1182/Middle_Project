package vo;

import java.io.Serializable;

public class BuyVO implements Serializable{
	private static final long serialVersionUID = -4252296479883184307L;
	
	private String buy_id;
	private String buy_date;
	private String refund;
	private int sales;
	private String ticket_id;
	private String mem_id;
	private String ej_id;
	public String getBuy_id() {
		return buy_id;
	}
	public void setBuy_id(String buy_id) {
		this.buy_id = buy_id;
	}
	public String getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getEj_id() {
		return ej_id;
	}
	public void setEj_id(String ej_id) {
		this.ej_id = ej_id;
	}
	
	
	
}
