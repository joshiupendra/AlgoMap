package slidingWindow;

/*
 * Max Consecutive Ones III
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */

public class MaxConsecutiveOnesIII {

	public static void main(String[] args) {
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
		int result = longestOnes(nums, k);
		System.out.println(result);
	}

	public static int longestOnes(int[] nums, int k) {
        int n = nums.length, maxCount = 0, curCount = 0, zCount = 0;
        int l = 0;
        
        for (int i=0; i<n; i++) {
        	if (nums[i] == 0) {
        		zCount += 1;
        	}
        	
        	while (zCount > k) {
        		if (nums[l] == 0) {
        			zCount -= 1;
        		}
        		l += 1;
        	}
        	
        	curCount = i - l + 1;
        	maxCount = Math.max(maxCount, curCount);
        }
        
        return maxCount;
    }
}
