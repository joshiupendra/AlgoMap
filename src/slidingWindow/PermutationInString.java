package slidingWindow;

import java.util.Arrays;

/*
 * Permutation in String
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 */

public class PermutationInString {

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidboaoo";
		boolean result = checkInclusion(s1, s2);
		System.out.println(result);
	}

	public static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        if (n1 > n2) {
        	return false;
        }
        
        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];
        
        for (int i=0; i<n1; i++) {
        	s1Counts[s1.charAt(i) - 97] += 1;
        	s2Counts[s2.charAt(i) - 97] += 1;
        }
        
        if (Arrays.equals(s1Counts, s2Counts)) {
        	return true;
        }
        
        for (int i=n1; i<n2; i++) {
        	s2Counts[s2.charAt(i) - 97] += 1;
        	s2Counts[s2.charAt(i-n1) - 'a'] -= 1;
        	if (Arrays.equals(s1Counts, s2Counts)) {
            	return true;
            }
        }
        
        return false;
    }
}
