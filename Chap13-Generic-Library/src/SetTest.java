import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 *  한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2019년도 2학기
 *  @author 김상진 
 *  SetTest.java
 */

enum WeekDay {
	SUN, MON, TUE, WED, THU, FRI, SAT
}

public class SetTest {
	public static void integerSet_test() {
		Set<Integer> s = new HashSet<>();
		s.add(5);
		s.add(3);
		s.add(7);
		s.add(5);
		System.out.println(s.size());
		System.out.println(s.contains(5));
		s.remove(3);
		System.out.println(s.size());
	}
	public static void enumSet_test() {
		Set<WeekDay> weekend = EnumSet.<WeekDay>of(WeekDay.SUN, WeekDay.SAT);
		Set<WeekDay> workingDay = EnumSet.range(WeekDay.MON, WeekDay.FRI);
		WeekDay w = WeekDay.MON;
		if(weekend.contains(w)) System.out.println(w+" is a weekend");
		if(workingDay.contains(w)) System.out.println(w+" is a working day");
	}
	public static boolean containDuplicates(int[] list) {
		if(list==null||list.length<=1) return false;
		Set<Integer> set = new HashSet<>();
		for(int n: list)
			if(set.contains(n)) return true; 
			else set.add(n);
		return false;
	}
	// 중복 검사
	public static void containDuplicates_test() {
		int[] list = {1,3,4,2,7,9,11,0,-1};
		System.out.println(containDuplicates(list));
		list = new int[]{1,3,4,3,9,9,0,1};
		System.out.println(containDuplicates(list));
 	}
	public static void main(String[] args) {
		integerSet_test();
		enumSet_test();
		containDuplicates_test();
	}

}
