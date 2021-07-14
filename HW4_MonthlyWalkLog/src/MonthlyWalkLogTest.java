/*
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 손지민 2019136072
 * MonthlyWalkLog 클래스
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