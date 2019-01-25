package chart;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import service.ILalaLandBuyService;
import javafx.stage.StageStyle;


public class ChartMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;
    private ILalaLandBuyService service;
    

    @FXML
    void clickimg1(MouseEvent event) throws RemoteException {
       Stage primaryStage=new Stage(StageStyle.DECORATED);
       Parent root = null;
      try {
         root = FXMLLoader.load(
               getClass().getResource("/chart/PieChart.fxml")
               );
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      Scene scene=new Scene(root);
      primaryStage.setTitle("파이차트 화면");
      primaryStage.setScene(scene);
      primaryStage.show();
    
    }

    @FXML
//<<<<<<< .mine
    void clickimg2(MouseEvent event) throws RemoteException {
        int ticket1= service.getTicketCount("tc001");//소인 티켓 구매수
        int ticket2= service.getTicketCount("tc002");//청소년 티켓 구매수
        int ticket3= service.getTicketCount("tc003");//성인 티켓 구매수
        
        
      //차트 의 x,y축을나타내는 객체 생성
         CategoryAxis xAxis = new CategoryAxis(); //x 주로 문자
         NumberAxis yAxis = new NumberAxis();  //y  주로 숫자
        
      //BarChart객체 생성
         BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
            
         
      xAxis.setLabel("티켓이름");
      yAxis.setLabel("값");
      
      //데이터 셋팅하기
      XYChart.Series series1 = new XYChart.Series<>();
      series1.setName("소인");
      series1.getData().add(new XYChart.Data<String,Number>("소 인",ticket1));

      
      XYChart.Series series2 = new XYChart.Series<>();
      series2.setName("청소년");
      series2.getData().add(new XYChart.Data<String,Number>("청소년",ticket2));      
         
      XYChart.Series series3 = new XYChart.Series<>();
      series3.setName("성인");
      series3.getData().add(new XYChart.Data<String,Number>("성인",ticket3));   

      
      //셋팅된 데이터를 차트에 추가하기
      bc.getData().addAll(series1,series2,series3);
      bc.setBarGap(-25);
      bc.setCategoryGap(80);
      
      bc.setCenterShape(true);
      Stage primaryStage =new Stage(); 
      Scene scene = new Scene(bc);
      primaryStage.setScene(scene);
      primaryStage.setTitle("티켓별 판매 분포");
      primaryStage.show();
    }

    @FXML
    void clickimg3(MouseEvent event) throws RemoteException {
       int memberCount1= service.getMemberCount(10);
       int memberCount2= service.getMemberCount(20);
       int memberCount3= service.getMemberCount(30);
       
       System.out.println(memberCount1);
       System.out.println(memberCount2);
       
       //차트 의 x,y축을나타내는 객체 생성
         CategoryAxis xAxis = new CategoryAxis(); //x 주로 문자
         NumberAxis yAxis = new NumberAxis();  //y  주로 숫자
        
      //BarChart객체 생성
         BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
            
         
        xAxis.setLabel("연령대");
      yAxis.setLabel("티켓구매 명");
      
   
      //데이터 셋팅하기
            XYChart.Series series1 = new XYChart.Series<>();
            series1.setName("0~9");
            series1.getData().add(new XYChart.Data<String,Number>("0~9",memberCount1));

            
            XYChart.Series series2 = new XYChart.Series<>();
            series2.setName("10~19");
            series2.getData().add(new XYChart.Data<String,Number>("10~19",memberCount2));      
               
            XYChart.Series series3 = new XYChart.Series<>();
            series3.setName("20~29");
            series3.getData().add(new XYChart.Data<String,Number>("20~29",memberCount3));   
      //셋팅된 데이터를 차트에 추가하기
      bc.getData().addAll(series1,series2,series3);
      bc.setBarGap(-25);
      bc.setCategoryGap(80);
      
      Stage primaryStage =new Stage(); 
      Scene scene = new Scene(bc);
      primaryStage.setScene(scene);
      primaryStage.setTitle("티켓별 판매 분포");
      primaryStage.show();
       
    }

    @FXML
    void enterimg1(MouseEvent event) {
       lbl1.setText("등급별 회원 분포");
       setFont();
    }

    @FXML
    void enterimg2(MouseEvent event) {
       lbl2.setText("티켓별 판매 분포");
       setFont();
    }

    @FXML
    void enterimg3(MouseEvent event) {
       lbl3.setText("연령별 판매 분포");
       setFont();
    }

    @FXML
    void exitimg1(MouseEvent event) {
       lbl1.setText("");
    }

    @FXML
    void exitimg2(MouseEvent event) {
       lbl2.setText("");
    }

    @FXML
    void exitimg3(MouseEvent event) {
       lbl3.setText("");
    }

    @FXML
    void initialize() {
        assert lbl1 != null : "fx:id=\"lbl1\" was not injected: check your FXML file 'ChartMain.fxml'.";
        assert lbl2 != null : "fx:id=\"lbl2\" was not injected: check your FXML file 'ChartMain.fxml'.";
        assert lbl3 != null : "fx:id=\"lbl3\" was not injected: check your FXML file 'ChartMain.fxml'.";

        
        try {
         Registry reg = LocateRegistry.getRegistry("localhost", 1088);
         service =  (ILalaLandBuyService) reg.lookup("buy");
      } catch (RemoteException | NotBoundException e) {
         System.out.println("buy service 가져오기 실패");
         e.printStackTrace();
      }
    }
    
    public void setFont() {
        final Font font = Font.loadFont(getClass().getResourceAsStream("/font/HoonlefthanderR.otf"), 35);
        lbl1.setFont(font);
        lbl2.setFont(font);
        lbl3.setFont(font);
        lbl1.setTextFill(Color.GRAY);
        lbl2.setTextFill(Color.GRAY);
        lbl3.setTextFill(Color.GRAY);
    }
}