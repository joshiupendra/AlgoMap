package arraysAndStrings;

/*
 * Product of Array Except Self
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] nums = {-1,1,0,-3,3};
		int[] result = productExceptSelf(nums);
		
		for (int num: result) {
			System.out.print(num + " ");
		}
	}
	
	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
        int lMulti = 1, rMulti = 1;
        int[] lArr = new int[n];
        int[] rArr = new int[n];
        
        for (int i=0; i<n; i++) {
        	int j = n - i - 1;
        	lArr[i] = lMulti;
        	lMulti *= nums[i];
        	rArr[j] = rMulti;
        	rMulti *= nums[j];
        }
        
        for (int i=0; i<n; i++) {
        	result[i] = lArr[i] * rArr[i];
        }
        
        return result;
    }
}
