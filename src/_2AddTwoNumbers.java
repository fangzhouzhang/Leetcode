public class _2AddTwoNumbers {
	/**
	 * nodes of l1 is n, nodes of l2 is m
	 * time: o(m + n) space: o(1)
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		int addition = 0;
		while (l1 != null && l2 != null) {
			ListNode node = null;
			if (l1.val + l2.val + addition < 10) {
				node = new ListNode(l1.val + l2.val + addition);
				addition = 0;

			} else {
				int val = (l1.val + l2.val + addition) % 10;
				node = new ListNode(val);
				addition = 1;
			}
			cur.next = node;
			cur = cur.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			ListNode node = null;
			if (l1.val + addition < 10) {
				node = new ListNode(l1.val + addition);
				addition = 0;

			} else {
				int val = (l1.val + addition) % 10;
				node = new ListNode(val);
				addition = 1;
			}
			cur.next = node;
			cur = cur.next;
			l1 = l1.next;

		}
		while (l2 != null) {
			ListNode node = null;
			if (l2.val + addition < 10) {
				node = new ListNode(l2.val + addition);
				addition = 0;

			} else {
				int val = (l2.val + addition) % 10;
				node = new ListNode(val);
				addition = 1;
			}
			cur.next = node;
			cur = cur.next;
			l2 = l2.next;
		}
		if (addition == 1) {
			ListNode node = new ListNode(addition);
			cur.next = node;
			cur = cur.next;
		}
		return dummy.next;
	}
}
