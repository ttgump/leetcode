/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

// 遇到不能排序又要复杂度O(n)有序的问题，只能增加空间复杂度，用hashset或者hashtable 
public class Solution {
    public int longestConsecutive(int[] num) {
        if(num == null) return 0;
        if(num.length == 0 || num.length == 1) return num.length;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : num) {  
            set.add(i);  
        }  
        int maxCon = 0;
        for(int i = 0; i < num.length; i++) {
            if(set.contains(num[i])) {
                int next = num[i] - 1;							// 找比num[i]小一个的值
                int count = 1;
                set.remove(num[i]);								// 及时的移除，减少之后的查找时间
                while(set.contains(next)) {
                    set.remove(next);
                    next--;
                    count++;
                }
                next = num[i] + 1;								// 找比num[i]大一个的值
                while(set.contains(next)) {
                    set.remove(next);
                    next++;
                    count++;
                }
                maxCon = Math.max(maxCon, count);
            }
        }
        return maxCon;
    }
}