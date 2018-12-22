package combat;
import java.util.Scanner;
import java.util.Random;
import character.Character;
import combat.Initiative;
import items.*;
public class Calculate {
	public static boolean [] accuracy(Character attacker, Character [] targets, Scanner kb) {
		int atkRoll = getAttackRoll(attacker,kb);
		int [] defRoll = new int[targets.length];
		boolean [] hits = new boolean[targets.length];
		
		for(int i = 0; i < defRoll.length; i++) {
			defRoll[i] = getDodgeRoll(targets[i],kb);
			if(defRoll[i] == atkRoll)
				hits[i] = tieBreaker(targets[i],attacker,kb);
			else if(defRoll [i] > atkRoll)
				hits[i] = false;
			else
				hits[i] = true;
		}
		return hits;
	}
	public static int getAttackRoll(Character attacker,Scanner kb) {
		System.out.print("Enter " + attacker.getName() + "'s Roll: ");
		int roll = kb.nextInt(); kb.nextLine();
		return roll + attacker.getAccuracy();
	}
	public static int getDodgeRoll(Character target,Scanner kb) {
		System.out.print("Enter " + target.getName() + "'s Roll: ");
		int roll = kb.nextInt(); kb.nextLine();
		return roll + target.getArmorClass();
	}
	public static Initiative checkHit(Character attacker, Character [] targets, Initiative theList, Weapon weapon, boolean [] hits, Scanner kb) {
		for(int i = 0; i < hits.length; i++) {
			if(hits[i] == true) {
				theList = dealWeaponDamage(attacker,targets[i],theList,weapon,kb);
			}
			else {
				System.out.println(attacker.getName() + " missed to hit " + targets[i].getName());
			}
		}
		return theList;
	}
	public static Initiative dealWeaponDamage(Character attacker, Character target, Initiative theList, Weapon weapon, Scanner kb) {
		char answer;
		int Damage;
		
		if(weapon.checkProjectile())
			Damage = weapon.getProjectileWeaponDamage(attacker, target);
		else
			Damage = weapon.getMeleeWeaponDamage(attacker, target);
		
		System.out.println(target.getName() + " takes " + Damage + " damage!");
		do {
			System.out.print("Do you wish to save this (y/n) ");
			answer = kb.nextLine().toLowerCase().charAt(0);
		}while(answer != 'y' && answer != 'n');
		if(answer == 'y') {
			target.changeHP(Damage * -1);
			theList.changeCharacter(target);
		}
		return theList;
	}
	public static boolean tieBreaker(Character target, Character attacker,Scanner kb) {
		System.out.println("Both " + target.getName() + " and " + attacker.getName() + " have tied.");
		System.out.print("Enter " + attacker.getName() + "'s Roll: ");
		int atkRoll = kb.nextInt(); kb.nextLine();
		System.out.print("Enter " + target.getName() + "'s Roll: ");
		int defRoll = kb.nextInt(); kb.nextLine();
		if(atkRoll == defRoll)
			return tieBreaker(target,attacker,kb);
		else
			return atkRoll > defRoll;
	}
}
