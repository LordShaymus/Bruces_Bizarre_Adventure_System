package combat;
import combat.Initiative;
import java.io.*;
import java.util.Scanner;
import character.Character;
public class SetupCombat {
	public static Initiative gatherInit(Scanner kb) throws FileNotFoundException{
		int partyAmount;
		Initiative theList = new Initiative();
		
		System.out.print("How many characters are there: ");
		partyAmount = kb.nextInt(); kb.nextLine();
		for(int i = 0; i < partyAmount; i++) {
			System.out.print("Enter a character's name: ");
			Character temp = new Character(kb.nextLine());
			System.out.print("Enter their roll: ");
			int init = kb.nextInt(); kb.nextLine();
			temp.setInit(init);
			theList.addSorted(temp);
		}
		return theList;
		
	}
}
