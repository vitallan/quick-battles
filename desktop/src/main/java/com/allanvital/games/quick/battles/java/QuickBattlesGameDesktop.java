package com.allanvital.games.quick.battles.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.allanvital.games.quick.battles.core.QuickBattlesGame;

public class QuickBattlesGameDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new QuickBattlesGame(), config);
	}
}
