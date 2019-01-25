package game.contoller.memory;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.CurrentLoginPerson;
import service.IEventJoinService;
import service.IEventService;
import vo.EventVO;
import vo.Event_joinVO;
import vo.MemberVO;

public class MemoryCardGame extends Application {
    private static final int NUM_OF_PAIRS = 8;
    private static final int NUM_PER_ROW = 4;
    
    private Tile selected = null;
    private int clickCount = 2;
    private int correct;
    
    /**
     * Event_join을 만들때 쓴 자료
     */
    private IEventJoinService ejservice; // insert를 하기위해 필요
    private IEventService evservice; // 이벤트를 가지고 오려고 필요
    List<EventVO> evlist = null; // 가져온 이벤트 내용를 넣는다
    private MemberVO member = new MemberVO(); // 로그인한 회원정보를 가진다
    private Event_joinVO ej = new Event_joinVO(); // event_join에 대한 내용을 가지고 있다
    String event_id = "ev2"; // 이벤트 아이디

    private Parent createContent() {
    	Clock timer = new Clock();
        Pane root = new Pane();
        
        root.getChildren().add(timer);
        root.setPrefSize(300, 300);

        char c = 'A';
        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < NUM_OF_PAIRS; i++) {
            tiles.add(new Tile(String.valueOf(c)));
            tiles.add(new Tile(String.valueOf(c)));
            c++;
        }

        Collections.shuffle(tiles);

        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i);
            tile.setTranslateX(50 * (i % NUM_PER_ROW));
            tile.setTranslateY(50 * (i / NUM_PER_ROW));
            root.getChildren().add(tile);
        }

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	 try {
 			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
 			ejservice = (IEventJoinService) reg.lookup("eventJoinService");
 			evservice = (IEventService) reg.lookup("eventService");
 		} catch (RemoteException | NotBoundException e) {
 			System.out.println("board service 가져오기 실패");
 			e.printStackTrace();
 		}
    	
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
    
    private class Clock extends Pane{
    	private Timeline animation;
    	private int tap = 60;
    	private String second = "";
    	Label label = new Label(tap+"");
    	Label colabel = new Label("");
    	Label content = new Label("60초 안에 낱말에");
    	Label content1 = new Label("짝을 맞춰주세요");
    	
    	private Clock() {
    		label.setTranslateX(250);
    		label.setTranslateY(100);
    		
    		colabel.setTranslateX(130);
    		colabel.setTranslateY(250);
    		colabel.setFont(Font.font(25));
    		
    		content.setTranslateX(0);
    		content.setTranslateY(230);
    		content.setFont(Font.font(15));
    		
    		content1.setTranslateX(0);
    		content1.setTranslateY(250);
    		content1.setFont(Font.font(15));
    		
    		
    		getChildren().addAll(label,content,content1,colabel);
    		animation = new Timeline(new KeyFrame(Duration.seconds(1), e->{
	    		try {
					timelabel();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}		
			}));
    		animation.setCycleCount(Timeline.INDEFINITE);
    		animation.play();
    	}
    	
    	private void timelabel() throws RemoteException {
    		if(tap > 0) {
    			tap--;
    		}
    		
    		if(correct == NUM_OF_PAIRS) {
            	animation.stop();
            	if(second.equals("0")) {
            		label.setText("패배하셨습니다"); 
            		label.setFont(Font.font(15));
            	}else {
            		label.setTranslateX(210);
            		label.setTranslateY(100);
            		label.setText("승리하셨습니다\n쿠폰함을 확인\n해주세요");
            		win();
            	}
            }

    		second = tap + "";
    		label.setText(second);
    	}
		
		public void win() throws RemoteException {
			evlist = evservice.allEvent();
			member = CurrentLoginPerson.CurrentMember;
			
			for (int i = 0; i < evlist.size(); i++) {
				if(evlist.get(i).getEvent_id().equals(event_id)) {
					ej.setEvent_id(evlist.get(i).getEvent_id());
					ej.setMem_id(member.getMem_id());
				}
			}
			
			/**
			 * insert를 사용해 자료를 넣어준다
			 * 0보다 크면 성공 아니면 실패
			 */
			int ejcount = ejservice.insertEventJoin(ej);
			if(ejcount > 0) {
				System.out.println("성공");
			}else {
				alert("실패");
			}
			colabel.setText("20% 할인쿠폰");
		}

    }

    public void alert(String header, String msg) {
    	Alert warning = new Alert(AlertType.WARNING);
    	
    	warning.setTitle("오류");
    	warning.setHeaderText(header);
    	warning.setContentText(msg);
    	warning.showAndWait();
    }
    
    private class Tile extends StackPane {
        private Text text = new Text();

        public Tile(String value) {
            Rectangle border = new Rectangle(50, 50);
            border.setFill(null);
            border.setStroke(Color.BLACK);

            text.setText(value);
            text.setFont(Font.font(30));

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);

            setOnMouseClicked(this::handleMouseClick);
            close();
        }
        
        

        public void handleMouseClick(MouseEvent event) {
            if (isOpen() || clickCount == 0) {
            	return;
            }

            clickCount--;

            if (selected == null) {
                selected = this;
                open(() -> {});
            }
            else {
                open(() -> {
                    if (!hasSameValue(selected)) {
                        selected.close();
                        this.close();
                    }else {
                    	correct++;
                    }

                    selected = null;
                    clickCount = 2;
                    
                });
                
            }
        }

        public boolean isOpen() {
            return text.getOpacity() == 1;
        }

        public void open(Runnable action) {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
            ft.setToValue(1);
            ft.setOnFinished(e -> action.run());
            ft.play();
        }

        public void close() {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
            ft.setToValue(0);
            ft.play();
        }

        public boolean hasSameValue(Tile another) {
        	
            return text.getText().equals(another.text.getText());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    void alert(String msg) {
    	Alert warning = new Alert(AlertType.WARNING);
    	
    	warning.setTitle("오류");
    	warning.setHeaderText(null);
    	warning.setContentText(msg);
    	warning.showAndWait();
    }
}