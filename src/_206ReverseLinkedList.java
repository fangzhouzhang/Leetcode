public class _206ReverseLinkedList {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode tmp = head.next;
		ListNode newHead = reverseList(head.next);
		tmp.next = head;
		head.next = null;
		return newHead;
	}

	/**
	 * non-recursive
	 * time: o(n) space: o(1)
	 * @param head
	 * @return
	 */
	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
