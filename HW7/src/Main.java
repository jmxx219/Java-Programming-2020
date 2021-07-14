import java.util.Scanner;

public class Main {
	public static void solve(String str) {
		StringBuilder result = new StringBuilder();
		String tmp = "";
		boolean isEndSpecial = (str.charAt(str.length()-1)=='#');
		int i=0;
		for(; i<str.length()-2; i++) { 
			if(str.charAt(i+2) != '#') {
				result.append((char)(str.charAt(i) + 48));

			}
			else {
				tmp = String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1));
				int n = Integer.parseInt(tmp) - 10;
				result.append((char)(106 + n));
				i+=2;
			}
		}
		if(!isEndSpecial) {
			if(i==str.length()-2) result.append((char)(str.charAt(str.length()-2) + 48));
			result.append((char)(str.charAt(str.length()-1) + 48));
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		String[] str = new String[T];
		for(int t=0; t<T; t++) {
			str[t] = in.nextLine();
			solve(str[t]);
		}
	}
}

//import java.util.Scanner;
// 
//public class Main {
//    public static void solve(String str) {
//        String result="";
//        String tmp = "";
//        boolean isEndSpecial = (str.charAt(str.length()-1)=='#');
//        int i=0;
//        for(; i<str.length()-2; i++) { 
//            if(str.charAt(i+2) != '#') {
//            	result += (char)(str.charAt(i) + 48);
//            	
//            }
//            else {
//                tmp = String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1));
//                int n = Integer.parseInt(tmp) - 10;
//                result += (char)(106 + n);
//                i+=2;
//            }
//        }
//        if(!isEndSpecial) {
//        	if(i==str.length()-2) result += (char)(str.charAt(str.length()-2) + 48);
//            result += (char)(str.charAt(str.length()-1) + 48);
//        }
//        System.out.println(result);
//    }
// 
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int T = in.nextInt();
//        in.nextLine();
//        String[] str = new String[T];
//        for(int t=0; t<T; t++) {
//            str[t] = in.nextLine();
//            solve(str[t]);
//        }
//    }
//}

