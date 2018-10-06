public class MergekSortedLists {
	/**
	 * k lists, n nodes
	 * time: o(logk * n) space:
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		return helper(lists, 0, lists.length - 1);
	}
	private ListNode helper(ListNode[] lists, int start, int end) {
		if (start >= end) {
			return lists[start];
		}
		int mid = start + (end - start) / 2;
		ListNode left = helper(lists, start, mid);//head of list
		ListNode right = helper(lists, mid + 1, end);// head of list
		return merge(left, right);
	}
	private ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		while (l1 != null) {
			cur.next = l1;
			l1 = l1.next;
			cur = cur.next;
		}
		while (l2 != null) {
			cur.next = l2;
			l2 = l2.next;
			cur = cur.next;
		}
		return dummy.next;
	}
}
