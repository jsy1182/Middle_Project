package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CalculatorController {
	String inputNum="";
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btn5;

    @FXML
    private Button btn4;

    @FXML
    private Button btn6;

    @FXML
    private Button btn2;

    @FXML
    private Button btn1;

    @FXML
    private Button btn3;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnClear;

    @FXML
    private Button btn0;

    @FXML
    private TextField txtresult;
    
    private GroupBuyController gbc;
    

	public void setGbc(GroupBuyController gbc) {
		this.gbc = gbc;
	}

	@FXML
    void clickbtnOk(ActionEvent event) {
    	if(!inputNum.equals("")) {
    		if(Integer.parseInt(inputNum)<10) {
    			gbc.setLabel2("10");
    			Stage close=(Stage) btn1.getScene().getWindow();
    			close.close();
    			return;
    		}
    		
    		if(Integer.parseInt(inputNum)>20) {
    			gbc.setLabel2("20");
    			Stage close=(Stage) btn1.getScene().getWindow();
    			close.close();
    			return;
    		}
			//화면전환부분
    		gbc.setLabel2(txtresult.getText());
			Stage close=(Stage) btn1.getScene().getWindow();
			close.close();
    	}else {
    		inputNum="10";
    		showResult();
    		return;
    	}
    }

    @FXML
    void clkbtn0(ActionEvent event) {
    	if(inputNum.equals("")) {
    		return;
    	}
    	inputNum+=0;
    	showResult();
    }

    @FXML
    void clkbtn1(ActionEvent event) {
    	inputNum+=1;
    	showResult();
    }

    @FXML
    void clkbtn2(ActionEvent event) {
    	inputNum+=2;
    	showResult();
    }

    @FXML
    void clkbtn3(ActionEvent event) {
    	inputNum+=3;
    	showResult();
    }

    @FXML
    void clkbtn4(ActionEvent event) {
    	inputNum+=4;
    	showResult();
    }

    @FXML
    void clkbtn5(ActionEvent event) {
    	inputNum+=5;
    	showResult();
    }

    @FXML
    void clkbtn6(ActionEvent event) {
    	inputNum+=6;
    	showResult();
    }

    @FXML
    void clkbtn7(ActionEvent event) {
    	inputNum+=7;
    	showResult();
    }

    @FXML
    void clkbtn8(ActionEvent event) {
    	inputNum+=8;
    	showResult();
    }

    @FXML
    void clkbtn9(ActionEvent event) {
    	inputNum+=9;
    	showResult();
    }

    @FXML
    void clkbtnClear(ActionEvent event) {
    	inputNum="";
    	showResult();
    }

    @FXML
    void initialize() {
        assert btn7 != null : "fx:id=\"btn7\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert btn8 != null : "fx:id=\"btn8\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert btn9 != null : "fx:id=\"btn9\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert btn5 != null : "fx:id=\"btn5\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert btn4 != null : "fx:id=\"btn4\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert btn6 != null : "fx:id=\"btn6\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert btn2 != null : "fx:id=\"btn2\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert btn3 != null : "fx:id=\"btn3\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert btn0 != null : "fx:id=\"btn0\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert txtresult != null : "fx:id=\"txtresult\" was not injected: check your FXML file 'Calculator.fxml'.";
        
        txtresult.setEditable(false);
        
    }
    public void setLabel() {
    	txtresult.setEditable(false);
    }
    public void showResult() {
    	txtresult.setText(inputNum);
    }
    
}
