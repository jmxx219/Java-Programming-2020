/*
 * �ѱ�����������б� ��ǻ�Ͱ��к� �ڹ����α׷���
 * @version 2020�⵵ 2�б�
 * @author ������ 2019136072
 * MonthlyWalkLog Ŭ����
 */

public class MonthlyWalkLogTest {
	public static void main(String[] args) {
		MonthlyWalkLog M1 = new MonthlyWalkLog(2020, 10);
		M1.recordDistance(11, 2000);
		System.out.println(M1.getDistance(11));
		
		
		
		MonthlyWalkLog M2 = new MonthlyWalkLog(2019, 2);
		M2.recordDistance(28, 5000);
		M2.recordDistance(0, 10000);
		//M2.print();
		
		
		MonthlyWalkLog M3 = new MonthlyWalkLog(2019,3);
		M3.recordDistance(11, 2000);
	}

}