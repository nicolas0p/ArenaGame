package model;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import model.concepts.Collidable;
import model.concepts.CollidableEnum;

public class Attack extends Observable implements Collidable {
	
	private double damage;
	private Point position;
	private Rectangle boundingBox;
	
	
	public Attack(double dmg, Point pos) {
		damage = dmg;
		position = pos;
		boundingBox = new Rectangle(position, new Dimension(1,1));
	}
	
	public Attack(double dmg, Point pos, Rectangle boundingBox) {
		damage = dmg;
		position = pos;
		this.boundingBox = boundingBox;
	}
	
	public double damage() {
		return damage;
	}
	
	public void finished() { //when the attack is finished
		setChanged();
		notifyObservers();
	}

	@Override
	public void onCollision(Collidable other) {
	}

	@Override
	public Rectangle boundingBox() {
		return boundingBox;
	}

	@Override
	public List<Collidable> toList() {
		List<Collidable> list = new ArrayList<Collidable>();
		list.add(this);
		return list;
	}

	@Override
	public CollidableEnum type() {
		return CollidableEnum.ATTACK;
	}
	
}