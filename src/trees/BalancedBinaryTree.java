package trees;

/*
 * Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true
 */

public class BalancedBinaryTree {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		TreeNode root = new TreeNode(2, left, right);
		System.out.println(root);
		isBalanced(root);
		System.out.println(balanced);
	}
	
	static boolean balanced = true;
	
	public static boolean isBalanced(TreeNode root) {
        getHeight(root);
		return balanced;
    }
	
	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int leftHeight = getHeight(root.left);
		if (balanced == false) {
			return 0;
		}
		
		int rightHeight = getHeight(root.right);
		
		if (Math.abs(leftHeight - rightHeight) > 1) {
			balanced = false;
			return 0;
		}
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
