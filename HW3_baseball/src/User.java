/*
 * �ѱ�����������б� ��ǻ�Ͱ��к� �ڹ����α׷���
 * @version 2020�⵵ 2�б�
 * @author ������
 * User Ŭ����
 */
import java.util.Scanner;

//����� Ŭ����
public class User {
	private int[] bat = new int[3];
	
	public int[] getBat() {	// bat�� ��ȯ�ϴ� getter
		return bat;
	}
	
	@SuppressWarnings("resource")
	public void hit() {	// ����ڷκ��� bat�� �Է¹޴� �޼ҵ�
		Scanner in = new Scanner(System.in);
		
		System.out.printf("[0-9]���� ���� 3���� �Է��Ͻÿ�: ");
		
		for(int i=0; i<3; i++) {
			bat[i] = in.nextInt();
		}
	}
	
	@SuppressWarnings("resource")
	public boolean done() {	// ������� ���� ���� ���θ� �Է¹޴� �޼ҵ�
		Scanner in = new Scanner(System.in);
		
		String s = null;
		
		while(true) {
			System.out.printf("�� ����(y/n)? ");
			s = in.nextLine().strip().toLowerCase();
			if(s.equals("y")||s.equals("n")) break;
		}
		return (s.equals("n"));
	}
}
