package binarySearch;

/*
 * Valid Perfect Square
Given a positive integer num, return true if num is a perfect square or false otherwise.
A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.
You must not use any built-in library function, such as sqrt.

Example 1:
Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.

Example 2:
Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
 */

public class ValidPerfectSquare {

	public static void main(String[] args) {
		int num = 2147483647;
		boolean result = isPerfectSquare(num);
		System.out.println(result);
	}

	public static boolean isPerfectSquare(int num) {
		if (num == 1) {
			return true;
		}
		
        long l = 1, r = num;
        long m;
        
        while (l <= r) {
        	m = (l + r) / 2;
        	long sqr = m * m;
        	
        	if (sqr == num) {
        		return true;
        	} else if (sqr < num) {
        		l = m + 1;
        	} else {
        		r = m - 1;
        	}
        }
		
		return false;
    }
}
