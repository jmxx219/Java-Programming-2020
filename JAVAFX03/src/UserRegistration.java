import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2020년도 2학기
 * @author 김상진 
 * 사용자 등록 예제
 */
public class UserRegistration extends Application {
	private static class User{
		String id;
		String name;
		LocalDate birthday;
		boolean isMale;
		ArrayList<String> hobbies = new ArrayList<>();
	}
	private Map<String, User> userDB = new HashMap<>();
	
	private String[] hobbyList = {
		"운동", "독서", "유투브", "영화보기"	
	};
	private TextField idField = new TextField();
	private TextField nameField = new TextField();
	private RadioButton maleChoice = new RadioButton("남성");
	private RadioButton femaleChoice = new RadioButton("여성");
	private CheckBox[] hobbyChoices = new CheckBox[hobbyList.length];
	private Button duplicationCheckButton = new Button("중복확인");
	private Button registerButton = new Button("등록");
	private ComboBox<Integer> yearBox = new ComboBox<>();
	private ComboBox<Integer> monthBox = new ComboBox<>();
	private ComboBox<Integer> dayBox = new ComboBox<>();
	private boolean duplicationChecked = false;
	
	private void duplicationCheck() {
		if(userDB.containsKey(idField.getText())) {
			duplicationChecked = false;
			registerButton.setDisable(true);
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("경고창");
			alert.setHeaderText("다른 사용자가 사용 중인 ID입니다.");
			alert.showAndWait();
		}
		else {	
			duplicationChecked = true;
			registerButton.setDisable(false);
		}
	}
	
	private void register() {
		if(!duplicationChecked) {
			registerButton.setDisable(true);
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("경고창");
			alert.setHeaderText("등록실");
			alert.showAndWait();
			return;
		}
		User user = new User();
		user.id = idField.getText();
		user.name = nameField.getText();
		user.isMale = maleChoice.isSelected();
		user.birthday = LocalDate.of(
			yearBox.getSelectionModel().getSelectedItem(), 
			monthBox.getSelectionModel().getSelectedItem(), 
			dayBox.getSelectionModel().getSelectedItem());
		for(var hobby: hobbyChoices)
			if(hobby.isSelected()) user.hobbies.add(hobby.getText());
		userDB.put(user.id, user);
		
		System.out.print("ID = "+user.id+", 이름 = "+user.name);
		System.out.print(user.isMale? ", 남성, ": ", 여성, ");
		System.out.print("생년월일: "+ user.birthday);
		System.out.print(", 취미: ");
		for(var hobby: user.hobbies)
			System.out.print(hobby+", ");
		System.out.println();
	}
	
	// 년, 월 정보 선택에 따라 일 정보 갱신
	private void change() {
		int year = yearBox.getSelectionModel().getSelectedItem();
		int month = monthBox.getSelectionModel().getSelectedItem();
		int day = 1;
		LocalDate date = LocalDate.of(year, month, day);

		dayBox.getItems().clear();
		/*
		for(int d=1; d<=date.lengthOfMonth(); d++) {
			dayBox.getItems().add(d);
		}
		*/
		//dayBox.getItems().addAll(IntStream.rangeClosed(1, date.lengthOfMonth()).boxed().toArray(Integer[]::new));
		dayBox.getItems().addAll(IntStream.rangeClosed(1, date.lengthOfMonth()).boxed().collect(Collectors.toList()));
		dayBox.getSelectionModel().select(Integer.valueOf(1));
 	}
	
	private void constructBirthdayBoxes() {
		LocalDate currentDate = LocalDate.now();
		int year = currentDate.getYear();
		for(int y=year-100; y<=year; y++)
			yearBox.getItems().add(y);
		yearBox.getSelectionModel().select(Integer.valueOf(year));
		yearBox.setOnAction(e->change());
		yearBox.setMinWidth(80d);
		
		//for(int m=1; m<=12; m++)
		//	monthBox.getItems().add(m);
		monthBox.getItems().addAll(
			IntStream.rangeClosed(1, 12).boxed()
				.collect(Collectors.toList()));
		monthBox.getSelectionModel().select(
			Integer.valueOf(currentDate.getMonth().getValue()));
		monthBox.setOnAction(e->change());
		monthBox.setMinWidth(80d);
		
		//for(int d=1; d<=currentDate.lengthOfMonth(); d++)
		//	dayBox.getItems().add(d);
		dayBox.getItems().addAll(
			IntStream.rangeClosed(1, currentDate.lengthOfMonth()).boxed()
				.collect(Collectors.toList()));
		dayBox.getSelectionModel().select(
				Integer.valueOf(currentDate.getDayOfMonth()));
		dayBox.setMinWidth(80d);
		dayBox.setVisibleRowCount(6);
	}
	
	private Pane constructContentsPane() {
		constructBirthdayBoxes();
		
		GridPane inputPane = new GridPane();
		inputPane.setPadding(new Insets(10));
		inputPane.setVgap(10d);
		inputPane.setHgap(10d);
		
		for(int i=0; i<hobbyChoices.length; i++)
			hobbyChoices[i] = new CheckBox(hobbyList[i]);
		
		inputPane.add(new Label("ID"), 0, 0);
		inputPane.add(new Label("이름"), 0, 1);
		inputPane.add(new Label("성별"), 0, 2);
		inputPane.add(new Label("생년월일"), 0, 3);
		inputPane.add(new Label("취미"), 0, 4);
		
		ToggleGroup genderGroup = new ToggleGroup();
		genderGroup.getToggles().addAll(maleChoice, femaleChoice);
		
		inputPane.add(idField, 1, 0, 3, 1);
		idField.textProperty().addListener((obs, oldVal, newVal)->{
			duplicationCheckButton.setDisable(
				idField.getText().length()==0);
		});
		
		inputPane.add(duplicationCheckButton, 4, 0);
		duplicationCheckButton.setDisable(true);
		duplicationCheckButton.setOnAction(e->duplicationCheck());
		
		inputPane.add(nameField, 1, 1, 3, 1);
		inputPane.add(maleChoice, 1, 2);
		inputPane.add(femaleChoice, 2, 2);
		
		inputPane.add(yearBox, 1, 3);
		inputPane.add(monthBox, 2, 3);
		inputPane.add(dayBox, 3, 3);
		
		for(int i=0; i<hobbyChoices.length; i++) {
			inputPane.add(hobbyChoices[i], i+1, 4);
		}
		maleChoice.setSelected(true);
		
		ColumnConstraints c60 = new ColumnConstraints(60);
		ColumnConstraints c80 = new ColumnConstraints(80);
		inputPane.getColumnConstraints().addAll(c60, c80, c80, c80, c80);
		return inputPane;
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		HBox buttonPane = new HBox();
		buttonPane.setPadding(new Insets(10));
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().add(registerButton);
		registerButton.setDisable(true);
		registerButton.setOnAction(e->register());
		
		BorderPane mainPane = new BorderPane();
		mainPane.setCenter(constructContentsPane());
		mainPane.setBottom(buttonPane);
		
		mainStage.setTitle("사용자 등록창");
		mainStage.setScene(new Scene(mainPane));
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
