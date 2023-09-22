/*
 * Video Poker
 *
 * In this assignment, you will implement a simulation of a 
 * popular casino game usually called video poker. 
 * The card deck contains 52 cards, 13 of each suit. At the beginning 
 * of the game, the deck is shuffled. You need to devise a fair method for shuffling. 
 * (It does not have to be efficient.) The player pays a token for each game. 
 * Then the top five cards of the deck are presented to the player. 
 * The player can reject none, some, or all of the cards. 
 * The rejected cards are replaced from the top of the deck. Now the hand is scored.
 * 
 * @author S26600478
 * @date 9/21/2023
 * 
 */

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Deck deck = new Deck();
		Scanner scan = new Scanner(System.in);
		int tokens = 1;
		boolean run = false;
		boolean intro = true;
		
		deck.createDeck();
		deck.shuffleDeck();
		
		while (intro) {
			System.out.println("Would you like to play Video Poker? It costs 1 token. y/n");
			System.out.println("Amount of tokens: " + tokens);
			System.out.println("If you need to know how to play, type 'help'");
			String input = scan.next();
			
			if (input.equalsIgnoreCase("y")) {
				if (tokens >= 1) {
					tokens--;
					run = true;
					intro = false;
					break;
				}
				else
					System.out.println("You don't have enough tokens to play!");
				System.exit(0);
			}
			else if (input.equalsIgnoreCase("n")) {
				System.out.println("You have decided not to play.");
				System.exit(0);
			}
			else if (input.equalsIgnoreCase("help")) {
				System.out.println("The card deck contains 52 cards, 13 of each suit. At the beginning of the game, the deck is shuffled. \nThe player pays a token for each game. Then the top five cards of the deck are presented to the player. \nThe player can reject none, some, or all of the cards. The rejected cards are replaced from \nthe top of the deck. Now the hand is scored.\n");
				System.out.println("Scoring: ");
				System.out.println("No pair – The lowest hand, containing 5 separate cards that do not match up to create any of the hands below.\r\n"
						+ "\r\n"
						+ "One pair – Two cards of the same value, for example 2 queens. Payout: 1\r\n"
						+ "\r\n"
						+ "Two pairs – Two pairs, for example two queens and two fives. Payout: 2\r\n"
						+ "\r\n"
						+ "Three of a kind – Three cards of the same value, for example three queens. Payout: 3\r\n"
						+ "\r\n"
						+ "Straight – Five cards with consecutive values, not necessarily of the same suit, such as 4, 5, 6, 7, 8. The Ace can either precede a 2 or follow a King. Payout: 4\r\n"
						+ "\r\n"
						+ "Flush – Five cards, not necessarily in order, of the same suit. Payout: 5\r\n"
						+ "\r\n"
						+ "Full House – Three of a kind and a pair, for example three queens and two fives. Payout: 6\r\n"
						+ "\r\n"
						+ "Four of a Kind – Four card of the same value, such as four queens. Payout: 25\r\n"
						+ "\r\n"
						+ "Straight Flush – A straight and a flush: five cards with consecutive values of the same suit. Payout: 50\r\n"
						+ "\r\n"
						+ "Royal Flush – The best possible hand in poker. A 10, Jack, Queen, King, and Ace, all of the same suit. Payout: 250\n");
			}
			else
				System.out.println("Invalid input, try again... (y/n)");
		}
		
		
		while (run) {
			System.out.println("Amounf of tokens: " + tokens);
			int a;
			int b;
			int c;
			int d;
			int e;
			deck.draw();
			System.out.println("Top five cards: ");
			deck.printHand();
			while (true) {
				System.out.println("What cards would you like to re-draw? if none type 'none'");
				System.out.print("Please enter in this format: #,#,#,#,#\n");
				String input = scan.next();
				if (input.equalsIgnoreCase("none")) {
					System.out.println("No cards were re-drawn.");
					break;
				}
				try {
					switch (input.length()) {
					case 1: 
						a = Integer.parseInt(input);
						deck.reDraw(a);
						break;
					case 3:
						a = Integer.parseInt(input.substring(0,1));
						b = Integer.parseInt(input.substring(2));
						deck.reDraw(a, b);
						break;
					case 5:
						a = Integer.parseInt(input.substring(0,1));
						b = Integer.parseInt(input.substring(2,3));
						c = Integer.parseInt(input.substring(4,5));
						deck.reDraw(a, b, c);
						break;
					case 7:
						a = Integer.parseInt(input.substring(0,1));
						b = Integer.parseInt(input.substring(2,3));
						c = Integer.parseInt(input.substring(4,5));
						d = Integer.parseInt(input.substring(6,7));
						deck.reDraw(a, b, c, d);
						break;
					case 9:
						a = Integer.parseInt(input.substring(0,1));
						b = Integer.parseInt(input.substring(2,3));
						c = Integer.parseInt(input.substring(4,5));
						d = Integer.parseInt(input.substring(6,7));
						e = Integer.parseInt(input.substring(8,9));
						deck.reDraw(a, b, c, d, e);
						break;
					}
					break;
				}
				catch (java.lang.NumberFormatException error) {
					System.out.println("Invalid input, please enter a number or 'none'");
				}
			}
			System.out.println("This is your new hand:");
			deck.printHand();
			
			//check scoring logic
			System.out.println("You got a " + deck.scoreHand());
			//return token values
			switch (deck.scoreHand()) {
			case "Royal Flush":
				tokens += 250;
				break;
			case "Straight Flush":
				tokens += 50;
				break;
			case "Four of a Kind":
				tokens += 25;
				break;
			case "Full House":
				tokens += 6;
				break;
			case "Flush":
				tokens += 5;
				break;
			case "Straight":
				tokens += 4;
				break;
			case "Three of a Kind":
				tokens += 3;
				break;
			case "Two Pairs":
				tokens += 2;
				break;
			case "One Pair":
				tokens += 1;
				break;
			case "Nothing":
				break;
			}
			
			System.out.println("Amount of tokens: " + tokens);
			break;
		}
		scan.close();
	}
}
