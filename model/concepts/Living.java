package model.concepts;

import model.Attack;

public interface Living {

	public double getLife();

	public void receiveAttack(Attack atk);

	public void receiveDamage(double dmg);

	public void die();
}
