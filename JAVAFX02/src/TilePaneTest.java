import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기 
 * @author 김상진 
 * TilePaneTest.java
 * 수평과 수직 기반 TilePane 예제
 */
public class TilePaneTest extends Application {

	private ArrayList<ImageView> imageViewList = new ArrayList<>();
	private TilePane tilePane;
	
	private void constructImageViewList() {
		Image pokemon00 = new Image("dragonite.png");
		Image pokemon01 = new Image("golem.png");
		Image pokemon02 = new Image("honchkrow.png");
		Image pokemon03 = new Image("sandslash.png");
		Image pokemon04 = new Image("weavile.png");
		Image pokemon05 = new Image("smeargle.png");
		Image pokemon06 = new Image("entei.png");
		Image pokemon07 = new Image("flygon.png");
		
		imageViewList.add(new ImageView(pokemon00));
		imageViewList.add(new ImageView(pokemon01));
		imageViewList.add(new ImageView(pokemon02));
		imageViewList.add(new ImageView(pokemon03));
		imageViewList.add(new ImageView(pokemon04));
		imageViewList.add(new ImageView(pokemon05));
		imageViewList.add(new ImageView(pokemon06));
		imageViewList.add(new ImageView(pokemon07));
		
		for(var pokemon: imageViewList) {
			pokemon.setFitWidth(100d);
			pokemon.setPreserveRatio(true);
		}
	}
	private void buildHorizontalTilePane() {
		tilePane = new TilePane();
		tilePane.setPadding(new Insets(10d));
		tilePane.setHgap(10d);
		tilePane.setPrefColumns(3);
	}
	private void buildVerticalTilePane() {
		tilePane = new TilePane();
		tilePane.setPadding(new Insets(10d));
		tilePane.setOrientation(Orientation.VERTICAL);
		tilePane.setTileAlignment(Pos.CENTER_LEFT);
		tilePane.setPrefRows(3);
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		constructImageViewList();		
		ScrollPane mainPane = new ScrollPane();
		//buildHorizontalTilePane();
		buildVerticalTilePane();
		for(var pokemon: imageViewList) tilePane.getChildren().add(pokemon);
		mainPane.setContent(tilePane);
		mainStage.setTitle("TilePane Test");
		mainStage.setScene(new Scene(mainPane));
		//mainStage.setResizable(false); // 크기 조절을 할 수 없도록 
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
