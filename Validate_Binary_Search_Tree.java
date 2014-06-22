/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/

/*
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
*/

/*
对于每一个子树，限制它的最大，最小值，如果超过则返回false。
对于根节点，最大最小都不限制；
每一层节点，左子树限制最大值小于根，右子树最小值大于根；
但是比较有趣的是，在递归的过程中还得不断带入祖父节点的值。

或者，中序遍历该树，然后扫描一遍看是否递增。
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
    public boolean isValidBST(TreeNode root) {
        return validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean validBST(TreeNode node, int min, int max) {
        if(node == null) return true;
        if(node.val > min 
				&& node.val < max 
				&& validBST(node.left, min, node.val)
				&& validBST(node.right, node.val, max))
            return true;
        else
            return false;
    }
}