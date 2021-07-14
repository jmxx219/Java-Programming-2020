
/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * ArgumentPassing 클래스: 자바는 값 전달 방식만 지원
 * 참조타입을 값 전달 방식으로 전달할 때 효과 이해하기
 */
public class ArgumentPassingTest {
	public static void swapName(Person p1, Person p2) {
		String tmp = p1.getName();
		p1.setName(p2.getName());
		p2.setName(tmp);
	}
	public static void swap(Person p1, Person p2) {
		Person tmp = p1;
		p1 = p2;
		p2 = tmp;
	}
	public static void foo(Person person) {
		person.setName("성춘향");
	}
	public static void foo(int n) {
		n = 1;
	}
	public static void main(String[] args) {
		int n = 0;
		foo(n);
		System.out.println(n);
		Person person1 = new Person("홍길동");
		Person person2 = new Person("전우치");
		System.out.println(person1.getName());
		System.out.println(person2.getName());
		foo(person1);
		System.out.println(person1.getName());
		System.out.println(person2.getName());
		swap(person1, person2);
		System.out.println(person1.getName());
		System.out.println(person2.getName());
		swapName(person1, person2);
		System.out.println(person1.getName());
		System.out.println(person2.getName());
	}
}
