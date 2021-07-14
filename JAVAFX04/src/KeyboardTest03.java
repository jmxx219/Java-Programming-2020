import java.util.HashMap;
import java.util.Map;

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
import javafx.scene.input.KeyCode;

@FunctionalInterface
interface MoveAction{
	void doMove();
}

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * 키보드 이벤트 처리
 * 화살표 키를 이용하여 노드 이동
 */
public class KeyboardTest03 extends Application {
	private ImageView iView = new ImageView();
	private static final int IMAGESIZE = 80;
	// 초기 위치
	private int xLoc = IMAGESIZE*2;
	private int yLoc = IMAGESIZE*2;
	// 화살표 키가 눌러졌을 때 실행될 함수를 등록하여 사용
	private Map<KeyCode, MoveAction> moveActions = new HashMap<>();
	
	// 각 화살표 키에 따라 해야 할 행동
	public void moveLeft() {
		if(xLoc>0) {
			xLoc -= IMAGESIZE; 
			iView.setX(xLoc);
		}
	}
	public void moveRight() {
		if(xLoc<320) {
			xLoc += IMAGESIZE; iView.setX(xLoc);
		}
	}
	public void moveUp() {
		if(yLoc>0) {
			yLoc -= IMAGESIZE; iView.setY(yLoc);
		}
	}
	public void moveDown() {
		if(yLoc<320) {
			yLoc += IMAGESIZE; iView.setY(yLoc);
		}
	}
	
	public void keyHandle(KeyEvent event) {	
		if(moveActions.containsKey(event.getCode()))
			moveActions.get(event.getCode()).doMove();
		event.consume(); 
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		Pane imagePane = new Pane();
		// Pane의 배경 그림이나 배경색 추가하기 
		// 배경 색이나 그림을 사용할 경우 그 위에 움직이는 이미지는 투명 이미지이어야 함
		imagePane.setBackground(
			//new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			//new Background(new BackgroundFill(Color.BLUE, new CornerRadii(30.0), new Insets(10))));
			new Background(new BackgroundFill(new ImagePattern(new Image("space.jpg")), CornerRadii.EMPTY, Insets.EMPTY)));
		Image image = new Image("totodile.png");
			// = new Image("bulbasaur.png");
		BorderPane mainPane = new BorderPane();
		iView.setImage(image);
		iView.setX(xLoc);
		iView.setY(yLoc);
		iView.setFitWidth(IMAGESIZE);
		iView.setPreserveRatio(true);
		imagePane.getChildren().add(iView);
		mainPane.setCenter(imagePane);
		
		mainPane.setOnKeyPressed(e->keyHandle(e));
		mainStage.setTitle("JavaFX Keyboard Event Handle");
		mainStage.setScene(new Scene(mainPane,IMAGESIZE*5,IMAGESIZE*5));
		mainStage.show();
		mainStage.setResizable(false);
		mainPane.requestFocus();
		
		moveActions.put(KeyCode.LEFT, ()->moveLeft());
		moveActions.put(KeyCode.RIGHT, ()->moveRight());
		moveActions.put(KeyCode.UP, ()->moveUp());
		moveActions.put(KeyCode.DOWN, ()->moveDown());
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
