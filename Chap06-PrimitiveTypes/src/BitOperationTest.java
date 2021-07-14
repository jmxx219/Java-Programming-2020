/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기
 * @author 김상진
 * 비트 연산 예제
 * isPowerOf2는 양수일 때만 동작함
 */
public class BitOperationTest {
	// x가 음수일 때도 올바르게 동작함
	public static boolean isOdd(int x) {
		return (x&1)==1;
	}
	public static boolean isPowerOf2V1(int n) {
		while(n%2==0) {
			n/=2;
		}
		return n==1;
	}
	public static boolean isPowerOf2V2(int n) {
		while((n&1)==0) {
			n>>=1;
		}
		return n==1;
	}
	public static boolean isPowerOf2V3(int n) {
		int count = 0;
		for(int i=0; i<32; i++) {
			if((n&1)==1) ++count;
			if(count>=2) return false; 
			n >>>= 1;
		}
		return true;
	}
	public static boolean isPowerOf2V4(int n) {
		return (n!=0) && ((n&(n-1))==0);
	}
	public static void testIsPowerOf2() {
		System.out.println("1 is power of 2: "+isPowerOf2V2(1));
		System.out.println("2 is power of 2: "+isPowerOf2V2(2));
		System.out.println("4 is power of 2: "+isPowerOf2V2(4));
		System.out.println("256 is power of 2: "+isPowerOf2V2(256));
		System.out.println("255 is power of 2: "+isPowerOf2V2(255));
		System.out.println("13 is power of 2: "+isPowerOf2V2(13));
		System.out.println("0x40000000 is power of 2: "+isPowerOf2V2(0x40000000));
		
	}
	public static void main(String[] args) {
		testIsPowerOf2();
	}
}
