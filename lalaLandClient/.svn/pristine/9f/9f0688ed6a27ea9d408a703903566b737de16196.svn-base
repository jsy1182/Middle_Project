package chart;

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
import java.util.TimeZone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import service.ILalaLandBuyService;
import service.ILalaLandMemberService;
import vo.BuyVO;
import vo.MemberVO;

public class BarChartController {
	ILalaLandBuyService service;
	List<BuyVO> list;
	int num1=0;
	int num2=0;
	int num3=0;
	int num4=0;
	int num5=0;
	int num6=0;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<String, Number> chart;

    @FXML
    void clkbtn(ActionEvent event) {
    	Stage close=(Stage) chart.getScene().getWindow();
		close.close();
    }

    @FXML
    void initialize() throws RemoteException {
        assert chart != null : "fx:id=\"chart\" was not injected: check your FXML file 'BarChart.fxml'.";
        
        try {
			Registry reg=LocateRegistry.getRegistry("localhost", 1088);
			service=(ILalaLandBuyService) reg.lookup("buy");
			list=service.getAllbuyForChart();
		} catch (RemoteException e) {
            System.out.println("member service 가져오기 실패");
            e.printStackTrace();
         }catch (NotBoundException ee) {
        	 System.out.println("member service 가져오기 실패");
             ee.printStackTrace();
		}
       
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
        XYChart.Series<String,Number> series1 = new XYChart.Series<>();
        series1.setName("오늘");
        series1.getData().add(new XYChart.Data<String,Number>("소 인",num1));
        series1.getData().add(new XYChart.Data<String,Number>("청소년",num2));
        series1.getData().add(new XYChart.Data<String,Number>("성 인",num3));

        
        XYChart.Series<String,Number> series2 = new XYChart.Series<>();
        series2.setName("어제");
        series2.getData().add(new XYChart.Data<String,Number>("소 인",num4));
        series2.getData().add(new XYChart.Data<String,Number>("청소년",num5));
        series2.getData().add(new XYChart.Data<String,Number>("성 인",num6));      
           
  

        System.out.println(series2.getData());
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
    	System.out.println(num1+" "+num2+" "+num3);
    	Date = today.get(Calendar.DATE)-1;
    	String yesterday=Year+"-"+Month+"-"+Date;
    	System.out.println(yesterday);
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
    	System.out.println(num4+" "+num5+" "+num6);
    	
    	
    	
    	
    	
    }
   

}
