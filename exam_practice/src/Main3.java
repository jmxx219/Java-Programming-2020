import java.util.Scanner;

public class Main3 {
	public static void solve(int num) {
		int sum = 1;
		for(int i=2; i<=Math.sqrt(num);i++) {
			if(num%i==0) sum+=i+num/i;
		}
		if(sum==num&&num>1) System.out.println("perfect\n");
		else System.out.println("no perfect\n");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		solve(n);
	}
}
