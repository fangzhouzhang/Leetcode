public class _237DeleteNodeinaLinkedList {
	public void deleteNode(ListNode node) {
		ListNode n = node.next;
		while (n != null) {
			node.val = n.val;
			if (n.next == null) {
				node.next = null;
			}
			node = n;
			n = n.next;
		}
	}
}
