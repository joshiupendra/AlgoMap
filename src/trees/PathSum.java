package trees;

/*
 * Path Sum
Given the root of a binary tree and an integer targetSum, 
return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.

Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 */

public class PathSum {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode root = new TreeNode(1, left, right);
		boolean hasPathSum = hasPathSum(root, 5);
		System.out.println(hasPathSum);
	}

	public static boolean hasPathSum(TreeNode root, int targetSum) {
        return hasSum(root, 0, targetSum);
    }
	
	public static boolean hasSum(TreeNode root, int curSum, int targetSum) {
		if (root == null) {
			return false;
		}
		
		curSum += root.val;
		
		if (root.left == null && root.right == null) {
			return curSum == targetSum;
		}
		
		return hasSum(root.left, curSum, targetSum) || hasSum(root.right, curSum, targetSum);
	}
}
