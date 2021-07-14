import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 *  한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2020년도 2학기
 *  @author 김상진 
 *  MapTest.java
 */
public class MapTest {
	public static void simpleMap_test() {
		Map<String, Integer> animals= new HashMap<>();
		animals.put("zebra", 5);
		animals.put("lion", 3);
		animals.put("tiger", 7);
		System.out.println(animals.get("zebra"));
		animals.put("zebra", 8);
		System.out.println(animals.get("zebra"));
		animals.remove("lion");
		animals.replace("tiger", 6); // key가 존재할 경우에만
		// animals.set("tiger", 6); 
		System.out.println(animals.get("tiger"));
		// 아래 두 가지 경우는 동일한 경우 
		// 주의사항. key 값 자체가 null일 수 있음
		System.out.println(animals.get("lion"));
		System.out.println(animals.get(null));
	}
	public static void enumMap_test() {
		Map<WeekDay, Integer> map = new EnumMap<>(WeekDay.class);
		map.put(WeekDay.SUN, 10);
		map.put(WeekDay.WED, 5);
		map.put(WeekDay.THU, 4);
		System.out.println(map.get(WeekDay.SUN));
		System.out.println(map.containsKey(WeekDay.SAT));		
	}
	// 동형 문자열 판단하기
	public static boolean isIsomorphic(String s, String t) {	
		if(s.length()!=t.length()) return false;	
		Map<Character,Character> map = new HashMap<>();	
		char[] S = s.toCharArray();	
		char[] T = t.toCharArray();
		for(int i=0; i<S.length; i++){		
			if(!map.containsKey(S[i])){			
				if(map.containsValue(T[i])) return false;			
				else map.put(S[i], T[i]);		
			}		
			else if(map.get(S[i])!=T[i]) return false;	
		}	
		return true;
	}
	public static void isIsomorphic_test() {
		System.out.println("add"+", egg: "+isIsomorphic("add","egg"));
		System.out.println("ooo"+", aab: "+isIsomorphic("ooo","abb"));
		System.out.println("soon"+", moon: "+isIsomorphic("soon","moon"));
		System.out.println("aba"+", ooo: "+isIsomorphic("aba","ooo"));
		System.out.println("kill"+", sing: "+isIsomorphic("kill","sing"));
	}
	public static void main(String[] args) {
		simpleMap_test();
		enumMap_test();
		isIsomorphic_test();
	}
}
