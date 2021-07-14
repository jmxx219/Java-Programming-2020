import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기 
 * @author 김상진 
 * TabPaneTest.java
 * TabPane 예제
 * 이미지 파일을 열 때마다 새 탭이 추가됨
 */
public class TabPaneTest extends Application {
	private Stage mainStage;
	private TabPane contentsPane = new TabPane();
	
	private void openImage() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(
			new ExtensionFilter("Image Files", "*.png", "*.jpg", ".jpeg", "*.gif", "*.bmp"));
		File file = fileChooser.showOpenDialog(mainStage);
		if(file==null) return;
		try {
			FileInputStream inputStream = new FileInputStream(file);
			Image image = new Image(inputStream);
			ImageView iView = new ImageView(image);
			iView.setFitWidth(200d);
			iView.setPreserveRatio(true);
			StackPane pane = new StackPane();
			pane.getChildren().add(iView);
			
			Tab tab = new Tab();
			tab.setText(file.getName());
			tab.setContent(pane);
			contentsPane.getTabs().add(tab);
			contentsPane.getSelectionModel().select(tab);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private MenuBar constructMenuBar(){
		MenuItem openMenuItem = new MenuItem("Open File...");
		openMenuItem.setOnAction(e->openImage());
		
		Menu fileMenu = new Menu("File");
		fileMenu.getItems().addAll(openMenuItem);	
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(fileMenu);
		return menuBar;
	}
	
	@Override
	public void start(Stage mainStage){
		this.mainStage = mainStage;
		BorderPane mainPane = new BorderPane();
		mainPane.setTop(constructMenuBar());
		mainPane.setCenter(contentsPane);
		mainStage.setTitle("TabPane Test");
		mainStage.setScene(new Scene(mainPane, 300d, 400d));
		mainStage.show();
		//mainStage.setResizable(false);
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
