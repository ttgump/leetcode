/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

/*
递归解法 超时！
public static boolean wordBreakHelper(String s, Set<String> dict) {
	for(int i = 1; i < s.length(); i++) {
		if(isContain(s.substring(0, i), dict)) {
			if(wordBreakHelper(s.substring(i, s.length()), dict)) return true;
		}
	}
	return false;
}

public static boolean isContain(String s, Set<String> dict) {
	for(String str : dict) {
		if(str.equals(s)) return true;
	}
	return false;
}
*/

//dynamic programming
//define dp[], dp[i]=true means that 0-(i-1) can be segmented using dictionary
//for each position in string s, if the current position is true, update dp when any substring starting from the current position is existing in the dictionary
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 0;i < s.length();i++){
            if(!dp[i]) continue;
            for(String e: dict){
                int end = i + e.length();
                if(end > s.length()) continue;
                String sub = s.substring(i, end);
                if(sub.equals(e))
                    dp[end] = true;
            }
        }
        return dp[s.length()];
    }
}