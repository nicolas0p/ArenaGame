/*package model;

import java.awt.Point;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		AttackManager atkManager = new AttackManager();
		MonsterManager monsterManager = new MonsterManager();
		Player player = new Player(new Point(0,0), atkManager);
		BasicMonster monster = new BasicMonster(new Point(0,32), new Armor(0), monsterManager);
		player.attack();
		System.out.println(monster.getLife());
		new CollisionManager().collide(atkManager, monster);
		System.out.println(monster.getLife());
	}

}*/