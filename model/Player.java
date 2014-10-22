package model;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import model.concepts.Collidable;
import model.concepts.CollidableEnum;

public class Player extends Entity {

	// private Wallet wallet;
	private AttackManager attackManager;

	public Player(Point posicao, AttackManager atkMng) {
		super(posicao, 1, new Sword(1), new Armor(5), 20, new Rectangle(
				posicao, new Dimension(1, 1))); // attack = 1, armor = 5(%),
												// life = 20 default
		attackManager = atkMng;
	}

	public Player(Point position, AttackManager atkMng, Sword sword,
			Armor armor, double life) {
		super(position, 2, sword, armor, life, new Rectangle(position,
				new Dimension(32, 32)));
		attackManager = atkMng;
	}

	public Player(Point position, AttackManager atkMng, Sword sword,
			Armor armor, double life, double maxLife) {
		super(position, 2, sword, armor, life, new Rectangle(position,
				new Dimension(32, 32)));
		attackManager = atkMng;
	}

	@Override
	public CollidableEnum type() {
		return CollidableEnum.PLAYER;
	}

	@Override
	public List<Collidable> toList() {
		List<Collidable> list = new ArrayList<Collidable>();
		list.add(this);
		return list;
	}

	public void attack() { // creates and sends an attack to the atkManager on
							// the right position
		Dimension atkDim = sword.dimension();
		Point attackPosition = facing.attackPosition(position, atkDim,
				atkDim.width, atkDim.height);
		Attack newAttack = new Attack(sword.attackPoints(), attackPosition);
		attackManager.addAttack(newAttack);
	}

	@Override
	public void onCollision(Collidable theOneItCollided) {
		CollidableEnum type = theOneItCollided.type();
		switch (type) {
		case MONSTER:
			this.receiveDamage(((Monster) theOneItCollided).attackPoints());
			this.onCollisionWithCollidable();
			break;
		case ATTACK:
			this.onCollisionWithCollidable();
			break;
		default:
			this.onCollisionWithCollidable();
			break;
		}
	}

	@Override
	public void die() {
		// TODO Game Over scene
	}

	public boolean isAlive() {
		return life > 0;
	}

}