public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode pre = null;
		ListNode cur = head;
		ListNode temp = null;
		while (cur != null) {
			if (cur.val == val) {
				temp = cur.next;
				head = remove(head, pre, cur);
				cur = temp;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return head;
	}
	private ListNode remove(ListNode head,
							ListNode pre,
							ListNode cur) {
		if (pre == null) {//cur is head node
			head = head.next;
			cur.next = null;
			return head;
		} else {
			pre.next = cur.next;
			cur.next = null;
			return head;

		}
	}
}
