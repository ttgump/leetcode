/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

click to show clarification.
*/

public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) return "";
        String[] strs = s.split("\\s+");
        if(strs.length == 0) return "";
        String result = "";
        result += strs[strs.length - 1];
        for(int i = strs.length - 2; i >= 0; i--) {
            if(!strs[i].equals(""))
                result += " " + strs[i];
        }
        return result;
    }
}