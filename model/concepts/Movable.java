package model.concepts;

import model.facingDirection.FacingDirection;


public interface Movable {

	public void moveTop();

	public void moveBot();

	public void moveLeft();

	public void moveRight();

	public FacingDirection facingDirection();
}