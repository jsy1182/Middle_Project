package vo;

import java.io.Serializable;

public class EmpVO implements Serializable{
	private static final long serialVersionUID = -7802003660715230071L;
	
	private String emp_id;
	private String emp_pass;
	private String emp_iden;
	private String emp_tel;
	private String emp_bir;
	private String emp_mail;
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_pass() {
		return emp_pass;
	}
	public void setEmp_pass(String emp_pass) {
		this.emp_pass = emp_pass;
	}
	public String getEmp_iden() {
		return emp_iden;
	}
	public void setEmp_iden(String emp_iden) {
		this.emp_iden = emp_iden;
	}
	public String getEmp_tel() {
		return emp_tel;
	}
	public void setEmp_tel(String emp_tel) {
		this.emp_tel = emp_tel;
	}
	public String getEmp_bir() {
		return emp_bir;
	}
	public void setEmp_bir(String emp_bir) {
		this.emp_bir = emp_bir;
	}
	public String getEmp_mail() {
		return emp_mail;
	}
	public void setEmp_mail(String emp_mail) {
		this.emp_mail = emp_mail;
	}
	
	
}
