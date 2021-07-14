
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * 타이머 이벤트 처리 (이벤트 발생마다 물체 움직임)
 * 옛날 방식
 */
public class TimerTest01 extends Application {
	private DrawingBoard board = new DrawingBoard();
	private Timeline shipTimeLine = new Timeline();
	private Timeline missileTimeLine = new Timeline();
	/*
	private KeyFrame shipFrame;
	private KeyFrame missileFrame;
	public void timerHandle(ActionEvent event) {
		Object source = event.getSource();
		if(source == shipFrame){
			board.moveShip();
		}
		else if(source == missileFrame){
			if(board.moveMissile()){
				missileTimeLine.stop();
				shipTimeLine.stop();
				board.clear();
			}
		}
	}
	*/
	public void shipTimerHandle() {
		board.moveShip();
	}
	public void missileTimerHandle() {
		if(board.moveMissile()){
			missileTimeLine.stop();
			shipTimeLine.stop();
			board.clear();
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {		
		
		//두 가지 타이머를 하나의 메소드에서 처리할 수도 있음
		//shipTimeLine.getKeyFrames().add(
		//		new KeyFrame(Duration.millis(750),e->timerHandle(e)));
		shipTimeLine.getKeyFrames().add(
			new KeyFrame(Duration.millis(750),e->shipTimerHandle()));
		shipTimeLine.setCycleCount(Animation.INDEFINITE);
		//shipFrame = shipTimeLine.getKeyFrames().get(0);
		
		missileTimeLine.getKeyFrames().add(
			new KeyFrame(Duration.millis(500),e->missileTimerHandle()));
		missileTimeLine.setCycleCount(Animation.INDEFINITE);
		//missileFrame = missileTimeLine.getKeyFrames().get(0);
		
		shipTimeLine.play();
		missileTimeLine.play();
		
		primaryStage.setTitle("JavaFX Timer Demo");
		primaryStage.setScene(new Scene(board,300,400));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
