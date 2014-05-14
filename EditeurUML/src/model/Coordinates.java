package model;

import java.io.Serializable;

/**
 * 
 * @author Dashell
 *
 */
public class Coordinates  implements Serializable{

	int x;
	int y;
	
	public Coordinates(int x,int y){
		this.x=x;
		this.y=y;
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
	
	
}
