package model;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.concepts.Collidable;
import model.concepts.CollidableEnum;

public class MonsterManager extends Observable implements Collidable, Observer {

	protected List<Monster> monsters;

	public MonsterManager() {
		monsters = new ArrayList<Monster>();
	}

	public void addMonster(Monster mons) {
		mons.addObserver(this);
		monsters.add(mons);
		setChanged();
		notifyObservers(mons);
	}

	public void addList(List<Monster> monster) {
		for(Monster actual : monster) {
			this.addMonster(actual);
		}
		
	}

	@Override
	public void update(Observable monster, Object arg) {
		monsters.remove(monster);
	}

	public List<Collidable> toList() {
		List<Collidable> list = new ArrayList<Collidable>(monsters);
		return list;
	}

	@Override
	public void onCollision(Collidable theOneHeCollided) {
	}

	@Override
	public Rectangle boundingBox() {
		return null;
	}

	public boolean isEmpty() {
		return monsters.size() == 0;
	}

	@Override
	public CollidableEnum type() {
		return null;
	}

}