/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<String>();
        for(int i = 0; i < tokens.length; i++) {
            if(!isOperator(tokens[i])) {
                st.push(tokens[i]);
            }
            else {
                int a=0, b=0, result=0;
                a = Integer.parseInt(st.pop());
                b = Integer.parseInt(st.pop());
                if(tokens[i].equals("+"))       result = b + a;
                else if(tokens[i].equals("-"))  result = b - a;
                else if(tokens[i].equals("*"))  result = b * a;
                else if(tokens[i].equals("/"))  result = b / a;
                st.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(st.pop());
    }
    
    public boolean isOperator(String token) {
        if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
            return true;
        else
            return false;
    }
}