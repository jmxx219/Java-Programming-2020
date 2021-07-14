import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * 키보드 이벤트 처리
 * 여러 키가 동시에 눌러졌을 때 처리방법
 */
public class KeyboardTest01 extends Application {
	private int count = 0;
	private KeyCode prevCode = KeyCode.ESCAPE;
	private final BooleanProperty aPressed = new SimpleBooleanProperty(false);
	private final BooleanProperty sPressed = new SimpleBooleanProperty(false);
	private final BooleanBinding a_sPressed = aPressed.and(sPressed);
	
	// CTRL+C, A+S 인식
	public void keyHandle01(KeyEvent event) {	
		++count;
		KeyCode currentCode = event.getCode();
		System.out.println(event.getCode()+": "+count);
		if((prevCode==KeyCode.CONTROL&&currentCode==KeyCode.C)|| 
		   (prevCode==KeyCode.C&&currentCode==KeyCode.CONTROL)){
			System.out.println("Ctrl+C: "+count);
			prevCode = KeyCode.ESCAPE;
		}
		else if((prevCode==KeyCode.A&&currentCode==KeyCode.S)|| 
				(prevCode==KeyCode.S&&currentCode==KeyCode.A)){
			System.out.println("A+S: "+count);
			prevCode = KeyCode.ESCAPE;
		}
		else prevCode = currentCode;
		event.consume();
	}
	
	// using isControlDown()
	public void keyHandle02(KeyEvent event) {	
		++count;
		System.out.println(event.getCode()+": "+count);
		if(event.isControlDown()&&event.getCode()==KeyCode.C) {
			System.out.println("Ctrl+C: "+count);
		}
		event.consume();
	}
	
	// BooleanProperty와 BooleanBinding 활용
	public void keyHandle03(KeyEvent event) {	
		++count;
		System.out.println("presseed: "+event.getCode()+": "+count);
		switch(event.getCode()) {
		case A: aPressed.set(true); break;
		case S: sPressed.set(true); break;
		default:
		}
		event.consume();
	}
	public void keyHandle04(KeyEvent event) {	
		++count;
		System.out.println("released: "+event.getCode()+": "+count);
		switch(event.getCode()) {
		case A: aPressed.set(false); break;
		case S: sPressed.set(false); break;
		default:
		}
		event.consume();
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		Pane mainPane = new Pane();
		
		mainPane.setOnKeyPressed(e->keyHandle03(e));
		mainPane.setOnKeyReleased(e->keyHandle04(e));
		a_sPressed.addListener((o,oldV,newV)->{
			if(newV) System.out.println("A+S");
		});
		
		mainStage.setTitle("JavaFX Keyboard Event Handle");
		mainStage.setScene(new Scene(mainPane, 400, 400));
		mainStage.show();
		mainStage.setResizable(false);
		mainPane.requestFocus();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
