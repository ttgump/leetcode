/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(checkHeight(root) == -1)
			return false;
		else
			return true;
    }
    
    public int checkHeight(TreeNode root) {
		if(root == null) return 0;
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1) return -1;
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1) return -1;
		
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1) return -1;
		else return Math.max(leftHeight, rightHeight) + 1;
	}
}