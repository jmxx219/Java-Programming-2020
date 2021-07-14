import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기 
 * @author 김상진
 * FadeTransition, ScaleTransition, RotateTransition 예제
 */
public class TransitionTest extends Application {
	private Button blinkBtn = new Button("blink");
	private Button fadeBtn = new Button("fade");
	private Button rotateBtn = new Button("rotate");
	private Button scaleBtn = new Button("scale");
	private Button fillBtn = new Button("fill");
	private Button strokeBtn = new Button("stroke");
	
	private Pane imagePane = new Pane();
	private Rectangle rectangle = new Rectangle(50d,50d,100d,100d);
	private Circle circle = new Circle(300d,300d,50d);
	private ImageView iView = new ImageView();
	private int xLoc = 160;
	private int yLoc = 160;
	private static final int IMAGESIZE = 80;
	
	void blink() {
		PauseTransition p1 = new PauseTransition(Duration.seconds(0.5));
		p1.setOnFinished(e->iView.setOpacity(0.0));
		PauseTransition p2 = new PauseTransition(Duration.seconds(0.5));
		p2.setOnFinished(e->iView.setOpacity(1.0));
		SequentialTransition sq = new SequentialTransition(p1, p2);
		sq.setCycleCount(10);
		sq.play();
	}
	void fade() {
		FadeTransition ft = new FadeTransition(Duration.seconds(2d), iView);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(2);
		ft.setAutoReverse(true);
		ft.play();
		
		//ft.setOnFinished(e->iView.setOpacity(1.0));
	}
	void scale() {
		ScaleTransition st = new ScaleTransition(Duration.millis(2000d), iView);
		st.setByX(1.5f);
		st.setByY(1.5f);
		st.setCycleCount(2);
		st.setAutoReverse(true);
		st.play();
	}
	void rotate() {
		RotateTransition rt = new RotateTransition(Duration.millis(3000d), iView);
	    rt.setByAngle(360);
	    rt.setCycleCount(1);
	    //rt.setAutoReverse(false);
	    rt.play();
	}
	
	void fill() {
		FillTransition ft = new FillTransition(Duration.seconds(2d), rectangle, Color.BLUE, Color.RED);
		//ft.setCycleCount(3);
		//ft.setAutoReverse(true);
		ft.play();
		ft.setOnFinished(e->rectangle.setFill(null));
	}
	
	void stroke() {
		StrokeTransition st = new StrokeTransition(Duration.seconds(2d), circle, Color.BLUE, Color.RED);
		st.setCycleCount(3);
		st.setAutoReverse(true);
		st.play();
		st.setOnFinished(
			e->circle.setStroke(Color.BLACK)
		);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane mainPane = new BorderPane();
		HBox buttonPane = new HBox();
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setPadding(new Insets(10));
		buttonPane.setSpacing(10);
		buttonPane.getChildren().addAll(blinkBtn,fadeBtn,rotateBtn,scaleBtn,fillBtn,strokeBtn);
		blinkBtn.setOnAction(e->blink());
		fadeBtn.setOnAction(e->fade());
		rotateBtn.setOnAction(e->rotate());
		scaleBtn.setOnAction(e->scale());
		fillBtn.setOnAction(e->fill());
		strokeBtn.setOnAction(e->stroke());
		
		imagePane.setBackground(
				new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		imagePane.setMinSize(400d, 400d);
		Image image = new Image("bulbasaur.png");
		iView.setImage(image);
		iView.setX(xLoc);
		iView.setY(yLoc);
		iView.setFitWidth(IMAGESIZE);
		iView.setPreserveRatio(true);
		
		rectangle.setStroke(Color.BLACK);
		rectangle.setStrokeWidth(2d);
		rectangle.setFill(null);
		
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(3d);
		circle.setFill(null);
		
		imagePane.getChildren().addAll(iView, rectangle, circle);
		
		mainPane.setCenter(imagePane);
		mainPane.setBottom(buttonPane);

		primaryStage.setTitle("JavaFX Various Transition Test");
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
