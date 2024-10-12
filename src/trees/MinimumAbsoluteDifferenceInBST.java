package trees;

/*
 * Minimum Absolute Difference in BST
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1
 */

public class MinimumAbsoluteDifferenceInBST {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		TreeNode root = new TreeNode(2, left, right);
		int result = getMinimumDifference(root);
		System.out.println(result);
	}
	
	static int minDistance = Integer.MAX_VALUE;
	static int prev = Integer.MIN_VALUE;

	public static int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDistance;
    }
	
	public static void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		
		inorder(node.left);
		
		if (prev != Integer.MIN_VALUE) {
			minDistance = Math.min(minDistance, node.val - prev);
		}
		
		prev = node.val;
		
		inorder(node.right);
	}
}
