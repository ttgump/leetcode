/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
public class Solution {
    public int searchInsert(int[] A, int target) {
        int insert = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == target) {
                insert = i;
                break;
            }
            if(A[i] < target) {
                if(i < A.length - 1) {
                    if(A[i+1] > target) {
                        insert = i+1;
                        break;
                    }
                }
                else {
                    insert = i+1;
                }
            }
        }
        return insert;
    }
}