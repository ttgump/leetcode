/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> path = new ArrayList<List<Integer>>();
        if(root == null) return path;
        List<Integer> onePath = new ArrayList<Integer>();
        pathSumHelper(root, sum, onePath, path);
        return path;
    }
    
    public void pathSumHelper(TreeNode root, int sum, List<Integer> onePath, List<List<Integer>> path) {
        if(root == null) return;
        
        onePath.add(root.val);
        
        if(root.left == null && root.right == null && sum == root.val) {
            List<Integer> copy = new ArrayList<Integer>();
            copy.addAll(onePath);
            path.add(copy);
        }
        else {
            pathSumHelper(root.left, sum - root.val, onePath, path);
            pathSumHelper(root.right, sum - root.val, onePath, path);
        }
        onePath.remove(onePath.size() - 1);
    }
}