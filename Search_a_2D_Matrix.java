/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

//two binary search
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length-1;
        boolean flag = false;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(matrix[mid][0] < target) {start = mid+1; flag = true;}
            else if(matrix[mid][0] > target) end = mid-1;
            else return true;
        }
        if(flag) return binarySearch(matrix[start-1], target, 0, matrix[0].length-1);
        else return binarySearch(matrix[start], target, 0, matrix[0].length-1);
    }
    
    public boolean binarySearch(int[] array, int target, int st, int en) {
        if(st > en) return false;
        int mid = st + (en-st)/2;
        if(array[mid] > target) return binarySearch(array, target, st, mid-1);
        else if(array[mid] < target) return binarySearch(array, target, mid+1, en);
        else return true;
    }
}