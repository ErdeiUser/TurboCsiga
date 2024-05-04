package main;

import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class Game {
	ArrayList<IRacer> listRacer=new ArrayList<IRacer>();
	IRacerDepot Depo=new SnailDepot();
	ArrayList<String> racerNames=new ArrayList<String>();
	int maxRacerCount=0,maxRound=5,maxBoost=2;
	ArrayList<String> racerColors=new ArrayList<String>();
	boolean Race=false;
	int Round=1;
	Random selectBoosted= new Random();
	
	public Game()
	{

		racerNames.add("Első");
		racerNames.add("Második");
		racerNames.add("Harmadik");
		racerNames.add("Negyedik");
		racerNames.add("Ötödik");		
		maxRacerCount=racerNames.size();
		racerColors.add("Piros");
		racerColors.add("Zöld");
		racerColors.add("Kék");
		racerColors.add("Sárga");
		racerColors.add("Fehér");
		
	}
	
	public void Start(int racerCount) throws Exception
	{
		if(racerCount>maxRacerCount)
		{
			throw new Exception("Sorry, too many racer!");
		}
		
		for (int i=0;i<racerCount;i++)
		{

			IRacer racer=Depo.Create(racerNames.get(i),String.valueOf(i)+" csiga",1,racerColors.get(i));
			listRacer.add(racer);
		}
		
		Race=true;
		System.out.println("Verseny elindul");
		int boostedRacer=0;
		int betWinner=0;
		
		Scanner myInput = new Scanner( System.in );
		while(true)
		{
			System.out.println( "Melyik csiga nyer? (1,2,3): " );
			betWinner = myInput.nextInt();
			if(betWinner>=1 && betWinner<=3)
			{
				break;
			}
		}
		myInput.close();
		System.out.println( "A játékos tippje: "+String.valueOf(betWinner) );

		while(Round<=maxRound)
		{ 
			
			if(Race)
			{
				System.out.println("---------------- Verseny folyamatban "+String.valueOf(Round)+". kör -------------------");
			}
			
			boostedRacer=selectBoosted.nextInt(racerCount);

			System.out.println("Turbo csiga =>"+String.valueOf(boostedRacer+1));
			
			for (int i=0;i<racerCount;i++) 
			{
			
				IRacer racer=listRacer.get(i);
				String hasBoost="";
				if (i==boostedRacer) {
					racer.setBoost(maxBoost);
					hasBoost="(turbo speed)";
				}
				int step=racer.Move();

				 
				
				System.out.println(racer.getName()+" "+racer.getColor() +" lépett "+step+hasBoost + " távolsága:"+racer.getDistance() );
			}
			Round++;
		}
	    Race=false;
	    
		int maxDistance=0;
		IRacer winner=null;
		int winnerSnailCount=0;

		for (int i=0;i<racerCount;i++) {
			
			IRacer racer=listRacer.get(i);
			int distance=racer.getDistance();
			
			if (distance>maxDistance) 
			{
				maxDistance=distance;
				winner=racer;
				winnerSnailCount=i+1;
			}
		}
		System.out.println("--------------------------------------");
		System.out.println("A versenyt "+winner.getName()+" "+ winner.getColor()+" nyerte meg "+String.valueOf( winner.getDistance()) + " távolsággal");
		if (betWinner==winnerSnailCount) 
		{
			System.out.println("A játékos nyert!");
		}
		else
		{
			System.out.println("A játékos vesztett!");
		}
	
}
}	