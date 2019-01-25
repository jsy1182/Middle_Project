package game.contoller.roulette;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.List;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.CurrentLoginPerson;
import service.IEventJoinService;
import service.IEventService;
import service.ILalaLandMemberService;
import vo.EventVO;
import vo.Event_joinVO;
import vo.MemberVO;

public class HangmanMain extends Application {

    private static final int APP_W = 900;
    private static final int APP_H = 500;
    private static final Font DEFAULT_FONT = new Font("Courier", 36);

	/**
     * The word to guess
     */
    private SimpleStringProperty word = new SimpleStringProperty();

    /**
     * How many letters left to guess
     */
    private SimpleIntegerProperty lettersToGuess = new SimpleIntegerProperty();
   
    /**
     * Is game playable
     */
    private SimpleBooleanProperty playable = new SimpleBooleanProperty();

    /**
     * List for letters of the word {@link #word}
     * It is backed up by the HBox children list,
     * so changes to this list directly affect the GUI
     */
    private ObservableList<Node> letters;

    /**
     * K - characters [A..Z] and '-'
     * V - javafx.scene.Text representation of K
     */
    private HashMap<Character, Text> alphabet = new HashMap<Character, Text>();

    private HangmanImage hangman = new HangmanImage();
    private WordReader wordReader = new WordReader();
    private Label couponLabel;
    private Label contentLabel1;
    private Label contentLabel2;
    
    /**
     * Event_join을 만들때 쓴 자료
     */
    private IEventJoinService ejservice; // insert를 하기위해 필요
    private IEventService evservice; // 이벤트를 가지고 오려고 필요
    List<EventVO> evlist = null; // 가져온 이벤트 내용를 넣는다
    private MemberVO member = new MemberVO(); // 로그인한 회원정보를 가진다
    private Event_joinVO ej = new Event_joinVO(); // event_join에 대한 내용을 가지고 있다
    String event_id = "ev1"; // 이벤트 아이디
    
    public Parent createContent() {
        HBox rowLetters = new HBox();
        rowLetters.setAlignment(Pos.CENTER);
        letters = rowLetters.getChildren();

        playable.bind(hangman.lives.greaterThan(0).and(lettersToGuess.greaterThan(0)));
        playable.addListener((obs, old, newValue) -> {
            if (!newValue.booleanValue()) {
            	/**
            	 * 이벤트 참가에 대한 내용
            	 * if에서는 행맨의 목숨이 0일경우 패배
            	 * 아닐경우 evlist에 있는 내용과
            	 * 현재 로그인한 회원의 아이디를 비교해서
            	 * ej객체에 회원아이디와 이벤트아이디를 준다
            	 * 
            	 */
            	if(hangman.lives.doubleValue() == 0) {
            		stopGame();
            		alert(null,"패배하셨습니다. 다시 시도해보세요");
            	}else {
            		alert(null,"승리하셨습니다. 쿠폰함에서 쿠폰을\n확인해보세요.");
            		try {
            			couponLabel.setTextFill(Color.RED);
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
							
						}else {
							alert("실패");
						}
					} catch (RemoteException e) {
						e.printStackTrace();
					}
            	}
            }
        });
        Label contentTitle = new Label("게임방법");
        contentTitle.setFont(Font.font("System", FontWeight.BOLD, 30));
        contentLabel1 = new Label("키보드에 알파벳을 입력하세요");
        contentLabel1.setFont(Font.font(20));
        contentLabel2 = new Label("LalaLand의 관련된 행맨입니다");
        contentLabel2.setFont(Font.font(20));
        Label contentLabel3 = new Label("6번 틀리면 게임에서 패배합니다");
        contentLabel3.setFont(Font.font(20));
        Label contentLabel4 = new Label("이기면 30% 할인 쿠폰을 받을수 있습니다");
        contentLabel4.setFont(Font.font(20));
        
        couponLabel = new Label("30% 할인 쿠폰");
        couponLabel.disableProperty().bind(playable);
        couponLabel.setFont(Font.font(30));
        

        // layout
        HBox row1 = new HBox();
        HBox row3 = new HBox();
        row1.setAlignment(Pos.CENTER);
        row3.setAlignment(Pos.CENTER);
        for (int i = 0 ; i < 20; i++) {
            row1.getChildren().add(new Letter(' '));
            row3.getChildren().add(new Letter(' '));
        }

        HBox rowAlphabet = new HBox(5);
        rowAlphabet.setAlignment(Pos.CENTER);
        for (char c = 'A'; c <= 'Z'; c++) {
            Text t = new Text(String.valueOf(c));
            t.setFont(DEFAULT_FONT);
            alphabet.put(c, t);
            rowAlphabet.getChildren().add(t);
        }

        Text hyphen = new Text("-");
        hyphen.setFont(DEFAULT_FONT);
        alphabet.put('-', hyphen);
        rowAlphabet.getChildren().add(hyphen);
        
