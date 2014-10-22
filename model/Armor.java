package model;

public class Armor {
	
	private double defencePoints;
	
	public Armor(double def) {
		defencePoints = def/100; //because defencePoints is a percentage
		if(defencePoints > 1) {
			defencePoints = defencePoints % 1;
		}
	}
	
	public double defencePoints() {
		return defencePoints;
	}
}