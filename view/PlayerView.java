package view;

import java.util.ArrayList;
import java.util.List;

import model.Player;
import net.slashie.libjcsi.CSIColor;


public class PlayerView implements View {
	
	private Player player;
	
	//Image
	private String image;

	public PlayerView(Player player) {
		this.player = player;
		this.image = "@";
	}
	
	public String image() {
		return image;
	}

	@Override
	public int getX() {
		return player.getPositionX();
	}

	@Override
	public int getY() {
		return player.getPositionY();
	}

	@Override
	public CSIColor getColor() {
		return CSIColor.WHITE;
	}
	
	@Override
	public List<View> toList() {
		List<View> aux = new ArrayList<View>();
		aux.add(this);
		return aux;
	}
	
}