import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * 타이머 이벤트 처리 (타이머 대신 TranslateTransition 이용하여 애니메이션 작성)
 * 여러 Transition을 결합하는 Parallel, SequentialTransition 예제
 * 이 예제는 Parallel만 사용
 */
public class MissileAnimation01 extends Application {
	private Image spaceCraftImg = new Image("spacecraft.png");
	private Image explosionImg = new Image("explosion.png"); 
	private Image missileImg = new Image("missile.png");
	private ImageView scView = new ImageView(spaceCraftImg);
	private ImageView mView = new ImageView(missileImg);
	private ImageView eView = new ImageView(explosionImg);
	
	@Override
	public void start(Stage primaryStage) throws Exception {		
		scView.setX(5);
		scView.setY(10);
		mView.setX(80);
		mView.setY(140);
		Group group = new Group();
		group.getChildren().addAll(scView,mView);
		
		final double destX = mView.getX()+missileImg.getWidth()/2-spaceCraftImg.getWidth()/2;
		double destY = scView.getY()+spaceCraftImg.getHeight()-mView.getY()-5;
		TranslateTransition t1 = new TranslateTransition(Duration.millis(1000d),scView);
		t1.setToX(destX);
		
		TranslateTransition t2 = new TranslateTransition(Duration.millis(1000d),mView);
		t2.setByY(destY);
		
		ParallelTransition pt = new ParallelTransition(t1, t2);
		pt.play();
		pt.setOnFinished(e->{
			group.getChildren().clear();
			group.getChildren().add(eView);
			eView.setX(destX);
			eView.setY(scView.getY()+spaceCraftImg.getHeight()-explosionImg.getHeight()/2);
		});
		
		primaryStage.setTitle("JavaFX Timer Demo");
		primaryStage.setScene(new Scene(group,300,400));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
