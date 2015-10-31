package com.allanvital.games.quick.battles.gameplay.player;

import java.util.List;

import com.allanvital.games.quick.battles.gameplay.actor.Soldier;

public interface GamePlayer {

	void receiveDeathNotification(Soldier soldier);
	void receiveSoldierList(List<Soldier> soldiers);
	List<Soldier> getSoldiers();
	
}
