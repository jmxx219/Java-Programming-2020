/*
 * �ѱ�����������б� ��ǻ�Ͱ��к� �ڹ����α׷���
 * @version 2020�⵵ 2�б�
 * @author ������
 * Computer Ŭ����
 */
import java.util.concurrent.ThreadLocalRandom;

// ��ǻ�� Ŭ����
public class Computer {
	private int[] ball = new int[3];
	
	Computer(){
		for (int i = 0; i < 3; i++) {	// �����Լ��� �̿��Ͽ� ball �ʱ�ȭ
			ball[i] = ThreadLocalRandom.current().nextInt(10);
		}
	}

	public int[] getBall() {	// ball�� ��ȯ�ϴ� getter
		return ball;
	}
	
	public void pitch() {	// ball�� ���� flag�� �ε����� �Ͽ�, �ش� �ε������� 1�� �����ϴ� �޼ҵ�
		int[] flag = new int[10];
		for (int i = 0; i < 3; i++) {
			while (true) {
				if (flag[ball[i]] == 0) {
					flag[ball[i]] = 1;
					break;
				}
			}
		}
	}
}
