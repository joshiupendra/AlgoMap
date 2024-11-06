package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Find if Path Exists in Graph
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). 
The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. 
Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
You want to determine if there is a valid path that exists from vertex source to vertex destination.
Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

Example 1:
Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2

Example 2:
Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
 */

public class FindIfPathExistsInGraph {

	public static void main(String[] args) {
		int n = 3;
		int[][] edges = {{0,1},{1,2},{2,0}};
		int source = 0;
		int destination = 2;
		boolean result = validPath(n, edges, source, destination);
		System.out.println(result);
	}

	public static boolean validPath(int n, int[][] edges, int source, int destination) {
		if (source == destination) {
			return true;
		}
		
		HashMap<Integer, List<Integer>> sPath = new HashMap<>();
		
		for (int i=0; i<edges.length; i++) {
			int e1 = edges[i][0];
			int e2 = edges[i][1];
			
			if (sPath.containsKey(e1)) {
				sPath.get(e1).add(e2);
			} else {
				List<Integer> pPath = new ArrayList<>();
				pPath.add(e2);
				sPath.put(e1, pPath);
			}
			
			if (sPath.containsKey(e2)) {
				sPath.get(e2).add(e1);
			} else {
				List<Integer> pPath = new ArrayList<>();
				pPath.add(e1);
				sPath.put(e2, pPath);
			}
		}

		boolean[] travel = new boolean[n];
		Arrays.fill(travel, false);
		
		return dfs(source, destination, sPath, travel);
    }

	public static boolean dfs(int src, int destination, Map<Integer, List<Integer>> map, boolean[] travel) {
		travel[src] = true;
		if (src == destination) {
			return true;
		}
		
		List<Integer> list = map.get(src);
		for (int i=0; i<list.size(); i++) {
			int ele = list.get(i);
			if (!travel[ele]) {
				if (dfs(ele, destination, map, travel)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
