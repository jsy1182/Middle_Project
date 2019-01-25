package controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lowagie.toolbox.plugins.Txt2Pdf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.ILalaLandBuyService;
import vo.Annual_memberVO;
import vo.BuyVO;
import vo.EventVO;
import vo.MemberVO;

public class PayMentController {
	ILalaLandBuyService service;
	BuyVO buyVO;
	Annual_memberVO annualVO;
	ReceiptController receiptController;
	MemberVO memVO;
	String bank1="농협";
	EventVO evo;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnPayment;

    @FXML
    private RadioButton radio1;

    @FXML
    private ToggleGroup bank;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio3;

    @FXML
    private RadioButton radio4;

    @FXML
    private TextField txFd1;

    @FXML
    private Label cardNum;

    @FXML
    private TextField txFd3;

    @FXML
    private TextField txFd4;

    @FXML
    private TextField txFd2;

    @FXML
    private Label cardNum2;

    @FXML
    private TextField txFd5;

    @FXML
    private Label cardNum3;

    @FXML
    private TextField txFd6;

    @FXML
    private Label cardNum4;

    @FXML
    private Label prodLabel;

    @FXML
    private Label moneyLabel;

    @FXML
    private Label emailLb;

    @FXML
    private TextField emailTxfd;
    
    @FXML
    private Label discLabel;

    @FXML
    void clickBtnCancel(ActionEvent event) {
    	Stage close=(Stage) prodLabel.getScene().getWindow();
		close.close();
    }
    /**
     * 11-24추가
     * @param event
     */
    @FXML
    void pressTxfd1(KeyEvent event) {
    	if(txFd1.getText().length()>3) {
    		txFd1.setEditable(false);
    		txFd2.requestFocus();
    	}
    }

    @FXML
    void pressTxfd2(KeyEvent event) {
    	if(txFd2.getText().length()>3) {
    		txFd2.setEditable(false);
    		txFd3.requestFocus();
    	}
    }

    @FXML
    void pressTxfd3(KeyEvent event) {
    	if(txFd3.getText().length()>3) {
    		txFd3.setEditable(false);
    		txFd4.requestFocus();
    	}
    }

    @FXML
    void pressTxfd4(KeyEvent event) {
    	if(txFd4.getText().length()>3) {
    		txFd4.setEditable(false);
    		txFd5.requestFocus();
    	}
    }

    @FXML
    void pressTxfd5(KeyEvent event) {
    	if(txFd5.getText().length()>3) {
    		txFd5.setEditable(false);
    		txFd6.requestFocus();
    	}
    }

    @FXML
    void pressTxfd6(KeyEvent event) {
    	if(txFd6.getText().length()>1) {
    		txFd6.setEditable(false);
    	}
    }
    
