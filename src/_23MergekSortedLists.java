public class _23MergekSortedLists {
	/**
	 * k lists, n nodes
	 * time: o(logk * n) space:
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		return mergeLists(lists, 0, lists.length - 1);
	}

	private ListNode mergeLists(ListNode[] lists, int start, int end) {
		if (start >= end) return lists[start];
		int mid = start + (end - start) / 2;
		ListNode node1 = mergeLists(lists, start, mid);
		ListNode node2 = mergeLists(lists, mid + 1, end);
		return mergeTwo(node1, node2);
	}

	private ListNode mergeTwo(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (a != null && b != null) {
			if (a.val < b.val) {
				cur.next = a;
				cur = a;
				a = a.next;
			} else {
				cur.next = b;
				cur = b;
				b = b.next;
			}
		}

		while (a != null) {
			cur.next = a;
			cur = a;
			a = a.next;
		}

		while (b != null) {
			cur.next = b;
			cur = b;
			b = b.next;
		}

		return dummy.next;
	}
}
