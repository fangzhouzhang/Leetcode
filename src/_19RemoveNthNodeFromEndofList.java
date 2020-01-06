public class _19RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;
		int k = 0;
		while (k++ < n + 1) fast = fast.next;
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
