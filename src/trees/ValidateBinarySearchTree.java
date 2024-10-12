package trees;

/*
 * Validate Binary Search Tree
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 
Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(2147483647);
		TreeNode root = new TreeNode(-2147483648, null, right);
		boolean result = isValidBST(root);
		System.out.println(result);
	}

	public static boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE - 1, Integer.MAX_VALUE + 1, true);
    }
	
	public static boolean isValid(TreeNode node, int min, int max, boolean isRoot) {
		if (node == null) {
			return true;
		}
		
		if (min != Integer.MIN_VALUE && node.val <= min) {
			return false;
		}
		
		if (max != Integer.MAX_VALUE && node.val >= max) {
			return false;
		}
		
		return isValid(node.left, min, node.val, false) && isValid(node.right, node.val, max, false);
	}
}
