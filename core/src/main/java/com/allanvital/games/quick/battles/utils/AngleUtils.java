package com.allanvital.games.quick.battles.utils;
import static com.allanvital.games.quick.battles.gameplay.FacingDirection.*;

import com.allanvital.games.quick.battles.gameplay.FacingDirection;

public class AngleUtils {

	public static FacingDirection getFacingDirection(float angle) {
		if (angle <= 30 || angle >= 330) {
			return E;
		} else if (angle <= 330 && angle >= 300) {
			return NE;
		} else if (angle >= 240 && angle <= 300) {
			return N;
		} else if (angle <= 240 && angle >= 210) {
			return NW;
		} else if (angle <= 210 && angle >= 150) {
			return W;
		} else if (angle <= 150 && angle >= 120) {
			return SW;
		} else if (angle <= 120 && angle >= 60) {
			return S;
		} else {
			return SE;
		}
	}
	
}
