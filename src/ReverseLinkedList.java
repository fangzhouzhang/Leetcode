public class ReverseLinkedList {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

	/**
	 * non-recursive
	 * time: o(n) space: o(1)
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		ListNode next = head.next;
		head.next = null;
		while (next != null) {
			ListNode temp = next.next;
			next.next = cur;
			cur = next;
			next = temp;
		}
		return cur;
	}
}
