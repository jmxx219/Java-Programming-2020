import javafx.application.Application;
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
 * 다양한 키보드 사건 구분하기 (누르고 있는 상태, 빠르게 연속 누르기, 보통) 
 */
public class KeyboardTest00 extends Application {
	private KeyCode prevCode = KeyCode.ESCAPE;
	private long prevTime = System.currentTimeMillis();
	private long currTime = 0;
	public void keyHandle(KeyEvent event) {	
		currTime = System.currentTimeMillis();
		long diff = currTime-prevTime;
		System.out.println("지난 키보드 입력 이후 경과된 시간: "+diff);
		prevTime = currTime;
		if(diff<100) {
			System.out.println("누르고 있는 상태");
		}
		else if(diff<250) {
			if(event.getCode()==prevCode)
				System.out.println("같은 키 빠른 연속 누름");
			else System.out.println("다른 키 빠른 연속 누름");
		} 
		else {
			System.out.println("보통");
		}
		prevCode = event.getCode();
		event.consume(); 
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		Pane mainPane = new Pane();
		
		mainPane.setOnKeyPressed(e->keyHandle(e));
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
