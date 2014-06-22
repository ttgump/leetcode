/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Node[] a = new Node[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            a[i] = new Node(numbers[i], i + 1);
        }
        Arrays.sort(a);
        int i = 0, j = numbers.length-1;
        while(i < j) {
            if(a[i].getVal() + a[j].getVal() == target) break;
            else if(a[i].getVal() + a[j].getVal() < target) i++;
            else j--;
        }
        int[] result = new int[2];
        result[0] = Math.min(a[i].getIndex(), a[j].getIndex());
        result[1] = Math.max(a[i].getIndex(), a[j].getIndex());
        return result;
    }
}

 class Node implements Comparable<Node> {
     private int val;
     private int index;
 
     Node(int v, int idx) {
         setVal(v);
         setIndex(idx);
     }
 
     public int getVal() {
         return this.val;
     }
 
     public void setVal(int val) {
         this.val = val;
     }
 
     public int getIndex() {
         return index;
     }
 
     public void setIndex(int index) {
         this.index = index;
     }

     public int compareTo(Node o) {
         return this.getVal() - o.getVal();
     }
 
     public String toString() {
         return Integer.toString(getVal());
     }
 }