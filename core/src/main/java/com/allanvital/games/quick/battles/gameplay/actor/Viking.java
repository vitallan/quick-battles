package com.allanvital.games.quick.battles.gameplay.actor;

import com.allanvital.games.quick.battles.gameplay.Position;
import com.allanvital.games.quick.battles.texture.TexturePathsConstants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Viking extends MovableSoldier {
	
	public Viking(Position position) {
		super(position, new Texture(Gdx.files.internal(TexturePathsConstants.VIKING_SPRITE)));
	}

	@Override
	public String toString() {
		return "<VIKING " + super.getPosition() + ">";
	}

}
