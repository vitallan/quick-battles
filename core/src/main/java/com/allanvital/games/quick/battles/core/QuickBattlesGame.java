package com.allanvital.games.quick.battles.core;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.allanvital.games.quick.battles.gameplay.MouseListener;
import com.allanvital.games.quick.battles.gameplay.Position;
import com.allanvital.games.quick.battles.gameplay.actor.Peasant;
import com.allanvital.games.quick.battles.gameplay.actor.Soldier;
import com.allanvital.games.quick.battles.gameplay.actor.Viking;
import com.allanvital.games.quick.battles.gameplay.player.AIPlayer;
import com.allanvital.games.quick.battles.gameplay.player.GamePlayer;
import com.allanvital.games.quick.battles.gameplay.player.HumanPlayer;
import com.allanvital.games.quick.battles.texture.TextureHolder;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public class QuickBattlesGame implements ApplicationListener {
	
	private GamePlayer humanPlayer;
	private GamePlayer aiPlayer;
	private List<Soldier> allSoldiers = new LinkedList<>();
	private TextureHolder holder;

	@Override
	public void create () {
		Soldier enemySoldier = new Viking(new Position(440, 240));
		Soldier mySoldier = new Peasant(new Position(120, 240));
		humanPlayer = new HumanPlayer();
		aiPlayer = new AIPlayer();
		humanPlayer.receiveSoldierList(Arrays.asList(mySoldier));
		aiPlayer.receiveSoldierList(Arrays.asList(enemySoldier));
		allSoldiers.add(mySoldier);
		allSoldiers.add(enemySoldier);
		holder = new TextureHolder();
		Gdx.input.setInputProcessor(new MouseListener(allSoldiers));
	}

	@Override
	public void resize (int width, int height) {
	}

	@Override
	public void render () {
		holder.updatePositions(humanPlayer, aiPlayer);
	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void dispose () {
	}
}
