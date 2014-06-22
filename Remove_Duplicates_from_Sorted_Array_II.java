/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/
/*
主要思路跟Remove Duplicates from Sorted Array I类似，增加一个boolean变量记录是否是第二次重复即可。
*/
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length <= 1) return A.length;
        int i = 0;
        boolean isSecond = false;
        for(int j = 1; j < A.length; j++) {
            if(A[j] != A[i]) {
                A[++i] = A[j];
                isSecond = false;
            }
            else if(A[j] == A[i] && !isSecond) {
                A[++i] = A[j];
                isSecond = true;
            }
            else isSecond = true;
        }
        return i+1;
    }
}