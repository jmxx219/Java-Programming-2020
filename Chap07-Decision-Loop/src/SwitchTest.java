/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2019년도 2학기
 * @author 김상진 
 * switch문 예제
 */
public class SwitchTest {
	public static int numberOfDays01(int month) {
		switch(month){
		case 4: case 6: case 9: case 11: return 30;
		case 2: return 28;
		default: return 31;
		}
	}
	public static int numberOfDays02(int month) {
		switch(month){
		case 4, 6, 9, 11: return 30;
		case 2: return 28;
		default: return 31;
		}
	}
	public static int numberOfDays03(int month) {
		return switch(month){
			case 4, 6, 9, 11 -> 30;
			case 2 -> 28;
			default -> 31;
		};
	}
	public static String isWorkingDay(String day) {
		return switch (day) {
			case "MON", "TUE", "WED", "THU", "FRI"  -> "근무일";
			default -> {
				if(day.isEmpty()) yield "유효한 요일이 아님";
				else yield "휴일";
			}
		};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
