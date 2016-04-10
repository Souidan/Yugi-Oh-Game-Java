package eg.edu.guc.yugioh.cards.spells;
import eg.edu.guc.yugioh.board.player.*;
import eg.edu.guc.yugioh.cards.*;
import java.util.ArrayList;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class CardDestruction extends SpellCard {
	public CardDestruction() {
		super(
				"Card Destruction",
				"Each player discards their entire hand, then draws the same number of cards they discarded.");

	}
	public CardDestruction(String s1, String s2) {
		super(s1,s2);

	}
	public void action(MonsterCard M){
		ArrayList<Card>arr1=getBoard().getActivePlayer().getField().getHand();
		int arr1Size=arr1.size();
		ArrayList<Card>arr2=getBoard().getOpponentPlayer().getField().getHand();
		int arr2Size=arr2.size();
		getBoard().getActivePlayer().getField().removeNCardsFromHand(arr1);
		getBoard().getOpponentPlayer().getField().removeNCardsFromHand(arr2);
		getBoard().getActivePlayer().getField().addNCardsToHand(arr1Size);
		getBoard().getOpponentPlayer().getField().addNCardsToHand(arr2Size);
		

	}

}
