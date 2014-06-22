/*
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
		ListNode sortList = new ListNode(head.val);
		for(ListNode i = head.next; i != null; i = i.next){
			if(i.val < sortList.val){
				ListNode temp = new ListNode(i.val);
				temp.next = sortList;
				sortList = temp;
			}
			else {
				if(sortList.next == null) {
					sortList.next = new ListNode(i.val);
				}
				else {
					// sortHead1 store the position before i should insert
					ListNode sortHead1= sortList;
					// sortHead2 store the position after i should insert
					ListNode sortHead2 = sortList.next;
					while(i.val > sortHead2.val){
						sortHead1 = sortHead1.next;
						sortHead2 = sortHead2.next;
						if(sortHead2 == null) break;
					}
					ListNode temp = new ListNode(i.val);
					sortHead1.next = temp;
					temp.next = sortHead2;
				}
			}
		}
		return sortList;
    }
}