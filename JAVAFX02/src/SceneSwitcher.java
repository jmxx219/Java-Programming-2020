import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기 
 * @author 김상진 
 * SceneSwitcher.java
 * Stage의 Scene 변경하기 예제
 * SplitPane 예제
 */
public class SceneSwitcher extends Application {
	private Stage mainStage;
	private Scene sceneWithEevee = constructEeveeScene();
	private Scene sceneWithDragonAir = constructDragonAirScene();
	private boolean eeveeSceneFlag = false;
	
	private void changeScene() {
		if(eeveeSceneFlag)
			mainStage.setScene(sceneWithEevee);
		else
			mainStage.setScene(sceneWithDragonAir);
		eeveeSceneFlag = !eeveeSceneFlag;
	}
	
	public MenuBar constructMenuBar(){
		MenuItem changeSceneMenuItem = new MenuItem("Change Scene");
		changeSceneMenuItem.setOnAction(e->changeScene());

		Menu fileMenu = new Menu("Window");
		fileMenu.getItems().addAll(changeSceneMenuItem);	
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(fileMenu);
		return menuBar;
	}
	
	private Scene constructEeveeScene() {
		//System.out.println("eevee");
		
		StackPane leftPane = new StackPane();
		StackPane rightPane = new StackPane();
		leftPane.setMinWidth(200d);
		Circle circle = new Circle(100d,100d,50d);
		circle.setFill(Color.YELLOW);
		leftPane.getChildren().add(circle);
		
		
		Image eImg = new Image("eevee.png");
		ImageView eView = new ImageView(eImg);
		eView.setFitWidth(200d);
		eView.setPreserveRatio(true);
		
		rightPane.getChildren().add(eView);
		
		SplitPane contentsPane = new SplitPane();
		contentsPane.getItems().addAll(leftPane, rightPane);
		//contentsPane.getDividers().get(0).setPosition(0);
		
		BorderPane mainPane = new BorderPane();
		mainPane.setTop(constructMenuBar());
		mainPane.setCenter(contentsPane);
		return new Scene(mainPane);
	}
	private Scene constructDragonAirScene() {
		//System.out.println("dragon");
		
		StackPane leftPane = new StackPane();
		Circle circle = new Circle(100d,100d,50d);
		circle.setFill(Color.CYAN);
		leftPane.getChildren().add(circle);
		Image dImg = new Image("dragonair.png");
		ImageView dView = new ImageView(dImg);
		dView.setFitWidth(200d);
		dView.setPreserveRatio(true);
		
		SplitPane contentsPane = new SplitPane();
		contentsPane.setOrientation(Orientation.VERTICAL);
		contentsPane.getItems().addAll(leftPane, dView);
		
		BorderPane mainPane = new BorderPane();
		mainPane.setTop(constructMenuBar());
		mainPane.setCenter(contentsPane);
		return new Scene(mainPane);
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		this.mainStage = mainStage;
		mainStage.setTitle("Scene Switch App");
		mainStage.setScene(sceneWithEevee);
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
