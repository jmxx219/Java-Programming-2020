/**
 * �ѱ�����������б� ��ǻ�Ͱ��к� �ڹ����α׷���
 * @version 2020�⵵ 2�б�
 * @author ������ 2019136072
 * Baseball Ŭ����
 */

// ��ü���� �߱� ������ �����ϴ� Ŭ����
public class Baseball {
	private int scount = 0;
	private int bcount = 0;
	private int result;
	private int out = 0;
	private Computer computer = new Computer();
	User user = new User();
	
	
	public void playGame() { // ���� ���� �޼ҵ�
		computer.pitch();
		while(true) {
			user.hit();
			result = compare(computer.getBall(), user.getBat());
			if (result == 1) {
				System.out.printf("����� ��\n");
				break;
			}
			else if (result == -1) {
				++out;
				System.out.printf("OUT: %d\n", out);
				if (out == 3) {
					System.out.printf("��ǻ�� ��\n");
					break;
				}
			}
		}
	}
	
	public int compare(int[] ball, int[] bat) {	// ball��  bat�� ���ϴ� �޼ҵ�
		int[] flag = new int[10];
		scount = 0;
		bcount = 0;
		for (int i = 0; i < 3; i++) flag[ball[i]] = 1;
		for (int i = 0; i < 3; i++) {
			if (ball[i] == bat[i]) ++scount;
			else if (flag[bat[i]] == 1) ++bcount;
		}
		if (scount == 3)
			return 1;
		else if (scount == 0 && bcount == 0) return -1;
		else {
			System.out.printf("S: %d, B: %d\n", scount, bcount);
			return 0;
		}
	}

}
