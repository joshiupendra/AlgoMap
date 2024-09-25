package slidingWindow;

import java.util.Arrays;

/*
 * Longest Repeating Character Replacement
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. 
You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 */

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		String s = "AABABBA";
		int k = 1;
		int result = characterReplacement(s, k);
		System.out.println(result);
	}

	public static int characterReplacement(String s, int k) {
        int longest = 0;
        int l = 0;
        int[] counts = new int[26];
        
        for (int r=0; r<s.length(); r++) {
        	counts[s.charAt(r) - 65] += 1;
        	
        	while (((r-l+1) - maxCount(counts)) > k) {
        		counts[s.charAt(r) - 65] -= 1;
        		l += 1;
        	}
        	longest = Math.max(longest, (r-l+1));
        }
        
        
        return longest;
    }
	
	public static int maxCount(int[] counts) {
		int max = 0;
		
		for (int i=0; i<counts.length; i++) {
			max = Math.max(max, counts[i]);
		}
		
		return max;
	}
}
