package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 3 Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

Example 4:
Input: nums = [1,2,-2,-1]
Output: []
 */

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = { 1,2,-2,-1 };
		List<List<Integer>> result = threeSum(nums);
		System.out.println(result);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		
		for (int i=0; i<nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				int target = -(nums[i] + nums[j]);
				if (map.containsKey(target) && map.get(target) != i && map.get(target) != j) {
					int[] arr = { nums[i], nums[j], target };
					Arrays.sort(arr);
					String str = "" + arr[0] + arr[1] + arr[2];
					if (!set.contains(str)) {
						list.add(Arrays.asList(arr[0], arr[1], arr[2]));
						set.add(str);
					}
				}
			}
		}

		return list;
	}
}
