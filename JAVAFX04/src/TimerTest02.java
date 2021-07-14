
import java.util.concurrent.ThreadLocalRandom;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * 타이머 이벤트 처리 (이벤트 발생마다 임의 위치에 그림 추가)
 */
public class TimerTest02 extends Application {
	private Pane centerPane = new Pane();
	private Timeline pokemonTimeLine = new Timeline();
	private Image dracaufeu = new Image("dracaufeu.png");
	
	public void pokemonTimerHandle() {
		ImageView dracaufeuNode = new ImageView(dracaufeu);
		dracaufeuNode.setFitWidth(80);
		dracaufeuNode.setPreserveRatio(true);
		dracaufeuNode.setX(ThreadLocalRandom.current().nextInt(420));
		dracaufeuNode.setY(ThreadLocalRandom.current().nextInt(420));
		centerPane.getChildren().add(dracaufeuNode);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {		
		BorderPane mainPane = new BorderPane();
		Button startButton = new Button("Start");
		Button stopButton = new Button("Stop");
		Button clearButton = new Button("Clear");
		startButton.setOnAction(e->pokemonTimeLine.play());
		stopButton.setOnAction(e->pokemonTimeLine.stop());
		clearButton.setOnAction(e->centerPane.getChildren().clear());
		
		HBox buttonPane = new HBox();
		buttonPane.setPadding(new Insets(10d));
		buttonPane.setSpacing(10d);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(startButton, stopButton, clearButton);
		centerPane.setMinSize(500, 500);
		
		mainPane.setTop(buttonPane);
		mainPane.setCenter(centerPane);
		
		pokemonTimeLine.getKeyFrames().add(
			new KeyFrame(Duration.seconds(1d),e->pokemonTimerHandle()));
		pokemonTimeLine.setDelay(Duration.millis(2000d));
		pokemonTimeLine.setCycleCount(Animation.INDEFINITE);
		
		primaryStage.setTitle("JavaFX Timer Demo");
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
