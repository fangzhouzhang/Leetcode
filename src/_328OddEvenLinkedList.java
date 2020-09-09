public class _328OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) return head;
		ListNode odd = head;
		ListNode evenHead = head.next;
		ListNode even = head.next;

		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	public ListNode oddEvenListII(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) return head;
		ListNode dummy = new ListNode(0);
		ListNode evenHead = dummy;
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			ListNode nextOdd = cur.next.next;
			ListNode nextEven = cur.next;
			nextEven.next = null;
			evenHead.next = nextEven;
			cur.next = nextOdd;
			evenHead = evenHead.next;
			if (cur.next != null) cur = cur.next;
		}
		cur.next = dummy.next;
		return head;
	}
}
