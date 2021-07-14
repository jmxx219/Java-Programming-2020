import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진 
 * 마우스 이벤트 처리 (Translate Transition 이용 마우스 클릭한 곳으로 이미지 움직)
 * 질문. Path Transition과의 차이점은?
 */
public class MovingObjectsWithMouse01 extends Application {
	private ImageView iView = new ImageView();
	// 초기 위치
	private int xLoc = 160;
	private int yLoc = 160;
	private static final int IMAGESIZE = 80;
	
	private double getDistance(double sourceX, double sourceY, double destX, double destY) {
		double diffY =  Math.abs(sourceY-destY);
		double diffX =  Math.abs(sourceX-destX);
		return Math.sqrt(diffX*diffX+diffY*diffY);
	}
	
	private void mouseHandle(MouseEvent mouseEvent) {	
		double x = mouseEvent.getSceneX();
		double y = mouseEvent.getSceneY(); 
		
		if(x>=IMAGESIZE/2&&x+IMAGESIZE/2<=400&&y>=IMAGESIZE/2&&y+IMAGESIZE/2<=400){
			// 이동 위치와 상관 없이 항상 걸리는 시간을 동일하게 하였을 때의 문제점???
			//final double destX = x-IMAGESIZE/2;
			//final double destY = y-IMAGESIZE/2;
			double destX = x-iView.getBoundsInLocal().getWidth()/2;
			double destY = y-iView.getBoundsInLocal().getHeight()/2;
			double distance = getDistance(iView.getX(),iView.getY(),destX,destY);
			TranslateTransition movementTransition 
				= new TranslateTransition(Duration.millis(distance*2),iView);
				//= new TranslateTransition(Duration.millis(1000d),iView);
			
			// imageView.getBoundsInLocal().getWidth()
			movementTransition.setByX(destX-iView.getX());
			movementTransition.setByY(destY-iView.getY());
			
			movementTransition.setAutoReverse(false);
			movementTransition.setCycleCount(1);
			
			movementTransition.play();
			movementTransition.setOnFinished(e->{
				// transition 종료 후 처리되는 코드
				iView.setX(destX);
				iView.setY(destY);	 
				iView.setTranslateX(0);
				iView.setTranslateY(0);
			});

			/*
			movementTransition.setAutoReverse(true);
			movementTransition.setCycleCount(2);
			movementTransition.play();
			*/
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
		mainPane.setOnMouseClicked(e->mouseHandle(e));
		primaryStage.setTitle("JavaFX Mouse Event Handle");
		primaryStage.setScene(new Scene(mainPane, IMAGESIZE*5, IMAGESIZE*5));
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
