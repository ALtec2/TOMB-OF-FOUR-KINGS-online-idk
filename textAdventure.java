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


	public void main(String []arg){
		addInList(monsterDeck);
		addInList(trapsDeck);
		addInList(sealedDeck);
		addInList(healthDeck);
		healthDeck.add(14);


	}

	public void addInList(ArrayList<Integer> deck){
		for(int x = 0; x < 14; x++){
			deck.add(x);
		}

	}

	public void randomNumber(){
		int randomDeck = (int)Math.random()*4;
		int randomCard = (int)Math.random()*13;
		while(works){
			if(randomDeck == 0 && !(monsterDeck.isEmpty())){
				;
			}
			if(randomDeck == 1 && !(monsterDeck.isEmpty())){
				;
			}
			if(randomDeck == 2 && !(monsterDeck.isEmpty())){
				;
			}
			if(randomDeck == 0 && healthDeck.size() > 8){ 
				if(randomCard <= 2 || randomCard >= 10){
						if(randomCard <= 2 || randomCard >= 10){
							healthDeck(randomCard);
						}
						randomCard = (int)Math.random()*14;
				}
			}
		} 
	}

	public void healthDeck(int randomCard){
		if(healthDeck.get(randomCard) == 1){
			torch--;
			healthDeck.remove(randomCard);
		}
		else if(healthDeck.get(randomCard) == 11){
			items.add(4);
			healthDeck.remove(randomCard);
		}
		else if(healthDeck.get(randomCard) == 12){
			devineFavor++;
			healthDeck.remove(randomCard);
		}
		else if(healthDeck.get(randomCard) == 13){
			healthDeck.remove(randomCard);
			score += 20;
		}
		else if(healthDeck.get(randomCard) == 14){
			healthDeck.remove(randomCard);
			torch += 999;
		}
	}

	
}
