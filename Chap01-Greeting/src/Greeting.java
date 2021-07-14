/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * Greeting 클래스
 */
public class Greeting {
	private String name;
	private String greeting;
	// 밑줄 문자로 매개변수 이름을 명명한 것은 멤버변수와 매개변수
	// 3장부터는 밑줄 문자를 사용하지 않고 자바에 있는 기능(this)를 이용하여 구분할 예정임	
	public void setName(String _name) {
		name = _name;
	}
	public void setGreeting(String _greeting) {
		greeting = _greeting;
	}
	public String sayHello() {
		return greeting + ", " + name;
	}
}
