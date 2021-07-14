import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2020년도 2학기
 * @author 김상진
 * 최종 연산 사용법 
 */
public class TerminalOperationTest {
	public static void sum_test() {
		int[] iArray = {1,5,3,7,2};
		int sum = IntStream.of(iArray).filter(n->n%2==1).sum();
		System.out.println(sum);
	}
	public static void reduce_test() {
		List<Integer> list = Arrays.asList(1,5,3,7,2);
		Optional<Integer> optionSum 
			= list.stream().filter(n->n%2==1).reduce(Integer::sum);
		System.out.println(optionSum.get());
		int sum = list.stream().filter(n->n%2==1).reduce(0, Integer::sum);
		System.out.println(sum);
	}
	public static void summarizing_test() {
		List<Integer> list = Arrays.asList(1,7,3,5,11);
		IntSummaryStatistics summary = 	
			list.stream().collect(Collectors.summarizingInt(x->x));
		System.out.printf("합계: %d, 평균: %.2f, 최대값: %d, 최소값: %d%n", 	
			summary.getSum(), summary.getAverage(), summary.getMax(), summary.getMin());
	}
	public static void joining_test() {
		List<String> list = Arrays.asList("lion","tiger","zebra","elephant");
		String result = list.stream().collect(Collectors.joining(", "));
		System.out.println(result);
	}
	public static void main(String[] args) {
		//summarizing_test();
		joining_test();
	}

}
