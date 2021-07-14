import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 2019136072 손지민 
 * Player: 축구 선수 추상 클래스
 * 요구사항. toString, hashCode, equals, clone, compareTo 재정의
 * toString은 각자 알아서
 * compareTo는 name을 이용하여 먼저 비교하고, 그다음 number를 이용하여 비교
 */
public abstract class Player implements Cloneable, Comparable<Player>{
	private String name;
	private int number;
	private Team team;
	public Player(String name, int number, Team team){
		setName(name);
		setNumber(number);
		this.team = Objects.requireNonNull(team);;
	}
	public void setName(String name) {
		this.name = Objects.requireNonNull(name);
	}
	public void setNumber(int number) {
		if(number<0) throw new IllegalArgumentException("");
		this.number = number;
	}
	@Override public String toString() { // 객체에 대한 문자열 표현 제공
		return String.format("player: %s, %d, %s, %s, ", name, number, team.getName(), team.getCountry());
	}
	@Override public boolean equals(Object other) { // 객체의 내부 상태가 같은지 비교
		if(other==null || getClass()!=other.getClass()) return false; //예외처리
		if(this==other) return true; //주소비교
		Player o = (Player)other;
		return name.equals(o.name)&&number==o.number&&team.equals(o.team);
	}
	@Override public int hashCode() { // 객체를 서로 구분할 수 있는 정수 값을 제공
		return Objects.hash(name, number, team.hashCode());
	}
	@Override public Player clone() throws CloneNotSupportedException { // 객체 복사
		return (Player)super.clone();
	}
	@Override public int compareTo(Player other) {
		int tmp = name.compareTo(other.name);
		return tmp==0? Integer.compare(number, other.number): tmp;
	}

}
