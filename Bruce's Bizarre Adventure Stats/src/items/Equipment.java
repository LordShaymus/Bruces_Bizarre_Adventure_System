package items;

public class Equipment {
	private int MAXHP, STR, DEF, ESS, RES, CON, AGL, SKL, LMT, INT, INS, LCK;//Attributes
	private double Fire,Water,Earth,Wind,Electricity,Ice,Poison,Light,Darkness,Acid,Slag;//Damage Resistance
	private double Strike,Bludgeon,Pierce,Arrow,Nonphysical,Explosive;//Damage Type Resistance
	private String Name, Type;
	public Equipment(final String name) {
		// TODO Auto-generated constructor stub
		this.Name = name;
		setupArmor(name);
	}
	private void setupArmor(final String name) {
		switch(name) {
		case "mage hat": this.Type = "Hat"; this.INT = 12; this.Nonphysical = 0.34; this.Fire = 0.25; break;
		case "battle armor": this.Type = "Armor"; this.STR = 5; this.DEF = 20; this.Bludgeon = 0.34; break;
		case "duelist gloves": this.Type = "Accessory"; this.SKL = 23; break;
		
		
		}
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
	
	//Damage Resistance
	public double getElementalResistance(final String element) {
		switch(element) {
		case "Fire": return Fire;
		case "Water": return Water;
		case "Earth": return Earth;
		case "Wind": return Wind;
		case "Electricity": return Electricity;
		case "Ice": return Ice;
		case "Poison": return Poison;
		case "Light": return Light;
		case "Darkness": return Darkness;
		case "Acid": return Acid;
		case "Slag": return Slag;
		}
		return 0.0;
	}
	
	public double getDamageResistance(final String damageType) {
		switch(damageType) {
		case "Strike": return Strike;
		case "Bludgeon": return Bludgeon;
		case "Pierce": return Pierce;
		case "Arrow": return Arrow;
		case "Nonphysical": return Nonphysical;
		case "Explosive": return Explosive;
		}
		return 0.0;
	}

}
