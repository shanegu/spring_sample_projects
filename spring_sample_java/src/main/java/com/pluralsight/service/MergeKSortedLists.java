package com.pluralsight.service;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
	private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
		public int compare(ListNode left, ListNode right) {
			return left.val - right.val;
		}
	};

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		
		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
		
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				heap.offer(lists.get(i));
			}
		}
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		
		while (!heap.isEmpty()) {			
			ListNode current = heap.poll();
			if (current.next != null) {
				heap.offer(current.next);
			}
			head.next = current;
			head = current;
		}
		
		return dummy.next;
	}
}
