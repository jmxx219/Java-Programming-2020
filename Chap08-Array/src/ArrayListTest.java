import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class A implements Cloneable{
	private int n = 0;
	public A(int n) {
		this.n = n;
	}
	public void set(int n) {
		this.n = n;
	}
	public int get() {
		return n;
	}
	public A clone() {
		A cloned = null;
		try {
			cloned = (A)super.clone();
		}
		catch(Exception e){}
		return cloned;
	}
	
}

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기 
 * @author 김상진
 * ArrayList 예제
 */
public class ArrayListTest {
	// 불변객체가 아닌 객체를 ArrayList에 추가하였을 경우 
	// 해당 참조를 가지고 있으면 ArrayList에 유지된 객체를 밖에서 변경할 수 있음
	public static void cloneTest() {
		ArrayList<A> list = new ArrayList<>();
		A a1 = new A(10);
		A a2 = new A(5);
		list.add(a1);
		list.add(a2.clone());
		list.add(new A(3));
		for(var o: list) System.out.println(o.get());
		a1.set(5);;
		for(var o: list) System.out.println(o.get());
	}
	// ArrayList를 배열로 변경
	// toArrayTest01: 유지하는 객체가 불변객체
	// toArrayTest02: 유지하는 객체가 불변객체가 아님
	public static void toArrayTest01() {
		ArrayList<String> list = new ArrayList<>();
		list.add("apple");
		list.add("grape");
		list.add("melon");
		list.add("banana");
		list.add("blueberry");
		Object[] array = list.toArray();
		for(var s: array) System.out.println(s);
		array[2] = "kiwi";
		for(var s: list) System.out.println(s);
		
		String[] sList = new String[list.size()];
		list.toArray(sList);
		sList[2] = "kiwi";
		for(var s: list) System.out.println(s);
	}
	public static void toArrayTest02() {
		ArrayList<StringBuilder> list = new ArrayList<>();
		list.add(new StringBuilder("apple"));
		list.add(new StringBuilder("grape"));
		list.add(new StringBuilder("melon"));
		list.add(new StringBuilder("banana"));
		list.add(new StringBuilder("blueberry"));
		Object[] array = list.toArray();
		for(var s: array) System.out.println(s);
		((StringBuilder)array[2]).append("kiwi");
		for(var s: list) System.out.println(s);
		
		StringBuilder[] sList = new StringBuilder[list.size()];
		list.toArray(sList);
		sList[2].append("kiwi");
		for(var s: list) System.out.println(s);
		
	}
	public static void arrayToList() {
		String[] fruits = {"apple","grape","banana","kiwi"};
		List<String> list01 = Arrays.asList(fruits);
		// List 리모콘으로는 추가가 가능하지 않음
		// list01.add("melon");
		for(var fruit: list01) System.out.println(fruit);
		
		ArrayList<String> list02 = new ArrayList<>();
		list02.addAll(Arrays.asList(fruits));
		list02.add("melon");
		for(var fruit: list02) System.out.println(fruit);
		
		ArrayList<String> other = new ArrayList<>();
		Collections.addAll(other, fruits);
		other.add("strawberry");
		for(var fruit: other) System.out.println(fruit);
		
	}
	public static void setTest() {
		ArrayList<String> list = new ArrayList<>();
		list.add("apple");
		list.add("grape");
		list.set(0, "banana");
		for(var fruit: list) System.out.println(fruit);
	}
	public static void main(String[] args) {
		//setTest();
		//toArrayTest01();
		toArrayTest02();
		//arrayToList();
		//cloneTest();
	}

}
