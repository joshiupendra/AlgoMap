package recursiveBacktracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Permutations
Given an array nums of distinct integers, return all the possible permutations. 
You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
 */

public class Permutations {

	public static void main(String[] args) {
		int[] nums = {0,1};
		List<List<Integer>> res = permute(nums);
		System.out.println(res);
	}
	
	static List<List<Integer>> result = new ArrayList<>();
	static int n;
	static List<Integer> sol = new ArrayList<>();

	public static List<List<Integer>> permute(int[] nums) {
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
		
		for (int num: nums) {
			if (!sol.contains(num)) {
				sol.add(num);
				backtrack(i+1, nums);
				sol.remove(sol.size() - 1);
			}
		}
	}
}
