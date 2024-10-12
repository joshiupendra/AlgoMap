package trees;

/*
 * Kth Smallest Element in a BST
Given the root of a binary search tree, and an integer k, 
return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Time Complexity: O(n)
Space Complexity: O(n)
 */

public class KthSmallestElementInBST {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		TreeNode root = new TreeNode(2, left, right);
		int result = kthSmallest(root, 2);
		System.out.println(result);
	}
	
	static int count;
	static int ans;

	public static int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return ans;
    }
	
	public static void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		
		inorder(node.left);
		
		if (count == 1) {
			ans = node.val;
		}
		
		count = count - 1;
		if (count > 0) {
			inorder(node.right);
		}
	}
}
