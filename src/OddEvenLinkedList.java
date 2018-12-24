public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode odd = new ListNode(-1);
		ListNode oddTail = odd;

		ListNode even = new ListNode(-1);
		ListNode evenTail = even;

		ListNode cur = head;
		int count = 1;

		while (cur != null) {
			if (count % 2 == 1) {//odd
				oddTail.next = cur;
				oddTail = oddTail.next;
				cur = cur.next;
				oddTail.next = null;
			} else {
				evenTail.next = cur;
				evenTail = evenTail.next;
				cur = cur.next;
				evenTail.next = null;
			}
			count++;
		}
		oddTail.next = even.next;
		return odd.next;
	}
}
