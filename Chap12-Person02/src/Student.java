import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 제12장 상속 두 번째 이야기 예제
 * @version 2020년도 2학기
 * @author 김상진 
 * Student 클래스
 * 배열 타입의 멤버변수가 있을 때 hashCode, equals, clone, toString의 구현 
 * 이 예처럼 한 객체 a가 다른 객체 b를 멤버 변수로 가지고 있는데 
 * b가 a를 멤버 변수로 가지고 있어 객체 그래프에 주기가 있으면 
 * hashCode, equals 구현할 때 무한 반복이 될 수 있음을 주의해야 함 
 */
public final class Student extends Person{
	private int year;
	private Student[] friends = null;
	public Student(String name, int year) {
		super(name);
		this.year = year;
	}
	public void setFriends(Student... friends) {
		Arrays.sort(friends);
		this.friends = friends;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString(){
		return "학생이름: "+super.toString()+", 학년: "+year;
	}
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), year, Arrays.hashCode(friends));
		/*
		ArrayList<String> friendNames = new ArrayList<>();
		for(var friend: friends)
			friendNames.add(friend.getName());
		return Objects.hash(super.hashCode(), year, friendNames.hashCode());
		*/
	}
	@Override
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		Student s = (Student)o;
		ArrayList<String> friendNames = new ArrayList<>();
		for(var friend: friends)
			friendNames.add(friend.getName());
		ArrayList<String> otherFriendNames = new ArrayList<>();
		for(var friend: s.friends)
			otherFriendNames.add(friend.getName());
		return year == s.year && friendNames.equals(otherFriendNames);
	}
	@Override
	public Student clone() {
		Student cloned = null;
		try {
			cloned = (Student)super.clone();
			cloned.friends = friends.clone();
		}
		catch(CloneNotSupportedException e) {	
		}
		return cloned;
	}
}
