/*
 * Class: CMSC203 
 * Instructor: Professor Gary Thai
 * Description: Make a random number guessing game that gives hints after a turn to help out the player!
 * Due: 07/03/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Mohammed Ali
*/


import java.util.Scanner;		//import needed for scanner

public class RandomNumberGuesser
{
	
	public static void main(String[] args)	//main method
	{
		final String PROGRAMMER_CREDITS = "Programmer: Mohammed Ali\nThank you for using my program!";
		
		//variables to store random number, next guess number, high number, and low number
		int randNumber;
		int nextGuess;
		int highGuess;
		int lowGuess;
		int countGuess=1;
		
		//loopControlVariable
		String inputYesNo;
		
		Scanner keyboard = new Scanner(System.in);
		
		randNumber = RNG.rand();
		
		System.out.println("Hello, we will be playing a "		//intro output
				+ "random number guessing game.\nYou will try"
				+ " to guess the random number!\n");
		do	//do-while loop to execute the game atleast once, then be able to ask the user if they wanna play again
		{
			RNG.resetCount();		//at the start of the game, i wanted to reset the variables
		    randNumber= RNG.rand();
		    highGuess=100;
		    lowGuess=1;
		  
		    do	//do-while loop if the guessed number was incorrect
		       {
		    	if(RNG.getCount()==0)		//first try if statement
			    {
		    		System.out.println("Enter your first guess:");
					nextGuess = keyboard.nextInt();
					if(nextGuess==randNumber)
	    			{
	    				break;
	    			}
		    		if(RNG.inputValidation(nextGuess, lowGuess, highGuess))
		    		{
		    			 if(nextGuess<=randNumber && (randNumber-nextGuess)<(randNumber-lowGuess))
		                 {
		                     lowGuess=nextGuess;
		                     System.out.println("Your guess is too low");
		                 }
		                 if(nextGuess>=randNumber && (nextGuess-randNumber)<(highGuess-randNumber))
		                 {
		                     highGuess=nextGuess;
		                     System.out.println("Your guess is too high");
		                 }
		                 
		    		}
			    }
			    else		//if it's second try or higher
			    	
			    	countGuess = RNG.getCount();
		    		System.out.println("Number of guesses is "+countGuess);
		    		nextGuess = keyboard.nextInt();
		    		if(nextGuess==randNumber)
	    			{
	    				break;
	    			}
		    		if(RNG.inputValidation(nextGuess, lowGuess, highGuess))
		    		{
		    			 if(nextGuess<=randNumber && (randNumber-nextGuess)<(randNumber-lowGuess))
		                 {
		                     lowGuess=nextGuess;
		                     System.out.println("Your guess is too low");
		                 }
		                 if(nextGuess>=randNumber && (nextGuess-randNumber)<(highGuess-randNumber))
		                 {
		                     highGuess=nextGuess;
		                     System.out.println("Your guess is too high");
		                 }
		    		}
		        	   
		       }
		    while(nextGuess!=randNumber);
		    System.out.println("Your guess is correct!");
		    keyboard.nextLine();
			System.out.println("Do you want to play again? (Type yes or no)");
			inputYesNo = keyboard.nextLine();
		}
		while(!(inputYesNo.equalsIgnoreCase("no")));	//if user says no, gives output, and gives programmers credit, else game restarts
		System.out.println("Thank you for playing!");
		System.out.println(PROGRAMMER_CREDITS);
		keyboard.close();
		System.exit(0);
	}
}