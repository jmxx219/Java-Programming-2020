import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기 
 * @author 김상진 
 * AnchorPaneTest.java
 * AnchorPane 예제
 */
public class AnchorPaneTest extends Application {
	
	@Override
	public void start(Stage mainStage) throws Exception {
		AnchorPane mainPane = new AnchorPane();
		Image hippoImage = new Image("hippopotas.png");
		ImageView hippo = new ImageView(hippoImage);
		hippo.setFitWidth(100d);
		hippo.setPreserveRatio(true);
		Image enteiImage = new Image("entei.png");
		ImageView entei = new ImageView(enteiImage);
		entei.setFitWidth(100d);
		entei.setPreserveRatio(true);
		mainPane.getChildren().addAll(hippo, entei);   // Add grid from Example 1-5
	    AnchorPane.setBottomAnchor(hippo, 5d);
	    AnchorPane.setRightAnchor(hippo, 5d);
	    AnchorPane.setBottomAnchor(entei, 5d);
	    AnchorPane.setLeftAnchor(entei, 5d);
		mainStage.setTitle("AnchorPane Test");
		mainStage.setScene(new Scene(mainPane, 400d, 400d));
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
