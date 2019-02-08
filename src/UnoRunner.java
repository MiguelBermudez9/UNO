import java.util.ArrayList;
import java.util.Scanner;


public class UnoRunner
	{
		static Cards topCard;
		static Cards playerCard;
		static Cards computerCard;
		static ArrayList<Cards> playerDeck = new ArrayList<Cards>();
		static ArrayList<Cards> computerDeck = new ArrayList<Cards>();
		public static void main(String[] args)
			{
				
				Deck.fillDeck();
				//printDeck();
				dealPlayerCards();
				dealComputerCards();
				displayPlayerCards();
				displayComputerCards();
				flipCard();
				while (playerDeck.size()>0 || computerDeck.size()>0)
					{
						Deck.fillDeck();
						playCard();
						playCompCard();
					}
				
				
				
				
				
		

			}
		public static void printDeck()
			{
					
		
			for (int i = 0; i< Deck.deck.size(); i ++)
				{
				System.out.println(Deck.deck.get(i).getColor() + " " + Deck.deck.get(i).getNumber());
								
				}
			System.out.println();
			}
		public static void dealPlayerCards()
		{
				{
					for (int i = 0; i < 7; i++)
						{
							playerDeck.add(Deck.deck.get(0));
							Deck.deck.remove(0);
						}
				
				}
		}
		public static void dealComputerCards()
		{
			
				{
					for (int i = 0; i < 7; i++)
						{
							computerDeck.add(Deck.deck.get(0));
							Deck.deck.remove(0);
						
						}
					
				}
		}
		public static void displayPlayerCards()
		{
			System.out.println("Your cards are: ");
		int menuNumber = 1;
		for (Cards c : playerDeck)
			{
				System.out.println(menuNumber + " " + c.getColor() + " " + c.getNumber());
				menuNumber++;
			}
		System.out.println("");
		}
		public static void displayComputerCards()
			{
				System.out.println("Your oponent's cards are: ");
				int menuNumber =1;
				for (Cards c : computerDeck)
					{
						System.out.println(menuNumber + " " + c.getColor() + " " + c.getNumber());
						menuNumber ++;
					}
			}
		public static void flipCard()
		{
			Scanner userInput = new Scanner(System.in);
			System.out.println("Press enter to reveal the first Card.");
			String a = userInput.nextLine();
			topCard = (Deck.deck.get(0));
			System.out.println(topCard.getColor() + " " + topCard.getNumber());
			Deck.deck.remove(0);
			}
		public static void playCard()
		{
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter corresponding number to play your card.");
			int number = userInput.nextInt();
			playerCard = (playerDeck.get(number-1));
			System.out.println("You played a " + playerCard.getColor() + " " + playerCard.getNumber());
			if (playerCard.getNumber() == topCard.getNumber() || playerCard.getColor().equals(topCard.getColor()))
						{
							topCard = (playerCard);
							System.out.println("Valid turn.");
							System.out.println("Top card is now" + "  " + topCard.getColor()+ " " + topCard.getNumber());
							playerDeck.remove(playerCard);
							displayComputerCards();
						}
			else
				{
					System.out.println("Top card is still" + "  " + topCard.getColor()+ " " + topCard.getNumber());
					System.out.println("Invalid card. Draw One");
					playerDeck.add(Deck.deck.get(0));
					displayComputerCards();
				}
			System.out.println(" ");
		}
		public static void playCompCard()
		{
			
			for (int i = 0; i<computerDeck.size(); i++)
				{
					computerCard = (computerDeck.get(i));
					if (computerCard.getNumber() == topCard.getNumber() || computerCard.getColor().equals(topCard.getColor()))
								{
									topCard = (computerCard);
									System.out.println("The computer played a " + computerCard.getColor() + " " + computerCard.getNumber());
									System.out.println("valid card");
									System.out.println("Top card is now a" + " " + topCard.getColor()+ " " + topCard.getNumber());
									computerDeck.remove(computerCard);
									displayPlayerCards();
								break;
									
								}
					else
						{
							System.out.println("The computer played a " + computerCard.getColor() + " " + computerCard.getNumber());
							System.out.println("Top card is still" + "  " + topCard.getColor()+ " " + topCard.getNumber());
							System.out.println("Invalid Card. Draw one.");
							computerDeck.add(Deck.deck.get(0));
							displayPlayerCards();
							break;
						}
					
				}
			System.out.println(" ");
			
		}
		

	}

