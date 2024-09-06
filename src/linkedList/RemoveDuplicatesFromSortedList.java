package linkedList;

/*
 * Remove Duplicates From Sorted List
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 
Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]
 */

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		ListNode last = new ListNode(2);
		ListNode middle = new ListNode(1, last);
		ListNode head = new ListNode(1, middle);
		
		ListNode node = deleteDuplicates(head);
		
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode node = head;
		
		while (node != null) {
			if (node.next != null && node.val == node.next.val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}

		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}