package slidingWindow;

/*
 * Minimum Size Subarray Sum
Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray whose sum is greater than or equal to target. 
If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1,1,1,1};
		int target = 11;
		int result = minSubArrayLen(target, nums);
		System.out.println(result);
	}

	public static int minSubArrayLen(int target, int[] nums) {
        int min = 0;
        int l = 0;
        int sum = 0;
        
        for (int r=0; r<nums.length; r++) {
        	sum += nums[r];
        	
        	while (sum >= target) {
        		min = (min > 0) ? Math.min(min, (r-l+1)) : (r-l+1);
        		sum -= nums[l];
        		l++;
        	}
        }
        
        return min;
    }
}
