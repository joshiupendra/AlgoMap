package hashmapsAndSets;

import java.util.HashMap;

/*
 * Majority Element
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. 
You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */

public class MajorityElement {

	public static void main(String[] args) {
		int[] nums = {2,2};
		int result = majorityElement(nums);
		System.out.println(result);
	}

	public static int majorityElement(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		
        int majority = (nums.length%2 == 1)? (nums.length / 2 + 1) : (nums.length / 2);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num: nums) {
        	if (map.containsKey(num)) {
        		int count = map.get(num) + 1;
        		if (count >= majority) {
        			return num;
        		}
        		map.put(num, count);
        	} else {
        		map.put(num, 1);
        	}
        }
        
        return 0;
    }
}
