/* �ѱ�����������б� ��ǻ�Ͱ��к� �ڹ����α׷���
 * @version 2020�⵵ 2�б�
 * @author ������ 2019136072
 * RobotDuck2 Ŭ����
 * 2) Duck ��ü�� ��� ������ �����ϴ� ���·� RobotDuck�� �����ϼ���.
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
