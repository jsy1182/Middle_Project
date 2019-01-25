package event.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import eventAdmin.controller.EventAdminAddController;
import eventAdmin.controller.EventAdminEditController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.IEventService;
import vo.EventVO;

public class EventAdminMainController {
	private IEventService service;
	List<EventVO> eventList;
	List<String> elist;

	// 내용을 쓸때 쓸 변수들
	public String econtent;
	public String start;
	public String end;
	public float discount;

	public EventVO vo;
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ListView<String> listview;

	@FXML
	private TextArea content;

	@FXML
	private Button btnEventAdd;

	@FXML
	private Button btnEventEnd;

	@FXML
	private Button btnEventEdit;

	@FXML
	void eventAdd(ActionEvent event) throws RemoteException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/event/fxml/EventAdd.fxml"));
			Parent root = loader.load();
			Stage stage = new Stage();
			
			EventAdminAddController evtAdminAdd = loader.getController();
			// evtAdminAdd.setTa(content);
			evtAdminAdd.setAdd(this);
			
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.DECORATED);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void showEdit(EventVO eventVo) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/event/fxml/EventEdit.fxml"));
			Parent root = loader.load();
			EventAdminEditController evtAdminEdit = loader.getController();
			evtAdminEdit.setEventVo(eventVo);
			evtAdminEdit.setTa(content);
			
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.DECORATED);
			stage.setScene(new Scene(root));
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void listShow(MouseEvent event) {
		String title = null;
		EventVO eventVo = null;
		if (event.getClickCount() == 2) {
			title = listview.getSelectionModel().getSelectedItem();
			for (int i = 0; i < eventList.size(); i++) {
				if (eventList.get(i).getEvent_title() == title) {
					eventVo = eventList.get(i);
				}
			}
			if (eventVo != null) {
				showEdit(eventVo);
			}
		} else if (event.getClickCount() == 1) {
			title = listview.getSelectionModel().getSelectedItem();
			for (int i = 0; i < eventList.size(); i++) {
				if (eventList.get(i).getEvent_title() == title) {
					title = eventList.get(i).getEvent_title();
					econtent = eventList.get(i).getEvent_content();
					//System.out.println("--->" + setDate(eventList.get(i).getEvent_start()));
					
					start = new SimpleDateFormat("YY-MM-dd").format(setDate(eventList.get(i).getEvent_start()));
					end = new SimpleDateFormat("YY-MM-dd").format(setDate(eventList.get(i).getEvent_end()));
					discount = eventList.get(i).getEvent_disc();
				}
			}

			content.setText("제목 : " + title + "\n내용 : " + econtent + "\n할인률 : " + discount + "\n이벤트 시작일 : " + start
						+ "\n이벤트 종료일 : " + end);
			
		}
	}
	
	public java.util.Date setDate(Date date){
		java.util.Date utilDate = new java.util.Date(date.getTime());  	
		return utilDate;
	}
	
	@FXML
	void initialize() throws RemoteException, ParseException {
		assert listview != null : "fx:id=\"listview\" was not injected: check your FXML file 'eventScene2.fxml'.";
		assert content != null : "fx:id=\"content\" was not injected: check your FXML file 'eventScene2.fxml'.";
		assert btnEventAdd != null : "fx:id=\"btnEventAdd\" was not injected: check your FXML file 'eventScene2.fxml'.";
		assert btnEventEnd != null : "fx:id=\"btnEventEnd\" was not injected: check your FXML file 'eventScene2.fxml'.";
		assert btnEventEdit != null : "fx:id=\"btnEventEdit\" was not injected: check your FXML file 'eventScene2.fxml'.";

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IEventService) reg.lookup("eventService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("event service 가져오기 실패");
			e.printStackTrace();
		}
		
		showlistView();
		content.setWrapText(true);
	}
	
	public void showlistView() throws RemoteException, ParseException {
		eventList = service.allEvent();
		ObservableList<String> list = FXCollections.observableArrayList();
		content.setEditable(false);
				
		SimpleDateFormat form = new SimpleDateFormat("YY-MM-dd"); // 날짜를 18-11-23같은 모습으로 만들어준다
		Date today = new Date(); // 현재 날짜
		String todayStr = form.format(today); // 현재 날짜를 받는 문자열
		today = form.parse(todayStr); // 문자가 되어있는 현재 날짜를 Date형으로 만들어 준다
		
		for (int i = 0; i < eventList.size(); i++) {
			int compare = today.compareTo(eventList.get(i).getEvent_end());
			if(compare > 0) {
				list.remove(eventList.get(i).getEvent_title());
				eventList.get(i).setEvent_disc(0.0f);
				service.updateEvent(eventList.get(i));
			}else if(compare < 0){
				list.add(eventList.get(i).getEvent_title());
			}else {
				list.remove(eventList.get(i).getEvent_title());
				eventList.get(i).setEvent_disc(0.0f);
				service.updateEvent(eventList.get(i));
			}
		}
		
		listview.setItems(list);
	}

}
