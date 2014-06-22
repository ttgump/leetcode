/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
/**
用一个stack解决问题，从头到尾扫描一下，遇到左括号压栈，遇到右括号就将stack的top元素和其配对弹出。如果中间遇到问题不能配对，或者到最后stack不空，就返回false
*/
public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else {
                if(st.empty()) return false;
                if(ch == ')') {
                    if(st.peek() == '(') st.pop();
                    else return false;
                }
                if(ch == ']') {
                    if(st.peek() == '[') st.pop();
                    else return false;
                }
                if(ch == '}') {
                    if(st.peek() == '{') st.pop();
                    else return false;
                }
            }
        }
        return st.empty();
    }
}