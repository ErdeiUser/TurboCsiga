package main;

public class TurboSnailGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game G=new Game();
		try {
			G.Start(3);
		} catch (Exception e) {

			System.out.println("hiba az alkalmazásban:"+e.getMessage());
		}
	}

}
