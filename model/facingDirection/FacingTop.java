package model.facingDirection;

import java.awt.Dimension;
import java.awt.Point;

public class FacingTop implements FacingDirection {

	@Override
	public Point attackPosition(Point attackerPosition, Dimension atkDim, int attackXSize,
			int attackYSize) {
		return new Point(attackerPosition.x, attackerPosition.y - attackYSize);
	}
	
}
