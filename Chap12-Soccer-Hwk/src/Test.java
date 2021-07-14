
/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 2019136072 손지민
 * 테스트 프로그램
 *  Player, Striker, Team에 toString, equals, hashCode, clone, compareTo를 재정의
 */
public class Test {

	public static void main(String[] args) throws CloneNotSupportedException{
		Team liverpool = new Team("Liverpool", "England");
		Team barcelona = new Team("Barcelona", "Spain");
		Player p1 = new Striker("Sadio Mane",10,liverpool);
		Player p2 = new Striker("Lionel Messi",10,barcelona); 
		Player p3 = p2.clone();
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p2!=p3);
		System.out.println(p2.hashCode()==p3.hashCode());
		System.out.println(p2.equals(p3));
		p3.setName("Diogo Jota");
		p3.setNumber(20);
		System.out.println(p2.hashCode()!=p3.hashCode());
		System.out.println(p2.equals(p3));
		System.out.println(p2.compareTo(p3));
	}

}
