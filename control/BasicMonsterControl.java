package control;

import java.awt.Point;

import model.BasicMonster;
import model.Player;

public class BasicMonsterControl implements Control{

	private BasicMonster monster;
	private Player player;
	
	public BasicMonsterControl(BasicMonster mons, Player play) {
		monster = mons;
		player = play;
	}

	@Override
	public void update() { //poor AI
		Point playerPosition = player.getPosition();
		Point monsterPosition = monster.getPosition();
		
		if(monsterPosition.x > playerPosition.x) {
			monster.moveLeft();
		}
		else {
			monster.moveRight();
		}
		if(monsterPosition.y > playerPosition.y) {
			monster.moveTop();
		}
		else {
			monster.moveBot();
		}
	}
}