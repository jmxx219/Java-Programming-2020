/* �ѱ�����������б� ��ǻ�Ͱ��к� �ڹ����α׷���
 * @version 2020�⵵ 2�б�
 * @author ������ 2019136072
 * RobotDuck1 Ŭ����
 * 1) Duck�� ����Ͽ� RobotDuck�� �����ϼ���.
 */

/*
  �� ���� Ŭ������ �ƹ� ���� ���� �� ����ϰ� �־����ϴ�. �׷��� �� ���뿡�� �κ������� �ʿ��ϰ� �Ǿ����ϴ�. 
  �κ������� �Ϲ� ������ �޸� ���͸��� �����Ǿ� �־�� �ൿ�� �� �� �ְ�, �Ҹ��� ����, ������ ������ �� ������ ������ ���մϴ�. �κ������� ��Ÿ���� ���� RobotDuck Ŭ������ �����ϰ��� �մϴ�.
 RobotDuck Ŭ������ ���͸��� ��Ÿ���� ���� int Ÿ���� ��� ���� battery�� ����ϸ�, �� ��� ������ ��ü�� ������ �� 5�� �ʱ�ȭ �Ǿ�� �մϴ�. 
  �� quack, swim �޼ҵ尡 ȣ��Ǹ� 1 �����ؾ� �ϰ�, �� ��� ������ ���� 0�̸� swim�� quack�� �������� �ʾƾ� �մϴ�. 
 Duck�� �ִ� �� �޼ҵ�� �� �������� �����Ǿ� ������ �ſ� �����ϴٰ� �����սô�. 
 RobotDuck�� battery ������ ���� 0���� �˻��ϴ� �Ͱ� 0�� �ƴϸ� battery ������ �����ϴ� ���� �����ϰ� Duck�� quack�� swim �ڵ�� �����ϴٰ� �����սô�. 
 RobotDuck�� Duck�� �޸� void charge() �޼ҵ尡 �ʿ��մϴ�. �� �޼ҵ�� ��� ���� battery ���� �ٽ� 5�� ������ �ֽø� �˴ϴ�.
 4�忡 ������ Door ������ �����Ͽ� RobotDuck�� �� ���� �������� ����� ������.
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
