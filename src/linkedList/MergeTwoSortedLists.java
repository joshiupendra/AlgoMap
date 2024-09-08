package linkedList;

/*
 * Merge Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. 
The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 */

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode last1 = new ListNode(4);
		ListNode middle1 = new ListNode(2, last1);
		ListNode list1 = new ListNode(1, middle1);
		
		ListNode last2 = new ListNode(4);
		ListNode middle2 = new ListNode(3, last2);
		ListNode list2 = new ListNode(1, middle2);
		
		ListNode node = mergeTwoLists(list1, list2);
		
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode();
        ListNode node = mergedList;
        
        while (list1 != null || list2 != null) {
        	if (list1 != null && list2 != null) {
        		if (list1.val < list2.val) {
        			node.next = list1;
        			node = list1;
        			list1 = list1.next;
        		} else {
        			node.next = list2;
        			node = list2;
        			list2 = list2.next;
        		}
        	} else if (list1 == null && list2 != null) {
        		node.next = list2;
        		node = list2;
        		list2 = list2.next;
        	} else if (list1 != null && list2 == null) {
        		node.next = list1;
        		node = list1;
        		list1 = list1.next;
        	}
        	
        	System.out.println(node.val);
        }
		
		return mergedList.next;
    }
}
