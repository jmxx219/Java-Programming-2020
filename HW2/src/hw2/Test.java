package hw2;

public class Test {

	public static void main(String[] args) {
		A a1 = new A(3,5);
		A a2 = new A(4,7);
		A a3 = new A(2,8);
		
		a3 = a1; // 16번째 줄
		a3.setX(2); 
		a1 = a2; 
		a1.setX(6); 
		a2 = a3; 
		
		System.out.println(a1.getX() + ", " + a1.getY()); // 21번째줄
		System.out.println(a2.getX() + ", " + a2.getY());
	}

}
