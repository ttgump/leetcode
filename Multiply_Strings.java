/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/
/*
Since the numbers can be arbitrarily large, we cannot convert a string number into an integer or a long. We need to convert them to an integer array where each element is one digit of the original string number. E.g. "12345" -> {1, 2, 3, 4, 5}.

We also need such an integer array for the result.
How long could it be?
Think about it. We know 999 * 999 < 999 * 1000 = 999000. That said, the length of the result array is the sum of the lengths of the two integer arrays.

At the end, we also need to trim prefix 0's, i.e. "090" -> "90".

Note that it is not necessary to have two integer arrays for the input string number. We can do the conversion on the fly (i.e. when performing multiplication for the two digits). Here we use space to save some redundant conversion time.

http://n00tc0d3r.blogspot.com/2013/04/multiply-strings.html
*/
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";  
        int l1 = num1.length(), l2 = num2.length();  
        int[] n1 = new int[l1];  
        int[] n2 = new int[l2];  
        int[] res = new int[l1+l2];  
        // convert num1 to number array  
        for (int i=0; i<l1; ++i) {  
			n1[i] = num1.charAt(i) - '0';  
        }  
        // convert num2 to number array  
        for (int i=0; i<l2; ++i) {  
			n2[i] = num2.charAt(i) - '0';  
        }  
        // multiply into number array  
        for (int i=0; i<l1; ++i) {  
			for (int j=0; j<l2; ++j) {  
				res[i+j+1] += n1[i]*n2[j];  
			}  
        }  
        // convert back to string  
        StringBuilder ss = new StringBuilder();  
        for (int k=l1+l2-1; k>=0; --k) {  
			ss.append((char)(res[k] % 10 + '0'));  
			if (k>0) res[k-1] += res[k] / 10;  
        }  
        // trim 0's  
        int count = ss.charAt(ss.length()-1)=='0' ? 1 : 0; 
        String s = ss.reverse().substring(count, ss.length());  
        return (s.isEmpty()) ? "0" : s;  
    }
}