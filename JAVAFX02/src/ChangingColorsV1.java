import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기 
 * @author 김상진 
 * ChangingColors.java
 * 사건 중심과 레이아웃 프로그래밍 예
 */
public class ChangingColorsV1 extends Application {
	private Button blueButton = new Button("Blue");
	private Button redButton = new Button("Red");
	private Button whiteButton = new Button("White");
	private MenuItem blueChoice = new MenuItem("Blue");
	private MenuItem redChoice = new MenuItem("Red");
	private MenuItem whiteChoice = new MenuItem("White");
	private Pane centerPane = new Pane();
	private Background whiteBackground =
		new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
	private Background blueBackground =
		new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY));
	private Background redBackground =
		new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY));
	
	/*
	private Canvas canvas = new Canvas(300, 300);
	public void changeBackground(ActionEvent event){
		Object source = event.getSource();
		GraphicsContext gc = canvas.getGraphicsContext2D();
		if(source==blueButton||source==blueChoice) gc.setFill(Color.BLUE);
		else if(source==redButton||source==redChoice) gc.setFill(Color.RED);
		else gc.setFill(Color.WHITE);
		gc.fillRect(0,  0, canvas.getWidth(), canvas.getHeight());
	}
	*/
	
	public void changeToWhiteBackground() {
		centerPane.setBackground(whiteBackground);
	}
	
	public void changeBackground(ActionEvent event){
		Object source = event.getSource();
		if(source==blueButton||source==blueChoice) { 
			centerPane.setBackground(blueBackground);
		}
		else if(source==redButton||source==redChoice) { 
			centerPane.setBackground(redBackground);
		}
		else {
			centerPane.setBackground(whiteBackground);
		}
	}
	
	/*
	// 소스와 연관된 문자열을 이용하여 소스를 판별 (메뉴항과 버튼 이름이 같기 때문에)
	public void changeBackground(ActionEvent event){
		Object source = event.getSource();
		String command = (source instanceof Button)? 
			((Button)source).getText(): ((MenuItem)source).getText();
		switch(command) {
		case "Blue": centerPane.setBackground(blueBackground); break;
		case "Red": centerPane.setBackground(redBackground); break;
		default: centerPane.setBackground(whiteBackground);
		}
	}
	*/

	private MenuBar constructMenuBar(){
		blueChoice.setOnAction(e->changeBackground(e));
		redChoice.setOnAction(e->changeBackground(e));
		whiteChoice.setOnAction(e->changeBackground(e));
		
		blueChoice.setAccelerator(KeyCombination.keyCombination("shortcut+B"));
		redChoice.setAccelerator(KeyCombination.keyCombination("shortcut+R"));
		whiteChoice.setAccelerator(KeyCombination.keyCombination("shortcut+W"));
		
		Menu colorMenu = new Menu("_Change Color");
		colorMenu.setMnemonicParsing(true);
		colorMenu.getItems().addAll(blueChoice,redChoice,whiteChoice);	
		Menu helpMenu = new Menu("_Help");
		helpMenu.setMnemonicParsing(true);
		helpMenu.getItems().add(new MenuItem("Welcome"));
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(colorMenu, helpMenu);
		return menuBar;
	}
	private HBox constructButtonPane() {
		HBox buttonPane = new HBox();
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setPadding(new Insets(10d));
		buttonPane.setSpacing(10d);
		//Region region = new Region();
		//HBox.setHgrow(region, Priority.ALWAYS);
		buttonPane.getChildren().addAll(blueButton,redButton,whiteButton);
		blueButton.setMinWidth(80d);
		redButton.setMinWidth(80d);
		whiteButton.setMinWidth(80d);
		blueButton.setOnAction(e->changeBackground(e));
		redButton.setOnAction(e->changeBackground(e));
		whiteButton.setOnAction(e->changeToWhiteBackground());
		return buttonPane;
	}
	
	
	// Using only BorderPane
	@Override
	public void start(Stage mainStage) throws Exception {
		centerPane.setBackground(whiteBackground);
		centerPane.setMinHeight(300d);
		
		BorderPane mainPane = new BorderPane();
		
		mainPane.setTop(constructMenuBar());
		//mainPane.setCenter(canvas);
		mainPane.setCenter(centerPane);
		mainPane.setBottom(constructButtonPane());
		
		mainStage.setTitle("Changing Colors");
		mainStage.setScene(new Scene(mainPane));
		mainStage.show();
		mainStage.setResizable(false);
		//버튼 클릭 사건 일부로 발생
		//whiteButton.fire();
	}
		
	/*
	// Using VBox with BorderPane
	@Override
	public void start(Stage mainStage) throws Exception {
		BorderPane mainPane = new BorderPane();
		centerPane.setBackground(whiteBackground);
		centerPane.setMinHeight(300d);
		mainPane.setCenter(centerPane);
		mainPane.setBottom(constructButtonPane());
		
		VBox vBox = new VBox(); 
		vBox.getChildren().addAll(constructMenuBar(), mainPane);
	
		mainStage.setTitle("Changing Colors");
		mainStage.setScene(new Scene(vBox));
		mainStage.show();
		mainStage.setResizable(false);
	}
	*/
	public static void main(String[] args) {
		Application.launch(args);
	}
}
