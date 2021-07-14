/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2019년도 2학기
 * @author 김상진
 * Door 클래스: 4장 상속 실습
 * 열거형을 이용한 상태에 따른 행위 구현 > 코드 중복이 많음
 */
public abstract class Door {
	public enum DoorState {OPENED, CLOSED, LOCKED};
	protected DoorState currentState = DoorState.CLOSED;
	public Door() {}
	public DoorState getCurrentState() {
		return currentState;
	}
	public void open(){
		switch(currentState) {
		case OPENED: System.out.println("문이 이미 열려 있음"); break;
		case CLOSED:
			System.out.println("문이 열림");
			currentState = DoorState.OPENED;
			break;
		case LOCKED:
			throw new IllegalStateException();
		}
	}
	public void close(){
		switch(currentState) {
		case OPENED:
			System.out.println("문이 닫힘");
			currentState = DoorState.CLOSED;
			break;
		case CLOSED:
			System.out.println("문이 이미 닫혀 있음");
			break;
		case LOCKED:
			throw new IllegalStateException();	
		} 
	}
	public abstract void lock();
	public abstract void unlock();
}
