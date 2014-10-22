package model;

import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import model.concepts.Collidable;
import model.concepts.CollidableEnum;

public class Wall implements Collidable {
	
	private Point position;
	private Rectangle boundingBox; //walls are squares
	
	public Wall(Point pos) {
		position = pos;
		boundingBox = new Rectangle(position, new Dimension(1,1));
	}
	
	public Point getPosition() {
		return position;
	}
	
	public Rectangle boundingBox() {
		return boundingBox;
	}

	@Override
	public void onCollision(Collidable theOneItCollided) {
		//Do nothing, you're a wall, man!
	}

	@Override
	public List<Collidable> toList() {
		List<Collidable> list = new ArrayList<Collidable>();
		list.add(this);
		return list;
	}

	@Override
	public CollidableEnum type() {
		return CollidableEnum.WALL;
	}
}