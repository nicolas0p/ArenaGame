package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.BasicMonster;
import model.Monster;
import model.MonsterManager;
import net.slashie.libjcsi.CSIColor;

public class MonsterManagerView extends Observable implements View, Observer {
	
	private MonsterManager monsterManager;
	private List<MonsterView> views;
	
	public MonsterManagerView(MonsterManager monsterManager) {
		this.monsterManager = monsterManager;
		monsterManager.addObserver(this);
		views = new ArrayList<MonsterView>();
	}
	
	@Override
	public List<View> toList() {
		return new ArrayList<View>(views);
	}
	
	@Override
	public int getX() {
		return 0;
	}
	
	@Override
	public int getY() {
		return 0;
	}

	@Override
	public CSIColor getColor() {
		return null;
	}

	@Override
	public String image() {
		return null;
	}

	@Override
	public void update(Observable monsterManager, Object monster) {
		this.addMonster((BasicMonster)monster);
	}
	
	public void addMonster(BasicMonster monster) {
		BasicMonsterView monsterView = new BasicMonsterView(monster, this);
		views.add(monsterView);
	}
	
	public void addList(List<BasicMonster> list) {
		for(BasicMonster actual : list) {
			views.add(new BasicMonsterView(actual, this));
		}
	}
	
	public void removeMonster(MonsterView monster) {
		views.remove(monster);
	}
	
}