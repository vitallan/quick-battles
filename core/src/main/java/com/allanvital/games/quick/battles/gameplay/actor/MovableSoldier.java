package com.allanvital.games.quick.battles.gameplay.actor;

import com.allanvital.games.quick.battles.gameplay.Position;
import com.badlogic.gdx.graphics.Texture;

public abstract class MovableSoldier implements Soldier {

	protected Position position;
	protected Texture texture;
	
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

}
