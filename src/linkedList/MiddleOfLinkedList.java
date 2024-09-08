package linkedList;

/*
 * Middle of the Linked List
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 */

public class MiddleOfLinkedList {

	public static void main(String[] args) {
		ListNode last = new ListNode(6);
		ListNode m4 = new ListNode(5, last);
		ListNode m3 = new ListNode(4, m4);
		ListNode m2 = new ListNode(3, m3);
		ListNode m1 = new ListNode(2, m2);
		ListNode head = new ListNode(1, m1);
		
		ListNode node = middleNode(head);
		
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode middleNode(ListNode head) {
		ListNode slowPointer = head;
        ListNode fastPointer = head;
        
        while (slowPointer != null && fastPointer != null) {
        	if (fastPointer.next == null) {
        		return slowPointer;
        	}
        	if (slowPointer.next != null && fastPointer.next != null) {
        		slowPointer = slowPointer.next;
        		fastPointer = fastPointer.next.next;
        	}
        }
		
        return slowPointer;
    }
}
