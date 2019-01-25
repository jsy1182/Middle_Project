package vo;

import java.io.Serializable;

public class VoiceVO implements Serializable{
	private static final long serialVersionUID = -3946699006582699852L;
	
	private String voice_id;
	private String voice_date;
	private String voice_content;
	public String getVoice_id() {
		return voice_id;
	}
	public void setVoice_id(String voice_id) {
		this.voice_id = voice_id;
	}
	public String getVoice_date() {
		return voice_date;
	}
	public void setVoice_date(String voice_date) {
		this.voice_date = voice_date;
	}
	public String getVoice_content() {
		return voice_content;
	}
	public void setVoice_content(String voice_content) {
		this.voice_content = voice_content;
	}

	

}
