import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 파일명: Effects.java
 * @author 김상진 
 * @version 2020년도 2학기
 * 효과 사용해보기
 */
public class Effects extends Application {
	private Button glowingButton = new Button("Glowing");
	private Button innerShadowButton = new Button("Shadow on");
	private Button dropShadowButton = new Button("with Shadow");
	private Button blurButton = new Button("blur");
	private Timeline glowTimeLine = new Timeline();
	private Glow glow = new Glow(0.0);
	private boolean toggle = true;
	private double level = 0.0;
	public void handle() {
		level += 0.1;
		if(level>1.0) level = 0.0;
		glow.setLevel(level);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		glowTimeLine.getKeyFrames().add(
				new KeyFrame(Duration.millis(1000),e->handle()));
		glowTimeLine.setCycleCount(Animation.INDEFINITE);
		glowingButton.setEffect(glow);
		InnerShadow innerShadow = new InnerShadow(10d, Color.RED);
		innerShadowButton.setTooltip(new Tooltip("내부 그림자"));
		innerShadowButton.setEffect(innerShadow);
		innerShadowButton.setOnAction(e->{
			toggle = !toggle;
			if(toggle) innerShadowButton.setEffect(innerShadow); 
			else innerShadowButton.setEffect(null);
		});
		DropShadow dropShadow = new DropShadow(5d, 3d, 3d, Color.STEELBLUE);
		dropShadowButton.setEffect(dropShadow);
		
		BoxBlur boxBlur = new BoxBlur();
		blurButton.setEffect(boxBlur);
		
		FlowPane pane = new FlowPane(10d, 10d);
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(glowingButton, innerShadowButton, dropShadowButton, blurButton);
		primaryStage.setTitle("JavaFX Node Effects");
		primaryStage.setScene(new Scene(pane, 250, 100));
		primaryStage.show();
		glowTimeLine.play();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
