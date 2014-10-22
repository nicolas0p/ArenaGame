package model;

import java.util.ArrayList;
import java.util.List;

public class InicialMenu {

	private int actualPosition;
	private List<String> options;

	public InicialMenu() {
		options = new ArrayList<String>();
		options.add("New Game");
		options.add("Load Game");
		actualPosition = 0;
	}

	public void moveUp() {
		if(actualPosition < options.size() - 1) {
			actualPosition++; 
		}
	}

	public void moveDown() {
		if(actualPosition > 0) {
			actualPosition--;
		}
	}
	
	public List<String> options() {
		return options;
	}
	
	public int actualPosition() {
		return actualPosition;
	}

}