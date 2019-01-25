package wise_saying;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.sun.mail.handlers.text_html;
import com.sun.media.ui.ToolTip;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import service.ILalaLandBuyService;
import service.ILalaLandItemService;
import service.ILalaLandMemberService;
import vo.BuyVO;

public class wiseSayingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label textwise;
    
    @FXML
    private BarChart<String, Number> chart;
    
    @FXML
    private Label label_1;

    @FXML
    private Label label_2;

    
    private ILalaLandMemberService service;
    private ILalaLandBuyService service2;
    
    int num1=0;
	int num2=0;
	int num3=0;
	int num4=0;
	int num5=0;
	int num6=0;
	List<BuyVO> list;
	
    @FXML
    private Label text;

    @FXML
    private Label text2;
    @FXML
    void setText1(MouseEvent event) {
    	//text.setVisible(true);
    }

    @FXML
    void setText2(MouseEvent event) {
    	//text.setVisible(false);
    }

    @FXML
    void setText3(MouseEvent event) {
    	//text2.setVisible(true);
    }

    @FXML
    void setText4(MouseEvent event) {
    	//text2.setVisible(false);
    }

    @FXML
    void initialize() throws RemoteException {
        assert textwise != null : "fx:id=\"textwise\" was not injected: check your FXML file 'wiseSaying.fxml'.";
        assert label_1 != null : "fx:id=\"label_1\" was not injected: check your FXML file 'wiseSaying.fxml'.";
        assert label_2 != null : "fx:id=\"label_2\" was not injected: check your FXML file 'wiseSaying.fxml'.";

        
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1088);
            service = (ILalaLandMemberService) reg.lookup("memberService");
            service2 = (ILalaLandBuyService) reg.lookup("buy");
            list=service2.getAllbuyForChart();
         } catch (RemoteException | NotBoundException e) {
            System.out.println("실패");
            e.printStackTrace();
         }
        
        final Font font = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 25);
        final Font font2 = Font.loadFont(getClass().getResourceAsStream("/font/Typo_SsangmunDongB.ttf"), 15);
		label_1.setFont(font);
		label_2.setFont(font);
		textwise.setFont(font2);
 
        String count = (int)(Math.random()*96+1)+"";

        String content=service.getWiseContent(count);
        
        	String content2="";
        	 for(int i=0;i<content.length();i++) {
        		 if((content.charAt(i)+"").equals("\n")) {
        			 
        		 }else {
        			 content2+=content.charAt(i); 
        		 }
             	if(i%23==0) {
             		content2+="\n";
             	}
             }
        	 textwise.setText(content2);
      
        
        setData();
        setChart();
  
    }
    
    public void setChart() {
    	/*XYChart.Series<String,Number> series=new XYChart.Series<>();
		
		series.getData().add(new XYChart.Data<String, Number>("어린이", num1));
		series.getData().add(new XYChart.Data<String, Number>("청소년", num2));
		series.getData().add(new XYChart.Data<String, Number>("성인", num3));
		*/
    	
    	//데이터 셋팅하기
        XYChart.Series series1 = new XYChart.Series<>();
        series1.setName("오늘");
        series1.getData().add(new XYChart.Data<String,Number>("소 인",num1));
        series1.getData().add(new XYChart.Data<String,Number>("청소년",num2));
        series1.getData().add(new XYChart.Data<String,Number>("성 인",num3));

        
        XYChart.Series series2 = new XYChart.Series<>();
        series2.setName("어제");
        series2.getData().add(new XYChart.Data<String,Number>("소 인",num4));
        series2.getData().add(new XYChart.Data<String,Number>("청소년",num5));
        series2.getData().add(new XYChart.Data<String,Number>("성 인",num6));      
           

        
        //셋팅된 데이터를 차트에 추가하기
        chart.getData().addAll(series1,series2);
   	
  
		// 셋팅된 데이터를 차트에 추가하기
		//chart.getData().addAll(series);
		chart.setBarGap(5); 	// 막대와 막대 사이의 간격
		chart.setCategoryGap(75);
		
    }
    
    public void setData() throws RemoteException {
    	GregorianCalendar today = new GregorianCalendar();
   	 
    	int Year = today.get(Calendar.YEAR);
    	int Month = today.get(Calendar.MONTH)+1;
    	int Date = today.get(Calendar.DATE);
    	int Hour = today.get(Calendar.HOUR_OF_DAY);

		String today1=Year+"-" +Month+"-"+Date;

		//오늘 방문자
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i).getBuy_date().substring(0, 10).equals(today1)) {
    			if(list.get(i).getTicket_id().equals("tc001") ) {
    				num1++;
    			}else if(list.get(i).getTicket_id().equals("tc002")) {
    				num2++;
    			}else if(list.get(i).getTicket_id().equals("tc003")) {
    				num3++;
    			}
    		}
    	}
    	Date = today.get(Calendar.DATE)-1;
    	String yesterday=Year+"-"+Month+"-"+Date;

    	 //어제 방문자
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i).getBuy_date().substring(0, 10).equals(yesterday)) {
    			if(list.get(i).getTicket_id().equals("tc001") ) {
    				num4++;
    			}else if(list.get(i).getTicket_id().equals("tc002")) {
    				num5++;
    			}else if(list.get(i).getTicket_id().equals("tc003")) {
    				num6++;
    			}
    		}
    	}

    }
  
}
