import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진  
 * 마우스 이벤트 처리 (왼쪽/오른쪽 버튼)
 */
public class MouseTest00 extends Application {
	private ImageView iView = new ImageView();
	private int xLoc = 160;
	private int yLoc = 160;
	private static final int IMAGESIZE = 80;
	private void mouseHandle(MouseEvent mouseEvent) {	
		MouseButton mouseButton = mouseEvent.getButton();
		if(mouseButton==MouseButton.PRIMARY){ 
			System.out.println("Left Button"); 
		}
		else if(mouseButton==MouseButton.SECONDARY){ 
			System.out.println("Right Button"); 
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane mainPane = new Pane();
		Image image = new Image("bulbasaur.png");
		iView.setImage(image);
		iView.setX(xLoc);
		iView.setY(yLoc);
		iView.setFitWidth(IMAGESIZE);
		iView.setPreserveRatio(true);
		mainPane.getChildren().add(iView);

		mainPane.setOnMouseClicked(e->mouseHandle(e));
		primaryStage.setTitle("JavaFX Mouse Event Handle");
		primaryStage.setScene(new Scene(mainPane, IMAGESIZE*5, IMAGESIZE*5));
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
