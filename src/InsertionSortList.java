public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {//0 and 1 node in list
			return head;
		}
		//there are >= 2 nodes in list
		ListNode compare = head.next;
		ListNode compareNext = compare.next;
		if (compareNext == null) {// 2 nodes in list
			if (head.val < compare.val) {
				return head;
			} else {
				compare.next = head;
				head.next = null;
				return compare;
			}
		}
		//there are >= 3 nodes in list
		ListNode newHead = null;
		while (compare != null) {
			compareNext = compare.next;
			if (newHead == null) {
				newHead = insertInSortedList(head, compare, compareNext);
			} else {
				newHead = insertInSortedList(newHead, compare, compareNext);
			}
			compare = compareNext;
		}
		return newHead;
	}
	private ListNode insertInSortedList(ListNode head,
										ListNode compare,
										ListNode compareNext) {
		if (head.val > compare.val) {
			ListNode tail = getTail(head, compare);
			compare.next = head;
			tail.next = compareNext;
			return compare;
		}
		ListNode cur = head;
		ListNode pre = null;
		while (cur != compare) {
			if (cur.val > compare.val) {
				ListNode tail = getTail(head, compare);
				pre.next = compare;
				compare.next = cur;
				tail.next = compareNext;
				return head;
			} else if (cur.val <= compare.val) {
				pre = cur;
				cur = cur.next;
			}
		}
		return head;
	}
	private ListNode getTail(ListNode head,
							 ListNode compare) {
		ListNode cur = head;
		ListNode pre = null;
		while (cur != null && cur != compare) {
			pre = cur;
			cur = cur.next;
		}
		return pre;
	}
}
