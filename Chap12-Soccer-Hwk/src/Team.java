import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 2019136072 손지민 
 * Team: 축구 구단 정보
 * 요구사항. toString, hashCode, equals, clone 재정의
 * toString은 각자 알아서
 */
public final class Team {
	private String name;
	private String country;
	public Team(String name, String country) {
		this.name = Objects.requireNonNull(name);
		this.country = Objects.requireNonNull(country);
	}
	public String getName(){
		return name;
	}
	public String getCountry(){
		return country;
	}
	@Override
	public String toString() { // 객체에 대한 문자열 표현 제공
		return String.format("Team: %s, %s", name, country);
	}
	
	@Override
	public boolean equals(Object other) { // 객체의 내부 상태가 같은지 비교
		if(other==null || getClass()!=other.getClass()) return false; //예외처리
		if(this==other) return true; //주소비교
		Team o = (Team)other;
		return name.equals(o.name)&&country.equals(o.country);
	}
	
	@Override
	public int hashCode() { // 객체를 서로 구분할 수 있는 정수 값을 제공
		return Objects.hash(name, country);
	}
	
	@Override
	public Team clone(){ // 객체 복사
		Team cloned = null;
		try {
			cloned = (Team)super.clone();
		}
		catch(CloneNotSupportedException e) {}
		return cloned;
	}
}
