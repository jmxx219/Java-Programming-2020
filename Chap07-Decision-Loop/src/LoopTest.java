
public class LoopTest {
	public static void forTest() {
		int i = 0;
		double f = 0.0;
		for(i = 1, f = 1.0; i<10; i++, f += 1.0) {
			System.out.printf("%d; %.2f%n", i, f);
		}
	}
	public static void main(String[] args) {
		forTest();

	}

}
