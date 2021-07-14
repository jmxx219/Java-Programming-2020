import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Baseball {
	/*
	  * Java에서 난수는 ThreadLocalRandom.current() 객체를 이용함 (다른 방법도 있음)
	  * 이를 위해 다음 import문이 필요함
	  * import java.util.concurrent.ThreadLocalRandom;
	  *
	  * 사용 방법은 다음과 같음 nextInt(n)이면 0부터 n-1까지 정수 중 랜덤값 하나를 생성하여 반환함
	  * ball[i] = ThreadLocalRandom.current().nextInt(10); // 0~9
	 */
	public static void pitch(int ball[]) {
		int[] flag = new int[10];
		int i = 0;
		for (i = 0; i < 3; i++) {
			while (true) {
				ball[i] = ThreadLocalRandom.current().nextInt(10);
				if (flag[ball[i]] == 0) {
					flag[ball[i]] = 1;
					break;
				}
			}
		}
	}
	/*
	 * 자바에서는 int compare(int[] ball, int[] bat) 형태로 정의
	 */
	public static int compare(int[] ball, int[] bat) {
		int[] flag = new int[10];
		int scount = 0;
		int bcount = 0;
		int i;
		for (i = 0; i < 3; i++) flag[ball[i]] = 1;
		for (i = 0; i < 3; i++) {
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

	/*
	 * Java 배열
	 * int[] bat = new int[3]; 자동으로 0으로 모두 초기화
	 *
	 * 자바에서 타자 값 입력
	 * for(int i=0; i<3; i++) bat[i] = in.nextInt();
	 */
	public static void playGame() {
		Scanner in = new Scanner(System.in);
		int[] bat = new int[3];
		int[] ball = new int[3];
		int result;
		int out = 0;
		pitch(ball);
		while (true) {
			System.out.printf("[0-9]까지 숫자 3개를 입력하시오: ");
			for(int i=0; i<3; i++) {
				bat[i] = in.nextInt();
			}
			result = compare(ball, bat);
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

	/*
	 * Java
	 * boolean done()
	 * getchar -> in.nextLine를 이용하여 문자열 입력 후 문자열 비교
	 * 예) String s = in.nextLine(); s = s.toLowerCase(); if(s.equals("n"))
	 */
	public static boolean done() {
		Scanner in = new Scanner(System.in);
		
		String s = null;
		System.out.printf("새 게임(y/n)? ");
		
//		s = in.nextLine();
//		s = s.toLowerCase();
//		
//		if(s.equals("n")) return false;
//		
//		return true;
		while(true) {
		 s = in.nextLine().strip().toLowerCase();
			if(s.equals("y")||s.equals("n")) break;
		}
		return (s.equals("n"));
	}
	
	public static void main(String[] args) {
		do {
			playGame();
		} while (done());
		
	}
}
