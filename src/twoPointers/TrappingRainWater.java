package twoPointers;

/*
 * Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Example 3:
Input: height = [6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3]
Output: 83
 */

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] height = { 6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3 };
		int result = trap(height);
		System.out.println(result);
	}

	public static int trap(int[] height) {
		int result = 0;
		int n = height.length;
		int lWall = 0, rWall = 0;
		int[] maxLeft = new int[n];
		int[] maxRight = new int[n];

		int j = 0;
		for (int i = 0; i < n; i++) {
			j = n - i - 1;
			maxLeft[i] = lWall;
			maxRight[j] = rWall;
			lWall = Math.max(lWall, height[i]);
			rWall = Math.max(rWall, height[j]);
		}

		int[] water = new int[n];
		for (int i = 0; i < n; i++) {
			int potential = Math.min(maxLeft[i], maxRight[i]);
			water[i] = Math.max(0, potential - height[i]);
		}

		for (int w: water) { 
			result += w; 
		}

		return result;
	}
}
