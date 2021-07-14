import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2020년도 2학기
 * @author 김상진 
 * Alert dialog 예제
 */
public class AlertTest01 extends Application {
	private Button infoBtn = new Button("ALERT INFO");
	private Button confirmBtn01 = new Button("ALERT CONFIRM1");
	private Button confirmBtn02 = new Button("ALERT CONFIRM2");
	
	@Override
	public void start(Stage mainStage) throws Exception {
		HBox mainPane = new HBox();
		mainPane.setPadding(new Insets(10));
		mainPane.setSpacing(10);
		mainPane.setAlignment(Pos.CENTER);
		mainPane.getChildren().addAll(infoBtn, confirmBtn01, confirmBtn02);
		mainStage.setTitle("Simple JavaFX App");
		mainStage.setScene(new Scene(mainPane, 500, 150));
		mainStage.show();

		infoBtn.setOnAction(e->{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("정보창");
			alert.setHeaderText("중요 메시지");
			alert.setContentText("잠시만 기다려주세요!!!");
			alert.showAndWait();
		});
		
		confirmBtn01.setOnAction(e->{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("확인창");
			alert.setHeaderText("확인부탁드립니다.");
			alert.setContentText("이것에 대해 확인해주시겠습니까?");
			Optional<ButtonType> result = alert.showAndWait();
			result.ifPresent(
				b -> System.out.println(
					(b == ButtonType.OK)? "사용자 OK 선택": "사용자 Cancel 선택"));
		});
		// 버튼 문자열 변경 방법
		confirmBtn02.setOnAction(e->{
			ButtonType hate = new ButtonType("싫어", ButtonBar.ButtonData.CANCEL_CLOSE);
			Alert alert = new Alert(AlertType.CONFIRMATION, 
				"이것에 대해 확인해주시겠습니까?", ButtonType.OK, hate);
			alert.setTitle("확인창");
			alert.setHeaderText("확인부탁드립니다.");
			Optional<ButtonType> result = alert.showAndWait();
			result.ifPresent(
				b->System.out.println(
					(b == hate)? "사용자 싫어 선택": "사용자 OK 선택"));
		});
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
