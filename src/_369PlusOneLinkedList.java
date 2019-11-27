public class _369PlusOneLinkedList {
	public ListNode plusOne(ListNode head) {
		if (head == null) return null;
		ListNode cur = head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode lastNotNine = dummy;
		while (cur != null) {
			if (cur.val != 9) lastNotNine = cur;
			cur = cur.next;
		}
		lastNotNine.val += 1;
		cur = lastNotNine.next;
		while (cur != null) {
			cur.val = 0;
			cur = cur.next;
		}
		return dummy.val == 1 ? dummy : dummy.next;
	}
}
