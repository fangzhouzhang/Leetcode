public class PartitionList {
    /**
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     * time : o(n) space : o(1)
     */
	public ListNode partition(ListNode head, int x) {
		ListNode small = new ListNode(-1);
		ListNode smallTail = small;

		ListNode big = new ListNode(-1);
		ListNode bigTail = big;

		ListNode cur = head;
		while (cur != null) {
			if (cur.val < x) {
				smallTail.next = cur;
				smallTail = smallTail.next;
				cur = cur.next;
				smallTail.next = null;
			} else {//cur.val >= x
				bigTail.next = cur;
				bigTail = bigTail.next;
				cur = cur.next;
				bigTail.next = null;
			}
		}
		smallTail.next = big.next;
		return small.next;
	}
}
