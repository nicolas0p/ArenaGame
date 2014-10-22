package model;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class BasicMonster extends Monster {
	
	
	public BasicMonster(Point position, MonsterManager monsterMng) {
		super(position, 1, new Sword(1), new Armor(0), 5, new Rectangle(position, new Dimension(1,1)),monsterMng);
	}

	/*STATS:
	 * life: 5
	 * atk: 1
	 * vel: 1
	 * def: 0
	 * dimensions: 32 x 32
	 */
}