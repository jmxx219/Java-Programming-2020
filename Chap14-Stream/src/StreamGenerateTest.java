import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2020년도 2학기
 * @author 김상진
 * 스트림의 생성 
 */
public class StreamGenerateTest {
	public static void iterateTest() {
		List<Integer> numbers =
			Stream.iterate(3, n->n+3).limit(10).collect(Collectors.toList());
		System.out.println(numbers);
	}
	public static void randomGeneration() {
		List<Integer> randoms = 
			Stream.generate(ThreadLocalRandom.current()::nextInt)
				.filter(x->x>0).limit(10).collect(Collectors.toList());
		System.out.println(randoms);
	}
	public static void primeGeneration() {
		List<Integer> primes //= Stream.generate(ThreadLocalRandom.current()::nextInt)
			= Stream.generate(()->ThreadLocalRandom.current().nextInt(1000))
			.filter(n->n>0).map(BigInteger::valueOf)
			.filter(n->n.isProbablePrime(10)).map(BigInteger::intValue)
			.limit(10).collect(Collectors.toList());
		System.out.println(primes);
	}
	public static void primitiveArrayToStream() {
		int[] numbers = {1,2,5,3,9};
		long count = Arrays.stream(numbers).filter(n->(n&1)==1).count();
		System.out.println(Arrays.toString(numbers)+": 홀수의 개수: "+count);
		count = IntStream.of(numbers).filter(n->(n&1)==0).count();
		System.out.println(Arrays.toString(numbers)+": 짝수의 개수: "+count);
		char[] characters = {'a','x','d','e','g','x'};
		//count = Arrays.stream(characters).filter(c->"aeiou".indexof(c)!=-1).count();  // error
		//count = IntStream.of(characters).filter(Character::isLowerCase).count();	// error
		count = String.valueOf(characters).chars().filter(c->c=='x').count();
		System.out.println(Arrays.toString(characters)+": x 문자 수: "+count);
		count = IntStream.range(0, characters.length).mapToObj(i->characters[i]).filter(c->c=='x').count();
		System.out.println(Arrays.toString(characters)+": x 문자 수: "+count);
	}
	public static void main(String[] args) {
		//iterateTest();
		//randomGeneration();
		//primeGeneration();
		//primitiveArrayToStream();
	}

}
