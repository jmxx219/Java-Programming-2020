/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기
 * @author 김상진
 * 함수 내에 클래스 정의
 * 특정 함수에서만 필요한 간단한 클래스 정의
 * 이와 같은 클래스는 final 지역변수나 실제적으로 final인 지역변수
 * 사용할 수 있음
 * 여기에 정의된 것과 같은 클래스를 정의하여 사용하는 경우는 없지만
 * 함수형 프로그래밍에서 람다 표현식은 함수 내에 내부 클래스를 정의하는것과 같음
 */
public class MethodInnerClass {
	public static void foo(){
		final int x = 3;
		int y = 2;
		// y = 5;
		class A{
			public int f(){
				// y = 4;
				return x+y+5;
			}
		}
		// y = 5;
		A a = new A();
		System.out.println(a.f());
	}
	public static void main(String[] args) {
		foo();
	}
}
