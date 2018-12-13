package character;
import java.io.*;
import java.util.Scanner;
public class Character extends Object{
	private String name;
	private int MAXHP, STR, DEF, ESS, RES, CON, AGL, SKL, LMT, INT, INS, LCK;
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
	}
	
	public int getMaxHP() {return this.MAXHP;}
	public int getStrength() {return this.STR;}
	public int getDefense() {return this.DEF;}
	public int getEssence() {return this.ESS;}
	public int getResistance() {return this.RES;}
	public int getConstitution() {return this.CON;}
	public int getAgility() {return this.AGL;}
	public int getSkill() {return this.SKL;}
	public int getLimit() {return this.LMT;}
	public int getIntelligence() {return this.INT;}
	public int getInstinct() {return this.INS;}
	public int getLuck() {return this.LCK;}
	public static void main(String [] args) throws FileNotFoundException{
		//For testing purpose
		Character Jimmy = new Character("Jimmy");
		Character Timmy = new Character("Timmy");
	}
}
