package recursiveBacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]
 */

public class LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		String digits = "23";
		List<String> res = letterCombinations(digits);
		System.out.println(res);
	}
	
	static Map<String, String> map = new HashMap<>();
	static List<String> result = new ArrayList<>();
	static List<String> sol = new ArrayList<>();
	static int n;

	public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
        	return result;
        }
        
        n = digits.length();
        
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        
        backtrack(0, digits);
        
        return result;
    }
	
	public static void backtrack(int i, String digits) {
		if (i == n) {
			result.add(String.join("", sol));
			return;
		}
		
		String str = map.get(String.valueOf(digits.charAt(i)));
		
		for (int j=0; j<str.length(); j++) {
			sol.add(String.valueOf(str.charAt(j)));
			backtrack(i + 1, digits);
			sol.remove(sol.size() - 1);
		}
	}
}
