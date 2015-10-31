package com.allanvital.games.quick.battles.gameplay.actor;

import com.allanvital.games.quick.battles.gameplay.Position;
import com.badlogic.gdx.graphics.Texture;

public interface Soldier {

	Texture getTexture();
	Position getPosition();
	float getSpeed();
	Boolean isMoving();
	void setDestination(Position position);
	void setPosition(Position position);
	void move(float delta);
	
}
