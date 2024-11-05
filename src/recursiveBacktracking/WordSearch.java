package recursiveBacktracking;

/*
 * Word Search
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 */

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { { 'a' } };
		String word = "a";
		boolean result = exist(board, word);
		System.out.println(result);
	}

	static int m;
	static int n;
	static int w;

	public static boolean exist(char[][] board, String word) {
		m = board.length;
		n = board[0].length;
		w = word.length();
		
		if (m == 1 && n == 1 && w == 1) {
			return board[0][0] == word.charAt(0);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (backtrack(i, j, 0, board, word)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean backtrack(int i, int j, int index, char[][] board, String word) {
		if (index == w) {
			return true;
		}

		if (board[i][j] != word.charAt(index)) {
			return false;
		}

		char temp = board[i][j];
		board[i][j] = '#';

		// 0,1
		int r = i + 0;
		int c = j + 1;
		if (r >= 0 && r < m && c >= 0 && c < n) {
			if (backtrack(r, c, index+1, board, word)) {
				return true;
			}
		}

		// 1,0
		r = i + 1;
		c = j + 0;
		if (r >= 0 && r < m && c >= 0 && c < n) {
			if (backtrack(r, c, index+1, board, word)) {
				return true;
			}
		}

		// 0,-1
		r = i + 0;
		c = j - 1;
		if (r >= 0 && r < m && c >= 0 && c < n) {
			if (backtrack(r, c, index+1, board, word)) {
				return true;
			}
		}

		// -1,0
		r = i - 1;
		c = j + 0;
		if (r >= 0 && r < m && c >= 0 && c < n) {
			if (backtrack(r, c, index+1, board, word)) {
				return true;
			}
		}
		board[i][j] = temp;

		return false;
	}
}
