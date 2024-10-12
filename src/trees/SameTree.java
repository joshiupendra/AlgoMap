package trees;

/*
 * Same Tree
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false
 */

public class SameTree {

	public static void main(String[] args) {
		TreeNode left1 = new TreeNode(1);
		TreeNode right1 = new TreeNode(3);
		TreeNode p = new TreeNode(2, left1, right1);
		TreeNode left2 = new TreeNode(1);
		TreeNode right2 = new TreeNode(3);
		TreeNode q = new TreeNode(2, left2, right2);
		boolean isSame = isSameTree(p, q);
		System.out.println(isSame);
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		return isBalanced(p, q);
    }
	
	public static boolean isBalanced(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		
		if ((p != null && q == null) || (p == null && q != null)) {
			return false;
		}
		
		if (p.val != q.val) {
			return false;
		}
		
		return isBalanced(p.left, q.left) && isBalanced(p.right, q.right);
	}
}
