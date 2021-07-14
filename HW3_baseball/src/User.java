/*
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 손지민
 * User 클래스
 */
import java.util.Scanner;

//사용자 클래스
public class User {
	private int[] bat = new int[3];
	
	public int[] getBat() {	// bat을 반환하는 getter
		return bat;
	}
	
	@SuppressWarnings("resource")
	public void hit() {	// 사용자로부터 bat을 입력받는 메소드
		Scanner in = new Scanner(System.in);
		
		System.out.printf("[0-9]까지 숫자 3개를 입력하시오: ");
		
		for(int i=0; i<3; i++) {
			bat[i] = in.nextInt();
		}
	}
	
	@SuppressWarnings("resource")
	public boolean done() {	// 사용자의 게임 진행 여부를 입력받는 메소드
		Scanner in = new Scanner(System.in);
		
		String s = null;
		
		while(true) {
			System.out.printf("새 게임(y/n)? ");
			s = in.nextLine().strip().toLowerCase();
			if(s.equals("y")||s.equals("n")) break;
		}
		return (s.equals("n"));
	}
}
