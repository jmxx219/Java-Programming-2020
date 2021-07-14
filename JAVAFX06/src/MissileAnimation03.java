import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

@FunctionalInterface
interface MyConsumer{
	void doOP();
}

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * Transition을 상속하여 구현
 */
public class MissileAnimation03 extends Application {
	private Image missileImg = new Image("missile.png");
	private ImageView mView = new ImageView(missileImg);
	private Image spaceCraftImg = new Image("spacecraft.png");
	private Image explosionImg = new Image("explosion.png"); 
	private ImageView scView = new ImageView(spaceCraftImg);
	private ImageView eView = new ImageView(explosionImg);
	private ParallelTransition pt;
	
	class SpaceCraftTransition extends Transition{
		private int startX;
		private double distance;
		public SpaceCraftTransition(Duration millis) {
			super();
			setCycleDuration(millis);
			startX = (int)scView.getX();
			distance = 300-startX;
		}
		@Override
		protected void interpolate(double frac) {
			int newX = startX+(int)(distance*frac);
			scView.setX(newX);
		}
	}

	class MissileTransition extends Transition{
		private MyConsumer consumer;
		private int startY;
		private double distance;
		public MissileTransition(Duration millis, MyConsumer consumer) {
			super();
			this.consumer = consumer;
			setCycleDuration(millis);
			startY = (int)mView.getY();
			distance = mView.getY();
		}
		@Override
		protected void interpolate(double frac) {
			int newY = startY-(int)(distance*frac);
			mView.setY(newY);
			if(scView.intersects(mView.getBoundsInLocal())) {
				pt.stop();
				consumer.doOP();
			}
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {		
		scView.setX(5);
		scView.setY(50);
		mView.setX(150);
		mView.setY(380);
		Group group = new Group();
		group.getChildren().addAll(scView,mView);
		
		Transition scTransition
			= new SpaceCraftTransition(Duration.millis(3000));
		Transition mTransition 
			= new MissileTransition(Duration.millis(1800),()->{
			group.getChildren().clear();
			group.getChildren().add(eView);	
			eView.setX(mView.getX()-(explosionImg.getWidth()-missileImg.getWidth())/2);
			eView.setY(mView.getY()-explosionImg.getHeight()/2);
		});
		pt = new ParallelTransition(scTransition, mTransition);
		pt.play();
		
		primaryStage.setTitle("JavaFX Timer Demo");
		primaryStage.setScene(new Scene(group,300,400));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
