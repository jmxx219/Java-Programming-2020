import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2019년도 1학기
 *  @author 김상진 
 *  CollectionsTest.java
 */
public class CollectionsTest {
	public static void collections_test() {
		String[] sList = {"apple", "grape", "banana", "strawberry", "kiwi"};
		List<String> list = Arrays.asList(sList);
		System.out.println(Collections.min(list));
		System.out.println(Collections.max(list));
		Collections.sort(list);
		System.out.println(list.get(0));
		Collections.reverse(list);
		System.out.println(list.get(0));
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
	}
	public static void main(String[] args) {
		collections_test();
	}

}
