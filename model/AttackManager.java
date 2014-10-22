package model;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;

import model.concepts.Collidable;
import model.concepts.CollidableEnum;

public class AttackManager extends Observable implements Observer, Collidable {
	
	private List<Attack> attacks;
	private Timer timer;
	
	public AttackManager() {
		this.timer = new Timer();
		attacks = new ArrayList<Attack>();
	}
	
	public void addAttack(Attack attack) { //add an attack to the list, and observes it
		attack.addObserver(this);
		attacks.add(attack);
		timer.schedule(new AttackTimerTask(attack), 2000);
		setChanged();
		notifyObservers(attack); //TODO PROBLEMS!
	}
	
	@Override
	public void update(Observable attack, Object arg) {
		attack.deleteObserver(this);
		attacks.remove(attack);
	}
	
	@Override
	public List<Collidable> toList() {
		return new ArrayList<Collidable>(attacks);
	}

	@Override
	public Rectangle boundingBox() {
		return null;
	}

	@Override
	public CollidableEnum type() {
		return null;
	}

	@Override
	public void onCollision(Collidable theOneHeCollided) {
		//Do nothing
	}
	
}