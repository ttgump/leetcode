/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/
/*
虽然不能再另外开辟非常数级的额外空间，但是可以在输入数组上就地进行swap操作。

思路：交换数组元素，使得数组中第i位存放数值(i+1)。最后遍历数组，寻找第一个不符合此要求的元素，返回其下标。整个过程需要遍历两次数组，复杂度为O(n)。

下图以题目中给出的第二个例子为例，讲解操作过程。

3	4	-1	1		swap 3, -1

-1	4	3	1		swap 4, 1

-1	1	3	4		swap 1, -1

1	-1	3	4

http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html
*/
public class Solution {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length) {
            if(A[i] > 0 && A[i] < A.length && A[i] != A[A[i]-1]) swap(A, i, A[i]-1);
            else i++;
        }
        int index = 0;
        for(; index < A.length; index++) {
            if(A[index] != index+1) break;
        }
        return index+1;
    }
    
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}