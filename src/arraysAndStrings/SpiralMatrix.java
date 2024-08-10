package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

/*
 * Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> result = spiralOrder(matrix);
		System.out.println(result);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix.length == 0) {
        	return result;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = 0, UP = 1, RIGHT = 2, DOWN = 3, LEFT = 4, DIRECTION = RIGHT;
        int upWall = 0, rightWall = n, downWall = m, leftWall = -1;
        while (result.size() < m*n) {
        	if (DIRECTION == RIGHT) {
        		while (j < rightWall) {
        			result.add(matrix[i][j]);
        			j++;
        		}
        		i++;
        		j--;
        		rightWall--;
        		DIRECTION = DOWN;
        	} else if (DIRECTION == DOWN) {
        		while (i < downWall) {
        			result.add(matrix[i][j]);
        			i++;
        		}
        		i--;
        		j--;
        		downWall--;
        		DIRECTION = LEFT;
        	} else if (DIRECTION == LEFT) {
        		while (j > leftWall) {
        			result.add(matrix[i][j]);
        			j--;
        		}
        		j++;
        		i--;
        		leftWall++;
        		DIRECTION = UP;
        	} else {
        		while (i > upWall) {
        			result.add(matrix[i][j]);
        			i--;
        		}
        		i++;
        		j++;
        		upWall++;
        		DIRECTION = RIGHT;
        	}
        }
        
        return result;
    }
}
