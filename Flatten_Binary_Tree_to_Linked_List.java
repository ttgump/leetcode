/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
 
 /*
 这道题思路很清晰，就是递归，然后分别flat右和左，刚开始以为flat哪个先都无所谓，但实际是要先flatten右边的，不然flatten完左边，把左边的连上右边去，右边的已经不是bst了。这是第一点。

第二点，难点，也是我卡住的地方，就是如何把点连接起来。我的思路会，但就是连点连错了，导致出不来。之前我写的是

build(root->right);
build(root->left);

root->right->left=root->right;
root->right=root->left;

这样看上去是对的，但是对于完成了一颗子树，换到另一颗子树的连接就出了问题。这个时候我们要用一个treenode来保存之前跑过的node的root，以便下一次连接，于是就有了下面的代码，多了一个tree.
 */
public class Solution {
    TreeNode tree = null;
    
    public void flatten(TreeNode root) {
        if(root == null) return;
        preOrder(root);
    }
    
    public void preOrder(TreeNode root) {
        if(root == null) return;
        
        preOrder(root.right);
        preOrder(root.left);
        root.right = tree;
        tree = root;
        root.left = null;
    }
}