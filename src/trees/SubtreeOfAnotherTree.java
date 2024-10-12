package trees;

/*
 * Subtree of Another Tree
Given the roots of two binary trees root and subRoot, 
return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 */

public class SubtreeOfAnotherTree {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode root = new TreeNode(1, left, right);
		TreeNode subRoot = new TreeNode(2);
		boolean isSubTree = isSubtree(root, subRoot);
		System.out.println(isSubTree);
	}

	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return hasSubTree(root, subRoot);
    }
	
	public static boolean sameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		
		if ((p != null && q == null) || (p == null && q != null)) {
			return false;
		}
		
		if (p.val != q.val) {
			return false;
		}
		
		return sameTree(p.left, q.left) && sameTree(p.right, q.right);
	}
	
	public static boolean hasSubTree(TreeNode root, TreeNode subRoot) {
		if (root == null) {
			return false;
		}
		
		if (sameTree(root, subRoot)) {
			return true;
		}
		
		return hasSubTree(root.left, subRoot) || hasSubTree(root.right, subRoot);
	}
}
