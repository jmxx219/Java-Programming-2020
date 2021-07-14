/**
 * TableDemo에 활용되는 클래스 
 * 배구선수 정보 유지
 * copyright 2020년도 1학기
 * @author 한국기술교육대학교 컴퓨터공학부 김상진 
 */
public class VolleyballPlayer {
	private String name;
	private int number;
	private double attackSuccessRate;
	public VolleyballPlayer(String name, int number, double attackSuccessRate) {
		this.name = name;
		this.number = number;
		this.attackSuccessRate = attackSuccessRate;
	}
	public String getName(){
		return name;
	}
	public int getNumber(){
		return number;
	}
	public double getAttackSuccessRate(){
		return attackSuccessRate;
	}
	public String toString(){
		return String.format("(%d) %s: %.3f", number, name, attackSuccessRate);
	}
}
