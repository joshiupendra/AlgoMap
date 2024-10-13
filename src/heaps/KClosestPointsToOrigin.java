package heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * K Closest Points to Origin
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, 
return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Example 1:
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		int[][] points = {{0,1},{1,0}};
		int k = 2;
		int[][] result = kClosest(points, k);
		for (int[] point: result) {
			for (int cor: point) {
				System.out.print(cor + " ");
			}
			System.out.println();
		}
	}

	public static int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        
        Map<int[], Double> map = new HashMap<>();
        for (int[] point: points) {
        	double distance = Math.sqrt((Math.abs(point[0])*Math.abs(point[0])) + (Math.abs(point[1])*Math.abs(point[1])));
        	map.put(point, distance);
        }
        
        PriorityQueue<Map.Entry<int[], Double>> minHeap = new PriorityQueue<>((a,b) -> Double.compare(b.getValue(), a.getValue()));
        
        for (Map.Entry<int[], Double> entry: map.entrySet()) {
        	if (minHeap.size() < k) {
        		minHeap.add(entry);
        	} else if (minHeap.peek().getValue() > entry.getValue()) {
        		minHeap.poll();
        		minHeap.add(entry);
        	}
        }
        
        for (int i=0; i<k; i++) {
        	int[] point = minHeap.poll().getKey();
        	result[i][0] = point[0];
        	result[i][1] = point[1];
        }
        
        return result;
    }
}
