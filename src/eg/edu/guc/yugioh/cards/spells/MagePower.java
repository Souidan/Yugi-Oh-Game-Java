package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class MagePower extends SpellCard {
	public MagePower() {
		super(
				"Mage Power",
				"Choose one monster from the field. This monster gains 500 ATK and DEF for each Spell Card you have on the field.");
	}
	public MagePower(String s1, String s2) {
		super(s1,s2);
	}
	public void action(MonsterCard monster){
		ArrayList<SpellCard> S = getBoard().getActivePlayer().getField().getSpellArea();
		int size=S.size();
		int add=size*500;
		int total=monster.getAttackPoints()+add;
		monster.setAttackPoints(total);
		total=monster.getDefensePoints()+add;
		monster.setDefensePoints(total);
		
		
	}

}
