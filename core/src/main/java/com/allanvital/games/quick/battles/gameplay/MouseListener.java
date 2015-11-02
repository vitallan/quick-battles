package com.allanvital.games.quick.battles.gameplay;

import java.util.List;

import com.allanvital.games.quick.battles.gameplay.actor.Soldier;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;

public class MouseListener implements InputProcessor {

	private List<Soldier> allSoldiers;
	
	private Soldier clickedSoldier;
	
	public MouseListener(List<Soldier> allSoldiers) {
		this.allSoldiers = allSoldiers;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (button == Buttons.LEFT) {
			checkSelect(screenX, screenY);
		}
		if (button == Buttons.RIGHT) {
			setMove(screenX, screenY);
		}
		return false;
	}

	private void setMove(int screenX, int screenY) {
		clickedSoldier.setDestination(new Position(screenX, screenY));
	}
	
	private void checkSelect(int screenX, int screenY) {
		for (Soldier soldier : allSoldiers) {
			if (isClickInSoldier(screenX, screenY, soldier.getPosition().getX(), 
					soldier.getPosition().getY(), soldier.getTexture().getHeight(), 
					soldier.getTexture().getWidth())) {
				
				this.clickedSoldier = soldier;
				return;
			} 
		}
		this.clickedSoldier = null;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	private Boolean isClickInSoldier(int clickX, int clickY, float areaXStart, float areaYStart, int areaHeight, int areaWidth) {
		float areaXFinal = areaXStart + areaWidth;
		float areaYFinal = areaYStart + areaHeight;
		return (clickX >= areaXStart && clickX <= areaXFinal) && (clickY >= areaYStart && clickY <= areaYFinal);
	}
	
}
