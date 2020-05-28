public class _203RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (null == head) return null;
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val == val) {
				ListNode next = cur.next;
				cur.next = null;
				cur = next;
			} else {
				pre.next = cur;
				pre = cur;
				cur = cur.next;
				pre.next = null;
			}
		}
		return dummy.next;
	}
}
