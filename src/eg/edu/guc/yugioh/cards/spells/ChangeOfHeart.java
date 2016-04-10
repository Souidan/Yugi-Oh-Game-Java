package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class ChangeOfHeart extends SpellCard {
	public ChangeOfHeart() {
		super("Change Of Heart",
				"You choose one monster from your opponent and add it to your own monsters. ");
	}
	public ChangeOfHeart(String s1, String s2) {
		super(s1,s2);
	}
	public void action(MonsterCard monster){
		int index=getBoard().getOpponentPlayer().getField().getMonstersArea().indexOf(monster);
		MonsterCard MC=getBoard().getOpponentPlayer().getField().getMonstersArea().remove(index);
		getBoard().getActivePlayer().getField().getMonstersArea().add(MC);
	    
		
	}
}
