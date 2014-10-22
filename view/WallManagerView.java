package view;

import java.util.ArrayList;
import java.util.List;

import model.Wall;
import model.WallManager;
import net.slashie.libjcsi.CSIColor;

public class WallManagerView implements View {

	private WallManager wallManager;
	private List<WallView> views;
	
	public WallManagerView(WallManager wallManager) {
		this.wallManager = wallManager;
		views = new ArrayList<WallView>();
		addList(wallManager.walls());
	}
	
	public void addList(List<Wall> walls) {
		for(Wall actual : walls) {
			views.add(new WallView(actual));
		}
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
		return new ArrayList<View>(views);
	}

}
