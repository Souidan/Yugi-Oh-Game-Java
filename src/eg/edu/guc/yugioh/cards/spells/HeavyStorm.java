package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class HeavyStorm extends HarpieFeatherDuster{
	public HeavyStorm() {
		super("Heavy Storm",
				"Destroy all spell cards on the board for both players");
	}
	public HeavyStorm(String s1, String s2) {
		super(s1,s2);
	}
public void action(MonsterCard monster){
	super.action(monster);
	getBoard().getActivePlayer().getField().removeSpellToGraveyard(getBoard().getActivePlayer().getField().getSpellArea());
}
}
