import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * Person 클래스: 객체 반환 함수를 사용할 때 주의할 점
 * 사람>> 상태: 이름, 생일, 
 * getName과 getBirthday의 차이점 분석
 */
public class Person {
	private String name;
	private Calendar birthday;
	public Person(String name) {
		setName(name);
	}
	public Person(String name, Calendar birthday) {
		setName(name);
		this.birthday = birthday;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName(){
		return name;
	} // ok
	public Calendar getBirthday(){
		return birthday;
		//return (Calendar) birthday.clone();
	} // problem
	public static void main(String[] args) {
		Person sangjin = new Person("김상진",new GregorianCalendar(2000,11,25));
		System.out.println(sangjin.getName());
		System.out.println(sangjin.getBirthday().getTime());
		String name = sangjin.getName();
		name = "김진희";
		Calendar calendar = sangjin.getBirthday();
		calendar.set(2000,0,25);
		System.out.println(sangjin.getName());
		System.out.println(sangjin.getBirthday().getTime());
	}
}
