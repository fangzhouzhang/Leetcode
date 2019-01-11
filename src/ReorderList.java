public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode mid = getMid(head);
		ListNode midNext = mid.next;
		mid.next = null;
		ListNode newHead = reverse(midNext);
		mergeList(head, newHead);

	}
	private ListNode getMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null &&
				fast.next != null &&
				fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	private ListNode reverse(ListNode midNext) {
		if (midNext == null || midNext.next == null) {
			return midNext;
		}
		ListNode head = reverse(midNext.next);
		midNext.next.next = midNext;
		midNext.next = null;
		return head;
	}
	// private ListNode dfs(ListNode midNext) {
	private void mergeList(ListNode head, ListNode newHead) {
		ListNode cur1 = head;
		ListNode cur2 = newHead;
		int cnt = 0;
		while (cur1 != null && cur2 != null) {
			if (cnt % 2 == 0) {
				ListNode temp = cur1.next;
				cur1.next = cur2;
				cur1 = temp;
			} else {
				ListNode temp = cur2.next;
				cur2.next = cur1;
				cur2 = temp;
			}
			cnt++;
		}
	}
}
