import java.util.ArrayList;
import java.util.Scanner;
public class textAdventure{
	int torch = 4;
	ArrayList<Integer> monsterDeck = new ArrayList<>();
	ArrayList<Integer> trapsDeck = new ArrayList<>();
	ArrayList<Integer> sealedDeck = new ArrayList<>();
	ArrayList<Integer> healthDeck = new ArrayList<>();
	ArrayList<Integer> items = new ArrayList<>();
	int randomDeck;
	int devineFavor = 0;
	int score  =0;
	boolean works = true;
	int space = 0;
	Scanner input = new Scanner(System.in);
	int skillCheckHight = 0;
	int choice; 
	int heartLost;
	int health =20;
 

	public void main(String []args){
		addInList(monsterDeck);
		addInList(trapsDeck);
		addInList(sealedDeck);
		addInList(healthDeck);
		healthDeck.add(14);

		//main varaible
		boolean goingForward = true;

		//starting game
		randomDeck();
		space++;
		while(space > 0 && torch != 0 && !(monsterDeck.isEmpty() && trapsDeck.isEmpty() && sealedDeck.isEmpty() && healthDeck.isEmpty())){
			randomDeck();
			if(goingForward){
				space++; 
			}
			else{
				space--;
			}
		}
		System.out.print(space);
	}

	public void skillCheck(int x){
		if(devineFavor > 0){
			devineFavor--;
			System.out.println("Your devine favor activated!");
		}
		else if(!items.isEmpty()){ 
			for(int i = 0 ; i <items.size(); i++){  
				if(randomDeck+1 == items.get(i)){
					if(items.get(i) == 1){ 
						System.out.println("Do you want to use a disarming kit");
					}
					else if(items.get(i) == 2){
						System.out.println("Do you want to use a strength potion");
					}
					else if(items.get(i) == 3){ 
						System.out.println("Do you want to use a lockpick kit");
					}
					else if(items.get(i) == 4){
						System.out.println("Do you want to use a medkit");
					}
					System.out.print(" 0 for No, 1 for Yes: ");
					choice = input.nextInt(); 
					works = true;
					while(works){
						if(choice < 2){
							works = false;
							if(choice == 1){
								if(items.get(i) == 4){
									System.out.println("You use up your item");
									health += heartLost;
									items.remove(i);
									break;
								}
								else{
									System.out.println("You use up your item");
									items.remove(i);
									break;
								}	
								
							}
							else{
								;
							}

						}
						else{
							System.out.print(" 0 for No, 1 for Yes: ");
							choice = input.nextInt();
						}	 
					}
				}
			}
		}  
		else{
			works = true;
			while(works){
				randomDeck = (int) (Math.random() * 4);
	            int randomCard;
				if(randomDeck == 0 && !(trapsDeck.isEmpty())){
					randomCard = (int)(Math.random()*trapsDeck.size());	
					if(trapsDeck.get(randomCard) == 1 || trapsDeck.get(randomCard) > 10){
						trapsDeck(randomCard);
						skillCheck(x);
					}
					else if(x > trapsDeck.get(randomCard)){
						health = health - x + trapsDeck.get(randomCard);
						trapsDeck.remove(randomCard);
					}

				}
				if(randomDeck == 1 && !(monsterDeck.isEmpty())){
					randomCard = (int)(Math.random()*monsterDeck.size());
					if(monsterDeck.get(randomCard) == 1 || monsterDeck.get(randomCard) > 10){
						monsterDeck(randomCard);
						skillCheck(x);
					}
					else if(x > monsterDeck.get(randomCard)){
						health = health - x + monsterDeck.get(randomCard);
						trapsDeck.remove(randomCard);
					}
				}
				if(randomDeck == 2&&!(sealedDeck.isEmpty())){
					randomCard = (int)(Math.random()*sealedDeck.size());
					if(sealedDeck.get(randomCard) == 1 || sealedDeck.get(randomCard) > 10){
						sealedDeck(randomCard);
						skillCheck(x);
					}
					else if(x > sealedDeck.get(randomCard)){
						health = health - x + sealedDeck.get(randomCard);
						trapsDeck.remove(randomCard);
					}
				}
				if(randomDeck == 3 && !(healthDeck.isEmpty())){ 
					randomCard = (int)(Math.random()*healthDeck.size());
					healthDeck(randomCard);
					skillCheck(x);
				}
			}  
		}
	}
          
