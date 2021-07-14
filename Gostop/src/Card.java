import java.lang.String;
/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 파일명: Card.java
 * @author 손지민 2019136072
 * @version 2020년도 2학기
 * 학기과제1. 고스톱
 */

/*
• 화투는 총 48장으로 구성되어 있으며, 여기에 보너스패가 몇 개 추가되어 사용할 수 있다.
• 보너스패를 제외한 기존 48장은 그림 3.1에 제시된 것처럼 화투패는 12개의 월로 나누어지고, 각 월에서는 광, 열끗, 오끗, 피 등으로 순서가 있다. 
	이 순서를 나타내기 위해 이 문서에서는 A, B, C, D를 사용한다.
• 화투의 각 패를 나타내는 클래스 Card를 정의하여 제출한다.
• 이때 화투패는 1에서 48까지의 정수를 주어 각 화투패를 생성할 수 있어야 한다.
• 맞고 구현을 생각하면서 이 클래스의 멤버 변수와 필요한 메소드를 정의한다.
 */

/*
 * <클래스 설계 이유>
 * 화투패가 1에서 48까지의 정수로 주어지면 12개의 월과 A,B,C,D로 나타내기 위하며 String 자료형의 card 멤버 변수를 만들었습니다.
 * 또 이 정수를 이용하여 월을 구하는 getMonth 메소드와 알파벳을 구하는 getABCD 메소드를 정의하였습니다. 두 메소드는 외부에서 쓰이지 않기 때문에 private으로 정의하였습니다.
 * 생성자에서는 숫자가 보너스피를 포함하여 1이상 50이하의 숫자가 들어오지 않으면 카드 생성 실패로 하였고, card 멤버 변수는 getMonth와 getABCD 메소드를 이용하여 초기화하였습니다.
 * 그리고 card의 값을 얻는 getCard 메소드를 만들었습니다.
 */

public class Card {
	private String card;
	
	private int getMonth(int number) {
		// 월 구하기
		return (number % 4 == 0) ? (number / 4) : (number / 4) + 1;
	}
	private char getABCD(int number) {
		// A, B, C, D 구하기
		if(number % 4 == 1) return 'A';
		else if(number % 4 == 2) return 'B';
		else if(number % 4 == 3) return 'C';
		else return 'D';
	}
	
	public Card(int number) {
		if(number<1||number>50) throw new IllegalArgumentException("Card: 생성 실패");
		// ex) number = 5이면 2A
		card = Integer.toString(getMonth(number)) + getABCD(number);
	}
	public String getCard() {
		return card;
	}
}
