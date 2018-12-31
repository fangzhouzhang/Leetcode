public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;

		int len = getLength(head);
		k = k % len;
		if (k == 0) {
			return head;
		}
		int target = len - k;
		int cnt = 0;
		ListNode cur = head;
		ListNode pre = null;
		while (cnt < target) {
			pre = cur;
			cur = cur.next;
			cnt++;
		}

		ListNode newHead = cur;

		ListNode tail = getTail(newHead);
		pre.next = null;
		tail.next = head;
		return newHead;
	}
	private int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			head = head.next;
			length++;
		}
		return length;
	}
	private ListNode getTail(ListNode head) {
		ListNode temp = null;
		while (head != null) {
			temp = head;
			head = head.next;
		}
		return temp;
	}
}
