package arraysAndStrings;

/*
 * Find Closest Number To Zero
Given an integer array nums of size n, return the number with the value closest to 0 in nums. 
If there are multiple answers, return the number with the largest value. 

Example
Input: nums = [-4,-2,1,4,8]
Output: 1
Explanation:
The distance from -4 to 0 is |-4| = 4.
The distance from -2 to 0 is |-2| = 2.
The distance from 1 to 0 is |1| = 1.
The distance from 4 to 0 is |4| = 4.
The distance from 8 to 0 is |8| = 8.
Thus, the closest number to 0 in the array is 1.

Input: nums = [2,-1,1]
Output: 1
Explanation: 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.
 */

public class FindClosestNumberToZero {
	public static void main(String[] args) {
		int[] nums = new int[] {-4, -2, 1, 4, 8};
		
		int result = findClosestNumber(nums);
		
		System.out.println(result);

	}
	
	public static int findClosestNumber(int [] nums) {
		int distance = nums[0];
		
		for (int num: nums) {
            if (Math.abs(distance) > Math.abs(num)) {
                distance = num;
            } else if (Math.abs(distance) == Math.abs(num)) {
                distance = (distance > num) ? distance : num;
            }
		}
		
		return distance;
	}

}
