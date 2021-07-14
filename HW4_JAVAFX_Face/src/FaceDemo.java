import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 파일명: FaceDemo.java
 * @author 손지민 2019136072 
 * @version 2020년도 2학기
 * JavaFX를 이용한 얼굴 그리기
 */
public class FaceDemo extends Application {
	public void start(Stage primaryStage) throws Exception{
		Group group = new Group();
		Face face1 = new Face(100,100);
		Face face2 = new Face(200,200);
		Face face3 = new Face(300,300);
		group.getChildren().addAll(
				face1.getGroup(), face2.getGroup(), face3.getGroup());
		primaryStage.setTitle("Face Demo");
		primaryStage.setScene(new Scene(group, 600d, 600d));
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
