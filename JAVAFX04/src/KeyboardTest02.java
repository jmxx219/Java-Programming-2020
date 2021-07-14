import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * 키보드 이벤트 처리
 * 화살표 키를 이용하여 노드 이동
 */
public class KeyboardTest02 extends Application {
	private ImageView iView = new ImageView();
	// 초기 위치
	private int xLoc = 160;
	private int yLoc = 160;
	private static final int IMAGESIZE = 80;
	
	// 화살표 키에 따라 객체의 위치를 변경함
	public void keyHandle(KeyEvent event) {	
		switch(event.getCode()){
		case LEFT: if(xLoc>0){ xLoc -= IMAGESIZE; iView.setX(xLoc); }  break;
		case RIGHT: if(xLoc<320){ xLoc += IMAGESIZE; iView.setX(xLoc); } break;
		case UP: if(yLoc>0){ yLoc -= IMAGESIZE; iView.setY(yLoc); } break;
		case DOWN: if(yLoc<320){ yLoc += IMAGESIZE; iView.setY(yLoc); } break;
		default:
		}
		event.consume(); 
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		Pane mainPane = new Pane();
		Image image = new Image("cyndaquil.png");
		iView.setImage(image);
		iView.setX(xLoc);
		iView.setY(yLoc);
		iView.setFitWidth(IMAGESIZE);
		iView.setPreserveRatio(true);
		mainPane.getChildren().add(iView);
		
		mainPane.setOnKeyPressed(e->keyHandle(e));
		mainStage.setTitle("JavaFX Keyboard Event Handle");
		mainStage.setScene(new Scene(mainPane, IMAGESIZE*5, IMAGESIZE*5));
		mainStage.show();
		mainStage.setResizable(false);
		mainPane.requestFocus();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
