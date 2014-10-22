package control;

import model.InicialMenu;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class InicialMenuControl implements Control {

	
	private InicialMenu inicialMenu;
	private ConsoleSystemInterface csi;
	
	@Override
	public void update() {
		CharKey dir = csi.inkey();
		if(dir.isUpArrow()){
			inicialMenu.moveUp();
		}
		if(dir.isDownArrow()){
			inicialMenu.moveDown();
		}
	}
	
}