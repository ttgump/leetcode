/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.isEmpty()) return 0;
        int n = s.length()-1;
        while(n >= 0 && s.charAt(n) == ' ') n--;		// find the index of the last char that is not space
        int i = n;
        for(; i >= 0; i--) {
            if(s.charAt(i) == ' ') break;				// find the length of the last word
        }
        return n-i;
    }
}