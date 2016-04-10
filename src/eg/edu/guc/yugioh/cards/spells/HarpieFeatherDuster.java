package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class HarpieFeatherDuster extends SpellCard {
	public HarpieFeatherDuster() {
		super("Harpie's Feather Duster",
				"Destroy all spell cards your opponent controls.");
	}
	public HarpieFeatherDuster(String s1,String s2){
		super(s1,s2);
		
	}
	public  void action(MonsterCard Monster){
		getBoard().getOpponentPlayer().getField().removeSpellToGraveyard(getBoard().getOpponentPlayer().getField().getSpellArea());
	}
}
