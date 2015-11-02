package com.allanvital.games.quick.battles.gameplay.actor;

import com.allanvital.games.quick.battles.gameplay.Position;
import com.badlogic.gdx.graphics.Texture;


public abstract class MovableSoldier implements Soldier {

	protected Position position;
	protected Texture texture;
	protected Position destinationPosition;
	protected boolean isBattling = false;
	
	public abstract String toString();
	
	public MovableSoldier(Position position, Texture texture) {
		this.position = position;
		this.texture = texture;
	}

	@Override
	public Texture getTexture() {
		return texture;
	}

	@Override
	public Position getPosition() {
		return position;
	}
	
	@Override
	public void setDestination(Position position) {
		this.destinationPosition = position;
	}

	@Override
	public void setPosition(Position position) {
		if (position.equals(destinationPosition)) {
			destinationPosition = null;
		}
		this.position = position;
	}
	
	@Override
	public Boolean isMoving() {
		return !(destinationPosition == null);
	}
	
	@Override
	public void move(float deltaTime) {
		if (destinationPosition == null) {
			return;
		}
		
		float speedPerTick = deltaTime * this.getSpeed();
		float deltaX = destinationPosition.getX() - this.getPosition().getX();
		float deltaY = destinationPosition.getY() - this.getPosition().getY();
		float goalDistance = (float) Math.sqrt( (deltaX * deltaX) * (deltaY * deltaY) );
		
		Position nextPosition;
		
		if (goalDistance > speedPerTick) {
			float xMove = speedPerTick * deltaX;
			float yMove = speedPerTick * deltaY;
			nextPosition = new Position(this.getPosition().getX() + xMove, this.getPosition().getY() + yMove);
		} else {
			nextPosition = destinationPosition;
		}
		this.setPosition(nextPosition);
	}

	public void setBattle(boolean isBattling, Soldier soldier) {
		this.isBattling = isBattling;
	}
	
}
