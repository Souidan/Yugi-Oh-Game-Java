package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.board.player.*;

public class PotOfGreed extends SpellCard {
	public PotOfGreed() {
		super("Pot of Greed", "Draw 2 extra cards.");

	}
	public PotOfGreed(String s1 , String s2) {
		super(s1,s2);

	}
	public void action(MonsterCard monster){
		 getBoard().getActivePlayer().getField().addNCardsToHand(2);
	}
	public static void main(String[] args) {
		PotOfGreed pog=new PotOfGreed();
		
		
	}

}
