import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2020년도 2학기
 * @author 김상진 
 * ListViewDemo.java
 * ListView 예제
 */
public class ListViewDemo extends Application {
	private static final String[] progLang = {
			"C", "C++", "C#", "JAVA", "Python", "JAVASCRIPT", "ML", "BASIC"};
	private ListView<String> progLangSkills = new ListView<>();
	private TextField textField = new TextField();
	
	public void changed(
		ObservableValue<? extends String> observable, String oldValue, String newValue) { 			 
		List<String> selected = progLangSkills.getSelectionModel().getSelectedItems();
		String text = "";
		for(String s: selected){
			text += (s+", ");
		}
		textField.setText(text.substring(0,text.length()-2));
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
		
		progLangSkills.getItems().addAll(progLang);
		progLangSkills.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		progLangSkills.setPrefHeight(80d);
		progLangSkills.getSelectionModel().selectedItemProperty()
			.addListener((o, oV, nV)->changed(o, oV, nV));
		
		FlowPane controlPane = new FlowPane();
		controlPane.setPadding(new Insets(10));
		controlPane.setAlignment(Pos.CENTER);
		controlPane.getChildren().add(progLangSkills);
		
		mainPane.setCenter(textPane);
		mainPane.setBottom(controlPane);
		
		mainStage.setTitle("ListView Example");
		mainStage.setScene(new Scene(mainPane));
		mainStage.show();
		mainStage.setResizable(false);
		progLangSkills.requestFocus();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
