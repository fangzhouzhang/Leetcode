public class _24SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		for (ListNode cur = dummy, a = cur.next, b = a.next; cur.next != null && cur.next.next != null;) {
			a = cur.next;
			b = a.next;
			cur.next = b;
			a.next = b.next;
			b.next = a;
			cur = a;
		}
		return dummy.next;
	}
}
