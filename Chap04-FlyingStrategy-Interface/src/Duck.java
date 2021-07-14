/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * Duck 클래스: 4장 interface 실습
 * Flyable interface 구현
 */
public class Duck implements Flyable {
	private FlyingStrategy strategy;
	public Duck(FlyingStrategy strategy) {
		setStrategy(strategy);
	}
	public void setStrategy(FlyingStrategy strategy) {
		this.strategy = strategy;
	}
	@Override
	public void fly() {
		strategy.doFly();
	}
}
