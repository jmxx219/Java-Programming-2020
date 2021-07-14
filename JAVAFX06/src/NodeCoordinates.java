import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * JavaFX 노드의 좌표계
 */
public class NodeCoordinates extends Application {
	private Button moveButton = new Button("move");
	private Button translateButton = new Button("translate");
	private Button animateButton = new Button("animate");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane mainPane = new BorderPane();
		
		Pane centerPane = new Pane();
		Image image = new Image("pikachu.png");
		ImageView iView = new ImageView(image);
		//iView.setX(100d);
		//iView.setY(100d);
		iView.setLayoutX(100d);
		iView.setLayoutY(100d);
		iView.setFitHeight(150d);
		iView.setPreserveRatio(true);
		centerPane.getChildren().add(iView);
		DropShadow dropShadow = new DropShadow(5d, 3d, 3d, Color.STEELBLUE);
		iView.setEffect(dropShadow);
		
		HBox buttonPane = new HBox();
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setSpacing(10d);
		buttonPane.setPadding(new Insets(10d));
		buttonPane.getChildren().addAll(moveButton, translateButton, animateButton);
		moveButton.setOnAction(e->{
			//iView.setX(200d);
			//iView.setY(100d);
			iView.setLayoutX(200d);
			iView.setLayoutY(200d);
			System.out.printf("getX, getY: (%.1f, %.1f)%n", iView.getX(), iView.getY());
			System.out.printf("getLayoutX, getLayoutY: (%.1f,%.1f)%n", iView.getLayoutX(), iView.getLayoutY());
			System.out.println(iView.getLayoutBounds());
			System.out.println(iView.getBoundsInLocal());
			System.out.println(iView.getBoundsInParent());
			System.out.println(iView.localToScreen(iView.getBoundsInLocal()));
		});
		
		translateButton.setOnAction(e->{
			Translate translate = new Translate();
			translate.setX(-50d);
			translate.setY(+50d);
			translate.setZ(0d);
			iView.getTransforms().add(translate);
			System.out.printf("getX, getY: (%.1f, %.1f)%n", iView.getX(), iView.getY());
			System.out.printf("getLayoutX, getLayoutY: (%.1f,%.1f)%n", iView.getLayoutX(), iView.getLayoutY());
			System.out.printf("getTranslateX, getTranslateY: (%.1f,%.1f)%n", iView.getTranslateX(), iView.getTranslateY());
			System.out.println(iView.getLayoutBounds());
			System.out.println(iView.getBoundsInLocal());
			System.out.println(iView.getBoundsInParent());
		});
		
		animateButton.setOnAction(e->{
			TranslateTransition t2 = new TranslateTransition(Duration.millis(1000d),iView);
			t2.setByY(-100d);
			t2.play();
			t2.setOnFinished(ee->{
				System.out.printf("getX, getY: (%.1f, %.1f)%n", iView.getX(), iView.getY());
				System.out.printf("getLayoutX, getLayoutY: (%.1f,%.1f)%n", iView.getLayoutX(), iView.getLayoutY());
				System.out.printf("getTranslateX, getTranslateY: (%.1f,%.1f)%n", iView.getTranslateX(), iView.getTranslateY());
				System.out.println(iView.getLayoutBounds());
				System.out.println(iView.getBoundsInLocal());
				System.out.println(iView.getBoundsInParent());
			});
		});
		
		mainPane.setCenter(centerPane);
		mainPane.setBottom(buttonPane);
		System.out.printf("getX, getY: (%.1f, %.1f)%n", iView.getX(), iView.getY());
		System.out.printf("getLayoutX, getLayoutY: (%.1f, %.1f)%n", iView.getLayoutX(), iView.getLayoutY());
		System.out.println(iView.getLayoutBounds());
		System.out.println(iView.getBoundsInLocal());
		System.out.println(iView.getBoundsInParent());
		primaryStage.setTitle("JavaFX Node Coordinates");
		primaryStage.setScene(new Scene(mainPane,300,400));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
