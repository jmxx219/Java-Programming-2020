import java.util.Objects;

final class A implements Cloneable{
	private int n;
	public A(int n) {
		this.n = n;
	}
	@Override public A clone() {
		A cloned = null;
		try {
			cloned = (A)super.clone();
		}
		catch(CloneNotSupportedException e) {}
		return cloned;
	}
}

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진 
 * Student 클래스
 * 멤버 변수 중 final 멤버 변수가 있는 경우
 * 원시타입 멤버 변수가 final: 얕은 복사 (super.clone() 호출) 이후 값을 바꿀 수 없음
 * 객체타입 멤버 변수가 final: 깊은 복사가 가능하지 않음 
 */
public class Student implements Cloneable, Comparable<Student>{ 
	private String name;
	private int year;
	public final int entranceYear;
	private int currentCredit = 0;
	//private final A a;
	public static final int TOTALMINCREDITS = 150;
	public Student(String name, int year, int entranceYear) { //, A a) {
		setName(name);
		setYear(year);
		//setEntraceYear(entranceYear);
		this.entranceYear = entranceYear;
		//this.a = a;
	}
	public void setName(String name) {
		this.name = Objects.requireNonNull(name);
	}
	public void setYear(int year) {
		this.year = year;
	}
	/*
	public void setEntranceYear(int entranceYear) {
		this.entranceYear = entranceYear;
	}
	*/
	@Override public String toString() {
		return String.format("학생: %s, %d, %d, %d", name, year, entranceYear, currentCredit);
	}
	@Override public boolean equals(Object other) {
		if(!super.equals(other)) return false;
		Student s = (Student)other;
		return name.equals(s.name) && year==s.year 
				&& entranceYear==s.entranceYear 
				&& currentCredit == s.currentCredit;
	}
	@Override public int hashCode() {
		return Objects.hash(name, year, entranceYear, currentCredit);
	}
	@Override public Student clone() {
		Student cloned = null;
		try {
			cloned = (Student)super.clone();
			//cloned.a = a.clone();
		}
		catch(CloneNotSupportedException e) {}
		return cloned;
	}
	@Override public int compareTo(Student other) {
		return name.compareTo(other.name);
	}
}
