package hashmapsAndSets;

import java.util.HashMap;

/*
 * Maximum Number of Balloons
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
You can use each character in text at most once. Return the maximum number of instances that can be formed.

Example 1:
Input: text = "nlaebolko"
Output: 1

Example 2:
Input: text = "loonbalxballpoon"
Output: 2

Example 3:
Input: text = "leetcode"
Output: 0
 */

public class MaximumNumberOfBalloons {

	public static void main(String[] args) {
		String text = "leetcode";
		int result = maxNumberOfBalloons(text);
		System.out.println(result);
	}

	public static int maxNumberOfBalloons(String text) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c: text.toCharArray()) {
        	if (map.containsKey(c)) {
        		map.put(c, map.get(c) + 1);
        	} else {
        		map.put(c, 1);
        	}
        }
        
        boolean flag = map.containsKey('b') && map.containsKey('a') && map.containsKey('l') && map.containsKey('o') && map.containsKey('n') &&
        		map.get('b') > 0 && map.get('a') > 0 && map.get('l') > 1 && map.get('o') > 1 && map.get('n') > 0;
        
        while (flag) {
        	map.put('b', map.get('b') - 1);
        	map.put('a', map.get('a') - 1);
        	map.put('l', map.get('l') - 2);
        	map.put('o', map.get('o') - 2);
        	map.put('n', map.get('n') - 1);
        	result++;
        	flag = map.get('b') > 0 && map.get('a') > 0 && map.get('l') > 1 && map.get('o') > 1 && map.get('n') > 0;
        }
        
        return result;
    }
}
