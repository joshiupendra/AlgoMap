package trees;

/*
 * Symmetric Tree
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false
 */

public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		TreeNode root = new TreeNode(1, left, right);
		boolean isSymmetric = isSymmetric(root);
		System.out.println(isSymmetric);
	}

	public static boolean isSymmetric(TreeNode root) {  
		return checkSame(root, root);
    }
	
	public static boolean checkSame(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		
		if (root1 == null || root2 == null) {
			return false;
		}
		
		if (root1.val != root2.val) {
			return false;
		}
		
		return checkSame(root1.left, root2.right) && checkSame(root1.right, root2.left);
	}
}
