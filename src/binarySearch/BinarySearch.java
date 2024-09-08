package binarySearch;

/*
 * Binary Search
Given an array of integers nums which is sorted in ascending order, and an integer target, 
write a function to search target in nums. 
If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 */

public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		int target = 2;
		int result = search(nums, target);
		System.out.println(result);
	}

	public static int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		int m = (left + right) / 2;
		
		while (left <= right) {
			if (nums[m] == target) {
				return m;
			} else if (nums[m] < target) {
				left = m + 1;
			} else {
				right = m - 1;
			}
			m = (left + right) / 2;
		}
        
		return -1;
    }
}
