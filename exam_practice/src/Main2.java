import java.util.Scanner;

//ÃÖ´ë 69 ¼ö
public class Main2 {
	public static void solve(int num) {
		int ten = 1;
		boolean change = false;
		int result = 0;
		
		while(ten*10<num) {
			ten*=10;
		}
		for(; ten>0; ten/=10) {
			if(num / ten == 6 && !change) {
				result = result*10 + 9;
				change = true;
			}
			else result = result*10 + num/ten;
			num %= ten;
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=0; t<T; t++) {
			int n = in.nextInt();
			solve(n);
		}
	}
}
