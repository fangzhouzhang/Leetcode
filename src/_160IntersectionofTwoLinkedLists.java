public class _160IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		ListNode tailA = null;
		ListNode cur = headA;
		int lenA = 0;
		while (cur != null) {
			lenA++;
			tailA = cur;
			cur = cur.next;
		}
		cur = headB;
		ListNode tailB = null;
		int lenB = 0;
		while (cur != null) {
			lenB++;
			tailB = cur;
			cur = cur.next;
		}
		if (tailA != tailB) return null;
		if (lenA == lenB) {
			while (headA != headB) {
				headA = headA.next;
				headB = headB.next;
			}
			return headA;
		} else if (lenA > lenB) {
			while (lenA != lenB) {
				headA = headA.next;
				lenA--;
			}
			while (headA != headB) {
				headA = headA.next;
				headB = headB.next;
			}
			return headA;
		} else {
			while (lenA != lenB) {
				headB = headB.next;
				lenB--;
			}
			while (headA != headB) {
				headA = headA.next;
				headB = headB.next;
			}
			return headA;
		}
	}
}
