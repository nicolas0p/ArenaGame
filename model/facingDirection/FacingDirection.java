package model.facingDirection;

import java.awt.Dimension;
import java.awt.Point;

public interface FacingDirection {
	
	public Point attackPosition(Point attackerPosition, Dimension atkDim, int attackXSize, int attackYSize);

}
