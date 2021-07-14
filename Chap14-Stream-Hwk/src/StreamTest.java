import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class StreamTest {
	// 다음을 스트림 라이브러리를 사용하여 바꾸세요.
	public static List<SoccerPlayer> getPlayersByTeam(String name){
		List<SoccerPlayer> list = new ArrayList<>();
		for(var player: getList())
			if(player.getTeam().equals(name)) list.add(player);
		return list;
	}
	// 다음을 스트림 라이브러리를 사용하여 바꾸세요.
	public static Map<Position, List<SoccerPlayer>> getPlayersByPosition(){
		Map<Position, List<SoccerPlayer>> map = new EnumMap<>(Position.class);
		for(var key: Position.values()) {
			map.put(key, new ArrayList<SoccerPlayer>());
		}
		for(var player: getList()){
			List<SoccerPlayer> list = map.get(player.getPosition());
			list.add(player);
		}
		return map;
	}
	// 다음을 스트림 라이브러리를 사용하여 바꾸세요.
	public static int count(Predicate<SoccerPlayer> predicate) {
		int count = 0;
		for(var player: getList())
			if(predicate.test(player)) ++count;
		return count;
	}
	public static void main(String[] args) {
		System.out.println(getPlayersByTeam("Liverpool"));
		System.out.println(getPlayersByPosition().get(Position.FORWARD));
		// 람다 표현식을 이용하여 다양한 함수를 전달해 보세요.
		System.out.println(count(p->p.getName().startsWith("H")));
	}
	public static List<SoccerPlayer> getList(){
		List<SoccerPlayer> list = Arrays.asList(
			new SoccerPlayer("Alisson Becker",1,Position.GOALKEEPER,"Liverpool"),
			new SoccerPlayer("Virgil Van Dijk",4,Position.DEFENDER,"Liverpool"),
			new SoccerPlayer("Trent Alexander-Arnold",66,Position.DEFENDER,"Liverpool"),
			new SoccerPlayer("Thiago Alcantara",6,Position.MIDFIELDER,"Liverpool"),
			new SoccerPlayer("Georginio Wijnaldum",5,Position.MIDFIELDER,"Liverpool"),
			new SoccerPlayer("Sadio Mane",10,Position.FORWARD,"Liverpool"),
			new SoccerPlayer("Mohamed Salah",11,Position.FORWARD,"Liverpool"),
			new SoccerPlayer("Hugo Loris",1,Position.GOALKEEPER,"Tottenham"),
			new SoccerPlayer("Eric Dier",15,Position.DEFENDER,"Tottenham"),
			new SoccerPlayer("Toby Alderweireld",4,Position.DEFENDER,"Tottenham"),
			new SoccerPlayer("Harry Winks",8,Position.MIDFIELDER,"Tottenham"),
			new SoccerPlayer("Dele Alli",20,Position.MIDFIELDER,"Tottenham"),
			new SoccerPlayer("Son Heung-Min",7,Position.FORWARD,"Tottenham"),
			new SoccerPlayer("Harry Kane",10,Position.FORWARD,"Tottenham"),
			new SoccerPlayer("Gerard Pique",3,Position.DEFENDER,"Barcelona"),
			new SoccerPlayer("Clement Lenglet",15,Position.DEFENDER,"Barcelona"),
			new SoccerPlayer("Frankie De Jong",21,Position.MIDFIELDER,"Barcelona"),
			new SoccerPlayer("Philippe Coutinho",14,Position.MIDFIELDER,"Barcelona"),
			new SoccerPlayer("Antoine Griezmann",7,Position.FORWARD,"Barcelona"),
			new SoccerPlayer("Lionel Messi",10,Position.FORWARD,"Barcelona"),
			new SoccerPlayer("Manuel Neur",1,Position.GOALKEEPER,"Bayern Munich"),
			new SoccerPlayer("Alphonso Davies",19,Position.DEFENDER,"Bayern Munich"),
			new SoccerPlayer("David Alaba",27,Position.DEFENDER,"Bayern Munich"),
			new SoccerPlayer("Leon Goretzka",18,Position.MIDFIELDER,"Bayern Munich"),
			new SoccerPlayer("Thomas Muller",25,Position.MIDFIELDER,"Bayern Munich"),
			new SoccerPlayer("Leroy Sane",10,Position.FORWARD,"Bayern Munich"),
			new SoccerPlayer("Robert Lewandowski",9,Position.FORWARD,"Bayern Munich")
		);
		return list;
	}
}
