package character;
import java.io.*;
import java.util.Scanner;
import items.Equipment;
import items.Weapon;
public class Character extends Object{
	private String name;
	private int MAXHP, STR, DEF, ESS, RES, CON, AGL, SKL, LMT, INT, INS, LCK;
	private int Fire,Water,Earth,Wind,Electricity,Ice,Poison,Light,Darkness,Acid,Slag;//Damage Resistance
	private double Strike,Bludgeon,Pierce,Arrow,Nonphysical;//Damage Type Resistance
	private Equipment Hat,Armor,Access1,Access2,Access3;
	private Weapon RightHand, LeftHand;
	public Character(final String name) throws FileNotFoundException{
		this.name = name;
		Scanner fin = getCharacterFile(name);
		setupCharacter(fin);
		fin.close();
		
	}
	private Scanner getCharacterFile(final String name) throws FileNotFoundException {
		String dir = new File("").getAbsolutePath(); 
		dir += "\\src\\characterSheet\\" + name + ".txt";
		try {
			return new Scanner(new File(dir));
		}
		catch(FileNotFoundException e) {
			Scanner kb = new Scanner(System.in);
			System.out.print("ERROR: Character name does not match any files found, please enter a new name: ");
			this.name = kb.nextLine();
			return getCharacterFile(this.name);
		}
	}
	private void setupCharacter(final Scanner fin) throws FileNotFoundException{
		//--- Attribute ---
		fin.nextLine();
		this.MAXHP = Integer.parseInt(fin.nextLine().replaceAll("Max HP: ", ""));
		this.STR = Integer.parseInt(fin.nextLine().replaceAll("Strength: ", ""));
		this.DEF = Integer.parseInt(fin.nextLine().replaceAll("Defense: ", ""));
		this.ESS = Integer.parseInt(fin.nextLine().replaceAll("Essence: ", ""));
		this.RES = Integer.parseInt(fin.nextLine().replaceAll("Resistance: ", ""));
		this.CON = Integer.parseInt(fin.nextLine().replaceAll("Constitution: ", ""));
		this.AGL = Integer.parseInt(fin.nextLine().replaceAll("Agility: ", ""));
		this.SKL = Integer.parseInt(fin.nextLine().replaceAll("Skill: ", ""));
		this.LMT = Integer.parseInt(fin.nextLine().replaceAll("Limit: ", ""));
		this.INT = Integer.parseInt(fin.nextLine().replaceAll("Intelligence: ", ""));
		this.INS = Integer.parseInt(fin.nextLine().replaceAll("Instinct: ", ""));
		this.LCK = Integer.parseInt(fin.nextLine().replaceAll("Luck: ", ""));	
		
		//Empty space & --- Equipment ---
		fin.nextLine(); fin.nextLine();
		this.RightHand = new Weapon(fin.nextLine().replaceAll("Right Hand: ", "").trim().toLowerCase());
		this.LeftHand = new Weapon(fin.nextLine().replaceAll("Left Hand: ", "").trim().toLowerCase());
		this.Hat = new Equipment(fin.nextLine().replaceAll("Hat: ", "").trim().toLowerCase());
		this.Armor = new Equipment(fin.nextLine().replaceAll("Armor: ", "").trim().toLowerCase());
		this.Access1 = new Equipment(fin.nextLine().replaceAll("Accessory 1: ","").trim().toLowerCase());
		
		
	}
	
	public int getMaxHP() {return this.MAXHP + Hat.getMaxHP() + Armor.getMaxHP() + Access1.getMaxHP();}
	public int getStrength() {return this.STR + Hat.getStrength() + Armor.getStrength() + Access1.getStrength();}
	public int getDefense() {return this.DEF + Hat.getDefense() + Armor.getDefense() + Access1.getDefense();}
	public int getEssence() {return this.ESS + Hat.getEssence() + Armor.getEssence() + Access1.getEssence();}
	public int getResistance() {return this.RES + Hat.getResistance() + Armor.getResistance() + Access1.getResistance();}
	public int getConstitution() {return this.CON + Hat.getConstitution() + Armor.getConstitution() + Access1.getConstitution();}
	public int getAgility() {return this.AGL + Hat.getAgility() + Armor.getAgility() + Access1.getAgility();}
	public int getSkill() {return this.SKL + Hat.getSkill() + Armor.getSkill() + Access1.getSkill();}
	public int getLimit() {return this.LMT + Hat.getLimit() + Armor.getLimit() + Access1.getLimit();}
	public int getIntelligence() {return this.INT + Hat.getIntelligence() + Armor.getIntelligence() + Access1.getIntelligence();}
	public int getInstinct() {return this.INS + Armor.getInstinct() + Hat.getInstinct() + Access1.getInstinct();}
	public int getLuck() {return this.LCK + Hat.getLuck() + Armor.getLuck() + Access1.getLuck();}
	public int getAccuracy() {return getSkill() + getLuck();}
	public int getArmorClass() {return getAgility() + getLuck();}
	public int getRightWeaponDamage(Character target) {
		if(RightHand.checkProjectile() == true)
			return RightHand.getProjectileWeaponDamage(this, target);
		else
			return RightHand.getMeleeWeaponDamage(this, target);
	}
	public int getLeftWeaponDamage(Character target) {
		if(RightHand.checkProjectile() == true)
			return LeftHand.getProjectileWeaponDamage(this, target);
		else
			return LeftHand.getMeleeWeaponDamage(this, target);
	}
	
	public double getElementalResistance(String element) {
		return Hat.getElementalResistance(element) + Armor.getElementalResistance(element) + Access1.getElementalResistance(element);
	}
	public double getDamageResistance(String damageType) {
		return Hat.getDamageResistance(damageType) + Armor.getDamageResistance(damageType) + Access1.getDamageResistance(damageType);
	}
	public static void main(String [] args) throws FileNotFoundException{
		//For testing purpose
		Character Jimmy = new Character("Jimmy");
		Character Timmy = new Character("Timmy");
		int Damage = Jimmy.getRightWeaponDamage(Jimmy);
		
	}
}
