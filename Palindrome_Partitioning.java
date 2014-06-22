/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
         if (s==null || s.length()==0){
           return res;
        }
        ArrayList<String> output = new ArrayList<String>();
        find(s, 0, output, res);
        return res;
    }
    
    public void find(String s, int st, ArrayList<String> output, ArrayList<ArrayList<String>> res) {
        if(st >= s.length()) {
            ArrayList<String> temp=new ArrayList<String>(output);
            res.add(temp);
        }
        else {
            for(int i = st; i < s.length(); i++) {
                if(isPalindrome(s, st, i)) {
                    output.add(s.substring(st, i+1));
                    find(s, i+1, output, res);
                    output.remove(output.size() - 1);
                }
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}