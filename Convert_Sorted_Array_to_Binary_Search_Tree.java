/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/*
此题用递归的方法，首先找到数组中的中值作为root，之后把中值左边的和右边的数组作为新数组分别做递归。
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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length == 0) return null;
        if(num.length == 1) return new TreeNode(num[0]);
        
        int n = num.length;
        int i = n/2;
        TreeNode root = new TreeNode(num[i]);
        
        int leftLength = i;
        int[] leftNum = new int[leftLength];
        System.arraycopy(num, 0, leftNum, 0, leftLength);
        root.left = sortedArrayToBST(leftNum);
        
        int rightLength = n-leftLength-1;
        int[] rightNum = new int[rightLength];
        System.arraycopy(num, i+1, rightNum, 0, rightLength);
        root.right = sortedArrayToBST(rightNum);
        
        return root;
    }
}