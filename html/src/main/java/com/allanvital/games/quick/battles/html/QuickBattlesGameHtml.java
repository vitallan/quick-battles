package com.allanvital.games.quick.battles.html;

import com.allanvital.games.quick.battles.core.QuickBattlesGame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class QuickBattlesGameHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new QuickBattlesGame();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
