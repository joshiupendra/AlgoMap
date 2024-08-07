package arraysAndStrings;

import java.util.HashMap;

/*
 * Roman To Integer
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger {

	public static void main(String[] args) {
		String input = "MCMXCIV";
		
		int result = romanToInt(input);
		System.out.println(result);
	}
	
	public static int romanToInt(String s) {
        int result = 0;
        int[] arr = new int[s.length()];
        
        for (int i=0; i<s.length(); i++) {
        	switch(s.charAt(i)) {
        		case 'I':
        			arr[i] = 1;
        			break;
        		case 'V':
        			arr[i] = 5;
        			break;
        		case 'X':
        			arr[i] = 10;
        			break;
        		case 'L':
        			arr[i] = 50;
        			break;
        		case 'C':
        			arr[i] = 100;
        			break;
        		case 'D':
        			arr[i] = 500;
        			break;
        		default:
        			arr[i] = 1000;
        			break;
        	}
        }
        
        int m = 0;
        while (m < s.length() - 1) {
        	if (arr[m] < arr[m+1]) {
        		result -= arr[m];
        	} else {
        		result += arr[m];
        	}
        	m++;
        }
        result += arr[m];
        
        return result;
    }
}
