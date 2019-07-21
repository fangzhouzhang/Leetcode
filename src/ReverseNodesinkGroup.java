public class ReverseNodesinkGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		int cnt = 1;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode begin = dummy;
		while (head != null) {
			if (cnt % k == 0) {
				begin = reverse(begin, head.next);
				head = begin.next;
			} else {
				head = head.next;
			}
			cnt++;
		}
		return dummy.next;
	}
	private ListNode reverse(ListNode exStart, ListNode exEnd) {
		ListNode pre = exStart.next;
		ListNode cur = pre.next;
		while (cur != exEnd) {
			pre.next = cur.next;
			cur.next = exStart.next;
			exStart.next = cur;
			cur = pre.next;
		}
		return pre;
	}
}
