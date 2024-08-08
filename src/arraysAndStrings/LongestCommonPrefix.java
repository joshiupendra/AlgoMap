package arraysAndStrings;

import java.util.Arrays;

/*
 * Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = {"dog","racecar","car"};
		String result = longestCommonPrefix(strs);
		System.out.println(result);
	}
	
	public static String longestCommonPrefix(String[] strs) {
		StringBuilder result = new StringBuilder();
		Arrays.sort(strs);
		String first = strs[0];
		String last = strs[strs.length-1];
		
		for (int i=0; i<Math.min(first.length(), last.length()); i++) {
			if (first.charAt(i) != last.charAt(i)) {
				return result.toString();
			}
			result.append(first.charAt(i));
		}
		
		return result.toString();
    }

}
