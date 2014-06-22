/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {
    public String addBinary(String a, String b) {
        if(a == null && b == null) return "";
        if(a != null && b == null) return a;
        if(a == null && b != null) return b;
        String res = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        boolean carry = false;
        while(i >= 0 || j >= 0) {
            int valueA = 0;
            int valueB = 0;
            int sum = 0;
            if(i >= 0 && j < 0) {
                valueA = a.charAt(i--) - '0';
            }
            else if(i < 0 && j >= 0) {
                valueB = b.charAt(j--) - '0';
            }
            else {
                valueA = a.charAt(i--) - '0';
                valueB = b.charAt(j--) - '0';
            }
            
            if(carry)       sum = valueA + valueB + 1;
            else            sum = valueA + valueB;
            if(sum >= 2) {
                sum = sum % 2;
                carry = true;
            }
            else carry = false;
            res = String.valueOf(sum) + res;
        }
        if(carry)       res = String.valueOf(1) + res;
        return res;
    }
}