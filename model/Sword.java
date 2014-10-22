package model;

import java.awt.Dimension;

public class Sword {
	
	private double attackPoints;
	private Dimension dimension; //of the attack this sword will create
	
	public Sword(double atk) { //regular attack constructor
		attackPoints = atk;
		dimension = new Dimension(1,1); //regular dimension
	}
	
	public Sword(double atk, Dimension dim) { //constructor if you need an attack with different dimensions
		attackPoints = atk;
		dimension = dim;
	}
	
	public double attackPoints() {
		return attackPoints;
	}
	
	public Dimension dimension() {
		return dimension;
	}
}