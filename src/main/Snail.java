package main;

public class Snail implements IRacer
{
	String Color;
	String Name;
	
	int Boost=1;
	int Step=1;
	String ID;
	int Distance=0;
	
	@Override
	public String getColor() 
	{
		return(Color);
	}

	@Override
	public int getStep() {
		// TODO Auto-generated method stub
		return Step;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	@Override
	public void setBoost(int boost) {
		Boost=boost;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Name;
	}

	public Snail(String name,String id,int step,String color)
	{
		ID=id;
		Name=name;
		Step=step;
		Color=color;
		
	}

	@Override
	public int Move() {
		// TODO Auto-generated method stub
		int retval=Step*Boost;
		//csak 1 körig él a turbo
		Boost=1;
		Distance=Distance+retval;
		return retval;
	}
	
	@Override
	public int getDistance() {
		// TODO Auto-generated method stub
		return Distance;
	}
	
	@Override
	public void backToStart() {
		int Boost=1;
		int Step=1;
		int Distance=0;
	}
	
	@Override
	public boolean hasBoost()
	{
		return Boost>1;
	}
}
