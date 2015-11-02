package com.allanvital.games.quick.battles.gameplay;

public class Position {

	private float x;
	private float y;
	
	public Position(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public String toString() {
		return "[" + x + "-" + y + "]";
	}
	
	@Override
	public boolean equals(final Object other) {
		float epsilon = 0.1f;
		if(other instanceof Position){
	        final Position obj = (Position) other;
	        return (Math.abs(this.x - obj.x) < epsilon) && (Math.abs(this.y - obj.y) < epsilon) ;
	    } else{
	        return false;
	    }
	}
	
}
