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
public class AlertTest02 extends Application {
	private Button confirmBtn = new Button("ALERT 확인");
	private Button likehateBtn = new Button("ALERT 좋아/싫어");
	
	@Override
	public void start(Stage mainStage) throws Exception {
		HBox mainPane = new HBox();
		mainPane.setPadding(new Insets(10));
		mainPane.setSpacing(10);
		mainPane.setAlignment(Pos.CENTER);
		mainPane.getChildren().addAll(confirmBtn, likehateBtn);
		mainStage.setTitle("Simple JavaFX App");
		mainStage.setScene(new Scene(mainPane, 500, 150));
		mainStage.show();

		confirmBtn.setOnAction(e->{
			ButtonType ok = new ButtonType("확인", ButtonBar.ButtonData.OK_DONE);
			ButtonType cancel = new ButtonType("취소", ButtonBar.ButtonData.CANCEL_CLOSE);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("확인창");
			alert.setHeaderText("확인부탁드립니다.");
			alert.setContentText("이것에 대해 확인해주시겠습니까?");
			alert.getButtonTypes().setAll(ok, cancel);
			alert.showAndWait().ifPresent(r->System.out.println(
				(r == ok)? "사용자 OK 선택": "사용자 Cancel 선택"));
		});
		
		likehateBtn.setOnAction(e->{
			ButtonType like = new ButtonType("좋아");
			ButtonType hate = new ButtonType("싫어");
			ButtonType cancel = new ButtonType("취소", ButtonBar.ButtonData.CANCEL_CLOSE);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("확인창");
			alert.setHeaderText("확인부탁드립니다.");
			alert.setContentText("김상진 교수를 좋아하시나요?");
			alert.getButtonTypes().setAll(like, hate, cancel);
			alert.showAndWait().ifPresent(r->{
				if (r == like){
					System.out.println("사용자 좋아 선택");
				} 
				else if(r == hate){
					System.out.println("사용자 싫어 선택");
				}
				else{
					System.out.println("사용자 Cancel 선택");
				}
			});
			
		});
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
