import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
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
public class Transform3D extends Application {
	private Box box = new Box();
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
		
		centerPane.getChildren().add(box);
		mainPane.setCenter(centerPane);
		mainPane.setBottom(buttonPane);
		
		PhongMaterial material = new PhongMaterial();
		//material.setDiffuseColor(Color.ROYALBLUE);
		material.setDiffuseMap(new Image("wood.jpeg"));
		box.setWidth(150d);
		box.setHeight(150d);
		box.setDepth(150d);
		box.setMaterial(material);
		
		box.setLayoutX(100d);
		box.setLayoutY(100d);
		
		primaryStage.setTitle("JavaFX 3D Node Transform");
		primaryStage.setScene(new Scene(mainPane, 600d, 400d));
		primaryStage.show();
		
		rotateBtn.setOnAction(e->{
			Rotate rxBox = new Rotate(0d, 0d, 0d, 0d, Rotate.X_AXIS); 
			Rotate ryBox = new Rotate(0d, 0d, 0d, 0d, Rotate.Y_AXIS); 
			Rotate rzBox = new Rotate(0d, 0d, 0d, 0d, Rotate.Z_AXIS); 
			rxBox.setAngle(30d); 
			ryBox.setAngle(50d); 
			rzBox.setAngle(30d); 
			box.getTransforms().addAll(rxBox, ryBox, rzBox);
		});
		scaleBtn.setOnAction(e->{
			Scale scale = new Scale();
			scale.setX(1.2);
			scale.setY(1.2);
			scale.setZ(1.2);
			scale.setPivotX(100d);
			scale.setPivotY(135d);
			box.getTransforms().add(scale);
		});
		translateBtn.setOnAction(e->{
			Translate translate = new Translate();
			translate.setX(200d);
			translate.setY(30d);
			translate.setZ(25d);
			box.getTransforms().add(translate);
		});
		undoBtn.setOnAction(e->{
			box.getTransforms().clear();
		});
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
