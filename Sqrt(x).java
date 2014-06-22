/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/
/*
两种实现方法：一是二分搜索，二是牛顿迭代法。
这里使用二分搜索法
对于一个非负数n，它的平方根不会大于（n/2+1）。在[0,n/2+1]这个范围内可以进行二分搜索，求出n的平方根。
*/
public class Solution {
    public int sqrt(int x) {
        int i = 0;
        int j = x/2 + 1;
        while(i <= j) {
            int mid = (i+j)/2;
            long sq = (long)mid*mid;
            if(sq == x) return mid;
            else if(sq > x) j = mid-1;
            else i = mid+1;
        }
        return j;
    }
}