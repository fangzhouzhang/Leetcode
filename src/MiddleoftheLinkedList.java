public class MiddleoftheLinkedList {
	/**
	 * time: o(n) space: o(1)
	 * @param head
	 * @return right middle point of linked list
	 */
	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
