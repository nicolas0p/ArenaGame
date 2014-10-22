package view;

import java.util.ArrayList;
import java.util.List;

import model.Wall;
import net.slashie.libjcsi.CSIColor;

public class WallView implements View {

	private Wall wall;
	
	public WallView(Wall wall) {
		this.wall = wall;
	}
	
	@Override
	public int getX() {
		return wall.getPosition().x;
	}

	@Override
	public int getY() {
		return wall.getPosition().y;
	}

	@Override
	public CSIColor getColor() {
		return CSIColor.BROWN;
	}

	@Override
	public String image() {
		return "□";
	}

	@Override
	public List<View> toList() {
		List<View> aux = new ArrayList<View>();
		aux.add(this);
		return aux;
	}
	
}