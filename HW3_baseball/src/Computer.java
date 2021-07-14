/*
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 손지민
 * Computer 클래스
 */
import java.util.concurrent.ThreadLocalRandom;

// 컴퓨터 클래스
public class Computer {
	private int[] ball = new int[3];
	
	Computer(){
		for (int i = 0; i < 3; i++) {	// 랜덤함수를 이용하여 ball 초기화
			ball[i] = ThreadLocalRandom.current().nextInt(10);
		}
	}

	public int[] getBall() {	// ball을 반환하는 getter
		return ball;
	}
	
	public void pitch() {	// ball의 값을 flag의 인덱스로 하여, 해당 인덱스에는 1을 대입하는 메소드
		int[] flag = new int[10];
		for (int i = 0; i < 3; i++) {
			while (true) {
				if (flag[ball[i]] == 0) {
					flag[ball[i]] = 1;
					break;
				}
			}
		}
	}
}
