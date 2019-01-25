package vo;

import java.io.Serializable;
import java.sql.Date;

public class EventVO implements Serializable{
	private static final long serialVersionUID = -5836000468818644437L;
	
	private String event_id;
	private String event_title;
	private String event_content;
	private float event_disc;
	private Date event_start;
	private Date event_end;
	
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getEvent_title() {
		return event_title;
	}
	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}
	public String getEvent_content() {
		return event_content;
	}
	public void setEvent_content(String event_content) {
		this.event_content = event_content;
	}
	public float getEvent_disc() {
		return event_disc;
	}
	public void setEvent_disc(float event_disc) {
		this.event_disc = event_disc;
	}
	public Date getEvent_start() {
		return event_start;
	}
	public void setEvent_start(Date event_start) {
		this.event_start = event_start;
	}
	public Date getEvent_end() {
		return event_end;
	}
	public void setEvent_end(Date event_end) {
		this.event_end = event_end;
	}
	
	
}
