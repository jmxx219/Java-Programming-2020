/*
 * �ѱ�����������б� ��ǻ�Ͱ��к� �ڹ����α׷���
 * @version 2020�⵵ 2�б�
 * @author ������
 * BaseballTest Ŭ����
 */

public class BaseballTest {

	public static void main(String[] args) {
		boolean do_ = true;
		
		while(do_) {
			Baseball baseball = new Baseball();
			baseball.playGame();
			do_ = !baseball.user.done();
		}
	}

}
