import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * 파일명 Hello.java
 * @author 김상진 
 * @version 2020년도 2학기
 * JavaFX를 이용한 첫 프로그램
 * Label 노드를 이용하여 Hello, World 출력, 폰트 객체 활용
 */
public class Hello extends Application {

	@Override
	public void start(Stage mainStage) throws Exception {
		Label myLabel = new Label("Hello, World");
		myLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16d));
		
		//Group group = new Group();
		//group.getChildren().add(myLabel);
		
		StackPane pane = new StackPane();
		pane.getChildren().add(myLabel);
		
		mainStage.setTitle("JavaFX Hello World App");
		//mainStage.setScene(new Scene(group, 500d, 400d));
		mainStage.setScene(new Scene(pane, 250d, 100d));
		mainStage.show();
		//myLabel.setLayoutX(150-myLabel.getWidth()/2);
		//myLabel.setLayoutY(100-myLabel.getHeight()/2);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
