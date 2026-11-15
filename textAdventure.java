import java.util.ArrayList;
public class textAdventure{
	int torch = 4;
	ArrayList<Integer> monsterDeck = new ArrayList<>();
	ArrayList<Integer> trapsDeck = new ArrayList<>();
	ArrayList<Integer> sealedDeck = new ArrayList<>();
	ArrayList<Integer> healthDeck = new ArrayList<>();
	ArrayList<Integer> items = new ArrayList<>();
	int devineFavor = 0;
	int score  =0;
	boolean works = true;
	int test = 0;


	public void main(String []arg){
		addInList(monsterDeck);
		addInList(trapsDeck);
		addInList(sealedDeck);
		addInList(healthDeck);
		healthDeck.add(14);

		while(torch != 0 && !(monsterDeck.isEmpty()||trapsDeck.isEmpty()||sealedDeck.isEmpty()||sealedDeck.isEmpty())){
			randomDeck();
		}


	}

	public void addInList(ArrayList<Integer> deck){
		for(int x = 0; x < 14; x++){
			deck.add(x);
		}

	}

	public void randomDeck(){
		int randomDeck = (int)Math.random()*4;
		int randomCard = (int)Math.random()*13;
		works = true;
		while(works){
			if(randomDeck == 0 && !(trapsDeck.isEmpty())){
				//trapsDeck(randomCard);
			}
			if(randomDeck == 1 && !(monsterDeck.isEmpty())){
				//monsterDeck(randomCard);
			}
			if(randomDeck == 2 && !(sealedDeck.isEmpty())){
				/*
				randomCard = (int)(Math.random()*sealedDeck.size()-1);
				sealedDeck(randomCard);*/
				
			}
			if(randomDeck == 3 && !(healthDeck.isEmpty())){ 
				/*	
				randomCard = (int)(Math.random()*healthDeck.size());
				if(healthDeck.get(randomCard) < 2 || healthDeck.get(randomCard) > 10){
					healthDeck(randomCard);
				}
				else{
					healthDeck.remove(randomCard);
				}
				*/
				
			}
			randomDeck = (int)(Math.random()*4);
		} 
	}
	public void trapsDeck(int randomCard){
		if(trapsDeck.get(randomCard) == 1){
			works = false;
			torch--;
			trapsDeck.remove(randomCard);
			System.out.println("Your torch burned out!");
		}
		else if(trapsDeck.get(randomCard) == 2){
			works = false;
			trapsDeck.remove(randomCard);
			System.out.println("You found a poorly concealed trap(2)!");
		}
		else if(trapsDeck.get(randomCard) == 3){
			works = false;
			trapsDeck.remove(randomCard);
			System.out.println("You found a poorly concealed trap(3)!");
		}
		else if(trapsDeck.get(randomCard) == 4){
			works = false;
			trapsDeck.remove(randomCard);
			System.out.println("You found a poorly concealed trap(4)!");
		}
		else if(trapsDeck.get(randomCard) == 5){
			works = false;
			trapsDeck.remove(randomCard);
			System.out.println("You found a concealed trap(5)!");
		}
		else if(trapsDeck.get(randomCard) == 6){
			works = false;
			trapsDeck.remove(randomCard);
			System.out.println("You found a concealed trap(6)!");
		}
		else if(trapsDeck.get(randomCard) == 7){
			works = false;
			trapsDeck.remove(randomCard);
			System.out.println("You found a concealed trap(7)!");
		}
		else if(trapsDeck.get(randomCard) == 8){
			works = false;
			trapsDeck.remove(randomCard);
			System.out.println("You stepped on a concealed trap(8)!");
		}
		else if(trapsDeck.get(randomCard) == 9){
			works = false;
			trapsDeck.remove(randomCard);
			System.out.println("You stepped on a concealed trap(9)!");
		}
		else if(trapsDeck.get(randomCard) == 10){
			works = false;
			trapsDeck.remove(randomCard);
			System.out.println("You stepped on a concealed trap(10)!");
		}
		else if(trapsDeck.get(randomCard) == 11){
			works = false;
			items.add(3);
			trapsDeck.remove(randomCard);
			System.out.println("You gained a disarming kit");
		}
		else if(trapsDeck.get(randomCard) == 12){
			works = false;
			devineFavor++;
			System.out.println("You gained a Devine Favor");
			trapsDeck.remove(randomCard);
		}
		else if(trapsDeck.get(randomCard) == 13){
			works = false;
			trapsDeck.remove(randomCard);
			score += 20;
			System.out.println("You found the Jewl of Falling");
		}
	}

