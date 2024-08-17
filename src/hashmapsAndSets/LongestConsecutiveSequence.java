package hashmapsAndSets;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Longest Consecutive Sequence
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 */

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] nums = {0};
		int result = longestConsecutive(nums);
		System.out.println(result);
	}

	public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
		HashMap<Integer, Integer> map = new HashMap<>();
		int longest = 0;
        
		for (int num: nums) {
			if (map.containsKey(num - 1)) {
				map.put(num, map.get(num-1) + 1);
				longest = (map.get(num) > longest)? map.get(num) : longest;
			} else {
				map.put(num, 1);
				longest = (longest == 0)? 1 : longest;
			}
		}
		
		return longest;
    }
}
