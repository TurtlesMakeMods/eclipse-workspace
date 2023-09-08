
/*****************************
A 3 x 3 Tic-Tac-Toe board.
******************************/
public class TicTacToe {
/***************************** 
   Constructs an empty board.
******************************/
public TicTacToe( ) {
newGame();
}

public void newGame() {
	   board = new char[ROWS][COLUMNS];
	   int position = 49;
	   // fill with #s
	   for (int i = 0; i < ROWS; i++)
	      for (int j = 0; j < COLUMNS; j++) {
	         board[i][j] = (char) position;
	         position++;
	      }
	
}

/***********************************************************
   Sets a field in the board. The field must be unoccupied.
   @param i the row index
   @param j the column index
   @param player the player ('x' or 'o')
 * @return 
************************************************************/
public boolean set(int i, char player) {
	int r = 0;
	int c = 0;
			switch (i) {
				case 1:
					r = 0;
					c = 0;
					break;
				case 2: 
					r = 0;
					c = 1;
					break;
				case 3:
					r = 0;
					c = 2;
					break;
				case 4:
					r = 1;
					c = 0;
					break;
				case 5:
					r = 1;
					c = 1;
					break;
				case 6:
					r = 1;
					c = 2;
					break;
				case 7:
					r = 2;
					c = 0;
					break;
				case 8:
					r = 2;
					c = 1;
					break;
				case 9:
					r = 2;
					c = 2;
					break;
			}
			if (board[r][c] == 'x' || board[r][c] == 'o')
				return false;
			else
				board[r][c] = player;
				return true;
}
/********************************************************
   Creates a string representation of the board such as
   |x  o|
   |  x |
   |   o|
   @return the string representation
*********************************************************/
public String toString( ) {
   String r = "";
   for (int i = 0; i < ROWS; i++) {
      r = r + "|";
      for (int j = 0; j < COLUMNS; j++)
         r = r + board[i][j] + "";
      r = r + "|\n";
   }
   return r;
}

public String checkWinner() {
    for (int a = 0; a < 8; a++) {
        String line = "";

        switch (a) {
        case 0:
            line += String.valueOf(board[0][0]) + String.valueOf(board[0][1]) + String.valueOf(board[0][2]);
            break;
        case 1:
            line += String.valueOf(board[1][0]) + String.valueOf(board[1][1]) + String.valueOf(board[1][2]);
            break;
        case 2:
            line += String.valueOf(board[2][0]) + String.valueOf(board[2][1]) + String.valueOf(board[2][2]);
            break;
        case 3:
            line += String.valueOf(board[0][0]) + String.valueOf(board[1][0]) + String.valueOf(board[2][0]);
            break;
        case 4:
            line += String.valueOf(board[0][1]) + String.valueOf(board[1][1]) + String.valueOf(board[2][1]);
            break;
        case 5:
            line += String.valueOf(board[0][2]) + String.valueOf(board[1][2]) + String.valueOf(board[2][2]);
            break;
        case 6:
            line += String.valueOf(board[0][0]) + String.valueOf(board[1][1]) + String.valueOf(board[2][2]);
            break;
        case 7:
            line += String.valueOf(board[0][2]) + String.valueOf(board[1][1]) + String.valueOf(board[2][0]);
            break;
        }
        
        if (line.equals("xxx"))
        	return "x";
        else if (line.equals("ooo"))
        	return "o";
    }
    for (char[] row : board) {
    	for(char c : row) {
    		if(c != 'x' && c != 'o')
    			return "";
    	}
    }
    return "draw";
}
private static char[][] board;
private static final int ROWS = 3;
private static final int COLUMNS = 3;
}


