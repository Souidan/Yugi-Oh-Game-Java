package eg.edu.guc.yugioh.board.player;

import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class Player {

	private final String name;
	private int lifePoints;
	private final Field field;
	public Player(String name) throws IOException{
		this.name=name;
		lifePoints=8000;
		field=new Field();
	}
	
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	public String getName() {
		return name;
	}
	public Field getField() {
		return field;
	}
	
	
}
