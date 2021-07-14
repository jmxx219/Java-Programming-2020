
public class FunnyTest {
	public static void main(String[] args) {
		try {
			int d = 0;
			int n = 10;
			System.out.println("Start");
			System.exit(0);
			n = n/d;
		}
		catch(Exception e) {
			System.out.println("Exception Caught");
		}
		finally {
			System.out.println("Finally");
		}
		System.out.println("Program ends");
	}
}
