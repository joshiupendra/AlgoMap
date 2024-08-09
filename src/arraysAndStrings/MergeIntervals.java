package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], 
merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Example 3:
Input: [[2,3],[4,5],[6,7],[8,9],[1,10]]
 */
public class MergeIntervals {

	public static void main(String[] args) {
		int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
		int[][] result = merge(intervals);
		
		for (int[] interval: result) {
			for (int n: interval) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        
        // Sort the intervals by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		
        // Add first interval to the result list
        list.add(intervals[0]);
        
        for (int i=1; i<intervals.length; i++) {
        	int[] lastInterval = list.get(list.size() - 1);
        	
        	// If Start is less than previous interval end then update end to current interval end
        	if (lastInterval[1] >= intervals[i][0]) {
        		lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
        	} else {
        		list.add(intervals[i]);
        	}
        }
        
        // Convert the ArrayList to a 2D array and return it
        int[][] result = list.toArray(new int[list.size()][]);
        
        return result;
    }

}
