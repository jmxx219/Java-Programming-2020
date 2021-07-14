import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기 
 * @author 김상진 
 * PaneTest.java
 * StackPane과 FlowPane 예제
 */
public class PaneTest extends Application {
	@Override
	public void start(Stage primaryStage){
		//Pane mainPane = new Pane();
		//FlowPane mainPane = new FlowPane();
		StackPane mainPane = new StackPane();
		
		Image eImg = new Image("eevee.png");
		ImageView eView = new ImageView(eImg);
		eView.setFitWidth(100d);
		eView.setPreserveRatio(true);
		Image sImg = new Image("dragonair.png");
		ImageView sView = new ImageView(sImg);
		sView.setFitWidth(100d);
		sView.setPreserveRatio(true);
		mainPane.getChildren().addAll(eView, sView);
				
		primaryStage.setTitle("Various Pane Test");
		primaryStage.setScene(new Scene(mainPane, 500d, 400d));
		primaryStage.show();
		//primaryStage.setResizable(false);
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
