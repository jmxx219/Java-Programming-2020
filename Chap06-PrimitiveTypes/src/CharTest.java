/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기
 * @author 김상진
 * 문자 타입 예제
 */
public class CharTest {
	public static void foo(int n) {
		System.out.println("foo: int");
	}
	public static void foo(char c) {
		System.out.println("foo: char");
	}
	public static void foo() {
		foo('a'+'z');
	}
	public static char nextChar(char c) {
		return (char)(c+1);
	}
	public static void nextCharTest() {
		System.out.println(nextChar('A'));
		System.out.println(nextChar('c'));
		System.out.println(nextChar('3'));
	}
	public static void varTest() {
		var x = 'a'+2;
		char y = 'b'+3;
		System.out.println(x);
		System.out.println(y);
		y = 100+5;
		System.out.println(y);
	}
	public static void integralTypeTest() {
		char n = (char)-10;
		char c = 97;
		System.out.println((int)n);
		System.out.println(c);
	}
	public static void main(String[] args) {
		//foo();
		//nextCharTest();
		varTest();
		//integralTypeTest();
	}

}
