package eg.edu.guc.yugioh.board;
import java.io.IOException;




import eg.edu.guc.yugioh.board.player.*;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.GracefulDice;
public class Board {
	private Player activePlayer;
	private Player opponentPlayer;
	private Player winner;
	public Board(){
		Card.setBoard(this);
	
	}
		public void whoStarts(Player p1,Player p2){
			int number=(int)Math.floor((Math.random() * 2) + 1);
			
			switch(number){
			case 1:activePlayer=p1;opponentPlayer=p2;break;
			case 2:activePlayer=p2;opponentPlayer=p1;break;
			}
		}
		public void startGame(Player p1,Player p2){
		whoStarts(p1,p2)	;
		p1.getField().addNCardsToHand(5);
	    p2.getField().addNCardsToHand(5);
		
	     activePlayer.getField().addCardToHand();	
		}
	
		public void nextPlayer(){
			Player tmp=activePlayer;
			activePlayer=opponentPlayer;
			opponentPlayer=tmp;
			activePlayer.getField().addCardToHand();
		}
		
		public Player getActivePlayer() {
			return activePlayer;
		}
		public void setActivePlayer(Player activePlayer) {
			this.activePlayer = activePlayer;
		}
		public Player getOpponentPlayer() {
			return opponentPlayer;
		}
		public void setOpponentPlayer(Player opponentPlayer) {
			this.opponentPlayer = opponentPlayer;
		}
		public Player getWinner() {
			return winner;
		}
		public void setWinner(Player winner) {
			this.winner = winner;
		}
	
	}


