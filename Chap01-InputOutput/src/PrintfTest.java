import java.time.LocalDate;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * PrintfTest 클래스
 */
public class PrintfTest {
	/**
	 * %,d 테스트, 인자 번호 테스트
	 */
	public static void currencyOutput() {
		int price = 5_000;
		String coffee = "바닐라라떼";
		System.out.printf("%2$s: %1$,d원%n", price, coffee);
	}
	/**
	 * 날짜 테스트, 인자 번호 테스트
	 */
	public static void dateOutput() {
		System.out.printf("%tF%n", LocalDate.now());
		System.out.printf("%1$tY %1$tm %1$te%n", LocalDate.now());
	}
	public static void main(String[] args) {
		currencyOutput();
		dateOutput();
	}
}
