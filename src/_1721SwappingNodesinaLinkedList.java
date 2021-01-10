public class _1721SwappingNodesinaLinkedList {
	public ListNode swapNodes(ListNode head, int k) {
		int cnt = 0, len = 0;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			len++;
		}
		cur = head;
		int v1 = -1, v2 = -1;
		ListNode t1 = null, t2 = null;
		while (cnt < k) {
			v1 = cur.val;
			t1 = cur;
			cur = cur.next;
			cnt++;
		}
		cnt = 0;
		cur = head;
		while (cnt < len + 1 - k){
			v2 = cur.val;
			t2 = cur;
			cur = cur.next;
			cnt++;
		}
		t1.val = v2;
		t2.val = v1;
		return head;
	}
}
