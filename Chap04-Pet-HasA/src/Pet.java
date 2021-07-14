/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * Pet 클래스
 * 상속을 사용하지 않고 조건문을 사용하지 않고 멍멍, 야옹 구현
 */
public class Pet {
	private String name;
	private MakeSoundStrategy soundStrategy;
	public Pet(String name, MakeSoundStrategy soundStrategy) {
		this.name = name;
		this.soundStrategy = soundStrategy;
	}
	public String getName() {
		return name;
	}
	public void setSoundStrategy(MakeSoundStrategy soundStrategy) {
		this.soundStrategy = soundStrategy;
	}
	public String makeSound() {
		return name+": "+soundStrategy.getSound();
	}
}
