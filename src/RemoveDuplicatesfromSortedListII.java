public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;

		while (cur != null) {
			if ((cur.next != null && cur.val != cur.next.val) ||
					cur.next == null) {
				pre.next = cur;
				pre = cur;
				cur = cur.next;
			} else if (cur.next != null && cur.val == cur.next.val) {
				cur = getNextValidNode(cur);
				if (cur == null) {
					pre.next = cur;
				}
			}
		}
		return dummy.next;
	}
	private ListNode getNextValidNode(ListNode cur) {
		while (cur != null && cur.next != null && cur.val == cur.next.val) {
			int delVal = cur.val;
			while (cur != null && cur.val == delVal) {
				cur = cur.next;
			}
		}
		return cur;
	}
}
