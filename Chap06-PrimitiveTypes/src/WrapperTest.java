/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기
 * @author 김상진
 * Wrapper 타입 예제
 */
public class WrapperTest {
	public static void foo(Byte b) {
		System.out.println("foo: Byte");
	}
	public static void foo(Number n) {
		System.out.println("foo: Number");
	}
	// Overloading
	// byte: byte, Byte, Number 순
	public static void foo() {
		foo((byte)1);
		foo(2);
		foo((byte)1+(byte)2);
	}
	public static void booleanTest() {
		Boolean b1 = Boolean.valueOf("1");
		Boolean b2 = Boolean.valueOf("0");
		System.out.println(b1||b2);
		b1 = Boolean.valueOf("True");
		b2 = Boolean.valueOf("true");
		System.out.println(b1+", "+b2);
	}
	public static void main(String[] args) {
		booleanTest();
		foo();
	}
}