    @FXML
    void clickBtnPayment(ActionEvent event) {
    	Pattern p1 = Pattern.compile("(^[0-9]{4}$)");
    	Pattern p2 = Pattern.compile("^(0?[1-9]|1[012])$");
    	
    	Matcher m1 = p1.matcher(txFd1.getText());
    	Matcher m2 = p1.matcher(txFd2.getText());
    	Matcher m3 = p1.matcher(txFd3.getText());
    	Matcher m4 = p1.matcher(txFd4.getText());
    	
    	if(!(m1.find() && m2.find() && m3.find() && m4.find())) {
    		walert("입력오류", "카드번호를 다시 입력해주세요");
    		txFd1.clear();
    		txFd2.clear();
    		txFd3.clear();
    		txFd4.clear();
    		txFd1.setEditable(true);
    		txFd2.setEditable(true);
    		txFd3.setEditable(true);
    		txFd4.setEditable(true);
    		return;
    	}
    	SimpleDateFormat format=new SimpleDateFormat("YYYY");
		Date date=new Date();
		String dateformat=format.format(date);
		int i=Integer.parseInt(dateformat);
    	int j=Integer.parseInt(txFd5.getText());
    	if(j<=i) {
    		walert("입력오류", "유효일자를 다시 입력해주세요");
    		txFd5.clear();
    		txFd6.clear();
    		txFd5.setEditable(true);
    		txFd6.setEditable(true);
    		return;
    	}
		
    	Matcher m5=p1.matcher(txFd5.getText());
    	Matcher m6=p2.matcher(txFd6.getText());
    	if(!m5.find()||!m6.find()) {
    		walert("입력오류", "유효일자를 다시 입력해주세요");
    		txFd5.clear();
    		txFd6.clear();
    		txFd5.setEditable(true);
    		txFd6.setEditable(true);
    		return;
    	}
    	
    	
    	try {
    		/**
    		 * 11-24추가
    		 */
    		if(buyVO.getTicket_id().equals("tc004")||buyVO.getTicket_id().equals("tc005")||buyVO.getTicket_id().equals("tc006")) {
    			buyVO.setEj_id(null);
    		}
			int chk=service.insertBuy(buyVO);
			if(chk==1) {
				if(buyVO.getTicket_id().equals("tc004")||buyVO.getTicket_id().equals("tc005")||buyVO.getTicket_id().equals("tc006")) {
					int chk2=service.checkAnnual2(memVO.getMem_id());
					if(chk2==0) {
						int update=service.updateAnnual(annualVO);
						if(update>0) {
							try {
								Parent receipt;
								FXMLLoader loader=new FXMLLoader(
										getClass().getResource("/buy/Receipt.fxml")
										);
								receipt=loader.load();
								Stage buyStage=(Stage) btnPayment.getScene().getWindow();
								
								Scene scene=new Scene(receipt);
								
								receiptController=loader.getController();
								receiptController.setBuyVO(buyVO);
								receiptController.setAnnualVO(annualVO);
								receiptController.setMemberVO(memVO,emailTxfd.getText());
								receiptController.setBank(bank1);
								receiptController.setLabel();
								buyStage.setTitle("영수증 출력화면");
								buyStage.setScene(scene);
								buyStage.show();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return;
						}else {
							walert("등록실패","등록에 실패했습니다.(연간회원)");
							return;
						}
					}
					int chk1=service.insertAnnual(annualVO);
					if(chk1==1) {
						try {
							Parent receipt;
							FXMLLoader loader=new FXMLLoader(
									getClass().getResource("/buy/Receipt.fxml")
									);
							receipt=loader.load();
							Stage buyStage=(Stage) btnPayment.getScene().getWindow();
							
							Scene scene=new Scene(receipt);
							
							receiptController=loader.getController();
							receiptController.setBuyVO(buyVO);
							receiptController.setAnnualVO(annualVO);
							receiptController.setMemberVO(memVO,emailTxfd.getText());
							receiptController.setBank(bank1);
							receiptController.setLabel();
							buyStage.setTitle("영수증 출력화면");
							buyStage.setScene(scene);
							buyStage.show();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						walert("등록실패","등록에 실패했습니다.(연간회원)");
						return;
					}
				}else {	//연간구매가 아니면
					gotoBuyScene();
				}
			}else {
				walert("등록실패","등록에 실패했습니다.(구매)");
				return;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void clickRadio1(ActionEvent event) {
    	bank1="NH농협";
    }

    @FXML
    void clickRadio2(ActionEvent event) {
    	bank1="KB국민";
    }

    @FXML
    void clickRadio3(ActionEvent event) {
    	bank1="신한은행";
    }

    @FXML
    void clickRadio4(ActionEvent event) {
    	bank1="신협";
    }

    @FXML
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'payment.fxml'.";
        assert btnPayment != null : "fx:id=\"btnPayment\" was not injected: check your FXML file 'payment.fxml'.";
        assert radio1 != null : "fx:id=\"radio1\" was not injected: check your FXML file 'payment.fxml'.";
        assert bank1 != null : "fx:id=\"bank\" was not injected: check your FXML file 'payment.fxml'.";
        assert radio2 != null : "fx:id=\"radio2\" was not injected: check your FXML file 'payment.fxml'.";
        assert radio3 != null : "fx:id=\"radio3\" was not injected: check your FXML file 'payment.fxml'.";
        assert radio4 != null : "fx:id=\"radio4\" was not injected: check your FXML file 'payment.fxml'.";
        assert txFd1 != null : "fx:id=\"txFd1\" was not injected: check your FXML file 'payment.fxml'.";
        assert cardNum != null : "fx:id=\"cardNum\" was not injected: check your FXML file 'payment.fxml'.";
        assert txFd3 != null : "fx:id=\"txFd3\" was not injected: check your FXML file 'payment.fxml'.";
        assert txFd4 != null : "fx:id=\"txFd4\" was not injected: check your FXML file 'payment.fxml'.";
        assert txFd2 != null : "fx:id=\"txFd2\" was not injected: check your FXML file 'payment.fxml'.";
        assert cardNum2 != null : "fx:id=\"cardNum2\" was not injected: check your FXML file 'payment.fxml'.";
        assert txFd5 != null : "fx:id=\"txFd5\" was not injected: check your FXML file 'payment.fxml'.";
        assert cardNum3 != null : "fx:id=\"cardNum3\" was not injected: check your FXML file 'payment.fxml'.";
        assert txFd6 != null : "fx:id=\"txFd6\" was not injected: check your FXML file 'payment.fxml'.";
        assert cardNum4 != null : "fx:id=\"cardNum4\" was not injected: check your FXML file 'payment.fxml'.";
        assert prodLabel != null : "fx:id=\"prodLabel\" was not injected: check your FXML file 'payment.fxml'.";
        assert moneyLabel != null : "fx:id=\"moneyLabel\" was not injected: check your FXML file 'payment.fxml'.";
        assert emailLb != null : "fx:id=\"emailLb\" was not injected: check your FXML file 'payment.fxml'.";
        assert emailTxfd != null : "fx:id=\"emailTxfd\" was not injected: check your FXML file 'payment.fxml'.";
        assert discLabel != null : "fx:id=\"discLabel\" was not injected: check your FXML file 'payment.fxml'.";
        
        try {
			Registry reg=LocateRegistry.getRegistry("localhost", 1088);
			service=(ILalaLandBuyService) reg.lookup("buy");
		} catch (RemoteException e) {
            System.out.println("buy service 가져오기 실패");
            e.printStackTrace();
         }catch (NotBoundException ee) {
        	 System.out.println("buy service 가져오기 실패");
             ee.printStackTrace();
		}
        
    }
    
    public void setService(ILalaLandBuyService service) {
    	this.service=service;
    }
    public void setBuyVO(BuyVO buyVO) {
    	this.buyVO=buyVO;
    	try {
    		String ej_id=buyVO.getEj_id();
    		if(ej_id!=null) {
    			evo=service.getEventwithEJID(this.buyVO.getEj_id());
    			discLabel.setText(Math.round(evo.getEvent_disc()*1000)/10f+"%");
    			if(buyVO.getTicket_id().equals("tc004")||buyVO.getTicket_id().equals("tc005")||buyVO.getTicket_id().equals("tc006")) {
    				discLabel.setText("적용X");
    			}
    		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void setAnnualVO(Annual_memberVO annualVO) {
    	this.annualVO=annualVO;
    }
    public void setMemVO(MemberVO memVO) {
    	this.memVO=memVO;
    }
    public void gotoMainPage() {
    	try {
    		FXMLLoader loader=new FXMLLoader(
    				getClass().getResource("/UI/mainscene.fxml")
    				);
    		Parent buy;
			buy=loader.load();
			Stage buyStage=(Stage) btnPayment.getScene().getWindow();
			
			Scene scene=new Scene(buy);
			buyStage.setTitle("구매를 누르면 갈화면");
			buyStage.setScene(scene);
			buyStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    			
    }//end of gotoMainPage
    
    public void walert(String header,String msg) {
		Alert walert=new Alert(AlertType.WARNING);
		
		walert.setTitle("등록실패");
		walert.setHeaderText(header);
		walert.setContentText(msg);
		
		walert.show();
	}//end of walert
    public void gotoBuyScene() {
    	String cardNum=txFd1.getText()+" - "+txFd2.getText()+" - "+txFd3.getText()+" - "+txFd4.getText();
    	String expiry=txFd5.getText()+"년 "+txFd6.getText()+"월";
    	
    	try {
			Parent receipt;
			FXMLLoader loader=new FXMLLoader(
					getClass().getResource("/buy/Receipt.fxml")
					);
			receipt=loader.load();
			Stage buyStage=(Stage) btnPayment.getScene().getWindow();
			
			Scene scene=new Scene(receipt);
			
			receiptController=loader.getController();
			receiptController.setBuyVO(buyVO);
			receiptController.setMemberVO(memVO,emailTxfd.getText());
			receiptController.setCardNum(cardNum);
			receiptController.setExpiry(expiry);
			receiptController.setBank(bank1);
			receiptController.setLabel();
			buyStage.setTitle("영수증 출력화면");
			buyStage.setScene(scene);
			buyStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void setLabel() {
    	String ticketName="";
    	if(buyVO.getTicket_id().equals("tc001")) {
    		ticketName="소인 티켓";
    	}else if(buyVO.getTicket_id().equals("tc002")) {
    		ticketName="청소년 티켓";
    	}else if(buyVO.getTicket_id().equals("tc003")) {
    		ticketName="성인 티켓";
    	}else if(buyVO.getTicket_id().equals("tc004")) {
    		ticketName="연간 소인 티켓";
    	}else if(buyVO.getTicket_id().equals("tc005")) {
    		ticketName="연간 청소년 티켓";
    	}else if(buyVO.getTicket_id().equals("tc006")) {
    		ticketName="연간 성인 티켓";
    	}else if(buyVO.getTicket_id().equals("tc007")) {
    		ticketName="단체 구매 티켓";
    	}
    	prodLabel.setText(ticketName);
    	moneyLabel.setText(buyVO.getSales()+"원");
    	emailTxfd.setText(memVO.getMem_mail());
    	final Font font3 = Font.loadFont(getClass().getResourceAsStream("/font/THELeft.ttf"), 15);
        prodLabel.setFont(font3);
        moneyLabel.setFont(font3);
        btnPayment.setFont(font3);
        btnCancel.setFont(font3);
    	//emailLb.setText(""); 멤버아이디로 멤버의 이메일을 넣어야
    }//end of setLabel
    
}
