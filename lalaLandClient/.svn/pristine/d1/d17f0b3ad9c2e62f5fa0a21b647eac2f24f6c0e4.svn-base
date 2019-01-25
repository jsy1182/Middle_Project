package Item.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.mail.EmailException;

import controller.MailItemBuy;
import controller.PDFItemBuy;
import controller.ReceiptController;
import javafx.collections.ObservableList;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.CurrentLoginPerson;
import service.ILalaLandItemService;
import vo.ItemVO;
import vo.Item_buyVO;
import vo.MemberVO;

public class ItemPayMentController {
///사용자 --- 아이템 구매 --결제
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ImageView image;

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
    
    public Item_buyVO itemBuy= new Item_buyVO();
    
    public ILalaLandItemService service;
    
    String bank1="농협";
    
    ReceiptController receiptController;
    
    //ObservableList<ItemVO> item;
    public ItemVO item=new ItemVO();//고객이 구매한 아이템에 대한정보
    public MemberVO member=CurrentLoginPerson.CurrentMember;//구매를 한 고객의 정보
    
    
    
    /**
     * 구매 취소
     * 고객 아이템 조회 창으로 감
     * @param event
     * @author 류주완
     * @since 2018-11-14
     */
    @FXML
    void clickBtnCancel(ActionEvent event) {	
    	alert("구매를 취소합니다.", "상품목록 창으로 이동합니다.");
    	Stage st = (Stage) emailLb.getScene().getWindow();
    	st.close();
//    	try {
//
//			Stage st;
//			st = (Stage) emailLb.getScene().getWindow();
//
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ItemCustomerMain.fxml"));
//			Parent addRoot = loader.load();
//
//			Scene addScene = new Scene(addRoot);
//			st.setScene(addScene);
//			st.show();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
    	
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
    /**
     * 상품을 결제 
     * (구현 할 수 있을 지 미지수)
     * @param event
     * @throws RemoteException 
     * @throws EmailException 
     */
    @FXML
    void clickBtnPayment(ActionEvent event) throws RemoteException, EmailException {
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
    	
    	
    	
    	if(txFd1.getText().trim().isEmpty() || txFd2.getText().trim().isEmpty() || txFd3.getText().trim().isEmpty() ||txFd4.getText().trim().isEmpty()) {
    		alert("카드번호가 입력되지 않았습니다.","카드번호를 확인하세요.");
    		
    		return;
    	}else if(txFd5.getText().trim().isEmpty() || txFd6.getText().trim().isEmpty()) {
    		alert("유효기간이 입력되지않았습니다.","유효기간을 확인하세요");
    		return;
    	}else if(txFd1.getText().trim().length()!=4 || txFd2.getText().trim().length()!=4 ||  txFd3.getText().trim().length()!=4 ||txFd4.getText().trim().length()!=4) {
    		alert("카드번호는 4 자리로 입력해 주세요","카드번호 길이 제한");
    		return;
    	}
    	
    	alert("상품을 구매합니다.", "결제");
    	//----결제---
    	
    	
    	
    	itemBuy.setItem_id(item.getItem_id());//아이템 id
    	itemBuy.setMem_id(member.getMem_id());//고객의 id
    	itemBuy.setItemBuy_refend("F");//환불여부의 초기 값은 F이다.
    	itemBuy.setItemBuy_sales(item.getItem_price());//아이템의 가격

    	service.insertItemBuy(itemBuy);
    	
    	//gotoBuyScene();
    	
    	
    	 List<Item_buyVO> itemBuy2=service.selectItemBuyAll();
    	 Item_buyVO buy=itemBuy2.get(0);//가장에 구매한 내역 즉 방금전에 구매한 내역 저장
    	 
    	 
    	
    	
    	PDFItemBuy pdf= new PDFItemBuy(buy);
    	pdf.pdfPrint();
    	
    	MailItemBuy mail = new MailItemBuy(buy,member.getMem_mail());
    	mail.sendPDFMail();
    	alert("구매가 완료되었습니다.", "가입하신 이메일로 영수증이 발송 되었습니다.");
    	Stage st = (Stage) emailLb.getScene().getWindow();
    	st.close();
    	
    	/*try {

			Stage st;
			st = (Stage) emailLb.getScene().getWindow();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item/fxml/ItemCustomerMain.fxml"));
			Parent addRoot = loader.load();

			Scene addScene = new Scene(addRoot);
			st.setScene(addScene);
			st.show();

		} catch (Exception e) {
			e.printStackTrace();
		}*/
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
    	assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert btnPayment != null : "fx:id=\"btnPayment\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert radio1 != null : "fx:id=\"radio1\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert bank != null : "fx:id=\"bank\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert radio2 != null : "fx:id=\"radio2\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert radio3 != null : "fx:id=\"radio3\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert radio4 != null : "fx:id=\"radio4\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert txFd1 != null : "fx:id=\"txFd1\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert cardNum != null : "fx:id=\"cardNum\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert txFd3 != null : "fx:id=\"txFd3\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert txFd4 != null : "fx:id=\"txFd4\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert txFd2 != null : "fx:id=\"txFd2\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert cardNum2 != null : "fx:id=\"cardNum2\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert txFd5 != null : "fx:id=\"txFd5\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert cardNum3 != null : "fx:id=\"cardNum3\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert txFd6 != null : "fx:id=\"txFd6\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert cardNum4 != null : "fx:id=\"cardNum4\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert prodLabel != null : "fx:id=\"prodLabel\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert moneyLabel != null : "fx:id=\"moneyLabel\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert emailLb != null : "fx:id=\"emailLb\" was not injected: check your FXML file 'ItemPayMent.fxml'.";
        assert emailTxfd != null : "fx:id=\"emailTxfd\" was not injected: check your FXML file 'ItemPayMent.fxml'.";

        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandItemService) reg.lookup("itemService");
         } catch (RemoteException | NotBoundException e) {
            System.out.println("실패");
            e.printStackTrace();
         }
        emailTxfd.setText(member.getMem_mail());
        
        

    }
    
    
    public void alert(String header,String msg) {
        Alert alert = new Alert(AlertType.WARNING);
        
        alert.setTitle("WARNING");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
        
     }
	public void setItemId(ItemVO std) {
		item=std;
		
		
	}
	
	 public void walert(String header,String msg) {
			Alert walert=new Alert(AlertType.WARNING);
			
			walert.setTitle("등록실패");
			walert.setHeaderText(header);
			walert.setContentText(msg);
			
			walert.show();
		}//end of walert
	/*public void setMemId(MemberVO member) {
		this.member=member;
		
	}*/
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
				//receiptController.setBuyVO(buyVO);
				//receiptController.setMemberVO(memVO,emailTxfd.getText());
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
	 
}
