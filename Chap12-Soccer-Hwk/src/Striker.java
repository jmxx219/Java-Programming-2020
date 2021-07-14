import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 2019136072 손지민 
 * Strike: 공격수
 * 부모 클래스: Player
 * 요구사항. toString, hashCode, equals, clone, compareTo 재정의
 * toString은 기본적으로 부모의 toString을 활용하는 형태로 각자 알아서
 * compareTo는 부모에 정의된 메소드를 먼저 이용하고, 동일하면 points을 이용하여 비교
 */
public final class Striker extends Player {
	private int goal = 0;
	private int assist = 0; 
	public Striker(String name, int number, Team team) {
		super(name, number, team);
	}

	@Override
	public String toString() { // 객체에 대한 문자열 표현 제공
		return super.toString() + String.format("striker: %d, %d", goal, assist);
	}
	
	@Override
	public boolean equals(Object other) { // 객체의 내부 상태가 같은지 비교
		if(!super.equals(other)) return false;
		Striker o = (Striker)other;
		return goal==o.goal&&assist==o.assist;
	}
	
	@Override
	public int hashCode() { // 객체를 서로 구분할 수 있는 정수 값을 제공
		return Objects.hash(super.hashCode(), goal, assist);
	}
	
	@Override
	public Striker clone() { // 객체 복사
		Striker cloned = null;
		try {
			cloned = (Striker)super.clone();
		}
		catch(CloneNotSupportedException e) {}
		return cloned;
	}
	@Override
	public int compareTo(Player other) {
		Striker s = (Striker)other;
		int comp = super.compareTo(other);
		return comp==0? goal-s.goal: comp;
	}
}
