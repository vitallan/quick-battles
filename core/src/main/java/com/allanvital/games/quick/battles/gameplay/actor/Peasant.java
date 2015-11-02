package com.allanvital.games.quick.battles.gameplay.actor;

import com.allanvital.games.quick.battles.gameplay.Position;
import com.allanvital.games.quick.battles.texture.TexturePathsConstants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Peasant extends MovableSoldier {

	public Peasant(Position position) {
		super(position, new Texture(Gdx.files.internal(TexturePathsConstants.PEASANT_SPRITE)));
	}

	@Override
	public String toString() {
		return "<PEASANT " + super.getPosition() + ">";
	}

	@Override
	public float getSpeed() {
		return 1.5f;
	}
	
}
