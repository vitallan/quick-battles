package com.allanvital.games.quick.battles.gameplay.player;

import java.util.List;

import com.allanvital.games.quick.battles.gameplay.actor.Soldier;

public class AIPlayer implements GamePlayer {

	private List<Soldier> soldiers;
	
	@Override
	public void receiveDeathNotification(Soldier soldier) {
	}

	@Override
	public void receiveSoldierList(List<Soldier> soldiers) {
		this.soldiers = soldiers;
	}

	@Override
	public List<Soldier> getSoldiers() {
		return soldiers;
	}

}
