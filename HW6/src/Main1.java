/*
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
import java.util.Scanner;

public class Main1 {
	public static void solve(int num, int digit) {
		int count = 0;
		if(num < 0) num *= -1;
		String numStr = String.valueOf(num);
		
		for(int i=0; i<numStr.length(); i++) {
			int number = Character.getNumericValue(numStr.charAt(i));
			if(number == digit) count ++;
		}
		
		System.out.println(count);
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
			solve(num, digit);
		}
	}

}
