package model;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Observable;

import model.concepts.Collidable;
import model.concepts.Living;
import model.concepts.Movable;
import model.facingDirection.*;

public abstract class Entity extends Observable implements Collidable, Living, Movable {
	
	protected Point position;
	protected Point lastValidPosition;
	protected FacingDirection facing;
	protected int velocity;
	
	protected double life;
	protected double maxLife;
	protected Sword sword;
	protected Armor armor;
	protected Rectangle boundingBox;
	
	public Entity(Point position, int vel, Sword swd, Armor arm, double life,Rectangle bBox) {
		this.position = position;
		lastValidPosition = new Point(position);
		velocity = vel;
		sword = swd;
		armor = arm;
		boundingBox = bBox;
		facing = new FacingTop();
		this.life = maxLife = life;
	}
	
	public void moveTop() {
		lastValidPosition.setLocation(position);
		this.position.y -= velocity;
		this.boundingBox.setLocation(position);
		facing = new FacingTop();
	}
	
	public void moveBot() {
		lastValidPosition.setLocation(position);
		this.position.y += velocity;
		this.boundingBox.setLocation(position);
		facing = new FacingBot();
	}
	
	public void moveLeft() {
		lastValidPosition.setLocation(position);
		this.position.x -= velocity;
		this.boundingBox.setLocation(position);
		facing = new FacingLeft();

	}
	
	public void moveRight() {
		lastValidPosition.setLocation(position);
		this.position.x += velocity;
		this.boundingBox.setLocation(position);
		facing = new FacingRight();
	}
	
	public int getPositionX() {
		return position.x;
	}
	
	public int getPositionY() {
		return position.y;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public double getLife() {
		return life;
	}
	
	public FacingDirection facingDirection() {
		return facing;
	}
	
	@Override
	public void receiveAttack(Attack atk) {
		this.receiveDamage(atk.damage());
	}
	
	@Override
	public void receiveDamage(double dmg) {
		life -= (dmg - dmg*armor.defencePoints()); //damage - damage*defence, defence is the percentage of damage that won't be taken
		if(life <= 0)
			this.die();
	}
	
	public Rectangle boundingBox() {
		return boundingBox;
	}
	
	protected void onCollisionWithCollidable() {
		position.setLocation(lastValidPosition); //if you collide with a Collidable, you come back to your last valid position
	}
	
	abstract public void die();
}