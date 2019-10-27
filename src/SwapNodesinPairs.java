public class SwapNodesinPairs {
    /**
     * @param head: a ListNode
     * @return: a ListNode
     * time : o(n) space : o(n)
     */
    public ListNode swapPairs(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = swapPairs(next.next);
        head.next = newHead;
        next.next = head;
        return next;
    }

	public ListNode swapPairs1(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;

		while (head != null && head.next != null) {
			ListNode next = head.next.next;
			head.next.next = head;
			pre.next = head.next;
			head.next = next;

			pre = head;
			head = head.next;

		}
		return dummy.next;
	}
}
