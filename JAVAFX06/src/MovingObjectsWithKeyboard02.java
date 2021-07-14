import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기 
 * @author 김상진
 * 키보드 이벤트 처리
 * TranslateTransition 이용
 */
public class MovingObjectsWithKeyboard02 extends Application {
	private ImageView iView = new ImageView();
	private static final int IMAGESIZE = 80;
	private int xLoc = 160;
	private int yLoc = 160;
	
	private void keyPressed(KeyEvent event) {	
		switch(event.getCode()){
		case LEFT: if(xLoc>0) xLoc -= IMAGESIZE; iView.setX(xLoc);  break;
		case RIGHT: if(xLoc<320) xLoc += IMAGESIZE; iView.setX(xLoc); break;
		case UP: if(yLoc>0) yLoc -= IMAGESIZE; iView.setY(yLoc); break;
		case DOWN: if(yLoc<320) yLoc += IMAGESIZE; iView.setY(yLoc); break;
		default:
			break;
		}
		event.consume(); 
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		Pane imagePane = new Pane();
		Line[] vLines = new Line[4];
		Line[] hLines = new Line[4];
		for(int i=0; i<vLines.length; i++) {
			vLines[i] = new Line((i*80)+80,0,(i*80)+80,400);
			vLines[i].setStroke(Color.BLUE);
			hLines[i] = new Line(0,(i*80)+80,400,(i*80)+80);
			hLines[i].setStroke(Color.BLUE);
		}
		imagePane.getChildren().addAll(vLines);
		imagePane.getChildren().addAll(hLines);
		
		Image image = new Image("totodile.png");
		BorderPane mainPane = new BorderPane();
		iView.setImage(image);
		iView.setX(IMAGESIZE*2);
		iView.setY(IMAGESIZE*2);
		iView.setFitWidth(IMAGESIZE);
		iView.setPreserveRatio(true);
		imagePane.getChildren().add(iView);
		mainPane.setCenter(imagePane);
		
		mainPane.setOnKeyPressed(e->keyPressed(e));
		mainStage.setTitle("JavaFX Keyboard Event Handle");
		mainStage.setScene(new Scene(mainPane,IMAGESIZE*5,IMAGESIZE*5));
		mainStage.show();
		mainStage.setResizable(false);
		mainPane.requestFocus();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
