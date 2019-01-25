package Board.controller;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.IBoardService;
import vo.AdminVO;
import vo.BoardVO;

public class BoardAdminMainController {
	IBoardService service = null;
	List<BoardVO> boardList = null;
	ObservableList<BoardVO> data;

	@FXML
    private ResourceBundle resources;
	
    @FXML
    private AnchorPane anchoPane;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private TableView<BoardVO> notice;

    @FXML
    private TableColumn<?, ?> col_no;

    @FXML
    private TableColumn<?, ?> col_title;

    @FXML
    private TableColumn<?, ?> col_writer;

    @FXML
    private TableColumn<?, ?> col_date;

    @FXML
    private Pagination pagination;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private TextField tf;

    @FXML
    private Button btn_search;

	

	@FXML
	void click_newNotice(ActionEvent event) {
		
		Stage stage = (Stage) notice.getScene().getWindow();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/NewNotice.fxml"));

		Parent root;
		try {
			root = loader.load();
			anchoPane.getChildren().setAll(root);
//			Scene scene = new Scene(root);
//			stage.setScene(scene);

		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}


	@FXML
	void click_search(ActionEvent event) {
		String searchdata = tf.getText();
		String colName = null;
		Map<String, String> param = new HashMap<>();
		if (searchdata.isEmpty()) {
			alert("검색할 내용이 없습니다.");
			return;
		}

		if (combo.getSelectionModel().getSelectedItem() == "제목") {
			colName = "bo_title";

		} else {// 내용
			colName = "bo_content";
		}

		param.put("searchdata", "%" + searchdata + "%");
		param.put("colName", colName);
		List<BoardVO> list;
		try {
			list = service.searchNoticeBoard(param);
			if (list.size() == 0 || list == null) {
				return;
			}
			data = FXCollections.observableArrayList(list);
			notice.setItems(data);

		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	private void alert(String string) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText(string);
		alert.showAndWait();

	}

	
	@FXML
	void viewBoard(MouseEvent event) {
		BoardVO board = notice.getSelectionModel().getSelectedItem();
		if (board == null) {
			return;
		}
		Stage stage = (Stage) notice.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Board/fxml/ViewBoardAdmin.fxml"));

		Parent child;
		try {
			child = loader.load();
			anchoPane.getChildren().setAll(child);

			ViewBoardAdminController viewBoardController = loader.getController();

			viewBoardController.setBoard(board);
			viewBoardController.setTextField();

//			Scene scene = new Scene(child);
//
//			stage.setScene(scene);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private int datasize;
	private int rowperpage = 10;

	@FXML
	void initialize() {
		assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'BoardAdminMain.fxml'.";
		assert notice != null : "fx:id=\"notice\" was not injected: check your FXML file 'BoardAdminMain.fxml'.";
		assert col_no != null : "fx:id=\"col_no\" was not injected: check your FXML file 'BoardAdminMain.fxml'.";
		assert col_title != null : "fx:id=\"col_title\" was not injected: check your FXML file 'BoardAdminMain.fxml'.";
		assert col_writer != null : "fx:id=\"col_writer\" was not injected: check your FXML file 'BoardAdminMain.fxml'.";
		assert col_date != null : "fx:id=\"col_date\" was not injected: check your FXML file 'BoardAdminMain.fxml'.";
		assert pagination != null : "fx:id=\"pagination\" was not injected: check your FXML file 'BoardAdminMain.fxml'.";
		assert combo != null : "fx:id=\"combo\" was not injected: check your FXML file 'BoardAdminMain.fxml'.";
		assert tf != null : "fx:id=\"tf\" was not injected: check your FXML file 'BoardAdminMain.fxml'.";
		assert btn_search != null : "fx:id=\"btn_search\" was not injected: check your FXML file 'BoardAdminMain.fxml'.";
        assert anchoPane != null : "fx:id=\"anchoPane\" was not injected: check your FXML file 'BoardEmpMain.fxml'.";


		
		List<String> combolist = new ArrayList<>();
		combolist.add(0, "제목");
		combolist.add(1, "내용");
		ObservableList<String> list = FXCollections.observableArrayList(combolist);
		combo.setItems(list);
		combo.getSelectionModel().selectFirst();

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1088);
			service = (IBoardService) reg.lookup("boardService");
			boardList = new ArrayList<>();
			boardList = service.getnoticeList();
		} catch (RemoteException | NotBoundException e) {
			System.out.println("board service 가져오기 실패");
			e.printStackTrace();
		}
		col_title.setCellValueFactory(new PropertyValueFactory<>("bo_title"));
		col_no.setCellValueFactory(new PropertyValueFactory<>("rownum"));
		col_date.setCellValueFactory(new PropertyValueFactory<>("bo_date"));
		col_writer.setCellValueFactory(new PropertyValueFactory<>("mem_id"));

		data = FXCollections.observableArrayList(boardList);
		notice.setItems(data);

		datasize = boardList.size();

		int pageCount = datasize / rowperpage + (datasize % rowperpage == 0 ? 0 : 1);

		pagination.setPageCount(pageCount); // 페이지 못 넘어가게 막음
		pagination.setMaxPageIndicatorCount(pageCount);
		changeTableView(0);

		pagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				changeTableView(newValue.intValue());
			}

		});

	}

	public void changeTableView(int index) {
		int fromIndex = index * rowperpage; // 가져올 데이터의 시작번호
		int toIndex = Math.min(fromIndex + rowperpage, datasize);

		notice.setItems(FXCollections.observableArrayList(boardList.subList(fromIndex, toIndex)));
	}
}
