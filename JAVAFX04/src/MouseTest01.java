import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진  
 * 마우스 이벤트 처리 (이중 클릭 처리)
 */
public class MouseTest01 extends Application {
	private ImageView iView = new ImageView();
	private int xLoc = 160;
	private int yLoc = 160;
	private static final int IMAGESIZE = 80;
	private long currTime = 0;
	private long prevTime = System.currentTimeMillis();
	private boolean isDblClicked = false;
	private int count = 0;
	PauseTransition pt = new PauseTransition(Duration.millis(220));
	// 클릭수만 가지고 이중 클릭 판단
	// 단일 클릭과 이중 클릭의 구분이 명확하지 않음
	private void mouseHandle01(MouseEvent mouseEvent) {	
		if(mouseEvent.getButton()==MouseButton.PRIMARY){ 
			if(mouseEvent.getClickCount()==2){ 
				System.out.println("Double clicked"); 
			}
			else{ 
				System.out.println("Mouse clicked"); 
			}

		} 
	}
	//첫 클릭과 두 번째 클릭 사이의 시간을 이용한 이중 클릭 판단
	private void mouseHandle02(MouseEvent mouseEvent) {	
		System.out.println(++count);
		currTime=System.currentTimeMillis();
		System.out.println(currTime-prevTime);
        isDblClicked = (currTime-prevTime)<=215;
        prevTime = currTime;

		if(isDblClicked){
			System.out.println("double clicked");
			pt.stop();
		}
		else{
			pt.play();
			pt.setOnFinished(e->{
				System.out.println("clicked");
			});
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane mainPane = new Pane();
		Image image = new Image("bulbasaur.png");
		iView.setImage(image);
		iView.setX(xLoc);
		iView.setY(yLoc);
		iView.setFitWidth(IMAGESIZE);
		iView.setPreserveRatio(true);
		mainPane.getChildren().add(iView);

		mainPane.setOnMouseClicked(e->mouseHandle02(e));
		primaryStage.setTitle("JavaFX Mouse Event Handle");
		primaryStage.setScene(new Scene(mainPane, IMAGESIZE*5, IMAGESIZE*5));
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
