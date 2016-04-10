package eg.edu.guc.yugioh.board.player;

import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class Field {
	private Phase phase;
	private final ArrayList<MonsterCard> monstersArea;
	private final ArrayList<SpellCard> spellArea;
	private final Deck deck;
	private final ArrayList<Card> hand;
	private final ArrayList<Card> graveyard;

	public Field() throws IOException {
		deck = new Deck();
		monstersArea = new ArrayList<MonsterCard>(5);
		spellArea = new ArrayList<SpellCard>(5);
		hand = new ArrayList<Card>(10000);
		graveyard = new ArrayList<Card>();
		phase=Phase.MAIN1;
	}

	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	
	public boolean FreeSpaceMonsters(){
		
		return (monstersArea.size()!=5);	
			
		}


	public boolean FreeSpaceSpells(){
		return (spellArea.size()!=5);	
		}
public int countSacrifices(MonsterCard monster){
			int level=monster.getLevel();
			int neededSacrifices=0;
			switch(level){
				case(1):
				case(2):
				case(3):
				case(4):neededSacrifices=0;break;
				case(5):
				case(6):neededSacrifices=1;break;
				case(7):
				case(8):neededSacrifices=2;break;
				
		}
	return neededSacrifices;
		}
		
		
public void addMonsterToField(MonsterCard monster,Mode m,boolean isHidden){
	if (!FreeSpaceMonsters())
		System.out.println("Sorry Monster Area is Full!!Can not add any more Monsters");
	else{
		monster.setMode(m);
		monster.setHidden(isHidden);
		monster.setLocation(Location.FIELD);
		monstersArea.add(monster);
	}
	
	}
	public void addMonsterToField(MonsterCard monster,Mode mode,ArrayList<MonsterCard>sacrifices){
		if (!FreeSpaceMonsters()){
			
		
			System.out.println("Sorry Monster Area is Full!!Can not add any more Monsters");
			return;}
		else{
			monster.setMode(mode);
			
			while(!sacrifices.isEmpty()){
				MonsterCard m=sacrifices.remove(0);
				
				graveyard.add(m);
				monstersArea.remove(m);
				m.setLocation(Location.GRAVEYARD);
			}
			}
			monster.setLocation(Location.FIELD);
			monstersArea.add(monster);
			
		}
		
	

	
	public void removeMonsterToGraveyard(MonsterCard monster){
		int index=monstersArea.indexOf(monster);
		graveyard.add(monstersArea.remove(index));
		monster.setLocation(Location.GRAVEYARD);
		
		
	}
	public void removeMonsterToGraveyard(ArrayList<MonsterCard>monsters){
		
		while(!monsters.isEmpty()){
			MonsterCard MC=monsters.remove(0);
			
			graveyard.add(MC);
			monstersArea.remove(MC);
			MC.setLocation(Location.GRAVEYARD);
			
			
		}
		monsters.clear();
	}

	public void addSpellToField(SpellCard action,MonsterCard monster,boolean hidden){
		if (!FreeSpaceSpells())
			System.out.println("Sorry Spell Area is Full!!Can not add any more Spells");
		
		else{
			action.setHidden(hidden);
			if(hidden){
				monster=null;
				spellArea.add(action);
				action.setLocation(Location.FIELD);
				return;
			}
			else{
			switch (action.getName()){
			
			case ("Dark Hole"):
			case ("Harpie's Feather Duster"):
			case ("Heavy Storm"):
			case ("Pot of Greed"):
			case ("Graceful Dice"):
			case("Monster Reborn"):
			case ("Raigeki"):monster=null;break;
			}
			if(action.getName()=="Card Destruction"){
				action.action(null);
				return;
			}
			spellArea.add(action);
			action.setLocation(Location.FIELD);
			
			action.action(monster);
			removeSpellToGraveyard(action);
			System.out.println();
			
		}
	}
	}
	public void activateSetSpell(SpellCard action,MonsterCard monster){
		int index=spellArea.indexOf(action);
		if (index==-1)
			return;
		SpellCard temp=spellArea.get(index);
		temp.setHidden(false);
		switch (temp.getName()){
		case("Card Destruction"):
		case ("Dark Hole"):
		case ("Harpie's Feather Duster"):
		case ("Heavy Storm"):
		case ("Pot of Greed"):
		case ("Graceful Dice"):
		case("Monster Reborn"):		
		case ("Raigeki"):monster=null;break;
		}
		action.action(monster);
		action.setLocation(Location.GRAVEYARD);
		removeSpellToGraveyard(action);
		
	}
	public void removeSpellToGraveyard(SpellCard spell){
		
		graveyard.add(spell);
		spellArea.remove(spell);
		spell.setLocation(Location.GRAVEYARD);
}
	public void removeSpellToGraveyard(ArrayList<SpellCard>spells){
	
		while(!spells.isEmpty()){
			SpellCard SP=spells.get(0);

			spells.remove(0);
			graveyard.add(SP);
			spellArea.remove(SP);
			SP.setLocation(Location.GRAVEYARD);
		}
		
	}
	public void removeNCardsFromHand(ArrayList<Card>arr){
		
		while (!hand.isEmpty()){
			Card c=hand.get(0);
			c.setLocation(Location.GRAVEYARD);
            graveyard.add(hand.remove(0));
             
			}
		
		}
	
		
	public void addCardToHand(){
		Card c=deck.drawOneCard();
		hand.add(c);
		c.setLocation(Location.HAND);
		
	}
	public void addNCardsToHand(int n){
		ArrayList<Card> tmp = new ArrayList<Card>(n);
		tmp= deck.drawNCards(n);
		int i=0;
		while(!tmp.isEmpty()){
			Card c=tmp.remove(0);
			hand.add(c);
			c.setLocation(Location.HAND);
			i++;
			
		}
	}

	public ArrayList<MonsterCard> getMonstersArea() {
		return monstersArea;
	}

	public ArrayList<SpellCard> getSpellArea() {
		return spellArea;
	}

	public Deck getDeck() {
		return deck;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public ArrayList<Card> getGraveyard() {
		return graveyard;
	}

	
	
	}






