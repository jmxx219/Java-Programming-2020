import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2020년도 2학기
 * @author 김상진 
 * ComboBoxDemo.java
 * ComboBox 예제. String ComboBox의 경우에는 편집가능하도록 할 수 있음
 */
public class ComboBoxDemoV2 extends Application {
	private ComboBox<String> foodChoice = new ComboBox<>();
	private TextField textField = new TextField();
	
	public void handle(ActionEvent event){
		textField.setText(foodChoice.getSelectionModel().getSelectedItem());
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		BorderPane mainPane = new BorderPane();
		FlowPane textPane = new FlowPane();
		textPane.setPadding(new Insets(10));
		textPane.setAlignment(Pos.CENTER);
		textField.setEditable(false);
		textField.setMinWidth(400);
		textPane.getChildren().add(textField);
		
		String[] foods = {"햄버거", "피자", "파스타", "떡볶이", "짜장면", "짬봉"};
		foodChoice.getItems().addAll(foods);
		foodChoice.setEditable(true);
		foodChoice.setOnAction(e->handle(e));
		foodChoice.getSelectionModel().select(0);
		foodChoice.setVisibleRowCount(3);
		textField.setText(foodChoice.getSelectionModel().getSelectedItem());
		
		FlowPane comboBoxPane = new FlowPane();
		comboBoxPane.setPadding(new Insets(10));
		comboBoxPane.setAlignment(Pos.CENTER);
		comboBoxPane.getChildren().add(foodChoice);
		
		mainPane.setCenter(textPane);
		mainPane.setBottom(comboBoxPane);
		
		mainStage.setTitle("ComboBox Example");
		mainStage.setScene(new Scene(mainPane));
		mainStage.show();
		foodChoice.requestFocus();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
