/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기
 * @author 김상진
 * 함수 내에 클래스 정의
 * 접근 제어
 * 내부 클래스 멤버들의 접근제어는 외부 클래스에게는 의미가 없음
 * 외부 클래스 멤버들의 접근제어는 내부 클래스에게는 의미가 없음
 *   
 */
class A{
	private int x1;
	protected int x2;
	public int x3;
	int x4;
	
	// A 외부에서 사용할 때 n1, n2, n3, n4의 접근 제어 구분이 의미가 있음 
	public static class B{
		private int n1;
		protected int n2;
		public int n3;
		int n4;
		public void bar() {
			A a = new A();
			a.x1 = 0;
			a.x2 = 0;
			a.x3 = 0;
			a.x4 = 0;
		}
	}
	// private이므로 밖에서는 C 클래스를 사용할 수 없음
	// 따라서 n1, n2, n3, n4의 접근 제어 구분은 무의미함
	private class C{
		private int n1;
		protected int n2;
		public int n3;
		int n4;
		public void bar() {
			x1 = 0;
			x2 = 0;
			x3 = 0;
			x4 = 0;
		}
	}
	public class D{
		private int n1;
		protected int n2;
		public int n3;
		int n4;
		public void bar() {
			x1 = 0;
			x2 = 0;
			x3 = 0;
			x4 = 0;
		}
	}
	
	public void foo() {
		// static 내부 클래스 객체 멤버 변수에 대한 접근
		// 접근 제어가 의미 없음
		B b = new B(); 
		b.n1 = 0;
		b.n2 = 0;
		b.n3 = 0;
		b.n4 = 0;
		// 일반 내부 클래스 객체 멤버 변수에 대한 접근
		// 접근 제어가 의미 없음
		C c = new C(); 
		c.n1 = 0;
		c.n2 = 0;
		c.n3 = 0;
		c.n4 = 0;
	}
}

class E{
	public void foo() {
		// 다른 클래스의 내부 클래스에 대한 접근
		// 접근 권한이 의미가 있음
		A.B b = new A.B();
		//b.n1 = 0;
		b.n2 = 0;
		b.n3 = 0;
		b.n4 = 0;
		/*
		// D는 A 내에서만 생성 가능 
		// A의 멤버 변수, 지역 변수
		A.D d = new A.D(); 
		d.n1 = 0;
		d.n2 = 0;
		d.n3 = 0;
		d.n4 = 0;
		*/
	}
}

public class ClassInnerClass {
	public static void main(String[] args) {
	}
}
