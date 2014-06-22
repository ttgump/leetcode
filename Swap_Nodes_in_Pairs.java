/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/
/*
使用3个指针，一个指向当前node（node），一个指向之后一个node（nextNode），一个指向之前一个node（previousNode）。交换node和nextNode，再将previousNode指向nextNode。
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode previousNode = null;
        ListNode node = head;
        ListNode nextNode = node.next;
        head = nextNode;
        
        while(true) {
            node.next = nextNode.next;
            nextNode.next = node;
            if(previousNode != null) previousNode.next = nextNode;
            
            previousNode = node;
            node = node.next;
            if(node != null) {
                nextNode = node.next;
                if(nextNode == null) break;
            }
            else break;
        }
        return head;
    }
}