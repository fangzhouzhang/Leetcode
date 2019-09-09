public class PlusOneLinkedList {
	public ListNode plusOne(ListNode head) {
		ListNode cur = head;
		ListNode right = null;
		while (cur != null) {
			if (cur.val != 9) {
				right = cur;
			}
			cur = cur.next;
		}
		if (right == null) {
			right = new ListNode(0);
			right.next = head;
			head = right;
		}
		right.val++;
		cur = right.next;
		while (cur != null) {
			cur.val = 0;
			cur = cur.next;
		}
		return head;
	}
}
