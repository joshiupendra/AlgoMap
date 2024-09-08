package binarySearch;

/*
 * Search Insert Position
Given a sorted array of distinct integers and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
 */

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = {3,5,7,9,10};
		int target = 8;
		int result = searchInsert(nums, target);
		System.out.println(result);
	}

	public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int middle = (left + right) / 2;
		
        while (left <= right) {
        	if (nums[middle] == target) {
        		return middle;
        	}else if (nums[middle] < target) {
        		left = middle + 1;
        	} else {
        		right = middle - 1;
        	}
        	middle = (left + right) / 2;
        }
        
        if (nums[middle] < target) {
        	return middle + 1;
        } else {
        	return middle;
        }
    }
}
