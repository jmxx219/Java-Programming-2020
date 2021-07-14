/*
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 손지민
 * BaseballTest 클래스
 */

public class BaseballTest {

	public static void main(String[] args) {
		boolean do_ = true;
		
		while(do_) {
			Baseball baseball = new Baseball();
			baseball.playGame();
			do_ = !baseball.user.done();
		}
	}

}
