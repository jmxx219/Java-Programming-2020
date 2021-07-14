import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2020년도 2학기
 * @author 김상진 
 * RadioButtonDemo.java
 * RadioButton 예제
 * ToggleGroup으로 RadioButton들을 그룹핑해 주어야 
 * 여러 개 중 하나만 선택 가능
 */
public class RadioButtonDemoV2 extends Application {
	private RadioButton plainRadioButton = new RadioButton("plain");
	private RadioButton boldRadioButton = new RadioButton("bold");
	private RadioButton italicRadioButton = new RadioButton("italic");
	private RadioButton bothRadioButton = new RadioButton("bold+italic");
	
	private TextField textField = new TextField();
	private Font normalFont = Font.font("Arial", FontPosture.REGULAR, 16);
	private Font boldFont = Font.font("Arial", FontWeight.BOLD, 16);
	private Font italicFont = Font.font("Arial", FontPosture.ITALIC, 16);
	private Font boldItalicFont = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 16);
	
	public void handle(){
		if(bothRadioButton.isSelected())
			textField.setFont(boldItalicFont);
		else if(boldRadioButton.isSelected())
			textField.setFont(boldFont);
		else if(italicRadioButton.isSelected())
			textField.setFont(italicFont);
		else textField.setFont(normalFont);
	}
	@Override
	public void start(Stage mainStage) throws Exception {
		BorderPane mainPane = new BorderPane();
		FlowPane textPane = new FlowPane();
		textPane.setPadding(new Insets(10));
		textPane.setAlignment(Pos.CENTER);
		textField.setText("Korea University of Technology and Education");
		textField.setEditable(false);
		textField.setMinWidth(400);
		textField.setFont(normalFont);
		textPane.getChildren().add(textField);
		
		HBox buttonPane = new HBox();
		buttonPane.setPadding(new Insets(10));
		buttonPane.setSpacing(10);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(plainRadioButton, italicRadioButton, boldRadioButton, bothRadioButton);
		ToggleGroup fontStyleGroup = new ToggleGroup();
		fontStyleGroup.getToggles().addAll(plainRadioButton, italicRadioButton, boldRadioButton, bothRadioButton);
		plainRadioButton.setOnAction(e->handle());
		italicRadioButton.setOnAction(e->handle());
		boldRadioButton.setOnAction(e->handle());
		bothRadioButton.setOnAction(e->handle());
		plainRadioButton.setSelected(true);
		
		mainPane.setCenter(textPane);
		mainPane.setBottom(buttonPane);
		
		mainStage.setTitle("RadioButton Example");
		mainStage.setScene(new Scene(mainPane));
		mainStage.show();
		plainRadioButton.requestFocus();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
