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
		System.out.printf("%s: 멍멍%n", name);
	}
}

/*
// 두 번째 버전
public class Dog {
	private String name;
	private String breed;

	public String getName() {
		return name;
	}

	public void setName(String _name) {
		name = _name;
	}
	public void setBreed(String _breed) {
		breed = _breed;
	}
	
	public void bark(){
		System.out.printf("%s: ", name);
		if(breed.equals("똥개"))
			System.out.println("왈왈");
		else System.out.println("멍멍");
		
	}
}
*/