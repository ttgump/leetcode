/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

/*
The divide and conquer approach can be find in the Chapter 4 in <Introduction to Algorithm 3ed>
*/
public class Solution {
    public int maxSubArray(int[] A) {
        if(A.length == 0) return 0;
        int[] res = maxSubArrayHelper(A, 0, A.length-1);
        return res[2];
    }
    
    public int[] maxSubArrayHelper(int[] A, int low, int high) {
        if(high == low) {
            int[] res = {low, high, A[low]};
            return res;
        }
        else {
            int mid = (low+high)/2;
            int[] left = maxSubArrayHelper(A, low, mid);
            int[] right = maxSubArrayHelper(A, mid+1, high);
            int[] cross = maxCrossSubArrayHelper(A, low, mid, high);
            if(left[2] >= right[2] && left[2] >= cross[2]) return left;
            else if(right[2] >= left[2] && right[2] >= cross[2]) return right;
            else return cross;
        }
    }
    
    public int[] maxCrossSubArrayHelper(int[] A, int low, int mid, int high) {
        int left_sum = Integer.MIN_VALUE;
        int max_left = mid;
        int sum = 0;
        for(int i = mid; i >= low; i--) {
            sum += A[i];
            if(sum > left_sum) {
                left_sum = sum;
                max_left = i;
            }
        }
        
        int right_sum = Integer.MIN_VALUE;
        int max_right = mid;
        sum = 0;
        for(int j = mid+1; j <= high; j++) {
            sum += A[j];
            if(sum > right_sum) {
                right_sum = sum;
                max_right = j;
            }
        }
        
        int[] res = {max_left, max_right, left_sum+right_sum};
        return res;
    }
}