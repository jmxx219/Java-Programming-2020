import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * 파일명: DrawPolygon.java
 * @author 김상진 
 * @version 2020년도 2학기
 * JavaFX를 이용한 다각형(삼각형, 오각형) 그리기
 */
public class DrawPolygon extends Application {
	@Override
	public void start(Stage mainStage) throws Exception {
		Polygon triangle = new Polygon();
		triangle.getPoints().addAll(new Double[]{
			100d, 50d,
			50d, 200d,
			150d, 200d});
		triangle.setStroke(Color.RED);
		triangle.setFill(null);
		triangle.setStrokeWidth(3d);

		Polygon pentagon = new Polygon();
		pentagon.getPoints().addAll(new Double[]{
				100.0,250.0,
				52.0, 285.0,
				71.0, 340.0,
				129.0,340.0,
				148.0,285.0		
		});
		pentagon.setStroke(Color.BLUE);
		pentagon.setFill(Color.CYAN);
		pentagon.setStrokeWidth(3d);
		
		Group group = new Group();
		group.getChildren().addAll(triangle, pentagon);
		
		mainStage.setTitle("Draw Polygon JavaFX App");
		mainStage.setScene(new Scene(group, 400d, 500d));
		mainStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
