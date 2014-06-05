package model;

import java.io.Serializable;

/**
 * 
 * @author Dashell
 *
 */
public class Coordinates  implements Serializable{

	private static final long serialVersionUID = 1L;
	int x;
	int y;
	
	/**
	 * Constructs an Coordinates with Cartesian coordinates (x being the abscissa axis and y-axis being ordered).
	 * @param x : The point located on the axis of abscissa.
	 * @param y : The point located on the axis of ordinate.
	 */
	public Coordinates(int x,int y){
		this.x=x;
		this.y=y;
	}

	/**
	 * Returns the position of the point on the axis of abscissa.
	 * @return x : The point located on the axis of abscissa.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Defines the point on the axis of abscissa.
	 * @param x : The point located on the axis of abscissa.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Returns the position of the point on the axis of ordinate.
	 * @return y : The point located on the axis of ordinate.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Defines the point on the axis of ordinate.
	 * @param y : The point located on the axis of ordinate.
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	
}
