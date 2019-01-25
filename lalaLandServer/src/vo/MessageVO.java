package vo;

import java.io.Serializable;

public class MessageVO implements Serializable{
	private static final long serialVersionUID = 4219601885398146393L;
	
	private String message_id;
	private String message_from;
	private String message_to;
	private String message_date;
	private String message_content;
	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	public String getMessage_from() {
		return message_from;
	}
	public void setMessage_from(String message_from) {
		this.message_from = message_from;
	}
	public String getMessage_to() {
		return message_to;
	}
	public void setMessage_to(String message_to) {
		this.message_to = message_to;
	}
	public String getMessage_date() {
		return message_date;
	}
	public void setMessage_date(String message_date) {
		this.message_date = message_date;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	
	
}
