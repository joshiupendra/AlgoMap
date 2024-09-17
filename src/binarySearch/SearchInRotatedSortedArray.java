package binarySearch;

/*
 * Search in Rotated Sorted Array
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) 
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1
 */

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = {3, 1};
		int target = 3;
		int result = search(nums, target);
		System.out.println(result);
	}

	public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        
        while (l < r) {
        	int mid = (l + r) / 2;
        	
        	if (nums[mid] > nums[r]) {
        		l = mid + 1;
        	} else {
        		r = mid;
        	}
        }
        
        int minIndex = l;
        
        if (minIndex == 0) {
        	l = 0;
        	r = nums.length - 1;
        } else if (target >= nums[0] && target <= nums[minIndex - 1]) {
        	l = 0;
        	r = minIndex - 1;
        } else {
        	l = minIndex;
        	r = nums.length - 1;
        }
        
        while (l <= r) {
        	int m = (l + r) / 2;
        	
        	if (nums[m] == target) {
        		return m;
        	} else if (nums[m] < target) {
        		l = m + 1;
        	} else {
        		r = m - 1;
        	}
        }
		
		return -1;
    }
}
