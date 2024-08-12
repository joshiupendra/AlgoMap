package hashmapsAndSets;

import java.util.HashMap;

/*
 * Ransom Note
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true
 */

public class RansomNote {

	public static void main(String[] args) {
		String ransomNote = "aa";
		String magazine = "aab";
		boolean result = canConstruct(ransomNote, magazine);
		System.out.println(result);
	}

	// Using Arrays
	public static boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}
		
		int[] alphabetsCounter = new int[26];
		
		for (char c: magazine.toCharArray()) {
			alphabetsCounter[c-'a']++;
		}
		
		for (char c: ransomNote.toCharArray()) {
			if (alphabetsCounter[c-'a'] == 0) {
				return false;
			}
			alphabetsCounter[c-'a']--;
		}
		
		return true;
	}
	
	// Using HashMap
	public static boolean canConstruct1(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<magazine.length(); i++) {
        	if (map.containsKey(magazine.charAt(i))) {
        		map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
        	} else {
        		map.put(magazine.charAt(i), 1);
        	}
        }
        
        for (int i=0; i<ransomNote.length(); i++) {
        	if (map.containsKey(ransomNote.charAt(i)) && map.get(ransomNote.charAt(i)) > 0) {
        		map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
        	} else {
        		return false;
        	}
        }
        
		return true;
    }
}
