/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/
public class Solution {
    public int atoi(String str) {
        if(str == null) return 0;
        if(str.length() == 0) return 0;
		// i is the begin index of the integer, this means discard space and '-' and '+'
        int i = 0;
        int N = str.length();
        while(i < N && str.charAt(i) == ' ') {
            i++;
        }
        if(i == N) return 0;
        
        boolean negative = (str.charAt(i) == '-');
        int res = 0;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        
		// j is the end index of the integer
        int j = i;
        for(; j < N; j++) {
            if(str.charAt(j) < '0' || str.charAt(j) > '9')
                break;
        }
        
        for(int k = i; k <= j-1; k++) {
            if(res > Integer.MAX_VALUE/10
        			|| (res == Integer.MAX_VALUE/10 
        				&& str.charAt(k) > '7')) {
        		if(negative)
        			return Integer.MIN_VALUE;
        		else 
        			return Integer.MAX_VALUE;
        	}
            res = res*10 + (str.charAt(k) - '0');
        }
        
        if(negative) return -res;
        else return res;
    }
}