package stacks;

import java.util.Stack;

/*
 * Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true
 */

public class ValidParentheses {

	public static void main(String[] args) {
		String s = "([])";
		boolean result = isValid(s);
		System.out.println(result);
	}

	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch: s.toCharArray()) {
        	if (ch == '(' || ch == '{' || ch == '[') {
        		stack.push(ch);
        	} else if (ch == ')') {
        		if (!stack.empty() && stack.peek() == '(') {
        			stack.pop();
        		} else {
        			return false;
        		}
        	} else if (ch == '}') {
        		if (!stack.empty() && stack.peek() == '{') {
        			stack.pop();
        		} else {
        			return false;
        		}
        	} else if (ch == ']') {
        		if (!stack.empty() && stack.peek() == '[') {
        			stack.pop();
        		} else {
        			return false;
        		}
        	}
        }
        
        if (!stack.empty()) {
        	return false;
        }
		
		return true;
    }
}
