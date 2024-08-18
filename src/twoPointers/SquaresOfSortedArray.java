package twoPointers;

import java.util.Arrays;

/*
 * Squares of a Sorted Array
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 */

public class SquaresOfSortedArray {

	public static void main(String[] args) {
		int[] nums = {-7,-3,2,3,11};
		int[] result = sortedSquares(nums);
		for (int num: result) {
			System.out.print(num + " ");
		}

	}
	
	public static int[] sortedSquares(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		int start = 0, end = n - 1;
		
		for (int i=n-1; i>=0; i--) {
			if (Math.abs(nums[start]) >= Math.abs(nums[end])) {
				result[i] = nums[start] * nums[start];
				start++;
			} else {
				result[i] = nums[end] * nums[end];
				end--;
			}
		}
		
		return result;
	}
}
