/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }
    
    public int depth(TreeNode root, int h) {
        if(root == null) return h;
        else if(root.left == null && root.right == null) return h+1;
        else if(root.left == null && root.right != null) return depth(root.right, h+1);
        else if(root.left != null && root.right == null) return depth(root.left, h+1);
        else return Math.max(depth(root.left, h+1), depth(root.right, h+1));
    }
}