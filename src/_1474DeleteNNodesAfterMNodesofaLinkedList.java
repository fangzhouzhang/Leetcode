public class _1474DeleteNNodesAfterMNodesofaLinkedList {
	public ListNode deleteNodes(ListNode head, int m, int n) {
		if (head == null || n == 0) return head;
		if (m == 0) return null;
		ListNode pre = new ListNode(0), cur = head;
		int idx = 0, len = m + n;
		while (cur != null) {
			if ((idx % len) >= m && (idx % len) < len) {
				cur = cur.next;
			} else {
				pre.next = cur;
				pre = cur;
				cur = cur.next;
				pre.next = null;
			}
			idx++;
		}
		return head;
	}
}
