package com.allanvital.games.quick.battles.texture;

import java.util.List;

import com.allanvital.games.quick.battles.gameplay.actor.Soldier;
import com.allanvital.games.quick.battles.gameplay.player.GamePlayer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextureHolder {
	
	private SpriteBatch batch;
	float elapsed;
	
	public TextureHolder() {
		batch = new SpriteBatch();
	}
	
	public void updatePositions(List<GamePlayer> players) {
		elapsed += Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for (GamePlayer gamePlayer : players) {
			for (Soldier soldier : gamePlayer.getSoldiers()) {
				batch.draw(
					soldier.getTexture(), soldier.getPosition().getX(),
					Gdx.graphics.getHeight() - 	soldier.getPosition().getY() - soldier.getTexture().getHeight()
				);
			}
		}
		batch.end();
	}
	
}
