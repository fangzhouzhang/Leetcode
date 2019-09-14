public class FlattenaMultilevelDoublyLinkedList {
	public Node flatten(Node head) {
		if( head == null) return head;
		Node cur = head;
		while (cur != null) {
			if (cur.child == null) {
				cur = cur.next;
				continue;
			}
			Node next = cur.next;
			Node child = cur.child;
			//get tail of children
			while (child.next != null) {
				child = child.next;
			}
			child.next = next;
			if (next != null) {
				next.prev = child;
			}
			cur.next = cur.child;
			cur.child.prev = cur;
			cur.child = null;
		}
		return head;
	}

	private class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;

		public Node() {}

		public Node(int _val,Node _prev,Node _next,Node _child) {
			val = _val;
			prev = _prev;
			next = _next;
			child = _child;
		}
	};
}
