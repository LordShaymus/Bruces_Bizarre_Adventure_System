package weather;

public class WeatherType{
	public enum Weather{
		SNOWY,WINDY,WHITEOUT,BLIZZARD;
	}
	Weather weathertype;
	public WeatherType(Weather weathertype) {
		this.weathertype = weathertype;
	}
	public double weatherDamageEffects(String element) {
		switch(weathertype) {
			case SNOWY: {
				switch(element) {
				case "Water": return 1.50;
				case "Ice": return 1.50;
				case "Fire": return 0.65;
				}
			}
			case WINDY:{
				switch(element) {
				case "Wind": return 1.50;
				case "Ice": return 1.15;
				case "Fire": return 0.15;
				}
			}
			case WHITEOUT:{
				switch(element) {
				case "Light": return 1.50;
				case "Darkness": return 0.0;
				}
			}
			case BLIZZARD:{
				switch(element) {
				case "Ice": return 2;
				case "Water": return 2;
				case "Fire": return 0.0;
				}
			}
		}
		return 1;
	}
}
/*Weather Notes:

-Snowy:
	
	+50% Water and Ice Damage
	+10% Freezing Rate
	-10% Projectile Accuracy Penalty
	-10% Instinct Penalty (Unless Survialist is Applied)
	-35% Fire Damage Penalty
	
-Windy:
	+50% Wind Damage
	+15% Ice Damage
	-25% Physical Damage Penalty
	-75% Fire Damage Penalty

-Whiteout:
	+50% Light Damage
	+25% Blind Rate
	-100% Darkness Damage
	-50% Instinct Penalty

-Blizzard:
	+100% Ice and Water Damage
	+25% Freezing Rate
	-15 Accuracy
	-15 Speed
	-100% Fire Damage Penalty
*/


