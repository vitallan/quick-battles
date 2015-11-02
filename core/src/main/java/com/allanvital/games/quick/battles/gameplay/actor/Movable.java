package com.allanvital.games.quick.battles.gameplay.actor;

import com.allanvital.games.quick.battles.gameplay.FacingDirection;
import static com.allanvital.games.quick.battles.gameplay.FacingDirection.*;
import com.allanvital.games.quick.battles.gameplay.Position;
import com.allanvital.games.quick.battles.utils.AngleUtils;

public interface Movable {

	void setDestination(Position position);
	void setPosition(Position position);
	Position getDestination();
	Position getPosition();
	float getSpeed();

	default FacingDirection getFacingDirection() {
		if (this.getDestination() == null) {
			return S;
		}
		float deltaX = this.getDestination().getX() - this.getPosition().getX();
		float deltaY = this.getDestination().getY() - this.getPosition().getY();
		
		float angle = (float) Math.toDegrees(Math.atan2(deltaY, deltaX));
		
		if(angle < 0){
	        angle += 360;
	    }
		System.out.println(AngleUtils.getFacingDirection(angle) + " -> " + angle);
		return AngleUtils.getFacingDirection(angle);
	}
	
	default boolean isMoving() {
		return this.getDestination() == null;
	}
	
	default void move(float delta) { 
		if (this.getDestination() == null) {
			return;
		}
		
		float speedPerTick = delta * this.getSpeed();
		float deltaX = this.getDestination().getX() - this.getPosition().getX();
		float deltaY = this.getDestination().getY() - this.getPosition().getY();
		float goalDistance = (float) Math.sqrt( (deltaX * deltaX) * (deltaY * deltaY) );
		
		Position nextPosition;
		
		if (goalDistance > speedPerTick) {
			float xMove = speedPerTick * deltaX;
			float yMove = speedPerTick * deltaY;

			nextPosition = new Position(this.getPosition().getX() + xMove, this.getPosition().getY() + yMove);
		} else {
			nextPosition = this.getDestination();
			this.setDestination(null);
		}
		getFacingDirection();
		this.setPosition(nextPosition);
	}
	
}
