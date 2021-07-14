import java.util.Objects;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 10장 인터페이스 두 번째 이야기
 * @version 2020년도 2학기
 * @author 김상진
 * Student 클래스: ComparableTest에서 활용
 */
public class Student implements Comparable<Student>{
	private String name;
	private String number;
	private int year;
	public Student(String name, String number){
		this(name,number,1);
	}
	public Student(String name, String number, int year) {
		this.name = Objects.requireNonNull(name);
		this.number = Objects.requireNonNull(number);
		this.year = year;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public int compareTo(Student o) {
		int comp = year-o.year;
		return (comp==0)? name.compareTo(o.name): comp;
	}
	@Override
	public String toString() {
		return String.format("(%s %s %d)", name, number, year);
	}
}
