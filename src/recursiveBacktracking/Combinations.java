package recursiveBacktracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Combinations
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 */

public class Combinations {

	public static void main(String[] args) {
		List<List<Integer>> res = combine(4, 2);
		System.out.println(res);
	}

	static List<List<Integer>> result = new ArrayList<>();
	static List<Integer> sol = new ArrayList<>();
	
	public static List<List<Integer>> combine(int n, int k) {
		backtrack(n, k);
		return result;
    }
	
	public static void backtrack(int x, int k) {
		if (sol.size() == k) {
			result.add(sol.stream().toList());
			return;
		}
		
		int left = x;
		int stillNeed = k - sol.size();
		
		if (left > stillNeed) {
			backtrack(x-1, k);
		}
		
		sol.add(x);
		backtrack(x-1, k);
		sol.remove(sol.size() - 1);
	}
}
