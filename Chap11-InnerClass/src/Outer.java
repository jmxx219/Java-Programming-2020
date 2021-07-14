/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기
 * 클래스 내에 클래스 정의
 * 보통 특정 클래스 내에서만 필요한 간단한 클래스 정의
 * 내부 클래스 객체는 외부 클래스 내에서만 생성이 가능하며,
 * 해당 객체는 자신을 포함하고 있는 외부 객체에 대한 참조를 유지함 
 * static 내부 클래스 객체는 어디서든 생성이 가능하며,
 * 외부 객체에 대한 참조를 유지하지 않음
 * @author 김상진
 */
public class Outer {
	private int oVal;
	private Inner x; 
	private class Inner{
		int iVal;
		Inner(int n){
			iVal = n;
		}
		void f(int n){
			iVal = oVal + n;
			iVal = Outer.this.oVal + n;
		}
	} // class Inner
	public static class SInner{
		int iVal;
		SInner(int n){
			iVal = n;
		}
		void f(int n) {
			//iVal = oVal + n;
		}
		int get() {
			return iVal;
		}
	}
	public Outer(int n1, int n2){
		oVal = n1;
		x = new Inner(n2);
	}
	public void g(int n){
		oVal = x.iVal + n;
		x.f(n);
	}
	public void print(){
		System.out.printf("oVal = %d, iVal = %d%n",
			oVal, x.iVal);
	}

	public static void main(String[] args) {
		Outer obj = new Outer(2, 3);
		// Outer.Inner x = new Outer.Inner(3); // 오류 Inner는 Outer 내에서만
		//Outer.SInner y = new Outer.SInner(3);
		obj.g(3);
		obj.print();
		//System.out.println(y.get());
	}

}
