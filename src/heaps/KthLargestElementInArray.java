package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Kth Largest Element in an Array
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 */

public class KthLargestElementInArray {

	public static void main(String[] args) {
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		int kthLargest = findKthLargest(nums, k);
		System.out.println(kthLargest);
	}

	public static int findKthLargest(int[] nums, int k) {
        int kthLargest = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int num: nums) {
        	maxHeap.add(num);
        }
        
        for (int i=0; i<k; i++) {
        	kthLargest = maxHeap.poll();
        }
        
        return kthLargest;
    }
}
