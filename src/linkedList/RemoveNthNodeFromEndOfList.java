package linkedList;

/*
 * Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
 */

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		ListNode last = new ListNode(5);
		ListNode m3 = new ListNode(4, last);
		ListNode m2 = new ListNode(3, m3);
		ListNode m1 = new ListNode(2, m2);
		ListNode head = new ListNode(1, m1);

		ListNode node = removeNthFromEnd(head, 1);
		
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode ahead = dummy;
        ListNode behind = dummy;
        
        while (n >= 0) {
        	ahead = ahead.next;
        	n--;
        }
        
        while (behind != null) {
        	if (ahead == null) {
        		behind.next = behind.next.next;
        		break;
        	}
        	ahead = ahead.next;
        	behind = behind.next;
        }
		
		return dummy.next;
    }
}
