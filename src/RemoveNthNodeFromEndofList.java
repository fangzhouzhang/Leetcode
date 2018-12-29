public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode fast = dummy;
		ListNode slow = dummy;

		int cnt = 0;

		while (fast != null && cnt < n + 1) {
			fast = fast.next;
			cnt++;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		ListNode del = slow.next;
		slow.next = del.next;
		del.next = null;

		return dummy.next;
	}
}