	public void addInList(ArrayList<Integer> deck){ 
		for(int x = 1; x < 14; x++){
			deck.add(x);
		}
	}
	public void printList(ArrayList<Integer> deck){ 
		for(int x = 0; x < deck.size(); x++){
			System.out.print(deck.get(x) + " ");
		}   
		System.out.println();

	}

	public void randomDeck(){
		works = true;
		while(works){ 
			randomDeck = (int) (Math.random() * 4);
            int randomCard;
			if(randomDeck == 0 && !(trapsDeck.isEmpty())){
				randomCard = (int)(Math.random()*trapsDeck.size());
				trapsDeck(randomCard);   
			}
			if(randomDeck == 1 && !(monsterDeck.isEmpty())){
				randomCard = (int)(Math.random()*monsterDeck.size());
				monsterDeck(randomCard);
			}
			if(randomDeck == 2&&!(sealedDeck.isEmpty())){
				randomCard = (int)(Math.random()*sealedDeck.size());
				sealedDeck(randomCard);
				
			}
			if(randomDeck == 3 && !(healthDeck.isEmpty())){ 
				randomCard = (int)(Math.random()*healthDeck.size());
				healthDeck(randomCard);
				if(sealedDeck.get(randomCard) == 1 || sealedDeck.get(randomCard) > 10){
					randomDeck();
				} 
			}
		}  
	}
	public void trapsDeck(int randomCard){
		if(trapsDeck.get(randomCard) == 1){
			works = false;
			torch--; 
			System.out.println("Your torch burned out!");
			trapsDeck.remove(randomCard);
		}
		else if(trapsDeck.get(randomCard) == 2){
			works = false;
			System.out.println("You found a poorly concealed trap(2)!");
			skillCheck(trapsDeck.remove(randomCard)); 
		}  
		else if(trapsDeck.get(randomCard) == 3){
			works = false;
			System.out.println("You found a poorly concealed trap(3)!");
			skillCheck(trapsDeck.remove(randomCard)); 
		}  
		else if(trapsDeck.get(randomCard) == 4){ 
			works = false;
			System.out.println("You found a poorly concealed trap(4)!");
			skillCheck(trapsDeck.remove(randomCard)); 
		}
		else if(trapsDeck.get(randomCard) == 5){
			works = false;
			System.out.println("You found a concealed trap(5)!");
			skillCheck(trapsDeck.remove(randomCard)); 
		}
		else if(trapsDeck.get(randomCard) == 6){
			works = false;
			System.out.println("You found a concealed trap(6)!");
			skillCheck(trapsDeck.remove(randomCard)); 
		}
		else if(trapsDeck.get(randomCard) == 7){
			works = false;
			System.out.println("You found a concealed trap(7)!");
			skillCheck(trapsDeck.remove(randomCard)); 
		}
		else if(trapsDeck.get(randomCard) == 8){
			works = false;
			System.out.println("You stepped on a concealed trap(8)!");
			skillCheck(trapsDeck.remove(randomCard)); 
		}
		else if(trapsDeck.get(randomCard) == 9){
			works = false;
			System.out.println("You stepped on a concealed trap(9)!");
			skillCheck(trapsDeck.remove(randomCard)); 
		}
		else if(trapsDeck.get(randomCard) == 10){
			works = false;
			System.out.println("You stepped on a concealed trap(10)!");
			skillCheck(trapsDeck.remove(randomCard)); 
		}
		else if(trapsDeck.get(randomCard) == 11){
			works = false;
			items.add(1);
			System.out.println("You gained a disarming kit");
			trapsDeck.remove(randomCard);
		}
		else if(trapsDeck.get(randomCard) == 12){
			works = false;
			devineFavor++;
			System.out.println("You gained a Devine Favor");
			trapsDeck.remove(randomCard);
		}
		else if(trapsDeck.get(randomCard) == 13){
			works = false;
			score += 20;
			System.out.println("You found the Jewl of Traps");
			trapsDeck.remove(randomCard);
		}
	}

