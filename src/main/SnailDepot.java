package main;

public class SnailDepot implements IRacerDepot{

	@Override
	public IRacer Create(String Name, String ID, int Step, String Color) {
		Snail retval=null;
		try {
			// TODO Auto-generated method stub
			retval=new Snail(Name,ID,Step,Color);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return retval;
	}

}
