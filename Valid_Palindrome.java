/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[\\p{Punct}\\p{Space}]+", "");;
        if(s.length() == 0 || s.length() == 1) return true;
        if(s.length() == 2) return s.charAt(0) == s.charAt(1);
        int i = 0;
        while(i <= s.length() / 2) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
            i++;
        }
        return true;
    }
}