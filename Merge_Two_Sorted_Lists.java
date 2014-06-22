/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 != null && l2 == null) return l1;
        if(l1 == null && l2 != null) return l2;
        int lest = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        if(l1.val < l2.val) { lest = l1.val; p1 = p1.next; }
        else { lest = l2.val; p2 = p2.next; }
        ListNode list = new ListNode(lest);
        ListNode node = list;
        while(p1 != null || p2 != null) {
            if(p1 != null && p2 != null) {
                if(p1.val < p2.val) { lest = p1.val; p1 = p1.next; }
                else { lest = p2.val; p2 = p2.next; }
            }
            else if(p1 != null && p2 == null) {
                lest = p1.val;
                p1 = p1.next;
            }
            else if(p1 == null && p2 != null) {
                lest = p2.val;
                p2 = p2.next;
            }
            node.next = new ListNode(lest);
            node = node.next;
        }
        return list;
    }
}