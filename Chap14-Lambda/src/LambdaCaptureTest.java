import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2019년도 2학기
 * @author 김상진
 * 자유변수의 capture
 */
public class LambdaCaptureTest {
	public static void scope_test() {
		int n = 1;
		// 람다에 사용한 매개변수 n과 지역변수와 같은 이름이기 때문에 사용할 수 없음
		//IntPredicate isOdd = n ->  ((n & 1) == 1);  // error
		IntPredicate isOdd = num ->  ((num & n) == 1);
		System.out.println(isOdd.test(3));
	}
	public static void simpleCapture_test() {
		int multiple = 10;
		IntUnaryOperator getMultiple = n -> n*multiple;
		System.out.println(getMultiple.applyAsInt(10));
	}
	public static void forCapture_test() {
		/*
		// 색인변수 capture할 수 없음. 계속 변하기 때문
		for(int i=1; i<=10; i++){
			IntUnaryOperator getMultiple = x -> x*i;	// error
			System.out.println(getMultiple.applyAsInt(1));
		}
		*/
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		// foreach for 문의 변수는 루프마다 고정된 값이기 때문에 capture할 수 있음
		for(int n: array){
			IntUnaryOperator getMultiple = x -> x*n;
			System.out.println(getMultiple.applyAsInt(1));
		}
		
	}
	public static void main(String[] args) {
		scope_test();
		simpleCapture_test();
		forCapture_test();	
	}
}
