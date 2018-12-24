public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n) {
			return head;
		}

		ListNode cur = head;

		ListNode preM = null;
		ListNode curM = null;
		ListNode preN = null;
		ListNode curN = null;
		int count = 1;

		while (cur != null && curN == null) {
			if (count == m) {
				curM = cur;
			}
			if (count == n) {
				curN = cur;
			}
			if (curM == null) {
				preM = cur;
			}
			if (curN == null) {
				preN = cur;
			}
			cur = cur.next;
			count++;
		}
		ListNode temp = curN.next;
		ListNode newHead = reverse(curM,curN);
		if (preM != null) {
			preM.next = curN;
			curM.next = temp;
			return head;
		} else if (preM == null) {
			curM.next = temp;
			return curN;
		}
		return null;
	}
	private ListNode reverse(ListNode curM, ListNode curN) {
		if (curM == curN) {
			return curN;
		}
		ListNode nextNode = curM.next;
		ListNode newHead = reverse(nextNode, curN);
		nextNode.next = curM;
		curM.next = null;
		return newHead;
	}
}
