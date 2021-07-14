import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * 윈도우 크기 변화 처리 (선 그리기) 
 * JavaFX를 이용한 수직, 수평선 그리기
 */
public class WindowEventTest extends Application {
	private Group group = new Group();
	private Scene mainScene = new Scene(group, 600, 600);
	//수평선(0,y,width,y)
	//수직선(x,0,x,height)
	private void heightChangeHandle(ObservableValue<? extends Number> observable, Number oldHeight, Number newHeight){
		// 기존 수직선은 끝 위치만 수정
		for(Node node: group.getChildren()){
			Line line = (Line)node;
			if(line.getStartX()==line.getEndX()) 
				line.setEndY(newHeight.doubleValue());
		}
		// 윈도우가 기존보다 커진 경우에는 새 수평선들을 추가해야 함
		int startX = (oldHeight.intValue()/10)*10;
		for(int i=startX; i<newHeight.intValue(); i+=10){
			Line hLine = new Line(0,i,mainScene.getWidth(),i);
			hLine.setStroke(Color.DARKGRAY);
			group.getChildren().add(hLine);
		}
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		for(int i=10; i<mainScene.getWidth(); i+=10){
			Line vLine = new Line(i,0, i,mainScene.getHeight());
			vLine.setStroke(Color.LIGHTGRAY);
			group.getChildren().add(vLine);
		}
		for(int i=10; i<mainScene.getHeight(); i+=10){
			Line hLine = new Line(0,i, mainScene.getWidth(),i);
			hLine.setStroke(Color.DARKGRAY);
			group.getChildren().add(hLine);
		}		
		primaryStage.setTitle("Simple JavaFX App");
		primaryStage.setScene(mainScene);
		primaryStage.show();
		mainScene.widthProperty().addListener((oV,oWidth,nWidth)->{
			// 기존 수평선은 끝 위치만 수정 
			for(Node node: group.getChildren()){
				Line line = (Line)node;
				if(line.getStartY()==line.getEndY()) 
					line.setEndX(nWidth.doubleValue());
			}
			// 윈도우가 기존보다 커진 경우에는 새 수직선들을 추가해야 함
			int startY = (oWidth.intValue()/10)*10;
			for(int i=startY; i<nWidth.intValue(); i+=10){
				Line vLine = new Line(i,0,i,mainScene.getHeight());
				vLine.setStroke(Color.LIGHTGRAY);
				group.getChildren().add(vLine);
			}
		});
		mainScene.heightProperty().addListener(
			(oV,oHeight,nHeight)->heightChangeHandle(oV,oHeight,nHeight));
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
