package main;
import character.Character;
import java.util.*;
import java.io.*;
import combat.Initiative;
public class MainMethod {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		Initiative theList = combat.SetupCombat.gatherInit(new Scanner(System.in));
		combat.EngageCombat.combatMenu(theList, kb);
		
	}

}
