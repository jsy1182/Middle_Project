package Board.controller;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ChattingViewHBox extends HBox {
	private ImageView hbImgView = new ImageView();
	private Label hbLabel = new Label();
	private boolean chk;  // 고객과 봇을 구분하는 변수(true:고객, false:봇)
	
	public ChattingViewHBox(Image img, String msg,boolean chk) {
		setPrefWidth(343);
		setSpacing(10);
		//setPadding(new Insets(10));
		
		String strStyle = "-fx-background-radius:30px; -fx-text-fill:black;";
		if(img!=null) {
			hbImgView.setImage(img);
			hbImgView.setFitHeight(52);
			hbImgView.setFitWidth(52);
		}
		hbLabel.setText(msg);
		hbLabel.setPrefWidth(267);
		hbLabel.setPadding(new Insets(10,10,10,20));
		
		
		if(chk) { // 고객
			strStyle += "-fx-background-color:yellow;";
			getChildren().addAll(hbLabel, hbImgView);
		}else {  // 봇
			strStyle += "-fx-background-color:white;";
			getChildren().addAll(hbImgView, hbLabel);
		}
		hbLabel.setStyle(strStyle);
		
	}
	
	
}
