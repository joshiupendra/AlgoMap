package graphs;

/*
 * Number of Islands
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */

public class NumberOfIslands {

	public static void main(String[] args) {
		char[][] grid = {{'1','1','0','0','0'},
						{'1','1','0','0','0'},
						{'0','0','1','0','0'},
						{'0','0','0','1','1'}};
		int result = numIslands(grid);
		System.out.println(result);
	}
	
	static int m;
	static int n;

	public static int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        int islands = 0;
        
        for (int i=0; i<m; i++) {
        	for (int j=0; j<n; j++) {
        		if (grid[i][j] == '1') {
        			islands += 1;
        			dfs(i, j, grid);
        		}
        	}
        }
        
		return islands;
    }
	
	public static void dfs(int i, int j, char[][] grid) {
		if (i<0 || i>=m || j<0 || j>=n || grid[i][j] != '1') {
			return;
		} else {
			grid[i][j] = '0';
			dfs(i, j+1, grid);
			dfs(i+1, j, grid);
			dfs(i, j-1, grid);
			dfs(i-1, j, grid);
		}
	}
}
