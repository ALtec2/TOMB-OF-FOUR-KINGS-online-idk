import java.util.ArrayList;
public class textAdventure{
	int torch = 4;
	int[] selection = {0,0};
	ArrayList<Integer> monsterDeck = new ArrayList<>();
	ArrayList<Integer> trapsDeck = new ArrayList<>();
	ArrayList<Integer> sealedDeck = new ArrayList<>();
	ArrayList<Integer> healthDeck = new ArrayList<>();


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
		boolean works = true;
		while(works){
			if(randomDeck == 0 && !(monsterDeck.isEmpty())){
				selection[0] = 1;
			}
			if(randomDeck == 1 && !(monsterDeck.isEmpty())){
				selection[0] = 2;
			}
			if(randomDeck == 2 && !(monsterDeck.isEmpty())){
				selection[0] = 3;
			}
			if(randomDeck == 0 && !(monsterDeck.isEmpty())){

					if(randomCard >= 2 && randomCard <= 10){
						;
					}
					else{
						healthDeck(randomCard);
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
			healthDeck.remove(randomCard);
		}
		else if(healthDeck.get(randomCard) == 12){
			healthDeck.remove(randomCard);
		}
		else if(healthDeck.get(randomCard) == 13){
			healthDeck.remove(randomCard);
		}
		else if(healthDeck.get(randomCard) == 14){
			healthDeck.remove(randomCard);
		}
	}
}