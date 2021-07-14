import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2020년도 2학기
 * @author 김상진
 * 일반 스트림과 parallel stream의 속도 비교 
 */
public class ParallelTest {
	public static void normalStringTest(List<String> list) {
		long startTime = System.nanoTime();
		System.out.println(
			list.stream().
				filter(s->s.startsWith("a")).count()
		);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("string test using stream: %,d%n",totalTime);
	}
	public static void parallelStringTest(List<String> list) {
		long startTime = System.nanoTime();
		System.out.println(
			list.parallelStream().
				filter(s->s.startsWith("a")).count()
		);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("string test using parallelstream: %,d%n",totalTime);
	}
	public static void normalIntTest(int[] list) {
		long startTime = System.nanoTime();
		System.out.println(
			Arrays.stream(list).
				filter(n->(n&1)==1).count()
		);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("Int test using Arrays: %,d%n",totalTime);
	}
	public static void normalIntTest_different(int[] list) {
		long startTime = System.nanoTime();
		System.out.println(
			IntStream.of(list).
				filter(n->(n&1)==1).count()
		);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("Int test using IntStream: %,d%n",totalTime);
	}
	public static void parallelIntTest(int[] list) {
		long startTime = System.nanoTime();
		System.out.println(
			Arrays.stream(list).parallel().
				filter(n->(n&1)==1).count()
		);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("Int test using Arrays, parallel: %,d%n",totalTime);
	}
	public static void parallelIntTest_different(int[] list) {
		long startTime = System.nanoTime();
		System.out.println(
			IntStream.of(list).parallel().
				filter(n->(n&1)==1).count()
		);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("Int test using IntStream, parallel: %,d%n",totalTime);
	}
	public static int[] createRandomIntList() {
		int[] list = new int[1000];
		ThreadLocalRandom randGen = ThreadLocalRandom.current();
		for(int i=0; i<list.length; i++)
			list[i] = randGen.nextInt(1000)+1;
		return list;
	}
	public static List<String> createRandomStringList(){
		List<String> list = new ArrayList<>();
		ThreadLocalRandom randGen = ThreadLocalRandom.current();
		for(int i=0; i<1000; i++) {
			StringBuilder s = new StringBuilder();
			for(int j=0; j<8; j++) {
				s.append((char)('a'+randGen.nextInt(26)));
			}
			list.add(s.toString());
		}
		return list;
	}
	public static void main(String[] args) {
		int[] list = createRandomIntList();
		normalIntTest(list);
		normalIntTest_different(list);
		parallelIntTest(list);
		parallelIntTest_different(list);
		List<String> sList = createRandomStringList();
		normalStringTest(sList);
		parallelStringTest(sList);
		
	}

}
