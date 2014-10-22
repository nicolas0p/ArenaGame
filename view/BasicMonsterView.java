package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.BasicMonster;
import net.slashie.libjcsi.CSIColor;

public class BasicMonsterView extends Observable implements MonsterView, Observer {

	private BasicMonster basicMonster;
	private MonsterManagerView monsterManagerView;
	
	public BasicMonsterView(BasicMonster basic, MonsterManagerView monsterManagerView) {
		basicMonster = basic;
		this.monsterManagerView = monsterManagerView;
		basic.addObserver(this);
	}
	
	@Override
	public int getX() {
		return basicMonster.getPositionX();
	}

	@Override
	public int getY() {
		return basicMonster.getPositionY();
	}

	@Override
	public CSIColor getColor() {
		return CSIColor.BLUE;
	}

	@Override
	public String image() {
		return "Ψ"; //OH YEAH!!!
	}
	
	@Override
	public List<View> toList() {
		List<View> aux = new ArrayList<View>();
		aux.add(this);
		return aux;
	}

	@Override
	public void update(Observable o, Object arg) {
		monsterManagerView.removeMonster(this);
	}
	
}