
/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * 파일명: Unit.java
 * @author 김상진 
 * @version 2020년도 2학기
 * 게임에 등장하는 유니트
 * 체력: 항상 100에서 시작
 * 레벨: 생성될 때 각 유니트의 레벨은 다를 수 있음
 * 이동속도: 모든 유니트의 이동속도는 1이고 변하지 않음 
 * 차지하는 공간: 각 유니트마다 다를 수 있지만 변하지 않음
 * 생성된 학생 수: 생성자에서 증가시킴
 */
public class Unit {
	private int stamina = 100;			// 체력. 0이 되면 죽음
	private int level;					// 1~5 중 하나 
	private static final int SPEED = 1;	// 이동속도 
	private final int SPACE;			// 차지하는 공간
	public Unit(int level, int space) {
		this.level = (level>=1&&level<=5)? level: 1;
		SPACE = space;
	}
}
