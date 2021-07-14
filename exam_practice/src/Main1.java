import java.util.Scanner;

// Integer.MIN_VALUE <= N <= Integer.MAX_VALUE
// Integer.MIN_VALUE Ư���� ó�����ְ�, ������ Math.abs() --> ��� --> ���� �˰������� ó��
// N == Integer.MIN_VALUE�̸� ������ ���ڰ� 8�̶�� ���� �˱� ������ �̸� Ȱ��

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
// ����
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
