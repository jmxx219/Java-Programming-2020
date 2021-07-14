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
 * ComboBox 예제
 */
public class ComboBoxDemoV1 extends Application {
	private ComboBox<String> monthChoice = new ComboBox<>();
	private TextField textField = new TextField();
	
	public void handle(ActionEvent event){
		textField.setText(monthChoice.getSelectionModel().getSelectedItem());
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
		
		String[] monthAbbr = {
				"JAN", "FEB", "MAR", "APR", "MAY", "JUN",
				"JUL", "AUG", "SEPT", "OCT", "NOV", "DEC"};
		monthChoice.getItems().addAll(monthAbbr);
		monthChoice.setOnAction(e->handle(e));
		monthChoice.getSelectionModel().select(0);
		monthChoice.setVisibleRowCount(5);
		textField.setText(monthChoice.getSelectionModel().getSelectedItem());
		
		FlowPane comboBoxPane = new FlowPane();
		comboBoxPane.setPadding(new Insets(10));
		comboBoxPane.setAlignment(Pos.CENTER);
		comboBoxPane.getChildren().add(monthChoice);
		
		mainPane.setCenter(textPane);
		mainPane.setBottom(comboBoxPane);
		
		mainStage.setTitle("ComboBox Example");
		mainStage.setScene(new Scene(mainPane));
		mainStage.show();
		monthChoice.requestFocus();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
