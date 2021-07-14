import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기 
 * @author 김상진
 * 정규 표현식: Pattern, Matcher, String의 split
 */
public class RegularExpressionTest {
	
	public static void simpleTest01() {
		System.out.println("Simple Test1");
		String input = " a ab abc abcd ";
		Pattern p = Pattern.compile(
			"ab?c?d?"
			//"abcd|abc|ab|a"
		);
		Matcher m = p.matcher(input);
		int count = 0;
		while(m.find()){
			++count;
			System.out.print(m.group()+", ");
		}
		System.out.println(count);
	}
	public static void simpleTest02() {
		System.out.println("Simple Test2");
		String input = "aaaab ab aaab b cacaab";
		String[] words = input.split("\\s");
		for(String s: words) {
			//if(s.matches("a+b")) System.out.println(s);
			//if(s.matches("a*b")) System.out.print(s+", ");
			if(s.matches("a{3}b")) System.out.print(s+", ");
		}
		System.out.println();
	}
	public static void simpleTest03() {
		System.out.println("Simple Test2");
		String input = "apple grape banana cherry melon";
		String[] words = input.split("\\s");
		for(String s: words) {
			//if(s.matches(".....")) System.out.println(s);
			//if(s.matches("[^a]\\w+")) System.out.print(s+", ");
			//if(s.matches("[a|b]\\w+")) System.out.print(s+", ");
			if(s.matches("\\w*[^e]")) System.out.print(s+", "); //e로 끝나지 않는 것
		}
		System.out.println();
	}
	public static void simpleTest04() {
		System.out.println("Simple Test3");
		String input = "apple grape banana cherry melon";
		Pattern p = Pattern.compile("\\b.{5}\\b");
		Matcher m = p.matcher(input);
		int count = 0;
		while(m.find()){
			++count;
			System.out.print(m.group()+", ");
		}
		System.out.println(count);
	}
	public static void boundaryTest() {
		System.out.println("Boundary Test(is): This island is beautiful.");
		String input = "This island is beautiful.";
		Pattern p = Pattern.compile("is");
		Matcher m = p.matcher(input);
		System.out.println("Without Boundary Test");		
		while(m.find()){
			System.out.print(m.group()+", ");
		}
		System.out.println();
		p = Pattern.compile("\\bis");
		m = p.matcher(input);
		System.out.println("Start Boundary Test");		
		while(m.find()){
			System.out.print(m.group()+", ");
		}
		System.out.println();
		p = Pattern.compile("\\bis\\b");
		m = p.matcher(input);
		System.out.println("Start, End Boundary Test");		
		while(m.find()){
			System.out.print(m.group()+", ");
		}
		System.out.println();
		
	}
	public static void matchingWordOfLength5() {
		String fruits = "apple xxx grape kiwi banana melon cherry mango";
		//Pattern p = Pattern.compile("\\b\\w{5}\\b");
		Pattern p = Pattern.compile("\\b[^\\s]{5}\\b");
		Matcher m = p.matcher(fruits);
		while(m.find()) {
			System.out.print(m.group()+", ");
		}
		System.out.println();
	}
	public static void phoneTest() {
		System.out.println("phone number test");
		String input = "010-6450-4378 (010)6450-4378";
		Pattern p = Pattern.compile("\\d{3}-\\d{4}-\\d{4}|\\(\\d{3}\\)\\d{4}-\\d{4}");
		Matcher m = p.matcher(input);
		while(m.find()){
			System.out.println(m.group()+", ");
		}
	}
	public static void emailTest() {
		System.out.println("email test");
		String input = "sangjin.kim@koreatech.ac.kr";
		Pattern p = Pattern.compile("\\w+(\\.\\w+)*@\\w+(\\.\\w+)*");
		Matcher m = p.matcher(input);
		if(m.matches()){
			System.out.println("Correct email");
		}
	}
	public static void romanNumericTest01() {
		System.out.println("Roman Numeric Test");
		String input = "I II III IV V VI VII VIII IX X";
		Pattern p = Pattern.compile("I([XV]|I{0,3})|V(I{0,3})|X");
		Matcher m = p.matcher(input);
		while(m.find()){
			System.out.print(m.group()+", ");
		}
		System.out.println();
	}
	public static void romanNumericTest02() {
		System.out.println("Roman Numeric Test");
		String input = "I II III IV V VI VII VIII IX X XXXIX CCXLVI CDXXI CLX CCVII";
		Pattern p = Pattern.compile(
			"(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})"
			//"M?(C([MD]|C{0,3})|D(C{0,3}))?"+
			//"(X([LC]|X{0,3})|L(X{0,3}))?"+
			//"(I([XV]|I{0,3})|V(I{0,3}))?"
		);
		Matcher m = p.matcher(input);
		while(m.find()){
			System.out.print(m.group()+", ");
		}
		System.out.println();
	}
	public static void splitTest() {
		System.out.println("Split test");
		
		String[] operands = "2000-300+500".split("\\+|\\-");
		String[] operators = "-2000-300+500".split("[0-9]+");
		
		System.out.println(Arrays.toString(operands));
		System.out.println(Arrays.toString(operators));
	}
	public static void stringTokenizerTest() {
		System.out.println("String Tokenizer Test");
		
		StringTokenizer tokenizer 
			= new StringTokenizer("2000-300+500","+-");
		while(tokenizer.hasMoreTokens()){
			System.out.println(tokenizer.nextToken());
		}
	}
	public static void main(String[] args) {
		//simpleTest01();
		//simpleTest02();
		//simpleTest03();
		simpleTest04();
		//boundaryTest();
		//matchingWordOfLength5();
		//phoneTest();
		//emailTest();
		//romanNumericTest01();
		//romanNumericTest02();
		//splitTest();
		//stringTokenizerTest();
	}

}
