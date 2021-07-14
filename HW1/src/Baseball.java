import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Baseball {
	/*
	  * Java���� ������ ThreadLocalRandom.current() ��ü�� �̿��� (�ٸ� ����� ����)
	  * �̸� ���� ���� import���� �ʿ���
	  * import java.util.concurrent.ThreadLocalRandom;
	  *
	  * ��� ����� ������ ���� nextInt(n)�̸� 0���� n-1���� ���� �� ������ �ϳ��� �����Ͽ� ��ȯ��
	  * ball[i] = ThreadLocalRandom.current().nextInt(10); // 0~9
	 */
	public static void pitch(int ball[]) {
		int[] flag = new int[10];
		int i = 0;
		for (i = 0; i < 3; i++) {
			while (true) {
				ball[i] = ThreadLocalRandom.current().nextInt(10);
				if (flag[ball[i]] == 0) {
					flag[ball[i]] = 1;
					break;
				}
			}
		}
	}
	/*
	 * �ڹٿ����� int compare(int[] ball, int[] bat) ���·� ����
	 */
	public static int compare(int[] ball, int[] bat) {
		int[] flag = new int[10];
		int scount = 0;
		int bcount = 0;
		int i;
		for (i = 0; i < 3; i++) flag[ball[i]] = 1;
		for (i = 0; i < 3; i++) {
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

	/*
	 * Java �迭
	 * int[] bat = new int[3]; �ڵ����� 0���� ��� �ʱ�ȭ
	 *
	 * �ڹٿ��� Ÿ�� �� �Է�
	 * for(int i=0; i<3; i++) bat[i] = in.nextInt();
	 */
	public static void playGame() {
		Scanner in = new Scanner(System.in);
		int[] bat = new int[3];
		int[] ball = new int[3];
		int result;
		int out = 0;
		pitch(ball);
		while (true) {
			System.out.printf("[0-9]���� ���� 3���� �Է��Ͻÿ�: ");
			for(int i=0; i<3; i++) {
				bat[i] = in.nextInt();
			}
			result = compare(ball, bat);
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

	/*
	 * Java
	 * boolean done()
	 * getchar -> in.nextLine�� �̿��Ͽ� ���ڿ� �Է� �� ���ڿ� ��
	 * ��) String s = in.nextLine(); s = s.toLowerCase(); if(s.equals("n"))
	 */
	public static boolean done() {
		Scanner in = new Scanner(System.in);
		
		String s = null;
		System.out.printf("�� ����(y/n)? ");
		
//		s = in.nextLine();
//		s = s.toLowerCase();
//		
//		if(s.equals("n")) return false;
//		
//		return true;
		while(true) {
		 s = in.nextLine().strip().toLowerCase();
			if(s.equals("y")||s.equals("n")) break;
		}
		return (s.equals("n"));
	}
	
	public static void main(String[] args) {
		do {
			playGame();
		} while (done());
		
	}
}
