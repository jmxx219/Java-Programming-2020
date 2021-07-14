import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * AnimationTimer를 상속하여 애니메이션 구현
 */
public class MissileAnimation02 extends Application {
	private Group group = new Group();
	private Image missileImg = new Image("missile.png");
	private ImageView mView = new ImageView(missileImg);
	private Image spaceCraftImg = new Image("spacecraft.png");
	private Image explosionImg = new Image("explosion.png"); 
	private ImageView scView = new ImageView(spaceCraftImg);
	private ImageView eView = new ImageView(explosionImg);
	
	public void explode() {
		group.getChildren().clear();
		group.getChildren().add(eView);	
		eView.setX(mView.getX()-(explosionImg.getWidth()-missileImg.getWidth())/2);
		eView.setY(mView.getY()-explosionImg.getHeight()/2);
	}
	
	private class MovementTimer extends AnimationTimer{
		private double delta = 2;
		@Override
		public void handle(long arg0) {
			mView.setY(mView.getY()-(delta*3));
			scView.setX(scView.getX()+delta);
			if(scView.intersects(mView.getBoundsInLocal())) {
				this.stop();
				explode();
			}
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {		
		scView.setX(5);
		scView.setY(50);
		mView.setX(150);
		mView.setY(380);
		group.getChildren().addAll(scView,mView);
		
		MovementTimer movementTimer = new MovementTimer();
		movementTimer.start();
		
		primaryStage.setTitle("JavaFX Timer Demo");
		primaryStage.setScene(new Scene(group,300,400));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
