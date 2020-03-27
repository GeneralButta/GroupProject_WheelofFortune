package Wheel_Of_Fortune;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class GameDriver {
	

	public static void main(String[] args) throws FileNotFoundException {
		Link_list linklist = new Link_list();
		Link_list puzzlelist = new Link_list();
		puzzle Puzzle = new puzzle();
		Link_list playerlist = new Link_list();
		Random rand = new Random();
		int number = rand.nextInt(25);
		int number2 = rand.nextInt(43);
		Scanner input1 = new Scanner(System.in);
		Scanner sysinCard = new Scanner(new File("Cards.txt"));
		Scanner keyboardInput = new Scanner(System.in);
		Scanner vowelinput = new Scanner(System.in);
		String name = " ";
		String wheelspinkey = " ";
		int currentplayernum = 1;
		int currentwheelposition = number;
		float amount = 0;
	    float vowelcost=250;
		Scanner optioninput=new Scanner(System.in);
		Scanner choiceinput= new Scanner(System.in);
		int option;
		String choice;
		
		System.out.println("------------------------------------------------------------------");

		System.out.println("WELCOME TO THE WHEEL OF FORTUNE GAME SHOW!!!\t\t\t");

		System.out.println("1. Play");
		System.out.println("2. Instructions");

		System.out.println("Enter your choice or 0 to exit\n");

		System.out.println("--------------------------------------------------------------------");
		
		
		
		option=optioninput.nextInt();
		
		while(option!=0)
		
		{
			
			if(option==1)
			{
		
		

		while (sysinCard.hasNext()) {
			String type = sysinCard.next();
			float values = sysinCard.nextFloat();
			Cards cards = new Cards(type, values);
			linklist.addToTail(cards);
		}
		Scanner sysinPuzzle = new Scanner(new File("Puzzle.txt"));
		while (sysinPuzzle.hasNext()) {
			String category = sysinPuzzle.next();
			String word = sysinPuzzle.next();
			puzzle puzzle = new puzzle(category, word);
			puzzlelist.addPuzzleToFront(puzzle);
		}
		for (int i = 1; i <= 3; i++) {
			System.out.println("Enter Name Of Player:");
			name = keyboardInput.next();

			playerlist.addPlayer(new Player(name, (float) 0.0, i, (float) 0.0, 0));

		}
		System.out.println("The players for tonights gameshow and please welcome them!!!:\n");
		for (int i = 1; i <= 3; i++) {
			System.out.println(playerlist.GetNode(i).getPlayerData().getName());
		}
		System.out.println("Your turn player:" + playerlist.GetNode(currentplayernum).getPlayerData().getName());

		Node roundPuzzle = puzzlelist.GetNode(number2); /* used to select puzzle */
		String category = roundPuzzle.getPuzzleData().getCategory(); /* store the category in a variable */
		String getPuzzlephrase = roundPuzzle.getPuzzleData().getPuzzlephrase().replaceAll("_",
				" ");/* store the puzzle in a variable */
//System.out.println("REMEMBER TO REMOVE ANSWER : "+getPuzzlephrase);
		String guesses = " ";

		try (Scanner in = new Scanner(System.in)) {
			boolean Solved = false;

			while (true) {
				Solved = true;
				System.out.println("Category: " + category + "\n\n");
				for (char guessedLetter : getPuzzlephrase.toCharArray()) {
					if (guesses.indexOf(guessedLetter) == -1) {
						System.out.print(" _ ");
						Solved = false;
					} else {
						System.out.print(guessedLetter);
					}
				}

				if (Solved) {
					break;
				}

				System.out.println("What do you want to do player?\n");
				System.out.println("Y/y- Spin the wheel\n");
				System.out.println("N/n- Continue to solve puzzle\n");
				System.out.println("B(uy)- Buy a vowel,cost:$250 \n");

				// ---------------------------------This block of code only executes based on
				// the user input that is based on the options from the menu------------------//
				wheelspinkey = input1.nextLine();
				if (wheelspinkey.equals("Y") || wheelspinkey.equals("y")) // if the key entered is Y then the wheel is
																			// spun and the card type is shown//
				{
					currentwheelposition++;// increments the wheel position so as to continually get a random position//
					Node Card = linklist.GetNode(currentwheelposition); /* used to select card */

					if (Card.getCardData().getType().equals("LOOSE_A_TURN")) // if it is that the card type stored in
																				// the Node instance of Card the block
																				// of code is executed below//
					{
						System.out.println("YOU LOSE A TURN!"); // message shown in the console that the user lost a
																// turn//
						currentplayernum++;// the currentplayernum is incremented to the next player//
						Node player = playerlist.GetNode(currentplayernum);// this gets the next player node so they can
																			// get a turn//

						System.out.println("Your turn  now player\t" + player.getPlayerData().getName());// shows the
																											// current
																											// player's
																											// name//

					}

					else if (Card.getCardData().getType().equals("BANKRUPT")) {
						System.out.println("BANKRUPT!");
						Node player = playerlist.GetNode(currentplayernum);
						player.getPlayerData().setRound_total(amount*0);
						System.out.println("You now have $" +player.getPlayerData().getRound_total());
						currentplayernum++;
						System.out.println("The last player went bankrupt,your turn player "
								+ playerlist.GetNode(currentplayernum).getPlayerData().getName());
					} else if (Card.getCardData().getType().equals("MONEY")) {
						System.out.println("MONEY\n");
						System.out.println("You received $ " + Card.getCardData().getValue() + "\tplayer\t" + playerlist
								.GetNode(currentplayernum).getPlayerData().getName());/* print the values of the card */
						amount = Card.getCardData().getValue() + amount;
						playerlist.GetNode(currentplayernum).getPlayerData().setRound_total(amount);

					}

				}

				if (wheelspinkey.equals("N") || wheelspinkey.equals("n")) {

					System.out.print("Enter a letter:\n "); // allows the user to enter a letter to guess the hidden
															// phrase//
					String letter = in.next().toUpperCase();

					

					if(letter.contains("A") || letter.contains("a") || letter.contains("I") || letter.contains("i")
							|| letter.contains("U") || letter.contains("u") || letter.contains("O") || letter.contains("o")
							|| letter.contains("E") || letter.contains("e")) 
					{
						System.out.println("You need to buy a vowel");
						
					}
					else
						guesses += letter;
					
					
					if (!getPuzzlephrase.contains(letter)) {
						currentplayernum++;
//					
						Node player = playerlist.GetNode(currentplayernum);
						System.out.println("Your turn player:" + player.getPlayerData().getName());

					}

				}
				if (wheelspinkey.equals("B") || wheelspinkey.equals("b")) {
					System.out.println("Select a vowel to buy player: A,E,I,O,U\n");
					 String vowel = vowelinput.next().toUpperCase();
					 
					if (playerlist.GetNode(currentplayernum).getPlayerData().getRound_total() == 0
							|| playerlist.GetNode(currentplayernum).getPlayerData().getRound_total() < 250) {
						System.out.println("You dont have enough money to buy a vowel\n");
						
					}

					else if (vowel.contains("A") || vowel.contains("a") || vowel.contains("I") || vowel.contains("i")
							|| vowel.contains("U") || vowel.contains("u") || vowel.contains("O") || vowel.contains("o")
							|| vowel.contains("E") || vowel.contains("e")) 
					{
									guesses+=vowel;
									playerlist.GetNode(currentplayernum).getPlayerData().setRound_total(amount-vowelcost);
					}
					
					
					 if(!getPuzzlephrase.contains(vowel))
					{
						 playerlist.GetNode(currentplayernum).getPlayerData().setRound_total(amount-vowelcost);
						currentplayernum++;
						Node player = playerlist.GetNode(currentplayernum);
						System.out.println("Your turn player:" + player.getPlayerData().getName());
					}

				}

			}
			
			System.out.println("\n End Of the Round!");

			System.out.println("Round total for player 1:" + playerlist.GetNode(1).getPlayerData().getName() + "is: "
					+ playerlist.GetNode(1).getPlayerData().getRound_total());
			System.out.println("Round total for player 2:" + playerlist.GetNode(2).getPlayerData().getName() + "is: "
					+ playerlist.GetNode(2).getPlayerData().getRound_total());
			System.out.println("Round total for player 3: " + playerlist.GetNode(3).getPlayerData().getName() + "is: "
					+ playerlist.GetNode(3).getPlayerData().getRound_total());
			
			
			//compares the round total of the players, if one is higher than the rest then the relevant message will be displayed to the screen
			//indicating to the user the winner of that round//
			if(playerlist.GetNode(1).getPlayerData().getRound_total()>playerlist.GetNode(2).getPlayerData().getRound_total()&&(playerlist.GetNode(1).getPlayerData().getRound_total()>(playerlist.GetNode(3).getPlayerData().getRound_total())))
			
			{
						System.out.println("This round's winner is:\t"+playerlist.GetNode(1).getPlayerData().getName()+"\twith a winning of:\t"+playerlist.GetNode(1).getPlayerData().getRound_total());
					}
			
			else if(playerlist.GetNode(2).getPlayerData().getRound_total()>playerlist.GetNode(1).getPlayerData().getRound_total()&&(playerlist.GetNode(2).getPlayerData().getRound_total()>(playerlist.GetNode(3).getPlayerData().getRound_total())))
			{
				System.out.println("This round's winner is:\t"+playerlist.GetNode(2).getPlayerData().getName()+"\twith a winning of:\t"+playerlist.GetNode(2).getPlayerData().getRound_total());
			}
			
			else if(playerlist.GetNode(3).getPlayerData().getRound_total()>playerlist.GetNode(1).getPlayerData().getRound_total()&&(playerlist.GetNode(3).getPlayerData().getRound_total()>(playerlist.GetNode(2).getPlayerData().getRound_total())))
			{
				System.out.println("This round's winner is:\t"+playerlist.GetNode(3).getPlayerData().getName()+"\twith a winning of:\t"+playerlist.GetNode(3).getPlayerData().getRound_total());
			}
			
			
		}

	}
			if(option==2)
			{
				System.out.println("Instructions\n");
				
				System.out.println("Do you want to go back to the menu? press b if you want to go back to the menu or press t to terminate program\n");
				 choice=choiceinput.next();
				 
				 if(choice.contains("B")||choice.contains("b"))
				 {
					 System.out.println("------------------------------------------------------------------");

						System.out.println("WELCOME TO THE WHEEL OF FORTUNE GAME SHOW!!!\t\t\t");

						System.out.println("1. Play");
						System.out.println("2. Instructions");
						System.out.println("3. Exit");

						System.out.println("Enter your choice\n or 0 to exit");

						System.out.println("--------------------------------------------------------------------");
						
						
						
						option=optioninput.nextInt();
				 }
				 else if(choice.contains("T")||choice.contains("t"))
				 {
					System.exit(0);
				 }
			}
			
			else
				System.exit(0);
		}
	}
}