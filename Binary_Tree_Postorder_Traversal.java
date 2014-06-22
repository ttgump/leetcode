/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        
        while(!st.isEmpty()) {
            TreeNode temp = st.peek();
            if(temp.left == null && temp.right == null) {
                res.add(temp.val);
                st.pop();
                while(!st.isEmpty() && (st.peek().left == temp || st.peek().right == temp)) {
                    temp = st.pop();
                    res.add(temp.val);
                }
            } else {
                if(temp.right != null)
                    st.push(temp.right);
                if(temp.left != null)
                    st.push(temp.left);
            }
        }
        return res;
    }
}