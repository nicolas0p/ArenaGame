package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.Attack;
import net.slashie.libjcsi.CSIColor;

public class AttackView extends Observable implements View, Observer {

	private Attack attack;
	private AttackManagerView atkManagerView;
	
	public AttackView(Attack atk, AttackManagerView atkManView) {
		attack = atk;
		atkManagerView = atkManView;
		attack.addObserver(this);
	}

	@Override
	public int getX() {
		return attack.boundingBox().x;
	}

	@Override
	public int getY() {
		return attack.boundingBox().y;
	}

	@Override
	public CSIColor getColor() {
		return CSIColor.RED;
	}

	@Override
	public String image() {
		return "/";
	}

	@Override
	public List<View> toList() {
		List<View> aux = new ArrayList<View>();
		aux.add(this);
		return aux;
	}

	@Override
	public void update(Observable attack, Object arg) {
		atkManagerView.removeAttack(this);
	}

}