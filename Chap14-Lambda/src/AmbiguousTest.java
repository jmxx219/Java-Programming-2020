import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

public class AmbiguousTest {
	public static void test(BiFunction<String,String,String> joiner){
		String s1 = "Hello";
		String s2 = "World";
		System.out.println(joiner.apply(s1, s2));
	}
	public static void test(IntBinaryOperator intOperation){
		int n1 = 10;
		int n2 = 5;
		System.out.println(intOperation.applyAsInt(n1, n2));
	}
	public static void main(String[] args) {
		//test((x, y) -> x + " " + y);	// error, ambiguous
		//test((x, y) -> x + y); 		// error, ambiguous
		IntBinaryOperator adder = (x,y)->x+y;
		test(adder);
		test((int x, int y)->x+y);
		test((IntBinaryOperator)((x,y)->x+y));
	}
}
