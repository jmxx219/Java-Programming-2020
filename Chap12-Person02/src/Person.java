import java.util.Objects;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 제12장 상속 두 번째 이야기 예제
 * @version 2019년도 2학기
 * @author 김상진 
 * Person 클래스: 부모 클래스가 Object
 */
public class Person implements Cloneable, Comparable<Person>{
	private String name;
	public Person(String name){
		setName(name);
	}
	public void setName(String name) {
		this.name = Objects.requireNonNull(name);
	}
	public String getName(){
		return name;
	}
	@Override
	public String toString(){
		return name;
	}
	@Override
	public int hashCode() {
		return Objects.hashCode(name);
	}
	@Override
	public boolean equals(Object o) {
		if(o==null||getClass()!=o.getClass()) return false;
		if(this==o) return true;
		Person p = (Person)o;
		return Objects.equals(name, p.name);
	}
	@Override
	public Person clone() throws CloneNotSupportedException{
		return (Person)super.clone();
	}
	@Override
	public int compareTo(Person o) {
		return name.compareTo(o.name);
	}
}
