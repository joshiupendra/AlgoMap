package heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. 
You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
 */

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		int[] result = topKFrequent(nums, k);
		for (int res: result) {
			System.out.print(res + " ");
		}
	}

	public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(), b.getValue()));
        
        for (int num: nums) {
        	if (map.containsKey(num)) {
        		map.put(num, map.get(num) + 1);
        	} else {
        		map.put(num, 1);
        	}
        }
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	if (minHeap.size() < k) {
        		minHeap.add(entry);
        	} else if (minHeap.peek().getValue() < entry.getValue()) {
        		minHeap.poll();
        		minHeap.add(entry);
        	}
        }
        
        for (int i=0; i<k; i++) {
        	Map.Entry<Integer, Integer> entry = minHeap.poll();
        	result[i] = entry.getKey();
        }
        
        return result;
    }
}
