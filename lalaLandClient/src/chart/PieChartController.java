package chart;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import service.ILalaLandBuyService;
import service.ILalaLandMemberService;
import vo.MemberVO;

public class PieChartController {
	List<MemberVO> list;
	ILalaLandMemberService service;
	int numOfSilver=0;
    int numOfGold=0;
    int numOfVIP=0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart chart;
    
    
    @FXML
    void initialize() {
        assert chart != null : "fx:id=\"chart\" was not injected: check your FXML file 'PieChart.fxml'.";
        
        try {
			Registry reg=LocateRegistry.getRegistry("localhost", 1088);
			service=(ILalaLandMemberService) reg.lookup("memberService");
			list=service.getAllMemberList();
		} catch (RemoteException e) {
            System.out.println("member service 가져오기 실패");
            e.printStackTrace();
         }catch (NotBoundException ee) {
        	 System.out.println("member service 가져오기 실패");
             ee.printStackTrace();
		}
        setChart();
        
        
    }
    
    public void setChart() {
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i).getMem_grade().equals("silver")) {
    			numOfSilver++;
    		}else if(list.get(i).getMem_grade().equals("gold")) {
    			numOfGold++;
    		}else if(list.get(i).getMem_grade().equals("vip")) {
    			numOfVIP++;
    		}
    	}
    	ObservableList<PieChart.Data> pieChartData=FXCollections.observableArrayList(
    			new PieChart.Data("골드", numOfGold),
    			new PieChart.Data("실버", numOfSilver),
    			new PieChart.Data("VIP", numOfVIP)
    			);
    	chart.setData(pieChartData);
    }
    
    
}
