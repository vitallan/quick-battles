package com.allanvital.games.quick.battles.gameplay;

import org.apache.commons.lang.builder.EqualsBuilder;

public class Position {

	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "[" + x + "-" + y + "]";
	}
	
	@Override
	public boolean equals(final Object other) {
		if(other instanceof Position){
	        final Position obj = (Position) other;
	        return new EqualsBuilder()
	            .append(x, obj.x)
	            .append(y, obj.y)
	            .isEquals();
	    } else{
	        return false;
	    }
	}
	
}
