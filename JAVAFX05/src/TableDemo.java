import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * TableDemo.java
 * Table 예제
 */
public class TableDemo extends Application {
	private TableView<VolleyballPlayer> vbPlayerTable = new TableView<>();
	private Label selectedText = new Label();
	
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		System.out.println(newValue);
		ObservableList<VolleyballPlayer> selected = vbPlayerTable.getSelectionModel().getSelectedItems();

		String result = "";
		for(VolleyballPlayer b: selected)
			result += b+"\n";
		System.out.println(result);
		/*selectedText.setText(result.substring(0,result.length()-1));*/
	}
	
	private void createTable(){
		vbPlayerTable.setItems(loadData());
		TableColumn<VolleyballPlayer, String> colName = new TableColumn<>("이름");
		
		colName.setMinWidth(80d);
		colName.setStyle("-fx-alignment: center");
		colName.setCellValueFactory(new PropertyValueFactory<VolleyballPlayer, String>("Name"));
		
		TableColumn<VolleyballPlayer, Integer> colNumber = new TableColumn<>("번호");
		colNumber.setMinWidth(80d);
		colNumber.setStyle("-fx-alignment: center");
		//colNumber.setStyle("-fx-alignment: center; -fx-background-color: black; -fx-text-fill: white");
		colNumber.setCellValueFactory(new PropertyValueFactory<VolleyballPlayer, Integer>("Number"));
		
		TableColumn<VolleyballPlayer, Double> colAttackSuccessRate = new TableColumn<>("공격성공률");
		colAttackSuccessRate.setMinWidth(120d);
		colAttackSuccessRate.setStyle("-fx-alignment: center");
		colAttackSuccessRate.setCellValueFactory(new PropertyValueFactory<VolleyballPlayer, Double>("AttackSuccessRate"));
		vbPlayerTable.getColumns().add(colName);
		vbPlayerTable.getColumns().add(colNumber);
		vbPlayerTable.getColumns().add(colAttackSuccessRate);
		//table.getColumns().addAll(colName, colNumber, colBatAvg);
		
		//vbPlayerTable.getStyleClass().add("table-view");
		
		//vbPlayerTable.setSelectionModel(null);
		vbPlayerTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		vbPlayerTable.getSelectionModel().selectedIndexProperty().addListener((ob,ov,nv)->changed(ob,ov,nv));
	}
	
	public ObservableList<VolleyballPlayer> loadData(){
		ObservableList<VolleyballPlayer> vbPlayerList = FXCollections.observableArrayList();
		vbPlayerList.add(new VolleyballPlayer("박정아",9,37.04));
		vbPlayerList.add(new VolleyballPlayer("이소영",1,39.96));
		vbPlayerList.add(new VolleyballPlayer("이재영",17,38.61));
		vbPlayerList.add(new VolleyballPlayer("강소희",10,36.75));
		vbPlayerList.add(new VolleyballPlayer("고예림",7,34.89));
		return vbPlayerList;
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		createTable();
		VBox tableBox = new VBox();
		tableBox.setSpacing(10);
		tableBox.setPadding(new Insets(10));
		tableBox.getChildren().addAll(vbPlayerTable, selectedText);
		mainStage.setTitle("KOVO 여자부");
		mainStage.setScene(new Scene(tableBox, 300, 400));
		mainStage.show();
		//mainStage.getScene().getStylesheets().add(getClass().getResource("vbPlayerTable.css").toExternalForm());
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
