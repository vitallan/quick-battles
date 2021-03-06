package com.allanvital.games.quick.battles;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.allanvital.games.quick.battles.gameplay.Position;
import com.allanvital.games.quick.battles.gameplay.actor.Viking;

public class VikingTest {

	private Viking viking;
	private Position initialPosition = new Position(5,5);
	private float defaultDelta = 0.01f;
	
	@Before
	public void setup() {
		viking = new Viking(initialPosition, null);
	}
	
	@Test
	public void moveTestUp() {
		Position destination = new Position(0, 0);
		viking.setDestination(destination);
		for (int i = 0; i < 121; i++) {
			viking.move(defaultDelta);
		}
		assertEquals(viking.getPosition(), destination);
	}
	
	@Test
	public void moveTestDown() {
		Position destination = new Position(207, 247);
		viking.setDestination(destination);
		for (int i = 0; i < 256; i++) {
			viking.move(defaultDelta);
		}
		assertEquals(viking.getPosition(), destination);
	}

}