	public void monsterDeck(int randomCard){
		if(monsterDeck.get(randomCard) == 1){
			works = false;
			torch--;
			monsterDeck.remove(randomCard);
			System.out.println("Your torch burned out!");
		}
		else if(monsterDeck.get(randomCard) == 2){
			works = false;
			monsterDeck.remove(randomCard);
			System.out.println("A damage zombie attacks you(2)!");
		}
		else if(monsterDeck.get(randomCard) == 3){
			works = false;
			monsterDeck.remove(randomCard);
			System.out.println("A damage zombie attacks you(3)!");
		}
		else if(monsterDeck.get(randomCard) == 4){
			works = false;
			monsterDeck.remove(randomCard);
			System.out.println("A damage zombie attacks you(4)!");
		}
		else if(monsterDeck.get(randomCard) == 5){
			works = false;
			monsterDeck.remove(randomCard);
			System.out.println("A zombie attacks you(5)!");
		}
		else if(monsterDeck.get(randomCard) == 6){
			works = false;
			monsterDeck.remove(randomCard);
			System.out.println("A zombie attacks you(6)!");
		}
		else if(monsterDeck.get(randomCard) == 7){
			works = false;
			monsterDeck.remove(randomCard);
			System.out.println("A zombie attacks you(7)!");
		}
		else if(monsterDeck.get(randomCard) == 8){
			works = false;
			monsterDeck.remove(randomCard);
			System.out.println("A horde of zombie attacks you(8)!");
		}
		else if(monsterDeck.get(randomCard) == 9){
			works = false;
			monsterDeck.remove(randomCard);
			System.out.println("A horde of zombie attacks you(9)!");
		}
		else if(monsterDeck.get(randomCard) == 10){
			works = false;
			monsterDeck.remove(randomCard);
			System.out.println("A horde of zombie attacks you(10)!");
		}
		else if(monsterDeck.get(randomCard) == 11){
			works = false;
			items.add(3);
			monsterDeck.remove(randomCard);
			System.out.println("You gained a strength potion");
		}
		else if(monsterDeck.get(randomCard) == 12){
			works = false;
			devineFavor++;
			System.out.println("You gained a Devine Favor");
			monsterDeck.remove(randomCard);
		}
		else if(monsterDeck.get(randomCard) == 13){
			works = false;
			monsterDeck.remove(randomCard);
			score += 20;
			System.out.println("You found the Jewl of Combat");
		}
	}

	public void sealedDeck(int randomCard){
		if(sealedDeck.get(randomCard) == 1){
			works = false;
			torch--;
			sealedDeck.remove(randomCard);
			System.out.println("Your torch burned out!");
		}
		else if(sealedDeck.get(randomCard) == 2){
			works = false;
			sealedDeck.remove(randomCard);
			System.out.println("A door is blocking your path(2)!");
		}
		else if(sealedDeck.get(randomCard) == 3){
			works = false;
			sealedDeck.remove(randomCard);
			System.out.println("A door is blocking your path(3)!");
		}
		else if(sealedDeck.get(randomCard) == 4){
			works = false;
			sealedDeck.remove(randomCard);
			System.out.println("A door is blocking your path(4)!");
		}
		else if(sealedDeck.get(randomCard) == 5){
			works = false;
			sealedDeck.remove(randomCard);
			System.out.println("A iron door is blocking your path(5)!");
		}
		else if(sealedDeck.get(randomCard) == 6){
			works = false;
			sealedDeck.remove(randomCard);
			System.out.println("A iron door is blocking your path(6)!");
		}
		else if(sealedDeck.get(randomCard) == 7){
			works = false;
			sealedDeck.remove(randomCard);
			System.out.println("A iron door is blocking your path(7)!");
		}
		else if(sealedDeck.get(randomCard) == 8){
			works = false;
			sealedDeck.remove(randomCard);
			System.out.println("A steel door is blocking your path(8)!");
		}
		else if(sealedDeck.get(randomCard) == 9){
			works = false;
			sealedDeck.remove(randomCard);
			System.out.println("A steel door is blocking your path(9)!");
		}
		else if(sealedDeck.get(randomCard) == 10){
			works = false;
			sealedDeck.remove(randomCard);
			System.out.println("A steel door is blocking your path(10)!");
		}
		else if(healthDeck.get(randomCard) == 11){
			works = false;
			items.add(3);
			healthDeck.remove(randomCard);
			System.out.println("You gained a lockpick kit");
		}
		else if(healthDeck.get(randomCard) == 12){
			works = false;
			devineFavor++;
			System.out.println("You gained a Devine Favor");
			healthDeck.remove(randomCard);
		}
		else if(healthDeck.get(randomCard) == 13){
			works = false;
			healthDeck.remove(randomCard);
			score += 20;
			System.out.println("You found the Jewl of Locks");
		}
	}

	public void healthDeck(int randomCard){
		if(healthDeck.get(randomCard) == 1){
			works = false;
			torch--;
			healthDeck.remove(randomCard);
			System.out.println("Your torch burned out!");
		}
		else if(healthDeck.get(randomCard) == 11){
			works = false;
			items.add(4);
			healthDeck.remove(randomCard);
			System.out.println("You gained a health potion");
		}
		else if(healthDeck.get(randomCard) == 12){
			works = false;
			devineFavor++;
			System.out.println("You gained a Devine Favor");
			healthDeck.remove(randomCard);
		}
		else if(healthDeck.get(randomCard) == 13){
			works = false;
			healthDeck.remove(randomCard);
			score += 20;
			System.out.println("You found the Heart Jewel");
		}
		else if(healthDeck.get(randomCard) == 14){
			works = false;
			healthDeck.remove(randomCard);
			torch += 999;
			System.out.println("You found a scroll of light");
		}
	}

	
}
