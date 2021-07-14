import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 파일명: ObtainedCardsTest.java
 * @author 손지민 2019136072
 * @version 2020년도 2학기
 * 학기과제1. 고스톱
 */

public class ObtainedCardsTest {

	//Test1
//	public static void main(String[] args) {
//		ObtainedCards obtainedCards = new ObtainedCards();
//		List<Integer> numbers = IntStream.rangeClosed(1,50).boxed().collect(Collectors.toList());
//		Collections.shuffle(numbers);
//		int size = 20 + ThreadLocalRandom.current().nextInt(10);
//		for(int i=0; i < size; i++) {
//			obtainedCards.add(new Card(numbers.get(i)));
//		}
//		System.out.println(obtainedCards);
//		System.out.println(obtainedCards.computeScore());
//	}
	
	//Test2
	public static void main(String[] args) {
		ObtainedCards obtainedCards = new ObtainedCards();
		int[] numbers = {1,9,45,5,13,30,22,34,38}; //비포함 3광, 고도리, 청단
		//int[] numbers = {3,7,11,15,19,23,27,32,33,39,42,43,48}; // 쌍피 3개, 피10개
		//int[] numbers = {29, 45, 41, 13, 18, 2, 6, 35, 39, 40, 47, 23, 24, 20, 27, 16, 15, 12, 42, 33, 48};
		for(var num: numbers) {
			obtainedCards.add(new Card(num));
		}
		System.out.println(obtainedCards);
		System.out.println(obtainedCards.computeScore());
	}
}
