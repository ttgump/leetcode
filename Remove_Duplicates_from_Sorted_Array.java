/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
*/
/*
算法主要思路为不断前向查找，当找到一个不再重复的元素时，将该元素复制到已经去重的最后一个元素的下一个相邻位置。前向查找及元素复制位置由索引front、back维护。
*/
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length <= 1) return A.length;
        int n = A.length;
        int front, back = 0;
        for(front = 1; front < n; front++) {
            if(A[back] != A[front]) {
                A[++back] = A[front];
            }
        }
        return back+1;
    }
}