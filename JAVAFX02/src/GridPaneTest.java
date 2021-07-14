import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기 
 * @author 김상진 
 * GridPaneTest.java
 * GridPane 예제
 */
public class GridPaneTest extends Application {
	@Override
	public void start(Stage primaryStage){
		GridPane mainPane = new GridPane();
		// fixed width
		ColumnConstraints column1 = new ColumnConstraints(200d);
		// ColumnConstraints(double minWidth, double prefWidth, double maxWidth)
	    ColumnConstraints column2 = new ColumnConstraints(150d, 200d, 300d);
	    column2.setHgrow(Priority.ALWAYS);
	    mainPane.getColumnConstraints().addAll(column1, column2);
	    RowConstraints row1 = new RowConstraints(150d);
	    RowConstraints row2 = new RowConstraints(150d);
	    mainPane.getRowConstraints().addAll(row1, row2);
	    
		Image eImg = new Image("entei.png");
		ImageView eView = new ImageView(eImg);
		eView.setFitWidth(100d);
		eView.setPreserveRatio(true);
		Image sImg = new Image("hippopotas.png");
		ImageView sView = new ImageView(sImg);
		sView.setFitWidth(100d);
		sView.setPreserveRatio(true);
		mainPane.add(eView, 0, 0);
		GridPane.setHalignment(sView, HPos.LEFT);
		mainPane.add(sView, 1, 0);
		mainPane.add(new Button("Hello"), 2, 0);
		Button appleBtn = new Button("Apple");
		Button bananaBtn = new Button("Banana");
		Button grapeBtn = new Button("Grape");
		GridPane.setValignment(appleBtn, VPos.TOP);
		mainPane.add(appleBtn, 0, 1);
		GridPane.setValignment(bananaBtn, VPos.CENTER);
		mainPane.add(bananaBtn, 1, 1);
		GridPane.setValignment(grapeBtn, VPos.BOTTOM);
		mainPane.add(grapeBtn, 2, 1);
		
		primaryStage.setTitle("Various Pane Test");
		primaryStage.setScene(new Scene(mainPane, 500d, 400d));
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
