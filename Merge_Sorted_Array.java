/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
*/
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
		// if length 0f A is 0, then just copy B to A
        if(m == 0) {System.arraycopy(B, 0, A, 0, n); return;}
		// merge B to A. i and j are current element index of A and B
        int i = 0, j = 0;
        while(j < n) {
            while(true) {
                if(A[i] >= B[j]) break;
                if(i >= m+j) break;
                i++;
            }
            A[m+j] = A[m+j-1];
            for(int k = m+j-1; k > i; k--) {
                A[k] = A[k-1];
            }
            A[i] = B[j];
            j++;
        }
    }
}