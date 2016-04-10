package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class MonsterReborn extends SpellCard {
	public MonsterReborn() {
		super(
				"Monster Reborn",
				" does not count in your own ''1 monster per turn'' rule. This monster does not require any sacrifices regardless its level. ");
	}
	public MonsterReborn(String s1, String s2) {
		super(s1,s2);
	}

	public MonsterCard getHisMaxMonster(){
		ArrayList<Card>grave=(ArrayList<Card>) getBoard().getOpponentPlayer().getField().getGraveyard();
	
	
		
		MonsterCard max=new MonsterCard();
		for (int i=0;i<grave.size();i++){
			MonsterCard TEMPREMOVE=(MonsterCard) grave.get(i);
			if(TEMPREMOVE instanceof MonsterCard){
				if (TEMPREMOVE.getAttackPoints()>max.getAttackPoints())
					max=TEMPREMOVE;
			}
		}
		if (max.getAttackPoints()==0)	
			System.out.println("ERRROR:No Monsters found in deck will return inaccuarte value!!");
			
		return max;
		
	}
	public MonsterCard getMyMaxMonster(){
		
		
		ArrayList <Card>grave =(ArrayList<Card>)getBoard().getActivePlayer().getField().getGraveyard();
		MonsterCard max=new MonsterCard();
		for(int i=0;i<grave.size();i++){
			MonsterCard TEMPREMOVE=(MonsterCard) grave.get(0);
			if(TEMPREMOVE instanceof MonsterCard){
				if (TEMPREMOVE.getAttackPoints()>max.getAttackPoints())
					max=TEMPREMOVE;
			}
		}
		if (max.getAttackPoints()==0)
			System.out.println("ERRROR:No Monsters found in deck will return inaccuarte value!!");
		return max;
		
	}
	public void action(MonsterCard monster){
		ArrayList <Card>mygrave=getBoard().getActivePlayer().getField().getGraveyard();
		ArrayList<Card> hisgrave=getBoard().getOpponentPlayer().getField().getGraveyard();
		MonsterCard MyMax= new MonsterCard();
		MonsterCard max=new MonsterCard();
		
		MonsterCard HisMax=new MonsterCard();
		MyMax=getMyMaxMonster();
		HisMax=getHisMaxMonster();
		if(MyMax.getAttackPoints()>HisMax.getAttackPoints()){
			max=MyMax;
		getBoard().getActivePlayer().getField().getMonstersArea().add(MyMax);
		MyMax.setLocation(Location.FIELD);
		mygrave.remove(MyMax);}
		else{
			max=HisMax;
			getBoard().getActivePlayer().getField().getMonstersArea().add(HisMax);
			hisgrave.remove(HisMax);
			HisMax.setLocation(Location.FIELD);
		}
			
			
		
		
		
		
		
		
		
	}
	
		
	}



