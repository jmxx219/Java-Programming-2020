/* 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 손지민 2019136072
 * Duck 클래스
 */

/*
  상속하여 만들면 Duck과 RobotDuck을 모두 Duck 타입의 리모컨으로 조작할 수 있는 이점은 있습니다. 하지만 상속 계층도에서 부모와 자식을 모두 생성하는 형태가 되기 때문에 바람직한 형태는 아닙니다. 
  그러면 과연 여러분 생각에 "RobotDuck is a Duck" 명제가 성립한다고 생각하시나요? 처음부터 Duck과 RobotDuck이 모두 필요하다고 알았으면 어떻게 설계하는 것이 가장 바람직하다고 생각하는지 여러분의 의견을 제시해 주세요. 
  즉, 다음 두 가지에 대한 의견을 간단하게 Duck 클래스 프로그램 주석에 포함하여 제출하여 주세요.
  
 1) "RobotDuck is a Duck" 명제가 성립하는지 여부. 성립하면 왜 성립한다고 생각하는지, 성립하지 않다고 생각하면 그 이유가 무엇인지 설명하시면 됩니다.
 	=> 명제가 성립한다고 생각한다. 상속을 하면 자식 클래스는 부모 클래스의 메소드를 물려받아, 자식은 부모가 갖고있는 상태와 행동을 갖고있기 때문이다.
 2) Duck, RobotDuck이 처음부터 모두 필요하다는 것을 알았을 경우 백지에서 설계한다면 어떻게 설계할지
 	=> Duck을 이용하여  RobotDuck을 처리하기 위해 Duck 클래스에 charge() 메소드를 추상 메서드로 선언한다. 이렇게 하면 리모컨으로 Duck와 RobotDuck를 공통으로 조작이 가능하다.
 */

public class Duck {
	public void fly(){
		System.out.println("하늘을 날고 있어...");
	}
	public void quack(){
		System.out.println("꽥꽥");
	}
	public void swim(){
		System.out.println("물에서 놀고 있어...");
	}
}
