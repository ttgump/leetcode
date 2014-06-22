/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(true) {
            slow = slow.next;
            if(fast.next == null) return null;
            fast = fast.next.next;
            if(fast == null) return null;
            if(slow == fast) break;
        }
        
        slow = head;
        while(true) {
            if(slow == fast) return slow;
            slow = slow.next;
            fast = fast.next;
        }
    }
}