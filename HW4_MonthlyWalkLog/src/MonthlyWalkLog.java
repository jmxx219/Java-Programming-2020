/*
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 손지민 2019136072
 * MonthlyWalkLog 클래스
 */

/*
 * 1) 교재에 있는 3번의 1, 2번의 답을 주석에 포함하시오.
 * 	① 위 클래스의 멤버 변수 중 dailyDistance의 용량을 31로 설정한 이유를 설명하시오.
 * 	=> 매일 걸은 거리를 기록하는 프로그램으로, 달 중에 31일이 가장 긴 일수이기 때문에 용량을 31으로 설정하였다.
 * 	② 위 클래스의 멤버 변수 중 year, month는 왜 final 변수로 선언한 이유를  설명하시오.
 * 	=> 이 프로그램은 해당되는 월 단위로 걸은 거리를 기록하는 프로그램이기 때문에 연도와 달은 객체가 생성되어 초기화된 이후에 다시 변경될 필요가 없다. 따라서 final를 이용하여 year, month를 한 번만 초기화한다.
 *	2) 생성자에서 year는 2000년 이상이어야 함
 *	3) 클래스를 완성할 때 3개 메소드의 사전조건과 사후조건을 각 메소드 위에 주석으로 포함하시오.
 *	4) 생성자의 경우 사전조건이 위배되면 오늘날짜를 이용하여 년도와 월 정보를 설정하여야 함
 *	이때 LocalDate 클래스를 활용하세요. 
 *  LocalDate today = LocalDate.now(); 
 *  today는 오늘날짜로 설정됨. 
 *  getYear, getMonthValue, lengthOfMonth 등의 메소드를 활용하면 사전조건이 위배되는지 검사할 수 있습니다.
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
		// 월에 따른 일수 체크
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if (day > 31 || day < 1)	day = 0;
		} 
		else if (month == 4 || month == 6 || month == 9 || month == 11 ) {
			if (day > 30 || day < 1)	day = 0;
		} 
		else if (month == 2) {
			// 윤년 체크
			boolean leapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
			if(leapYear) {
				if(day > 29 || day < 1) day = 0;
			}
			else if (day > 28 || day < 1)	day = 0;	
		}		
		if(day == 0) {	// 오늘 날짜로 설정
			day = today.getDayOfMonth();
		}
	
		return day;
	}

	// 사전 조건: 매개변수 year이 2000년도 이상이여야 하고, 매개변수 month는 1-12월 사이여야 한다.
	// 사후 조건: 사전 조건이 위배 될 경우, 현재 연도와 달로 멤버 변수를 초기화 시켜준다.
	public MonthlyWalkLog(int year, int month){
		if(!checkYear(year) || !checkMonth(month)) {
			// 오늘 년도와 월 정보로 설정
			year = today.getYear();
			month = today.getMonthValue();
		}
		this.year = year;
		this.month = month;
	}
	
	// 사전 조건: day는 1 이상이고, 해당 달의 마지막 날(31, 30, 29, 28) 이하여야 한다. distance는 0보다 커야한다.
	// 사후 조건: dailyDistance의 인덱스가 0부터 시작하므로 day와 인덱스 -1 값이 같을 때, 해당 인덱스에 distance 값을 대입한다. 
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
	
	// 사전 조건: day는 1 이상이고, 해당 달의 마지막 날(31, 30, 29, 28) 이하여야 한다.
	// 사후 조건: 반환값의 자료형이 double형이여야 한다. dailyDistance의 인덱스가 0부터 시작하므로 day보다 1작은 값을 인덱스로하여 반환해야한다.
	public double getDistance(int day){
		day = checkDay(day);
		return dailyDistance[--day];
	}
	
//	public void print() {
//		System.out.print f("%d년 %d월 걸은 거리 계산\n", year, month);
//		for(int i = 0; i < 31; i++) {
//			System.out.printf("%d일: %.3f걸음\n", i + 1, dailyDistance[i]);
//		}
//	}
}
