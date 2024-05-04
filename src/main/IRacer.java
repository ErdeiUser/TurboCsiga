
package main;

public interface IRacer {
	String getName();
	int getStep();
	String getID();
	int Move();
	int getDistance();
	void backToStart();
	boolean hasBoost();
	void setBoost(int boost);
	String getColor();
}
