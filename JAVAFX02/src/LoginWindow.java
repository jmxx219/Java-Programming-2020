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
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
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
		Button loginBtn = new Button("로그인");
		TextField idField = new TextField();
		PasswordField pwdField = new PasswordField();
		loginBtn.setDisable(true);
		idField.setPromptText("ID는 이메일 형태입니다.");
		pwdField.setPromptText("패스워드 8자 이상이어야 합니다.");
		// idField에 데이터 입력이 있는 경우에만 loginBtn을 활성화
		idField.setOnKeyTyped(e->{
			if(idField.getText().length()!=0) loginBtn.setDisable(false);
			else loginBtn.setDisable(true);
		});
		/*
		idField.setOnKeyPressed(e->{
			if(idField.getText().length()!=0) loginBtn.setDisable(false);
			else loginBtn.setDisable(true);
		});
		*/
		
		GridPane mainPane = new GridPane();
		mainPane.setPadding(new Insets(10d));
		mainPane.setHgap(10d);
		mainPane.setVgap(10d);
		// add(node, column, row, colspan, rowspan)
		mainPane.add(idLabel, 0, 0); 
		mainPane.add(pwdLabel, 0, 1);
		mainPane.add(idField, 1, 0);
		mainPane.add(pwdField, 1, 1);
		mainPane.add(loginBtn, 2, 0, 1, 2);
		mainStage.setTitle("KoreaTech Login Window");
		mainStage.setScene(new Scene(mainPane));
		mainStage.setResizable(false); // 크기 조절을 할 수 없도록 
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
