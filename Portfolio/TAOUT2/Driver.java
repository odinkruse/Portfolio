
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		double wins = 0;
		double losses = 0;
		double games = 0;
		double winrate;
		Craps instance = new Craps();
		do
		{
			boolean temp = instance.roll();
			if(temp == true)
			{
				wins++;
				//System.out.println("win");
				
			}
			else if(temp == false)
			{
				losses++;
				//System.out.println("loss");
			}
			games++;
		}
		while(games<10000000);
		winrate = wins/games;
		System.out.println(wins+ " wins " + losses+ " losses ");
		System.out.println("winrate "+winrate);
	}

}