        VBox colHangman = new VBox(contentTitle,contentLabel1,contentLabel2,
        		contentLabel3,contentLabel4,couponLabel);
        HBox rowHangman = new HBox(10,colHangman, hangman);
        rowHangman.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10);
        // vertical layout
        vBox.getChildren().addAll(row1,rowLetters,
                row3,rowAlphabet,rowHangman);
        return vBox;
    }
    
    public void alert(String header, String msg) {
    	Alert warning = new Alert(AlertType.INFORMATION);
    	
    	warning.setTitle("INFORMATION");
    	warning.setHeaderText(header);
    	warning.setContentText(msg);
    	warning.showAndWait();
    }

    private void stopGame() {
        for (Node n : letters) {
            Letter letter = (Letter) n;
            letter.show();
        }
    }

    private void startGame() {
        for (Text t : alphabet.values()) {
            t.setStrikethrough(false);
            t.setFill(Color.BLACK);
        }

        hangman.reset();
        word.set(wordReader.getRandomWord().toUpperCase());
        lettersToGuess.set(word.length().get());

        letters.clear();
        for (char c : word.get().toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    private static class HangmanImage extends Parent {
        private static final int SPINE_START_X = 100;
        private static final int SPINE_START_Y = 20;
        private static final int SPINE_END_X = SPINE_START_X;
        private static final int SPINE_END_Y = SPINE_START_Y + 50;

        /**
         * How many lives left
         */
        private SimpleIntegerProperty lives = new SimpleIntegerProperty();

        public HangmanImage() {
            Circle head = new Circle(20);
            head.setTranslateX(SPINE_START_X);

            Line spine = new Line();
            spine.setStartX(SPINE_START_X);
            spine.setStartY(SPINE_START_Y);
            spine.setEndX(SPINE_END_X);
            spine.setEndY(SPINE_END_Y);

            Line leftArm = new Line();
            leftArm.setStartX(SPINE_START_X);
            leftArm.setStartY(SPINE_START_Y);
            leftArm.setEndX(SPINE_START_X + 40);
            leftArm.setEndY(SPINE_START_Y + 10);

            Line rightArm = new Line();
            rightArm.setStartX(SPINE_START_X);
            rightArm.setStartY(SPINE_START_Y);
            rightArm.setEndX(SPINE_START_X - 40);
            rightArm.setEndY(SPINE_START_Y + 10);

            Line leftLeg = new Line();
            leftLeg.setStartX(SPINE_END_X);
            leftLeg.setStartY(SPINE_END_Y);
            leftLeg.setEndX(SPINE_END_X + 25);
            leftLeg.setEndY(SPINE_END_Y + 50);

            Line rightLeg = new Line();
            rightLeg.setStartX(SPINE_END_X);
            rightLeg.setStartY(SPINE_END_Y);
            rightLeg.setEndX(SPINE_END_X - 25);
            rightLeg.setEndY(SPINE_END_Y + 50);

            getChildren().addAll(head, spine, leftArm, rightArm, leftLeg, rightLeg);
            lives.set(getChildren().size());
        }

        public void reset() {
            getChildren().forEach(node -> node.setVisible(false));
            lives.set(getChildren().size());
        }

        public void takeAwayLife() {
            for (Node n : getChildren()) {
                if (!n.isVisible()) {
                    n.setVisible(true);
                    lives.set(lives.get() - 1);
                    break;
                }
            }
        }
    }

    private static class Letter extends StackPane {
        private Rectangle bg = new Rectangle(40, 60);
        private Text text;

        public Letter(char letter) {
            bg.setFill(letter == ' ' ? Color.DARKSEAGREEN : Color.WHITE);
            bg.setStroke(Color.BLUE);

            text = new Text(String.valueOf(letter).toUpperCase());
            text.setFont(DEFAULT_FONT);
            text.setVisible(false);

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg, text);
        }

        public void show() {
            RotateTransition rt = new RotateTransition(Duration.seconds(1), bg);
            rt.setAxis(Rotate.Y_AXIS);
            rt.setToAngle(180);
            rt.setOnFinished(event -> text.setVisible(true));
            rt.play();
        }

        public boolean isEqualTo(char other) {
            return text.getText().equals(String.valueOf(other).toUpperCase());
        }
    }
    
    void alert(String msg) {
    	Alert warning = new Alert(AlertType.WARNING);
    	
    	warning.setTitle("오류");
    	warning.setHeaderText(null);
    	warning.setContentText(msg);
    	warning.showAndWait();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getText().isEmpty())
                return;

            char pressed = event.getText().toUpperCase().charAt(0);
            if ((pressed < 'A' || pressed > 'Z') && pressed != '-')
                return;

            if (playable.get()) {
                Text t = alphabet.get(pressed);
                if (t.isStrikethrough())
                    return;

                // mark the letter 'used'
                t.setFill(Color.BLUE);
                t.setStrikethrough(true);

                boolean found = false;

                for (Node n : letters) {
                    Letter letter = (Letter) n;
                    if (letter.isEqualTo(pressed)) {
                        found = true;
                        lettersToGuess.set(lettersToGuess.get() - 1);
                        letter.show();
                    }
                }

                if (!found) {
                    hangman.takeAwayLife();
                }
                
            }
        });
        
        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			ejservice = (IEventJoinService) reg.lookup("eventJoinService");
			evservice = (IEventService) reg.lookup("eventService");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("board service 가져오기 실패");
			e.printStackTrace();
		}
        
        
        
        primaryStage.setResizable(false);
        primaryStage.setWidth(APP_W);
        primaryStage.setHeight(APP_H);
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(scene);
        primaryStage.show();
        startGame();
    }

    public static void main(String[] args) {
        launch(args);
        
    }
}
