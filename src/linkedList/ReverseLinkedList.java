package linkedList;

/*
 * Reverse Linked List
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []
 */

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode last = new ListNode(5);
		ListNode middle3 = new ListNode(4, last);
		ListNode middle2 = new ListNode(3, middle3);
		ListNode middle1 = new ListNode(2, middle2);
		ListNode head = new ListNode(1, middle1);
		
		ListNode node = reverseList(head);
		
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}

	}

	public static ListNode reverseList(ListNode head) {
		ListNode curNode = head;
		ListNode prev = null;
		ListNode next = null;
		
		while (curNode != null) {
			
			if (curNode.next != null) {
				next = curNode.next;
			} else {
				curNode.next = prev;
				return curNode;
			}
			if (prev != null) {
				curNode.next = prev;
			} else {
				curNode.next = null;
			}
			prev = curNode;
			curNode = next;
		}
		
		return head;
    }
}

/*
 * class ListNode { int val; ListNode next;
 * 
 * ListNode() { }
 * 
 * ListNode(int val) { this.val = val; }
 * 
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
 */