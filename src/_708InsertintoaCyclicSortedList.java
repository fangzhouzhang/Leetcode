public class _708InsertintoaCyclicSortedList {
	public Node insert(Node head, int insertVal) {
		if (head == null) {
			Node node = new Node(insertVal);
			node.next = node;
			return node;
		}

		Node pre = head;
		Node next = head.next;
		boolean inserted = false;
		while (true) {
			if ((pre.val <= insertVal && insertVal <= next.val)
					|| (pre.val < insertVal && pre.val > next.val)
					|| (next.val > insertVal && pre.val > next.val)) {
				pre.next = new Node(insertVal, next);
				inserted = true;
				break;
			}
			pre = pre.next;
			next = next.next;
			if (pre == head) break;
		}
		if (!inserted) next.next = new Node(insertVal, pre);
		return head;
	}

	private class Node {
		public int val;
		public Node next;

		public Node() {}

		public Node(int _val,Node _next) {
			val = _val;
			next = _next;
		}
		public Node(int _val) {
			val = _val;
			next = null;
		}
	};
}
