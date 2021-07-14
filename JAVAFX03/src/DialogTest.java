import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2020년도 2학기
 * @author 김상진 
 * DialogTest.java
 * TextInputDialog, ChoiceDialog 사용 예제
 */
public class DialogTest extends Application {
	private Button textInputDialogBtn = new Button("텍스트 입력창");
	private Button choiceDialogBtnBtn = new Button("선택창");
	
	@Override
	public void start(Stage mainStage) throws Exception {
		HBox mainPane = new HBox();
		mainPane.setPadding(new Insets(10));
		mainPane.setSpacing(10);
		mainPane.setAlignment(Pos.CENTER);
		mainPane.getChildren().addAll(textInputDialogBtn, choiceDialogBtnBtn);
		mainStage.setTitle("기본 Dialog");
		mainStage.setScene(new Scene(mainPane));
		mainStage.show();

		textInputDialogBtn.setOnAction(e->{
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("이름 입력창");
			dialog.setHeaderText(null);
			dialog.setContentText("이름을 입력하여주세요!!!");
			dialog.showAndWait().ifPresent(System.out::println);
		});
		
		choiceDialogBtnBtn.setOnAction(e->{
			List<Integer> choices = IntStream.rangeClosed(1,12).boxed().collect(Collectors.toList());
			ChoiceDialog<Integer> dialog = new ChoiceDialog<>(1, choices);
			dialog.setTitle("가장 좋아하는 월 선택");
			dialog.setHeaderText(null);
			dialog.setContentText("가장 좋아하는 월을 선택하여 주세?");
			dialog.showAndWait().ifPresent(System.out::println);
		});
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
