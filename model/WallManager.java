package model;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import model.concepts.Collidable;
import model.concepts.CollidableEnum;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class WallManager implements Collidable{
	
	private List<Wall> walls;
	
	public WallManager(ConsoleSystemInterface csi) {
		walls = this.buildWalls(csi);
	}
	
	private List<Wall> buildWalls(ConsoleSystemInterface csi) {
		int width = csi.width();
		int height = csi.height();
		
		List<Wall> list = new ArrayList<Wall>();
		for(int i = 0 ; i < height ; i++) {
			Wall aux = new Wall(new Point(0,i));
			Wall aux2 = new Wall(new Point(width-1,i));
			list.add(aux);
			list.add(aux2);
		}
		
		for(int j = 1 ; j < width ; j++) {
			Wall aux = new Wall(new Point(j,0));
			Wall aux2 = new Wall(new Point(j, height-1));
			list.add(aux);
			list.add(aux2);
		}
		return list;
	}
	
	public List<Wall> walls() {
		return walls;
	}

	@Override
	public void onCollision(Collidable theOneHeCollided) {
	}

	@Override
	public Rectangle boundingBox() {
		return null;
	}

	@Override
	public CollidableEnum type() {
		return null;
	}

	@Override
	public List<Collidable> toList() {
		return new ArrayList<Collidable>(walls);
	}
}