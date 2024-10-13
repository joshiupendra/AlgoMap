package heaps;

import java.security.cert.PKIXRevocationChecker;
import java.util.PriorityQueue;

/*
 * Merge k Sorted Lists
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []
 */

public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode l3 = new ListNode(-1);
		ListNode l2 = new ListNode(-1, l3);
		ListNode l1 = new ListNode(-1, l2);
		ListNode l = new ListNode(-2, l1);
		//ListNode t2 = new ListNode(3, t3);
		//ListNode t1 = new ListNode(1, t2);
		ListNode[] lists = {l, null};
		ListNode result = mergeKLists(lists);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        
        for (int i=0; i<lists.length; i++) {
        	ListNode temp = lists[i];
        	while (temp != null) {
        		minHeap.add(temp);
        		temp = temp.next;
        	}
        }

        ListNode temp;
        ListNode prev = null;
        int n = minHeap.size();
        System.out.println(n);
        
        for (int i=0; i<n; i++) {
        	temp = minHeap.poll();
        	if (i == 0) {
        		head = temp;
        		prev = temp;
        	} else if (i == n-1) {
        		prev.next = temp;
        		prev = temp;
        		prev.next = null;
        	} else {
        		prev.next = temp;
        		prev = temp;
        	}
        }
        
        return head;
    }
}

class ListNode {
	int val;
	ListNode next;
	
	ListNode() {}
	
	ListNode(int val) { 
		this.val = val; 
	}
	
	ListNode(int val, ListNode next) { 
		this.val = val; this.next = next; 
	}

}
