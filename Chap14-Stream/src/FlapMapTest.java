import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2020년도 2학기
 * @author 김상진
 * Stream의 중간 연산 flatMap 사용법 
 */
public class FlapMapTest {
	public static void test1() {
		long count = Stream.of("Firmino", "Milner", "Mane", "Salah")
			.flatMap(s -> s.chars().mapToObj(Character::toLowerCase))
			//.filter(ch -> ch == 'a' || ch == 'A')
			.filter(ch -> ch == 'a')
			.count();
		System.out.println(count);
	}
	public static void test2() {
		long count = Stream.of("Firmino", "Milner", "Mane", "Salah")
			.flatMap(s -> s.chars().boxed())
			//.filter(ch -> ch == 'a' || ch == 'A')
			.filter(ch -> ch == 'a')
			.count();
		System.out.println(count);
	}
	public static void test3() {
		long count = Stream.of("Firmino", "Milner", "Mane", "Salah")
			.flatMap(name->IntStream.range(0, name.length()).mapToObj(name::charAt))
			.filter(ch -> ch == 'a' || ch == 'A')
			.count();
		System.out.println(count);
	}
	public static void test4() {
		long count = Stream.of("Firmino", "Milner", "Mane", "Salah")
			.flatMap(s -> s.chars().boxed())
			.filter(ch -> ch == 'a' || ch == 'A')
			.count();
		System.out.println(count);
	}
	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		test4();
	}

}
