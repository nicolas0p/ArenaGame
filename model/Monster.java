package model;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import model.concepts.Collidable;
import model.concepts.CollidableEnum;

public abstract class Monster extends Entity { // regular monster class

	protected MonsterManager monsterManager;
	
	public Monster(Point position, int velocity, Sword sword, Armor armor, double life,
			Rectangle boundingBox, MonsterManager monsterMng) {
		super(position, velocity, sword, armor, life,boundingBox);
		monsterManager = monsterMng;
		monsterMng.addMonster(this);
	}

	@Override
	public CollidableEnum type() {
		return CollidableEnum.MONSTER;
	}

	@Override
	public void die() { // gets removed from the list of living monsters
		setChanged();
		notifyObservers();
	}

	@Override
	public List<Collidable> toList() {
		List<Collidable> list = new ArrayList<Collidable>();
		list.add(this);
		return list;
	}

	public double attackPoints() {
		return sword.attackPoints();
	}
	
	@Override
	public void onCollision(Collidable theOneItCollided) {
		CollidableEnum type = theOneItCollided.type();
		switch(type) {
			case MONSTER : this.onCollisionWithCollidable();
						   break;
			case WALL : this.onCollisionWithCollidable();
						break;
			case ATTACK : this.receiveAttack((Attack)theOneItCollided);
						  this.onCollisionWithCollidable();
						  break;
			case PLAYER : this.onCollisionWithCollidable();
		}
	}

}