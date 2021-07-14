
public class Test {
	public static int reverseNumber(int n) {
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(reverseNumber(12_345));
		System.out.println(reverseNumber(100));
		//System.out.println(reverseNumber(1001));
		System.out.println(reverseNumber(1_234_512_345));
		System.out.println(reverseNumber(-1_234_512_345));
		System.out.println(reverseNumber(2_147_483_647));
		System.out.println(reverseNumber(-2_147_483_648));
		System.out.println(reverseNumber(-12_345));
	}

}
