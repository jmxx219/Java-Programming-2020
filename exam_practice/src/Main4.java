import java.util.Scanner;

public class Main4 {
	public static int solve(String str) {
		if(str.length()==1) return 0;
		int[] count = new int[26];
		for(int i=0; i<str.length(); i++) {
			++count[(int)(str.charAt(i)-'a')];
		}
		for(int i=0; i<str.length(); i++) {
			if(count[(int)(str.charAt(i)-'a')]==1) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		
		for(int i=0; i<T; i++) {
			String str = in.nextLine();
			System.out.println(solve(str));
		}
	}
}
