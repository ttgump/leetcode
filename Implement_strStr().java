/*
Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
*/
public class Solution {
    public String strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return null;
        if(needle.length() == 0) return haystack;
        
        for(int i=0; haystack.length() - i >= needle.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int j = i;
                while(j - i < needle.length() && haystack.charAt(j) == needle.charAt(j-i))
                    j++;
                if(j - i == needle.length())
                    return haystack.substring(i);
            }
        }
        return null;
    }
}