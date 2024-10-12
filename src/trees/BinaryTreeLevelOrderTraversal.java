package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Binary Tree Level Order Traversal
Given the root of a binary tree, return the level order traversal of its nodes' values. 
(i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
 */

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode root = new TreeNode(1, left, right);
		List<List<Integer>> ans = levelOrder(root);
		System.out.println(ans);
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		
		if (root == null) {
        	return ans;
        }
		
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
        	List<Integer> level = new ArrayList<>();
        	int n = queue.size();
        	
        	for (int i=0; i<n; i++) {
        		TreeNode node = queue.pollFirst();
        		level.add(node.val);
        		
        		if (node.left != null) {
        			queue.add(node.left);
        		}
        		
        		if (node.right != null) {
        			queue.add(node.right);
        		}
        	}
        	
        	ans.add(level);
        }
        
        return ans;
    }
}
