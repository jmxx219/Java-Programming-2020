import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 파일명: DrawCircle.java
 * @author 김상진 
 * @version 2020년도 2학기
 * JavaFX를 이용한 원, 타원 그리기
 */
public class DrawCircle extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Circle c = new Circle(100d,100d,50d);
		c.setStroke(Color.RED);
		c.setStrokeWidth(1.5d);
		c.setFill(null);
		
		Ellipse e = new Ellipse(275d,100d,75d,40d);
		e.setStroke(Color.RED);
		e.setFill(Color.ORANGE);
		e.setStrokeWidth(3d);

		Group group = new Group();
		group.getChildren().addAll(c, e);
		
		primaryStage.setTitle("Draw Circle JavaFX App");
		primaryStage.setScene(new Scene(group, 400d, 200d));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
