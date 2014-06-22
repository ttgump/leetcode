/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null) return null;
        if(lists.size() == 0) return null;
        if(isEnd(lists)) return null;
        
        int[] min = getCurrentMin(lists);
        lists.set(min[1], lists.get(min[1]).next);
        ListNode res = new ListNode(min[0]);
        ListNode pRes = res;
        
        while(!isEnd(lists)) {
            min = getCurrentMin(lists);
            lists.set(min[1], lists.get(min[1]).next);
            pRes.next = new ListNode(min[0]);
            pRes = pRes.next;
        }
        
        return res;
    }
    
    public boolean isEnd(ArrayList<ListNode> lists) {
        for(ListNode node : lists) {
            if(node != null) return false;
        }
        return true;
    }
    
    public int[] getCurrentMin(ArrayList<ListNode> lists) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        int[] res = new int[2];
        for(ListNode node : lists) {
            if(node != null && min > node.val) {
                index = lists.indexOf(node);
                min = node.val;
            }
        }
        res[0] = min;
        res[1] = index;
        return res;
    }
}