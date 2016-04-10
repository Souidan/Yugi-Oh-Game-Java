package eg.edu.guc.yugioh.cards.spells;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.*;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class GracefulDice extends SpellCard {
	public GracefulDice() {
		super(
				"Graceful Dice",
				"Generates a random number between 1 and 10. All monsters you currently control gain ATK and DEF equal to the random number x 100");
	}
	public GracefulDice(String s1, String s2) {
		
				super(s1,s2);
	}
	public void action(MonsterCard monster){
		int r = (int)Math.floor((Math.random()*10)+1);
		r=r*100;
		if (getBoard().getActivePlayer().getField().getMonstersArea().isEmpty()){
			
		System.out.println("Monster Area is Empty!!");
			return;}
		int size=getBoard().getActivePlayer().getField().getMonstersArea().size();
		
		ArrayList<MonsterCard> mon=getBoard().getActivePlayer().getField().getMonstersArea();
		MonsterCard m=mon.get(0);
		
		
		for(int i=0;i<size;i++){
			m=mon.remove(0);
			m.setAttackPoints(m.getAttackPoints()+r);
			m.setDefensePoints(m.getDefensePoints()+r);
		mon.add(m);
}
		

}
	}