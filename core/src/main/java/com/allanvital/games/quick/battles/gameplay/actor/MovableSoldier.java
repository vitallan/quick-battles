package com.allanvital.games.quick.battles.gameplay.actor;

import com.allanvital.games.quick.battles.gameplay.Position;
import com.badlogic.gdx.graphics.Texture;

public abstract class MovableSoldier implements Soldier {

	protected Position position;
	protected Texture texture;
	protected Position destinationPosition;
	
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
		int myX = this.getPosition().getX();
		int myY = this.getPosition().getY();
		
		int destinationX = this.destinationPosition.getX();
		int destinationY = this.destinationPosition.getY();
		
		int xDifference = destinationX - myX;
		int yDifference = destinationY - myY;
		
		float xSpeed = this.getSpeed();
		float ySpeed = this.getSpeed();
		
		if (xDifference != 0 && yDifference != 0) {
			xSpeed = this.getSpeed() / 2;
			ySpeed = this.getSpeed() / 2;
		}
		if (xDifference < 0) {
			myX = (int) Math.floor(myX - (deltaTime * xSpeed));
		} else {
			myX = (int) Math.ceil((myX + (deltaTime * xSpeed)));
		}
		if (yDifference < 0) {
			myY = (int) Math.floor(myY - (deltaTime * ySpeed));
		} else {
			myY = (int) Math.ceil(myY + (deltaTime * ySpeed));
		}
		this.setPosition(new Position(myX, myY));
	}

}
