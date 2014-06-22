/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode nodeBefore = head;
        ListNode node = head.next;
        Tag: 
        while(true) {
            while(node.val == nodeBefore.val) {
                nodeBefore.next = node.next;
                node = node.next;
                if(node == null) break Tag;
            }
            nodeBefore = nodeBefore.next;
            node = node.next;
            if(node == null) break;
        }
        return head;
    }
}