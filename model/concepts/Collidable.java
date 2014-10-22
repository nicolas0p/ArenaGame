package model.concepts;

import java.awt.Rectangle;
import java.util.List;

public interface Collidable {

	public void onCollision(Collidable theOneHeCollided);

	public Rectangle boundingBox();

	public CollidableEnum type();

	public List<Collidable> toList();

}