
public class SoccerPlayer {
	private String name;
	private int number;
	private String team;
	private Position position;
	public SoccerPlayer(String name, int number, Position position, String team) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}
	public Position getPosition() {
		return position;
	}
	public String getTeam() {
		return team;
	}
}
