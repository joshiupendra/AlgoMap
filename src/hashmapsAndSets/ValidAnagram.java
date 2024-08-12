package hashmapsAndSets;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
 */

public class ValidAnagram {

	public static void main(String[] args) {
		String s = "rat";
		String t = "car";
		boolean result = isAnagram(s, t);
		System.out.println(result);
	}
	
	//Using Arrays
	public static boolean isAnagram(String s, String t) {
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		
		Arrays.sort(sArr);
		Arrays.sort(tArr);
		
		return Arrays.equals(sArr, tArr);
	}

	// Using HashMap
	public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
        	return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Add chars from s into map with their counter
        for (char c: s.toCharArray()) {
        	if (map.containsKey(c)) {
        		map.put(c, map.get(c) + 1);
        	} else {
        		map.put(c, 1);
        	}
        }
        
        // Check for each char of t if it is present in map or not
        for (char c: t.toCharArray()) {
        	if (map.containsKey(c) && map.get(c) > 0) {
        		map.put(c, map.get(c) - 1);
        	} else {
        		return false;
        	}
        }
		
		return true;
    }
}
