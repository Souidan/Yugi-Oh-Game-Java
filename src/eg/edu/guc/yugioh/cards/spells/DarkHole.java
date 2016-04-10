package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class DarkHole extends Raigeki {
	public DarkHole() {
		super("Dark Hole", "Destroy all monsters on the field.");
	}
	public DarkHole(String s1,String s2){
		super(s1,s2);
	}
	public void action(MonsterCard m){
		super.action(m);
		getBoard().getActivePlayer().getField().removeMonsterToGraveyard(getBoard().getActivePlayer().getField().getMonstersArea());
	}
}
