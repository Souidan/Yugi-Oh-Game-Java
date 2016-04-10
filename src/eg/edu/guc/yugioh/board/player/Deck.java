package eg.edu.guc.yugioh.board.player;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.*;
public class Deck {
private static ArrayList<Card> monsters= new ArrayList<Card>(30);

private static ArrayList<Card> spells= new ArrayList<Card>(10);

private final ArrayList<Card> deck= new ArrayList<Card>(20);
private static int top;

public Deck() throws IOException {
	this.monsters=loadFileMonsters("Database-Monsters.csv");
	this.spells=loadFileSpells("Database-Spells.csv");
	
	buildDeck(monsters,spells);
	shuffleDeck();
	top=19;
	
	
		
	}
public static ArrayList<Card> loadFileMonsters(String path) throws IOException{
	ArrayList<Card> M=new ArrayList<Card>(30);
	String currentLine = "";
	
	FileReader fileReader= new FileReader(path);
	BufferedReader br = new BufferedReader(fileReader);
	
	while ((currentLine = br.readLine()) != null) {

	String temp=currentLine;
	String result[]=temp.split(",");
		
			MonsterCard MC=new MonsterCard (result[1],result[2],(Integer.parseInt(result[5])),Integer.parseInt(result[3]),Integer.parseInt(result[4]));
			M.add(MC);
			
			
		}
			
	
	
	
	return M;}


public static ArrayList<Card> loadFileSpells(String path) throws IOException{
	ArrayList<Card> S=new ArrayList<Card>(10);
	String currentLine = "";
	int i=0;
	FileReader fileReader= new FileReader(path);
	BufferedReader br = new BufferedReader(fileReader);
	while ((currentLine = br.readLine()) != null) {
	String temp=currentLine;
	String result[]=temp.split(",");
	


			switch (result[1]){
			case("Card Destruction"):CardDestruction COD=new CardDestruction();S.add(i,COD);break;
			case("Change Of Heart"): ChangeOfHeart COF=new ChangeOfHeart();S.add(i,COF);break;
			case("Dark Hole"): DarkHole DH=new DarkHole();S.add(i,DH);break;
			case("Graceful Dice"):GracefulDice GD=new GracefulDice();S.add(i,GD);System.out.println(S.get(i).getName());break;
			case("Harpie's Feather Duster"):HarpieFeatherDuster HFP= new HarpieFeatherDuster();S.add(i,HFP);break;
			case("Heavy Storm"): HeavyStorm HS=new HeavyStorm();S.add(i,HS);break;
			case("Mage Power"):MagePower MP=new MagePower();S.add(i,MP);break;
			case("Monster Reborn"):MonsterReborn MR=new MonsterReborn();S.add(i,MR);break;
			case("Pot of Greed"):PotOfGreed POG= new PotOfGreed();S.add(i,POG);break;
			case("Raigeki"):Raigeki RG=new Raigeki();S.add(i,RG);break;
			
			
			}
			

		}
		
	
			
	System.out.println(S.size());
	return S;
}

private void shuffleDeck(){

	Collections.shuffle(deck);
}


public static ArrayList<Card> loadCardsFromFile(String path)throws IOException{
		String currentLine = "";
		ArrayList <Card> S=new ArrayList <Card>();
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
	int count=0;
		while ((currentLine = br.readLine()) != null) {
			String temp=currentLine;
			
			String res[]=temp.split(",");
			System.out.println(res[0]);
			count++;
			System.out.println(count);
			
				if(res[0].charAt(0)=='M'){
					MonsterCard mc = new MonsterCard(res[1],res[2],Integer.parseInt(res[5]),Integer.parseInt(res[3]),Integer.parseInt(res[4]));
					S.add(mc);
					System.out.println(mc.getName());
					
					}
				else { 
					
				
				switch (res[1]){
				case("Card Destruction"):CardDestruction COD=new CardDestruction();S.add(COD);break;
				case("Change Of Heart"): ChangeOfHeart COF=new ChangeOfHeart();S.add(COF);break;
				case("Dark Hole"): DarkHole DH=new DarkHole();S.add(DH);break;
				case("Graceful Dice"):GracefulDice GD=new GracefulDice();S.add(GD);break;
				case("Harpie's Feather Duster"):HarpieFeatherDuster HFP= new HarpieFeatherDuster();S.add(HFP);break;
				case("Heavy Storm"): HeavyStorm HS=new HeavyStorm();S.add(HS);break;
				case("Mage Power"):MagePower MP=new MagePower();S.add(MP);break;
				case("Monster Reborn"):MonsterReborn MR=new MonsterReborn();S.add(MR);break;
				case("Pot of Greed"):PotOfGreed POG= new PotOfGreed();S.add(POG);break;
				case("Raigeki"):Raigeki RG=new Raigeki();S.add(RG);break;
		}
				System.out.println(S.size());
			
				}
				
		
}
		return S;
}
		


private void buildDeck(ArrayList<Card> monstersA,ArrayList<Card> spellsA){
	ArrayList <Card> Monsters1=(ArrayList<Card>) monstersA.clone();
	ArrayList<Card> Spells1=(ArrayList<Card>)spellsA.clone();
	
	int count=0;
	for (int i=0;i<15;i++){
		int r=(int)Math.floor((Math.random() * 30));
		MonsterCard tmp= (MonsterCard) Monsters1.get(r);
		deck.add(i,tmp);
		tmp.setLocation(Location.DECK);
		
	count=i;
	}
	for (int i=0;i<5;i++){
		int k=(int)Math.floor((Math.random() * 9));
		SpellCard stmp=(SpellCard) Spells1.get(k);
		deck.add(count,stmp);
		stmp.setLocation(Location.DECK);
		
		count++;
	}
	
	
}

public static ArrayList<Card> getMonsters() {
	return monsters;
}
public static void setMonsters(ArrayList<Card> monsters) {
	Deck.monsters = monsters;
}
public static ArrayList<Card> getSpells() {
	return spells;
}
public static void setSpells(ArrayList<Card> spells) {
	Deck.spells = spells;
}
public static int getTop() {
	return top;
}
public static void setTop(int top) {
	Deck.top = top;
}
public ArrayList<Card> getDeck() {
	return deck;
}
public ArrayList<Card> drawNCards(int n){
	ArrayList<Card> result=new ArrayList<Card>(n);
	
	int size=deck.size();
	if (n>size)
		System.out.println("ERROR:Not enough cards in deck");
	for (int i=1;i<=n;i++){
		result.add(deck.remove(size-i));
		
		top--;
	}
	return result;
}

public Card drawOneCard(){
	Card c=deck.remove(top);
	c.setLocation(Location.HAND);
	top--;
	return c;
}

            

}




