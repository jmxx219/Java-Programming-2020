import java.util.Arrays;
/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기 
 * @author 김상진
 * 배열 복제 또는 복사
 */
public class ArrayCloneTest {
	// clone을 이용한 배열 복제
	// 배열 자체가 가지고 있는 기능
	// 같은 용량의 동일 내용의 배열을 만들 때 유용함
	public static void cloneTest() {
		int[] list = {1,2,3,4,5};
		int[] copy = list.clone();
		copy[0] = 0;
		System.out.println("Using clone");
		System.out.println(Arrays.toString(list));
		System.out.println(Arrays.toString(copy));
	}
	// System.arraycopy를 이용한 배열 복사
	// clone과 달리 공간 확보를 직접해야 함
	// 장점. 배열의 일부만 복사할 수 있음
	// 단점. 미리 공간이 확보되어 있어야 함
	public static void SystemArraycopy() {
		int[] list = {1,2,3,4,5};
		int[] copy = new int[list.length];
		int[] other = {1,1,1,1,1};
		System.out.println("Using System.arraycopy");
		System.arraycopy(list, 0, copy, 0, list.length);
		System.arraycopy(list, 2, other, 0, list.length-2);
		copy[0] = 0;
		System.out.println(Arrays.toString(list));
		System.out.println(Arrays.toString(copy));
		System.out.println(Arrays.toString(other));
	}
	// Arrays.copyOf를 사용한 복제
	// 장점. 복사할 때 용량을 조절할 수 있음
	public static void arraysCopyOf() {
		int[] list = {1,2,3,4,5};
		int[] copy = Arrays.copyOf(list, list.length);
		int[] other1 = Arrays.copyOf(list, list.length*2);
		int[] other2 = Arrays.copyOf(list, list.length/2);
		copy[0] = 0;
		System.out.println("Using Arrays.copyOf");
		System.out.println(Arrays.toString(list));
		System.out.println(Arrays.toString(copy));
		System.out.println(Arrays.toString(other1));
		System.out.println(Arrays.toString(other2));
	}
	public static void main(String[] args) {
		cloneTest();
		SystemArraycopy();
		arraysCopyOf();
	}

}
