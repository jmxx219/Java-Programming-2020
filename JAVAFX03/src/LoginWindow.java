import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2020년도 2학기
 * @author 김상진 
 * LoginWindow.java
 * Layout 예제 
 * GridPane 예제
 */
public class LoginWindow extends Application {
	
	@Override
	public void start(Stage mainStage) throws Exception {
		Label idLabel = new Label("계정명");
		Label pwdLabel = new Label("패스워드");
		Button loginButton = new Button("로그인");
		TextField idField = new TextField();
		PasswordField pwdField = new PasswordField();
		loginButton.setDisable(true);
		idField.textProperty().addListener((obs, oldVal, newVal)->{
			loginButton.setDisable(idField.getText().length()==0||
				pwdField.getText().length()==0);
		});
		pwdField.textProperty().addListener((obs, oldVal, newVal)->{
			loginButton.setDisable(idField.getText().length()==0||
				pwdField.getText().length()==0);
		});
		idField.setPromptText("ID를 입력하세요.");
		pwdField.setPromptText("패스워를 입력하세요.");
		
		// idField에 데이터 입력이 있는 경우에만 loginBtn을 활성화
		/*
		idField.setOnKeyTyped(e->{
			loginButton.setDisable(idField.getText().length()==0||
				pwdField.getText().length()==0);
		});
		*/
		/*
		idField.setOnKeyPressed(e->{
			loginButton.setDisable(idField.getText().length()==0||
				pwdField.getText().length()==0);
		});
		*/
		
		GridPane mainPane = new GridPane();
		mainPane.setPadding(new Insets(10d));
		mainPane.setHgap(10d);
		// add(node, column, row, colspan, rowspan)
		mainPane.add(idLabel, 0, 0); 
		mainPane.add(pwdLabel, 0, 1);
		mainPane.add(idField, 1, 0);
		mainPane.add(pwdField, 1, 1);
		mainPane.add(loginButton, 2, 0, 1, 2);
		mainStage.setTitle("KoreaTech Login Window");
		mainStage.setScene(new Scene(mainPane));
		mainStage.setResizable(false); // 크기 조절을 할 수 없도록 
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
