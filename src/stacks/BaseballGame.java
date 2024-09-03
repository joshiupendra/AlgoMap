package stacks;

import java.util.Iterator;
import java.util.Stack;

/*
 * Baseball Game
You are keeping the scores for a baseball game with strange rules. 
At the beginning of the game, you start with an empty record.
You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
An integer x.
Record a new score of x.
'+'.
Record a new score that is the sum of the previous two scores.
'D'.
Record a new score that is the double of the previous score.
'C'.
Invalidate the previous score, removing it from the record.
Return the sum of all the scores on the record after applying all the operations.
The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.

Example 1:
Input: ops = ["5","2","C","D","+"]
Output: 30
Explanation:
"5" - Add 5 to the record, record is now [5].
"2" - Add 2 to the record, record is now [5, 2].
"C" - Invalidate and remove the previous score, record is now [5].
"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
The total sum is 5 + 10 + 15 = 30.

Example 2:
Input: ops = ["5","-2","4","C","D","9","+","+"]
Output: 27
Explanation:
"5" - Add 5 to the record, record is now [5].
"-2" - Add -2 to the record, record is now [5, -2].
"4" - Add 4 to the record, record is now [5, -2, 4].
"C" - Invalidate and remove the previous score, record is now [5, -2].
"D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
"9" - Add 9 to the record, record is now [5, -2, -4, 9].
"+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
"+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.

Example 3:
Input: ops = ["1","C"]
Output: 0
Explanation:
"1" - Add 1 to the record, record is now [1].
"C" - Invalidate and remove the previous score, record is now [].
Since the record is empty, the total sum is 0.
 */

public class BaseballGame {

	public static void main(String[] args) {
		String[] operations = {"5","2","C","D","+"}; 
		int result = calPoints(operations);
		System.out.println(result);
	}

	public static int calPoints(String[] operations) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (String ch: operations) {
        	if (Character.isLetter(ch.charAt(0))) {
        		// System.out.println("Letter: " + ch);
        		if (ch.equals("C")) {
        			stack.pop();
        		} else if (ch.equals("D")) {
        			int temp = stack.peek() * 2;
        			stack.push(temp);
        		}
        		
        	} else if (ch.equals("+")) {
        		int fEle = stack.pop();
        		int sEle = stack.pop();
        		int temp = fEle + sEle;
        		// System.out.println("+: " + fEle + " " + sEle + " " + temp);
        		stack.push(sEle);
        		stack.push(fEle);
        		stack.push(temp);
        	} else {
        		stack.push(Integer.parseInt(ch));
        	}
        }
        
        Iterator<Integer> value = stack.iterator();
        
        while (value.hasNext()) {
        	int temp = value.next();
        	// System.out.println(temp);
        	result += temp;
        }
        
        return result;
    }
}
