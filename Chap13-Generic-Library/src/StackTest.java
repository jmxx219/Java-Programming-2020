import java.util.Stack;

/**
 *  한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2020년도 2학기
 *  @author 김상진 
 *  StackTest.java
 *  괄호 검사
 */
public class StackTest {
	public static boolean validParenthesesV1(String exp){	
		if(exp.length()==0) return true;	
		Stack<Character> stack = new Stack<>();	
		for(var c: exp.toCharArray()){		
			switch(c){		
			case '(': case '{': case '[':			
				stack.push(c);	 break;		
			case ')': case '}': case ']':
				if(stack.isEmpty()) return false;			
				char lp = stack.pop();			
				if((lp=='(' && c==')') || (lp=='{' && c=='}') || (lp=='[' && c==']'))
					continue;
				else return false;		
			}	
		} 	
		return stack.isEmpty();
	}
	public static boolean validParenthesesV2(String exp){	
		if(exp.length()==0) return true;	
		Stack<Character> stack = new Stack<>();	
		boolean requireLevel1 = false;
		boolean requireLevel2 = false;
		for(var c: exp.toCharArray()){		
			switch(c){		
			case '(': case '{': case '[':
				if(!stack.isEmpty()) {
					char top = stack.peek();
					if(c=='{' && top=='(') {
						System.out.println(top+", "+c);
						return false;
					}
					else if(c=='[' && top!='[') {
						System.out.println(top+", "+c);
						return false;
					}
				}
				if(c=='(') requireLevel1 = false;
				else if(c=='{') {
					requireLevel1 = true;
					requireLevel2 = false;
				}
				else{ // c=='['
					requireLevel2 = true;
				}
				stack.push(c);	 break;		
			case ')': case '}': case ']':
				if(stack.isEmpty()) return false;			
				char lp = stack.pop();	
				if((lp=='(' && c==')') || (lp=='{' && c=='}' && !requireLevel1) ||
				   (lp=='[' && c==']' && !requireLevel2)) {
					continue;
				}
				else {
					return false;		
				}
			}	
		} 	
		return stack.isEmpty();
	}
	public static void validParenthesesV1Test() {
		System.out.println("((()))[]: "+validParenthesesV1("((()))[]"));
		System.out.println("(){}[]: "+validParenthesesV1("(){}[]"));
		System.out.println("{()}[]: "+validParenthesesV1("{()}[]"));
		System.out.println("((())[]: "+validParenthesesV1("((())[]"));
		System.out.println("())[]: "+validParenthesesV1("())[]"));
	}
	public static void validParenthesesV2Test() {
		System.out.println("((()))[{()()}]: "+validParenthesesV2("((()))[{()()}]"));
		System.out.println("()()(): "+validParenthesesV2("()()()"));
		System.out.println("(){}(): "+validParenthesesV2("(){}()"));
		System.out.println("()[](): "+validParenthesesV2("()[]()"));
		System.out.println("()[{}](): "+validParenthesesV2("()[{}]()"));
		System.out.println("(){()}(): "+validParenthesesV2("(){()}()"));
	}
	public static void main(String[] args) {
		//validParenthesesV1Test();
		validParenthesesV2Test();
	}

}
