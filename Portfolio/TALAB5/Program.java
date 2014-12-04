import java.util.*;
/**
 * Write a description of class Program here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Program
{
    // instance variables - replace the example below with your own
    private String sentence;
    Scanner scan = new Scanner(System.in);

    public Program(String in_sentence)
    {
    	sentence = in_sentence;
    	//System.out.println("Enter a sentence");
    	//sentence = scan.nextLine();
    }

    public void menu()
    {
    	System.out.println("Press 1 to find letters:");
    	System.out.println("Press 2 to find word count:");
    	System.out.println("Press 3 to change the sentence:");
    	System.out.println("Press 4 to exit:");
    	int choice = scan.nextInt();
    	switch (choice){
    	case 1: findletter();
    		menu();
    	case 2: findwords();
    		menu();
    	case 3: changesentence();
    		menu();
    	case 4: break;
    	default: System.exit(4);
    	}
    }
    public void findletter()
    {
        System.out.println("enter letter");
        char letter = scan.next().charAt(0);
        char[] chararr = sentence.toCharArray();
        int counter = 0;
        for(int i = 0; i < chararr.length; i++)
        {
            if(chararr[i] == letter)
            {
                counter++;
            }
        }
        System.out.println(counter+" instances of " +letter);
    }
    public void findwords()
    {
    	int words = 1;
    	char[] chararr = sentence.toCharArray();
    	for(int i = 0; i <chararr.length; i ++)
    	{
    		if(chararr[i] == ' ')
    		{
    			words++;
    		}
    	}
    	System.out.println(words+" words");
    }
    public void changesentence()
    {
    	scan.nextLine();
    	System.out.println("Enter new sentence");
    	sentence = scan.nextLine();
    }
}


