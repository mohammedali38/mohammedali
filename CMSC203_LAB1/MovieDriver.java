package application;

import java.util.Scanner;

public class MovieDriver
	{
		public static void main(String[] args) 
			{
				String continueMovie;
			
				do
					{
						Scanner keyboard = new Scanner(System.in);
				
						Movie movieObject = new Movie();
			
						System.out.println("Enter the title of the movie: ");
						String title = keyboard.nextLine();
						movieObject.setTitle(title);

						System.out.println("Enter the movie's rating: ");
						String rating = keyboard.nextLine();
						movieObject.setRating(rating);
				
						System.out.println("Enter the amount of tickets sold at this theater: ");
						int ticketsSold = keyboard.nextInt();
						movieObject.setSoldTickets(ticketsSold);
						keyboard.nextLine();
						
						System.out.println(movieObject.toString());
				
						System.out.println("Do you want to enter another movie? (yes or no)");
						continueMovie = keyboard.nextLine();
					}
				while (continueMovie.equalsIgnoreCase("yes"));
			
			System.out.println("\nbye");
			
			
			
			
			
			
			
			
			
			
			
			
			
			}	

		
		
		
		
		
		
		
		
	}
