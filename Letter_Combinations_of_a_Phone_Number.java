/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        res.add("");
        if(digits == null) return res;
        int N = digits.length();
        for(int i = 0; i < N; i++) {
            int d = digits.charAt(i) - '0';
            switch(d){
                case 1: break;
                case 2: {
                    ArrayList<String> newRes = new ArrayList<String>();
                    for(String str : res) {
                        String str1 = str + "a";
                        String str2 = str + "b";
                        String str3 = str + "c";
                        newRes.add(str1);
                        newRes.add(str2);
                        newRes.add(str3);
                    }
                    res = newRes;
                    break;
                }
                case 3: {
                    ArrayList<String> newRes = new ArrayList<String>();
                    for(String str : res) {
                        String str1 = str + "d";
                        String str2 = str + "e";
                        String str3 = str + "f";
                        newRes.add(str1);
                        newRes.add(str2);
                        newRes.add(str3);
                    }
                    res = newRes;
                    break;
                }
                case 4: {
                    ArrayList<String> newRes = new ArrayList<String>();
                    for(String str : res) {
                        String str1 = str + "g";
                        String str2 = str + "h";
                        String str3 = str + "i";
                        newRes.add(str1);
                        newRes.add(str2);
                        newRes.add(str3);
                    }
                    res = newRes;
                    break;
                }
                case 5: {
                    ArrayList<String> newRes = new ArrayList<String>();
                    for(String str : res) {
                        String str1 = str + "j";
                        String str2 = str + "k";
                        String str3 = str + "l";
                        newRes.add(str1);
                        newRes.add(str2);
                        newRes.add(str3);
                    }
                    res = newRes;
                    break;
                }
                case 6: {
                    ArrayList<String> newRes = new ArrayList<String>();
                    for(String str : res) {
                        String str1 = str + "m";
                        String str2 = str + "n";
                        String str3 = str + "o";
                        newRes.add(str1);
                        newRes.add(str2);
                        newRes.add(str3);
                    }
                    res = newRes;
                    break;
                }
                case 7: {
                    ArrayList<String> newRes = new ArrayList<String>();
                    for(String str : res) {
                        String str1 = str + "p";
                        String str2 = str + "q";
                        String str3 = str + "r";
                        String str4 = str + "s";
                        newRes.add(str1);
                        newRes.add(str2);
                        newRes.add(str3);
                        newRes.add(str4);
                    }
                    res = newRes;
                    break;
                }
                case 8: {
                    ArrayList<String> newRes = new ArrayList<String>();
                    for(String str : res) {
                        String str1 = str + "t";
                        String str2 = str + "u";
                        String str3 = str + "v";
                        newRes.add(str1);
                        newRes.add(str2);
                        newRes.add(str3);
                    }
                    res = newRes;
                    break;
                }
                case 9: {
                    ArrayList<String> newRes = new ArrayList<String>();
                    for(String str : res) {
                        String str1 = str + "w";
                        String str2 = str + "x";
                        String str3 = str + "y";
                        String str4 = str + "z";
                        newRes.add(str1);
                        newRes.add(str2);
                        newRes.add(str3);
                        newRes.add(str4);
                    }
                    res = newRes;
                    break;
                }
            }
        }
        return res;
    }
}