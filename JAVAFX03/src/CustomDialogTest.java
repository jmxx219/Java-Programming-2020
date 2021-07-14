import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2020년도 2학기
 * @author 김상진 
 * CustomDialogTest.java
 * Dialog 클래스를 이용한 Custom Dialog 생성 및 사용 
 */
public class CustomDialogTest extends Application {
	private Button loginDialogBtn = new Button("로그인창");
	private void showLoginDialog(){
		// 사용자 구성 Dialog 생성
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("사용자 로그인창");
		dialog.setHeaderText("상진이가 만든 로그인창");

		// Dialog의 icon 설정
		ImageView iView = new ImageView(new Image("login.png"));
		iView.setFitWidth(80);
		iView.setPreserveRatio(true);
		dialog.setGraphic(iView);

		// 등장할 버튼 설정
		ButtonType loginButtonType = new ButtonType("로그인", ButtonBar.ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// 원하는 모습 구현하기 위해 GridPane 활용
		GridPane contentsPane = new GridPane();
		contentsPane.setHgap(10);
		contentsPane.setVgap(10);
		contentsPane.setPadding(new Insets(20));

		TextField username = new TextField();
		username.setPromptText("계정명");
		PasswordField password = new PasswordField();
		password.setPromptText("패스워드");

		contentsPane.add(new Label("계정명:"), 0, 0);
		contentsPane.add(username, 1, 0);
		contentsPane.add(new Label("패스워드:"), 0, 1);
		contentsPane.add(password, 1, 1);

		// 계정명이 입력된 경우에만 활성화
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		// 입력 데이터에 대한 사전 검증
		username.textProperty().addListener((observable, oldValue, newValue) -> {
		    loginButton.setDisable(newValue.trim().isEmpty());
		});

		dialog.getDialogPane().setContent(contentsPane);

		// 입력 TextField 중 focus 줄 것을 결정
		Platform.runLater(() -> username.requestFocus());

		// 결과 받아오기
		dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == loginButtonType) {
		        return new Pair<>(username.getText(), password.getText());
		    }
		    return null;
		});

		dialog.showAndWait().ifPresent(usernamePassword -> {
		    System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
		});
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox mainPane = new HBox();
		mainPane.setPadding(new Insets(10));
		mainPane.setSpacing(10);
		mainPane.setAlignment(Pos.CENTER);
		mainPane.getChildren().add(loginDialogBtn);
		primaryStage.setTitle("기본 Dialog");
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.show();

		loginDialogBtn.setOnAction(e->{
			showLoginDialog();
		});
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
