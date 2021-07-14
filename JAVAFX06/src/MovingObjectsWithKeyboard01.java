import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기 
 * @author 김상진
 * 키보드 이벤트 처리
 * AnimationTimer 이용
 */
public class MovingObjectsWithKeyboard01 extends Application {
	private ImageView iView = new ImageView();
	private static final int IMAGESIZE = 80;
	private boolean goUp = false;
	private boolean goDown = false;
	private boolean goLeft = false;
	private boolean goRight = false;
	
	private class MovementTimer extends AnimationTimer{
		private static final double delta = 5;
		@Override
		public void handle(long now) {
			if(goUp&&iView.getY()>0) iView.setY(iView.getY()-delta);
			if(goDown&&iView.getY()<320) iView.setY(iView.getY()+delta);
			if(goLeft&&iView.getX()>0) iView.setX(iView.getX()-delta);
			if(goRight&&iView.getX()<320) iView.setX(iView.getX()+delta);
		}
	}
	
	private void keyReleased(KeyEvent event) {
		switch(event.getCode()){
		case LEFT: goLeft = false; break;
		case RIGHT: goRight = false; break;
		case UP: goUp = false; break;
		case DOWN: goDown = false; break;
		default:
			break;
		}
		event.consume(); 
	}
	private void keyPressed(KeyEvent event) {	
		switch(event.getCode()){
		case LEFT: goLeft = true; break;
		case RIGHT: goRight = true; break;
		case UP: goUp = true; break;
		case DOWN: goDown = true; break;
		default:
			break;
		}
		event.consume(); 
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		Pane imagePane = new Pane();
		// Pane의 배경 그림이나 배경색 추가하기 
		// 배경 색이나 그림을 사용할 경우 그 위에 움직이는 이미지는 투명 이미지이어야 함
		imagePane.setBackground(
			new Background(new BackgroundFill(new ImagePattern(new Image("space.jpg")), CornerRadii.EMPTY, Insets.EMPTY)));
		Image image = new Image("totodile.png");
		BorderPane mainPane = new BorderPane();
		iView.setImage(image);
		iView.setX(IMAGESIZE*2);
		iView.setY(IMAGESIZE*2);
		iView.setFitWidth(IMAGESIZE);
		iView.setPreserveRatio(true);
		imagePane.getChildren().add(iView);
		mainPane.setCenter(imagePane);
		
		MovementTimer movementTimer = new MovementTimer();
		movementTimer.start();
		mainPane.setOnKeyPressed(e->keyPressed(e));
		mainPane.setOnKeyReleased(e->keyReleased(e));
		mainStage.setTitle("JavaFX Keyboard Event Handle");
		mainStage.setScene(new Scene(mainPane,IMAGESIZE*5,IMAGESIZE*5));
		mainStage.show();
		mainStage.setResizable(false);
		mainPane.requestFocus();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
