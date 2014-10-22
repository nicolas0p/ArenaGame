package view;

import java.util.List;
import java.util.ArrayList;

import model.InicialMenu;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class InicialMenuView implements View {
	
	private InicialMenu inicialMenu;
	private GeneralView generalView;
	
	public InicialMenuView(InicialMenu ini, GeneralView generalView) {
		inicialMenu = ini;
		this.generalView = generalView;
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
	public List<View> toList() {
		return null;
	}
}