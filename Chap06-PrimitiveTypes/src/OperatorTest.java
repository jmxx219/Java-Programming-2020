/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기
 * @author 김상진
 * 연산자 예제
 */
public class OperatorTest {
	public static void incrementTest() {
		int n = 0;
		int a = (++n)+(n--)+n;
		System.out.println(a);
	}
	public static void main(String[] args) {
		incrementTest();
	}

}