	public void monsterDeck(int randomCard){
		if(monsterDeck.get(randomCard) == 1){
			works = false;
			torch--;
			System.out.println("Your torch burned out!");
			monsterDeck.remove(randomCard);		}
		else if(monsterDeck.get(randomCard) == 2){
			works = false;
			System.out.println("A damage zombie attacks you(2)!");
			skillCheck(monsterDeck.remove(randomCard)); 
		}
		else if(monsterDeck.get(randomCard) == 3){
			works = false;
			System.out.println("A damage zombie attacks you(3)!");
			skillCheck(monsterDeck.remove(randomCard)); 
		}
		else if(monsterDeck.get(randomCard) == 4){
			works = false;
			System.out.println("A damage zombie attacks you(4)!");
			skillCheck(monsterDeck.remove(randomCard)); 
		}
		else if(monsterDeck.get(randomCard) == 5){
			works = false;
			System.out.println("A zombie attacks you(5)!");
			skillCheck(monsterDeck.remove(randomCard)); 
		}
		else if(monsterDeck.get(randomCard) == 6){
			works = false;
			System.out.println("A zombie attacks you(6)!");
			skillCheck(monsterDeck.remove(randomCard)); 
		}
		else if(monsterDeck.get(randomCard) == 7){
			works = false;
			System.out.println("A zombie attacks you(7)!");
			skillCheck(monsterDeck.remove(randomCard)); 
		}
		else if(monsterDeck.get(randomCard) == 8){
			works = false;
			System.out.println("A horde of zombie attacks you(8)!");
			skillCheck(monsterDeck.remove(randomCard)); 
		}
		else if(monsterDeck.get(randomCard) == 9){
			works = false;
			System.out.println("A horde of zombie attacks you(9)!");
			skillCheck(monsterDeck.remove(randomCard)); 
		}
		else if(monsterDeck.get(randomCard) == 10){
			works = false;
			System.out.println("A horde of zombie attacks you(10)!");
			skillCheck(monsterDeck.remove(randomCard)); 
		}
		else if(monsterDeck.get(randomCard) == 11){
			works = false;
			items.add(2);
			System.out.println("You gained a strength potion");
			monsterDeck.remove(randomCard);
		}
		else if(monsterDeck.get(randomCard) == 12){
			works = false;
			devineFavor++;
			System.out.println("You gained a Devine Favor");
			monsterDeck.remove(randomCard); 
		}
		else if(monsterDeck.get(randomCard) == 13){
			works = false;
			score += 20;
			System.out.println("You found the Jewl of Combat");
			monsterDeck.remove(randomCard);
		}
	}

