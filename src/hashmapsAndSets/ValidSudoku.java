package hashmapsAndSets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * Valid Sudoku
Determine if a 9 x 9 Sudoku board is valid. 
Only the filled cells need to be validated according to the following rules:
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:
Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
 */

public class ValidSudoku {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         char[][] arr = new char[9][9];
         for(int i_arr = 0; i_arr < 9; i_arr++)
         {
         	String[] arr_arr = br.readLine().split(" ");
         	for(int j_arr = 0; j_arr < arr_arr.length; j_arr++)
         	{
         		arr[i_arr][j_arr] = arr_arr[j_arr].charAt(0);
         	}
         }

         boolean out_ = isValidSudoku(arr);
         System.out.println(out_);

         wr.close();
         br.close();
	}

	public static boolean isValidSudoku(char[][] board) {
		int[][] row = new int[9][9];
	    int[][] col = new int[9][9];
	    int[][] box = new int[9][9];
	
	    for (int i=0; i<9; i++) {
	        for (int j=0; j<9; j++) {
	            if (board[i][j] != '.') {
	                int value = (board[i][j] == '.') ? -1 : Character.getNumericValue(board[i][j]) - 1;
	                int boxNo = 3 * (i/3) + (j/3);
	
	                if (row[i][value] == 1 || col[j][value] == 1 || box[boxNo][value] == 1) {
	                    return false;
	                }
	
	                row[i][value] = 1;
	                col[j][value] = 1;
	                box[boxNo][value] = 1;
	            }
	        }
	    }
	
	    return true;
    }
}
