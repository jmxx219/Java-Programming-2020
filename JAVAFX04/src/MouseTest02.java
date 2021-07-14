import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진  
 * 마우스 이벤트 처리 (클릭 위치로 이미지 이동)
 */
public class MouseTest02 extends Application {
	private ImageView iView = new ImageView();
	// 시작위치
	private int xLoc = 160;
	private int yLoc = 160;
	private static final int IMAGESIZE = 80;
	private void mouseHandle(MouseEvent mouseEvent) {	
		 double x = mouseEvent.getSceneX();
		 double y = mouseEvent.getSceneY();
		 
		 if(x>=IMAGESIZE/2&&x+IMAGESIZE/2<=400&&y>=IMAGESIZE/2&&y+IMAGESIZE/2<=400){
			 iView.setX(x-IMAGESIZE/2);
			 iView.setY(y-IMAGESIZE/2);
		 }
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		Pane mainPane = new Pane();
		Image image = new Image("bulbasaur.png");
		iView.setImage(image);
		iView.setX(xLoc);
		iView.setY(yLoc);
		iView.setFitWidth(IMAGESIZE);
		iView.setPreserveRatio(true);
		mainPane.getChildren().add(iView);
		
		mainPane.setOnMouseClicked(e->mouseHandle(e));
		mainStage.setTitle("JavaFX Mouse Event Handle");
		mainStage.setScene(new Scene(mainPane, IMAGESIZE*5, IMAGESIZE*5));
		mainStage.show();
		mainStage.setResizable(false);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
