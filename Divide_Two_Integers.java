/*
Divide two integers without using multiplication, division and mod operator.
*/
/*
使用位操作，算法如下：
function divide(x, y)
Input: Two n-bit integers x and y, where y >= 1
Output: The quotient and remainder of x divided by y
if x = 0: return (q, r) = (0, 0)
(q, r) = divide(x/2, y)
q = 2 * q, r = 2 * r
if x is odd: r = r + 1
if r >= y: r = r * y, q = q + 1
return (q; r)
*/
public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return 0;
        else if(dividend < 0 && divisor < 0) return (int)divideHelper(-(long)dividend, -(long)divisor)[0];
        else if(dividend < 0 && divisor > 0) return -(int)divideHelper(-(long)dividend, (long)divisor)[0];
        else if(dividend >= 0 && divisor < 0) return -(int)divideHelper((long)dividend, -(long)divisor)[0];
        else return (int)divideHelper((long)dividend, (long)divisor)[0];
    }
    
    public long[] divideHelper(long x, long y) {
        long[] res = {0, 0};
        if(x == 0) return res;
        res = divideHelper(x >> 1, y);
        long q = res[0];
        long r = res[1];
        q = q << 1;
        r = r << 1;
        if((x & 1) == 1) r = r+1;		// Decide whether x is odd
        if(r >= y) {
            r = r - y;
            q = q + 1;
        }
        res[0] = q;
        res[1] = r;
        return res;
    }
}