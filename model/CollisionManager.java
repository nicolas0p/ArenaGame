package model;

import java.util.List;

import model.concepts.Collidable;

public class CollisionManager {
	
	public CollisionManager() {
		
	}
	
	public void collide(Collidable one, Collidable two) {
		List<Collidable> listOfOne = one.toList();
		List<Collidable> listOfTwo = two.toList();
		
		for(Collidable collidableOne : listOfOne) {
			for(Collidable collidableTwo : listOfTwo) {
				
				if(collidableOne.boundingBox().intersects(collidableTwo.boundingBox())) {
					
					collidableOne.onCollision(collidableTwo); //warns collidableOne that he collided with collidableTwo
					
					collidableTwo.onCollision(collidableOne); //warns collidableTwo that he collided with collidableOne
				}
			}
		}
	}
}