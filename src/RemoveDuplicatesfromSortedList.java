public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode pre = head;
		ListNode cur = head.next;

		while (cur != null) {
			if (pre.val == cur.val) {
				pre.next = cur.next;
				cur.next = null;
				cur = pre.next;
			} else {//pre.val != cur.val
				pre = cur;
				cur = cur.next;
			}
		}
		return head;
	}
}
