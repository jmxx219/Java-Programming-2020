/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 손지민 2019136072
 * Baseball 클래스
 */

// 전체적인 야구 게임을 진행하는 클래스
public class Baseball {
	private int scount = 0;
	private int bcount = 0;
	private int result;
	private int out = 0;
	private Computer computer = new Computer();
	User user = new User();
	
	
	public void playGame() { // 게임 진행 메소드
		computer.pitch();
		while(true) {
			user.hit();
			result = compare(computer.getBall(), user.getBat());
			if (result == 1) {
				System.out.printf("사용자 승\n");
				break;
			}
			else if (result == -1) {
				++out;
				System.out.printf("OUT: %d\n", out);
				if (out == 3) {
					System.out.printf("컴퓨터 승\n");
					break;
				}
			}
		}
	}
	
	public int compare(int[] ball, int[] bat) {	// ball과  bat을 비교하는 메소드
		int[] flag = new int[10];
		scount = 0;
		bcount = 0;
		for (int i = 0; i < 3; i++) flag[ball[i]] = 1;
		for (int i = 0; i < 3; i++) {
			if (ball[i] == bat[i]) ++scount;
			else if (flag[bat[i]] == 1) ++bcount;
		}
		if (scount == 3)
			return 1;
		else if (scount == 0 && bcount == 0) return -1;
		else {
			System.out.printf("S: %d, B: %d\n", scount, bcount);
			return 0;
		}
	}

}
