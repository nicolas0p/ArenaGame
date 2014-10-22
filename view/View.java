package view;

import java.util.List;

import net.slashie.libjcsi.CSIColor;

public interface View {
	public int getX();
	public int getY();
	public CSIColor getColor();
	public String image();
	public List<View> toList();
}