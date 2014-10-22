package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.slashie.libjcsi.ConsoleSystemInterface;

public class BasicMonsterSpawner {
	
	private ConsoleSystemInterface csi;
	private MonsterManager monsterManager;

	public BasicMonsterSpawner(MonsterManager monsterManager, ConsoleSystemInterface csi) {
		this.monsterManager = monsterManager;
		this.csi = csi;
	}
	
	public List<BasicMonster> spawn(int howMuch) {
		int width = csi.width();
		int height = csi.height();
		
		Random r = new Random();
		List<BasicMonster> list = new ArrayList<BasicMonster>();
		
		for(int i = 0 ; i < howMuch ; i++) {
			int x = (int)(r.nextDouble()*(width-1)+1); //between 1 and width-1
			int y = (int)(r.nextDouble()*(height-1)+1); //between 1 and height-1
			Point position = new Point(x, y);
			BasicMonster willBeSpawned = new BasicMonster(position, monsterManager);
			list.add(willBeSpawned);
		}
		return list;
	}
	
}