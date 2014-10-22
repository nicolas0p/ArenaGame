package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.Attack;
import model.AttackManager;
import net.slashie.libjcsi.CSIColor;

public class AttackManagerView implements View, Observer {

	private AttackManager attackManager;
	private List<AttackView> views;
	
	public AttackManagerView(AttackManager atkManager) {
		attackManager = atkManager;
		attackManager.addObserver(this);
		views = new ArrayList<AttackView>();
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
	public void update(Observable attackManager, Object atk) {
		this.addAttack((Attack)atk);
	}
	
	public void addAttack(Attack atk) {
		AttackView atkView = new AttackView(atk, this);
		views.add(atkView);
	}
	
	public void removeAttack(AttackView atk) {
		views.remove(atk);
	}
	
}