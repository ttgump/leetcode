/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/

/*
使用一个hashmap存储每一个node的编号（index）
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> hm = new HashMap<Integer, ListNode>();
        ListNode node = head;
        int index = 0;
        while(node != null) {
            hm.put(index, node);
            node = node.next;
            index++;
        }
        if(n == index) {return head.next;}
        else if(n == 1 && index == 1) return null;
        else if(n == 1 && index > 1) {
            ListNode node1 = hm.get(index-n-1);
            node1.next = null;
            return head;
        }
        else {
            ListNode node1 = hm.get(index-n-1);
            ListNode node2 = hm.get(index-n+1);
            node1.next = node2;
            return head;
        }
    }
}