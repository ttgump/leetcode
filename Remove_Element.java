/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/
/*
用两个指针i，j，一个记录当前的坐标，一个从头到尾扫整个数组。如果遇到跟elem不相同的元素，将之查到已经去掉elem的数组后面。
*/
public class Solution {
    public int removeElement(int[] A, int elem) {
        int i = 0, j = 0;
        int N = A.length;
        while(j < N) {
            if(A[j] == elem)    j++;
            else                A[i++] = A[j++];
        }
        return i;
    }
}