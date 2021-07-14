import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2020년도 2학기
 * @author 김상진 
 * Alert dialog 예제
 */
public class AlertDemo extends Application {
	
	@Override
	public void start(Stage mainStage) throws Exception {
		Button infoAlert = new Button("정보창");
		Button warningAlert = new Button("경고창");
		Button errorAlert = new Button("오류창");
		Button confirmAlert = new Button("확인창");
		
		infoAlert.setOnAction(e->{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("정보창");
			//alert.setHeaderText(null);
			//alert.setContentText(null);
			
			alert.setHeaderText("중요 메시지");
			alert.setContentText("잠시만 기다려주세요!!!");
			alert.showAndWait();
		});
		warningAlert.setOnAction(e->{
			Alert alert = new Alert(AlertType.WARNING,"죄송합니다!!!",
				ButtonType.OK);
			alert.setTitle("경고창");
			alert.setHeaderText("시스템에 문제 발생");
			//alert.setContentText("죄송합니다!!!");
			alert.showAndWait();
		});
		errorAlert.setOnAction(e->{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("오류창");
			alert.setHeaderText("시스템에 심각한 문제 발생");
			alert.setContentText("죄송합니다!!!");
			alert.showAndWait();
		});
		confirmAlert.setOnAction(e->{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("확인창");
			alert.setHeaderText("새 게임을?");
			alert.setContentText("새 게임을 하고 싶으면 확인 버튼을...");
			Optional<ButtonType> result = alert.showAndWait();
			/*
			if(result.isPresent()) {
				System.out.println((result.get() == ButtonType.OK)? 
					"사용자 OK 선택": "사용자 Cancel 선택");
			}
			*/
			result.ifPresent(
					b -> System.out.println(
						(b == ButtonType.OK)? "사용자 OK 선택": "사용자 Cancel 선택"));
		});
		
		HBox mainPane = new HBox();
		mainPane.setPadding(new Insets(10));
		mainPane.setSpacing(10);
		mainPane.setAlignment(Pos.CENTER);
		mainPane.getChildren().addAll(infoAlert, warningAlert, errorAlert, confirmAlert);
			
		mainStage.setTitle("사용자 등록창");
		mainStage.setScene(new Scene(mainPane));
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
