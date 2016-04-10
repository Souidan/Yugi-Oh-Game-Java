package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class Raigeki extends SpellCard {
	public Raigeki() {
		super("Raigeki", "Destroy all monsters your opponent controls.");
	}
	public Raigeki(String s1, String s2) {
		super(s1, s2);
	}
    public  void action(MonsterCard m){
    	getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(getBoard().getOpponentPlayer().getField().getMonstersArea());
    }
}
