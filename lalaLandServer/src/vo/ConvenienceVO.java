package vo;

import java.io.Serializable;

public class ConvenienceVO implements Serializable{
	private static final long serialVersionUID = 3692426020578130128L;
	
	private String con_id;
	private String con_iden;
	private String con_pos;
	private String con_contenct;
	private String con_free;
	private String con_tel;
	private String con_title;
	public String getCon_title() {
		return con_title;
	}
	public void setCon_title(String con_title) {
		this.con_title = con_title;
	}
	public String getCon_id() {
		return con_id;
	}
	public void setCon_id(String con_id) {
		this.con_id = con_id;
	}
	public String getCon_iden() {
		return con_iden;
	}
	public void setCon_iden(String con_iden) {
		this.con_iden = con_iden;
	}
	public String getCon_pos() {
		return con_pos;
	}
	public void setCon_pos(String con_pos) {
		this.con_pos = con_pos;
	}
	public String getCon_contenct() {
		return con_contenct;
	}
	public void setCon_contenct(String con_contenct) {
		this.con_contenct = con_contenct;
	}
	public String getCon_free() {
		return con_free;
	}
	public void setCon_free(String con_free) {
		this.con_free = con_free;
	}
	public String getCon_tel() {
		return con_tel;
	}
	public void setCon_tel(String con_tel) {
		this.con_tel = con_tel;
	}
	
	
}
