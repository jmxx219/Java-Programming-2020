/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * Dog 클래스
 */
public class Dog {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String _name) {
		name = _name;
	}
	public void bark(){
		System.out.printf("%s: ", name);
	}
}
