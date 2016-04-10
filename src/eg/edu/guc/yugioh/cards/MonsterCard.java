package eg.edu.guc.yugioh.cards;

public class MonsterCard extends Card {
	private  int level;
	private int defensePoints;
	private int attackPoints;
	private Mode mode;

	public MonsterCard(String name, String description,int level, int attack,
			int defence) {
		super(name, description);
		if (level>8||level<1){
			System.out.println("Wronglevel set to default level 1");
			this.level=1;
		}
		else{
			
		this.level=level;}
			attackPoints = attack;
			defensePoints = defence;
			mode = Mode.DEFENSE;
		}
	

	

	public MonsterCard() {
		this("", "", 0, 0, 0);
	}

	public int getDefensePoints() {
		return defensePoints;
	}

	public void setDefensePoints(int defensePoints) {
		this.defensePoints = defensePoints;
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public int getLevel() {
		return level;
	}
	
	}


