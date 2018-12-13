package character;
import java.io.*;
import java.util.Scanner;
public class Combatant extends Character{
	public Combatant(final String name) throws FileNotFoundException{
		super(name);
		Scanner fin = getCharacterFile(name);
		setupEquipment(fin);
	}
	private Scanner getCharacterFile(String name) throws FileNotFoundException {
		String dir = new File("").getAbsolutePath(); 
		dir += "\\src\\characterSheet\\" + name + ".txt";
		try {
			return new Scanner(new File(dir));
		}
		catch(FileNotFoundException e) {
			Scanner kb = new Scanner(System.in);
			System.out.print("ERROR: Character name does not match any files found, please enter a new name: ");
			name = kb.nextLine();
			return getCharacterFile(name);
		}
	}
	public void setupEquipment(final Scanner fin) {
		
	}
	

}
