package stacks;

import java.util.Stack;

/*
 * Daily Temperatures
Given an array of integers temperatures represents the daily temperatures, 
return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. 
If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
 */

public class DailyTemperatures {

	public static void main(String[] args) {
		int[] temperatures = { };
		int[] result = dailyTemperatures(temperatures);
		for (int num : result) {
			System.out.print(num + " ");
		}
	}

	public static int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		if (n == 0) {
			return new int[] {};
		}
		
		int[] result = new int[n];
		Stack<int[]> stack = new Stack<>();
		
		stack.push(new int[] {temperatures[0], 0});

		for (int i = 1; i < n; i++) {
			while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
				int[] temp = stack.pop();
				result[temp[1]] = i - temp[1];
			} 
				
			stack.push(new int[] {temperatures[i], i});
		}

		return result;
	}
}
