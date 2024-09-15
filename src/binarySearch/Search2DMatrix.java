package binarySearch;

/*
 * Search a 2D Matrix
You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 */

public class Search2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 13;
		boolean result = searchMatrix(matrix, target);
		System.out.println(result);
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = (m * n) - 1;
		
		while (l <= r) {
			int mid = (l + r) / 2;
			int i = mid / n;
			int j = mid % n;
			
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
        
		return false;
    }
}
