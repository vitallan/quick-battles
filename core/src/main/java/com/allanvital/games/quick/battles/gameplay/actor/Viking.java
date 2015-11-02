package com.allanvital.games.quick.battles.gameplay.actor;

import com.allanvital.games.quick.battles.gameplay.Position;
import com.allanvital.games.quick.battles.texture.TexturePathsConstants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Viking extends MovableSoldier {
	
	public Viking(Position position, Texture texture) {
		super(position, texture);
	}
	
	public Viking(Position position) {
		super(position, new Texture(Gdx.files.internal(TexturePathsConstants.VIKING_SPRITE)));
	}

	@Override
	public String toString() {
		return "<VIKING " + super.getPosition() + ">";
	}

	@Override
	public float getSpeed() {
		if (isBattling) {
			return 0.2f;
		}
		return 2.8f;
	}

}
