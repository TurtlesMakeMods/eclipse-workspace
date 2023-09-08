import javax.swing.JOptionPane;

/***************************************************************
 * This program tests the TicTacToe class by prompting the user to set positions
 * on the board and printing out the result.
 ****************************************************************/
public class TicTacToeTest {
	public static void main(String[] args) {
		char player = 'x';
		int turn = 0;
		// X gets the first move

		TicTacToe game = new TicTacToe();
		while (turn <= 9) {
			
			if (game.checkWinner().equals("x")) {
				JOptionPane.showMessageDialog(null, "Player x Wins");
				int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
				if (playAgain == JOptionPane.YES_OPTION) {
					game.newGame();
					turn = 0;
					player = 'x';
				} else
					System.exit(0);
			}

			else if (game.checkWinner().equals("o")) {
				JOptionPane.showMessageDialog(null, "Player o Wins");
				int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
				if (playAgain == JOptionPane.YES_OPTION) {
					game.newGame();
					turn = 0;
					player = 'x';
				} else
					System.exit(0);
			}

			else if (game.checkWinner().equals("draw")) {
				JOptionPane.showMessageDialog(null, "Draw!");
				int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
				if (playAgain == JOptionPane.YES_OPTION) {
					game.newGame();
					turn = 0;
					player = 'x';
				} else
					System.exit(0);
			}

			if (turn == 0)
				JOptionPane.showMessageDialog(null,
						"Welcome to Tic Tac Toe.\nYou will have X and the computer will have O.");

			// calls game.toString( )
			if (player == 'x') {
				while (true) {
					String input = JOptionPane
							.showInputDialog("Position for " + player + " (Cancel to exit)\n" + game.toString());

					if (input == null) // quit the game?
						System.exit(0);
					int position = Integer.parseInt(input);
					if (game.set(position, player))
						break;
					else {
						JOptionPane.showMessageDialog(null, "Position taken");
					}
				}
				// make a move
			} else {
				// Computer's turn
				while (true) {
					int random = (int) (Math.random() * 8) + 1;
					if (game.set(random, player))
						break;
				}

			}

			if (player == 'x') // toggle the player
				player = 'o';
			else
				player = 'x';

			turn++;
		}
	}
}
