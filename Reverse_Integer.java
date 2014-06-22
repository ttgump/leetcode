/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/
public class Solution {
    public int reverse(int x) {
        if(x >= 0) {
            String str = String.valueOf(x);
            String re_str = "";
            for(int i = str.length()-1; i >= 0; i--)
                re_str += str.charAt(i);
            return Integer.parseInt(re_str);
        }
        else {
            String str = String.valueOf(-x);
            String re_str = "";
            for(int i = str.length()-1; i >= 0; i--)
                re_str += str.charAt(i);
            return (-1)*Integer.parseInt(re_str);
        }
    }
}