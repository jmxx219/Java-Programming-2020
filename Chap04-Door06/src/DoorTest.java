/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * DoorTest 클래스: 4장 상속 실습
 * Has-a를 이용한 잠금장치 있는 문의 구현
 */
public class DoorTest {
	public static void doorTest(DoorWithLock door) {
		door.open();
		door.close();
		door.lock();
		door.open();
		door.unlock();
		door.open();
		door.lock();
		door.close();
		door.lock();
	}
	public static void main(String[] args) {
		doorTest(new DoorWithLock());	
	}
}
