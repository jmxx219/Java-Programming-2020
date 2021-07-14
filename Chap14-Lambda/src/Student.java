/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2019년도 2학기
 * @author 김상진
 *
 */
public class Student{
	private String name;
	private String number;
	private int year;
	public Student(String name, String number){
		this(name,number,1);
	}
	public Student(String name, String number, int year) {
		setName(name);
		setNumber(number);
		setYear(year);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override public String toString() {
		return String.format("(%s, %s, %d)", name==null? "": name, number, year);
	}
	
}
