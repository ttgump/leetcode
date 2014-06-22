/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
*/

/*
[解题思路]
非递归解法：按层遍历，每一层检查一下是否对称。

递归解法：

其中左子树和右子树对称的条件：
两个节点值相等，或者都为空
左节点的左子树和右节点的右子树对称
左节点的右子树和右节点的左子树对称
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSym(root.left, root.right);
    }
    
    public boolean isSym(TreeNode left, TreeNode right) {
        if(left == null) return right == null;
        if(right == null) return left == null;
        if(left.val != right.val) return false;
        if(!isSym(left.left, right.right)) return false;
        if(!isSym(left.right, right.left)) return false;
        return true;
    }
}