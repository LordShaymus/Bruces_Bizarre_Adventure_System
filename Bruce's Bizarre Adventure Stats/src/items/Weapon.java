package items;
import character.Character;

public class Weapon {
	private int baseDamage,criticalPoints;
	private String weaponType,name,damageType,element;
	private double damageMod;
	private boolean projectile;
	public Weapon(final String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		getWeapon(name);
	}
	public String getName() {return name;}
	private void getWeapon(final String name) {
		switch(name) {
		case "training sword": baseDamage = 100; damageMod = 0.20; weaponType = "Shortsword"; damageType = "Nonphysical"; element = "Fire"; break;
		}
		if(baseDamage == 0) {
			damageType = "None";
		}
	}
	public int getMeleeWeaponDamage(Character attacker, Character target) {
		int damage = (int)(baseDamage * (1 + damageMod)) + attacker.getStrength() - target.getDefense();
		double resistance = target.getElementalResistance(element) + target.getDamageResistance(damageType);
		damage =  (int)(damage * resistance);
		if(damage < 0)
			return 1;
		return damage;
	}
	public int getProjectileWeaponDamage(Character attacker, Character target) {
		int damage = (int)(baseDamage * (1 + damageMod)) + attacker.getSkill() - target.getDefense();
		double resistance = target.getElementalResistance(element) + target.getDamageResistance(damageType);
		damage = (int)(damage * (1 - resistance));
		if(damage < 0)
			return 1;
		return damage;
	}
	public boolean checkProjectile() {return projectile;}

}
