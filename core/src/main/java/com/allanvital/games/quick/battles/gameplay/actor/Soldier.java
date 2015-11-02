package com.allanvital.games.quick.battles.gameplay.actor;

public interface Soldier extends Movable, Printable {

	void setStatusWith(Soldier soldier, boolean isBattling);

}
