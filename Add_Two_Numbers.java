/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 != null && l2 == null) return l1;
        if(l1 == null && l2 != null) return l2;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        ListNode res = new ListNode((p1.val + p2.val)%10);
        carry = (p1.val+p2.val)/10;
        p1 = p1.next;
        p2 = p2.next;
        ListNode r = res;
        
        while(p1 != null || p2 != null) {
            if(p1 != null && p2 == null) {
                r.next = new ListNode((p1.val + carry)%10);
                carry = (p1.val + carry)/10;
                r = r.next;
                p1 = p1.next;
            }
            else if(p1 == null && p2 != null) {
                r.next = new ListNode((p2.val + carry)%10);
                carry = (p2.val + carry)/10;
                r = r.next;
                p2 = p2.next;
            }
            else {
                r.next = new ListNode((p1.val + p2.val + carry)%10);
                carry = (p1.val+p2.val + carry)/10;
                r = r.next;
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        if(carry > 0) {
            r.next = new ListNode(carry);
        }
        return res;
    }
}