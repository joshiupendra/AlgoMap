package trees;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardUpLeftHandler;

/*
 * Maximum Depth of Binary Tree
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2
 */

public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		TreeNode root = new TreeNode(2, left, right);
		int height = maxDepth(root);
		System.out.println(height);
	}

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
        
		return 1 + Math.max(left, right);
    }
}
