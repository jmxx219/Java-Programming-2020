import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 파일명: Effects.java
 * @author 김상진 
 * @version 2020년도 2학기
 * 효과 사용해보기
 */
public class Transform extends Application {
	private Rectangle rectangle = new Rectangle(50d, 50d, 100d, 100d);
	private Button rotateBtn = new Button("rotate");
	private Button scaleBtn = new Button("scale");
	private Button translateBtn = new Button("translate");
	private Button undoBtn = new Button("undo transform");
	
	private Pane centerPane = new Pane();
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane mainPane = new BorderPane();
		
		HBox buttonPane = new HBox();
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setSpacing(10d);
		buttonPane.setPadding(new Insets(10d));
		buttonPane.getChildren().addAll(rotateBtn, scaleBtn, translateBtn, undoBtn);
		
		centerPane.getChildren().add(rectangle);
		mainPane.setCenter(centerPane);
		mainPane.setBottom(buttonPane);
		
		rectangle.setFill(Color.BURLYWOOD);
		
		primaryStage.setTitle("JavaFX Node Transform");
		primaryStage.setScene(new Scene(mainPane, 500, 500));
		primaryStage.show();
		
		rotateBtn.setOnAction(e->{
			Rotate rotate = new Rotate();
			rotate.setAngle(20d);
			rotate.setPivotX(100d);
			rotate.setPivotY(100d);
			rectangle.getTransforms().add(rotate);
		});
		scaleBtn.setOnAction(e->{
			Scale scale = new Scale();
			scale.setX(1.5);
			scale.setY(1.5);
			scale.setPivotX(100d);
			scale.setPivotY(135d);
			rectangle.getTransforms().add(scale);
		});
		translateBtn.setOnAction(e->{
			Translate translate = new Translate();
			translate.setX(200d);
			translate.setY(100d);
			translate.setZ(0d);
			rectangle.getTransforms().add(translate);
		});
		undoBtn.setOnAction(e->{
			rectangle.getTransforms().clear();
		});
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
