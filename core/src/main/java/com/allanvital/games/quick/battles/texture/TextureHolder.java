package com.allanvital.games.quick.battles.texture;

import java.awt.Rectangle;

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
	
	public void updatePositions(GamePlayer humanPlayer, GamePlayer aiPlayer) {
		elapsed += Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		this.drawSoldiers(humanPlayer, aiPlayer, elapsed);
		this.drawSoldiers(aiPlayer, humanPlayer, elapsed);
		
		batch.end();
	}
	
	private void drawSoldiers(GamePlayer player, GamePlayer enemyPlayer, float elapsedTime) {
		for (Soldier soldier : player.getSoldiers()) {
			this.checkSoldierColliding(soldier, enemyPlayer);
			soldier.move(Gdx.graphics.getDeltaTime());
			batch.draw(
				soldier.getTexture(), 
				soldier.getPosition().getX(),
				Gdx.graphics.getHeight() - 	soldier.getPosition().getY() - soldier.getTexture().getHeight()
			);
		}
	}
	
	private void checkSoldierColliding(Soldier currentSoldier, GamePlayer enemyPlayer) {
		for (Soldier soldier : enemyPlayer.getSoldiers()) {
			Rectangle currentSoldierRectangle = this.getSoldierRectangle(currentSoldier);
			Rectangle enemySoldierRectangle = this.getSoldierRectangle(soldier);
			
			if (currentSoldierRectangle.intersects(enemySoldierRectangle)) {
				currentSoldier.setBattle(true, soldier);
				soldier.setBattle(true, currentSoldier);
				return;
			}
		}
		currentSoldier.setBattle(false, null);
	}
	
	private Rectangle getSoldierRectangle(Soldier soldier) {
		return new Rectangle((int)soldier.getPosition().getX(), 
				(int)soldier.getPosition().getY(), 
				soldier.getTexture().getWidth(), 
				soldier.getTexture().getWidth());
	}
	
}
