package model;

import java.util.TimerTask;

public class AttackTimerTask extends TimerTask {

	private Attack attack;

	public AttackTimerTask (Attack attack) {
		this.attack = attack;
	}
	
	@Override
	public void run() {
		attack.finished();		
	}

}
