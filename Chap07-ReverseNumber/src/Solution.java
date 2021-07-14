
public class Solution {
	public static int reverseNumber(int n) {
		int rev = 0;
		boolean isNegative = (n<0);
		while(n!=0) {
			int currentDigit = Math.abs(n%10);
			if(rev<=(Integer.MAX_VALUE-currentDigit)/10)
				rev = currentDigit+rev*10;
			else {
				return isNegative? Integer.MIN_VALUE: Integer.MAX_VALUE;
			}
			n = n/10;
		}
		return isNegative? -rev: rev;
	}
	public static int reverseNumber_usingLong(int n) {
		long L = n;
		boolean isNegative = (n<0);
		L = Math.abs(L);
		long rev = 0;
		while(L!=0) {
			rev = L%10+rev*10;
			if(rev>=Integer.MAX_VALUE)
				return isNegative? Integer.MIN_VALUE: Integer.MAX_VALUE;
			L /= 10;
		}
		return (int) (isNegative? -rev: rev);
	}
	public static void main(String[] args) {
		System.out.println(reverseNumber(0));
		System.out.println(reverseNumber(12345));
		System.out.println(reverseNumber(100));
		System.out.println(reverseNumber(1_234_512_345));
		System.out.println(reverseNumber(-1_234_512_345));
		System.out.println(reverseNumber(2_147_483_647));
		System.out.println(reverseNumber(-2_147_483_648));
		System.out.println(reverseNumber(-12345));
	}

}
