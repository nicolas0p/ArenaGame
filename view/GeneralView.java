package view;

import java.util.ArrayList;
import java.util.List;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;
import model.WallManager;
import model.Wall;

public class GeneralView {

	private List<View> views;
	
	// console
	private ConsoleSystemInterface csi;

	public GeneralView(ConsoleSystemInterface csi) {
		this.csi = csi;
		views = new ArrayList<View>();
	}
	
	public void addListView(List<View> toAdd) {
		views.addAll(toAdd);
	}
	
	public void addView(View toAdd) {
		views.add(toAdd);
	}
	
	public void draw() {
		csi.cls();
		for(View actual : views) {
			List<View> aux = actual.toList();
			for(View one : aux) {
				int x = one.getX();
				int y = one.getY();
				String image = one.image();
				CSIColor color = one.getColor();
				csi.print(x, y, image, color);
			}
		}
		csi.refresh();
	}
	
}