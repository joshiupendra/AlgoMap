package slidingWindow;

/*
 * Maximum Average Subarray I
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. 
Any answer with a calculation error less than 10-5 will be accepted.

Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:
Input: nums = [5], k = 1
Output: 5.00000
 */

public class MaximumAverageSubarrayI {

	public static void main(String[] args) {
		int[] nums = {5};
		int k = 1;
		double avg = findMaxAverage(nums, k);
		System.out.println(avg);
	}

	public static double findMaxAverage(int[] nums, int k) {
		int n = nums.length, curSum = 0;
		
        for (int i=0; i<k; i++) {
        	curSum += nums[i];
        }
        
        double maxAvg = curSum * 1.0 / k;
        
        for (int i=k; i<n; i++) {
        	curSum += nums[i];
        	curSum -= nums[i - k];
        	
        	double avg = curSum * 1.0 / k;
        	maxAvg = Math.max(maxAvg, avg);
        }
        
        return maxAvg;
    }
}
