import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
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
 * CheckBoxDemo.java
 * CheckBox 예제
 */
public class CheckBoxDemo extends Application {
	private CheckBox boldCheckBox = new CheckBox("bold");
	private CheckBox italicCheckBox = new CheckBox("italic");
	private TextField textField = new TextField();
	private Font normalFont = Font.font("Arial", FontPosture.REGULAR, 16);
	private Font boldFont = Font.font("Arial", FontWeight.BOLD, 16);
	private Font italicFont = Font.font("Arial", FontPosture.ITALIC, 16);
	private Font boldItalicFont = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 16);
	
	private void handle(){
		if(boldCheckBox.isSelected()&&italicCheckBox.isSelected())
			textField.setFont(boldItalicFont);
		else if(boldCheckBox.isSelected())
			textField.setFont(boldFont);
		else if(italicCheckBox.isSelected())
			textField.setFont(italicFont);
		else textField.setFont(normalFont);
	}
	@Override
	public void start(Stage mainStage) throws Exception {
		BorderPane mainPane = new BorderPane();
		FlowPane textPane = new FlowPane();
		textPane.setPadding(new Insets(10));
		textPane.setAlignment(Pos.CENTER);
		textField.setEditable(false);
		textField.setText("Korea University of Technology and Education");
		textField.setMinWidth(400);
		
		textPane.getChildren().add(textField);
		HBox buttonPane = new HBox();
		buttonPane.setPadding(new Insets(10));
		buttonPane.setSpacing(10);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(boldCheckBox, italicCheckBox);
		boldCheckBox.setOnAction(e->handle());
		italicCheckBox.setOnAction(e->handle());
		boldCheckBox.setSelected(true);
		textField.setFont(boldFont);

		mainPane.setCenter(textPane);
		mainPane.setBottom(buttonPane);
		
		mainStage.setTitle("CheckBox Example");
		mainStage.setScene(new Scene(mainPane));
		mainStage.show();
		
		boldCheckBox.requestFocus();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
