package main;


import javafx.application.HostServices;
import javafx.scene.media.AudioClip;
import vo.AdminVO;
import vo.EmpVO;
import vo.MemberVO;

public class CurrentLoginPerson {
	public static MemberVO CurrentMember ;
	public static AdminVO CurrentAdmin;
	public static EmpVO CurrentEmp;
	public static HostServices hostServices ;

	private static String url = "/music/Openning Music.mp3";
	
	
	//public static AudioClip note = new AudioClip(getClass().getResource("/music/Openning Music.mp3").toString());
	public static AudioClip note = new AudioClip(CurrentLoginPerson.class.getResource(url).toString());
	
	public CurrentLoginPerson(MemberVO member) {
		CurrentMember = member;
	}
	
	public CurrentLoginPerson(AdminVO admin) {
		CurrentAdmin=admin;
	}
	public CurrentLoginPerson(EmpVO emp) {
		CurrentEmp=emp;
	}


}
