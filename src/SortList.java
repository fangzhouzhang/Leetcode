public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);
		return merge(l1, l2);
	}
	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
			cur.next = null;
		}
		if (l1 == null) {
			cur.next = l2;
		}
		if (l2 == null) {
			cur.next = l1;
		}
		return dummy.next;
	}
}
