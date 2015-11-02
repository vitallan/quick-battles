package com.allanvital.games.quick.battles.gameplay.actor;

import java.util.HashSet;
import java.util.Set;

import com.allanvital.games.quick.battles.gameplay.Position;
import com.badlogic.gdx.graphics.Texture;


public abstract class MovablePrintableSoldier implements Soldier {

	protected Position position;
	protected Texture texture;
	protected Position destination;
	protected boolean isBattling;
	protected Set<Soldier> battlingWith = new HashSet<Soldier>();
	
	public abstract String toString();
	
	public MovablePrintableSoldier(Position position, Texture texture) {
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
	public Position getDestination() {
		return destination;
	}
	
	@Override
	public void setDestination(Position destination) {
		this.destination = destination;
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public void setStatusWith(Soldier soldier, boolean isBattlingAgainst) {
		if (isBattlingAgainst) {
			battlingWith.add(soldier);
		} else {
			battlingWith.remove(soldier);
		}
		this.isBattling = battlingWith.isEmpty();
	}
	
}
