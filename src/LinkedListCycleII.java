public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		ListNode meetNode = getMeetNode(head);
		if (meetNode == null) {
			return null;
		}
		return getEntranceNode(head, meetNode);
	}
	private ListNode getMeetNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return slow;
			}
		}
		return null;
	}
	private ListNode getEntranceNode(ListNode head, ListNode meetNode) {
		while (head != meetNode) {
			head = head.next;
			meetNode = meetNode.next;
		}
		return head;
	}
}
