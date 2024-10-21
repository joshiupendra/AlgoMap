package recursiveBacktracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Subsets
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 */

public class Subsets {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> result = subsets(nums);
		System.out.println(result);
	}
	
	static List<List<Integer>> result = new ArrayList<>();
	static List<Integer> sol = new ArrayList<>();
	static int n;
	
	public static List<List<Integer>> subsets(int[] nums) {
		n = nums.length;
		result.clear();
		sol.clear();
		
		backtrack(0, nums);
		
		return result;
    }
	
	public static void backtrack(int i, int[] nums) {
		if (i == n) {
			result.add(sol.stream().toList());
			return;
		}
		
		// Don't pick nums[i]
		backtrack(i+1, nums);
		
		// Pick nums[i]
		sol.add(nums[i]);
		backtrack(i+1, nums);
		sol.remove(sol.size() - 1);
	}
}
