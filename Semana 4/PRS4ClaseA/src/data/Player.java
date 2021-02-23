package data;

public class Player {
	
	
	private String name;
	private String nationality;
	private String position;
	
	private int speed;
	private int attack;
	private int defense;
	
	private Team team;
	
	public Player() {
		
	}
	
	public Player(String name, String nationality, String position, int speed, int attack, int defense) {
		this.name = name;
		this.nationality = nationality;
		this.position = position;
		this.speed = speed;
		this.attack = attack;
		this.defense = defense;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
}
