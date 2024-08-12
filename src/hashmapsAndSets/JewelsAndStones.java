package hashmapsAndSets;

import java.util.HashSet;

/*
 * Jewels and Stones
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. 
Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Example 2:
Input: jewels = "z", stones = "ZZ"
Output: 0
 */

public class JewelsAndStones {

	public static void main(String[] args) {
		String jewels = "z";
		String stones = "ZZ";
		int result = numJewelsInStones(jewels, stones);
		System.out.println(result);
	}

	public static int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        
        // Add all jewels in HashSet
        for (int i=0; i<jewels.length(); i++) {
        	set.add(jewels.charAt(i));
        }
        
        // Check if each character in stones present in jewels set or not
        for (int i=0; i<stones.length(); i++) {
        	if (set.contains(stones.charAt(i))) {
        		result++;
        	}
        }
        
        return result;
    }
}
