import java.util.Scanner;

// Integer.MIN_VALUE <= N <= Integer.MAX_VALUE
// Integer.MIN_VALUE 특별히 처리해주고, 나머지 Math.abs() --> 양수 --> 동일 알고리즘으로 처리
// N == Integer.MIN_VALUE이면 마지막 숫자가 8이라는 것을 알기 때문에 이를 활용

public class Main1 {
	public static int solve(int num, int digit) {
		if(digit==0&&num==0) return 1;
		int count = 0;
		while(num!=0) {
			int n = Math.abs(num%10);
			if(n==digit) ++count;
			num /= 10;
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int num;
		int digit;
		in.nextLine();
		for(int i=0; i < T; i++) {
			num = in.nextInt();
			digit = in.nextInt();
			System.out.println(solve(num, digit));
		}
	}
}


/*
// 모음
import java.util.Scanner;

public class Main {
	public static void solve(String str) {
		int count = 0;

		for(int j=0; j<str.length(); j++) {
			switch(str.charAt(j)) {
			case 'a': case 'e': case 'i': case 'o': case 'u': count++;
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		String str;
		in.nextLine();
		for(int i=0; i < T; i++) {
			str = in.nextLine();
			solve(str);
		}
	}

}*/
