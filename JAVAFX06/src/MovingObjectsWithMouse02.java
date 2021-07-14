import java.util.concurrent.ThreadLocalRandom;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진  
 * 마우스 이벤트 처리 (Path Transition 이용 마우스 클릭한 곳으로 이미지 움직)
 */
public class MovingObjectsWithMouse02 extends Application {
	private Pane mainPane = new Pane();
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
	
	// 출발지와 목적지 사이에 두 개의 임의의 점 추가 
	private void mouseHandle(MouseEvent mouseEvent) {	
		double destX = mouseEvent.getSceneX();
		double destY = mouseEvent.getSceneY();
		double distance = 0;
		Circle dCircle = new Circle(destX,destY,10);
		mainPane.getChildren().add(dCircle);
		
		if(destX>=IMAGESIZE/2&&destX+IMAGESIZE/2<=400&&
			destY>=IMAGESIZE/2&&destY+IMAGESIZE/2<=400){
			Path path = new Path();
			double prevX = iView.getX()+IMAGESIZE/2;
			double prevY = iView.getY()+IMAGESIZE/2;
			Circle sCircle = new Circle(prevX, prevY, 10);
			mainPane.getChildren().add(sCircle);
			path.getElements().add(new MoveTo(prevX, prevY));
			
			Circle[] circles = new Circle[2];
			for(int i=0; i<2; i++) {
				int x = ThreadLocalRandom.current().nextInt(320)+IMAGESIZE/2;
				int y = ThreadLocalRandom.current().nextInt(320)+IMAGESIZE/2;
				circles[i] = new Circle(x,y,10);
				mainPane.getChildren().add(circles[i]);
				distance  += getDistance(prevX, prevY, x, y);
				path.getElements().add(new LineTo(x,y));
				prevX = x;
				prevY = y;
			}
			distance = getDistance(prevX, prevY, destX, destY);
			path.getElements().add(new LineTo(destX,destY));
			
			//path.getElements().add(new CubicCurveTo(150,150,250,250,x,y));
				
			PathTransition pathTransition = new PathTransition();
			// 이동 위치와 상관 없이 항상 걸리는 시간을 동일하게 하였을 때의 문제점???
			pathTransition.setDuration(Duration.millis(distance*4));
			pathTransition.setPath(path);
			pathTransition.setNode(iView);
			//pathTransition.setOrientation(PathTransition.OrientationType.NONE);
			pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pathTransition.setCycleCount(1);	
			//pathTransition.setCycleCount(Timeline.INDEFINITE);
			pathTransition.setAutoReverse(false);
			pathTransition.play();

			pathTransition.setOnFinished(e->{
				// transition 끝났을 때 실행되는 코드
				iView.setX(destX-IMAGESIZE/2);
				iView.setY(destY-IMAGESIZE/2);	 
				iView.setTranslateX(0);
				iView.setTranslateY(0);
				mainPane.getChildren().remove(sCircle);
				mainPane.getChildren().remove(dCircle);
				mainPane.getChildren().remove(circles[0]);
				mainPane.getChildren().remove(circles[1]);
			});

		}
		
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		Image image = new Image("bulbasaur.png");
		iView.setImage(image);
		iView.setX(xLoc);
		iView.setY(yLoc);
		iView.setFitWidth(IMAGESIZE);
		iView.setPreserveRatio(true);
		mainPane.getChildren().add(iView);
		
		mainPane.setOnMouseClicked(e->mouseHandle(e));
		mainStage.setTitle("JavaFX Mouse Event Handle");
		mainStage.setScene(new Scene(mainPane, IMAGESIZE*5, IMAGESIZE*5));
		mainStage.show();
		mainStage.setResizable(false);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
