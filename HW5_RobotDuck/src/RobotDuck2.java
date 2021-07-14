/* 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 손지민 2019136072
 * RobotDuck2 클래스
 * 2) Duck 객체를 멤버 변수로 유지하는 형태로 RobotDuck을 정의하세요.
 */

public class RobotDuck2 {
	Duck duck = new Duck();
	private int battery = 5;
	
	boolean isBattery() {
		return (battery!=0);
	}
	
	public void fly(){}
	public void quack(){
		if(isBattery()) {
			duck.quack();
			--battery;
		}
	}
	public void swim(){
		if(isBattery()) {
			duck.swim();
			--battery;
		}
	}
	private void charge() {
		battery = 5;
	}
}
