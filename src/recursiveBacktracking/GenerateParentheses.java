package recursiveBacktracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
 */

public class GenerateParentheses {

	public static void main(String[] args) {
		int n = 3;
		List<String> result = generateParenthesis(n);
		System.out.println(result);
	}

	public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        backtrack(result, n, 0, 0, "");
        
        return result;
    }
	
	public static void backtrack(List<String> result, int n, int open, int close, String str) {
		if (open == close && close == n) {
			result.add(str);
			return;
		}
		
		if (open < n) {
			backtrack(result, n, open+1, close, str+"(");
		} 
		
		if (close < open) {
			backtrack(result, n, open, close+1, str+")");
		}
	}
}
