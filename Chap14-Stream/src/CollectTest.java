import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2020년도 2학기
 * @author 김상진
 * Stream의 최종 연산 collect 사용법
 */

class Student{
	private String name;
	private int year;
	public Student(String name, int year) {
		this.name = name;
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public int getYear() {
		return year;
	}
	@Override public String toString() {
		return String.format("%s: %d학년", name, year);
	}
}

enum PlayerType {BATTER, PITCHER};

class Player{
	private String name;
	private String team;
	private PlayerType type;
	public Player(String name, String team, PlayerType type) {
		this.name = name;
		this.team = team;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public String getTeam() {
		return team;
	}
	public PlayerType getType() {
		return type;
	}
	public String toString() {
		return String.format("%s, %s, %s", team, type==PlayerType.BATTER? "타자": "투수", name);
	}
}

public class CollectTest {
	public static void toMapTest_Student() {
		List<Student> list = 
			Arrays.asList(new Student("홍길동",1),new Student("장길산",2),
					new Student("장보고",4),new Student("임꺽정",1));
		Map<String,Student> studentMap =
			list.stream().collect(
				Collectors.toMap(Student::getName, Function.identity()));
		System.out.println(studentMap.get("장보고").getYear());
	}	
	public static void toArray_test() {
		List<String> list = Arrays.asList("lion","tiger","zebra","elephant");
		String[] result = 
			list.stream().filter(s->s.length()>4).toArray(String[]::new);
		System.out.println(Arrays.toString(result));
		
		int[] array = {3,2,5,4,8,10,11,6,13};
		array = IntStream.of(array).filter(x->(x&1)==1).toArray();
		System.out.println(Arrays.toString(array));
		
		int[] nums = IntStream.rangeClosed(1, 10).toArray();
		System.out.println(Arrays.toString(nums));
	}
	public static void toList_test() {
		List<String> list = Arrays.asList("lion","tiger","zebra","elephant");
		List<String> result = 
			list.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
		result.forEach(System.out::println);
		List<String> fruits = Arrays.asList("apple","melon","kiwi","mango", "orange", "apple", 
				"cherry", "banana");
		ArrayList<String> fruit5 = fruits.stream().distinct()
					.filter(s->s.length()==5).map(String::toUpperCase)
						.collect(Collectors.toCollection(ArrayList<String>::new));
		System.out.println(fruit5);
	}
	public static void toSet_test() {
		List<String> animals = Arrays.asList("lion","tiger","lion","zebra","elephant","zebra");
		Set<String> animalSet = animals.stream().collect(Collectors.toSet());
		System.out.println(animalSet.size());
		System.out.println(animalSet.contains("zebra"));
	}
	public static void toMap_test01() {
		List<String> animals = Arrays.asList("lion","tiger","lion","zebra","elephant","tiger");
		Map<String, Long> animalCountMap = animals.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		for(var entry: animalCountMap.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}	
	}
	public static void toMap_test02() {
		List<Student> list = Arrays.asList(
			new Student("홍길동",1), new Student("장길산",2),
			new Student("장보고",4), new Student("임꺽정",1));
		Map<String,Student> studentMap = list.stream()
			.collect(Collectors.toMap(Student::getName, Function.identity()));
		System.out.println(studentMap.get("장보고"));
	}
	public static void grouping_test() {
		List<Player> list = Arrays.asList(new Player("양의지", "NC", PlayerType.BATTER), 
				new Player("정수빈", "두산", PlayerType.BATTER), 
				new Player("김재환", "두산", PlayerType.BATTER),
				new Player("이용찬", "두산", PlayerType.PITCHER));
		Map<String, List<Player>> teamMap = list.stream()
			.collect(Collectors.groupingBy(Player::getTeam));
		List<Player> doosan = teamMap.get("두산");
		doosan.forEach(System.out::println);
		Map<String, Long> playerCount = list.stream()
			.collect(Collectors.groupingBy(Player::getTeam, Collectors.counting()));
		System.out.println(playerCount.get("두산"));
		
		Map<PlayerType, Set<Player>> playerTypeMap = list.stream()
				.collect(Collectors.groupingBy(Player::getType, Collectors.toSet()));
		Set<Player> batter = playerTypeMap.get(PlayerType.BATTER);
		batter.forEach(System.out::println);
	}
	public static void partitioning_test() {
		List<Player> list = Arrays.asList(new Player("양의지", "NC", PlayerType.BATTER), 
			new Player("정수빈", "두산", PlayerType.BATTER), 
			new Player("김재환", "두산", PlayerType.BATTER),
			new Player("이용찬", "두산", PlayerType.PITCHER));
		Map<Boolean, List<Player>> pitcherBatterList = list.stream()
			.collect(Collectors.partitioningBy(p -> p.getType()==PlayerType.BATTER));
		List<Player> pitchers = pitcherBatterList.get(false);
		pitchers.forEach(System.out::println);
	}
	public static void main(String[] args) {
		//toArray_test();
		toList_test();
		//toSet_test();
		//toMap_test01();
		//toMap_test02();
		//grouping_test();
		//partitioning_test();
	}

}
