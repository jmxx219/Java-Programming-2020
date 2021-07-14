/*
 * �ѱ�����������б� ��ǻ�Ͱ��к� �ڹ����α׷���
 * @version 2020�⵵ 2�б�
 * @author ������ 2019136072
 * MonthlyWalkLog Ŭ����
 */

/*
 * 1) ���翡 �ִ� 3���� 1, 2���� ���� �ּ��� �����Ͻÿ�.
 * 	�� �� Ŭ������ ��� ���� �� dailyDistance�� �뷮�� 31�� ������ ������ �����Ͻÿ�.
 * 	=> ���� ���� �Ÿ��� ����ϴ� ���α׷�����, �� �߿� 31���� ���� �� �ϼ��̱� ������ �뷮�� 31���� �����Ͽ���.
 * 	�� �� Ŭ������ ��� ���� �� year, month�� �� final ������ ������ ������  �����Ͻÿ�.
 * 	=> �� ���α׷��� �ش�Ǵ� �� ������ ���� �Ÿ��� ����ϴ� ���α׷��̱� ������ ������ ���� ��ü�� �����Ǿ� �ʱ�ȭ�� ���Ŀ� �ٽ� ����� �ʿ䰡 ����. ���� final�� �̿��Ͽ� year, month�� �� ���� �ʱ�ȭ�Ѵ�.
 *	2) �����ڿ��� year�� 2000�� �̻��̾�� ��
 *	3) Ŭ������ �ϼ��� �� 3�� �޼ҵ��� �������ǰ� ���������� �� �޼ҵ� ���� �ּ����� �����Ͻÿ�.
 *	4) �������� ��� ���������� ����Ǹ� ���ó�¥�� �̿��Ͽ� �⵵�� �� ������ �����Ͽ��� ��
 *	�̶� LocalDate Ŭ������ Ȱ���ϼ���. 
 *  LocalDate today = LocalDate.now(); 
 *  today�� ���ó�¥�� ������. 
 *  getYear, getMonthValue, lengthOfMonth ���� �޼ҵ带 Ȱ���ϸ� ���������� ����Ǵ��� �˻��� �� �ֽ��ϴ�.
 */
import java.time.*;

public class MonthlyWalkLog {
	private double dailyDistance[] = new double[31];
	private final int year;
	private final int month;
	LocalDate today = LocalDate.now(); 
	
	private boolean checkYear(int year) { return (year >= 2000 && year <= today.getYear()); }
	private boolean checkMonth(int month) {	return (month >= 1 && month <= 12);	}
	private double checkDistance(double distance) {
		return (distance > 0 ? distance : 0) ;
	}
	private int checkDay(int day) {
		// ���� ���� �ϼ� üũ
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if (day > 31 || day < 1)	day = 0;
		} 
		else if (month == 4 || month == 6 || month == 9 || month == 11 ) {
			if (day > 30 || day < 1)	day = 0;
		} 
		else if (month == 2) {
			// ���� üũ
			boolean leapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
			if(leapYear) {
				if(day > 29 || day < 1) day = 0;
			}
			else if (day > 28 || day < 1)	day = 0;	
		}		
		if(day == 0) {	// ���� ��¥�� ����
			day = today.getDayOfMonth();
		}
	
		return day;
	}

	// ���� ����: �Ű����� year�� 2000�⵵ �̻��̿��� �ϰ�, �Ű����� month�� 1-12�� ���̿��� �Ѵ�.
	// ���� ����: ���� ������ ���� �� ���, ���� ������ �޷� ��� ������ �ʱ�ȭ �����ش�.
	public MonthlyWalkLog(int year, int month){
		if(!checkYear(year) || !checkMonth(month)) {
			// ���� �⵵�� �� ������ ����
			year = today.getYear();
			month = today.getMonthValue();
		}
		this.year = year;
		this.month = month;
	}
	
	// ���� ����: day�� 1 �̻��̰�, �ش� ���� ������ ��(31, 30, 29, 28) ���Ͽ��� �Ѵ�. distance�� 0���� Ŀ���Ѵ�.
	// ���� ����: dailyDistance�� �ε����� 0���� �����ϹǷ� day�� �ε��� -1 ���� ���� ��, �ش� �ε����� distance ���� �����Ѵ�. 
	public void recordDistance(int day, double distance){
		day = checkDay(day);
		distance = checkDistance(distance);
		for (int i = 0; i < 31; i++) {
			if (day == i + 1) {
				dailyDistance[i] += distance;
				break;
			}
		}
	}
	
	// ���� ����: day�� 1 �̻��̰�, �ش� ���� ������ ��(31, 30, 29, 28) ���Ͽ��� �Ѵ�.
	// ���� ����: ��ȯ���� �ڷ����� double���̿��� �Ѵ�. dailyDistance�� �ε����� 0���� �����ϹǷ� day���� 1���� ���� �ε������Ͽ� ��ȯ�ؾ��Ѵ�.
	public double getDistance(int day){
		day = checkDay(day);
		return dailyDistance[--day];
	}
	
//	public void print() {
//		System.out.print f("%d�� %d�� ���� �Ÿ� ���\n", year, month);
//		for(int i = 0; i < 31; i++) {
//			System.out.printf("%d��: %.3f����\n", i + 1, dailyDistance[i]);
//		}
//	}
}
