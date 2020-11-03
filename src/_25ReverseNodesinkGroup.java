public class _25ReverseNodesinkGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode a = null, b = null;
		for (ListNode cur = dummy; cur.next != null && cur.next.next != null;) {
			a = cur.next;
			b = a.next;
			ListNode fast = cur;
			for (int i = 0; i < k && fast != null; i++) {
				fast = fast.next;
			}
			if (fast == null) break;
			for (int i = 0; i < k - 1 && b != null; i++) {
				ListNode tmp = b.next;
				b.next = a;
				a = b;
				b = tmp;
			}
			ListNode tmp = cur.next;
			cur.next = a;
			tmp.next = b;
			cur = tmp;
		}
		return dummy.next;
	}
}
