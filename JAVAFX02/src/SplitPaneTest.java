import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;


/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기 
 * @author 김상진 
 * SplitPaneTest.java
 * SplitPane 예제
 */
public class SplitPaneTest extends Application {
	private Stage mainStage;
	private TextArea topArea = new TextArea();
	private TextArea bottomArea = new TextArea();
	private boolean isTop = true;
	
	private void openFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Txt Files", "*.txt"));
		File file = fileChooser.showOpenDialog(mainStage);
		if(file==null) return;
		try(Scanner reader = new Scanner(file)){
			StringBuilder in = new StringBuilder();
			while(reader.hasNextLine()){
				in.append(reader.nextLine()).append("\n");
			}
			if(isTop) {
				topArea.setText(in.toString());
			}
			else {
				bottomArea.setText(in.toString());
			}
			isTop = !isTop;
		}
		catch(FileNotFoundException ex){
			ex.printStackTrace();
		}
	}
	private MenuBar constructMenuBar(){
		MenuItem openMenuItem = new MenuItem("Open File...");
		openMenuItem.setOnAction(e->openFile());
		
		Menu fileMenu = new Menu("File");
		fileMenu.getItems().addAll(openMenuItem);	
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(fileMenu);
		return menuBar;
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		this.mainStage = mainStage;
		
		BorderPane mainPane = new BorderPane();
		SplitPane contentsPane = new SplitPane();
		//contentsPane.setOrientation(Orientation.VERTICAL);
		contentsPane.setOrientation(Orientation.HORIZONTAL);
		
		ScrollPane topPane = new ScrollPane();
		ScrollPane bottomPane = new ScrollPane();
		topPane.setContent(topArea);
		bottomPane.setContent(bottomArea);
		contentsPane.getItems().addAll(topArea,bottomArea);
		
		mainPane.setTop(constructMenuBar());
		mainPane.setCenter(contentsPane);
		
		mainStage.setTitle("SplitPane Test");
		mainStage.setScene(new Scene(mainPane, 400d, 400d));
		//mainStage.setResizable(false); // 크기 조절을 할 수 없도록 
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
