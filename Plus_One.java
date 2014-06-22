/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        boolean carry = false;
        digits[digits.length - 1] += 1;
        if(digits[digits.length - 1] >= 10) {
            carry = true;
            digits[digits.length - 1] = digits[digits.length - 1] % 10; 
        }
        for(int i = digits.length - 2; i >= 0; i--) {
            if(carry) {
                digits[i] += 1;
                if(digits[i] >= 10) {
                    digits[i] = digits[i] % 10;
                }
                else {
                    carry = false;
                }
            }
            else {
                break;
            }
        }
        if(carry) {
            int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = 1;
            return res;
        }
        return digits;
    }
}