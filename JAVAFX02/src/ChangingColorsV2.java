import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기 
 * @author 김상진 
 * ChangingColors.java
 * 사건 중심과 레이아웃 프로그래밍 예
 * Button 대신에 ToggleButton과 ToggleGroup 활용
 */
public class ChangingColorsV2 extends Application {
	private ToggleButton blueButton = new ToggleButton("Blue");
	private ToggleButton redButton = new ToggleButton("Red");
	private ToggleButton whiteButton = new ToggleButton("White");
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
		
	public void changeBackgroundColor(Object source) {
		if(source==blueButton||source==blueChoice) { 
			centerPane.setBackground(blueBackground);
			blueButton.setSelected(true);
		}
		else if(source==redButton||source==redChoice) { 
			centerPane.setBackground(redBackground);
			redButton.setSelected(true);
		}
		else {
			centerPane.setBackground(whiteBackground);
			whiteButton.setSelected(true);
		}
	}
	
	private MenuBar constructMenuBar(){
		blueChoice.setOnAction(e->changeBackgroundColor(blueChoice));
		redChoice.setOnAction(e->changeBackgroundColor(redChoice));
		whiteChoice.setOnAction(e->changeBackgroundColor(whiteChoice));

		blueChoice.setAccelerator(KeyCombination.keyCombination("shortcut+B"));
		redChoice.setAccelerator(KeyCombination.keyCombination("shortcut+R"));
		whiteChoice.setAccelerator(KeyCombination.keyCombination("SHIFT+CTRL+W"));
		
		Menu colorMenu = new Menu("Change Color");
		colorMenu.getItems().addAll(blueChoice,redChoice,whiteChoice);	
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(colorMenu);
		return menuBar;
	}
	private HBox constructButtonPane() {
		HBox buttonPane = new HBox();
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setPadding(new Insets(10d));
		buttonPane.setSpacing(10d);
		buttonPane.getChildren().addAll(blueButton,redButton,whiteButton);
		return buttonPane;
	}
	
	// Using VBox with BorderPane
	@Override
	public void start(Stage mainStage) throws Exception {
		ToggleGroup buttonGroup = new ToggleGroup();
		buttonGroup.getToggles().addAll(blueButton, redButton, whiteButton);
		buttonGroup.selectedToggleProperty().addListener((c,o,n)->{
			if(c.getValue()==null) return;
			changeBackgroundColor(n);
		});
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
		centerPane.requestFocus();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
