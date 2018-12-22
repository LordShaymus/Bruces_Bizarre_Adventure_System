package combat;
import java.util.*;
import combat.Initiative;
import character.Character;
public class EngageCombat {
	public static void combatMenu(Initiative theList, Scanner kb) {
		int choice = 0;
		do {
			System.out.println(theList.upNext());
			Character attacker = theList.characterTurn();
			System.out.println("\n--- What Will " + attacker.getName() + " Do? ---\n1. Attack Menu\n2. Equipment\n3. Check Status\n4. Next Turn\n0. End Combat");
			System.out.print("Enter your choice: ");
			choice = kb.nextInt(); kb.nextLine();
			switch(choice) {
			case 1: attackMenu(theList,attacker,kb); break;
			case 4: theList.moveUp(); break;
			}
		}while(choice != 0);
	}
	
	public static void attackMenu(Initiative theList, Character attacker, Scanner kb) {
		int choice = 0;
		boolean [] hits;
		System.out.println("\n--- How will " + attacker.getName() + " attack? ---"
				+ "\n1.Right Hand: " + attacker.getRightHandWeapon() + "\n2.Left Hand: " + attacker.getLeftHandWeapon() 
				+ "\n3.Hand To Hand\n4.Magic\n5.Force\n6.Limit Ability\n0. Exit");
		System.out.print("Enter your choice: ");
		do {
		choice = kb.nextInt(); kb.nextLine();
		}while(choice >= 7 || choice <= -1);
		
		if(choice != 0) {
			Character [] targets = gatherTargets(theList,kb);
			switch(choice) {
			case 1: hits = combat.Calculate.accuracy(attacker, targets, kb);
					theList = combat.Calculate.checkHit(attacker, targets, theList, attacker.RightHand, hits, kb);
					break;
			case 2: hits = combat.Calculate.accuracy(attacker, targets, kb);
					theList = combat.Calculate.checkHit(attacker, targets, theList, attacker.LeftHand, hits, kb);
					break;
						   
					
			}
		}
	}
	public static Character[] gatherTargets(Initiative theList, Scanner kb){
		Character [] targets;
		int amount;
		
		System.out.print("\nHow many targets are there: ");
		amount = kb.nextInt(); kb.nextLine();
		targets = new Character[amount];
		
		for(int i = 0; i < targets.length; i++) {
			System.out.print("Enter a character's name: ");
			Character temp = theList.find(kb.nextLine());
			while(temp == null) {
				System.out.print("Error: Character is not in this current list, enter a new name: ");
				temp = theList.find(kb.nextLine());
			}
			targets[i] = temp;
		}
		return targets;
	}
	

}
