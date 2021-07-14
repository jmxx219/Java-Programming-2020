/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2019년도 2학기 
 * @author 김상진
 * String 클래스 사용법
 */
public class StringTest {
	// 숫자, 대문자, 소문자 순
	// 문자열이 긴 것이 
	public static void compareToTest() {
		System.out.println("banana".compareTo("apple")>0);
		System.out.println("banana".compareTo("banana")==0);
		System.out.println("banana".compareTo("grape")<0);
		System.out.println("lesson10".compareTo("lesson2")<0);
		System.out.println("Apple".compareTo("apple")<0);
		System.out.println("123".compareTo("apple")<0);
		System.out.println("apples".compareTo("apple")>0);
	}
	public static void primitiveToString() {
		int n = 10;
		String s = ""+n;
		int a = Integer.parseInt(s);
		int b = Integer.valueOf(s);
		int c = Integer.valueOf(s).intValue();
		System.out.println(s+", "+a+", "+b+", "+c);
	}
	public static boolean isPalindrome(String s){
		return s.equals((new StringBuilder(s)).reverse().toString());
	}
	
	public static int charFrequencyUsingFor(String s, int ch){
		char[] list = s.toCharArray();
		int count = 0;
		for(var c: list)
			if(c==ch) ++count;
		return count;
	}
	
	public static int charFrequencyUsingIndexOf(String s, int ch){
		int count = 0;
		int index = s.indexOf(ch);
		while(index!=-1) {
			++count;
			index = s.indexOf(ch, index+1);
		}
		return count;
	}
	
	public static int charFrequencyUsingReplace(String s, int ch){
		String tmp = s.replace(""+(char)ch,"");
		//System.out.println(tmp);
		return s.length()-tmp.length();
	} // charFrequency(String, int)
	
	public static int vowelFrequency(String s){
		int count = 0;
		for(var c: s.toLowerCase().toCharArray()){
			if("aeiou".indexOf(c)!=-1) ++count;
		}
		return count;
	} // charFrequenc(String, int);
	
	public static void startsWith_EndsWith() {
		System.out.println("\nstartsWith, endsWith Test\n");
		String[] fruits = {"apple", "banana", "grape", 
				"kiwi", "melon", "mango"};
		for(String fruit: fruits){
			if(fruit.startsWith("m")) System.out.print(fruit+",");
		}
		System.out.println();
		for(String fruit: fruits){
			if(fruit.endsWith("e")) System.out.print(fruit+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println(charFrequencyUsingFor("banana",'a'));
		System.out.println(charFrequencyUsingIndexOf("banana",'a'));
		System.out.println(charFrequencyUsingReplace("banana",'a'));
		System.out.println(vowelFrequency("banana"));
		System.out.println(isPalindrome("abba"));
		//primitiveToString();
		//compareToTest();
		//startsWith_EndsWith();
	}
}
