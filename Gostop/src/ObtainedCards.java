/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 파일명: ObtainedCards.java
 * @author 손지민 2019136072
 * @version 2020년도 2학기
 * 학기과제1. 고스톱
 */

/*
• 이 클래스의 가장 핵심 역할은 점수를 계산하는 것이다. 
고스톱에서 점수는 자신의 획득한 패뿐만 아니라 상대방 패에 따라 달라질 수 있으며, 고를 몇 번 하였는지, 흔들었는지 등과 같이 게임 진행 내용도 반영되어야 한다. 
이 클래스에서는 획득한 패를 통해 정확하게 계산할 수 있는 부분만 계산하여 준다.
• 점수 계산법
• 점수 계산을 포함하여 맞고 구현을 생각하면서 이 클래스의 멤버 변수와 필요한 메소드를 정의한다.
 */

/*
 * <클래스 설계 이유>
 * 광, 열끗, 오끗, 피마다 점수 계산이 다르기 때문에 각각의 패를 넣어주기 위하여 String 자료형의 배열 멤버 변수인 gwang, cardOfTen, cardOfFive, cardOfPi를 만들었습니다.
 * 또한 각각의 배열의 길이를 저장하기 위해 int 자료형의 gwangCount, fiveCount, tenCount, piCount 멤버변수를 만들었습니다.
 * 또한 총 점수를 나타내는 score 함수도 정의하였고, 0으로 초기화하였습니다.
 * add 메서드는 매개 변수로 받은 card 객체의 패의 값에 따라 광, 열끗, 오끗, 피에 해당하는 배열에 넣었습니다. 넣은 다음에는 배열의 길이를 나타내는 멤버 변수의 값에 1만큼 더해주었습니다.
 * computeScore는 점수를 계산하는 메서드로, 화투의 패를 넣은 배열을 이용하여 광, 열끗, 오끗, 피의 점수를 각각 계산해서 score 멤버변수에 점수를 대입하여 최종적으로 총 점수를 나타내는 반환하도록 하였습니다.
 */

public class ObtainedCards {
	private int score = 0;
	
	private String[] gwang = new String[5];
	private String[] cardOfTen = new String[8];
	private String[] cardOfFive = new String[10];
	private String[] cardOfPi = new String[26];
	
	private int gwangCount = 0;
	private int fiveCount = 0;
	private int tenCount = 0;
	private int piCount = 0;

	public void add(Card card) {
		// 광, 열끗, 오끗, 피 각각의 패를 저장
		if(card.getCard().equals("1A") || card.getCard().equals("3A") || card.getCard().equals("8A") || card.getCard().equals("11A") || card.getCard().equals("12A")) {
			gwang[gwangCount] = card.getCard();
			gwangCount++;
		}
		else if(card.getCard().equals("2A") || card.getCard().equals("4A") || card.getCard().equals("5A") || card.getCard().equals("6A") || card.getCard().equals("7A") || 
				card.getCard().equals("8B") || card.getCard().equals("10A") || card.getCard().equals("12B")) {
			cardOfTen[tenCount] = card.getCard();
			tenCount++;
		}
		else if(card.getCard().equals("1B") || card.getCard().equals("2B") || card.getCard().equals("3B") || card.getCard().equals("4B") || card.getCard().equals("5B") ||
				card.getCard().equals("6B") || card.getCard().equals("7B") || card.getCard().equals("9B") || card.getCard().equals( "10B") || card.getCard().equals("12C")) {
			cardOfFive[fiveCount] = card.getCard();
			fiveCount++;
		}
		else {
			cardOfPi[piCount] = card.getCard();
			piCount++;
		}
	}
	public int computeScore() {
		// 광점수
		if(gwangCount == 3) {
			score += 3;
			for(int i=0; i < gwangCount; i++) {
				if(gwang[i].equals("12A")) {
					score -= 1;
				}
			}
		}
		else if (gwangCount == 4) score += 4;
		else if (gwangCount == 5) score += 15;
		
		//열끗 점수
		int godoriCount = 0; // 고도리
		for(int i = 0; i < tenCount; i++) {
			if (cardOfTen[i].equals("2A") || cardOfTen[i].equals("4A") || cardOfTen[i].equals("8B")) {
				++godoriCount;
			}
			if(i >= 5)	++score;
			if(godoriCount == 3) score += 5;
			
		}
		
		//오끗점수
		int hongdanCount = 0;	// 홍단
		int cheongdanCount = 0;	// 청단
		int chodanCount = 0;	// 초단
		for(int i = 0; i < fiveCount; i++) {
			if (cardOfFive[i].equals("1B") || cardOfFive[i].equals("2B") || cardOfFive[i].equals("3B")) {
				hongdanCount++;
			}
			if (cardOfFive[i].equals("6B") || cardOfFive[i].equals("9B") || cardOfFive[i].equals("10B")) {
				cheongdanCount++;
			}
			if (cardOfFive[i].equals("4B") || cardOfFive[i].equals("5B") || cardOfFive[i].equals("7B")) {
				chodanCount++;
			}
			if(i >= 5)	++score;
			if(hongdanCount == 3) score += 3;
			if(cheongdanCount == 3) score += 3;
			if(chodanCount == 3) score += 3;
		}
		
		//피 점수
		for(int i = 0; i < piCount; i++) {
			if(i >= 9) ++score;
			if (cardOfPi[i].equals("9A") || cardOfPi[i].equals("11B") || cardOfPi[i].equals("12D") || cardOfPi[i].equals("13A") || cardOfPi[i].equals("13B")) {
				++score;
			}
		}
		
		// 총 점수 반환
		return score;
	}
}
