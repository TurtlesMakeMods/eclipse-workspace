import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
	private String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
	ArrayList<String> cards = new ArrayList<String>();
	ArrayList<String> hand = new ArrayList<String>();

	public Deck() {
		;
	}
	
	public void createDeck() {
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < numbers.length; j++)
				cards.add(numbers[j] + " of " + suits[i]);
		}
	}
	
	public void printDeck() {
		for (int i = 0; i < cards.size(); i++)
			System.out.println(cards.get(i));
	}
	
	public void printHand() {
		for (int i = 0; i < hand.size(); i++) {
			switch(getCardNumber(i)) {
			case "1":
				System.out.println("["+i+"] "+ "Ace of " + getCardSuit(i));
				break;
			case "11":
				System.out.println("["+i+"] "+ "Jack of " + getCardSuit(i));
				break;
			case "12":
				System.out.println("["+i+"] "+ "Queen of " + getCardSuit(i));
				break;
			case "13":
				System.out.println("["+i+"] "+ "King of " + getCardSuit(i));
				break;
			default:
				System.out.println("["+i+"] "+ hand.get(i));
			}
		}
	}
	
	
	public void shuffleDeck() {
		for (int i = 0; i < 250; i++) {
			int num = (int) (Math.random()*51);
			int num2 = (int) (Math.random()*51);
			Collections.swap(cards, num, num2);
		}
	}
	
	public void draw() {
		hand.clear();
		hand.add(cards.get(0));
		hand.add(cards.get(1));
		hand.add(cards.get(2));
		hand.add(cards.get(3));
		hand.add(cards.get(4));
		for (int i = 0; i < 5; i++) {
			String temp = cards.get(0);
			cards.remove(0);
			cards.add(temp);
		}
	}
	
	public void reDraw(int a, int b, int c, int d, int e) {
		String temp = cards.get(0);
		cards.remove(0);
		cards.add(temp);
		hand.remove(e);
		hand.add(temp);
		reDraw(a, b, c, d);
	}
	
	public void reDraw(int a, int b, int c, int d) {
		String temp = cards.get(0);
		cards.remove(0);
		cards.add(temp);
		hand.remove(d);
		hand.add(temp);
		reDraw(a, b, c);
	}
	
	public void reDraw(int a, int b, int c) {
		String temp = cards.get(0);
		cards.remove(0);
		cards.add(temp);
		hand.remove(c);
		hand.add(temp);
		reDraw(a, b);
	}
	
	public void reDraw(int a, int b) {
		String temp = cards.get(0);
		cards.remove(0);
		cards.add(temp);
		hand.remove(b);
		hand.add(temp);
		reDraw(a);
	}
	
	public void reDraw(int a) {
		String temp = cards.get(0);
		cards.remove(0);
		cards.add(temp);
		hand.remove(a);
		hand.add(temp);
	}
	
	public String getCardNumber(int index) {
		return hand.get(index).split(" of ")[0];
	}
	
	public String getCardSuit(int index) {
		return hand.get(index).split(" of ")[1];
	}
	
	public boolean checkConsecutiveCards() {
		int a = Integer.parseInt(getCardNumber(0));
		int b = Integer.parseInt(getCardNumber(1));
		int c = Integer.parseInt(getCardNumber(2));
		int d = Integer.parseInt(getCardNumber(3));
		int e = Integer.parseInt(getCardNumber(4));
		int[] arr = {a, b, c, d, e};
		sort(arr);
		if (arr[0]+1 == arr[1] && arr[1]+1 == arr[2] && arr[2]+1 == arr[3] && arr[3]+1 == arr[4])
			return true;
		else
			return false;
	}
	
	public boolean checkMatchingSuits() {
		if ((getCardSuit(0).equals(getCardSuit(1)))&&(getCardSuit(1).equals(getCardSuit(2)))&&(getCardSuit(2).equals(getCardSuit(3)))&&(getCardSuit(3).equals(getCardSuit(4)))&&(getCardSuit(4).equals(getCardSuit(5))))
			return true;
		else	
			return false;
	}
	
	public String scoreHand() {
		int a = Integer.parseInt(getCardNumber(0));
		int b = Integer.parseInt(getCardNumber(1));
		int c = Integer.parseInt(getCardNumber(2));
		int d = Integer.parseInt(getCardNumber(3));
		int e = Integer.parseInt(getCardNumber(4));
		int[] arr = {a, b, c, d, e};
		sort(arr);
		
		//check royal flush
		if (checkMatchingSuits()) {
			if (checkConsecutiveCards()) {
				if (arr[4] == 13)
					return "Royal Flush";
			}
		}
		
		//check straight flush
		if (checkMatchingSuits()) {
			if (checkConsecutiveCards())
				return "Straight Flush";
		}
		
		//check four of a kind
		if (arr[0]==arr[1] && arr[0]==arr[2] && arr[0]==arr[3])
			return "Four of a kind";
		if (arr[1]==arr[2] && arr[1]==arr[3] && arr[1]==arr[4] )
			return "Four of a Kind";
		
		//check full house
		if (arr[0] == arr[1] && arr[0] == arr[2]) {
			if (arr[3]==arr[4])
				return "Full House";
		}
		if (arr[2] == arr[3] && arr[2] == arr[4]) {
			if (arr[0]==arr[1])
				return "Full House";
		}
		
		//check straight
		if (checkConsecutiveCards()) {
			return "Straight";
		}
		
		//check flush
		if (checkMatchingSuits()) {
			return "Flush";
		}
		
		//check three of a kind
		if (arr[0] == arr[1] && arr[0] == arr[2])
			return "Three of a Kind";
		if (arr[1] == arr[2] && arr[1] == arr[3])
			return "Three of a Kind";
		if (arr[2] == arr[3] && arr[2] == arr[4])
			return "Three of a Kind";
		
		//check	two pair
		if (arr[0] == arr[1] && arr[2] == arr[3])
			return "Two Pairs";
		if (arr[0] == arr[1] && arr[3] == arr[4])
			return "Two Pairs";
		if (arr[1] == arr[2] && arr[3] == arr[4])
			return "Two Pairs";
		
		//one pair
		if (arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[3] || arr[3] == arr[4])
			return "One Pair";
		
		return "Nothing";
	}
	
	 public void sort(int[] arr) {
		 boolean swapped = true;
	     while (swapped) {
	    	 swapped = false;
	         for (int i = 0; i < arr.length - 1; i++) {
	        	 if (arr[i] > arr[i + 1]) {
	        		 int temp = arr[i];
	                 arr[i] = arr[i + 1];
	                 arr[i + 1] = temp;
	                 swapped = true;
	             }
	         }
	     }
	 }
}
