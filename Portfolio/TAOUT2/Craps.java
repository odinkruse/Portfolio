import java.util.Random;
public class Craps 
{
Random random  = new Random();
int dice1, dice2, firstsum;
	public Craps()
	{
	
	}
	public boolean roll()
	{
		dice1 = random.nextInt(6)+1;
		dice2 = random.nextInt(6)+1;
		if(dice1+dice2 == 7 || dice1+dice2 == 11)
		{
			return true;
		}
		if(dice1+dice2==3||dice1+dice2==2||dice1+dice2==12)
		{
			return false;
		}
		else
		{
			firstsum = dice1+dice2;
			return reroll();
		}
	}
	public boolean reroll()
	{
		dice1 = random.nextInt(6)+1;
		dice2 = random.nextInt(6)+1;
		//System.out.println("reroll");
		if(dice1+dice2 == firstsum)
		{
			return true;						
		}
		if(dice1+dice2 == 7)
		{
			return false;
		}
		else 
			return reroll();
	}
}
