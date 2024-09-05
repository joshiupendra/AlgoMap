package stacks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:
MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */

public class MinStack {
	List<Integer> list = new ArrayList<Integer>();
	int size;
	int minEle;

	public MinStack() {

	}

	public void push(int val) {
		if (size == 0) {
			minEle = val;
		} else {
			minEle = Math.min(minEle, val);
		}
		list.add(val);
		size++;
		// Collections.sort(list);
	}

	public void pop() {
		if (size > 0) {
			int ele = list.remove(size - 1);
			size--;
			if (ele == minEle && size > 0) {
				minEle = list.stream().min(Integer::compareTo).get();
			}
		}
	}

	public int top() {
		return list.get(size - 1);
	}

	public int getMin() {
		return minEle;
	}

	public void print() {
		System.out.println(list);
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(2147483646);
		minStack.push(2147483646);
		minStack.push(2147483647);
		minStack.print();
		System.out.println(minStack.top());
		minStack.pop();
		minStack.print();
		System.out.println(minStack.getMin());
		minStack.pop();
		minStack.print();
		System.out.println(minStack.getMin());
		minStack.pop();
		minStack.push(2147483647);
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
		minStack.push(-2147483648);
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
	}

}