	public void sealedDeck(int randomCard){
		if(sealedDeck.get(randomCard) == 1){
			works = false;
			torch--;
			System.out.println("Your torch burned out!");
			sealedDeck.remove(randomCard);
		}
		else if(sealedDeck.get(randomCard) == 2){
			works = false;
			System.out.println("A door is blocking your path(2)!");
			skillCheck(sealedDeck.remove(randomCard)); 
		}
		else if(sealedDeck.get(randomCard) == 3){
			works = false;
			System.out.println("A door is blocking your path(3)!");
			skillCheck(sealedDeck.remove(randomCard)); 
		}
		else if(sealedDeck.get(randomCard) == 4){
			works = false;
			System.out.println("A door is blocking your path(4)!");
			skillCheck(sealedDeck.remove(randomCard)); 
		}
		else if(sealedDeck.get(randomCard) == 5){
			works = false;
			System.out.println("A iron door is blocking your path(5)!");
			skillCheck(sealedDeck.remove(randomCard)); 
		}
		else if(sealedDeck.get(randomCard) == 6){
			works = false;
			System.out.println("A iron door is blocking your path(6)!");
			skillCheck(sealedDeck.remove(randomCard)); 
		}
		else if(sealedDeck.get(randomCard) == 7){
			works = false;
			System.out.println("A iron door is blocking your path(7)!");
			skillCheck(sealedDeck.remove(randomCard)); 
		}
		else if(sealedDeck.get(randomCard) == 8){
			works = false;
			System.out.println("A steel door is blocking your path(8)!");
			skillCheck(sealedDeck.remove(randomCard)); 
		}
		else if(sealedDeck.get(randomCard) == 9){
			works = false;
			System.out.println("A steel door is blocking your path(9)!");
			skillCheck(sealedDeck.remove(randomCard)); 
		}
		else if(sealedDeck.get(randomCard) == 10){
			works = false;
			System.out.println("A steel door is blocking your path(10)!");
			skillCheck(sealedDeck.remove(randomCard)); 
		}
		else if(sealedDeck.get(randomCard) == 11){
			works = false;
			items.add(3);
			System.out.println("You gained a lockpick kit");
			sealedDeck.remove(randomCard);  
		}
		else if(sealedDeck.get(randomCard) == 12){
			works = false;
			devineFavor++;
			System.out.println("You gained a Devine Favor");
			sealedDeck.remove(randomCard); 
		} 
		else if(sealedDeck.get(randomCard) == 13){
			works = false;
			score += 20;
			System.out.println("You found the Jewl of Locks");
			sealedDeck.remove(randomCard);  
		}
	}

	public void healthDeck(int randomCard){
		if(healthDeck.get(randomCard) == 1){
			works = false;
			torch--;
			System.out.println("Your torch burned out!");
			healthDeck.remove(randomCard); 
		}
		else if(healthDeck.get(randomCard) == 2){
			works = false;
			System.out.println("You found a small pile of gold(2)!"); 
		}
		else if(healthDeck.get(randomCard) == 3){
			works = false;
			System.out.println("You found a small pile of gold(3)!"); 
		}
		else if(healthDeck.get(randomCard) == 4){
			works = false;
			System.out.println("You found a small pile of gold(4)!"); 
		}
		else if(healthDeck.get(randomCard) == 5){
			works = false;
			System.out.println("You found a pile of gold(5)!"); 
		}
		else if(healthDeck.get(randomCard) == 6){
			works = false;
			System.out.println("You found a pile of gold(6)!"); 
		}
		else if(healthDeck.get(randomCard) == 7){
			works = false;
			System.out.println("You found a pile of gold(7)!"); 
		}
		else if(healthDeck.get(randomCard) == 8){
			works = false;
			System.out.println("You found a huge pile of gold(8)!"); 
		}
		else if(healthDeck.get(randomCard) == 9){
			works = false;
			System.out.println("You found a huge pile of gold(9)!"); 
		}
		else if(healthDeck.get(randomCard) == 10){
			works = false;
			System.out.println("You found a huge pile of gold(10)!"); 
		}
		else if(healthDeck.get(randomCard) == 11){
			works = false;
			items.add(4);
			System.out.println("You gained a health potion");
			healthDeck.remove(randomCard);  
		}
		else if(healthDeck.get(randomCard) == 12){
			works = false;
			devineFavor++;
			System.out.println("You gained a Devine Favor");
			healthDeck.remove(randomCard);
		} 
		else if(healthDeck.get(randomCard) == 13){
			works = false; 
			score += 20;
			System.out.println("You found the Heart Jewel");
			healthDeck.remove(randomCard);  
		}
		else if(healthDeck.get(randomCard) == 14){
			works = false;  
			torch += 999;
			System.out.println("You found a scroll of light"); 
			healthDeck.remove(randomCard);
		}  
		//printList(healthDeck);          
	}

	
}
