package control;

import model.Player;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class PlayerControl implements Control {

	private Player player;
	
	//Console 
	private ConsoleSystemInterface csi;
		
	public PlayerControl(Player player, ConsoleSystemInterface csi) {
		this.player = player;
		this.csi = csi;
	}
	
	public void update() {
		CharKey dir = csi.inkey();
		if(dir.isUpArrow()){
			player.moveTop();
		}
		if(dir.isDownArrow()){
			player.moveBot();
		}
		if(dir.isLeftArrow()){
			player.moveLeft();
		}
		if(dir.isRightArrow()){
			player.moveRight();
		}
		if(dir.isCenterArrow()) {
			player.attack();
//			System.out.println(player.getPosition());
		}
	}
}