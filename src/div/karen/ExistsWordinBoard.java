package div.karen;
import java.util.Random;

/* Author: Karen 2017.3.13
 * Description : Q4. Given a 2D board and a word, find if the word exists in the grid. */
public class ExistsWordinBoard {

	public ExistsWordinBoard() {
	}

	public boolean exist(char[][] board, String word) {
		//check the board and word is available
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}
		if (word.length() == 0) {
			return true;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				//check the board[i][j] if this is match with the first char
				if (board[i][j] == word.charAt(0)) {
					boolean result = dfs(board, word, i, j, 0);
					if (result) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, String word, int i, int j, int k) {
		
		//check the board and word is available
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}
		if (word.length() == 0) {
			return true;
		}
		
		//finish the word check, k = length
		if (word.length() == k) {
			return true;
		}

		boolean result = false;
		if (insideBoard(board, i, j) && board[i][j] == word.charAt(k)) {
			char temp = board[i][j];
			//Make the board[i][j] = #, can not check twice
			board[i][j] = '#';
			//Check the four direction
			result = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
			//Make the board[i][j] = temp, if the result return true
			board[i][j] = temp;
		}
		return result;
	}

	private boolean insideBoard(char[][] board, int i, int j) {
		//Check the board is inside
		return (i >= 0 && i < board.length && j >= 0 && j < board[0].length);
	}

	public static void main(String[] args) {
		ExistsWordinBoard sb = new ExistsWordinBoard();
		String input = "ac";
		
		//cook a 2D board
		int rows = 10;
		int cols = 10;
		char[][] arrayBoard = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			System.out.print("[ ");
			for (int j = 0; j < cols; j++) {
				Random r = new Random();
				char c = (char) (r.nextInt(26) + 'a');
				arrayBoard[i][j] = c;
				System.out.print(arrayBoard[i][j] + " ");
			}
			System.out.println("]");
		}
		
		System.out.println("Input :" +input);
		System.out.println(sb.exist(arrayBoard, input));
	}
}
