/* 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 손지민 2019136072
 * RobotDuck1 클래스
 * 1) Duck을 상속하여 RobotDuck을 정의하세요.
 */

/*
  이 오리 클래스를 아무 문제 없이 잘 사용하고 있었습니다. 그런데 이 응용에서 로봇오리가 필요하게 되었습니다. 
  로봇오리는 일반 오리와 달리 배터리가 충전되어 있어야 행동을 할 수 있고, 소리를 내고, 물에서 움직일 수 있지만 날지는 못합니다. 로봇오리를 나타내기 위해 RobotDuck 클래스를 정의하고자 합니다.
 RobotDuck 클래스는 배터리를 나타내기 위해 int 타입의 멤버 변수 battery를 사용하며, 이 멤버 변수는 객체를 생성할 때 5로 초기화 되어야 합니다. 
  또 quack, swim 메소드가 호출되면 1 감소해야 하고, 이 멤버 변수의 값이 0이면 swim과 quack은 동작하지 않아야 합니다. 
 Duck에 있는 각 메소드는 한 문장으로 구성되어 있지만 매우 복잡하다고 가정합시다. 
 RobotDuck은 battery 변수의 값이 0인지 검사하는 것과 0이 아니면 battery 변수를 감소하는 것을 제외하고 Duck의 quack과 swim 코드와 동일하다고 가정합시다. 
 RobotDuck은 Duck과 달리 void charge() 메소드가 필요합니다. 이 메소드는 멤버 변수 battery 값을 다시 5로 설정해 주시면 됩니다.
 4장에 설명한 Door 예제를 참고하여 RobotDuck을 두 가지 버전으로 만들어 보세요.
 */

public class RobotDuck1 extends Duck{
	private int battery = 5;
	
	boolean isBattery() {
		return (battery!=0);
	}
	
	@Override public void fly(){}
	@Override public void quack(){
		if(isBattery()) {
			super.quack();
			--battery;
		}
	}
	@Override public void swim(){
		if(isBattery()) {
			super.swim();
			--battery;
		}
	}
	private void charge() {
		battery = 5;
	}
}
